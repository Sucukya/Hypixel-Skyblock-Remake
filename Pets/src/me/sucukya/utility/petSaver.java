package me.sucukya.utility;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class petSaver {

    public static File pets;
    public static YamlConfiguration petsconf;

    public static void save(Player p, ItemStack stack) {
        ArrayList<String> petslist;

        pets = new File("plugins//HPSBR//Pets//players//" + p.getUniqueId().toString() + ".yml");
        petsconf = YamlConfiguration.loadConfiguration(pets);

        try {
            petsconf.save(pets);
        } catch (IOException e) {
            e.printStackTrace();
        }

        NBTItem nbti = new NBTItem(stack);
        int level = nbti.getInteger("level");
        String rarity = nbti.getString("rarity");
        int xp = nbti.getInteger("xp");
        String petitem = nbti.getString("item");
        String id = nbti.getString("id");
        String type = nbti.getString("type");
        String head = nbti.getString("head");
        String pettype = nbti.getString("pettype");

        String owned = "";

        if(petsconf.contains("ownedpets")) {
            String[] elements = petsconf.getString("ownedpets").split(",");
            List<String> list = Arrays.asList(elements);
            petslist = new ArrayList<String>(list);
            petslist.add(id);
            for(int i=0; i < petslist.size(); i++) {
                owned = owned + petslist.get(i) + ",";
            }
            System.out.println(owned);
        } else {
            petslist = new ArrayList<>();
            petslist.add(id);
            for(int i=0; i < petslist.size(); i++) {
                owned = owned + petslist.get(i) + ",";
            }
        }

        if(!petsconf.contains("equipedpet")) {
            petsconf.set("equipedpet", "None");
        }

        petsconf.set("ownedpets", owned);
        ConfigurationSection cs = petsconf.createSection(id);

        cs.set("level", level);
        cs.set("rarity", rarity);
        cs.set("xp", xp);
        cs.set("petitem", petitem);
        cs.set("type", type);
        cs.set("head",head);
        cs.set("pettype",pettype);

        try {
            petsconf.save(pets);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
