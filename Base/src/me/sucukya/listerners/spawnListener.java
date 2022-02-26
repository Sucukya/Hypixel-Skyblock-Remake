//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.listerners;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class spawnListener implements Listener {

    @EventHandler
    public void onSpawn(EntitySpawnEvent e) {
        if(e.getEntityType() == EntityType.PLAYER || e.getEntityType() == EntityType.DROPPED_ITEM || e.getEntityType() == EntityType.ARMOR_STAND || e.getEntityType() == EntityType.EXPERIENCE_ORB) {
        } else {
            Entity ent = e.getEntity();
            LivingEntity lvent = (LivingEntity) e.getEntity();
            ItemStack stat= new ItemStack(Material.SCUTE);
            ItemMeta meta = stat.getItemMeta();
            meta.setDisplayName(" ");
            stat.setItemMeta(meta);
            NBTItem nbti = new NBTItem(stat);
            nbti.setInteger("lvl",1);
            nbti.setInteger("hp",100);
            nbti.setInteger("chp",100);
            nbti.setInteger("dmg",10);
            stat = nbti.getItem();
            lvent.getEquipment().setItemInOffHand(stat);
            String entName  = e.getEntityType().toString().toLowerCase().substring(0, 1).toUpperCase() + e.getEntityType().toString().toLowerCase().substring(1);
            ent.setCustomName("§8[§7Lv" + nbti.getInteger("lvl") +"§8] §c" + entName + " §a" + nbti.getInteger("chp") + "§f/§a" + nbti.getInteger("hp") +"§c❤");
            ent.setCustomNameVisible(true);
        }
    }

}
