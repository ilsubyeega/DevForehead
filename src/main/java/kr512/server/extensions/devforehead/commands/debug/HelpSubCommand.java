package kr512.server.extensions.devforehead.commands.debug;

import kr512.server.extensions.devforehead.designs.StaticPalatte;
import net.minestom.server.chat.*;
import net.minestom.server.command.CommandSender;
import net.minestom.server.command.builder.Arguments;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class HelpSubCommand {
    public static boolean initialized = false;
    public static ArrayList<SubCommandInfo> subcommandinfostoarge = new ArrayList<>();

    public static void init() {
        if (initialized) return;
        subcommandinfostoarge.add(new SubCommandInfo("help", "Shows a command list and description.", null));
        initialized = true;
    }

    public static void help(CommandSender sender, Arguments args) {
        init();
        sender.sendMessage(ChatColor.RESET.toString());
        sender.sendMessage(StaticPalatte.primary + "=>  DevForehead");
        sender.sendMessage(StaticPalatte.primary + "  Developed by ilsubyeega with <3");
        sender.sendMessage(ChatColor.RESET.toString());
        if (sender.isPlayer()) {
            Player player = sender.asPlayer();
            subcommandinfostoarge.forEach(e -> {
                RichMessage richmessage = RichMessage.of(
                        ColoredText.of(StaticPalatte.info, "/debug " + e.name + (e.usage != null ? " " + e.usage : ""))
                                .append(ChatColor.WHITE, ": " + e.description)
                ).setHoverEvent(ChatHoverEvent.showText(ColoredText.of(StaticPalatte.info, "Click to suggest this command.")))
                        .setClickEvent(ChatClickEvent.suggestCommand("/debug help"));
                player.sendMessage(richmessage);
            });
        } else if (sender.isConsole()) {
            subcommandinfostoarge.forEach(e ->
                    sender.sendMessage(String.format("/debhug %s : %s", "/" + e.name + (e.usage != null ? " " + e.usage : ""), e.description)));
        }
    }

}

class SubCommandInfo {
    String name;
    String description;
    @Nullable
    String usage;

    SubCommandInfo(@NotNull String name, @NotNull String description, @Nullable String usage) {
        this.name = name;
        this.description = description;
        this.usage = usage;
    }
    /*String toString() {
        return "/"+name + " " + (usage != null ? usage : "") + " " + (description != null ? description : "");
    }*/
}