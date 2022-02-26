package me.sucukya.commands;

import me.sucukya.utility.Data;
import me.sucukya.utility.Files;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class refresh implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cms, Command cmd, String arg, String[] args) {
        //Check if Player has Permission to execute Command
        if (cms.hasPermission("hpsbr.refresh")) {
            //Executing File Refresh
            Files.refresh();
            Data.refresh();
            //Send Message
            cms.sendMessage(Data.prefix + "§aFiles refreshed!");
        }
        return true;
    }
}