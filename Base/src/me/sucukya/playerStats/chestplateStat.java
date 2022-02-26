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

public class chestplateStat implements Listener {

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
                                if (type.equalsIgnoreCase("chestplate")) {
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

        if (chestplateMaps.hpmap.containsKey(p)) {
            hp = chestplateMaps.hpmap.get(p);
        }
        if (chestplateMaps.defmap.containsKey(p)) {
            def = chestplateMaps.defmap.get(p);
        }
        if (chestplateMaps.strmap.containsKey(p)) {
            str = chestplateMaps.strmap.get(p);
        }
        if (chestplateMaps.speedmap.containsKey(p)) {
            speed = chestplateMaps.speedmap.get(p);
        }
        if (chestplateMaps.manamap.containsKey(p)) {
            mana = chestplateMaps.manamap.get(p);
        }
        if (chestplateMaps.cchancemap.containsKey(p)) {
            cchance = chestplateMaps.cchancemap.get(p);
        }
        if (chestplateMaps.cdamagemap.containsKey(p)) {
            cdamage = chestplateMaps.cdamagemap.get(p);
        }
        if (chestplateMaps.petluckmap.containsKey(p)) {
            petluck = chestplateMaps.petluckmap.get(p);
        }
        if (chestplateMaps.bonusasmap.containsKey(p)) {
            bonusas = chestplateMaps.bonusasmap.get(p);
        }
        if (chestplateMaps.magicfindmap.containsKey(p)) {
            magicfind = chestplateMaps.magicfindmap.get(p);
        }
        if (chestplateMaps.scchancemap.containsKey(p)) {
            scchance = chestplateMaps.scchancemap.get(p);
        }
        if (chestplateMaps.truedefmap.containsKey(p)) {
            truedef = chestplateMaps.truedefmap.get(p);
        }
        if (chestplateMaps.ferocitymap.containsKey(p)) {
            ferocity = chestplateMaps.ferocitymap.get(p);
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


        chestplateMaps.hpmap.put(p, 0.0);
        chestplateMaps.defmap.put(p,0.0);
        chestplateMaps.strmap.put(p, 0.0);
        chestplateMaps.speedmap.put(p, 0.0);
        chestplateMaps.manamap.put(p, 0.0);
        chestplateMaps.cchancemap.put(p, 0.0);
        chestplateMaps.cdamagemap.put(p, 0.0);
        chestplateMaps.petluckmap.put(p, 0.0);
        chestplateMaps.bonusasmap.put(p, 0.0);
        chestplateMaps.magicfindmap.put(p, 0.0);
        chestplateMaps.scchancemap.put(p, 0.0);
        chestplateMaps.truedefmap.put(p, 0.0);
        chestplateMaps.ferocitymap.put(p, 0.0);
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

        chestplateMaps.hpmap.put(p, hp);
        chestplateMaps.defmap.put(p, def);
        chestplateMaps.strmap.put(p, str);
        chestplateMaps.speedmap.put(p, speed);
        chestplateMaps.manamap.put(p, intelligence);
        chestplateMaps.cchancemap.put(p, cchance);
        chestplateMaps.cdamagemap.put(p, cdamage);
        chestplateMaps.petluckmap.put(p, petluck);
        chestplateMaps.bonusasmap.put(p, aspeed);
        chestplateMaps.magicfindmap.put(p, magicfind);
        chestplateMaps.scchancemap.put(p, scchance);
        chestplateMaps.truedefmap.put(p, truedef);
        chestplateMaps.ferocitymap.put(p, ferocity);

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
