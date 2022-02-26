//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.commands;

import me.sucukya.Main;
import me.sucukya.utility.Data;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class build implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cms, Command cmd, String s, String[] strings) {
        Player p = (Player) cms;
        if(p.hasPermission("bpsbr.build")) {
            if(Main.buildMode.contains(p)) {
                Main.buildMode.remove(p);
                p.sendMessage(Data.prefix + "§aYou just §c§ldeactivated §aBuildmode");
            } else {
                Main.buildMode.add(p);
                p.sendMessage(Data.prefix + "§aYou just §2§lactivated §aBuildmode");
            }
        }

        return true;
    }
}
