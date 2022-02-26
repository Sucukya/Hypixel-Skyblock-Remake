package me.sucukya.listeners;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Pets;
import me.sucukya.utility.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.*;

public class petsMenu implements Listener {

    @EventHandler
    public void onClickInv(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory() == null) {} else {
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)) {} else {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPets")) {
                    e.setCancelled(true);
                    openMenu(p);
                }
            }
        }
    }

    public static void openMenu(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, "§8Pets");
        int glassminRow = 0;
        int glassmaxRow = 54;
        for (int i = glassminRow; i < glassmaxRow; i++) {
            inv.setItem(i, Items.createItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, 0, " "));
        }

        int[] clearfields = {10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43};
        for (int id : clearfields) {
            inv.clear(id);
        }


        File pets = new File("plugins//HPSBR//Pets//players//" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration petsconfig = YamlConfiguration.loadConfiguration(pets);

        ArrayList<String> ownedpetslist = null;
        ArrayList<Integer> worthList = new ArrayList<>();
        HashMap<Integer, String> order = new HashMap<Integer, String>();
        HashMap<String, Integer> page = new HashMap<String, Integer>();
        HashMap<String, Integer> rarityworth = new HashMap<String, Integer>();
        HashMap<Integer, String> slot = new HashMap<Integer, String>();


        rarityworth.put("common", 1000);
        rarityworth.put("uncommon", 2000);
        rarityworth.put("rare", 3000);
        rarityworth.put("epic", 4000);
        rarityworth.put("legendary", 5000);
        rarityworth.put("mythic", 6000);

        if (petsconfig.contains("ownedpets")) {
            String[] elements = petsconfig.getString("ownedpets").split(",");
            List<String> list = Arrays.asList(elements);
            ownedpetslist = new ArrayList<>(list);
            for (int i = 0; i < ownedpetslist.size(); i++) {
                ConfigurationSection cs = petsconfig.getConfigurationSection(ownedpetslist.get(i));
                int level = cs.getInt("level");
                int xp = cs.getInt("xp");
                String rarity = cs.getString("rarity");
                String type = cs.getString("type");
                String item = cs.getString("item");
                if (i <= 28) {
                    page.put(ownedpetslist.get(i), 1);
                } else if (i > 28 && i <= 56) {
                    page.put(ownedpetslist.get(i), 2);
                } else if (i > 56 && i <= 84) {
                    page.put(ownedpetslist.get(i), 3);
                } else if (i > 84 && i <= 112) {
                    page.put(ownedpetslist.get(i), 4);
                }
                if (page.get(ownedpetslist.get(i)) == 1) {
                    int worth = rarityworth.get(rarity) + level + (xp / 1000 );
                    if (worthList.contains(worth)) {
                        worth = worth - 1;
                        worthList.add(worth);
                        order.put(worth, ownedpetslist.get(i));
                    } else {
                        worthList.add(worth);
                        order.put(worth, ownedpetslist.get(i));
                    }

                }
            }
        }
        int i = 9;
        while(!order.isEmpty()) {
            int worth = Collections.max(order.keySet());
            String id = order.get(worth);

                if (i == 16 || i == 25 || i == 34) {
                    i = i + 3;
                } else {
                    i++;
                }
                slot.put(i, id);
                order.remove(worth);
        }
        Iterator it2 = slot.keySet().iterator();
        while(it2.hasNext()){
            Object next = it2.next();
            String id = slot.get(next);
            it2.remove();
            ConfigurationSection cs = petsconfig.getConfigurationSection(id);
            int level = cs.getInt("level");
            int xp = cs.getInt("xp");
            String rarity = cs.getString("rarity");
            String type = cs.getString("type");
            String item = cs.getString("item");
            String head = cs.getString("head");
            String pettype = cs.getString("pettype");

            ItemStack stack = Items.createHead(head);
            ItemMeta meta = stack.getItemMeta();
            meta.setDisplayName("§7[Lvl "+ level + "] " + Pets.raritycolormap.get(rarity) + type);
            List<String> lore = new ArrayList<>();
            String raritypet = rarity.substring(0, 1).toUpperCase() + rarity.substring(1) + "Pet";
            lore.add("§8" + pettype + " Pet");
            lore.add("");
            File typefile = new File("plugins//HPSBR//Pets//type//" + type.toLowerCase() + ".yml");
            YamlConfiguration typeconfig = YamlConfiguration.loadConfiguration(typefile);
            double hp = 0;
            double def = 0;
            double str = 0;
            double speed = 0;
            double cchance = 0;
            double cdamage = 0;
            double bonusas = 0;
            double mana = 0;
            double scchance = 0;
            double magicfind = 0;
            double petluck = 0;
            double truedef = 0;
            double ferocity = 0;
            if(typeconfig.contains("hp")) {
                hp = typeconfig.getDouble("hp") * level;
            }
            if(typeconfig.contains("def")) {
                def = typeconfig.getDouble("def") * level;
            }
            if(typeconfig.contains("str")) {
                str = typeconfig.getDouble("str") * level;
            }
            if(typeconfig.contains("speed")) {
                speed = typeconfig.getDouble("speed") * level;
            }
            if(typeconfig.contains("cchance")) {
                cchance = typeconfig.getDouble("cchance") * level;
            }
            if(typeconfig.contains("cdamage")) {
                cdamage = typeconfig.getDouble("cdamage") * level;
            }
            if(typeconfig.contains("bonusas")) {
                bonusas = typeconfig.getDouble("bonusas") * level;
            }
            if(typeconfig.contains("mana")) {
                mana = typeconfig.getDouble("mana") * level;
            }
            if(typeconfig.contains("scchance")) {
                scchance = typeconfig.getDouble("scchance") * level;
            }
            if(typeconfig.contains("magicfind")) {
                magicfind = typeconfig.getDouble("magicfind") * level;
            }
            if(typeconfig.contains("petluck")) {
                petluck = typeconfig.getDouble("petluck") * level;
            }
            if(typeconfig.contains("truedef")) {
                truedef = typeconfig.getDouble("truedef") * level;
            }
            if(typeconfig.contains("ferocity")) {
                ferocity = typeconfig.getDouble("ferocity") * level;
            }

            if(str > 0) {
                lore.add("§7Strength: §a+" + str);
            }
            if(cchance > 0) {
                lore.add("§7Crit Chance: §a+" + cchance + "%");
            }
            if(cdamage > 0) {
                lore.add("§7Crit Damage: §a+" + cdamage + "%");
            }
            if(bonusas > 0) {
                lore.add("§7Bonus Attack Speed: §a+" + bonusas + "%");
            }
            if(scchance > 0) {
                lore.add("§7Sea Creature Chance: §a+" + scchance+ "%");
            }
            if(hp > 0) {
                lore.add("§7Health: §a+" + hp +" HP");
            }
            if(def > 0) {
                lore.add("§7Defense: §a+" + def );
            }
            if(mana > 0) {
                lore.add("§7Intelligence: §a+" + mana );
            }
            if(speed > 0) {
                lore.add("§7Speed: §a+" + speed +"%");
            }
            if(truedef > 0) {
                lore.add("§7True Defense: §a+" + truedef );
            }
            if(magicfind > 0) {
                lore.add("§7Magic Find: §a+" + magicfind );
            }
            if(petluck > 0) {
                lore.add("§7Pet Luck: §a+" + petluck );
            }
            if(ferocity > 0) {
                lore.add("§7Ferocity: §a+" + ferocity );
            }
            if(hp > 0 || def > 0 || speed > 0 || mana > 0 || truedef > 0 || magicfind > 0 || petluck > 0 || str > 0 || cchance > 0 || cdamage > 0 || bonusas > 0 || scchance > 0 || ferocity > 0) {
                lore.add(" ");
            }


            if(level < 100) {
                lore.add("§7Progress to Level " + (level + 1) + ": §e0%");
                lore.add("§7--------------------- §e" + xp + "/0");
            } else {
                lore.add("§b§lMAX LEVEL");
            }
            lore.add("§eClick to summon!");
            meta.setLore(lore);
            stack.setItemMeta(meta);

            NBTItem itemnbt = new NBTItem(stack);
            itemnbt.setString("id", id);
            stack = itemnbt.getItem();

            inv.setItem((int) next,stack);

        }

        ItemStack pethider = new ItemStack(Material.STONE_BUTTON,1);
        ItemMeta pethidermeta = pethider.getItemMeta();
        if(Pets.hidepets.contains(p.getUniqueId())) {
            pethidermeta.setDisplayName("§cHide Pets");
        } else {
            pethidermeta.setDisplayName("§aHide Pets");
        }
        List<String> pethiderlore = new ArrayList<>();
        pethiderlore.add("§7Hide all pets which are little");
        pethiderlore.add("§7heads from being visible in the");
        pethiderlore.add("§7world");
        pethiderlore.add("");
        pethiderlore.add("§7Pet effects remain active.");
        pethiderlore.add("");
        if(Pets.hidepets.contains(p.getUniqueId())) {
            pethiderlore.add("§7Currently: §cPets hidden!");
        } else {
            pethiderlore.add("§7Currently: §aPets shown!");
        }
        if(petsconfig.getString("equipedpet").equalsIgnoreCase("None")) {
            pethiderlore.add("§7Selected Pet: §cNone");
        } else {
            ConfigurationSection cs2 = petsconfig.getConfigurationSection(petsconfig.getString("equipedpet"));
            String rarity2 = cs2.getString("rarity");
            String type2 = cs2.getString("type");
            pethiderlore.add("§7Selected pet: " + Pets.raritycolormap.get(rarity2) + type2);
        }
        pethiderlore.add("");
        if(Pets.hidepets.contains(p.getUniqueId())) {
            pethiderlore.add("§eClick to show!");
        } else {
            pethiderlore.add("§eClick to hide!");
        }

        pethidermeta.setLore(pethiderlore);
        pethider.setItemMeta(pethidermeta);


        ItemStack petconvert = null;
        if(Pets.convertlist.contains(p)) {
            petconvert = new ItemStack(Material.LIME_DYE,1);
        } else {
            petconvert = new ItemStack(Material.GRAY_DYE,1);
        }
        ItemMeta petconvertmeta = petconvert.getItemMeta();
        petconvertmeta.setDisplayName("§aConvert Pet to an Item");
        List<String> petconvertlore = new ArrayList<>();
        petconvertlore.add("§7Enable this setting and click");
        petconvertlore.add("§7any pet to convert it to an");
        petconvertlore.add("§7item.");
        petconvertlore.add("");
        if(Pets.convertlist.contains(p)) {
            petconvertlore.add("§aEnabled");
        } else {
            petconvertlore.add("§cDisabled");
        }
        petconvertmeta.setLore(petconvertlore);
        petconvert.setItemMeta(petconvertmeta);

        inv.setItem(4,Items.createItemStack(Material.BONE,1,0,"§aPlaceholder"));
        inv.setItem(46,Items.createItemStack(Material.BONE,1,0,"§aPlaceholder"));
        inv.setItem(47,Items.createItemStack(Material.BONE,1,0,"§aPlaceholder"));
        inv.setItem(48,Items.createItemStack(Material.BONE,1,0,"§aPlaceholder"));
        inv.setItem(49,Items.createItemStack(Material.BARRIER,1,0,"§cClose"));
        inv.setItem(50,petconvert);
        inv.setItem(51,pethider);
        inv.setItem(53,Items.createItemStack(Material.BONE,1,0,"§aPlaceholder"));


        p.openInventory(inv);
    }

}
