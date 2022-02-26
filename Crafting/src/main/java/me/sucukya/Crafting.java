//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya;

import me.sucukya.crafting.Events;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Crafting extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Crafting Module loading...");

        Bukkit.getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Crafting Module unloading...");
    }


}
