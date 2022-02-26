//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.enchant.enchantments;


import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.utility.Data;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

public class Protection {



    

    public static void doEnchant(org.bukkit.entity.Player p, org.bukkit.inventory.ItemStack stack, java.lang.Integer level){
        NBTItem nbti = new NBTItem(stack);
        String itype = nbti.getString("type");
        String type = "helmet";
        String type2 = "chestplate";
        String type3 = "leggings";
        String type4 = "boots";
        
                if(stack.getType() == Material.BOOK) {
                    nbti.setInteger("e15", level);
                    nbti.setInteger("totalenchs", nbti.getInteger("totalenchs") + 1);
                    nbti.setString("type","book");
                    p.sendMessage(Data.prefix + "§a Successfully applied §2Protection " + level + "§a!");
                    stack = nbti.getItem();
                    ItemMeta meta = stack.getItemMeta();
                    meta.setUnbreakable(true);
                    stack.setItemMeta(meta);
                    me.sucukya.utility.loreRebuilder.rebuild(stack, p, p.getInventory());

                } else {
                    if (itype.equalsIgnoreCase(type) || itype.equalsIgnoreCase(type2) || itype.equalsIgnoreCase(type3) || itype.equalsIgnoreCase(type4)) {
                        nbti.setInteger("e15", level);
                        nbti.setInteger("totalenchs", nbti.getInteger("totalenchs") + 1);
                        p.sendMessage(Data.prefix + "§a Successfully applied §2Protection " + level + "§a!");
                        int extra = level * 3;
                        int oldProt = nbti.getInteger("def");
                        nbti.setInteger("def", oldProt + extra);
                        stack = nbti.getItem();
                        if(!(stack.getType() == Material.PLAYER_HEAD)) {
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
