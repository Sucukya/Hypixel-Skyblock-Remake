//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.armor;

import java.util.HashMap;
import java.util.Map;

public class Light {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("def",1);
            map.put("hp",5);
            map.put("speed",1);
            map.put("cchance",1);
            map.put("cdamage",1);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("def",2);
            map.put("hp",7);
            map.put("speed",2);
            map.put("cchance",1);
            map.put("cdamage",2);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("def",3);
            map.put("hp",10);
            map.put("speed",3);
            map.put("cchance",2);
            map.put("cdamage",3);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("def",4);
            map.put("hp",15);
            map.put("speed",4);
            map.put("cchance",2);
            map.put("cdamage",4);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("def",5);
            map.put("hp",20);
            map.put("speed",5);
            map.put("cchance",3);
            map.put("cdamage",5);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("def",6);
            map.put("hp",25);
            map.put("speed",6);
            map.put("cchance",4);
            map.put("cdamage",6);
        }
        return map;
    }
}
