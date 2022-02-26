//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.armor;

import java.util.HashMap;
import java.util.Map;

public class Titanic {

    public static Map get(String rarity) {
        HashMap<String,Integer> map = new HashMap<>();

        if(rarity.equalsIgnoreCase("common")) {
            map.put("def",10);
            map.put("hp",10);
        } else if(rarity.equalsIgnoreCase("uncommon")) {
            map.put("def",15);
            map.put("hp",15);
        } else if(rarity.equalsIgnoreCase("rare")) {
            map.put("def",20);
            map.put("hp",20);
        } else if(rarity.equalsIgnoreCase("epic")) {
            map.put("def",25);
            map.put("hp",25);
        } else if(rarity.equalsIgnoreCase("legendary")) {
            map.put("def",35);
            map.put("hp",35);
        } else if(rarity.equalsIgnoreCase("mythic")) {
            map.put("def",45);
            map.put("hp",45);
        }
        return map;
    }
}
