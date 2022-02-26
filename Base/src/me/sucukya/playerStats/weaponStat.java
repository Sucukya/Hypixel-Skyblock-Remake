//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.playerStats;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

public class weaponStat implements Listener {

    @EventHandler
    public void onSwitch(PlayerItemHeldEvent e) {
        Player p = e.getPlayer();
        int slot = e.getNewSlot();
        int beforeslot = e.getPreviousSlot();
        ItemStack before = p.getInventory().getItem(beforeslot);
        ItemStack stat = p.getInventory().getItemInOffHand();
        NBTItem stats = new NBTItem(e.getPlayer().getInventory().getItemInOffHand());

        if(before == null || before.getType().isAir()) {

        } else {
            NBTItem nbti = new NBTItem(before);
            if(nbti.getKeys().contains("type")) {
                reset(p,stats,stat);
            }
        }

        if(p.getInventory().getItem(slot) == null || p.getInventory().getItem(slot).getType().isAir()) {
            reset(p,stats,stat);
        } else {
            ItemStack stack = p.getInventory().getItem(slot);
            NBTItem nbti = new NBTItem(stack);
            if (nbti.getKeys().contains("type")) {
                String type = nbti.getString("type");
                if (type.equalsIgnoreCase("sword")) {
                    double str = nbti.getDouble("str");
                    double cchance = nbti.getDouble("cchance");
                    double cdamage = nbti.getDouble("cdamage");
                    double aspeed = nbti.getDouble("aspeed");
                    double scchance = nbti.getDouble("scchance");
                    double speed = nbti.getDouble("speed");
                    double hp = nbti.getDouble("hp");
                    double def = nbti.getDouble("def");
                    double intelligence = nbti.getDouble("intel");
                    double magicfind = nbti.getDouble("magicfind");
                    double petluck = nbti.getDouble("petluck");
                    double truedef = nbti.getDouble("truedef");
                    double ferocity = nbti.getDouble("ferocity");

                    weaponMaps.hpmap.put(p, hp);
                    weaponMaps.defmap.put(p, def);
                    weaponMaps.strmap.put(p, str);
                    weaponMaps.speedmap.put(p, speed);
                    weaponMaps.manamap.put(p, intelligence);
                    weaponMaps.cchancemap.put(p, cchance);
                    weaponMaps.cdamagemap.put(p, cdamage);
                    weaponMaps.petluckmap.put(p, petluck);
                    weaponMaps.bonusasmap.put(p, aspeed);
                    weaponMaps.magicfindmap.put(p, magicfind);
                    weaponMaps.scchancemap.put(p, scchance);
                    weaponMaps.truedefmap.put(p, truedef);
                    weaponMaps.ferocitymap.put(p,ferocity);

                    double finalhp = stats.getDouble("bonushp") + hp;
                    double finaldef = stats.getDouble("bonusdef") + def;
                    double finalstr = stats.getDouble("bonusstr") + str;
                    double finalspeed = stats.getDouble("bonusspeed") + speed;
                    double finalmana = stats.getDouble("bonusmana") + intelligence;
                    double finalcchance = stats.getDouble("bonuscchance") + cchance;
                    double finalcdamage = stats.getDouble("bonuscdamage") + cdamage;
                    double finalpetluck = stats.getDouble("bonuspetluck") + petluck;
                    double finalbonusas = stats.getDouble("bonusbonusas") + aspeed;
                    double finalmagicfind = stats.getDouble("bonusmagicfind") + magicfind;
                    double finalscchance = stats.getDouble("bonusscchance") + scchance;
                    double finaltruedef = stats.getDouble("bonustruedef") + truedef;
                    double finalferocity = stats.getDouble("bonusferocity") + ferocity;

                    stats.setDouble("bonushp", finalhp);
                    stats.setDouble("bonusdef", finaldef);
                    stats.setDouble("bonusstr", finalstr);
                    stats.setDouble("bonusspeed", finalspeed);
                    stats.setDouble("bonusmana", finalmana);
                    stats.setDouble("bonuscchance", finalcchance);
                    stats.setDouble("bonuscdamage", finalcdamage);
                    stats.setDouble("bonuspetluck", finalpetluck);
                    stats.setDouble("bonusbonusas", finalbonusas);
                    stats.setDouble("bonusmagicfind", finalmagicfind);
                    stats.setDouble("bonusscchance", finalscchance);
                    stats.setDouble("bonustruedef", finaltruedef);
                    stats.setDouble("bonusferocity", finalferocity);

                    stat = stats.getItem();
                    p.getInventory().setItemInOffHand(stat);
                    me.sucukya.listerners.updateStat.update(p,"basehp");

                }
            } else {
                reset(p,stats,stat);
            }

        }
    }

        public static void reset(Player p, NBTItem stats, ItemStack stat){
        double hp = 0;
        double def = 0;
        double str = 0;
        double speed = 0;
        double mana = 0;
        double cchance = 0;
        double cdamage = 0;
        double petluck = 0;
        double bonusas = 0;
        double magicfind = 0;
        double scchance = 0;
        double truedef = 0;
        double ferocity = 0;

        if (weaponMaps.hpmap.containsKey(p)) {
            hp = weaponMaps.hpmap.get(p);
        }
        if (weaponMaps.defmap.containsKey(p)) {
            def = weaponMaps.defmap.get(p);
        }
        if (weaponMaps.strmap.containsKey(p)) {
            str = weaponMaps.strmap.get(p);
        }
        if (weaponMaps.speedmap.containsKey(p)) {
            speed = weaponMaps.speedmap.get(p);
        }
        if (weaponMaps.manamap.containsKey(p)) {
            mana = weaponMaps.manamap.get(p);
        }
        if (weaponMaps.cchancemap.containsKey(p)) {
            cchance = weaponMaps.cchancemap.get(p);
        }
        if (weaponMaps.cdamagemap.containsKey(p)) {
            cdamage = weaponMaps.cdamagemap.get(p);
        }
        if (weaponMaps.petluckmap.containsKey(p)) {
            petluck = weaponMaps.petluckmap.get(p);
        }
        if (weaponMaps.bonusasmap.containsKey(p)) {
            bonusas = weaponMaps.bonusasmap.get(p);
        }
        if (weaponMaps.magicfindmap.containsKey(p)) {
            magicfind = weaponMaps.magicfindmap.get(p);
        }
        if (weaponMaps.scchancemap.containsKey(p)) {
            scchance = weaponMaps.scchancemap.get(p);
        }
        if (weaponMaps.truedefmap.containsKey(p)) {
            truedef = weaponMaps.truedefmap.get(p);
        }
        if (weaponMaps.ferocitymap.containsKey(p)) {
            ferocity = weaponMaps.ferocitymap.get(p);
        }
        double finalhp = stats.getDouble("bonushp") - hp;
        double finaldef = stats.getDouble("bonusdef") - def;
        double finalstr = stats.getDouble("bonusstr") - str;
        double finalspeed = stats.getDouble("bonusspeed") - speed;
        double finalmana = stats.getDouble("bonusmana") - mana;
        double finalcchance = stats.getDouble("bonuscchance") - cchance;
        double finalcdamage = stats.getDouble("bonuscdamage") - cdamage;
        double finalpetluck = stats.getDouble("bonuspetluck") - petluck;
        double finalbonusas = stats.getDouble("bonusbonusas") - bonusas;
        double finalmagicfind = stats.getDouble("bonusmagicfind") - magicfind;
        double finalscchance = stats.getDouble("bonusscchance") - scchance;
        double finaltruedef = stats.getDouble("bonustruedef") - truedef;
        double finalferocity = stats.getDouble("bonusferocity") - ferocity;

        stats.setDouble("bonushp", finalhp);
        stats.setDouble("bonusdef", finaldef);
        stats.setDouble("bonusstr", finalstr);
        stats.setDouble("bonusspeed", finalspeed);
        stats.setDouble("bonusmana", finalmana);
        stats.setDouble("bonuscchance", finalcchance);
        stats.setDouble("bonuscdamage", finalcdamage);
        stats.setDouble("bonuspetluck", finalpetluck);
        stats.setDouble("bonusbonusas", finalbonusas);
        stats.setDouble("bonusmagicfind", finalmagicfind);
        stats.setDouble("bonusscchance", finalscchance);
        stats.setDouble("bonustruedef", finaltruedef);
        stats.setDouble("bonusferocity", finalferocity);

        stat = stats.getItem();
        p.getInventory().setItemInOffHand(stat);
        me.sucukya.listerners.updateStat.update(p,"basehp");


        weaponMaps.hpmap.put(p, 0.0);
        weaponMaps.defmap.put(p,0.0);
        weaponMaps.strmap.put(p, 0.0);
        weaponMaps.speedmap.put(p, 0.0);
        weaponMaps.manamap.put(p, 0.0);
        weaponMaps.cchancemap.put(p, 0.0);
        weaponMaps.cdamagemap.put(p, 0.0);
        weaponMaps.petluckmap.put(p, 0.0);
        weaponMaps.bonusasmap.put(p, 0.0);
        weaponMaps.magicfindmap.put(p, 0.0);
        weaponMaps.scchancemap.put(p, 0.0);
        weaponMaps.truedefmap.put(p, 0.0);
        weaponMaps.ferocitymap.put(p, 0.0);
    }


}
