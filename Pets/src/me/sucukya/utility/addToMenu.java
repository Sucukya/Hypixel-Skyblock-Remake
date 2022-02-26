package me.sucukya.utility;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Pets;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class addToMenu {

    public static void addToMenu(Player p, ItemStack item) {
        petSaver.save(p,item);
        NBTItem nbti = new NBTItem(item);
        int lvl = nbti.getInteger("level");
        String type = nbti.getString("type");
        String rarity = nbti.getString("rarity");
        
        p.sendMessage("§aSuccessfully added " + Pets.raritycolormap.get(rarity) + type + " §ato your pets menu!");
        p.getInventory().remove(item);
    }

}
