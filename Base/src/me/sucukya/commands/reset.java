//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.commands;

import me.sucukya.Main;
import me.sucukya.utility.Data;
import me.sucukya.utility.Files;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class reset implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender cms, Command cmd, String arg, String[] args) {
        Player p = (Player)cms;
        if(p.hasPermission("hpsbr.reset")) {
            if(args.length == 1) {
                String target = args[0];
                Player player = Bukkit.getPlayer(target);
                if(Main.isOnline.contains(player)) {
                    Files.alreadyJoinedConf.set(player.getUniqueId().toString(), null);
                    player.kickPlayer(Data.prefix + "§c YOU HAVE BEEN RESET DUE TO CHEATING / OTHER!");
                    try {
                        Files.alreadyJoinedConf.save(Files.alreadyJoined);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    p.sendMessage(Data.prefix + "§cThat player isn't online!");
                }


            } else {
                p.sendMessage(Data.prefix + "§cNot enough Arguments: /reset <Player>");
            }
        }


        return true;
    }
}
