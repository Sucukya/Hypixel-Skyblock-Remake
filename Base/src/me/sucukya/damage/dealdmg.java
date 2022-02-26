//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.damage;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.enchant.checkIfHasEnchant;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class dealdmg {

    public static void deal(int dmg, Entity e, Player p) {
        if(e.getType() == EntityType.PLAYER || e.getType() == EntityType.ARMOR_STAND || e.getType() == EntityType.DROPPED_ITEM) {
        } else{
            LivingEntity ent = (LivingEntity) e;
            NBTItem nbti = new NBTItem(ent.getEquipment().getItemInOffHand());
            int hp = nbti.getInteger("hp");
            int chp = nbti.getInteger("chp");
            int lvl = nbti.getInteger("lvl");
            int realdmg = (int) ent.getLastDamage();
            int realhp = (int) ent.getHealth();
            String entName  = e.getType().toString().toLowerCase().substring(0, 1).toUpperCase() + e.getType().toString().toLowerCase().substring(1);
            int newHealth = chp-dmg;
            nbti.setInteger("chp", newHealth);
            ItemStack stack;
            stack = nbti.getItem();
            ent.getEquipment().setItemInOffHand(stack);
            nbti.setString("hitby", p.getUniqueId().toString());
            if(realhp - realdmg <= 0) {
                ent.setHealth(7);
            }
            if(nbti.getInteger("chp") <= 0) {
                ent.setHealth(0);
                e.isDead();
                e.setCustomName("§8[§7Lv" + lvl +"§8] §c" + entName + " §e" + 0 + "§f/§a" + hp +"§c❤");
                if(p.getInventory().getItemInMainHand().hasItemMeta()) {
                    if(checkIfHasEnchant.check(p.getInventory().getItemInMainHand(), "Telekinesis")) {

                    }
                }
            } else {
                if(newHealth <= hp/2) {
                    e.setCustomName("§8[§7Lv" + lvl +"§8] §c" + entName + " §e" + newHealth + "§f/§a" + hp +"§c❤");
                    e.setCustomNameVisible(true);
                } else {
                    e.setCustomName("§8[§7Lv" + lvl +"§8] §c" + entName + " §a" + newHealth + "§f/§a" + hp +"§c❤");
                    e.setCustomNameVisible(true);
                }
            }


        }

    }

}
