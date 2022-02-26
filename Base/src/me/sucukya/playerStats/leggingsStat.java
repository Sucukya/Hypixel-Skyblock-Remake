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

public class leggingsStat implements Listener {

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
                                if (type.equalsIgnoreCase("leggings")) {
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

        if (leggingsMaps.hpmap.containsKey(p)) {
            hp = leggingsMaps.hpmap.get(p);
        }
        if (leggingsMaps.defmap.containsKey(p)) {
            def = leggingsMaps.defmap.get(p);
        }
        if (leggingsMaps.strmap.containsKey(p)) {
            str = leggingsMaps.strmap.get(p);
        }
        if (leggingsMaps.speedmap.containsKey(p)) {
            speed = leggingsMaps.speedmap.get(p);
        }
        if (leggingsMaps.manamap.containsKey(p)) {
            mana = leggingsMaps.manamap.get(p);
        }
        if (leggingsMaps.cchancemap.containsKey(p)) {
            cchance = leggingsMaps.cchancemap.get(p);
        }
        if (leggingsMaps.cdamagemap.containsKey(p)) {
            cdamage = leggingsMaps.cdamagemap.get(p);
        }
        if (leggingsMaps.petluckmap.containsKey(p)) {
            petluck = leggingsMaps.petluckmap.get(p);
        }
        if (leggingsMaps.bonusasmap.containsKey(p)) {
            bonusas = leggingsMaps.bonusasmap.get(p);
        }
        if (leggingsMaps.magicfindmap.containsKey(p)) {
            magicfind = leggingsMaps.magicfindmap.get(p);
        }
        if (leggingsMaps.scchancemap.containsKey(p)) {
            scchance = leggingsMaps.scchancemap.get(p);
        }
        if (leggingsMaps.truedefmap.containsKey(p)) {
            truedef = leggingsMaps.truedefmap.get(p);
        }
        if (leggingsMaps.ferocitymap.containsKey(p)) {
            ferocity = leggingsMaps.ferocitymap.get(p);
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


        leggingsMaps.hpmap.put(p, 0.0);
        leggingsMaps.defmap.put(p,0.0);
        leggingsMaps.strmap.put(p, 0.0);
        leggingsMaps.speedmap.put(p, 0.0);
        leggingsMaps.manamap.put(p, 0.0);
        leggingsMaps.cchancemap.put(p, 0.0);
        leggingsMaps.cdamagemap.put(p, 0.0);
        leggingsMaps.petluckmap.put(p, 0.0);
        leggingsMaps.bonusasmap.put(p, 0.0);
        leggingsMaps.magicfindmap.put(p, 0.0);
        leggingsMaps.scchancemap.put(p, 0.0);
        leggingsMaps.truedefmap.put(p, 0.0);
        leggingsMaps.ferocitymap.put(p, 0.0);
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

        leggingsMaps.hpmap.put(p, hp);
        leggingsMaps.defmap.put(p, def);
        leggingsMaps.strmap.put(p, str);
        leggingsMaps.speedmap.put(p, speed);
        leggingsMaps.manamap.put(p, intelligence);
        leggingsMaps.cchancemap.put(p, cchance);
        leggingsMaps.cdamagemap.put(p, cdamage);
        leggingsMaps.petluckmap.put(p, petluck);
        leggingsMaps.bonusasmap.put(p, aspeed);
        leggingsMaps.magicfindmap.put(p, magicfind);
        leggingsMaps.scchancemap.put(p, scchance);
        leggingsMaps.truedefmap.put(p, truedef);
        leggingsMaps.ferocitymap.put(p, ferocity);

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
