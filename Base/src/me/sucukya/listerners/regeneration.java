//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.listerners;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Main;
import me.sucukya.playerStats.calculateStat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.text.DecimalFormat;

public class regeneration {

    public static void regen() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getMain(), new Runnable() {

            @Override
            public void run() {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    ItemStack stack = all.getInventory().getItemInOffHand();
                    NBTItem nbti = new NBTItem(stack);
                    int chp = nbti.getInteger("chp");
                    int hp = me.sucukya.playerStats.calculateStat.calculate(all,"hp");
                    double regen2 = (calculateStat.calculate(all,"hp") / 100) + 1.5;
                    if(chp < hp) {
                        chp = (int) (chp + regen2);
                        if (chp > hp) {
                            nbti.setInteger("chp", hp);
                            stack = nbti.getItem();
                            all.getInventory().setItemInOffHand(stack);
                        } else {
                            nbti.setInteger("chp", chp);
                            stack = nbti.getItem();
                            all.getInventory().setItemInOffHand(stack);
                        }
                    }
                }
            }
        },40L,40L);
    }

}
