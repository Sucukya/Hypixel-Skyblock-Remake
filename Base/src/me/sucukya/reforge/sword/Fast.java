//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.sword;

import java.util.HashMap;
import java.util.Map;

public class Fast {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("aspeed",10);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("aspeed",120);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("aspeed",30);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("aspeed",40);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("aspeed",50);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("aspeed",60);
        }
        return map;
    }

}
