//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.sword;

import java.util.HashMap;
import java.util.Map;

public class Heroic {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("intel",40);
            map.put("str",15);
            map.put("aspeed",1);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("intel",50);
            map.put("str",20);
            map.put("aspeed",2);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("intel",65);
            map.put("str",25);
            map.put("aspeed",2);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("intel",80);
            map.put("str",32);
            map.put("aspeed",3);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("intel",100);
            map.put("str",40);
            map.put("aspeed",5);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("intel",120);
            map.put("str",48);
            map.put("aspeed",7);
        }
        return map;
    }

}
