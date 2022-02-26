//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.islands.commands;

import me.sucukya.islands.utils.mapUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class test implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player)commandSender;
        String profile = mapUtils.getSelectedProfile(p);
        Location loc = p.getLocation();
        p.sendMessage("map_" + p.getUniqueId() + "_" + profile);
        loc.setWorld(Bukkit.getWorld("map_" + p.getUniqueId() + "_" + profile));
        p.sendMessage(loc.getWorld().toString());


        return true;
    }
}
