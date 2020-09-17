package kr512.server.extensions.devforehead;

import kr512.server.extensions.devforehead.commands.debug.DebugCommand;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandManager;
import net.minestom.server.extensions.Extension;

/**
 * Main class of DevForehead. this class will be loaded on Minestom.
 */
public class DevForehead extends Extension {


    @Override
    public void initialize() {
        CommandManager commandManager = MinecraftServer.getCommandManager();
        commandManager.register(new DebugCommand());
        getLogger().info("%sEnabled DevForehead " + getDescription().getVersion());
    }

    @Override
    public void terminate() {
        getLogger().info("Terminated DevForehead.");
    }
}