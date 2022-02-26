//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.islands.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class createMap {


    public static void createMap(Player p) throws IOException {
        String profile = mapUtils.getSelectedProfile(p);
        mapUtils.copyDirectory(new File(Bukkit.getServer().getWorldContainer() + "//template"),
                new File(Bukkit.getServer().getWorldContainer() + "//map_" + p.getUniqueId().toString() + "_" + profile));
        loadMap("map_" + p.getUniqueId().toString() + "_" + profile);
        Location loc = p.getLocation();
        loc.setWorld(Bukkit.getWorld("map_" + p.getUniqueId().toString() + "_" + profile));
        p.sendMessage(loc.getWorld().toString());
        loc.setX(7.5);
        loc.setY(100);
        loc.setZ(7.5);
        loc.setYaw(0);
        loc.setPitch(0);
        p.teleport(loc);
    }
    public static void loadMap(String mapname){
        Bukkit.getServer().createWorld(new WorldCreator(mapname));
    }
}