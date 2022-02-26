//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.sword;

import java.util.HashMap;
import java.util.Map;

public class Odd {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("cchance",12);
            map.put("cdamage",10);
            map.put("intel",-5);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("cchance",15);
            map.put("cdamage",15);
            map.put("intel",-10);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("cchance",20);
            map.put("cdamage",22);
            map.put("intel",-16);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("cchance",25);
            map.put("cdamage",30);
            map.put("intel",-24);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("cchance",30);
            map.put("cdamage",40);
            map.put("intel",-36);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("cchance",35);
            map.put("cdamage",50);
            map.put("intel",-48);
        }
        return map;
    }

}
