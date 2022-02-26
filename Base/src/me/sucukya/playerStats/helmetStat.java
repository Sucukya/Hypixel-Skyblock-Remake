//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.playerStats;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class helmetStat implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory() != null) {
            if (e.getView().getType() != InventoryType.ANVIL) {
                if (e.getClickedInventory().equals(p.getInventory())) {
                    if (e.getSlot() == 37) {
                        ItemStack stack = e.getCursor();
                        if (e.getCurrentItem().getType().isAir() || e.getCurrentItem() == null) {
                            if(stack == null || stack.getType().isAir()) {
                            } else {
                                NBTItem nbti = new NBTItem(stack);
                                NBTItem stats = new NBTItem(p.getInventory().getItemInOffHand());
                                ItemStack stat = p.getInventory().getItemInOffHand();
                                String type = nbti.getString("type");
                                if (type.equalsIgnoreCase("helmet")) {
                                    get(p, stats, stat, nbti);
                                }
                            }
                        } else {

                            if(stack.getType().isAir() || stack == null) {
                                NBTItem stats = new NBTItem(p.getInventory().getItemInOffHand());
                                ItemStack stat = p.getInventory().getItemInOffHand();
                                reset(p,stats,stat);
                            } else {
                                NBTItem nbti = new NBTItem(stack);
                                NBTItem stats = new NBTItem(p.getInventory().getItemInOffHand());
                                ItemStack stat = p.getInventory().getItemInOffHand();

                                reset(p,stats,stat);
                                get(p,stats,stat,nbti);
                            }
                        }
                    }
                }
            }
        }
    }public static void reset(Player p, NBTItem stats, ItemStack stat){
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

        if (helmetMaps.hpmap.containsKey(p)) {
            hp = helmetMaps.hpmap.get(p);
        }
        if (helmetMaps.defmap.containsKey(p)) {
            def = helmetMaps.defmap.get(p);
        }
        if (helmetMaps.strmap.containsKey(p)) {
            str = helmetMaps.strmap.get(p);
        }
        if (helmetMaps.speedmap.containsKey(p)) {
            speed = helmetMaps.speedmap.get(p);
        }
        if (helmetMaps.manamap.containsKey(p)) {
            mana = helmetMaps.manamap.get(p);
        }
        if (helmetMaps.cchancemap.containsKey(p)) {
            cchance = helmetMaps.cchancemap.get(p);
        }
        if (helmetMaps.cdamagemap.containsKey(p)) {
            cdamage = helmetMaps.cdamagemap.get(p);
        }
        if (helmetMaps.petluckmap.containsKey(p)) {
            petluck = helmetMaps.petluckmap.get(p);
        }
        if (helmetMaps.bonusasmap.containsKey(p)) {
            bonusas = helmetMaps.bonusasmap.get(p);
        }
        if (helmetMaps.magicfindmap.containsKey(p)) {
            magicfind = helmetMaps.magicfindmap.get(p);
        }
        if (helmetMaps.scchancemap.containsKey(p)) {
            scchance = helmetMaps.scchancemap.get(p);
        }
        if (helmetMaps.truedefmap.containsKey(p)) {
            truedef = helmetMaps.truedefmap.get(p);
        }
        if (helmetMaps.ferocitymap.containsKey(p)) {
            ferocity = helmetMaps.ferocitymap.get(p);
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


        helmetMaps.hpmap.put(p, 0.0);
        helmetMaps.defmap.put(p,0.0);
        helmetMaps.strmap.put(p, 0.0);
        helmetMaps.speedmap.put(p, 0.0);
        helmetMaps.manamap.put(p, 0.0);
        helmetMaps.cchancemap.put(p, 0.0);
        helmetMaps.cdamagemap.put(p, 0.0);
        helmetMaps.petluckmap.put(p, 0.0);
        helmetMaps.bonusasmap.put(p, 0.0);
        helmetMaps.magicfindmap.put(p, 0.0);
        helmetMaps.scchancemap.put(p, 0.0);
        helmetMaps.truedefmap.put(p, 0.0);
        helmetMaps.ferocitymap.put(p, 0.0);
    }

    public static void get(Player p, NBTItem stats, ItemStack stat, NBTItem nbti) {

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

        helmetMaps.hpmap.put(p, hp);
        helmetMaps.defmap.put(p, def);
        helmetMaps.strmap.put(p, str);
        helmetMaps.speedmap.put(p, speed);
        helmetMaps.manamap.put(p, intelligence);
        helmetMaps.cchancemap.put(p, cchance);
        helmetMaps.cdamagemap.put(p, cdamage);
        helmetMaps.petluckmap.put(p, petluck);
        helmetMaps.bonusasmap.put(p, aspeed);
        helmetMaps.magicfindmap.put(p, magicfind);
        helmetMaps.scchancemap.put(p, scchance);
        helmetMaps.truedefmap.put(p, truedef);
        helmetMaps.ferocitymap.put(p, ferocity);

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

}
