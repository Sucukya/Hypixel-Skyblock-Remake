//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.armor;

import java.util.HashMap;
import java.util.Map;

public class Fierce {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("str",2);
            map.put("cchance",2);
            map.put("cdamage",4);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("str",4);
            map.put("cchance",3);
            map.put("cdamage",7);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("str",6);
            map.put("cchance",4);
            map.put("cdamage",10);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("str",8);
            map.put("cchance",5);
            map.put("cdamage",14);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("str",10);
            map.put("cchance",6);
            map.put("cdamage",18);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("str",12);
            map.put("cchance",7);
            map.put("cdamage",22);
        }
        return map;
    }
}
