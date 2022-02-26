//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.sword;

import java.util.HashMap;
import java.util.Map;

public class Sharp {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("cchance",10);
            map.put("cdamage",20);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("cchance",12);
            map.put("cdamage",30);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("cchance",14);
            map.put("cdamage",40);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("cchance",17);
            map.put("cdamage",55);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("cchance",20);
            map.put("cdamage",75);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("cchance",23);
            map.put("cdamage",95);
        }
        return map;
    }

}
