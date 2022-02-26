//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.commands;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.utility.Data;
import me.sucukya.utility.loreRebuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class recombobulate implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cms, Command cmd, String arg, String[] args) {
        Player p = (Player) cms;
        HashMap<String,String> rarities = new HashMap<>();
        rarities.put("common", "uncommon");
        rarities.put("uncommon", "rare");
        rarities.put("rare", "epic");
        rarities.put("epic", "legendary");
        rarities.put("legendary", "mythic");
        ItemStack stack = p.getInventory().getItemInMainHand();
        NBTItem nbti = new NBTItem(stack);
        if(p.hasPermission("hpsbr.recomb")) {
            if(nbti.getKeys().contains("recomb")) {
                p.sendMessage(Data.prefix + "§cThis item has already been recombobulated");
            } else {
                String rarity = nbti.getString("rarity");
                nbti.setString("rarity", rarities.get(rarity));
                nbti.setBoolean("recomb", true);
                stack = nbti.getItem();
                if (nbti.getKeys().contains("reforge")) {
                    String reforge = nbti.getString("reforge");
                    String type = nbti.getString("type");
                    switch (type) {
                        case "sword":
                            me.sucukya.reforge.sword.apply.apply(stack,reforge,p,p.getInventory());
                            break;
                        case "helmet":
                            me.sucukya.reforge.armor.apply.apply(stack,reforge,p,p.getInventory());
                            break;
                        case "chestplate":
                            me.sucukya.reforge.armor.apply.apply(stack,reforge,p,p.getInventory());
                            break;
                        case "leggings":
                            me.sucukya.reforge.armor.apply.apply(stack,reforge,p,p.getInventory());
                            break;
                        case "boots":
                            me.sucukya.reforge.armor.apply.apply(stack,reforge,p,p.getInventory());
                            break;
                    }
                } else {
                    loreRebuilder.rebuild(stack,p,p.getInventory());
                }
            }

        }


        return true;
    }
}
