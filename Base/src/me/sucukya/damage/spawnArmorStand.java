//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.damage;

import me.sucukya.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class spawnArmorStand {

    public static void spawn(Entity e, int dmg, boolean crit) {
        if (e.getType() == EntityType.ARMOR_STAND) {
        } else {
            ArmorStand stand = (ArmorStand) e.getLocation().getWorld().spawnEntity(e.getLocation().add(0, -0.5F, 1) , EntityType.ARMOR_STAND);
            if(crit) {
                stand.setCustomName("§f⟡§6" + dmg + "§f⟡");
            } else {
                stand.setCustomName("§7" + dmg);
            }
            stand.setCustomNameVisible(true);
            stand.setGravity(false);
            stand.setInvulnerable(true);

            Bukkit.getScheduler().runTaskLater(Main.getMain(), () -> {
                stand.remove();
            },20L);
        }
    }

}
