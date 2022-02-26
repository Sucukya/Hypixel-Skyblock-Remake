//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.playerStats;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class helmetClick implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getItem() == null || e.getItem().getType().isAir()) {
        } else {
            if(!Main.tools.contains(e.getMaterial())) {
                ItemStack stack = e.getItem();
                ItemStack stat = p.getInventory().getItemInOffHand();
                NBTItem nbti = new NBTItem(stack);
                NBTItem stats = new NBTItem(stat);
                String type = nbti.getString("type");
                if (e.getAction().equals(Action.LEFT_CLICK_AIR)) {
                    e.setCancelled(false);
                }
                if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                    e.setCancelled(false);
                }
                if (stack.getType().equals(Material.PLAYER_HEAD)) {
                    if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                        e.setCancelled(true);
                    } else if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                        if (type.equalsIgnoreCase("helmet")) {
                            ItemStack stack2 = p.getInventory().getItem(39);
                            if (stack2 == null || stack2.getType().isAir()) {
                                helmetStat.get(p, stats, stat, nbti);
                                p.getInventory().setItem(39, stack);
                                p.getInventory().getItemInMainHand().setAmount(0);
                            }
                        }
                    } else {
                        e.setCancelled(true);
                    }
                }
            }



        }


    }

}
