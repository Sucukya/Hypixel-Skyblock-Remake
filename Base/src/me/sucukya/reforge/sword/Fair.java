//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.sword;

import java.util.HashMap;
import java.util.Map;

public class Fair {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("cchance",2);
            map.put("cdamage",2);
            map.put("intel",2);
            map.put("str",2);
            map.put("aspeed",2);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("cchance",3);
            map.put("cdamage",3);
            map.put("intel",3);
            map.put("str",3);
            map.put("aspeed",3);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("cchance",4);
            map.put("cdamage",4);
            map.put("intel",4);
            map.put("str",4);
            map.put("aspeed",4);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("cchance",7);
            map.put("cdamage",7);
            map.put("intel",7);
            map.put("str",7);
            map.put("aspeed",7);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("cchance",10);
            map.put("cdamage",10);
            map.put("intel",10);
            map.put("str",10);
            map.put("aspeed",10);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("cchance",13);
            map.put("cdamage",13);
            map.put("intel",13);
            map.put("str",13);
            map.put("aspeed",13);
        }
        return map;
    }

}
