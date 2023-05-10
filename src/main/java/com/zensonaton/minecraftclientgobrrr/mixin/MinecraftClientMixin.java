package com.zensonaton.minecraftclientgobrrr.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import net.minecraft.client.WindowSettings;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.util.Window;
import net.minecraft.client.util.WindowProvider;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.zensonaton.minecraftclientgobrrr.MinecraftClientGobrrr;

import java.io.File;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
	@Final public File gameDirectory;
	@Shadow protected abstract String getWindowTitle();
	@Shadow public abstract void onWindowFocusChanged(boolean bl);

	private Window minecraftclientgobrr$createdWindow;

	@Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/RunArgs$Directories;getAssetDir()Ljava/nio/file/Path;"))
	private void createGameWindowEarly(RunArgs runArgs, CallbackInfo ci) {
		MinecraftClientGobrrr.LOGGER.info("Doing some wacky game window magic! He-he.");

		RenderSystem.initBackendSystem();
		WindowProvider windowProvider = new WindowProvider((MinecraftClient) (Object) this);
		GameOptions options = new GameOptions((MinecraftClient) (Object) this, gameDirectory);
		WindowSettings windowSettings = options.overrideHeight > 0 && options.overrideWidth > 0 ? new WindowSettings(options.overrideWidth, options.overrideHeight, runArgs.windowSettings.fullscreenWidth, runArgs.windowSettings.fullscreenHeight, runArgs.windowSettings.fullscreen) : runArgs.windowSettings;

		// We can't use localized strings because game resources aren't loaded at this point.
		// This is the reason why we are using "loading" as hardcoded string here.
		minecraftclientgobrr$createdWindow = windowProvider.createWindow(
			windowSettings,
			options.fullscreenResolution,
			getWindowTitle() + " - loading..."
		);
		onWindowFocusChanged(true);
	}

	@Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/WindowProvider;createWindow(Lnet/minecraft/client/WindowSettings;Ljava/lang/String;Ljava/lang/String;)Lnet/minecraft/client/util/Window;"))
	private Window useEarlyGameWindow(WindowProvider instance, WindowSettings windowSettings, String string, String string2) {
		MinecraftClientGobrrr.LOGGER.info("Replacing 'real' window with 'fake' one.");

		return minecraftclientgobrr$createdWindow;
	}
}
