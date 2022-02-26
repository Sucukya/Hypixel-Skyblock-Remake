//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.listerners;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public class updateHealthBar{

    public static void update(Player p) {
        p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
        NBTItem nbti = new NBTItem(p.getInventory().getItemInOffHand());
        int base = nbti.getInteger("basehp");
        int bonus = nbti.getInteger("bonushp");
        int hp = base + bonus;
        int chp = nbti.getInteger("chp");
        int health = chp / (hp/20);
        if(health > 20) {
            p.setHealth(20);
            health = 20;
        }
        p.setHealth(health);


    }

}
