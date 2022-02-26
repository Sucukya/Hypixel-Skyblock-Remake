package me.sucukya.utility;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import me.sucukya.playerStats.*;

import java.io.File;
import java.io.IOException;

public class saveStats {

    public static void save(Player p) {
        double weaponhp = 0;
        double weapondef = 0;
        double weaponstr = 0;
        double weaponspeed = 0;
        double weaponmana = 0;
        double weaponcchance = 0;
        double weaponcdamage = 0;
        double weaponpetluck = 0;
        double weaponbonusas = 0;
        double weaponmagicfind = 0;
        double weaponscchance = 0;
        double weapontruedef = 0;
        double weaponferocity = 0;
        if(weaponMaps.hpmap.containsKey(p)) {
            weaponhp = weaponMaps.hpmap.get(p);
        }
        if(weaponMaps.defmap.containsKey(p)) {
            weapondef = weaponMaps.defmap.get(p);
        }
        if(weaponMaps.strmap.containsKey(p)) {
            weaponstr = weaponMaps.strmap.get(p);
        }
        if(weaponMaps.speedmap.containsKey(p)) {
            weaponspeed = weaponMaps.speedmap.get(p);
        }
        if(weaponMaps.manamap.containsKey(p)) {
            weaponmana = weaponMaps.manamap.get(p);
        }
        if(weaponMaps.cchancemap.containsKey(p)) {
            weaponcchance = weaponMaps.cchancemap.get(p);
        }
        if(weaponMaps.cdamagemap.containsKey(p)) {
            weaponcdamage = weaponMaps.cdamagemap.get(p);
        }
        if(weaponMaps.petluckmap.containsKey(p)) {
            weaponpetluck = weaponMaps.petluckmap.get(p);
        }
        if(weaponMaps.bonusasmap.containsKey(p)) {
            weaponbonusas = weaponMaps.bonusasmap.get(p);
        }
        if(weaponMaps.magicfindmap.containsKey(p)) {
            weaponmagicfind = weaponMaps.magicfindmap.get(p);
        }
        if(weaponMaps.scchancemap.containsKey(p)) {
            weaponscchance = weaponMaps.scchancemap.get(p);
        }
        if(weaponMaps.truedefmap.containsKey(p)) {
            weapontruedef = weaponMaps.truedefmap.get(p);
        }
        if(weaponMaps.ferocitymap.containsKey(p)) {
            weaponferocity = weaponMaps.ferocitymap.get(p);
        }

        double helmethp = 0;
        double helmetdef = 0;
        double helmetstr = 0;
        double helmetspeed = 0;
        double helmetmana = 0;
        double helmetcchance = 0;
        double helmetcdamage = 0;
        double helmetpetluck = 0;
        double helmetbonusas = 0;
        double helmetmagicfind = 0;
        double helmetscchance = 0;
        double helmettruedef = 0;
        double helmetferocity = 0;
        if(helmetMaps.hpmap.containsKey(p)) {
            helmethp = helmetMaps.hpmap.get(p);
        }
        if(helmetMaps.defmap.containsKey(p)) {
            helmetdef = helmetMaps.defmap.get(p);
        }
        if(helmetMaps.strmap.containsKey(p)) {
            helmetstr = helmetMaps.strmap.get(p);
        }
        if(helmetMaps.speedmap.containsKey(p)) {
            helmetspeed = helmetMaps.speedmap.get(p);
        }
        if(helmetMaps.manamap.containsKey(p)) {
            helmetmana = helmetMaps.manamap.get(p);
        }
        if(helmetMaps.cchancemap.containsKey(p)) {
            helmetcchance = helmetMaps.cchancemap.get(p);
        }
        if(helmetMaps.cdamagemap.containsKey(p)) {
            helmetcdamage = helmetMaps.cdamagemap.get(p);
        }
        if(helmetMaps.petluckmap.containsKey(p)) {
            helmetpetluck = helmetMaps.petluckmap.get(p);
        }
        if(helmetMaps.bonusasmap.containsKey(p)) {
            helmetbonusas = helmetMaps.bonusasmap.get(p);
        }
        if(helmetMaps.magicfindmap.containsKey(p)) {
            helmetmagicfind = helmetMaps.magicfindmap.get(p);
        }
        if(helmetMaps.scchancemap.containsKey(p)) {
            helmetscchance = helmetMaps.scchancemap.get(p);
        }
        if(helmetMaps.truedefmap.containsKey(p)) {
            helmettruedef = helmetMaps.truedefmap.get(p);
        }
        if(helmetMaps.ferocitymap.containsKey(p)) {
            helmetferocity = helmetMaps.ferocitymap.get(p);
        }

        double chestplatehp = 0;
        double chestplatedef = 0;
        double chestplatestr = 0;
        double chestplatespeed = 0;
        double chestplatemana = 0;
        double chestplatecchance = 0;
        double chestplatecdamage = 0;
        double chestplatepetluck = 0;
        double chestplatebonusas = 0;
        double chestplatemagicfind = 0;
        double chestplatescchance = 0;
        double chestplatetruedef = 0;
        double chestplateferocity = 0;
        if(chestplateMaps.hpmap.containsKey(p)) {
            chestplatehp = chestplateMaps.hpmap.get(p);
        }
        if(chestplateMaps.defmap.containsKey(p)) {
            chestplatedef = chestplateMaps.defmap.get(p);
        }
        if(chestplateMaps.strmap.containsKey(p)) {
            chestplatestr = chestplateMaps.strmap.get(p);
        }
        if(chestplateMaps.speedmap.containsKey(p)) {
            chestplatespeed = chestplateMaps.speedmap.get(p);
        }
        if(chestplateMaps.manamap.containsKey(p)) {
            chestplatemana = chestplateMaps.manamap.get(p);
        }
        if(chestplateMaps.cchancemap.containsKey(p)) {
            chestplatecchance = chestplateMaps.cchancemap.get(p);
        }
        if(chestplateMaps.cdamagemap.containsKey(p)) {
            chestplatecdamage = chestplateMaps.cdamagemap.get(p);
        }
        if(chestplateMaps.petluckmap.containsKey(p)) {
            chestplatepetluck = chestplateMaps.petluckmap.get(p);
        }
        if(chestplateMaps.bonusasmap.containsKey(p)) {
            chestplatebonusas = chestplateMaps.bonusasmap.get(p);
        }
        if(chestplateMaps.magicfindmap.containsKey(p)) {
            chestplatemagicfind = chestplateMaps.magicfindmap.get(p);
        }
        if(chestplateMaps.scchancemap.containsKey(p)) {
            chestplatescchance = chestplateMaps.scchancemap.get(p);
        }
        if(chestplateMaps.truedefmap.containsKey(p)) {
            chestplatetruedef = chestplateMaps.truedefmap.get(p);
        }
        if(chestplateMaps.ferocitymap.containsKey(p)) {
            chestplateferocity = chestplateMaps.ferocitymap.get(p);
        }

        double leggingshp = 0;
        double leggingsdef = 0;
        double leggingsstr = 0;
        double leggingsspeed = 0;
        double leggingsmana = 0;
        double leggingscchance = 0;
        double leggingscdamage = 0;
        double leggingspetluck = 0;
        double leggingsbonusas = 0;
        double leggingsmagicfind = 0;
        double leggingsscchance = 0;
        double leggingstruedef = 0;
        double leggingsferocity = 0;
        if(leggingsMaps.hpmap.containsKey(p)) {
            leggingshp = leggingsMaps.hpmap.get(p);
        }
        if(leggingsMaps.defmap.containsKey(p)) {
            leggingsdef = leggingsMaps.defmap.get(p);
        }
        if(leggingsMaps.strmap.containsKey(p)) {
            leggingsstr = leggingsMaps.strmap.get(p);
        }
        if(leggingsMaps.speedmap.containsKey(p)) {
            leggingsspeed = leggingsMaps.speedmap.get(p);
        }
        if(leggingsMaps.manamap.containsKey(p)) {
            leggingsmana = leggingsMaps.manamap.get(p);
        }
        if(leggingsMaps.cchancemap.containsKey(p)) {
            leggingscchance = leggingsMaps.cchancemap.get(p);
        }
        if(leggingsMaps.cdamagemap.containsKey(p)) {
            leggingscdamage = leggingsMaps.cdamagemap.get(p);
        }
        if(leggingsMaps.petluckmap.containsKey(p)) {
            leggingspetluck = leggingsMaps.petluckmap.get(p);
        }
        if(leggingsMaps.bonusasmap.containsKey(p)) {
            leggingsbonusas = leggingsMaps.bonusasmap.get(p);
        }
        if(leggingsMaps.magicfindmap.containsKey(p)) {
            leggingsmagicfind = leggingsMaps.magicfindmap.get(p);
        }
        if(leggingsMaps.scchancemap.containsKey(p)) {
            leggingsscchance = leggingsMaps.scchancemap.get(p);
        }
        if(leggingsMaps.truedefmap.containsKey(p)) {
            leggingstruedef = leggingsMaps.truedefmap.get(p);
        }
        if(leggingsMaps.ferocitymap.containsKey(p)) {
            leggingsferocity = leggingsMaps.ferocitymap.get(p);
        }
        double bootshp = 0;
        double bootsdef = 0;
        double bootsstr = 0;
        double bootsspeed = 0;
        double bootsmana = 0;
        double bootscchance = 0;
        double bootscdamage = 0;
        double bootspetluck = 0;
        double bootsbonusas = 0;
        double bootsmagicfind = 0;
        double bootsscchance = 0;
        double bootstruedef = 0;
        double bootsferocity = 0;
        if(bootsMaps.hpmap.containsKey(p)) {
            bootshp = bootsMaps.hpmap.get(p);
        }
        if(bootsMaps.defmap.containsKey(p)) {
            bootsdef = bootsMaps.defmap.get(p);
        }
        if(bootsMaps.strmap.containsKey(p)) {
            bootsstr = bootsMaps.strmap.get(p);
        }
        if(bootsMaps.speedmap.containsKey(p)) {
            bootsspeed = bootsMaps.speedmap.get(p);
        }
        if(bootsMaps.manamap.containsKey(p)) {
            bootsmana = bootsMaps.manamap.get(p);
        }
        if(bootsMaps.cchancemap.containsKey(p)) {
            bootscchance = bootsMaps.cchancemap.get(p);
        }
        if(bootsMaps.cdamagemap.containsKey(p)) {
            bootscdamage = bootsMaps.cdamagemap.get(p);
        }
        if(bootsMaps.petluckmap.containsKey(p)) {
            bootspetluck = bootsMaps.petluckmap.get(p);
        }
        if(bootsMaps.bonusasmap.containsKey(p)) {
            bootsbonusas = bootsMaps.bonusasmap.get(p);
        }
        if(bootsMaps.magicfindmap.containsKey(p)) {
            bootsmagicfind = bootsMaps.magicfindmap.get(p);
        }
        if(bootsMaps.scchancemap.containsKey(p)) {
            bootsscchance = bootsMaps.scchancemap.get(p);
        }
        if(bootsMaps.truedefmap.containsKey(p)) {
            bootstruedef = bootsMaps.truedefmap.get(p);
        }
        if(helmetMaps.ferocitymap.containsKey(p)) {
            helmetferocity = helmetMaps.ferocitymap.get(p);
        }

        File file = new File("plugins//HPSBR//stats//" + p.getUniqueId() +".yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

        yaml.set("weaponhp", weaponhp);
        yaml.set("weapondef", weapondef);
        yaml.set("weaponstr", weaponstr);
        yaml.set("weaponspeed", weaponspeed);
        yaml.set("weaponmana", weaponmana);
        yaml.set("weaponcchance", weaponcchance);
        yaml.set("weaponcdamage", weaponcdamage);
        yaml.set("weaponpetluck", weaponpetluck);
        yaml.set("weaponbonusas", weaponbonusas);
        yaml.set("weaponmagicfind", weaponmagicfind);
        yaml.set("weaponscchance", weaponscchance);
        yaml.set("weapontruedef", weapontruedef);
        yaml.set("weaponferocity", weaponferocity);

        yaml.set("helmethp", helmethp);
        yaml.set("helmetdef", helmetdef);
        yaml.set("helmetstr", helmetstr);
        yaml.set("helmetspeed", helmetspeed);
        yaml.set("helmetmana", helmetmana);
        yaml.set("helmetcchance", helmetcchance);
        yaml.set("helmetcdamage", helmetcdamage);
        yaml.set("helmetpetluck", helmetpetluck);
        yaml.set("helmetbonusas", helmetbonusas);
        yaml.set("helmetmagicfind", helmetmagicfind);
        yaml.set("helmetscchance", helmetscchance);
        yaml.set("helmettruedef", helmettruedef);
        yaml.set("helmetferocity", helmetferocity);

        yaml.set("chestplatehp", chestplatehp);
        yaml.set("chestplatedef", chestplatedef);
        yaml.set("chestplatestr", chestplatestr);
        yaml.set("chestplatespeed", chestplatespeed);
        yaml.set("chestplatemana", chestplatemana);
        yaml.set("chestplatecchance", chestplatecchance);
        yaml.set("chestplatecdamage", chestplatecdamage);
        yaml.set("chestplatepetluck", chestplatepetluck);
        yaml.set("chestplatebonusas", chestplatebonusas);
        yaml.set("chestplatemagicfind", chestplatemagicfind);
        yaml.set("chestplatescchance", chestplatescchance);
        yaml.set("chestplatetruedef", chestplatetruedef);
        yaml.set("chestplateferocity", chestplateferocity);

        yaml.set("leggingshp", leggingshp);
        yaml.set("leggingsdef", leggingsdef);
        yaml.set("leggingsstr", leggingsstr);
        yaml.set("leggingsspeed", leggingsspeed);
        yaml.set("leggingsmana", leggingsmana);
        yaml.set("leggingscchance", leggingscchance);
        yaml.set("leggingscdamage", leggingscdamage);
        yaml.set("leggingspetluck", leggingspetluck);
        yaml.set("leggingsbonusas", leggingsbonusas);
        yaml.set("leggingsmagicfind", leggingsmagicfind);
        yaml.set("leggingsscchance", leggingsscchance);
        yaml.set("leggingstruedef", leggingstruedef);
        yaml.set("leggingsferocity", leggingsferocity);

        yaml.set("bootshp", bootshp);
        yaml.set("bootsdef", bootsdef);
        yaml.set("bootsstr", bootsstr);
        yaml.set("bootsspeed", bootsspeed);
        yaml.set("bootsmana", bootsmana);
        yaml.set("bootscchance", bootscchance);
        yaml.set("bootscdamage", bootscdamage);
        yaml.set("bootspetluck", bootspetluck);
        yaml.set("bootsbonusas", bootsbonusas);
        yaml.set("bootsmagicfind", bootsmagicfind);
        yaml.set("bootsscchance", bootsscchance);
        yaml.set("bootstruedef", bootstruedef);
        yaml.set("bootsferocity", bootsferocity);

        try {
            yaml.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
