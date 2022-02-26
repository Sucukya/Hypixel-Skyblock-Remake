//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.commands;

import me.sucukya.utility.Data;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class sbEnchant implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cms, Command cmd, String arg, String[] args) {
        Player p = (Player) cms;
        if(cms.hasPermission("hpsbr.enchant")) {
            if(args.length == 2) {
                String enchant = args[0];
                int level = 0;
                try {
                    level = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    cms.sendMessage(Data.prefix + "§4Level §chas to be an §4Integer §c!");
                }
                try {
                    me.sucukya.enchant.getEnchant.get(enchant.toLowerCase(),level,p,p.getInventory().getItemInMainHand());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                p.sendMessage(Data.prefix + "§cNot enough arguments use: §a/sbenchant <Enchantment> <Level>");
            }
        }

        return true;
    }
}
