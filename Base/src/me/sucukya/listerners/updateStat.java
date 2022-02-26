//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.listerners;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class updateStat {

    public static void update(Player p,String stat) {
        if(stat.equalsIgnoreCase("basehp")) {
            NBTItem nbti = new NBTItem(p.getInventory().getItemInOffHand());
            int basehp = nbti.getInteger("basehp");
            int bonushp = nbti.getInteger("bonushp");
            int chp = bonushp + basehp;
            nbti.setInteger("chp", chp);
            ItemStack stack;
            stack = nbti.getItem();
            p.getInventory().setItemInOffHand(stack);
        }


    }

}
