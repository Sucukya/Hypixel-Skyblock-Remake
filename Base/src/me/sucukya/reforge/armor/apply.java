//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge.armor;

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
        if(reforge.equalsIgnoreCase("Clean")) {
            map = (HashMap<String, Integer>) Clean.get(rarity);
        } else if(reforge.equalsIgnoreCase("Fierce")) {
            map = (HashMap<String, Integer>) Fierce.get(rarity);
        } else if(reforge.equalsIgnoreCase("Heavy")) {
            map = (HashMap<String, Integer>) Heavy.get(rarity);
        } else if(reforge.equalsIgnoreCase("Light")) {
            map = (HashMap<String, Integer>) Light.get(rarity);
        } else if(reforge.equalsIgnoreCase("Mythic")) {
            map = (HashMap<String, Integer>) Mythic.get(rarity);
        } else if(reforge.equalsIgnoreCase("Pure")) {
            map = (HashMap<String, Integer>) Pure.get(rarity);
        } else if(reforge.equalsIgnoreCase("Smart")) {
            map = (HashMap<String, Integer>) Smart.get(rarity);
        } else if(reforge.equalsIgnoreCase("Titanic")) {
            map = (HashMap<String, Integer>) Titanic.get(rarity);
        } else if(reforge.equalsIgnoreCase("Wise")) {
            map = (HashMap<String, Integer>) Wise.get(rarity);
        }

        int bonusstr = 0;
        int bonuscchance = 0;
        int bonuscdamage = 0;
        int bonusintel = 0;
        int bonusaspeed = 0;
        int bonushp = 0;
        int bonusspeed = 0;
        int bonusdef = 0;

        if(map.containsKey("str")) {
            bonusstr = map.get("str");
        }
        if(map.containsKey("cchance")) {
            bonuscchance = map.get("cchance");
        }
        if(map.containsKey("cdamage")) {
            bonuscdamage = map.get("cdamage");
        }
        if(map.containsKey("mana")) {
            bonusintel = map.get("mana");
        }
        if(map.containsKey("speed")) {
            bonusaspeed = map.get("speed");
        }
        if(map.containsKey("hp")) {
            bonushp = map.get("hp");
        }
        if(map.containsKey("def")) {
            bonusdef = map.get("def");
        }


        int basestr = nbti.getInteger("str");
        int basecchance = nbti.getInteger("cchance");
        int basecdamage = nbti.getInteger("cdamage");
        int baseintel = nbti.getInteger("intel");
        int baseaspeed = nbti.getInteger("aspeed");
        int basespeed = nbti.getInteger("speed");
        int basehp = nbti.getInteger("hp");
        int basedef = nbti.getInteger("def");

        int rfgbeforestr = 0;
        int rfgbeforecchance = 0;
        int rfgbeforecdamage = 0;
        int rfgbeforeintel = 0;
        int rfgbeforeaspeed = 0;
        int rfgbeforespeed = 0;
        int rfgbeforehp = 0;
        int rfgbeforedef = 0;

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
        if(nbti.getKeys().contains("rfgspeed")) {
            rfgbeforespeed = nbti.getInteger("rfgspeed");
        }
        if(nbti.getKeys().contains("rfghp")) {
            rfgbeforehp = nbti.getInteger("rfghp");
        }
        if(nbti.getKeys().contains("rfgdef")) {
            rfgbeforedef = nbti.getInteger("rfgdef");
        }



        int finalstr = basestr + bonusstr - rfgbeforestr;
        int finalcchance = basecchance + bonuscchance - rfgbeforecchance;
        int finalcdamage = basecdamage + bonuscdamage - rfgbeforecdamage;
        int finalintel = baseintel + bonusintel - rfgbeforeintel;
        int finalaspeed = baseaspeed + bonusaspeed - rfgbeforeaspeed;
        int finalspeed = basespeed + bonusspeed - rfgbeforespeed;
        int finalhp = basehp + bonushp - rfgbeforehp;
        double finaldef = basedef + bonusdef - rfgbeforedef;


        nbti.setInteger("str", finalstr);
        nbti.setInteger("cchance", finalcchance);
        nbti.setInteger("cdamage", finalcdamage);
        nbti.setInteger("intel", finalintel);
        nbti.setInteger("aspeed", finalaspeed);
        nbti.setInteger("speed", finalspeed);
        nbti.setInteger("hp", finalhp);
        nbti.setDouble("def", finaldef);

        nbti.setInteger("rfgstr", bonusstr);
        nbti.setInteger("rfgcchance", bonuscchance);
        nbti.setInteger("rfgcdamage", bonuscdamage);
        nbti.setInteger("rfgintel", bonusintel);
        nbti.setInteger("rfgaspeed", bonusaspeed);
        nbti.setInteger("rfgspeed", bonusspeed);
        nbti.setInteger("rfghp", bonushp);
        nbti.setInteger("rfgdef", bonusdef);

        nbti.setString("reforge", reforge);

        stack = nbti.getItem();



        me.sucukya.utility.loreRebuilder.rebuild(stack,p,inv);
    }

}
