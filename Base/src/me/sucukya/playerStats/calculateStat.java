//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.playerStats;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.entity.Player;

public class calculateStat {

    public static int calculate(Player p, String stattocalc) {
        NBTItem nbti = new NBTItem(p.getInventory().getItemInOffHand());
        int base = nbti.getInteger("base" + stattocalc);
        int bonus = nbti.getInteger("bonus" + stattocalc);
        int stat = base + bonus;
        return stat;
    }


}
