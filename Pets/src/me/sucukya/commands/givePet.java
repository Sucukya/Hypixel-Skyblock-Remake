package me.sucukya.commands;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Pets;
import me.sucukya.utility.Items;
import me.sucukya.utility.randomGenerator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class givePet implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cms, Command cmd, String arg, String[] args) {

        if(!(cms instanceof Player)) {
            System.out.println("This command can only be executed by a player with the hpsbr.pets.create permission!");
        } else {
            Player p = (Player) cms;
            if(p.hasPermission("hpsbr.pets.create")) {
                if(args.length == 3) {
                    String type = args[0];
                    String rarity = args[1];
                    int level = Integer.parseInt(args[2]);

                    File file = new File("plugins//HPSBR//Pets//type//" + type + ".yml");
                    YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
                    if(file.exists()) {
                        String typeformatted = type.substring(0, 1).toUpperCase() + type.substring(1);
                        String pettype = conf.getString("type");
                        String id = randomGenerator.getString(32, randomGenerator.Mode.ALPHANUMERIC);
                        ItemStack pet = Items.createHead(conf.getString("head"));
                        ItemMeta petmeta = pet.getItemMeta();
                        petmeta.setDisplayName("§7[Lvl " + level + "] " + Pets.raritycolormap.get(rarity) + typeformatted);
                        List<String> petlore = new ArrayList<>();
                        petlore.add("§8" + pettype + " Pet");
                        petlore.add("");
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
                        if(conf.contains("hp")) {
                            hp = conf.getDouble("hp") * level;
                        }
                        if(conf.contains("def")) {
                            def = conf.getDouble("def") * level;
                        }
                        if(conf.contains("str")) {
                            str = conf.getDouble("str") * level;
                        }
                        if(conf.contains("speed")) {
                            speed = conf.getDouble("speed") * level;
                        }
                        if(conf.contains("cchance")) {
                            cchance = conf.getDouble("cchance") * level;
                        }
                        if(conf.contains("cdamage")) {
                            cdamage = conf.getDouble("cdamage") * level;
                        }
                        if(conf.contains("bonusas")) {
                            bonusas = conf.getDouble("bonusas") * level;
                        }
                        if(conf.contains("mana")) {
                            mana = conf.getDouble("mana") * level;
                        }
                        if(conf.contains("scchance")) {
                            scchance = conf.getDouble("scchance") * level;
                        }
                        if(conf.contains("magicfind")) {
                            magicfind = conf.getDouble("magicfind") * level;
                        }
                        if(conf.contains("petluck")) {
                            petluck = conf.getDouble("petluck") * level;
                        }
                        if(conf.contains("truedef")) {
                            truedef = conf.getDouble("truedef") * level;
                        }
                        if(conf.contains("ferocity")) {
                            ferocity = conf.getDouble("ferocity") * level;
                        }

                        if(str > 0) {
                            petlore.add("§7Strength: §a+" + str);
                        }
                        if(cchance > 0) {
                            petlore.add("§7Crit Chance: §a+" + cchance + "%");
                        }
                        if(cdamage > 0) {
                            petlore.add("§7Crit Damage: §a+" + cdamage + "%");
                        }
                        if(bonusas > 0) {
                            petlore.add("§7Bonus Attack Speed: §a+" + bonusas + "%");
                        }
                        if(scchance > 0) {
                            petlore.add("§7Sea Creature Chance: §a+" + scchance+ "%");
                        }
                        if(hp > 0) {
                            petlore.add("§7Health: §a+" + hp +" HP");
                        }
                        if(def > 0) {
                            petlore.add("§7Defense: §a+" + def );
                        }
                        if(mana > 0) {
                            petlore.add("§7Intelligence: §a+" + mana );
                        }
                        if(speed > 0) {
                            petlore.add("§7Speed: §a+" + speed +"%");
                        }
                        if(truedef > 0) {
                            petlore.add("§7True Defense: §a+" + truedef );
                        }
                        if(magicfind > 0) {
                            petlore.add("§7Magic Find: §a+" + magicfind );
                        }
                        if(petluck > 0) {
                            petlore.add("§7Pet Luck: §a+" + petluck );
                        }
                        if(ferocity > 0) {
                            petlore.add("§7Ferocity: §a+" + ferocity );
                        }
                        if(hp > 0 || def > 0 || speed > 0 || mana > 0 || truedef > 0 || magicfind > 0 || petluck > 0 || str > 0 || cchance > 0 || cdamage > 0 || bonusas > 0 || scchance > 0 || ferocity > 0) {
                            petlore.add(" ");
                        }
                        petlore.add("§eRight-click to add this pet to");
                        petlore.add("§eyour pets menu");
                        petlore.add("");
                        petlore.add("§l" + Pets.raritycolormap.get(rarity) + rarity.toUpperCase());
                        petmeta.setLore(petlore);
                        pet.setItemMeta(petmeta);
                        NBTItem petnbt = new NBTItem(pet);
                        petnbt.setInteger("level", level);
                        petnbt.setString("type", typeformatted);
                        petnbt.setString("rarity", rarity.toLowerCase());
                        petnbt.setString("head", conf.getString("head"));
                        petnbt.setBoolean("pet", true);
                        petnbt.setString("id",id);
                        petnbt.setString("pettype",pettype);

                        pet = petnbt.getItem();
                        p.getInventory().addItem(pet);
                    } else {
                        p.sendMessage("§cThis pet doesn't exist!");
                    }

                } else {
                    p.sendMessage("Not enough arguments! Use /givepet <type> <rarity> <level>");
                }
            } else {
                p.sendMessage("§cYou don't have enough permissions to perform this command!");
            }
        }



        return true;
    }
}
