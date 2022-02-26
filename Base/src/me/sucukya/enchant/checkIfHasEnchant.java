//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.enchant;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.inventory.ItemStack;

public class checkIfHasEnchant{

    public static boolean check(ItemStack stack, String ench) {
        boolean has = false;
        NBTItem nbti = new NBTItem(stack);
        if(nbti.getKeys().contains(ench)) {
            has = true;
        } else {
            has = false;
        }
        return has;
    }


}
