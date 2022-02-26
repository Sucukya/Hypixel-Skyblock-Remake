package me.sucukya.utility;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class ChangeAccStats {

    public static void reset(Player p) {
        File file = new File("plugins//HPSBR//accessories//" + p.getUniqueId() + ".yml");
        NBTItem stats = new NBTItem(p.getInventory().getItemInOffHand());
        if(file.exists()) {
            YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
            double hp = conf.getDouble("hp");
            double def = conf.getDouble("def");
            double str = conf.getDouble("str");
            double speed = conf.getDouble("speed");
            double mana = conf.getDouble("intel");
            double cchance = conf.getDouble("cchance");
            double cdamage = conf.getDouble("cdamage");
            double petluck = conf.getDouble("petluck");
            double bonusas = conf.getDouble("bonusas");
            double magicfind = conf.getDouble("magicfind");
            double sschance = conf.getDouble("sschance");
            double truedef = conf.getDouble("truedef");
            double ferocity = conf.getDouble("ferocity");

            double hpnew = stats.getDouble("bonushp") - hp;
            double defnew = stats.getDouble("bonusdef") - def;
            double strnew = stats.getDouble("bonusstr") - str;
            double speednew = stats.getDouble("bonusspeed") - speed;
            double mananew = stats.getDouble("bonusmana") - mana;
            double cchancenew = stats.getDouble("bonuscchance") - cchance;
            double cdamagenew = stats.getDouble("bonuscdamage") - cdamage;
            double petlucknew = stats.getDouble("bonuspetluck") - petluck;
            double bonusasnew = stats.getDouble("bonusbonusas") - bonusas;
            double magicfindnew = stats.getDouble("bonusmagicfind") - magicfind;
            double scchancenew = stats.getDouble("bonusscchance") - sschance;
            double truedefnew = stats.getDouble("bonustruedef") - truedef;
            double ferocitynew = stats.getDouble("bonusferocity") - ferocity;

            stats.setDouble("bonushp",hpnew);
            stats.setDouble("bonusdef",defnew);
            stats.setDouble("bonusstr",strnew);
            stats.setDouble("bonusspeed",speednew);
            stats.setDouble("bonusmana",mananew);
            stats.setDouble("bonuscchance",cchancenew);
            stats.setDouble("bonuscdamage",cdamagenew);
            stats.setDouble("bonuspetluck",petlucknew);
            stats.setDouble("bonusbonusas",bonusasnew);
            stats.setDouble("bonusmagicfind",magicfindnew);
            stats.setDouble("bonusscchance",scchancenew);
            stats.setDouble("bonustruedef",truedefnew);
            stats.setDouble("bonusferocity",ferocitynew);

            ItemStack stack = stats.getItem();
            p.getInventory().setItemInOffHand(stack);

            conf.set("hp", 0);
            conf.set("def", 0);
            conf.set("str", 0);
            conf.set("speed", 0);
            conf.set("intel", 0);
            conf.set("cchance", 0);
            conf.set("cdamage", 0);
            conf.set("petluck", 0);
            conf.set("bonusas", 0);
            conf.set("magicfind", 0);
            conf.set("scchance", 0);
            conf.set("truedef", 0);
            conf.set("ferocity", 0);

            try {
                conf.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
