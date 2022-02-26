//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.listerners;


import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Main;
import me.sucukya.playerStats.calculateStat;
import me.sucukya.utility.Items;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class menuOpen implements Listener {


    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(!Main.tools.contains(e.getMaterial())) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (p.getOpenInventory().getType() != InventoryType.CHEST) {
                    if (e.getItem() == null || e.getItem().getType() == Material.AIR) {
                    } else {
                        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSkyBlock Menu §7(Right Click)")) {
                            openMenu(p);
                        }
                    }
                } else {
                    e.setCancelled(true);
                }
            }
        }
    }
    @EventHandler
    public void onClickInv(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory() == null) {} else {
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)) {} else {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSkyBlock Menu §7(Right Click)")) {
                    e.setCancelled(true);

                    openMenu(p);
                }
            }
        }
    }


    public static void openMenu(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, "§8SkyBlock Menu");
        int minRow = 0;
        int maxRow = 54;
        for (int i = minRow; i < maxRow; i++) {
            inv.setItem(i, Items.createItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, 0, " "));
        }

        ItemStack accbag = Items.createHead("http://textures.minecraft.net/texture/961a918c0c49ba8d053e522cb91abc74689367b4d8aa06bfc1ba9154730985ff");
        ItemMeta accbagmeta = accbag.getItemMeta();
        accbagmeta.setDisplayName("§aAccessory Bag");
        List<String> accbaglore = new ArrayList<>();
        accbaglore.add("§7A special bag which can hold");
        accbaglore.add("§7Talismans, Rings, Artifacts and");
        accbaglore.add("§7Orbs within it. All will still");
        accbaglore.add("§7work while in this bag!");
        accbaglore.add("");
        accbaglore.add("§eClick to open!");
        accbagmeta.setLore(accbaglore);
        accbag.setItemMeta(accbagmeta);
        inv.setItem(53,accbag);

        ItemStack statHead = new ItemStack(Material.PLAYER_HEAD);
        ItemStack stack = p.getInventory().getItemInOffHand();
        NBTItem nbtistack = new NBTItem(stack);
        SkullMeta skullMeta = (SkullMeta) statHead.getItemMeta();
        skullMeta.setDisplayName("§aYour Profile Stats");
        skullMeta.setOwningPlayer(p);
        List < String > lore = new ArrayList < String > ();
        lore.add("  §c❤ Health §f" + calculateStat.calculate(p,"hp") + " HP");
        lore.add("  §a❈ Defense §f" + calculateStat.calculate(p,"def"));
        lore.add("  §c❁ Strength §f" + calculateStat.calculate(p,"str"));
        lore.add("  §f✦ Speed §f" + calculateStat.calculate(p,"speed"));
        if(calculateStat.calculate(p,"cchance")  <= 100) {
            lore.add("  §9☣ Crit Chance §f" + calculateStat.calculate(p, "cchance") + "%");
        } else {
            lore.add("  §9☣ Crit Chance §f" + "100%");
        }
        lore.add("  §9☠ Crit Damage §f" + calculateStat.calculate(p,"cdamage") + "%");
        if(calculateStat.calculate(p,"bonusas") <= 100) {
            lore.add("  §e⚔ Bonus Attack Speed §f" + calculateStat.calculate(p, "bonusas") + "%");
        } else {
            lore.add("  §e⚔ Bonus Attack Speed §f" + "100%");
        }
        lore.add("  §b✎ Intelligence §f" + calculateStat.calculate(p,"mana"));
        if(calculateStat.calculate(p,"scchance") <= 100) {
            lore.add("  §3α Sea Creature Chance §f" + calculateStat.calculate(p, "scchance") + "%");
        } else {
            lore.add("  §3α Sea Creature Chance §f" +"100%");
        }
        lore.add("  §b✯ Magic Find §f" + calculateStat.calculate(p,"magicfind"));
        lore.add("  §d♣ Pet Luck §f" + calculateStat.calculate(p,"petluck"));
        lore.add("  §f❂ True Defense §f" + calculateStat.calculate(p,"truedef"));
        lore.add("  §c⫽ Ferocity §f" + calculateStat.calculate(p,"ferocity"));
        lore.add("");
        lore.add("§eClick to view more detailed Stats!");
        skullMeta.setLore(lore);
        statHead.setItemMeta(skullMeta);
        inv.setItem(13, statHead);

        //Skills
        ItemStack skills = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta2 = skills.getItemMeta();
        meta2.setDisplayName("§aYour Skills");
        List < String > loreskills = new ArrayList < String > ();
        loreskills.add("§7View your Skill progression and");
        loreskills.add("§7rewards.");
        loreskills.add("");
        loreskills.add("§eClick to view!");
        meta2.setLore(loreskills);
        meta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        skills.setItemMeta(meta2);
        inv.setItem(19, skills);


        //Collections
        ItemStack collec = new ItemStack(Material.PAINTING);
        ItemMeta meta3 = collec.getItemMeta();
        meta3.setDisplayName("§aCollection");
        List < String > lorescollec = new ArrayList < String > ();
        lorescollec.add("§7View all of the items available");
        lorescollec.add("§7in Skyblock. Collect more of an");
        lorescollec.add("§7item to unlock rewards on your");
        lorescollec.add("§7way to becoming a master of");
        lorescollec.add("§7Skyblock!");
        lorescollec.add("");
        lorescollec.add("§eClick to view!");
        meta3.setLore(lorescollec);
        meta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta3.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        collec.setItemMeta(meta3);
        inv.setItem(20, collec);


        //Recipes
        ItemStack recipes = new ItemStack(Material.BOOK);
        ItemMeta meta4 = recipes.getItemMeta();
        meta4.setDisplayName("§aRecipe Book");
        List < String > loresrecipes = new ArrayList < String > ();
        loresrecipes.add("§7Through your adventure, you will");
        loresrecipes.add("§7unlock recipes for all kinds of");
        loresrecipes.add("§7special items! You can view how");
        loresrecipes.add("§7to craft these items here.");
        loresrecipes.add("");
        loresrecipes.add("§eClick to view!");
        meta4.setLore(loresrecipes);
        meta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta4.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta4.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        recipes.setItemMeta(meta4);
        inv.setItem(21, recipes);



        //trades
        ItemStack trades = new ItemStack(Material.EMERALD);
        ItemMeta meta5 = trades.getItemMeta();
        meta5.setDisplayName("§aTrades");
        List < String > lorestrades = new ArrayList < String > ();
        lorestrades.add("§7View your available trades.");
        lorestrades.add("§7These trades are always");
        lorestrades.add("§7available and accesible through");
        lorestrades.add("§7the SkyBlock Menu.");
        lorestrades.add("");
        lorestrades.add("§eClick to view!");
        meta5.setLore(lorestrades);
        meta5.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta5.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        trades.setItemMeta(meta5);
        inv.setItem(22, trades);


        //quests
        ItemStack quests = new ItemStack(Material.WRITABLE_BOOK);
        ItemMeta meta6 = quests.getItemMeta();
        meta6.setDisplayName("§aQuest Log");
        List < String > loresquests = new ArrayList < String > ();
        loresquests.add("§7View your active quests,");
        loresquests.add("§7progress, and rewards.");
        loresquests.add("");
        loresquests.add("§eClick to view!");
        meta6.setLore(loresquests);
        meta6.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta6.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta6.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        quests.setItemMeta(meta6);
        inv.setItem(23, quests);


        //calendar
        ItemStack calendar = new ItemStack(Material.CLOCK);
        ItemMeta meta7 = calendar.getItemMeta();
        meta7.setDisplayName("§aCalendar and Events");
        List < String > lorescalend = new ArrayList < String > ();
        lorescalend.add("§7View the Skyblock Calendar,");
        lorescalend.add("§7upcoming events, and event");
        lorescalend.add("§7rewards!");
        lorescalend.add("");
        lorescalend.add("§eClick to view!");
        meta7.setLore(lorescalend);
        meta7.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta7.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta7.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        calendar.setItemMeta(meta7);
        inv.setItem(24, calendar);


        //ec
        ItemStack ec = new ItemStack(Material.ENDER_CHEST);
        ItemMeta meta8 = ec.getItemMeta();
        meta8.setDisplayName("§aEnder Chest");
        List < String > loresec = new ArrayList < String > ();
        loresec.add("§7Store global items that you want");
        loresec.add("§7to access at any time from");
        loresec.add("§7anywhere here.");
        loresec.add("");
        loresec.add("§eClick to view!");
        meta8.setLore(loresec);
        meta8.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta8.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta8.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ec.setItemMeta(meta8);
        inv.setItem(25, ec);


        //pets
        File petsFile = new File("plugins//HPSBR//Pets//players//" + p.getUniqueId().toString() + ".yml");
        if(petsFile.exists()) {
            YamlConfiguration petsconfig = YamlConfiguration.loadConfiguration(petsFile);
            String equipedpet = petsconfig.getString("equipedpet");
            ItemStack pets = new ItemStack(Material.BONE);
            ItemMeta meta9 = pets.getItemMeta();
            meta9.setDisplayName("§aPets");
            List<String> lorespets = new ArrayList<String>();
            lorespets.add("§7View and manage all of your");
            lorespets.add("§7Pets.");
            lorespets.add("");
            lorespets.add("§7Level up your pets faster by");
            lorespets.add("§7gaining xp in their favorite");
            lorespets.add("§7skill!");
            lorespets.add("");
            if (equipedpet.equalsIgnoreCase("None")) {
                lorespets.add("§7Selected pet: §cNone");
            } else {
                ConfigurationSection cs = petsconfig.getConfigurationSection(equipedpet);
                String type = cs.getString("type");
                String rarity = cs.getString("rarity");
                String raritycolor = "";
                if (rarity.equalsIgnoreCase("common")) {
                    raritycolor = "§f";
                }
                if (rarity.equalsIgnoreCase("uncommon")) {
                    raritycolor = "§a";
                }
                if (rarity.equalsIgnoreCase("rare")) {
                    raritycolor = "§9";
                }
                if (rarity.equalsIgnoreCase("epic")) {
                    raritycolor = "§5";
                }
                if (rarity.equalsIgnoreCase("legendary")) {
                    raritycolor = "§6";
                }
                if (rarity.equalsIgnoreCase("mythic")) {
                    raritycolor = "§d";
                }
                lorespets.add("§7Selected pet: " + raritycolor + type);
            }
            lorespets.add("");
            lorespets.add("§eClick to view!");
            meta9.setLore(lorespets);
            meta9.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta9.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta9.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            pets.setItemMeta(meta9);
            inv.setItem(30, pets);
        } else {
            ItemStack pets = new ItemStack(Material.BONE);
            ItemMeta meta9 = pets.getItemMeta();
            meta9.setDisplayName("§aPets");
            List<String> lorespets = new ArrayList<String>();
            lorespets.add("§7View and manage all of your");
            lorespets.add("§7Pets.");
            lorespets.add("");
            lorespets.add("§7Level up your pets faster by");
            lorespets.add("§7gaining xp in their favorite");
            lorespets.add("§7skill!");
            lorespets.add("");
            lorespets.add("§7Selected pet: §cNone" );
            lorespets.add("");
            lorespets.add("§eClick to view!");
            meta9.setLore(lorespets);
            meta9.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta9.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta9.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            pets.setItemMeta(meta9);
            inv.setItem(30, pets);
        }


        //crafting
        ItemStack crafting = new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta meta10 = crafting.getItemMeta();
        meta10.setDisplayName("§aCrafting Table");
        List < String > lorescrafting = new ArrayList < String > ();
        lorescrafting.add("§7Opens the crafting grid.");
        lorescrafting.add("");
        lorescrafting.add("§eClick to open!");
        meta10.setLore(lorescrafting);
        meta10.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta10.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta10.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        crafting.setItemMeta(meta10);
        inv.setItem(31, crafting);



        //wardrobe
        ItemStack wardrobe = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta11 = (LeatherArmorMeta) wardrobe.getItemMeta();
        meta11.setColor(Color.PURPLE);
        meta11.addEnchant(Enchantment.MENDING, 1, true);
        meta11.setDisplayName("§aWardrobe");
        List < String > loreswar = new ArrayList < String > ();
        loreswar.add("§7Store armor sets and quickly");
        loreswar.add("§7swap between them.");
        loreswar.add("");
        loreswar.add("§eClick to view!");
        meta11.setLore(loreswar);
        meta11.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta11.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta11.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        wardrobe.setItemMeta(meta11);
        inv.setItem(32, wardrobe);

        //fasttravel
        ItemStack fasttravel = Items.createHead("http://textures.minecraft.net/texture/c9c8881e42915a9d29bb61a16fb26d059913204d265df5b439b3d792acd56");
        SkullMeta meta12 = (SkullMeta) fasttravel.getItemMeta();
        meta12.setDisplayName("§bFast Travel");
        List < String > loresft = new ArrayList < String > ();
        loresft.add("§7You can have multiple");
        loresft.add("§7Teleport to islands you've");
        loresft.add("§7already visited.");
        loresft.add("");
        loresft.add("§bRight-click for hub warp!");
        loresft.add("§eClick to pick location!");
        meta12.setLore(loresft);
        meta12.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta12.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta12.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        fasttravel.setItemMeta(meta12);
        inv.setItem(47, fasttravel);

        //profiles
        ItemStack profiles = new ItemStack(Material.NAME_TAG);
        ItemMeta meta13 = profiles.getItemMeta();
        meta13.setDisplayName("§aProfile Management");
        List < String > loresprofiles = new ArrayList < String > ();
        loresprofiles.add("§7You can have multiple");
        loresprofiles.add("§7Skyblock profiles at the");
        loresprofiles.add("§7same time");
        loresprofiles.add("");
        loresprofiles.add("§7Each profile has its own");
        loresprofiles.add("§7island, inventory, quest");
        loresprofiles.add("§7log...");
        loresprofiles.add("");
        loresprofiles.add("§7Profiles §e1§6/§e3");
        loresprofiles.add("§7Playing on: §aPineapple");
        loresprofiles.add("");
        loresprofiles.add("§bPlay with friends using /coop!");
        loresprofiles.add("§eClick to manage!");
        meta13.setLore(loresprofiles);
        meta13.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta13.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta13.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        profiles.setItemMeta(meta13);
        inv.setItem(48, profiles);

        //close
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta meta14 = close.getItemMeta();
        meta14.setDisplayName("§cClose");
        meta14.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta14.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta14.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        close.setItemMeta(meta14);
        inv.setItem(49, close);

        //settings
        ItemStack settings = new ItemStack(Material.REDSTONE_TORCH);
        ItemMeta meta15 = settings.getItemMeta();
        meta15.setDisplayName("§aSettings");
        List < String > loressettings = new ArrayList < String > ();
        loressettings.add("§7View and edit your SkyBlock");
        loressettings.add("§7settings.");
        loressettings.add("");
        loressettings.add("§eClick to view!");
        meta15.setLore(loressettings);
        meta15.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta15.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta15.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        settings.setItemMeta(meta15);
        inv.setItem(50, settings);








        if (p.hasPermission("rpg.create")) {
            inv.setItem(46, Items.createItemStack(Material.NETHER_STAR, 1, 0, "§cAdmin Tools"));
        }


        p.openInventory(inv);
    }


}