//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.islands;

import me.sucukya.islands.commands.test;
import me.sucukya.islands.listeners.JoinListener;
import me.sucukya.islands.listeners.LeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

public class Islands extends JavaPlugin implements Serializable {

    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new LeaveListener(), this);
        this.getCommand("test").setExecutor(new test());
    }

    @Override
    public void onDisable() {
    }



}
