//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge;

import me.sucukya.utility.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class openReforge implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent e) {
        if(e.getRightClicked().getCustomName().equalsIgnoreCase("§fBlacksmith")) {
            open(e.getPlayer());
            }
        }

    public static void open(Player p){
        Inventory inv = Bukkit.createInventory(null, 45, "§8Reforge Item");
        int minRow = 0;
        int maxRow = 45;
        for (int i = minRow; i < maxRow; i++) {
            inv.setItem(i, Items.createItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, 0, " "));
        }
        inv.setItem(0, Items.createItemStack(Material.RED_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(8, Items.createItemStack(Material.RED_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(9, Items.createItemStack(Material.RED_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(17, Items.createItemStack(Material.RED_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(18, Items.createItemStack(Material.RED_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(26, Items.createItemStack(Material.RED_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(27, Items.createItemStack(Material.RED_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(35, Items.createItemStack(Material.RED_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(36, Items.createItemStack(Material.RED_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(44, Items.createItemStack(Material.RED_STAINED_GLASS_PANE, 1, 0, " "));
        ItemStack air = new ItemStack(Material.AIR);
        inv.setItem(13, air);
        ItemStack anvil = new ItemStack(Material.ANVIL);
        ItemMeta anvilmeta = anvil.getItemMeta();
        anvilmeta.setDisplayName("§eReforge Item");
        List<String> anvilLore = new ArrayList<String>();
        anvilLore.add("§7Place an item above to reforge");
        anvilLore.add("§7it! Reforging items adds a");
        anvilLore.add("§7random modifier to the item that");
        anvilLore.add("§7grants stat boosts.");
        anvilmeta.setLore(anvilLore);
        anvil.setItemMeta(anvilmeta);
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

        p.openInventory(inv);
    }

}
