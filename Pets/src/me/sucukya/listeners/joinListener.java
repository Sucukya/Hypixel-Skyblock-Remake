package me.sucukya.listeners;

import me.sucukya.Pets;
import me.sucukya.utility.spawnArmorStand;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

public class joinListener implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Pets.justJoined.add(p);
        File pets = new File("plugins//HPSBR//Pets//players//" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration petsconfig = YamlConfiguration.loadConfiguration(pets);
        if(!pets.exists()) {
            petsconfig.set("equipedpet","None");
            try {
                petsconfig.save(pets);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            spawnArmorStand.spawnUnHide(p);
        }

        moveArmorStand.prevX.put(p.getUniqueId(),p.getLocation().getX());
        moveArmorStand.prevZ.put(p.getUniqueId(),p.getLocation().getZ());
        moveArmorStand.prevY.put(p.getUniqueId(),p.getLocation().getY());
        moveArmorStand.prevYaw.put(p.getUniqueId(),p.getLocation().getYaw());
        moveArmorStand.prevPitch.put(p.getUniqueId(),p.getLocation().getPitch());
    }

}
