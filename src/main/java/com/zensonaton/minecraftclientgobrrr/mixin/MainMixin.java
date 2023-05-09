package com.zensonaton.minecraftclientgobrrr.mixin;

import com.zensonaton.minecraftclientgobrrr.MinecraftClientGobrrr;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import net.minecraft.client.main.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Main.class)
public class MainMixin {
	// I don't like Mixins.
	//	@ModifyVariable(method = "main([Ljava/lang/String;Z)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;<init>(Lnet/minecraft/client/RunArgs;)V", shift = At.Shift.AFTER), print = true, argsOnly = true)
	//	private static void moveMinecraftClientInitToSeparateThread() {
	//
	//	}
}
