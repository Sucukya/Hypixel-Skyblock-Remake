//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.sword;

import java.util.HashMap;
import java.util.Map;

public class Epic {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("cdamage",10);
            map.put("str",15);
            map.put("aspeed",1);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("cdamage",15);
            map.put("str",20);
            map.put("aspeed",2);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("cdamage",20);
            map.put("str",25);
            map.put("aspeed",4);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("cdamage",27);
            map.put("str",32);
            map.put("aspeed",7);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("cdamage",35);
            map.put("str",40);
            map.put("aspeed",10);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("cdamage",43);
            map.put("str",48);
            map.put("aspeed",13);
        }
        return map;
    }

}
