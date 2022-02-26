package me.sucukya.utility;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        p.sendMessage(String.valueOf(p.getInventory().getItem(8)));
            File file = new File("plugins//HPSBR//Pets//players//" + p.getUniqueId() +  ".yml");
            YamlConfiguration petsconfig = YamlConfiguration.loadConfiguration(file);
            ArrayList<String> ownedpetslist = null;

            System.out.println(petsconfig.getKeys(true));

            if(petsconfig.contains("ownedpets")) {
                System.out.println("super");
                String[] elements = petsconfig.getString("ownedpets").split(",");
                List<String> list = Arrays.asList(elements);
                ownedpetslist = new ArrayList<>(list);
                System.out.println(ownedpetslist.toString());
            }


        return true;
    }
}
