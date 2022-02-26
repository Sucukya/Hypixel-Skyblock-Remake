//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.armor;

import java.util.HashMap;
import java.util.Map;

public class Wise {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("hp",6);
            map.put("speed",1);
            map.put("mana",25);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("hp",8);
            map.put("speed",1);
            map.put("mana",50);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("hp",10);
            map.put("speed",1);
            map.put("mana",75);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("hp",12);
            map.put("speed",1);
            map.put("mana",100);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("hp",15);
            map.put("speed",1);
            map.put("mana",125);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("hp",18);
            map.put("speed",1);
            map.put("mana",150);
        }
        return map;
    }
}
