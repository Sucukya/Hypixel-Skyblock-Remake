package me.sucukya.listeners;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;

import static me.sucukya.utility.addToMenu.addToMenu;

public class petItemClick implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (!(p.getOpenInventory().getType() == InventoryType.CHEST)) {
                if (e.getItem() == null || e.getItem().getType() == Material.AIR) {
                } else {
                    if (e.getItem().getType() == Material.PLAYER_HEAD) {
                        if(e.getItem().hasItemMeta()) {
                            NBTItem nbti = new NBTItem(e.getItem());
                            if(nbti.getKeys().contains("pet")) {
                                addToMenu(p,e.getItem());
                                e.setCancelled(true);
                                p.getInventory().remove(e.getItem());
                            }
                        }
                    }
                }
            }
        }
    }

}
