//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.damage;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class takeDamage implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if(e.getEntity().getType().equals(EntityType.PLAYER)) {
            Bukkit.broadcastMessage("test");
            Player p = (Player) e.getEntity();
                if (e.getDamager().getType().equals(EntityType.ARROW)) {
                    Projectile proj = (Projectile) e.getDamager();
                    LivingEntity ent = (LivingEntity) proj.getShooter();
            } else if(e.getCause() == EntityDamageEvent.DamageCause.DROWNING|| e.getCause().equals(EntityDamageEvent.DamageCause.FALL) || e.getCause().equals(EntityDamageEvent.DamageCause.LAVA) || e.getCause().equals(EntityDamageEvent.DamageCause.FIRE)) {
            }else {
                e.setDamage(0);
                Entity ent = e.getDamager();
                LivingEntity lent = (LivingEntity) e.getDamager();
                NBTItem nbti = new NBTItem(lent.getEquipment().getItemInOffHand());
                int dmg = nbti.getInteger("dmg");
                NBTItem stat = new NBTItem(p.getInventory().getItemInOffHand());
                int chp = stat.getInteger("chp");
                double def = me.sucukya.playerStats.calculateStat.calculate(p,"def");
                int hp = me.sucukya.playerStats.calculateStat.calculate(p,"hp");
                int ehp = (int) (chp * (def/100 + 1));
                ehp = ehp - dmg;
                chp = (int) (ehp / (def/100 +1));
                stat.setInteger("chp",chp);
                ItemStack stack = stat.getItem();
                p.getInventory().setItemInOffHand(stack);
                me.sucukya.listerners.updateHealthBar.update(p);
            }

        }


    }

}
