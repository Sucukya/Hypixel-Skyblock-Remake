//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.location;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class CheckLocation{

    public static HashMap<Player,String> locMap = new HashMap();
    public static HashMap<Player,String> locMap2 = new HashMap();


    public static void check(Player p) {
        NBTItem nbti = new NBTItem(p.getInventory().getItemInOffHand());
        double playerX = p.getLocation().getX();
        double playerZ = p.getLocation().getZ();
        double playerY = p.getLocation().getY();
        boolean isInArea = false;

        if(p.getLocation().getWorld().getName().equalsIgnoreCase("world")) {
            if ((playerX >= -58 && playerX <= -19) && (playerZ >= -100 && playerZ <= -79) && (playerY >= 51 && playerY <= 91)) {
                isInArea = true;
                locMap.put(p, "§6Auction House");
                locMap2.put(p, "ah");
            } else if ((playerX >= -43 && playerX <= -19) && (playerZ >= -78 && playerZ <= -70) && (playerY >= 70 && playerY <= 150)) {
                isInArea = true;
                locMap.put(p, "§eBazaar Alley");
                locMap2.put(p, "ba");
            } else if ((playerX >= -56 && playerX <= -20) && (playerZ >= -65 && playerZ <= -56) && (playerY >= 64 && playerY <= 93)) {
                isInArea = true;
                locMap.put(p, "§6Bank");
                locMap2.put(p, "bank");
            } else if ((playerX >= -4 && playerX <= 13) && (playerZ >= -113 && playerZ <= -98) && (playerY >= 63 && playerY <= 86)) {
                isInArea = true;
                locMap.put(p, "§bCommunity Center");
                locMap2.put(p, "cc");
            } else if ((playerX >= -9 && playerX <= 19) && (playerZ >= -134 && playerZ <= -105) && (playerY >= 41 && playerY <= 61)) {
                isInArea = true;
                locMap.put(p, "§bElection Room");
                locMap2.put(p, "er");
            } else if ((playerX >= 16 && playerX <= 29) && (playerZ >= -77 && playerZ <= -59) && (playerY >= 59 && playerY <= 100)) {
                isInArea = true;
                locMap.put(p, "§bFarm House");
                locMap2.put(p, "fh");
            } else if ((playerX >= -34 && playerX <= -23) && (playerZ >= -135 && playerZ <= -121) && (playerY >= 69 && playerY <= 100)) {
                isInArea = true;
                locMap.put(p, "§bBlacksmith");
                locMap2.put(p, "bs");
            } else if ((playerX >= -207 && playerX <= -69) && (playerZ >= -220 && playerZ <= -81) && (playerY >= 69 && playerY <= 100)) {
                isInArea = true;
                locMap.put(p, "§cGraveyard");
                locMap2.put(p, "gy");
            } else if ((playerX >= 19 && playerX <= 29) && (playerZ >= -46 && playerZ <= -35) && (playerY >= 60 && playerY <= 82)) {
                isInArea = true;
                locMap.put(p, "§bFashion Shop");
                locMap2.put(p, "fs");
            } else if ((playerX >= -80 && playerX <= 67) && (playerZ >= 117 && playerZ <= 210) && (playerY >= 20 && playerY <= 100)) {
                isInArea = true;
                locMap.put(p, "§cHigh Level");
                locMap2.put(p, "hl");
            } else if ((playerX >= 33 && playerX <= 52) && (playerZ >= 64 && playerZ <= 83) && (playerY >= 64 && playerY <= 166)) {
                isInArea = true;
                locMap.put(p, "§dWizard Tower");
                locMap2.put(p, "wizardtower");
            } else if ((playerX >= 68 && playerX <= 174) && (playerZ >= -17 && playerZ <= 202) && (playerY >= 50 && playerY <= 100)) {
                isInArea = true;
                locMap.put(p, "§2Wilderness");
                locMap2.put(p, "wild");
            } else if ((playerX >= 102 && playerX <= 156) && (playerZ >= -75 && playerZ <= -27) && (playerY >= 66 && playerY <= 71)) {
                isInArea = true;
                locMap.put(p, "§bColosseum Arena");
                locMap2.put(p, "colosseuma");
            } else if ((playerX >= 78 && playerX <= 169) && (playerZ >= -94 && playerZ <= -18) && (playerY >= 55 && playerY <= 100)) {
                isInArea = true;
                locMap.put(p, "§bColosseum");
                locMap2.put(p, "colosseum");
            } else if ((playerX >= 13 && playerX <= 83) && (playerZ >= -189 && playerZ <= -116) && (playerY >= 67 && playerY <= 92)) {
                isInArea = true;
                locMap.put(p, "§bFarm");
                locMap2.put(p, "farm");
            } else if ((playerX >= -41 && playerX <= -31) && (playerZ >= -115 && playerZ <= -105) && (playerY >= 62 && playerY <= 76)) {
                isInArea = true;
                locMap.put(p, "§bLibrary");
                locMap2.put(p, "library");
            } else if ((playerX >= -228 && playerX <= -93) && (playerZ >= -78 && playerZ <= 17) && (playerY >= 61 && playerY <= 97)) {
                isInArea = true;
                locMap.put(p, "§bForest");
                locMap2.put(p, "forest");
            } else if ((playerX >= -80 && playerX <= 67) && (playerZ >= 0 && playerZ <= 116) && (playerY >= 60 && playerY <= 240)) {
                isInArea = true;
                locMap.put(p, "§bMountain");
                locMap2.put(p, "mountain");
            } else if ((playerX >= -82 && playerX <= -225) && (playerZ >= 23 && playerZ <= 161) && (playerY >= 20 && playerY <= 200)) {
                isInArea = true;
                locMap.put(p, "§bRuins");
                locMap2.put(p, "ruins");
            } else if ((playerX >= -91 && playerX <= -76) && (playerZ >= -141 && playerZ <= -114) && (playerY >= 51 && playerY <= 63)) {
                isInArea = true;
                locMap.put(p, "§cDungeons Entrance");
                locMap2.put(p, "dungeonsentrance");
            } else if ((playerX >= -200 && playerX <= -34) && (playerZ >= -147 && playerZ <= -73) && (playerY >= 32 && playerY <= 68)) {
                isInArea = true;
                locMap.put(p, "§bCoal Mines");
                locMap2.put(p, "cm");
            } else if ((playerX >= -69 && playerX <= 9) && (playerZ >= -231 && playerZ <= -120) && (playerY >= 32 && playerY <= 102)) {
                isInArea = true;
                locMap.put(p, "§bCoal Mines");
                locMap2.put(p, "cm2");
            } else if ((playerX >= -62 && playerX <= 51) && (playerZ >= -135 && playerZ <= -1) && (playerY >= 20 && playerY <= 100)) {
                isInArea = true;
                locMap.put(p, "§bVillage");
                locMap2.put(p, "v");
            }
        } else if(p.getLocation().getWorld().getName().equalsIgnoreCase("map_" + p.getUniqueId().toString() + "_" + nbti.getInteger("profile"))) {
            isInArea = true;
            locMap.put(p, "§aYour Island");
            locMap2.put(p, "pisland");
        }

        if(p.getLocation().getWorld().equals(Bukkit.getWorld("world")) && !isInArea) {
            locMap.put(p,"§7None");
        }

    }

}
