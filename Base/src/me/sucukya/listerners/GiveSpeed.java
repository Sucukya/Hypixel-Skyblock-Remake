//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.listerners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import me.sucukya.playerStats.calculateStat;

public class GiveSpeed {

    public static void give() {
            for(Player p : Bukkit.getOnlinePlayers()) {
                double speed = calculateStat.calculate(p,"speed");
                double speed2 = (speed/1000) + 0.2;
                double speed3 = (speed/1000) + 0.1;
                if(speed <= 100)  {
                    p.setWalkSpeed((float) speed3);
                } else {
                    p.setWalkSpeed((float) speed2);
                }
            }
        }

}
