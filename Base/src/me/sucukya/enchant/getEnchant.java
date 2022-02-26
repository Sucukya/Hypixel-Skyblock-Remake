//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.enchant;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.InvocationTargetException;

public class getEnchant {


    public static void get(String enchant, int level, Player p, ItemStack stack) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
                String ench = enchant.substring(0, 1).toUpperCase() + enchant.substring(1);
                String methodName = "doEnchant";
                Object arg1 = p;
                Object arg2 = stack;
                Object arg3 = level;
                Class.forName("me.sucukya.enchant.enchantments." + ench).getDeclaredMethod(methodName,Player.class,ItemStack.class, Integer.class).invoke(null, arg1,arg2,arg3);
    }

}
