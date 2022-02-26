//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.enchant.enchantments;


import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.utility.Data;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

public class Telekinesis {

    String type = "all";


    public static void doEnchant(org.bukkit.entity.Player p, org.bukkit.inventory.ItemStack stack, java.lang.Integer level){
        NBTItem nbti = new NBTItem(stack);
                nbti.setInteger("e1", level);
                nbti.setInteger("totalenchs", nbti.getInteger("totalenchs") + 1);
                p.sendMessage(Data.prefix + "§a Successfully applied §2Telekinesis " + level +"§a!");
                stack = nbti.getItem();
                stack.addEnchantment(Enchantment.MENDING,1);
                ItemMeta meta = stack.getItemMeta();
                meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                meta.setUnbreakable(true);
                stack.setItemMeta(meta);
                me.sucukya.utility.loreRebuilder.rebuild(stack,p,p.getInventory());

    }

}
