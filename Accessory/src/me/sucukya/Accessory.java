package me.sucukya;

import me.sucukya.listeners.AccessoryBag;
import me.sucukya.listeners.Triggers;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Accessory extends JavaPlugin {

    @Override
    public void onEnable()
    {
        System.out.println("Loading Hypixel Skyblock Remake - Accessory !");
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new AccessoryBag(), this);
        pm.registerEvents(new Triggers(), this);

    }

    @Override
    public void onDisable()
    {
        System.out.println("Unloading Hypixel Skyblock Remake - Accessory !");
    }
}
