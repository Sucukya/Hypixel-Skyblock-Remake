//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.sword;

import java.util.HashMap;
import java.util.Map;

public class Spicy {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();


        if(rarity.equalsIgnoreCase("common")) {
            map.put("cchance",1);
            map.put("cdamage",25);
            map.put("aspeed",1);
            map.put("str",2);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("cchance",1);
            map.put("cdamage",35);
            map.put("aspeed",2);
            map.put("str",3);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("cchance",1);
            map.put("cdamage",45);
            map.put("aspeed",4);
            map.put("str",4);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("cchance",1);
            map.put("cdamage",60);
            map.put("aspeed",7);
            map.put("str",7);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("cchance",1);
            map.put("cdamage",80);
            map.put("aspeed",10);
            map.put("str",10);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("cchance",1);
            map.put("cdamage",100);
            map.put("aspeed",13);
            map.put("str",13);
        }
        return map;
    }

}
