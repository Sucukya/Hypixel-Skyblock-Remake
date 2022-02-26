//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.damage;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class calculateDamage {

    public static Map<String, Integer> calc(int damage, Player p, Entity e) {
        NBTItem nbtiStats = new NBTItem(p.getInventory().getItemInOffHand());
        NBTItem mobStats = new NBTItem(((LivingEntity) e).getEquipment().getItemInOffHand());
        NBTItem nbti = new NBTItem(p.getInventory().getItemInOffHand());

        if(p.getInventory().getItemInMainHand().getType().isAir() || p.getInventory().getItemInMainHand() == null) {
        } else {
            nbti = new NBTItem(p.getInventory().getItemInMainHand());
        }

        int basestr = nbtiStats.getInteger("basestr");
        int bonusstr = nbtiStats.getInteger("bonusstr");
        int str = basestr + bonusstr;
        int basedmg = (5 + damage + (str / 5) * (1 + str/100));
        double dmgmult = 0;
        if(e.getType().equals(EntityType.ZOMBIE) || e.getType().equals(EntityType.ZOMBIE_VILLAGER) || e.getType().equals(EntityType.SKELETON) || e.getType().equals(EntityType.WITHER_SKELETON) || e.getType().equals(EntityType.ZOMBIFIED_PIGLIN) || e.getType().equals(EntityType.WITHER)) {
            if(nbti.getKeys().contains("e14")) {
                int smitelevel = nbti.getInteger("e14");
                dmgmult = (1 + (1 * 0.04) + (0.08 * smitelevel) + 0);
            } else if(nbti.getKeys().contains("e5")) {
                int sharplevel = nbti.getInteger("e5");
                dmgmult = (1 + (1 * 0.04) + (0.05 * sharplevel) + 0);
            }else if(nbti.getKeys().contains("e20")) {
                int powerlevel = nbti.getInteger("e20");
                dmgmult = (1 + (1 * 0.04) + (0.08 * powerlevel) + 0);
            } else{
                dmgmult = (1 + (1 * 0.04) + 0 + 0);
            }
        } else if(e.getType().equals(EntityType.SPIDER) || e.getType().equals(EntityType.CAVE_SPIDER) || e.getType().equals(EntityType.SILVERFISH)) {
            if(nbti.getKeys().contains("e62")) {
                int smitelevel = nbti.getInteger("e62");
                dmgmult = (1 + (1 * 0.04) + (0.08 * smitelevel) + 0);
            } else if(nbti.getKeys().contains("e5")) {
                int sharplevel = nbti.getInteger("e5");
                dmgmult = (1 + (1 * 0.04) + (0.05 * sharplevel) + 0);
            }else if(nbti.getKeys().contains("e20")) {
                int powerlevel = nbti.getInteger("e20");
                dmgmult = (1 + (1 * 0.04) + (0.08 * powerlevel) + 0);
            } else {
                dmgmult = (1 + (1 * 0.04) + 0 + 0);
            }
        } else {
            if(nbti.getKeys().contains("e5")) {
                int sharplevel = nbti.getInteger("e5");
                dmgmult = (1 + (1 * 0.04) + (0.05 * sharplevel) + 0);
            }else if(nbti.getKeys().contains("e20")) {
                int powerlevel = nbti.getInteger("e20");
                dmgmult = (1 + (1 * 0.04) + (0.08 * powerlevel) + 0);
            } else {
                dmgmult = (1 + (1 * 0.04) + 0 + 0);
            }
        }
        if(e.getType().equals(EntityType.ENDERMAN) || e.getType().equals(EntityType.ENDER_DRAGON)) {
            if(nbti.getKeys().contains("e22")) {
                int eslayerlvl = nbti.getInteger("e22");
                dmgmult = dmgmult + (0.12 * eslayerlvl);
            }
        }
        if(e.getType().equals(EntityType.CREEPER) || e.getType().equals(EntityType.MAGMA_CUBE) || e.getType().equals(EntityType.SLIME)) {
            if(nbti.getKeys().contains("e23")) {
                int cubismlvl = nbti.getInteger("e23");
                dmgmult = dmgmult + (0.1 * cubismlvl);
            }
        }
        Map<String,Integer> map = new HashMap<>();
        Random rand = new Random();
        int ccc = rand.nextInt(100);
        int basecc = nbtiStats.getInteger("basecchance");
        int bonuscc = nbtiStats.getInteger("bonuscchance");
        int cc = basecc + bonuscc;
        int finaldmg = 0;
        if (ccc <= cc) {
            float baseccdmg = nbtiStats.getInteger("basecdamage");
            float bonusccdmg = nbtiStats.getInteger("bonuscdamage");
            float ccdmg = baseccdmg + bonusccdmg;
            float cccdmg = ccdmg/100;
            int cdmg = (int) Math.ceil(cccdmg * 5);
            finaldmg = (int) (basedmg * dmgmult * 1 * ( 1 + cdmg));
            map.put("finaldmg",finaldmg);
            map.put("crit",1);
            if(nbti.getKeys().contains("e8")) {
                int syphonlvl = nbti.getInteger("e8");
                double hptoadd = ((syphonlvl * 0.1) + 0.1) * finaldmg;
                nbtiStats.setInteger("chp", nbtiStats.getInteger("chp") + (int)hptoadd);
            }
        } else {
            finaldmg = (int) ((basedmg * dmgmult) * 1);
            map.put("finaldmg",finaldmg);
            map.put("crit",0);
            if(nbti.getKeys().contains("e24")) {
                int syphonlvl = nbti.getInteger("e24");
                double hptoadd = (syphonlvl * 0.1) * finaldmg;
                nbtiStats.setInteger("chp", (int) (nbtiStats.getInteger("chp") + hptoadd));
            }
        }

        if(nbti.getKeys().contains("e6")) {
            if(mobStats.getKeys().contains("hitby")) {
            } else {
                if(mobStats.getString("hitby").equalsIgnoreCase(p.getUniqueId().toString())) {
                } else {
                    int firststrikelevel = nbti.getInteger("e6");
                    finaldmg = map.get("finaldmg");
                    finaldmg = (int) Math.ceil(finaldmg * (0.25 * firststrikelevel));
                    map.put("finaldmg", finaldmg);
                }
            }
        }

        return map;

    }

}
