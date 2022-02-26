//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.tabAutoComplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class createSwordComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender cms, Command cmd, String arg, String[] args) {
        if(args.length == 1) {
            List<String> list = new ArrayList<>();
            list.add("Minecraft Material");
            return list;
        }
        if(args.length == 2) {
            List<String> list = new ArrayList<>();
            list.add("name String");
            return list;
        }
        if(args.length == 3) {
            List<String> list = new ArrayList<>();
            list.add("common");
            list.add("uncommon");
            list.add("rare");
            list.add("epic");
            list.add("legendary");
            list.add("mythic");
            return list;
        }
        if(args.length == 4) {
            List<String> list = new ArrayList<>();
            list.add("int");
            list.add("dmg");
            return list;
        }
        if(args.length == 5) {
            List<String> list = new ArrayList<>();
            list.add("int");
            list.add("hp");
            return list;
        }
        if(args.length == 6) {
            List<String> list = new ArrayList<>();
            list.add("double");
            list.add("def");
            return list;
        }
        if(args.length == 7) {
            List<String> list = new ArrayList<>();
            list.add("int");
            list.add("str");
            return list;
        }
        if(args.length == 8) {
            List<String> list = new ArrayList<>();
            list.add("int");
            list.add("speed");
            return list;
        }
        if(args.length == 9) {
            List<String> list = new ArrayList<>();
            list.add("int");
            list.add("mana");
            return list;
        }
        if(args.length == 10) {
            List<String> list = new ArrayList<>();
            list.add("int");
            list.add("cchance");
            return list;
        }
        if(args.length == 11) {
            List<String> list = new ArrayList<>();
            list.add("int");
            list.add("cdamage");
            return list;
        }
        if(args.length == 12) {
            List<String> list = new ArrayList<>();
            list.add("int");
            list.add("petluck");
            return list;
        }
        if(args.length == 13) {
            List<String> list = new ArrayList<>();
            list.add("int");
            list.add("bonusas");
            return list;
        }
        if(args.length == 14) {
            List<String> list = new ArrayList<>();
            list.add("int");
            list.add("magicfind");
            return list;
        }
        if(args.length == 15) {
            List<String> list = new ArrayList<>();
            list.add("int");
            list.add("scchance");
            return list;
        }
        if(args.length == 16) {
            List<String> list = new ArrayList<>();
            list.add("int");
            list.add("truedef");
            return list;
        }
        if(args.length == 17) {
            List<String> list = new ArrayList<>();
            list.add("int");
            list.add("ferocity");
            return list;
        }
        if(args.length == 18) {
            List<String> list = new ArrayList<>();
            list.add("boolean");
            list.add("rfgable");
            return list;
        }
        return null;
    }
}
