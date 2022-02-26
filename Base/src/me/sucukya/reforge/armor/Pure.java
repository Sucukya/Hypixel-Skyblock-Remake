//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.armor;

import java.util.HashMap;
import java.util.Map;

public class Pure {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("str",2);
            map.put("def",2);
            map.put("hp",2);
            map.put("speed",1);
            map.put("cchance",2);
            map.put("cdamage",2);
            map.put("mana",2);
            map.put("aspeed",1);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("str",3);
            map.put("def",3);
            map.put("hp",3);
            map.put("speed",1);
            map.put("cchance",4);
            map.put("cdamage",3);
            map.put("mana",3);
            map.put("aspeed",1);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("str",4);
            map.put("def",4);
            map.put("hp",4);
            map.put("speed",1);
            map.put("cchance",6);
            map.put("cdamage",4);
            map.put("mana",4);
            map.put("aspeed",2);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("str",6);
            map.put("def",6);
            map.put("hp",6);
            map.put("speed",1);
            map.put("cchance",8);
            map.put("cdamage",6);
            map.put("mana",6);
            map.put("aspeed",3);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("str",8);
            map.put("def",8);
            map.put("hp",8);
            map.put("speed",1);
            map.put("cchance",10);
            map.put("cdamage",8);
            map.put("mana",8);
            map.put("aspeed",4);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("str",2);
            map.put("def",2);
            map.put("hp",2);
            map.put("speed",1);
            map.put("cchance",12);
            map.put("cdamage",10);
            map.put("mana",10);
            map.put("aspeed",6);
        }
        return map;
    }
}
