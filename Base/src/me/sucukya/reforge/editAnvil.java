//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.utility.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class editAnvil {

    public static void edit(String rarity, String type, ItemStack stack, Player p) {
        HashMap<String,Integer> costmap = new HashMap<>();
        costmap.put("common",125);
        costmap.put("uncommon",250);
        costmap.put("rare",500);
        costmap.put("epic",1250);
        costmap.put("legendary",2500);
        costmap.put("mythic",5000);

        int cost = costmap.get(rarity);

        Inventory inv = Bukkit.createInventory(null, 45, "§8Reforge Item");
        int minRow = 0;
        int maxRow = 45;
        for (int i = minRow; i < maxRow; i++) {
            inv.setItem(i, Items.createItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, 0, " "));
        }
        inv.setItem(0, Items.createItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(8, Items.createItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(9, Items.createItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(17, Items.createItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(18, Items.createItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(26, Items.createItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(27, Items.createItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(35, Items.createItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(36, Items.createItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(44, Items.createItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(13, stack);
        ItemStack anvil = new ItemStack(Material.ANVIL);
        ItemMeta anvilmeta = anvil.getItemMeta();
        anvilmeta.setDisplayName("§aReforge Item");
        List<String> anvilLore = new ArrayList<String>();
        anvilLore.add("§7Reforges the above item, giving");
        anvilLore.add("§7it a random item modifier that");
        anvilLore.add("§7boosts its stats.");
        anvilLore.add("");
        anvilLore.add("§7Cost");
        anvilLore.add("§6" + cost +" Coins");
        anvilmeta.setLore(anvilLore);
        anvil.setItemMeta(anvilmeta);
        NBTItem nbti = new NBTItem(anvil);
        nbti.setInteger("cost",cost);
        nbti.setString("type",type);
        anvil = nbti.getItem();
        inv.setItem(22, anvil);
        inv.setItem(40, Items.createItemStack(Material.BARRIER, 1, 0, "§cClose"));
        ItemStack bag = Items.createHead("http://textures.minecraft.net/texture/1a11a7f11bcd5784903c5201d08261c4df8379109d6e611c1cd3ededf031afed");
        ItemMeta bagmeta = bag.getItemMeta();
        bagmeta.setDisplayName("§aAccessory Bag Reforging");
        List<String> bagLore = new ArrayList<>();
        bagLore.add("§7Apply a random reforge to all of");
        bagLore.add("§7the accessories in your");
        bagLore.add("§aAccessory Bag §7at a discount!");
        bagLore.add("");
        bagLore.add("§eClick to view!");
        bagmeta.setLore(bagLore);
        bag.setItemMeta(bagmeta);
        inv.setItem(41, bag);
        p.setItemOnCursor(null);
        p.openInventory(inv);
    }
}
