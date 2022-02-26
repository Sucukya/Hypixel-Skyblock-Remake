//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.utility;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class loreRebuilder {
    public static int enchamount = 0;

    public static void rebuild(ItemStack stack, Player p, Inventory inv) {
        StringBuilder builder = new StringBuilder();
        enchamount = 0;
        int minEnchantID = 1;
        int maxEnchantID = 64;
        NBTItem nbti = new NBTItem(stack);
        Set<String> ree = nbti.getKeys();
        boolean rfgable = nbti.getBoolean("reforgable");
        if(!ree.contains("reforgable")) {
            rfgable = false;
        }
        String rarity = nbti.getString("rarity");
        if(!nbti.getKeys().contains("rarity")) {
            rarity = "common";
        }
        String name = nbti.getString("name");;

        if(!nbti.getKeys().contains("name")) {
            name = stack.getType().toString();
        }

        String type = nbti.getString("type");
        if(!nbti.getKeys().contains("type")) {
            type = "Unknown";
        }
        String rfg = nbti.getString("reforge");
        if(!ree.contains("reforge")) {
            rfg = "";
        }
        String color = "";
        double dmg = nbti.getDouble("damage");
        double totalenchs = nbti.getDouble("totalenchs");
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

        int rfgdmg = nbti.getInteger("rfgdamage");
        int rfgstr = nbti.getInteger("rfgstr");
        int rfgcchance = nbti.getInteger("rfgcchance");
        int rfgcdamage = nbti.getInteger("rfgcdamage");
        int rfgaspeed = nbti.getInteger("rfgaspeed");
        int rfgscchance = nbti.getInteger("rfgscchance");
        int rfgspeed = nbti.getInteger("rfgspeed");
        int rfghp = nbti.getInteger("rfghp");
        int rfgdef = nbti.getInteger("rfgdef");
        int rfgintelligence = nbti.getInteger("rfgintel");
        int rfgmagicfind = nbti.getInteger("rfgmagicfind");
        int rfgpetluck = nbti.getInteger("rfgpetluck");
        int rfgtruedef = nbti.getInteger("rfgtruedef");
        int rfgferocity = nbti.getInteger("rfgferocity");
        stack = nbti.getItem();


        for (int i = minEnchantID; i < maxEnchantID; i++) {
            String enchantToCheck = "e" + i;
            if (nbti.getKeys().contains(enchantToCheck)) {
                enchamount++;
                if (totalenchs == 1) {
                    builder.append("§9" + (getEnchant.getEnchant(enchantToCheck).replace("_", " ")) + " " + (nbti.getInteger(enchantToCheck).toString()));
                }
                if (enchamount == 1 && totalenchs > 1) {
                    builder.append("§9" + (getEnchant.getEnchant(enchantToCheck).replace("_", " ")) + " " + (nbti.getInteger(enchantToCheck).toString() + ", "));
                }
                if (enchamount > 1) {
                    enchamount = 0;
                    builder.append("§9" + (getEnchant.getEnchant(enchantToCheck).replace("_", " ")) + " " + (nbti.getInteger(enchantToCheck).toString()) + "\n");
                }


            }


        }


        switch(rarity) {
            case "common":
                color = "§f";
                break;
            case "uncommon":
                color = "§a";
                break;
            case "rare":
                color = "§9";
                break;
            case "epic":
                color = "§5";
                break;
            case "legendary":
                color = "§6";
                break;
            case "mythic":
                color = "§d";
                break;
        }
        ItemMeta meta = stack.getItemMeta();
        if(rfg.equalsIgnoreCase("")) {
            meta.setDisplayName(color + name.replace("_", " "));
        } else {
            meta.setDisplayName(color + rfg + " " + name.replace("_", " "));
        }
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();
        if(dmg > 0) {
            if(rfgdmg > 0) {
                lore.add("§7Damage: §c+" + dmg + " §9(" + rfg + " +" + rfgdmg +")");
            } else {
                lore.add("§7Damage: §c+" + dmg);
            }
        }
        if(str > 0) {
            if(rfgstr > 0) {
                lore.add("§7Strength: §c+" + str + " §9(" + rfg + " +" + rfgstr +")");
            } else {
                lore.add("§7Strength: §c+" + str);
            }
        }
        if(cchance > 0) {
            if(rfgcchance > 0) {
                lore.add("§7Crit Chance: §c+" + cchance + "% §9(" + rfg + " +" + rfgcchance +"%)");
            } else {
                lore.add("§7Crit Chance: §c+" + cchance+ "% §9");
            }
        }
        if(cdamage > 0) {
            if(rfgcdamage > 0) {
                lore.add("§7Crit Damage: §c+" + cdamage + "% §9(" + rfg + " +" + rfgcdamage +"%)");
            } else {
                lore.add("§7Crit Damage: §c+" + cdamage + "% §9" );
            }
        }
        if(aspeed > 0) {
            if(rfgaspeed > 0) {
                lore.add("§7Bonus Attack Speed: §c+" + aspeed + "% §9(" + rfg + " +" + rfgaspeed +"%)");
            } else {
                lore.add("§7Bonus Attack Speed: §c+" + aspeed + "% §9");
            }
        }
        if(scchance > 0) {
            if(rfgscchance > 0) {
                lore.add("§7Sea Creature Chance: §c+" + scchance + "% §9(" + rfg + " +" + rfgscchance +"%)");
            } else {
                lore.add("§7Sea Creature Chance: §c+" + scchance + "% §9");
            }
        }
        if(hp > 0 || def > 0 || speed > 0 || truedef > 0 || magicfind > 0 || petluck > 0 || intelligence != 0) {
            lore.add(" ");
        }
        if(hp > 0) {
            if(rfghp > 0) {
                lore.add("§7Health: §a+" + hp + " HP §9(" + rfg + " +" + rfghp + " HP)");
            } else {
                lore.add("§7Health: §a+" + hp + " HP");
            }
        }
        if(def > 0) {
            if(rfgdef > 0) {
                lore.add("§7Defense: §a+" + def + " §9(" + rfg + " +" + rfgdef + ")");
            } else {
                lore.add("§7Defense: §a+" + def);
            }
        }
        if(speed > 0) {
            if(rfgspeed > 0) {
                lore.add("§7Speed: §a+" + speed + " §9(" + rfg + " +" + rfgspeed + ")");
            } else {
                lore.add("§7Speed: §a+" + speed);
            }
        }
        if(intelligence > 0) {
            if(rfgintelligence > 0) {
                lore.add("§7Intelligence: §a+" + intelligence + " §9(" + rfg + " +" + rfgintelligence + ")");
            } else {
                lore.add("§7Intelligence: §a+" + intelligence);
            }
        }
        if(intelligence < 0) {
            if(rfgintelligence < 0) {
                lore.add("§7Intelligence: §a" + intelligence + " §9(" + rfg + " " + rfgintelligence + ")");
            } else {
                lore.add("§7Intelligence: §a" + intelligence);
            }
        }
        if(truedef > 0) {
            if(rfgtruedef > 0) {
                lore.add("§7True Defense: §a+" + truedef + " §9(" + rfg + " +" + rfgtruedef + ")");
            } else {
                lore.add("§7True Defense: §a+" + truedef);
            }
        }
        if(magicfind > 0) {
            if(rfgmagicfind > 0) {
                lore.add("§7Magic Find: §a+" + magicfind + " §9(" + rfg + " +" + rfgmagicfind + ")");
            } else {
                lore.add("§7Magic Find: §a+" + magicfind);
            }        }
        if(petluck > 0) {
            if(rfgpetluck > 0) {
                lore.add("§7Pet Luck: §a+" + petluck + " §9(" + rfg + " +" + rfgpetluck + ")");
            } else {
                lore.add("§7Pet Luck: §a+" + petluck);
            }
        }

        if(ferocity > 0) {
            if(rfgferocity > 0) {
                lore.add("§7Ferocity : §a+" + ferocity + " §9(" + rfg + " +" + rfgferocity + ")");
            } else {
                lore.add("§7Ferocity : §a+" + ferocity);
            }
        }

        if(dmg > 0 || str > 0 || cchance > 0 || cdamage > 0 || aspeed > 0 || scchance > 0 || hp > 0 || def > 0 || speed > 0 || truedef > 0 || magicfind > 0 || petluck > 0 || ferocity > 0 || intelligence != 0 || !builder.toString().equalsIgnoreCase("")) {
            lore.add(" ");
        }
        if(!builder.toString().equalsIgnoreCase("")) {
            String srcString = builder.toString();
            String [] lines = srcString.split("\n");
            if(lines.length == 0) {
                lore.add(lines[0]);
            }
            for(int i = 0; i < lines.length; i++) {
                lore.add(lines[i]);
            }
        }
        if(!builder.toString().equalsIgnoreCase("")) {
            lore.add(" ");
        }
        if(rfgable) {
            lore.add("§8This item can be reforged!");
        }
        if(nbti.getKeys().contains("recomb")) {
            lore.add(color + "§l§kq §r" + color + "§l" + rarity.toUpperCase() + " " + type.toUpperCase() + " §l§kq");
        } else {
            lore.add(color + "§l" + rarity.toUpperCase() + " " + type.toUpperCase());
        }
        meta.setLore(lore);
        stack.setItemMeta(meta);
        if(p.getOpenInventory().getTitle().equalsIgnoreCase("§8Reforge Item")) {
            inv.setItem(13, stack);
        } else {
            p.getInventory().setItemInMainHand(stack);
        }





    }

}
