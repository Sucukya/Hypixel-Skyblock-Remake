package me.sucukya.utility;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Files {

    //Own Class for Files for better Overview in Main Class

        public static File config = new File("plugins//HPSBR//config.yml");
        public static File alreadyJoined = new File("plugins//HPSBR//alreadyJoined.yml");

        public static YamlConfiguration conf;
        public static YamlConfiguration alreadyJoinedConf;

        public static void refresh() {
            conf = YamlConfiguration.loadConfiguration(config);
            alreadyJoinedConf = YamlConfiguration.loadConfiguration(alreadyJoined);
        }



}
