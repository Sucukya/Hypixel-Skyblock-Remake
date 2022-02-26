package me.sucukya.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class rightClickArmorStand implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent e) {
        if(e.getRightClicked().getType().equals(EntityType.ARMOR_STAND)) {
            e.setCancelled(true);
        }
    }

}
