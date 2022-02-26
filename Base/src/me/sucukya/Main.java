package me.sucukya;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.commands.*;
import me.sucukya.damage.onHit;
import me.sucukya.damage.takeDamage;
import me.sucukya.enchant.openEnchantingTable;
import me.sucukya.listerners.*;
import me.sucukya.location.CheckLocation;
import me.sucukya.playerStats.*;
import me.sucukya.reforge.clickAnvil;
import me.sucukya.reforge.openReforge;
import me.sucukya.reforge.refreshAnvil;
import me.sucukya.reforge.shiftItem;
import me.sucukya.scoreboard.ScoreBoard;
import me.sucukya.tabAutoComplete.baseComplete;
import me.sucukya.tabAutoComplete.createArmorComplete;
import me.sucukya.tabAutoComplete.createSwordComplete;
import me.sucukya.utility.Files;
import me.sucukya.utility.saveStats;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends JavaPlugin {
    //Neccesary Arraylists
    public static ArrayList < Player > isOnline = new ArrayList < > ();
    public static ArrayList < Player > buildMode = new ArrayList < > ();
    public static HashMap<String, String > enchants = new HashMap<>();
    public static ArrayList < String > weaponEnchants = new ArrayList < > ();
    public static ArrayList < String > bowEnchants = new ArrayList < > ();
    public static ArrayList < String > toolEnchants = new ArrayList < > ();
    public static ArrayList < String > allEnchants = new ArrayList < > ();
    public static ArrayList < String > armorEnchants = new ArrayList < > ();
    public static ArrayList <Material> tools = new ArrayList < > ();

    //Creating Main Instance (For Tasks)
    static Main main;
    public Main() {
        main = this;
    }
    public static Main getMain() {
        return main;
    }

    @Override
    public void onEnable() {
        //Send Starting Message
        System.out.println("Loading Hypixel Skyblock Remake - Base !");
        //Initialize Config
        if (!Files.config.exists()) {
            createConfig();
        } else {
            Files.refresh();
        }
        registerCommands();
        registerListeners();
        //Loading HashMaps for OnlinePlayers
        for(Player all : Bukkit.getOnlinePlayers()) {
            me.sucukya.utility.loadStats.load(all);
            ScoreBoard.sendScoreboard(all);
        }
        //Start Refresh of SendActionBar
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                ActionBarStats.send();
                ScoreBoard.updater();
                GiveSpeed.give();
                checkFor0.check();
                for(Player p : Bukkit.getOnlinePlayers()) {
                    CheckLocation.check(p);
                }
            }
        }, 20L, 10L);

        //Adding all Online Players to List
        for (Player all: Bukkit.getOnlinePlayers()) {
            isOnline.add(all);
        }

        regeneration.regen();

        //Registering Enchantments
        loadEnchants();
        loadTools();
    }

    private void registerCommands() {
        //Registering Commands
        getCommand("refresh").setExecutor(new refresh());
        getCommand("base").setExecutor(new base());
        getCommand("build").setExecutor(new build());
        getCommand("gm").setExecutor(new gm());
        getCommand("test").setExecutor(new test());
        getCommand("reset").setExecutor(new reset());
        getCommand("createarmor").setExecutor(new createArmor());
        getCommand("createsword").setExecutor(new createSword());
        getCommand("sbenchant").setExecutor(new sbEnchant());
        getCommand("convertitem").setExecutor(new convertItem());
        getCommand("recombobulate").setExecutor(new recombobulate());
        getCommand("reforgemenu").setExecutor(new reforgeMenu());

        //Registering Tab-Completers
        getCommand("base").setTabCompleter(new baseComplete());
        getCommand("createarmor").setTabCompleter(new createArmorComplete());
        getCommand("createsword").setTabCompleter(new createSwordComplete());
    }
    private void registerListeners() {
        //Registering Events
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new Events(), this);
        pm.registerEvents(new menuOpen(), this);
        pm.registerEvents(new clickBlank(), this);
        pm.registerEvents(new closeButton(), this);
        pm.registerEvents(new onHit(), this);
        pm.registerEvents(new spawnListener(), this);
        pm.registerEvents(new openReforge(), this);
        pm.registerEvents(new statHead(), this);
        pm.registerEvents(new clickTP(), this);
        pm.registerEvents(new clickAnvil(), this);
        pm.registerEvents(new refreshAnvil(), this);
        pm.registerEvents(new shiftItem(), this);
        pm.registerEvents(new weaponStat(), this);
        pm.registerEvents(new helmetStat(), this);
        pm.registerEvents(new chestplateStat(), this);
        pm.registerEvents(new leggingsStat(), this);
        pm.registerEvents(new bootsStat(), this);
        pm.registerEvents(new helmetShift(), this);
        pm.registerEvents(new chestplateShift(), this);
        pm.registerEvents(new leggingsShift(), this);
        pm.registerEvents(new bootsShift(), this);
        pm.registerEvents(new helmetClick(), this);
        pm.registerEvents(new chestplateClick(), this);
        pm.registerEvents(new leggingsClick(), this);
        pm.registerEvents(new bootsClick(), this);
        pm.registerEvents(new leaveListener(), this);
        pm.registerEvents(new takeDamage(), this);
        pm.registerEvents(new openEnchantingTable(), this);
        pm.registerEvents(new enterPortal(), this);
        pm.registerEvents(new enderChest(), this);
    }
    private void createConfig() {
        //Method to create Config File(for better Overview)
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(Files.config);
        conf.set("Prefix", "§b§lSkyBlock | ");
        try {
            conf.save(Files.config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadEnchants() {
        //Enchants in general
        enchants.put("e1","Telekinesis");
        enchants.put("e2","Scavenger");
        enchants.put("e3","Thunderlord");
        enchants.put("e7","Critical");
        enchants.put("e11","Fortune");
        enchants.put("e15","Protection");
        enchants.put("e16","Growth");
        enchants.put("e17","True Protection");
        enchants.put("e52","Silk Touch");
        enchants.put("e53","Smelting Touch");
        enchants.put("e5","Sharpness");
        enchants.put("e14","Smite");
        enchants.put("e62","Bane_of_Arthropods");
        enchants.put("e22","Enderslayer");
        enchants.put("e23","Cubism");
        enchants.put("e6","First_Strike");
        enchants.put("e10","Effiency");
        enchants.put("e24","Life_Steal");
        enchants.put("e8","Syphon");
        enchants.put("e20","Power");

        //allEnchants
        allEnchants.add("e1");

        //weaponEnchants
        weaponEnchants.add("e2");
        weaponEnchants.add("e3");
        weaponEnchants.add("e7");
        weaponEnchants.add("e5");
        weaponEnchants.add("e14");
        weaponEnchants.add("e62");
        weaponEnchants.add("e22");
        weaponEnchants.add("e23");
        weaponEnchants.add("e6");
        weaponEnchants.add("e8");
        weaponEnchants.add("e24");

        //toolEnchants
        toolEnchants.add("e52");
        toolEnchants.add("e53");
        toolEnchants.add("e11");
        toolEnchants.add("e10");

        //bowEnchants
        bowEnchants.add("e2");
        bowEnchants.add("e20");

        //armorEnchants
        armorEnchants.add("e15");
        armorEnchants.add("e16");
        armorEnchants.add("e17");

    }
    private void loadTools() {
        tools.add(Material.WOODEN_AXE);
        tools.add(Material.WOODEN_PICKAXE);
        tools.add(Material.WOODEN_HOE);
        tools.add(Material.WOODEN_SHOVEL);
        tools.add(Material.STONE_AXE);
        tools.add(Material.STONE_PICKAXE);
        tools.add(Material.STONE_HOE);
        tools.add(Material.STONE_SHOVEL);
        tools.add(Material.IRON_AXE);
        tools.add(Material.IRON_PICKAXE);
        tools.add(Material.IRON_HOE);
        tools.add(Material.IRON_SHOVEL);
        tools.add(Material.GOLDEN_AXE);
        tools.add(Material.GOLDEN_PICKAXE);
        tools.add(Material.GOLDEN_HOE);
        tools.add(Material.GOLDEN_SHOVEL);
        tools.add(Material.DIAMOND_AXE);
        tools.add(Material.DIAMOND_PICKAXE);
        tools.add(Material.DIAMOND_HOE);
        tools.add(Material.DIAMOND_SHOVEL);
        tools.add(Material.NETHERITE_AXE);
        tools.add(Material.NETHERITE_PICKAXE);
        tools.add(Material.NETHERITE_HOE);
        tools.add(Material.NETHERITE_SHOVEL);
    }

    @Override
    public void onDisable() {
        //Send Stopping Message
        System.out.println("Unloading Hypixel Skyblock Remake - Base !");
        for (Player all : Bukkit.getOnlinePlayers()) {
            NBTItem nbti = new NBTItem(all.getInventory().getItemInOffHand());
            saveStats.save(all);
        }
    }
}