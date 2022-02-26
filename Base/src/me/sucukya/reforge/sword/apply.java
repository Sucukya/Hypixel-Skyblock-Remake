//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.sword;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class apply {

    public static void apply(ItemStack stack, String reforge, Player p, Inventory inv) {
        NBTItem nbti = new NBTItem(stack);
        String rarity = nbti.getString("rarity").toLowerCase();
        HashMap<String,Integer> map = null;
        if(reforge.equalsIgnoreCase("Gentle")) {
            map = (HashMap<String, Integer>) Gentle.get(rarity);
        } else if(reforge.equalsIgnoreCase("Fast")) {
            map = (HashMap<String, Integer>) Fast.get(rarity);
        } else if(reforge.equalsIgnoreCase("Fair")) {
            map = (HashMap<String, Integer>) Fair.get(rarity);
        } else if(reforge.equalsIgnoreCase("Epic")) {
            map = (HashMap<String, Integer>) Epic.get(rarity);
        } else if(reforge.equalsIgnoreCase("Heroic")) {
            map = (HashMap<String, Integer>) Heroic.get(rarity);
        } else if(reforge.equalsIgnoreCase("Legendary")) {
            map = (HashMap<String, Integer>) Legendary.get(rarity);
        } else if(reforge.equalsIgnoreCase("Odd")) {
            map = (HashMap<String, Integer>) Odd.get(rarity);
        } else if(reforge.equalsIgnoreCase("Sharp")) {
            map = (HashMap<String, Integer>) Sharp.get(rarity);
        } else if(reforge.equalsIgnoreCase("Spicy")) {
            map = (HashMap<String, Integer>) Spicy.get(rarity);
        }

        int bonusstr = 0;
        int bonuscchance = 0;
        int bonuscdamage = 0;
        int bonusintel = 0;
        int bonusaspeed = 0;

        if(map.containsKey("str")) {
            bonusstr = map.get("str");
        }
        if(map.containsKey("cchance")) {
            bonuscchance = map.get("cchance");
        }
        if(map.containsKey("cdamage")) {
            bonuscdamage = map.get("cdamage");
        }
        if(map.containsKey("intel")) {
            bonusintel = map.get("intel");
        }
        if(map.containsKey("aspeed")) {
            bonusaspeed = map.get("aspeed");
        }

        int basestr = nbti.getInteger("str");
        int basecchance = nbti.getInteger("cchance");
        int basecdamage = nbti.getInteger("cdamage");
        int baseintel = nbti.getInteger("intel");
        int baseaspeed = nbti.getInteger("aspeed");

        int rfgbeforestr = 0;
        int rfgbeforecchance = 0;
        int rfgbeforecdamage = 0;
        int rfgbeforeintel = 0;
        int rfgbeforeaspeed = 0;

        if(nbti.getKeys().contains("rfgstr")) {
            rfgbeforestr = nbti.getInteger("rfgstr");
        }
        if(nbti.getKeys().contains("rfgcchance")) {
            rfgbeforecchance = nbti.getInteger("rfgcchance");
        }
        if(nbti.getKeys().contains("rfgcdamage")) {
            rfgbeforecdamage = nbti.getInteger("rfgcdamage");
        }
        if(nbti.getKeys().contains("rfgintel")) {
            rfgbeforeintel = nbti.getInteger("rfgintel");
        }
        if(nbti.getKeys().contains("rfgaspeed")) {
            rfgbeforeaspeed = nbti.getInteger("rfgaspeed");
        }


        int finalstr = basestr + bonusstr - rfgbeforestr;
        int finalcchance = basecchance + bonuscchance - rfgbeforecchance;
        int finalcdamage = basecdamage + bonuscdamage - rfgbeforecdamage;
        int finalintel = baseintel + bonusintel - rfgbeforeintel;
        int finalaspeed = baseaspeed + bonusaspeed - rfgbeforeaspeed;



        nbti.setInteger("str", finalstr);
        nbti.setInteger("cchance", finalcchance);
        nbti.setInteger("cdamage", finalcdamage);
        nbti.setInteger("intel", finalintel);
        nbti.setInteger("aspeed", finalaspeed);

        nbti.setInteger("rfgstr", bonusstr);
        nbti.setInteger("rfgcchance", bonuscchance);
        nbti.setInteger("rfgcdamage", bonuscdamage);
        nbti.setInteger("rfgintel", bonusintel);
        nbti.setInteger("rfgaspeed", bonusaspeed);

        nbti.setString("reforge", reforge);
        stack = nbti.getItem();


        me.sucukya.utility.loreRebuilder.rebuild(stack,p,inv);
    }

}
