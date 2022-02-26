//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.tabAutoComplete;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class baseComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender cms, Command cmd, String arg, String[] args) {
        if(args.length == 1) {
            List<String> stats = new ArrayList<>();
            stats.add("basehp");
            stats.add("basedef");
            stats.add("basemana");
            stats.add("basestr");
            stats.add("basecchance");
            stats.add("basecdamage");
            stats.add("basescchance");
            stats.add("basepetluck");
            stats.add("basemagicfind");
            stats.add("basebonusas");
            stats.add("basetruedef");
            stats.add("baseferocity");
            stats.add("purse");
            return stats;
        }
        if(args.length == 2) {
            List<String> playernames = new ArrayList<>();
            for(Player player : Bukkit.getOnlinePlayers()) {
                playernames.add(player.getName());
            }
            return playernames;
        }

        if(args.length == 3) {
            List<String> value = new ArrayList<>();
            value.add("add");
            value.add("remove");
            value.add("set");
            return value;
        }
        if(args.length == 3) {
            List<String> value = new ArrayList<>();
            value.add("<amount>");
            return value;
        }

        return null;

    }
}
