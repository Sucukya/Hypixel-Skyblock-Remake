//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.sword;

import java.util.HashMap;
import java.util.Map;

public class Gentle {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("str",3);
            map.put("aspeed",8);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("str",5);
            map.put("aspeed",10);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("str",7);
            map.put("aspeed",15);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("str",10);
            map.put("aspeed",20);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("str",15);
            map.put("aspeed",25);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("str",20);
            map.put("aspeed",30);
        }

        return map;
    }

}
