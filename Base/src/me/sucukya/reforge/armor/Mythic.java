//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.armor;

import java.util.HashMap;
import java.util.Map;

public class Mythic {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("str",2);
            map.put("def",2);
            map.put("hp",2);
            map.put("speed",2);
            map.put("cchance",1);
            map.put("mana",20);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("str",4);
            map.put("def",4);
            map.put("hp",4);
            map.put("speed",2);
            map.put("cchance",2);
            map.put("mana",25);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("str",6);
            map.put("def",6);
            map.put("hp",6);
            map.put("speed",2);
            map.put("cchance",3);
            map.put("mana",30);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("str",8);
            map.put("def",8);
            map.put("hp",8);
            map.put("speed",2);
            map.put("cchance",4);
            map.put("mana",40);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("str",10);
            map.put("def",10);
            map.put("hp",10);
            map.put("speed",2);
            map.put("cchance",5);
            map.put("mana",50);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("str",12);
            map.put("def",12);
            map.put("hp",12);
            map.put("speed",2);
            map.put("cchance",6);
            map.put("mana",60);
        }
        return map;
    }
}
