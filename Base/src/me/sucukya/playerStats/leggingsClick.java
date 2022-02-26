//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.playerStats;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class leggingsClick implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getItem() == null || e.getItem().getType().isAir()) {
        } else {
            if (!Main.tools.contains(e.getMaterial())) {
                ItemStack stack = e.getItem();
                ItemStack stat = p.getInventory().getItemInOffHand();
                NBTItem nbti = new NBTItem(stack);
                NBTItem stats = new NBTItem(stat);
                String type = nbti.getString("type");
                if (e.getAction().equals(Action.LEFT_CLICK_AIR)) {
                    e.setCancelled(false);
                } else if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                    e.setCancelled(false);
                } else {
                    if (type.equalsIgnoreCase("leggings")) {
                        ItemStack stack2 = p.getInventory().getItem(37);
                        if (stack2 == null || stack2.getType().isAir()) {
                            leggingsStat.get(p, stats, stat, nbti);
                        }
                    }
                }
            }
        }
    }
    }
