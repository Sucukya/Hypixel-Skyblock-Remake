//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.armor;

import java.util.HashMap;
import java.util.Map;

public class Clean {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("hp",5);
            map.put("def",5);
            map.put("cchance",2);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("hp",7);
            map.put("def",7);
            map.put("cchance",4);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("hp",10);
            map.put("def",10);
            map.put("cchance",6);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("hp",12);
            map.put("def",12);
            map.put("cchance",8);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("hp",15);
            map.put("def",15);
            map.put("cchance",10);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("hp",18);
            map.put("def",18);
            map.put("cchance",12);
        }
        return map;
    }
}
