package me.sucukya.commands;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Main;
import me.sucukya.listerners.updateStat;
import me.sucukya.utility.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class base implements CommandExecutor {
    //Really bad method of checking if argument is in cluded in this list!
    String list = "basestr,basehp,basedef,basemana,basecchance,basecdamage,basescchance,basepetluck,basemagicfind,basebonusas,purse,basetruedef,baseferocity";
    @Override
    public boolean onCommand(CommandSender cms, Command cmd, String str, String[] args) {
        Player p = (Player) cms;
        //Check if player has Permission to execute the command!
        if (p.hasPermission("hpsbr.base")) {
            if (args.length == 4) {
                //Getting all values
                String stat = args[0].toLowerCase();
                String arg = args[2];
                String playerStr = args[1];
                Player player = Bukkit.getPlayer(playerStr);
                if (stat.equalsIgnoreCase("purse")) {
                    if (Main.isOnline.contains(player)) {
                        double amount = 0;
                        try {
                            amount = Double.parseDouble(args[3]);
                        } catch (Exception e) {
                            p.sendMessage(Data.prefix + "§cAmount has to be an Integer!");
                        }
                        NBTItem nbti = new NBTItem(player.getInventory().getItemInOffHand());
                        //Getting statBefore
                        double statBefore = nbti.getDouble("purse");
                        //Editing the stat with Switch() Argument
                        switch (arg) {
                            case "add":
                                double statAfter = statBefore + amount;
                                p.sendMessage(Data.prefix + "§aYou set the base §c" + stat.toUpperCase() + " §aof §c" + playerStr + " §ato §c" + statAfter);
                                NBTItem nbtiAdd = new NBTItem(player.getInventory().getItemInOffHand());
                                    nbtiAdd.setDouble("purse", (double) statAfter);
                                    ItemStack stackadd = nbtiAdd.getItem();
                                    player.getInventory().setItemInOffHand(stackadd);
                                    updateStat.update(p, stat);
                                break;
                            case "set":
                                p.sendMessage(Data.prefix + "§aYou set the base §c" + stat.toUpperCase() + " §aof §c" + playerStr + " §ato §c" + amount);
                                NBTItem nbtiset = new NBTItem(player.getInventory().getItemInOffHand());
                                    nbtiset.setDouble(stat, (double) amount);
                                    ItemStack stackset = nbtiset.getItem();
                                    player.getInventory().setItemInOffHand(stackset);
                                    updateStat.update(p, stat);
                                break;
                            case "remove":
                                double statAfter2 = statBefore - amount;
                                p.sendMessage(Data.prefix + "§aYou set the base §c" + stat.toUpperCase() + " §aof §c" + playerStr + " §ato §c" + statAfter2);
                                    NBTItem nbtiremove = new NBTItem(player.getInventory().getItemInOffHand());
                                    nbtiremove.setDouble(stat, (double) statAfter2);
                                    ItemStack stackremove = nbtiremove.getItem();
                                    player.getInventory().setItemInOffHand(stackremove);
                                    updateStat.update(p, stat);
                                break;
                        }
                    } else {
                        p.sendMessage(Data.prefix + "§c This player isn't online!");
                    }
                } else {
                    //Really bad method of checking if argument is in cluded in this list!
                    if (list.contains(stat)) {
                        //Checking if target player is online.
                        if (Main.isOnline.contains(player)) {
                            int amount = 0;
                            try {
                                amount = Integer.parseInt(args[3]);
                            } catch (Exception e) {
                                p.sendMessage(Data.prefix + "§cAmount has to be an Integer!");
                            }
                            NBTItem nbti = new NBTItem(player.getInventory().getItemInOffHand());
                            //Getting statBefore
                            int statBefore = nbti.getInteger(stat);
                            //Editing the stat with Switch() Argument
                            switch (arg) {
                                case "add":
                                    int statAfter = statBefore + amount;
                                    p.sendMessage(Data.prefix + "§aYou set the base §c" + stat.toUpperCase() + " §aof §c" + playerStr + " §ato §c" + statAfter);
                                    NBTItem nbtiAdd = new NBTItem(player.getInventory().getItemInOffHand());
                                    if (stat.equalsIgnoreCase("basedef")) {
                                        nbtiAdd.setDouble(stat, (double) statAfter);
                                        ItemStack stackadd = nbtiAdd.getItem();
                                        player.getInventory().setItemInOffHand(stackadd);
                                        updateStat.update(p, stat);
                                    } else {
                                        nbtiAdd.setInteger(stat, statAfter);
                                        ItemStack stackadd = nbtiAdd.getItem();
                                        player.getInventory().setItemInOffHand(stackadd);
                                        updateStat.update(p, stat);
                                    }
                                    break;
                                case "set":
                                    p.sendMessage(Data.prefix + "§aYou set the base §c" + stat.toUpperCase() + " §aof §c" + playerStr + " §ato §c" + amount);
                                    NBTItem nbtiset = new NBTItem(player.getInventory().getItemInOffHand());
                                    if (stat.equalsIgnoreCase("basedef")) {
                                        nbtiset.setDouble(stat, (double) amount);
                                        ItemStack stackset = nbtiset.getItem();
                                        player.getInventory().setItemInOffHand(stackset);
                                        updateStat.update(p, stat);
                                    } else {
                                        nbtiset.setInteger(stat, amount);
                                        ItemStack stackset = nbtiset.getItem();
                                        player.getInventory().setItemInOffHand(stackset);
                                        updateStat.update(p, stat);
                                    }
                                    break;
                                case "remove":
                                    int statAfter2 = statBefore - amount;
                                    p.sendMessage(Data.prefix + "§aYou set the base §c" + stat.toUpperCase() + " §aof §c" + playerStr + " §ato §c" + statAfter2);
                                    if (stat.equalsIgnoreCase("basedef")) {
                                        NBTItem nbtiremove = new NBTItem(player.getInventory().getItemInOffHand());
                                        nbtiremove.setDouble(stat, (double) statAfter2);
                                        ItemStack stackremove = nbtiremove.getItem();
                                        player.getInventory().setItemInOffHand(stackremove);
                                        updateStat.update(p, stat);
                                    } else {
                                        NBTItem nbtiremove = new NBTItem(player.getInventory().getItemInOffHand());
                                        nbtiremove.setInteger(stat, statAfter2);
                                        ItemStack stackremove = nbtiremove.getItem();
                                        player.getInventory().setItemInOffHand(stackremove);
                                        updateStat.update(p, stat);
                                    }
                                    break;
                            }
                        } else {
                            p.sendMessage(Data.prefix + "§c This player isn't online!");
                        }
                    } else {
                        p.sendMessage(Data.prefix + "§c This is not a valid stat!");
                    }
                }
            }
        }





        return true;
    }
}