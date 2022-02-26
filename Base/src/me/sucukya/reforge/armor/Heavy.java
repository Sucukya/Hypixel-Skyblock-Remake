//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.armor;

import java.util.HashMap;
import java.util.Map;

public class Heavy {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("def",25);
            map.put("speed",-1);
            map.put("cdamage",-1);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("def",35);
            map.put("speed",-1);
            map.put("cdamage",-2);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("def",50);
            map.put("speed",-1);
            map.put("cdamage",-3);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("def",65);
            map.put("speed",-1);
            map.put("cdamage",-4);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("def",80);
            map.put("speed",-1);
            map.put("cdamage",-5);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("def",95);
            map.put("speed",-1);
            map.put("cdamage",-6);
        }
        return map;
    }
}
