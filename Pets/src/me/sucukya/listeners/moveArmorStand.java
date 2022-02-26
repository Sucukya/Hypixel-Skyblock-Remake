package me.sucukya.listeners;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class moveArmorStand implements Listener {



    public static HashMap<UUID,Double> prevX = new HashMap<>();
    public static HashMap<UUID,Double> prevZ = new HashMap<>();
    public static HashMap<UUID,Double> prevY = new HashMap<>();
    public static HashMap<UUID,Float> prevYaw = new HashMap<>();
    public static HashMap<UUID,Float> prevPitch = new HashMap<>();


   public static void check(Player p, long startTime) {
       List<Entity> entities = p.getNearbyEntities(10, 10, 10);
       for (Entity entity : entities) {
           if (entity.getType().equals(EntityType.ARMOR_STAND)) {
               ArmorStand as = (ArmorStand) entity;
               if (as.getEquipment().getHelmet() == null || as.getEquipment().getHelmet().getType().equals(Material.AIR)) {
               }else {
                   ItemStack pet = as.getEquipment().getHelmet();
                   NBTItem nbti = new NBTItem(pet);
                   if (nbti.getKeys().contains("owner")) {
                       if (nbti.getString("owner").equalsIgnoreCase(p.getUniqueId().toString())) {
                           Location loc = p.getLocation();
                           if (Math.abs(loc.getX() - prevX.get(p.getUniqueId())) <= 0.75 && Math.abs(loc.getZ() - prevZ.get(p.getUniqueId())) <= 0.75 && Math.abs(loc.getY() - prevY.get(p.getUniqueId())) <= 1) {
                               double timeSeconds = Math.floor(((double) System.currentTimeMillis() - (double) startTime) / 500D);
                               as.teleport(as.getLocation().clone().add(0D, Math.sin(timeSeconds) * 0.05D, 0));
                               p.spawnParticle(Particle.ENCHANTMENT_TABLE,as.getLocation().clone().add(0D, Math.sin(timeSeconds) * 0.05D + 0.5, 0), 3);
                           } else {
                               prevX.put(p.getUniqueId(),loc.getX());
                               prevZ.put(p.getUniqueId(),loc.getZ());
                               prevY.put(p.getUniqueId(),loc.getY());
                               prevYaw.put(p.getUniqueId(),loc.getYaw());
                               prevPitch.put(p.getUniqueId(),loc.getPitch());
                               Vector direction = p.getLocation().getDirection().multiply(new Vector(-1, 0, -1)).normalize();
                               Location loc2 = p.getLocation();
                               loc2.setX(p.getLocation().getX());
                               loc2.setZ(p.getLocation().getZ());
                               loc2.setY(p.getLocation().getY() + 0.3);
                               as.teleport(loc2.add(direction));
                           }
                       }
                   }
               }
           }
       }
   }
}
