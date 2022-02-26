//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.listerners;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.location.CheckLocation;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class clickTP implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        NBTItem nbti = new NBTItem(p.getInventory().getItemInOffHand());
        if(e.getClickedInventory() !=null) {
            if(e.getView().getType() != InventoryType.ANVIL) {
                if(e.getView().getTitle().equalsIgnoreCase("§8SkyBlock Menu")) {
                    if(e.getCurrentItem() == null || e.getCurrentItem().getType().isAir()) {
                    } else {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bFast Travel")) {
                            if (e.getClick().isRightClick()) {
                                if (p.getWorld().equals(Bukkit.getWorld("world"))) {
                                    p.sendMessage("§7Warping you to your private island...");
                                    CheckLocation.locMap.put(p,"§aYour Island");
                                    CheckLocation.locMap2.put(p,"pisland");
                                    Location loc = p.getLocation();
                                    loc.setX(7.5);
                                    loc.setY(100);
                                    loc.setZ(7.5);
                                    loc.setPitch(0);
                                    loc.setYaw(0);
                                    loc.setWorld(Bukkit.getWorld("map_" + p.getUniqueId().toString() + "_" + nbti.getInteger("profile")));
                                    p.teleport(loc);
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§7Warping you to the hub island...");
                                    CheckLocation.locMap.put(p,"§bVillage");
                                    CheckLocation.locMap2.put(p,"v");
                                    Location loc = p.getLocation();
                                    loc.setX(-2.5);
                                    loc.setY(70);
                                    loc.setZ(-69.5);
                                    loc.setPitch(0);
                                    loc.setYaw(180);
                                    loc.setWorld(Bukkit.getWorld("world"));
                                    p.teleport(loc);
                                    p.closeInventory();
                                }
                            }
                        }
                    }
                }
            }
        }
    }




}
