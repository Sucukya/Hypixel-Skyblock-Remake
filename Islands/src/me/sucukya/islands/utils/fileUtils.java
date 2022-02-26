//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.islands.utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class fileUtils {

    public static File maps = new File("plugins//HPSBR//maps.yml");
    public static YamlConfiguration mapsconf;
    public static void loadConfs() throws IOException, InvalidConfigurationException {
        mapsconf.load(maps);
    }


}
