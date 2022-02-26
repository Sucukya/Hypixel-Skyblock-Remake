package me.sucukya;

import me.sucukya.commands.givePet;
import me.sucukya.listeners.*;
import me.sucukya.utility.Test;
import me.sucukya.utility.petsCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Pets extends JavaPlugin {
    private final long startTime = System.currentTimeMillis();

    public static ArrayList<Player> convertlist = new ArrayList<>();
    public static ArrayList<Player> justJoined = new ArrayList<>();
    public static ArrayList<UUID> hidepets = new ArrayList<>();
    public static HashMap<String,String> raritycolormap = new HashMap<>();


    @Override
    public void onEnable() {

        raritycolormap.put("common", "§f");
        raritycolormap.put("uncommon", "§a");
        raritycolormap.put("rare", "§9");
        raritycolormap.put("epic", "§5");
        raritycolormap.put("legendary", "§6");
        raritycolormap.put("mythic", "§d");

        System.out.println("Loading Hypixel Skyblock Remake - Pets !");
        this.getCommand("test").setExecutor(new Test());
        this.getCommand("pets").setExecutor(new petsCommand());
        this.getCommand("givepet").setExecutor(new givePet());

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new petItemClick(), this);
        pm.registerEvents(new petsMenu(), this);
        pm.registerEvents(new petMenuClick(), this);
        pm.registerEvents(new joinListener(),this);
        pm.registerEvents(new leaveListener(),this);
        pm.registerEvents(new teleportEvent(),this);
        pm.registerEvents(new rightClickArmorStand(),this);

        for(Player p : Bukkit.getOnlinePlayers()) {
            moveArmorStand.prevX.put(p.getUniqueId(),p.getLocation().getX());
            moveArmorStand.prevZ.put(p.getUniqueId(),p.getLocation().getZ());
            moveArmorStand.prevY.put(p.getUniqueId(),p.getLocation().getY());
            moveArmorStand.prevYaw.put(p.getUniqueId(),p.getLocation().getYaw());
            moveArmorStand.prevPitch.put(p.getUniqueId(),p.getLocation().getPitch());
        }

        getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()) {
                moveArmorStand.check(p,startTime);
            }
            }
        },1L,1L);
    }

    @Override
    public void onDisable() {
        System.out.println("Unloading Hypixel Skyblock Remake - Pets !");
    }
}
