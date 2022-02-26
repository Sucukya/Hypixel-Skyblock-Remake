package me.sucukya.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerDropItemEvent;

public class Triggers implements Listener {

    @EventHandler
    public void onOpenInvetory(InventoryOpenEvent e) {
        Player p = (Player) e.getPlayer();
        Checker.check(p);
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        Checker.check(p);
    }

    @EventHandler
    public void onPickUpItem(EntityPickupItemEvent e) {
        Player p = (Player) e.getEntity();
        Checker.check(p);
    }

    @EventHandler
    public void onMoveItem(InventoryMoveItemEvent e) {
        Player p = (Player) e.getInitiator().getViewers();
        Checker.check(p);
    }

    @EventHandler
    public void onInventoryPickUp(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Checker.check(p);
    }

    @EventHandler
    public void onCloseInventory(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();
        Checker.check(p);
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        Player p = (Player) e.getWhoClicked();
        Checker.check(p);
    }

}
