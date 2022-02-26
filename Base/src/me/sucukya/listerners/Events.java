//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.listerners;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Main;
import me.sucukya.location.CheckLocation;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Events implements Listener {

    public static ArrayList<Material> fortuneAffected = new ArrayList<>();

    //PlaceBlock Event
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        NBTItem nbti = new NBTItem(p.getInventory().getItemInOffHand());
        if (!Main.buildMode.contains(p)) {
            if (p.getWorld().equals(Bukkit.getWorld("world"))) {
                e.setCancelled(true);
            } else if (p.getWorld().equals("map_" + p.getUniqueId() + "_" + nbti.getInteger("profile"))) {
                e.setCancelled(false);
            }
        }
    }

    //BlockBreak Event
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        fortuneAffected.add(Material.IRON_INGOT);
        fortuneAffected.add(Material.GOLD_INGOT);
        fortuneAffected.add(Material.DIAMOND);
        fortuneAffected.add(Material.REDSTONE);
        fortuneAffected.add(Material.EMERALD);
        fortuneAffected.add(Material.COAL);
        Player p = e.getPlayer();
        NBTItem nbti = new NBTItem(p.getInventory().getItemInOffHand());
        if (!Main.buildMode.contains(p)) {
            if (p.getWorld().equals(Bukkit.getWorld("world"))) {
                e.setCancelled(true);
            } else if (p.getWorld().equals("map_" + p.getUniqueId() + "_" + nbti.getInteger("profile"))) {
                e.setCancelled(false);
            }
        } else {
            if (CheckLocation.locMap2.get(p).equalsIgnoreCase("cm") || CheckLocation.locMap2.get(p).equalsIgnoreCase("cm2") || CheckLocation.locMap2.get(p).equalsIgnoreCase("gm") || CheckLocation.locMap2.get(p).equalsIgnoreCase("dc")) {
                if (p.getInventory().getItemInMainHand() == null || p.getInventory().getItemInMainHand().getType() == Material.AIR) {
                } else {
                    if (Main.tools.contains(p.getInventory().getItemInMainHand().getType())) {
                        if (nbti.getKeys().contains("totalenchs")) {
                            if (nbti.getKeys().contains("e1")) {
                                if (nbti.getKeys().contains("e52")) {
                                    ItemStack stack = new ItemStack(e.getBlock().getType());
                                    ItemMeta meta = stack.getItemMeta();
                                    List<String> lore = new ArrayList<>();
                                    lore.add("§f§lCOMMON");
                                    meta.setLore(lore);
                                    stack.setItemMeta(meta);
                                    e.setDropItems(false);
                                    p.getInventory().addItem(stack);
                                } else if (nbti.getKeys().contains("e53")) {
                                    Material material = e.getBlock().getType();
                                    e.setDropItems(false);
                                    switch (material) {
                                        case IRON_ORE:
                                            material = Material.IRON_INGOT;
                                            SmeltingTouch2(material, nbti, p);
                                            break;
                                        case GOLD_ORE:
                                            material = Material.GOLD_INGOT;
                                            SmeltingTouch2(material, nbti, p);
                                            break;
                                        case COBBLESTONE:
                                            material = Material.STONE;
                                            SmeltingTouch2(material, nbti, p);
                                            break;
                                        case OAK_LOG:
                                            material = Material.CHARCOAL;
                                            SmeltingTouch2(material, nbti, p);
                                            break;
                                        case BIRCH_LOG:
                                            material = Material.CHARCOAL;
                                            SmeltingTouch2(material, nbti, p);
                                            break;
                                        case DARK_OAK_LOG:
                                            material = Material.CHARCOAL;
                                            SmeltingTouch2(material, nbti, p);
                                            break;
                                        case ACACIA_LOG:
                                            material = Material.CHARCOAL;
                                            SmeltingTouch2(material, nbti, p);
                                            break;
                                        case JUNGLE_LOG:
                                            material = Material.CHARCOAL;
                                            SmeltingTouch2(material, nbti, p);
                                            break;
                                        default:
                                            for (ItemStack is : e.getBlock().getDrops()) {
                                                ItemMeta meta = is.getItemMeta();
                                                List<String> lore = new ArrayList<>();
                                                lore.add("§f§lCOMMON");
                                                meta.setLore(lore);
                                                is.setItemMeta(meta);
                                                e.setDropItems(false);
                                                if (nbti.getKeys().contains("e11")) {
                                                    Fortune2(is, nbti, p);
                                                } else {
                                                    p.getInventory().addItem(is);
                                                }
                                            }
                                    }
                                } else {
                                    for (ItemStack is : e.getBlock().getDrops()) {
                                        ItemMeta meta = is.getItemMeta();
                                        List<String> lore = new ArrayList<>();
                                        lore.add("§f§lCOMMON");
                                        meta.setLore(lore);
                                        is.setItemMeta(meta);
                                        if (nbti.getKeys().contains("e11")) {
                                            Fortune2(is, nbti, p);
                                            e.setDropItems(false);
                                        } else {
                                            p.getInventory().addItem(is);
                                            e.setDropItems(false);
                                        }
                                    }
                                }
                            } else {
                                if (nbti.getKeys().contains("e52")) {
                                    e.setDropItems(false);
                                    ItemStack stack = new ItemStack(e.getBlock().getType());
                                    ItemMeta meta = stack.getItemMeta();
                                    List<String> lore = new ArrayList<>();
                                    lore.add("§f§lCOMMON");
                                    meta.setLore(lore);
                                    stack.setItemMeta(meta);
                                    p.getWorld().dropItem(e.getBlock().getLocation(), stack);
                                } else if (nbti.getKeys().contains("e53")) {
                                    Material material = e.getBlock().getType();
                                    switch (material) {
                                        case IRON_ORE:
                                            material = Material.IRON_INGOT;
                                            SmeltingTouch1(material, nbti, p, e);
                                            break;
                                        case GOLD_ORE:
                                            material = Material.GOLD_INGOT;
                                            SmeltingTouch1(material, nbti, p, e);
                                            break;
                                        case COBBLESTONE:
                                            material = Material.STONE;
                                            SmeltingTouch1(material, nbti, p, e);
                                            break;
                                        case OAK_LOG:
                                            material = Material.CHARCOAL;
                                            SmeltingTouch1(material, nbti, p, e);
                                            break;
                                        case BIRCH_LOG:
                                            material = Material.CHARCOAL;
                                            SmeltingTouch1(material, nbti, p, e);
                                            break;
                                        case DARK_OAK_LOG:
                                            material = Material.CHARCOAL;
                                            SmeltingTouch1(material, nbti, p, e);
                                            break;
                                        case ACACIA_LOG:
                                            material = Material.CHARCOAL;
                                            SmeltingTouch1(material, nbti, p, e);
                                            break;
                                        case JUNGLE_LOG:
                                            material = Material.CHARCOAL;
                                            SmeltingTouch1(material, nbti, p, e);
                                            break;
                                        default:
                                            for (ItemStack is : e.getBlock().getDrops()) {
                                                ItemMeta meta = is.getItemMeta();
                                                List<String> lore = new ArrayList<>();
                                                lore.add("§f§lCOMMON");
                                                meta.setLore(lore);
                                                is.setItemMeta(meta);
                                                e.setDropItems(false);
                                                if (nbti.getKeys().contains("e11")) {
                                                    Fortune1(is, nbti, p, e);
                                                } else {
                                                    p.getWorld().dropItem(e.getBlock().getLocation(), is);
                                                }
                                            }
                                    }
                                } else if (nbti.getKeys().contains("e11")) {
                                    for (ItemStack is : e.getBlock().getDrops()) {
                                        ItemMeta meta = is.getItemMeta();
                                        List<String> lore = new ArrayList<>();
                                        lore.add("§f§lCOMMON");
                                        meta.setLore(lore);
                                        is.setItemMeta(meta);
                                        e.setDropItems(false);
                                        Fortune1(is, nbti, p, e);
                                    }
                                }
                            }
                        } else {
                            for (ItemStack is : e.getBlock().getDrops()) {
                                ItemMeta meta = is.getItemMeta();
                                List<String> lore = new ArrayList<>();
                                lore.add("§f§lCOMMON");
                                meta.setLore(lore);
                                is.setItemMeta(meta);
                                e.setDropItems(false);
                                p.getWorld().dropItem(e.getBlock().getLocation(), is);
                            }
                        }
                    }
                }
            } else {
                e.setCancelled(false);
            }
        }
        }

        public static void SmeltingTouch1 (Material material, NBTItem nbti, Player p, BlockBreakEvent e){
            ItemStack stack = new ItemStack(material);
            ItemMeta meta = stack.getItemMeta();
            List<String> lore = new ArrayList<>();
            lore.add("§f§lCOMMON");
            meta.setLore(lore);
            stack.setItemMeta(meta);
            if (nbti.getKeys().contains("e11")) {
                Random rand = new Random();
                int random = rand.nextInt(100);
                int level = nbti.getInteger("e11");
                if (random <= level * 10) {
                    if (fortuneAffected.contains(stack.getType())) {
                        p.getWorld().dropItem(e.getBlock().getLocation(), stack);
                        p.getWorld().dropItem(e.getBlock().getLocation(), stack);
                    } else {
                        p.getWorld().dropItem(e.getBlock().getLocation(), stack);
                    }
                }
            } else {
                p.getWorld().dropItem(e.getBlock().getLocation(), stack);
            }
        }
        public static void SmeltingTouch2 (Material material, NBTItem nbti, Player p){
            ItemStack stack = new ItemStack(material);
            ItemMeta meta = stack.getItemMeta();
            List<String> lore = new ArrayList<>();
            lore.add("§f§lCOMMON");
            meta.setLore(lore);
            stack.setItemMeta(meta);
            if (nbti.getKeys().contains("e11")) {
                Random rand = new Random();
                int random = rand.nextInt(100);
                int level = nbti.getInteger("e11");
                if (random <= level * 10) {
                    if (fortuneAffected.contains(stack.getType())) {
                        p.getInventory().addItem(stack);
                        p.getInventory().addItem(stack);
                    } else {
                        p.getInventory().addItem(stack);
                    }
                }
            } else {
                p.getInventory().addItem(stack);
            }
        }
        public static void Fortune1 (ItemStack is, NBTItem nbti, Player p, BlockBreakEvent e){
            Random rand = new Random();
            int random = rand.nextInt(100);
            int level = nbti.getInteger("e11");
            if (random <= level * 10) {
                if (fortuneAffected.contains(is.getType())) {
                    p.getWorld().dropItem(e.getBlock().getLocation(), is);
                    p.getWorld().dropItem(e.getBlock().getLocation(), is);
                } else {
                    p.getWorld().dropItem(e.getBlock().getLocation(), is);
                }
            } else {
                p.getWorld().dropItem(e.getBlock().getLocation(), is);
            }
        }
        public static void Fortune2 (ItemStack is, NBTItem nbti, Player p){
            Random rand = new Random();
            int random = rand.nextInt(100);
            int level = nbti.getInteger("e11");
            if (random <= level * 10) {
                if (fortuneAffected.contains(is.getType())) {
                    p.getInventory().addItem(is);
                    p.getInventory().addItem(is);
                } else {
                    p.getInventory().addItem(is);
                }
            } else {
                p.getInventory().addItem(is);
            }
        }

        //Drop Event
        @EventHandler
        public void onDrop (PlayerDropItemEvent e){
            if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§aSkyBlock Menu §7(Right Click)")) {
                e.setCancelled(true);
                e.getPlayer().closeInventory();
                NBTItem stats = new NBTItem(e.getPlayer().getInventory().getItemInOffHand());
                me.sucukya.playerStats.weaponStat.reset(e.getPlayer(), stats, e.getPlayer().getInventory().getItemInOffHand());
                Bukkit.getScheduler().runTaskLater(Main.getMain(), new Runnable() {
                    @Override
                    public void run() {
                        e.getItemDrop().remove();
                    }
                }, 600L);
            }
        }

        //InventoryClickEvent
        @EventHandler
        public void onClick (InventoryClickEvent e){
            Player p = (Player) e.getWhoClicked();
                if (e.getView().getTitle().equalsIgnoreCase("§8SkyBlock Menu")) {
                    if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
                    } else {
                        e.setCancelled(true);
                    }
                }
                if (e.getView().getTitle().equalsIgnoreCase("§8Your SkyBlock Profile")) {
                    if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
                    } else {
                        if (e.getCurrentItem().getType().equals(Material.ARROW)) {
                            menuOpen.openMenu(p);
                        } else {
                            e.setCancelled(true);
                        }
                    }
                }
        }

        //HungerEvent
        @EventHandler
        public void onHunger (FoodLevelChangeEvent e){
            e.setCancelled(true);
        }

        //PickUpItemEvent
        @EventHandler
        public void onPickUp (EntityPickupItemEvent e){
            if (e.getItem().getType().equals(Material.SCUTE)) {
                e.getItem().remove();
            }
        }

        //SwitchHandEvent
        @EventHandler
        public void onSwitch (PlayerSwapHandItemsEvent e){
            e.setCancelled(true);
        }
}
