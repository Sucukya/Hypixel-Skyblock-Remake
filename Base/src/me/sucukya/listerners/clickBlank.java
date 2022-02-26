package me.sucukya.listerners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class clickBlank implements Listener {


    //Check for Inventory Click
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getClickedInventory() == null) {

        }else {
            if(e.getClickedInventory().equals(p.getInventory())) {
                if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
                }else {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
                        e.setCancelled(true);
                    }
                }

            }else {
                if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
                }else {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}
