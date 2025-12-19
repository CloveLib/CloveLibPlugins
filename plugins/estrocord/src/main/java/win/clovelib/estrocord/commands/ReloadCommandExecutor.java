/*
 * Copyright (c) 2025 Clove Twilight
 * Licensed under the MIT Licence
 */

package win.clovelib.estrocord.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import win.clovelib.estrocord.EstroMain;

public class ReloadCommandExecutor implements CommandExecutor {

    private final EstroMain plugin;

    public ReloadCommandExecutor(EstroMain plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("estrocord.reload")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to reload the plugin!");
            return true;
        }

        sender.sendMessage(ChatColor.YELLOW + "Reloading configuration...");

        try {
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "Configuration reloaded successfully!");
        } catch (Exception e) {
            sender.sendMessage(ChatColor.RED + "An error occurred while reloading the configuration.");
            plugin.getLogger().severe("Failed to reload configuration: " + e.getMessage());
            e.printStackTrace();
        }

        return true;
    }
}
