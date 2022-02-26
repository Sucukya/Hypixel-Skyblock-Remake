package me.sucukya.listerners;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.location.CheckLocation;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class enterPortal implements Listener {

    @EventHandler
    public void playerEnterPortal(PlayerTeleportEvent e) {
        Player p = e.getPlayer();
        NBTItem nbti = new NBTItem(p.getInventory().getItemInOffHand());
        if(e.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL)) {
            if(CheckLocation.locMap2.get(p).equalsIgnoreCase("v")) {
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
                e.setTo(loc);
                p.closeInventory();
            }
        } else if(e.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL)) {
            if(CheckLocation.locMap2.get(p).equalsIgnoreCase("pisland")) {
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
                e.setTo(loc);
                p.closeInventory();
            }
        }
    }
}
