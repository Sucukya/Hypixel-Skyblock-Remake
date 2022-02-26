//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.utility;

import me.sucukya.Main;

import java.util.HashMap;

public class getEnchant {

    public static String getEnchant(String enchantID) {
        String enchant = Main.enchants.get(enchantID);
        return enchant;
    }


}
