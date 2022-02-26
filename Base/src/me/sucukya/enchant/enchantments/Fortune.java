//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.enchant.enchantments;


import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.utility.Data;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

public class Fortune {



    

    public static void doEnchant(org.bukkit.entity.Player p, org.bukkit.inventory.ItemStack stack, java.lang.Integer level){
        NBTItem nbti = new NBTItem(stack);
        String itype = nbti.getString("type");
        String type1 = "pickaxe";
        String type2 = "axe";
        String type3 = "shovel";
        
                if(stack.getType() == Material.BOOK) {
                    nbti.setInteger("e11", level);
                    nbti.setInteger("totalenchs", nbti.getInteger("totalenchs") + 1);
                    p.sendMessage(Data.prefix + "§a Successfully applied §2Fortune " + level + "§a!");
                    stack = nbti.getItem();
                    ItemMeta meta = stack.getItemMeta();
                    meta.setUnbreakable(true);
                    stack.setItemMeta(meta);
                    me.sucukya.utility.loreRebuilder.rebuild(stack, p, p.getInventory());

                } else {
                    if (itype.equalsIgnoreCase(type1) || itype.equalsIgnoreCase(type2) || itype.equalsIgnoreCase(type3)) {
                        if (nbti.getKeys().contains("e52")) {
                            p.sendMessage(Data.prefix + "§cOne or more Enchantments that are already on the tool don't work with the one you tried to add.");
                        } else {
                            nbti.setInteger("e11", level);
                            nbti.setInteger("totalenchs", nbti.getInteger("totalenchs") + 1);
                            p.sendMessage(Data.prefix + "§a Successfully applied §2Fortune " + level + "§a!");
                            stack = nbti.getItem();
                            stack.addEnchantment(Enchantment.MENDING, 1);
                            ItemMeta meta = stack.getItemMeta();
                            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                            meta.setUnbreakable(true);
                            stack.setItemMeta(meta);
                            me.sucukya.utility.loreRebuilder.rebuild(stack, p, p.getInventory());

                        }
                    } else {
                        p.sendMessage(Data.prefix + "§cThis enchantment can't be put on your selected item!");
                    }
                }

    }

}
