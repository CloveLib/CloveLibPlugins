/*
 * Copyright (c) 2025 Clove Twilight
 * Licensed under the MIT Licence
 */

package win.clovelib.estrocord.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import win.clovelib.estrocord.EstroMain;

public class RecipesCommandExecutor implements CommandExecutor {

    private static final String RECIPES_URL = "https://www.clovelib.win/crafts/estrocord";
    private final EstroMain plugin;

    public RecipesCommandExecutor(EstroMain plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Create clickable message
            TextComponent message = new TextComponent(ChatColor.LIGHT_PURPLE + "Click here to view all spawn egg recipes: ");
            TextComponent link = new TextComponent(ChatColor.AQUA + "" + ChatColor.UNDERLINE + RECIPES_URL);
            link.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, RECIPES_URL));
            message.addExtra(link);

            player.spigot().sendMessage(message);
        } else {
            // Console output
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "View all spawn egg recipes at: " + ChatColor.AQUA + RECIPES_URL);
        }

        return true;
    }
}