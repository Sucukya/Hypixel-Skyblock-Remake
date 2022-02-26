package me.sucukya.utility;

import me.sucukya.listeners.petsMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class petsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            petsMenu.openMenu((Player) commandSender);
        }else {
            System.out.println("This command can only be used by a Player!");
        }
        return true;
    }
}
