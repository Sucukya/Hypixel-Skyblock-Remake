//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.listerners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class closeButton implements Listener {

    //Check for InventoryClick
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(e.getClickedInventory() !=null) {
            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
                } else {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cClose")) {
                        e.getWhoClicked().closeInventory();
                    }
                }
        }
    }

}
