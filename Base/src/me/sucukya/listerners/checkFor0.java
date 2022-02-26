//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.listerners;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class checkFor0 {

    public static void check() {
        for(Player all : Bukkit.getOnlinePlayers()) {
            NBTItem nbti = new NBTItem(all.getInventory().getItemInOffHand());
            int hp = nbti.getInteger("hp");
            int chp = nbti.getInteger("chp");
            if(chp <= 0) {
                nbti.setInteger("chp",hp);
                all.getInventory().setItemInOffHand(nbti.getItem());
                all.sendMessage("§cYou died!");
                all.setHealth(20);
                Location loc = all.getLocation();
                loc.setX(-2.5);
                loc.setY(70);
                loc.setZ(-69.5);
                loc.setPitch(0);
                loc.setYaw(180);
                loc.setWorld(Bukkit.getWorld("world"));
                all.teleport(loc);
            }
        }
    }

}
