<img src="https://raw.githubusercontent.com/Zensonaton/MinecraftClientGobrrr/main/src/main/resources/assets/minecraftclientgobrrr/icon.png" align="right" width=200>

# Minecraft Client go brrr

**Fabric/Quilt mod that forces Minecraft to create game window much earlier**.
Lets say that you are playing on a huge modpack like AOF; The thing is that you need to wait several minutes to see game window. This mod changes that, forcing Minecraft to create a game window a lot earlier. Although that window cannot be interacted with, it is still a great indicator that the game is actually loading.

## Compatibility

That mod was tested with AOF6, and there wasn't any issues, however, there *are* incompatible mods:

* [Bobby](https://modrinth.com/mod/bobby), [Farsight](https://www.curseforge.com/minecraft/mc-mods/farsight-fabric/files). See [issue #6](https://github.com/Zensonaton/MinecraftClientGobrrr/issues/6).

There may be other incompatabilities or issues that I may not be aware of. Please report those in the [issues section](https://github.com/Zensonaton/MinecraftClientGobrrr/issues).

### Does this speed up game loading?

No, its not. Like, at all.

This mod simply creates a game window a little earlier to tell us, *humons*, that the game is loading. There is nothing that this mod does.

### Can I use this mod in modpacks?

Yes, without permission.

### Plans

* Support other Minecraft versions.
* ~~Move `MinecraftClient` class initialization in separate thread, solving the 'Minecraft not responding' issue on game loading~~. (too hard to accomplish)

### Downloads

* [Modrinth](https://modrinth.com/mod/minecraftclientgobrrr).
* [Curseforge](https://curseforge.com/minecraft/mc-mods/minecraft-client-go-brrr).

### License

This project is licensed under the `MIT` license.
