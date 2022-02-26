package me.sucukya.listeners;

import me.sucukya.utility.Items;
import me.sucukya.utility.inventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class AccessoryBag implements Listener {
    int slots = 3;
    public void openMenu(Player p) {
        File file = new File("plugins//HPSBR//inventories//" + p.getUniqueId() + ".yml");
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
        if (conf.contains("accessorybagpage1")) {
            Inventory inv = inventoryManager.stringToInventory(conf.getString("accessorybagpage1"));
            for(int i = 0; i < slots; i++) {
                if(inv.getItem(i) != null) {
                    if (inv.getItem(i).getType().equals(Material.BLACK_STAINED_GLASS_PANE)) {
                        inv.setItem(i, new ItemStack(Material.AIR));
                    }
                }
            }
            p.openInventory(inv);
        } else {
            Inventory inv = Bukkit.createInventory(null, 54, "§8Accessory Bag");
            int minRow = 0;
            int maxRow = 54;
            for (int i = minRow; i < maxRow; i++) {
                inv.setItem(i, Items.createItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, 0, " "));
            }
            inv.setItem(53, Items.createItemStack(Material.ARROW, 1, 0, "§aPage 2"));
            inv.setItem(49, Items.createItemStack(Material.BARRIER, 1, 0, "§cClose"));
            inv.setItem(48, Items.createItemStack(Material.ARROW, 1, 0, "§aGo Back"));
            for(int i = 0; i < slots; i++) {
                inv.setItem(i, new ItemStack(Material.AIR));
            }

            p.openInventory(inv);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (!(e.getClickedInventory() == null)) {
            if (e.getView().getTitle().equalsIgnoreCase("§8SkyBlock Menu")) {
                if (!(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR)) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAccessory Bag")) {
                        openMenu(p);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        if(!(e.getInventory() == null)) {
            if(e.getView().getTitle().equalsIgnoreCase("§8Accessory Bag")) {
                Inventory inv = e.getInventory();
                InventoryView view = e.getView();
                File file = new File("plugins//HPSBR//inventories//" + e.getPlayer().getUniqueId() + ".yml");
                YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
                conf.set("accessorybagpage1", inventoryManager.inventoryToString(inv,view));
                try {
                    conf.save(file);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
