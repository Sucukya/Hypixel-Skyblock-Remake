package me.sucukya.listeners;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Pets;
import me.sucukya.utility.convertToItem;
import me.sucukya.utility.spawnArmorStand;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class petMenuClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if(e.getClickedInventory() != null) {
            if(e.getView().getTitle().equalsIgnoreCase("§8Pets")) {
                if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
                } else {
                    if(e.getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {
                        ItemStack stack = e.getCurrentItem();
                        if(Pets.convertlist.contains(p)) {
                            Pets.convertlist.remove(p);
                            convertToItem.convert(p,stack);
                            e.setCancelled(true);
                            p.closeInventory();
                        } else {
                            me.sucukya.utility.spawnArmorStand.spawn(e.getCurrentItem(), p);
                            p.getOpenInventory().close();
                            e.setCancelled(true);
                        }
                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aConvert Pet to an Item")) {
                        e.setCancelled(true);
                        if(Pets.convertlist.contains(p)) {
                            Pets.convertlist.remove(p);
                        } else {
                            Pets.convertlist.add(p);
                        }
                        petsMenu.openMenu(p);
                    } else if(e.getCurrentItem().getType().equals(Material.STONE_BUTTON)) {
                        e.setCancelled(true);
                        if(Pets.hidepets.contains(p.getUniqueId())) {
                            Pets.hidepets.remove(p.getUniqueId());
                            spawnArmorStand.spawnUnHide(p);
                            p.sendMessage("§cHide Pets is now disabled!");
                        } else {
                            p.sendMessage("§aHide Pets is now enabled!");
                            Pets.hidepets.add(p.getUniqueId());
                            List<Entity> entities = p.getNearbyEntities(10, 10, 10);
                            for (Entity entity : entities) {
                                if (entity.getType().equals(EntityType.ARMOR_STAND)) {
                                    ArmorStand as = (ArmorStand) entity;
                                    if(as.getEquipment().getHelmet() == null || as.getEquipment().getHelmet().getType() == Material.AIR) {
                                    } else {
                                        NBTItem nbti = new NBTItem(as.getEquipment().getHelmet());
                                        if(nbti.getString("owner").equalsIgnoreCase(p.getUniqueId().toString())) {
                                            as.remove();
                                        }
                                    }
                                }
                            }
                        }
                        p.closeInventory();
                    }

                }
            }
        }

    }
}
