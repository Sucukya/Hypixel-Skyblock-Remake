//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.armor;

import java.util.HashMap;
import java.util.Map;

public class Smart {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("hp",4);
            map.put("def",4);
            map.put("mana",20);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("hp",6);
            map.put("def",6);
            map.put("mana",40);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("hp",9);
            map.put("def",9);
            map.put("mana",60);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("hp",12);
            map.put("def",12);
            map.put("mana",80);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("hp",15);
            map.put("def",15);
            map.put("mana",100);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("hp",18);
            map.put("def",18);
            map.put("mana",120);
        }
        return map;
    }
}
