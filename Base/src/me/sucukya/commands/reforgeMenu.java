package me.sucukya.commands;

import me.sucukya.reforge.openReforge;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reforgeMenu implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            if(commandSender.hasPermission("HPSBR.reforgemenu")) {
                openReforge.open((Player) commandSender);
            }
        }
        return true;
    }
}
