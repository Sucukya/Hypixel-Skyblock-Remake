//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.islands.listeners;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        NBTItem nbti = new NBTItem(p.getInventory().getItemInOffHand());
        if(nbti.getKeys().contains("profile")) {
            if(p.getWorld().getName().equals("map_" + p.getUniqueId().toString()+ "_" + nbti.getInteger("profile"))) {
                Location loc = p.getLocation();
                loc.setX(-2.5);
                loc.setY(70);
                loc.setZ(-69.5);
                loc.setPitch(0);
                loc.setYaw(180);
                loc.setWorld(Bukkit.getWorld("world"));
                p.teleport(loc);
            }
            Bukkit.unloadWorld("map_" + p.getUniqueId() + "_" + nbti.getInteger("profile"), true);
            Bukkit.broadcastMessage(Bukkit.getWorlds().toString());
        }
    }

}
