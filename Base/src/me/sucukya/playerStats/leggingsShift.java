//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.playerStats;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class leggingsShift implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        ItemStack stat = p.getInventory().getItemInOffHand();
        NBTItem stats = new NBTItem(stat);
        if(e.getClickedInventory() != null) {
            if(e.getView().getType() != InventoryType.ANVIL) {
                if(e.getClickedInventory().equals(p.getInventory())) {
                    if (e.getCurrentItem() == null || e.getCurrentItem().getType().isAir()) {
                    } else {
                        if (e.getClick().isShiftClick()) {
                            if (e.getSlot() != 37) {
                                NBTItem nbti = new NBTItem(e.getCurrentItem());
                                String type = nbti.getString("type");
                                if (type.equalsIgnoreCase("leggings")) {
                                    ItemStack stack = p.getInventory().getItem(37);
                                    if (stack == null || stack.getType().isAir()) {
                                        leggingsStat.get(p, stats, stat, nbti);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
