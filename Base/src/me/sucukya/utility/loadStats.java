//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.utility;

import me.sucukya.playerStats.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class loadStats {

    public static void load(Player p) {
        File file = new File("plugins//HPSBR//stats//" + p.getUniqueId() + ".yml");
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);

        double weaponhp = conf.getDouble("weaponhp");
        double weapondef = conf.getDouble("weapondef");
        double weaponstr = conf.getDouble("weaponstr");
        double weaponspeed = conf.getDouble("weaponspeed");
        double weaponmana = conf.getDouble("weaponmana");
        double weaponcchance = conf.getDouble("weaponcchance");
        Double weaponcdamage = conf.getDouble("weaponcdamage");
        Double weaponpetluck = conf.getDouble("weaponpetluck");
        Double weaponbonusas = conf.getDouble("weaponbonusas");
        Double weaponmagicfind = conf.getDouble("weaponmagicfind");
        Double weaponscchance = conf.getDouble("weaponscchance");
        Double weapontruedef = conf.getDouble("weapontruedef");
        Double weaponferocity = conf.getDouble("weaponferocity");

        Double helmethp = conf.getDouble("helmethp");
        double helmetdef = conf.getDouble("helmetdef");
        Double helmetstr = conf.getDouble("helmetstr");
        Double helmetspeed = conf.getDouble("helmetspeed");
        Double helmetmana = conf.getDouble("helmetmana");
        Double helmetcchance = conf.getDouble("helmetcchance");
        Double helmetcdamage = conf.getDouble("helmetcdamage");
        Double helmetpetluck = conf.getDouble("helmetpetluck");
        Double helmetbonusas = conf.getDouble("helmetbonusas");
        Double helmetmagicfind = conf.getDouble("helmetmagicfind");
        Double helmetscchance = conf.getDouble("helmetscchance");
        Double helmettruedef = conf.getDouble("helmettruedef");
        Double helmetferocity = conf.getDouble("helmetferocity");

        Double chestplatehp = conf.getDouble("chestplatehp");
        double chestplatedef = conf.getDouble("chestplatedef");
        Double chestplatestr = conf.getDouble("chestplatestr");
        Double chestplatespeed = conf.getDouble("chestplatespeed");
        Double chestplatemana = conf.getDouble("chestplatemana");
        Double chestplatecchance = conf.getDouble("chestplatecchance");
        Double chestplatecdamage = conf.getDouble("chestplatecdamage");
        Double chestplatepetluck = conf.getDouble("chestplatepetluck");
        Double chestplatebonusas = conf.getDouble("chestplatebonusas");
        Double chestplatemagicfind = conf.getDouble("chestplatemagicfind");
        Double chestplatescchance = conf.getDouble("chestplatescchance");
        Double chestplatetruedef = conf.getDouble("chestplatetruedef");
        Double chestplateferocity = conf.getDouble("chestplateferocity");

        Double leggingshp = conf.getDouble("leggingshp");
        double leggingsdef = conf.getDouble("leggingsdef");
        Double leggingsstr = conf.getDouble("leggingsstr");
        Double leggingsspeed = conf.getDouble("leggingsspeed");
        Double leggingsmana = conf.getDouble("leggingsmana");
        Double leggingscchance = conf.getDouble("leggingscchance");
        Double leggingscdamage = conf.getDouble("leggingscdamage");
        Double leggingspetluck = conf.getDouble("leggingspetluck");
        Double leggingsbonusas = conf.getDouble("leggingsbonusas");
        Double leggingsmagicfind = conf.getDouble("leggingsmagicfind");
        Double leggingsscchance = conf.getDouble("leggingsscchance");
        Double leggingstruedef = conf.getDouble("leggingstruedef");
        Double leggingsferocity = conf.getDouble("leggingsferocity");

        Double bootshp = conf.getDouble("bootshp");
        double bootsdef = conf.getDouble("bootsdef");
        Double bootsstr = conf.getDouble("bootsstr");
        Double bootsspeed = conf.getDouble("bootsspeed");
        Double bootsmana = conf.getDouble("bootsmana");
        Double bootscchance = conf.getDouble("bootscchance");
        Double bootscdamage = conf.getDouble("bootscdamage");
        Double bootspetluck = conf.getDouble("bootspetluck");
        Double bootsbonusas = conf.getDouble("bootsbonusas");
        Double bootsmagicfind = conf.getDouble("bootsmagicfind");
        Double bootsscchance = conf.getDouble("bootsscchance");
        Double bootstruedef = conf.getDouble("bootstruedef");
        Double bootsferocity = conf.getDouble("bootsferocity");

        weaponMaps.hpmap.put(p,weaponhp);
        weaponMaps.defmap.put(p,weapondef);
        weaponMaps.strmap.put(p,weaponstr);
        weaponMaps.speedmap.put(p,weaponspeed);
        weaponMaps.manamap.put(p,weaponmana);
        weaponMaps.cchancemap.put(p,weaponcchance);
        weaponMaps.cdamagemap.put(p,weaponcdamage);
        weaponMaps.petluckmap.put(p,weaponpetluck);
        weaponMaps.bonusasmap.put(p,weaponbonusas);
        weaponMaps.magicfindmap.put(p,weaponmagicfind);
        weaponMaps.scchancemap.put(p,weaponscchance);
        weaponMaps.truedefmap.put(p,weapontruedef);
        weaponMaps.ferocitymap.put(p,weapontruedef);

        helmetMaps.hpmap.put(p,helmethp);
        helmetMaps.defmap.put(p,helmetdef);
        helmetMaps.strmap.put(p,helmetstr);
        helmetMaps.speedmap.put(p,helmetspeed);
        helmetMaps.manamap.put(p,helmetmana);
        helmetMaps.cchancemap.put(p,helmetcchance);
        helmetMaps.cdamagemap.put(p,helmetcdamage);
        helmetMaps.petluckmap.put(p,helmetpetluck);
        helmetMaps.bonusasmap.put(p,helmetbonusas);
        helmetMaps.magicfindmap.put(p,helmetmagicfind);
        helmetMaps.scchancemap.put(p,helmetscchance);
        helmetMaps.truedefmap.put(p,helmettruedef);
        helmetMaps.ferocitymap.put(p,weapontruedef);

        chestplateMaps.hpmap.put(p,chestplatehp);
        chestplateMaps.defmap.put(p,chestplatedef);
        chestplateMaps.strmap.put(p,chestplatestr);
        chestplateMaps.speedmap.put(p,chestplatespeed);
        chestplateMaps.manamap.put(p,chestplatemana);
        chestplateMaps.cchancemap.put(p,chestplatecchance);
        chestplateMaps.cdamagemap.put(p,chestplatecdamage);
        chestplateMaps.petluckmap.put(p,chestplatepetluck);
        chestplateMaps.bonusasmap.put(p,chestplatebonusas);
        chestplateMaps.magicfindmap.put(p,chestplatemagicfind);
        chestplateMaps.scchancemap.put(p,chestplatescchance);
        chestplateMaps.truedefmap.put(p,chestplatetruedef);
        chestplateMaps.ferocitymap.put(p,weapontruedef);

        leggingsMaps.hpmap.put(p,leggingshp);
        leggingsMaps.defmap.put(p,leggingsdef);
        leggingsMaps.strmap.put(p,leggingsstr);
        leggingsMaps.speedmap.put(p,leggingsspeed);
        leggingsMaps.manamap.put(p,leggingsmana);
        leggingsMaps.cchancemap.put(p,leggingscchance);
        leggingsMaps.cdamagemap.put(p,leggingscdamage);
        leggingsMaps.petluckmap.put(p,leggingspetluck);
        leggingsMaps.bonusasmap.put(p,leggingsbonusas);
        leggingsMaps.magicfindmap.put(p,leggingsmagicfind);
        leggingsMaps.scchancemap.put(p,leggingsscchance);
        leggingsMaps.truedefmap.put(p,leggingstruedef);
        leggingsMaps.ferocitymap.put(p,weapontruedef);

        bootsMaps.hpmap.put(p,bootshp);
        bootsMaps.defmap.put(p,bootsdef);
        bootsMaps.strmap.put(p,bootsstr);
        bootsMaps.speedmap.put(p,bootsspeed);
        bootsMaps.manamap.put(p,bootsmana);
        bootsMaps.cchancemap.put(p,bootscchance);
        bootsMaps.cdamagemap.put(p,bootscdamage);
        bootsMaps.petluckmap.put(p,bootspetluck);
        bootsMaps.bonusasmap.put(p,bootsbonusas);
        bootsMaps.magicfindmap.put(p,bootsmagicfind);
        bootsMaps.scchancemap.put(p,bootsscchance);
        bootsMaps.truedefmap.put(p,bootstruedef);
        bootsMaps.ferocitymap.put(p,weapontruedef);
    }

}
