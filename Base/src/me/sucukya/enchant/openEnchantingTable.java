//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.enchant;

import me.sucukya.utility.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class openEnchantingTable implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getClickedBlock() == null || e.getClickedBlock().getType().isAir()) {
        } else {
            if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if(e.getClickedBlock().getType().equals(Material.ENCHANTING_TABLE)) {
                    e.setCancelled(true);
                    open(p);
                }
            }
        }
    }

    public static void open(Player p){
        Inventory inv = Bukkit.createInventory(null, 54, "§8Enchant Item");
        int minRow = 0;
        int maxRow = 54;
        for (int i = minRow; i < maxRow; i++) {
            inv.setItem(i, Items.createItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, 0, " "));
        }
        inv.setItem(0, Items.createItemStack(Material.YELLOW_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(8, Items.createItemStack(Material.YELLOW_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(45, Items.createItemStack(Material.YELLOW_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(53, Items.createItemStack(Material.YELLOW_STAINED_GLASS_PANE, 1, 0, " "));
        inv.setItem(49, Items.createItemStack(Material.BARRIER, 1, 0, "§cClose"));
        for (int i = 2; i < 7; i++) {
            inv.setItem(i, Items.createItemStack(Material.RED_STAINED_GLASS_PANE, 1, 0, " "));
        }
        inv.setItem(12,Items.createItemStack(Material.RED_STAINED_GLASS_PANE,1,0," "));
        inv.setItem(14,Items.createItemStack(Material.RED_STAINED_GLASS_PANE,1,0," "));

        ItemStack eitem = new ItemStack(Material.GRAY_DYE);
        ItemMeta eitemmeta = eitem.getItemMeta();
        eitemmeta.setDisplayName("§cEnchant Item");
        List<String> eitemlore = new ArrayList<>();
        eitemlore.add("§7Place an item in the open slot");
        eitemlore.add("§7to enchant it!");
        eitemmeta.setLore(eitemlore);
        eitem.setItemMeta(eitemmeta);

        inv.setItem(29,eitem);
        inv.setItem(31,eitem);
        inv.setItem(33,eitem);

        ItemStack air = new ItemStack(Material.AIR);
        inv.setItem(13,air);


        p.openInventory(inv);
    }


}
