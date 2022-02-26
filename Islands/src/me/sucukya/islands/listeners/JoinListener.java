//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.islands.listeners;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.islands.utils.createMap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class JoinListener implements Listener {

    @EventHandler
      public void onJoin(PlayerJoinEvent e) throws IOException {
        Player p = e.getPlayer();
        NBTItem nbti = new NBTItem(p.getInventory().getItemInOffHand());
        if(nbti.getKeys().contains("profile")){
            createMap.loadMap("map_" + p.getUniqueId() + "_" + nbti.getInteger("profile"));
        } else {
            nbti.setInteger("profile", 1);
            ItemStack stack = nbti.getItem();
            p.getInventory().setItemInOffHand(stack);
            createMap.createMap(p);
        }
    }
}
