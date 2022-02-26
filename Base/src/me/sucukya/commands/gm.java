//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.commands;

import me.sucukya.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gm implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cms, Command cmd, String arg, String[] args) {
        Player p = (Player)cms;
        if(args.length == 1) {
            String mode = args[0];

            if(mode.equalsIgnoreCase("1") || mode.equalsIgnoreCase("c")) {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage("Set own game mode to Creative Mode");
            }
            if(mode.equalsIgnoreCase("2") || mode.equalsIgnoreCase("a")) {
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage("Set own game mode to Adventure Mode");
            }
            if(mode.equalsIgnoreCase("3") || mode.equalsIgnoreCase("sp")) {
                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage("Set own game mode to Spectator Mode");
            }
            if(mode.equalsIgnoreCase("0") || mode.equalsIgnoreCase("s")) {
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage("Set own game mode to Survival Mode");
            }
            if(!(mode.equalsIgnoreCase("1") || mode.equalsIgnoreCase("2") ||mode.equalsIgnoreCase("3") ||mode.equalsIgnoreCase("0") ||mode.equalsIgnoreCase("c") ||mode.equalsIgnoreCase("a") ||mode.equalsIgnoreCase("sp") ||mode.equalsIgnoreCase("s"))) {
                p.sendMessage("Use /gm [player] <1,2,3,0 or c,a,sp,s>");
            }

        } else if(args.length == 2) {
            String target = args[1];
            String mode = args[0];
            Player targetPlayer = Bukkit.getPlayer(target);
            if(Main.isOnline.contains(targetPlayer)) {
                if(mode.equalsIgnoreCase("1") || mode.equalsIgnoreCase("c")) {
                    targetPlayer.setGameMode(GameMode.CREATIVE);
                    p.sendMessage("Set game mode of " + targetPlayer.getDisplayName() + " to Creative Mode");
                }
                if(mode.equalsIgnoreCase("2") || mode.equalsIgnoreCase("a")) {
                    targetPlayer.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage("Set game mode of " + targetPlayer.getDisplayName() + " to Adventure Mode");
                }
                if(mode.equalsIgnoreCase("3") || mode.equalsIgnoreCase("sp")) {
                    targetPlayer.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage("Set game mode of " + targetPlayer.getDisplayName() + " to Spectator Mode");
                }
                if(mode.equalsIgnoreCase("0") || mode.equalsIgnoreCase("s")) {
                    targetPlayer.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage("Set game mode of " + targetPlayer.getDisplayName() + " to Survival Mode");
                }
                if(!(mode.equalsIgnoreCase("1") || mode.equalsIgnoreCase("2") ||mode.equalsIgnoreCase("3") ||mode.equalsIgnoreCase("0") ||mode.equalsIgnoreCase("c") ||mode.equalsIgnoreCase("a") ||mode.equalsIgnoreCase("sp") ||mode.equalsIgnoreCase("s"))) {
                    p.sendMessage("Use /gm [player] <1,2,3,0 or c,a,sp,s>");
                }
            } else {
                p.sendMessage("This player is not online");
            }


        } else {
            p.sendMessage("Use /gm [player] <1,2,3,0 or c,a,sp,s>");
        }




        return true;
    }
}
