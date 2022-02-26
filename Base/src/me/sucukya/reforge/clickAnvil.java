//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class clickAnvil implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getClickedInventory() !=null) {
            if(e.getView().getType() != InventoryType.ANVIL) {
                if(e.getView().getTitle().equalsIgnoreCase("§8Reforge Item")) {
                    if(e.getCurrentItem() == null || e.getCurrentItem().getType().isAir()) {
                    } else {
                        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eReforge Item")) {
                            e.setCancelled(true);
                            p.sendMessage("§cPlace an item in the empty slot to reforge it!");
                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aReforge Item")) {
                            ItemStack stack = e.getInventory().getItem(13);
                            reforge.reforge(stack, (Player) e.getWhoClicked(),e.getInventory());
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }



}
