package me.sucukya.utility;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class petStat {
    public static void add(Player p, ItemStack stack) {
        File pets = new File("plugins//HPSBR//Pets//players//" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration petsconfig = YamlConfiguration.loadConfiguration(pets);
        NBTItem nbti = new NBTItem(stack);
        NBTItem stats = new NBTItem(p.getInventory().getItemInOffHand());
        String id = nbti.getString("id");
        ConfigurationSection cs = petsconfig.getConfigurationSection(id);
        int level = cs.getInt("level");
        String type = cs.getString("type");
        File typefile = new File("plugins//HPSBR//Pets//type//" + type.toLowerCase() +".yml");
        YamlConfiguration typeconfig = YamlConfiguration.loadConfiguration(typefile);
        double hp = 0;
        double def = 0;
        double str = 0;
        double speed = 0;
        double cchance = 0;
        double cdamage = 0;
        double bonusas = 0;
        double mana = 0;
        double scchance = 0;
        double magicfind = 0;
        double petluck = 0;
        double truedef = 0;
        double ferocity = 0;
        if(typeconfig.contains("hp")) {
            hp = typeconfig.getDouble("hp") * level;
        }
        if(typeconfig.contains("def")) {
            def = typeconfig.getDouble("def") * level;
        }
        if(typeconfig.contains("str")) {
            str = typeconfig.getDouble("str") * level;
        }
        if(typeconfig.contains("speed")) {
            speed = typeconfig.getDouble("speed") * level;
        }
        if(typeconfig.contains("cchance")) {
            cchance = typeconfig.getDouble("cchance") * level;
        }
        if(typeconfig.contains("cdamage")) {
            cdamage = typeconfig.getDouble("cdamage") * level;
        }
        if(typeconfig.contains("bonusas")) {
            bonusas = typeconfig.getDouble("bonusas") * level;
        }
        if(typeconfig.contains("mana")) {
            mana = typeconfig.getDouble("mana") * level;
        }
        if(typeconfig.contains("scchance")) {
            scchance = typeconfig.getDouble("scchance") * level;
        }
        if(typeconfig.contains("magicfind")) {
            magicfind = typeconfig.getDouble("magicfind") * level;
        }
        if(typeconfig.contains("petluck")) {
            petluck = typeconfig.getDouble("petluck") * level;
        }
        if(typeconfig.contains("truedef")) {
            truedef = typeconfig.getDouble("truedef") * level;
        }
        if(typeconfig.contains("ferocity")) {
            ferocity = typeconfig.getDouble("ferocity") * level;
        }

        double finalhp = (int) (stats.getDouble("bonushp") + hp);
        double finaldef = stats.getDouble("bonusdef") + def;
        double finalstr = (int) (stats.getDouble("bonusstr") + str);
        double finalspeed = (int) (stats.getDouble("bonusspeed") + speed);
        double finalmana = (int) (stats.getDouble("bonusmana") + mana);
        double finalcchance = (int) (stats.getDouble("bonuscchance") + cchance);
        double finalcdamage = (int) (stats.getDouble("bonuscdamage") + cdamage);
        double finalpetluck = (int) (stats.getDouble("bonuspetluck") + petluck);
        double finalbonusas = (int) (stats.getDouble("bonusbonusas") + bonusas);
        double finalmagicfind = (int) (stats.getDouble("bonusmagicfind") + magicfind);
        double finalscchance = (int) (stats.getDouble("bonusscchance") + scchance);
        double finaltruedef = (int) (stats.getDouble("bonustruedef") + truedef);
        double finalferocity = stats.getDouble("bonusferocity") + ferocity;

        stats.setDouble("bonushp",finalhp);
        stats.setDouble("bonusdef",finaldef);
        stats.setDouble("bonusstr",finalstr);
        stats.setDouble("bonusspeed",finalspeed);
        stats.setDouble("bonusmana",finalmana);
        stats.setDouble("bonuscchance",finalcchance);
        stats.setDouble("bonuscdamage",finalcdamage);
        stats.setDouble("bonuspetluck",finalpetluck);
        stats.setDouble("bonusbonusas",finalbonusas);
        stats.setDouble("bonusmagicfind",finalmagicfind);
        stats.setDouble("bonusscchance",finalscchance);
        stats.setDouble("bonustruedef",finaltruedef);
        stats.setDouble("bonusferocity",finalferocity);

        ItemStack stat = stats.getItem();
        p.getInventory().setItemInOffHand(stat);
    }

    public static void remove(Player p, ItemStack stack) {
        File pets = new File("plugins//HPSBR//Pets//players//" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration petsconfig = YamlConfiguration.loadConfiguration(pets);
        NBTItem nbti = new NBTItem(stack);
        NBTItem stats = new NBTItem(p.getInventory().getItemInOffHand());
        String id = nbti.getString("id");
        ConfigurationSection cs = petsconfig.getConfigurationSection(id);
        int level = cs.getInt("level");
        String type = cs.getString("type");
        File typefile = new File("plugins//HPSBR//Pets//type//" + type.toLowerCase() +".yml");
        YamlConfiguration typeconfig = YamlConfiguration.loadConfiguration(typefile);
        double hp = 0;
        double def = 0;
        double str = 0;
        double speed = 0;
        double cchance = 0;
        double cdamage = 0;
        double bonusas = 0;
        double mana = 0;
        double scchance = 0;
        double magicfind = 0;
        double petluck = 0;
        double truedef = 0;
        double ferocity = 0;
        if(typeconfig.contains("hp")) {
            hp = typeconfig.getDouble("hp") * level;
        }
        if(typeconfig.contains("def")) {
            def = typeconfig.getDouble("def") * level;
        }
        if(typeconfig.contains("str")) {
            str = typeconfig.getDouble("str") * level;
        }
        if(typeconfig.contains("speed")) {
            speed = typeconfig.getDouble("speed") * level;
        }
        if(typeconfig.contains("cchance")) {
            cchance = typeconfig.getDouble("cchance") * level;
        }
        if(typeconfig.contains("cdamage")) {
            cdamage = typeconfig.getDouble("cdamage") * level;
        }
        if(typeconfig.contains("bonusas")) {
            bonusas = typeconfig.getDouble("bonusas") * level;
        }
        if(typeconfig.contains("mana")) {
            mana = typeconfig.getDouble("mana") * level;
        }
        if(typeconfig.contains("scchance")) {
            scchance = typeconfig.getDouble("scchance") * level;
        }
        if(typeconfig.contains("magicfind")) {
            magicfind = typeconfig.getDouble("magicfind") * level;
        }
        if(typeconfig.contains("petluck")) {
            petluck = typeconfig.getDouble("petluck") * level;
        }
        if(typeconfig.contains("truedef")) {
            truedef = typeconfig.getDouble("truedef") * level;
        }
        if(typeconfig.contains("ferocity")) {
            ferocity = typeconfig.getDouble("ferocity") * level;
        }

        double finalhp = (int) (stats.getDouble("bonushp") - hp);
        double finaldef = stats.getDouble("bonusdef") - def;
        double finalstr = (int) (stats.getDouble("bonusstr") - str);
        double finalspeed = (int) (stats.getDouble("bonusspeed") - speed);
        double finalmana = (int) (stats.getDouble("bonusmana") - mana);
        double finalcchance = (int) (stats.getDouble("bonuscchance") - cchance);
        double finalcdamage = (int) (stats.getDouble("bonuscdamage") - cdamage);
        double finalpetluck = (int) (stats.getDouble("bonuspetluck") - petluck);
        double finalbonusas = (int) (stats.getDouble("bonusbonusas") - bonusas);
        double finalmagicfind = (int) (stats.getDouble("bonusmagicfind") - magicfind);
        double finalscchance = (int) (stats.getDouble("bonusscchance") - scchance);
        double finaltruedef = (int) (stats.getDouble("bonustruedef") - truedef);
        double finalferocity = stats.getDouble("bonusferocity") - ferocity;

        stats.setDouble("bonushp",finalhp);
        stats.setDouble("bonusdef",finaldef);
        stats.setDouble("bonusstr",finalstr);
        stats.setDouble("bonusspeed",finalspeed);
        stats.setDouble("bonusmana",finalmana);
        stats.setDouble("bonuscchance",finalcchance);
        stats.setDouble("bonuscdamage",finalcdamage);
        stats.setDouble("bonuspetluck",finalpetluck);
        stats.setDouble("bonusbonusas",finalbonusas);
        stats.setDouble("bonusmagicfind",finalmagicfind);
        stats.setDouble("bonusscchance",finalscchance);
        stats.setDouble("bonustruedef",finaltruedef);
        stats.setDouble("bonusferocity",finalferocity);
        ItemStack stat = stats.getItem();
        p.getInventory().setItemInOffHand(stat);
    }

    public static void removeStand(Player p, String id) {
        File pets = new File("plugins//HPSBR//Pets//players//" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration petsconfig = YamlConfiguration.loadConfiguration(pets);
        NBTItem stats = new NBTItem(p.getInventory().getItemInOffHand());
        ConfigurationSection cs = petsconfig.getConfigurationSection(id);
        int level = cs.getInt("level");
        String type = cs.getString("type");
        File typefile = new File("plugins//HPSBR//Pets//type//" + type.toLowerCase() +".yml");
        YamlConfiguration typeconfig = YamlConfiguration.loadConfiguration(typefile);
        double hp = 0;
        double def = 0;
        double str = 0;
        double speed = 0;
        double cchance = 0;
        double cdamage = 0;
        double bonusas = 0;
        double mana = 0;
        double scchance = 0;
        double magicfind = 0;
        double petluck = 0;
        double truedef = 0;
        double ferocity = 0;
        if(typeconfig.contains("hp")) {
            hp = typeconfig.getDouble("hp") * level;
        }
        if(typeconfig.contains("def")) {
            def = typeconfig.getDouble("def") * level;
        }
        if(typeconfig.contains("str")) {
            str = typeconfig.getDouble("str") * level;
        }
        if(typeconfig.contains("speed")) {
            speed = typeconfig.getDouble("speed") * level;
        }
        if(typeconfig.contains("cchance")) {
            cchance = typeconfig.getDouble("cchance") * level;
        }
        if(typeconfig.contains("cdamage")) {
            cdamage = typeconfig.getDouble("cdamage") * level;
        }
        if(typeconfig.contains("bonusas")) {
            bonusas = typeconfig.getDouble("bonusas") * level;
        }
        if(typeconfig.contains("mana")) {
            mana = typeconfig.getDouble("mana") * level;
        }
        if(typeconfig.contains("scchance")) {
            scchance = typeconfig.getDouble("scchance") * level;
        }
        if(typeconfig.contains("magicfind")) {
            magicfind = typeconfig.getDouble("magicfind") * level;
        }
        if(typeconfig.contains("petluck")) {
            petluck = typeconfig.getDouble("petluck") * level;
        }
        if(typeconfig.contains("truedef")) {
            truedef = typeconfig.getDouble("truedef") * level;
        }
        if(typeconfig.contains("ferocity")) {
            ferocity = typeconfig.getDouble("ferocity") * level;
        }

        double finalhp = (int) (stats.getDouble("bonushp") - hp);
        double finaldef = stats.getDouble("bonusdef") - def;
        double finalstr = (int) (stats.getDouble("bonusstr") - str);
        double finalspeed = (int) (stats.getDouble("bonusspeed") - speed);
        double finalmana = (int) (stats.getDouble("bonusmana") - mana);
        double finalcchance = (int) (stats.getDouble("bonuscchance") - cchance);
        double finalcdamage = (int) (stats.getDouble("bonuscdamage") - cdamage);
        double finalpetluck = (int) (stats.getDouble("bonuspetluck") - petluck);
        double finalbonusas = (int) (stats.getDouble("bonusbonusas") - bonusas);
        double finalmagicfind = (int) (stats.getDouble("bonusmagicfind") - magicfind);
        double finalscchance = (int) (stats.getDouble("bonusscchance") - scchance);
        double finaltruedef = (int) (stats.getDouble("bonustruedef") - truedef);
        double finalferocity = stats.getDouble("bonusferocity") - ferocity;

        stats.setDouble("bonushp",finalhp);
        stats.setDouble("bonusdef",finaldef);
        stats.setDouble("bonusstr",finalstr);
        stats.setDouble("bonusspeed",finalspeed);
        stats.setDouble("bonusmana",finalmana);
        stats.setDouble("bonuscchance",finalcchance);
        stats.setDouble("bonuscdamage",finalcdamage);
        stats.setDouble("bonuspetluck",finalpetluck);
        stats.setDouble("bonusbonusas",finalbonusas);
        stats.setDouble("bonusmagicfind",finalmagicfind);
        stats.setDouble("bonusscchance",finalscchance);
        stats.setDouble("bonustruedef",finaltruedef);
        stats.setDouble("bonusferocity",finalferocity);
        ItemStack stat = stats.getItem();
        p.getInventory().setItemInOffHand(stat);
    }
}
