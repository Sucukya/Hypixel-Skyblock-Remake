//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.npc;

import me.sucukya.npc.commands.reforge;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    //onEnable()
    @Override
    public void onEnable() {
        //Load PluginManager
        PluginManager pm = Bukkit.getPluginManager();

        //Register Commands
        getCommand("reforge").setExecutor(new reforge());
    }

    //onDisable()
    @Override
    public void onDisable() {

    }


}
