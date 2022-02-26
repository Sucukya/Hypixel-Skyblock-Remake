//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.sword;

import java.util.HashMap;
import java.util.Map;

public class Legendary {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("cchance",5);
            map.put("cdamage",5);
            map.put("intel",5);
            map.put("str",3);
            map.put("aspeed",2);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("cchance",7);
            map.put("cdamage",10);
            map.put("intel",8);
            map.put("str",7);
            map.put("aspeed",3);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("cchance",9);
            map.put("cdamage",15);
            map.put("intel",12);
            map.put("str",12);
            map.put("aspeed",5);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("cchance",12);
            map.put("cdamage",22);
            map.put("intel",18);
            map.put("str",18);
            map.put("aspeed",7);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("cchance",15);
            map.put("cdamage",28);
            map.put("intel",25);
            map.put("str",25);
            map.put("aspeed",10);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("cchance",18);
            map.put("cdamage",34);
            map.put("intel",32);
            map.put("str",32);
            map.put("aspeed",13);
        }
        return map;
    }

}
