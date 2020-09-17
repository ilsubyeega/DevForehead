package kr512.server.extensions.devforehead.commands.debug;

import kr512.server.extensions.devforehead.designs.StaticPalatte;
import net.minestom.server.command.CommandSender;
import net.minestom.server.command.builder.Arguments;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.Argument;
import net.minestom.server.command.builder.arguments.ArgumentType;

public class DebugCommand extends Command {
    public DebugCommand(){
        super("debug", "dg");

        setDefaultExecutor(this::defaultExecutor);

        // /debug help
        Argument helpArg = ArgumentType.Word("mode").from("help");
        addSyntax(HelpSubCommand::help, helpArg);
    }
    private void defaultExecutor(CommandSender sender, Arguments args){
        sender.sendMessage(StaticPalatte.info + "Correct Usage: /debug help");
    }


}
