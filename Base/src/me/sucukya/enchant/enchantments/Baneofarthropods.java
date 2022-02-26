//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.enchant.enchantments;


import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.utility.Data;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

public class Baneofarthropods {



    public static void doEnchant(org.bukkit.entity.Player p, org.bukkit.inventory.ItemStack stack, java.lang.Integer level){
        NBTItem nbti = new NBTItem(stack);
        String type = nbti.getString("type");
        String enchtype = "sword";
                if(stack.getType().equals(Material.BOOK)) {
                    if(nbti.getKeys().contains("e5") || nbti.getKeys().contains("e14")) {
                        p.sendMessage(Data.prefix + "§cOne or more Enchantments that are already on the book don't work with the one you tried to add.");
                    } else {
                        nbti.setInteger("e62", level);
                        nbti.setInteger("totalenchs", nbti.getInteger("totalenchs") + 1);
                        p.sendMessage(Data.prefix + "§a Successfully applied §2Bane of Arthropods " + level + "§a!");
                        stack = nbti.getItem();
                        ItemMeta meta = stack.getItemMeta();
                        meta.setUnbreakable(true);
                        stack.setItemMeta(meta);
                        me.sucukya.utility.loreRebuilder.rebuild(stack, p, p.getInventory());
                    }

                } else {
                    if(nbti.getKeys().contains("e5") || nbti.getKeys().contains("e14")) {
                        p.sendMessage(Data.prefix + "§cOne or more Enchantments that are already on the sword don't work with the one you tried to add.");
                    } else {
                        if (type.equalsIgnoreCase(enchtype)) {
                            nbti.setInteger("e62", level);
                            nbti.setInteger("totalenchs", nbti.getInteger("totalenchs") + 1);
                            p.sendMessage(Data.prefix + "§a Successfully applied §2Bane of Arthropods " + level + "§a!");
                            stack = nbti.getItem();
                            if (!(stack.getType() == Material.PLAYER_HEAD)) {
                                stack.addEnchantment(Enchantment.MENDING, 1);
                            }
                            ItemMeta meta = stack.getItemMeta();
                            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                            meta.setUnbreakable(true);
                            stack.setItemMeta(meta);
                            me.sucukya.utility.loreRebuilder.rebuild(stack, p, p.getInventory());
                        } else {
                            p.sendMessage(Data.prefix + "§cThis enchantment can't be put on your selected item!");
                        }
                    }
                }

    }

}
