package me.sucukya.listerners;

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

import java.io.File;
import java.io.IOException;

public class enderChest implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(!(e.getClickedInventory() == null)) {
            if(e.getView().getTitle().equalsIgnoreCase("§8SkyBlock Menu")) {
                if(!(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR)) {
                    if(e.getCurrentItem().getType() == Material.ENDER_CHEST) {
                        File file = new File("plugins//HPSBR//inventories//" + p.getUniqueId() + ".yml");
                        if(file.exists()) {
                            YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
                            if(conf.contains("enderchestpage1")) {
                                String enderchestpage1 = conf.getString("enderchestpage1");
                                p.openInventory(inventoryManager.stringToInventory(enderchestpage1));
                            }
                        } else {
                            Inventory inv = Bukkit.createInventory(null,54,"§8Ender Chest 1");
                            p.openInventory(inv);
                        }
                    }
                }
            }
        }

    }
    @EventHandler
    public void onEscape(InventoryCloseEvent e) {
        if(!(e.getInventory() == null)) {
            if (e.getView().getTitle().contains("§8Ender Chest")) {
                Inventory inv = e.getInventory();
                InventoryView view = e.getView();
                File file = new File("plugins//HPSBR//inventories//" + e.getPlayer().getUniqueId() + ".yml");
                YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
                conf.set("enderchestpage1", inventoryManager.inventoryToString(inv,view));
                try {
                    conf.save(file);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
