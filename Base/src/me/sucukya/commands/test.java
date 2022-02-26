//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.commands;

import me.sucukya.location.CheckLocation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class test implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        CheckLocation.check((Player) commandSender);
        String test = strings[0];
        commandSender.sendMessage(CheckLocation.locMap.get(commandSender));
        commandSender.sendMessage(test);
        return true;
    }
}
