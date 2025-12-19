package win.clovelib.cpc.commands;

import win.clovelib.cpc.CpcMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

import java.util.UUID;

public class SystemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        UUID playerUUID = player.getUniqueId();

        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /system <create|rename|remove> [name]");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "create":
                if (args.length < 2) {
                    sender.sendMessage(ChatColor.RED + "Usage: /system create <name>");
                    return true;
                }
                createSystem(playerUUID, args[1], sender);
                break;

            case "rename":
                if (args.length < 2) {
                    sender.sendMessage(ChatColor.RED + "Usage: /system rename <newName>");
                    return true;
                }
                renameSystem(playerUUID, args[1], sender);
                break;

            case "remove":
                removeSystem(playerUUID, sender);
                break;

            default:
                sender.sendMessage(ChatColor.RED + "Unknown subcommand. Use /system <create|rename|remove> [name]");
                break;
        }
        return true;
    }

    private void createSystem(UUID uuid, String name, CommandSender sender) {
        if (CpcMain.systemDataMap.containsKey(uuid)) {
            sender.sendMessage(ChatColor.RED + "You already have a system!");
            return;
        }

        CpcMain.SystemData newSystem = new CpcMain.SystemData(name);
        CpcMain.systemDataMap.put(uuid, newSystem);
        CpcMain.saveSystem(uuid);
        sender.sendMessage(ChatColor.GREEN + "System '" + name + "' created!");
    }

    private void renameSystem(UUID uuid, String newName, CommandSender sender) {
        if (!CpcMain.systemDataMap.containsKey(uuid)) {
            sender.sendMessage(ChatColor.RED + "You do not have a system!");
            return;
        }

        CpcMain.systemDataMap.get(uuid).systemName = newName;
        CpcMain.saveSystem(uuid);
        sender.sendMessage(ChatColor.GREEN + "System renamed to '" + newName + "'!");
    }

    private void removeSystem(UUID uuid, CommandSender sender) {
        if (!CpcMain.systemDataMap.containsKey(uuid)) {
            sender.sendMessage(ChatColor.RED + "You do not have a system to remove!");
            return;
        }

        CpcMain.systemDataMap.remove(uuid);
        CpcMain.saveSystem(uuid);
        sender.sendMessage(ChatColor.GREEN + "Your system has been removed!");
    }
}