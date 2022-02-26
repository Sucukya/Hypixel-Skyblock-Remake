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

public class bootsStat implements Listener {

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
                                if (type.equalsIgnoreCase("boots")) {
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

        if (bootsMaps.hpmap.containsKey(p)) {
            hp = bootsMaps.hpmap.get(p);
        }
        if (bootsMaps.defmap.containsKey(p)) {
            def = bootsMaps.defmap.get(p);
        }
        if (bootsMaps.strmap.containsKey(p)) {
            str = bootsMaps.strmap.get(p);
        }
        if (bootsMaps.speedmap.containsKey(p)) {
            speed = bootsMaps.speedmap.get(p);
        }
        if (bootsMaps.manamap.containsKey(p)) {
            mana = bootsMaps.manamap.get(p);
        }
        if (bootsMaps.cchancemap.containsKey(p)) {
            cchance = bootsMaps.cchancemap.get(p);
        }
        if (bootsMaps.cdamagemap.containsKey(p)) {
            cdamage = bootsMaps.cdamagemap.get(p);
        }
        if (bootsMaps.petluckmap.containsKey(p)) {
            petluck = bootsMaps.petluckmap.get(p);
        }
        if (bootsMaps.bonusasmap.containsKey(p)) {
            bonusas = bootsMaps.bonusasmap.get(p);
        }
        if (bootsMaps.magicfindmap.containsKey(p)) {
            magicfind = bootsMaps.magicfindmap.get(p);
        }
        if (bootsMaps.scchancemap.containsKey(p)) {
            scchance = bootsMaps.scchancemap.get(p);
        }
        if (bootsMaps.truedefmap.containsKey(p)) {
            truedef = bootsMaps.truedefmap.get(p);
        }
        if (bootsMaps.ferocitymap.containsKey(p)) {
            ferocity = bootsMaps.ferocitymap.get(p);
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


        bootsMaps.hpmap.put(p, 0.0);
        bootsMaps.defmap.put(p,0.0);
        bootsMaps.strmap.put(p, 0.0);
        bootsMaps.speedmap.put(p, 0.0);
        bootsMaps.manamap.put(p, 0.0);
        bootsMaps.cchancemap.put(p, 0.0);
        bootsMaps.cdamagemap.put(p, 0.0);
        bootsMaps.petluckmap.put(p, 0.0);
        bootsMaps.bonusasmap.put(p, 0.0);
        bootsMaps.magicfindmap.put(p, 0.0);
        bootsMaps.scchancemap.put(p, 0.0);
        bootsMaps.truedefmap.put(p, 0.0);
        bootsMaps.ferocitymap.put(p, 0.0);
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

        bootsMaps.hpmap.put(p, hp);
        bootsMaps.defmap.put(p, def);
        bootsMaps.strmap.put(p, str);
        bootsMaps.speedmap.put(p, speed);
        bootsMaps.manamap.put(p, intelligence);
        bootsMaps.cchancemap.put(p, cchance);
        bootsMaps.cdamagemap.put(p, cdamage);
        bootsMaps.petluckmap.put(p, petluck);
        bootsMaps.bonusasmap.put(p, aspeed);
        bootsMaps.magicfindmap.put(p, magicfind);
        bootsMaps.scchancemap.put(p, scchance);
        bootsMaps.truedefmap.put(p, truedef);
        bootsMaps.ferocitymap.put(p, ferocity);

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
