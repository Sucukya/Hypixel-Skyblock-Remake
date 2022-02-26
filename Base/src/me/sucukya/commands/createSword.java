//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.commands;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class createSword implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cms, Command cmd, String arg, String[] args) {
        Player p = (Player)cms;
        if(p.hasPermission("hpsbr.createArmor")) {
            if(args.length == 18) {
                String mat = args[0];
                String name = args[1];
                String rarity = args[2];
                int dmg = Integer.parseInt(args[3]);
                int hp = Integer.parseInt(args[4]);
                double def = Integer.parseInt(args[5]);
                int str = Integer.parseInt(args[6]);
                int speed = Integer.parseInt(args[7]);
                int mana = Integer.parseInt(args[8]);
                int cchance = Integer.parseInt(args[9]);
                int cdamage = Integer.parseInt(args[10]);
                int petluck = Integer.parseInt(args[11]);
                int bonusas = Integer.parseInt(args[12]);
                int magicfind = Integer.parseInt(args[13]);
                int scchance = Integer.parseInt(args[14]);
                int truedef = Integer.parseInt(args[15]);
                int ferocity = Integer.parseInt(args[16]);
                String rfgable = args[17];

                Material material = null;
                try {
                    material = Material.getMaterial(mat.toUpperCase());
                } catch (Exception e){
                }
                String raritycolor = "";
                if(rarity.equalsIgnoreCase("common")) {
                    raritycolor = "§f§l";
                }
                if(rarity.equalsIgnoreCase("uncommon")) {
                    raritycolor = "§a§l";
                }
                if(rarity.equalsIgnoreCase("rare")) {
                    raritycolor = "§9§l";
                }
                if(rarity.equalsIgnoreCase("epic")) {
                    raritycolor = "§5§l";
                }
                if(rarity.equalsIgnoreCase("legendary")) {
                    raritycolor = "§6§l";
                }
                if(rarity.equalsIgnoreCase("mythic")) {
                    raritycolor = "§d§l";
                }


                    ItemStack stack = new ItemStack(material);
                    ItemMeta meta = stack.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.setUnbreakable(true);
                    meta.setDisplayName(raritycolor.replace("§l","") + name.replace("_"," "));
                    List<String> lore = new ArrayList<>();
                    if(dmg > 0) {
                        lore.add("§7Damage: §c+" + dmg);
                    }
                    if(str > 0) {
                        lore.add("§7Strength: §c+" + str);
                    }
                    if(cchance > 0) {
                        lore.add("§7Crit Chance: §c+" + cchance + "%");
                    }
                    if(cdamage > 0) {
                        lore.add("§7Crit Damage: §c+" + cdamage + "%");
                    }
                    if(bonusas > 0) {
                        lore.add("§7Bonus Attack Speed: §c+" + bonusas + "%");
                    }
                    if(scchance > 0) {
                        lore.add("§7Sea Creature Chance: §c+" + scchance + "%");
                    }
                    if(hp > 0 || def > 0 || speed > 0 || mana > 0 || truedef > 0 || magicfind > 0 || petluck > 0) {
                        lore.add(" ");
                    }
                    if(hp > 0) {
                        lore.add("§7Health: §a+" + hp +" HP");
                    }
                    if(def > 0) {
                        lore.add("§7Defense: §a+" + def );
                    }
                    if(mana > 0) {
                        lore.add("§7Intelligence: §a+" + mana );
                    }
                    if(speed > 0) {
                        lore.add("§7Speed: §a+" + speed +"%");
                    }
                    if(truedef > 0) {
                        lore.add("§7True Defense: §a+" + truedef );
                    }
                    if(magicfind > 0) {
                        lore.add("§7Magic Find: §a+" + magicfind );
                    }
                    if(petluck > 0) {
                        lore.add("§7Pet Luck: §a+" + petluck );
                    }
                    if(petluck > 0) {
                        lore.add("§7Ferocity: §a+" + ferocity );
                    }
                    if(hp > 0 || def > 0 || speed > 0 || mana > 0 || truedef > 0 || magicfind > 0 || petluck > 0 || str > 0 || cchance > 0 || cdamage > 0 || bonusas > 0 || scchance > 0 || ferocity > 0) {
                        lore.add(" ");
                    }
                    if(rfgable.equalsIgnoreCase("true")) {
                        lore.add("§8This item can be reforged!");
                    }
                    if(rfgable.equalsIgnoreCase("false")) {
                        lore.add("§8This item can't be reforged!");
                    }
                    lore.add(raritycolor + rarity.toUpperCase() + " SWORD");
                    meta.setLore(lore);
                    stack.setItemMeta(meta);
                    NBTItem nbti = new NBTItem(stack);
                    nbti.setInteger("str",str);
                    nbti.setInteger("cchance",cchance);
                    nbti.setInteger("cdamage",cdamage);
                    nbti.setInteger("aspeed",bonusas);
                    nbti.setInteger("scchance",scchance);
                    nbti.setInteger("speed",speed);
                    nbti.setInteger("hp",hp);
                    nbti.setDouble("def",def);
                    nbti.setInteger("intel",mana);
                    nbti.setInteger("magicfind",magicfind);
                    nbti.setInteger("petluck",petluck);
                    nbti.setInteger("truedef",truedef);
                    nbti.setInteger("ferocity",ferocity);
                    nbti.setInteger("damage",dmg);
                    nbti.setString("name",name);
                nbti.setString("type","sword");
                nbti.setString("rarity",rarity);
                if(rfgable.equalsIgnoreCase("true")) {
                    nbti.setBoolean("reforgable", true);
                } else {
                    nbti.setBoolean("reforgable", false);
                }
                    stack = nbti.getItem();
                    p.getInventory().addItem(stack);



            }
        }
        return true;
    }
}
