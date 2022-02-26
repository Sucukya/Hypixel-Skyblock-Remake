package me.sucukya.listeners;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Pets;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.io.File;
import java.util.List;

public class teleportEvent implements Listener {

    @EventHandler
    public void onTeleport(PlayerTeleportEvent e) {
        Player p = e.getPlayer();
        if(Pets.justJoined.contains(p)) {
        } else {
            File pets = new File("plugins//HPSBR//Pets//players//" + p.getUniqueId().toString() + ".yml");
            YamlConfiguration petsconfig = YamlConfiguration.loadConfiguration(pets);
            String id = petsconfig.getString("equipedpet");
            if (id.equalsIgnoreCase("None")) {
            } else {
                List<Entity> entities = p.getNearbyEntities(10, 10, 10);
                for (Entity entity : entities) {
                    if (entity.getType().equals(EntityType.ARMOR_STAND)) {
                        ArmorStand as = (ArmorStand) entity;
                        if (as.getEquipment().getHelmet() == null || as.getEquipment().getHelmet().getType() == Material.AIR) {
                        } else {
                            NBTItem nbti = new NBTItem(as.getEquipment().getHelmet());
                            if (nbti.getString("owner").equalsIgnoreCase(p.getUniqueId().toString())) {
                                as.remove();
                            }
                        }
                    }
                }
            }
        }
    }

}
