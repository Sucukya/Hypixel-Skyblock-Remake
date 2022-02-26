//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.utility.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class refreshAnvil implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory() != null) {
            if (e.getView().getType() != InventoryType.ANVIL) {
                if (e.getView().getTitle().equalsIgnoreCase("§8Reforge Item")) {
                    if (e.getSlot() == 13) {
                        ItemStack stack = e.getCursor();
                        if (e.getCurrentItem() == null) {
                            if (stack.getType().isAir()) {
                                openReforge.open(p);
                            } else {

                                NBTItem nbti = new NBTItem(stack);
                                if (nbti.getKeys().contains("reforgable")) {
                                    boolean rfgable = nbti.getBoolean("reforgable");
                                    if (rfgable) {
                                        String rarity = nbti.getString("rarity");
                                        String type = nbti.getString("type");

                                        editAnvil.edit(rarity, type, stack,p);
                                    } else {
                                        ItemStack error = new ItemStack(Material.BARRIER);
                                        ItemMeta errormeta = error.getItemMeta();
                                        errormeta.setDisplayName("§cError");
                                        List<String> errorlore = new ArrayList<>();
                                        errorlore.add("§7You cannot reforge this item");
                                        errormeta.setLore(errorlore);
                                        error.setItemMeta(errormeta);

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
                                        inv.setItem(13, stack);
                                        inv.setItem(22, error);
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
                            }
                        } else {
                            if (stack.getType().isAir()) {
                                if(e.getInventory().getItem(13) == null || e.getInventory().getItem(13).getType().isAir()) {
                                } else {
                                    p.getInventory().addItem(e.getInventory().getItem(13));
                                    openReforge.open(p);
                                }
                            } else {
                                NBTItem nbti = new NBTItem(stack);
                                if (nbti.getKeys().contains("reforgable")) {
                                    boolean rfgable = nbti.getBoolean("reforgable");
                                    if (rfgable) {
                                        p.getInventory().addItem(e.getInventory().getItem(13));
                                        String rarity = nbti.getString("rarity");
                                        String type = nbti.getString("type");

                                        editAnvil.edit(rarity, type, stack,p);
                                    } else {
                                        p.getInventory().addItem(e.getInventory().getItem(13));
                                        ItemStack error = new ItemStack(Material.BARRIER);
                                        ItemMeta errormeta = error.getItemMeta();
                                        errormeta.setDisplayName("§cError");
                                        List<String> errorlore = new ArrayList<>();
                                        errorlore.add("§7You cannot reforge this item");
                                        errormeta.setLore(errorlore);
                                        error.setItemMeta(errormeta);

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
                                        inv.setItem(13, stack);
                                        inv.setItem(22, error);
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

                            }
                        }

                    }
                }
            }
        }
    }

}
