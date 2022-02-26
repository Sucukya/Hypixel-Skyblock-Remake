//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.damage;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Map;

public class onHit implements Listener {


    //Check for EntityDamageByEntityEvent

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if(e.getDamager().getType() == EntityType.PLAYER) {
            if(e.getEntity().getType() == EntityType.ARMOR_STAND) {
                e.setCancelled(true);
            } else if(e.getEntity().getType() == EntityType.PLAYER) {
            } else {
                Player p = (Player) e.getDamager();
                Material mat = p.getInventory().getItemInMainHand().getType();
                Map dmgmap;
                if (mat.isAir()) {
                    dmgmap = calculateDamage.calc(0, p, e.getEntity());
                } else {
                    if (p.getInventory().getItemInMainHand().hasItemMeta()) {
                        NBTItem nbtItem = new NBTItem(p.getInventory().getItemInMainHand());
                        int dmg = nbtItem.getInteger("damage");
                        dmgmap = calculateDamage.calc(dmg, p, e.getEntity());
                    } else {
                        dmgmap = calculateDamage.calc(0, p, e.getEntity());
                    }
                }
                int dmgcalc = (int) dmgmap.get("finaldmg");
                int isCrit = (int) dmgmap.get("crit");
                boolean crit = false;
                if (isCrit == 1) {
                    crit = true;
                } else if (isCrit == 0) {
                    crit = false;
                }
                spawnArmorStand.spawn(e.getEntity(), dmgcalc, crit);
                dealdmg.deal(dmgcalc,e.getEntity(),p);
            }

        } else if(e.getDamager().getType().equals(EntityType.ARROW)) {
            Projectile ent = (Projectile) e.getDamager();
            Entity lent = (Entity) ent.getShooter();
            if (lent.getType().equals(EntityType.PLAYER)) {
                Player p = (Player) ent.getShooter();
                if (e.getEntity().getType() == EntityType.ARMOR_STAND) {
                    e.setCancelled(true);
                } else {
                    Material mat = p.getInventory().getItemInMainHand().getType();
                    Map dmgmap;
                    if (mat.isAir()) {
                        dmgmap = calculateDamage.calc(0, p, e.getEntity());
                    } else {
                        if (p.getInventory().getItemInMainHand().hasItemMeta()) {
                            NBTItem nbtItem = new NBTItem(p.getInventory().getItemInMainHand());
                            int dmg = nbtItem.getInteger("damage");
                            dmgmap = calculateDamage.calc(dmg, p, e.getEntity());
                        } else {
                            dmgmap = calculateDamage.calc(0, p, e.getEntity());
                        }
                    }
                    int dmgcalc = (int) dmgmap.get("finaldmg");
                    int isCrit = (int) dmgmap.get("crit");
                    boolean crit = false;
                    if (isCrit == 1) {
                        crit = true;
                    } else if (isCrit == 0) {
                        crit = false;
                    }
                    spawnArmorStand.spawn(e.getEntity(), dmgcalc, crit);
                    dealdmg.deal(dmgcalc, e.getEntity(), p);
                }
            }
        }
    }
}
