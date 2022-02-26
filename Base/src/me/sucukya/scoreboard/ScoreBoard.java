//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.scoreboard;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Main;
import me.sucukya.location.CheckLocation;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class ScoreBoard {
    private static HashMap<Scoreboard, Player> boards = new HashMap<>();


    public static void updater() {
        new BukkitRunnable() {

            @Override
            public void run() {
                for(Scoreboard board : boards.keySet()) {
                    Player p = boards.get(board);
                    NBTItem nbti = new NBTItem(p.getInventory().getItemInOffHand());
                    Double Coin = nbti.getDouble("purse");
                    String Coins = null;
                    if(Coin == 0) {
                        DecimalFormat df = new DecimalFormat("#");
                        Coins ="§6" + df.format(Coin);
                    } else {
                        DecimalFormat df = new DecimalFormat("#,###.0");
                        Coins = "§6" + df.format(Coin);
                        Coins.replace(",",".").replace(".",",");
                    }
                    board.getTeam("Coins").setPrefix("§fPurse: §6" + Coins);
                    String loc = CheckLocation.locMap.get(p);
                    board.getTeam("place").setPrefix("§7 ⏣ " + loc);
                }
            }
        }.runTaskTimer(Main.getMain(), 0, 10);
    }
    public static void sendScoreboard(Player p) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.getObjective("aaa") != null ? board.getObjective("aaa") : board.registerNewObjective("aaa", "bbb");
        Team coin = board.registerNewTeam("Coin");
        Team coins = board.registerNewTeam("Coins");
        Team empty = board.registerNewTeam("empty");
        Team empty2 = board.registerNewTeam("empty2");
        Team empty3 = board.registerNewTeam("empty3");
        Team empty5 = board.registerNewTeam("empty5");
        Team place = board.registerNewTeam("place");
        Team bits = board.registerNewTeam("bits");
        Team ad = board.registerNewTeam("ad");
        Team gametime = board.registerNewTeam("gametime");


        obj.setDisplayName("§6§lSKYBLOCK");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        NBTItem nbti = new NBTItem(p.getInventory().getItemInOffHand());
        Double Coin = nbti.getDouble("purse");
        String Coins = null;
        if(Coin == 0) {
            DecimalFormat df = new DecimalFormat("#");
            Coins ="§6" + df.format(Coin);
        } else {
            DecimalFormat df = new DecimalFormat("#,###.0");
            Coins = "§6" + df.format(Coin);
            Coins.replace(",",".").replace(".",",");
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yy");
        LocalDateTime now = LocalDateTime.now();


        empty.setPrefix("§7" + dtf.format(now) + "§8 clear");
        empty.addEntry(ChatColor.DARK_RED.toString());
        obj.getScore(ChatColor.DARK_RED.toString()).setScore(10);
        boards.put(board, p);

        empty2.setPrefix(" ");
        empty2.addEntry(ChatColor.BLUE.toString());
        obj.getScore(ChatColor.BLUE.toString()).setScore(5);
        boards.put(board, p);

        empty5.setPrefix(" ");
        empty5.addEntry(ChatColor.DARK_PURPLE.toString());
        obj.getScore(ChatColor.DARK_PURPLE.toString()).setScore(9);
        boards.put(board, p);

        String loc = CheckLocation.locMap.get(p);
        place.setPrefix("§7 "+ "🞠" + loc);
        place.addEntry(ChatColor.LIGHT_PURPLE.toString());
        obj.getScore(ChatColor.LIGHT_PURPLE.toString()).setScore(6);
        boards.put(board, p);

        coin.setPrefix("§fPurse: §6" + Coins);
        coin.addEntry(ChatColor.BLACK.toString());
        obj.getScore(ChatColor.BLACK.toString()).setScore(4);
        boards.put(board, p);

        coins.setPrefix("§fPurse: §6" + Coins);
        coins.addEntry(ChatColor.BLACK.toString());
        obj.getScore(ChatColor.BLACK.toString()).setScore(4);
        boards.put(board, p);


        bits.setPrefix("Placeholder");
        bits.addEntry(ChatColor.RED.toString());
        obj.getScore(ChatColor.RED.toString()).setScore(3);
        boards.put(board, p);

        ad.setPrefix("§ewww.server.net");
        ad.addEntry(ChatColor.YELLOW.toString());
        obj.getScore(ChatColor.YELLOW.toString()).setScore(1);
        boards.put(board,p);

        gametime.setPrefix(" §fEarly Winter 6th");
        gametime.addEntry(ChatColor.DARK_GREEN.toString());
        obj.getScore(ChatColor.DARK_GREEN.toString()).setScore(8);
        boards.put(board,p);

        obj.getScore(ChatColor.GRAY.toString()).setScore(2);
        boards.put(board, p);






        obj.getScore("§7 10:30pm §bc").setScore(7);
        p.setScoreboard(board);


    }

}
