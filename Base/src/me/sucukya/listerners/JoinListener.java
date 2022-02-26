package me.sucukya.listerners;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Main;
import me.sucukya.location.CheckLocation;
import me.sucukya.scoreboard.ScoreBoard;
import me.sucukya.utility.Files;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Files.refresh();
        Player p = e.getPlayer();
        p.sendMessage("uff");
        //Setting Join Message to null
        e.setJoinMessage(null);
        //Setting Base Stuff
        p.setHealth(20);
        p.setCollidable(false);
        p.sendMessage("uff");
        //Setting Stats
        p.sendMessage("test");
        if(Files.alreadyJoined.exists()) {
            p.sendMessage("Uiii");
            if (Files.alreadyJoinedConf.contains(p.getUniqueId().toString())) {
                p.sendMessage("Peniskopfauch");
            } else {
                p.sendMessage("Peniskopf");
                ItemStack stack = new ItemStack(Material.SCUTE);
                ItemMeta meta = stack.getItemMeta();
                meta.setDisplayName(" ");
                stack.setItemMeta(meta);
                NBTItem nbti = new NBTItem(stack);
                nbti.setInteger("basehp", 100);
                nbti.setInteger("bonushp", 0);
                nbti.setInteger("basedef", 0);
                nbti.setInteger("bonusdef", 0);
                nbti.setInteger("basestr", 0);
                nbti.setInteger("bonusstr", 0);
                nbti.setInteger("basespeed", 100);
                nbti.setInteger("bonusspeed", 0);
                nbti.setInteger("basemana", 100);
                nbti.setInteger("bonusmana", 0);
                nbti.setInteger("basecchance", 30);
                nbti.setInteger("bonuscchance", 0);
                nbti.setInteger("basecdamage", 50);
                nbti.setInteger("bonuscdamage", 0);
                nbti.setInteger("chp", 100);
                nbti.setInteger("basepetluck", 0);
                nbti.setInteger("bonuspetluck", 0);
                nbti.setInteger("basebonusas", 0);
                nbti.setInteger("bonusbonusas", 0);
                nbti.setInteger("basemagicfind", 0);
                nbti.setInteger("bonusmagicfind", 0);
                nbti.setInteger("basescchance", 0);
                nbti.setInteger("bonusscchance", 0);
                nbti.setInteger("basetruedef", 0);
                nbti.setInteger("bonustruedef", 0);
                nbti.setInteger("bonusferocity", 0);
                nbti.setInteger("purse", 100);
                stack = nbti.getItem();
                p.getInventory().setItemInOffHand(stack);
                Files.alreadyJoinedConf.set(p.getUniqueId().toString(), 1);
                try {
                    Files.alreadyJoinedConf.save(Files.alreadyJoined);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            p.sendMessage("Peniskopf");
            ItemStack stack = new ItemStack(Material.SCUTE);
            ItemMeta meta = stack.getItemMeta();
            meta.setDisplayName(" ");
            stack.setItemMeta(meta);
            NBTItem nbti = new NBTItem(stack);
            nbti.setInteger("basehp", 100);
            nbti.setInteger("bonushp", 0);
            nbti.setInteger("basedef", 0);
            nbti.setInteger("bonusdef", 0);
            nbti.setInteger("basestr", 0);
            nbti.setInteger("bonusstr", 0);
            nbti.setInteger("basespeed", 100);
            nbti.setInteger("bonusspeed", 0);
            nbti.setInteger("basemana", 100);
            nbti.setInteger("bonusmana", 0);
            nbti.setInteger("basecchance", 30);
            nbti.setInteger("bonuscchance", 0);
            nbti.setInteger("basecdamage", 50);
            nbti.setInteger("bonuscdamage", 0);
            nbti.setInteger("chp", 100);
            nbti.setInteger("basepetluck", 0);
            nbti.setInteger("bonuspetluck", 0);
            nbti.setInteger("basebonusas", 0);
            nbti.setInteger("bonusbonusas", 0);
            nbti.setInteger("basemagicfind", 0);
            nbti.setInteger("bonusmagicfind", 0);
            nbti.setInteger("basescchance", 0);
            nbti.setInteger("bonusscchance", 0);
            nbti.setInteger("basetruedef", 0);
            nbti.setInteger("bonustruedef", 0);
            nbti.setInteger("bonusferocity", 0);
            nbti.setInteger("purse", 100);
            stack = nbti.getItem();
            p.getInventory().setItemInOffHand(stack);
            Files.alreadyJoinedConf.set(p.getUniqueId().toString(), 1);
            try {
                Files.alreadyJoinedConf.save(Files.alreadyJoined);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        me.sucukya.utility.loadStats.load(p);
        Main.isOnline.add(p);
        CheckLocation.check(p);
        //Giving the Skyblock Menu to the Player
        ItemStack menu = new ItemStack(Material.NETHER_STAR);
        ItemMeta menumeta = menu.getItemMeta();
        menumeta.addEnchant(Enchantment.MENDING,1,false);
        menumeta.setDisplayName("§aSkyBlock Menu §7(Right Click)");
        List< String > loremenu = new ArrayList< String >();
        loremenu.add("§7View all of your SkyBlock");
        loremenu.add("§7progress, including your Skills,");
        loremenu.add("§7Collections, Recipes, and more!");
        loremenu.add("");
        loremenu.add("§eClick to open!");
        menumeta.setLore(loremenu);
        menumeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        menumeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        menumeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        menu.setItemMeta(menumeta);
        p.getInventory().setItem(8,menu);
        ScoreBoard.sendScoreboard(p);
        updateHealthBar.update(p);


    }

}