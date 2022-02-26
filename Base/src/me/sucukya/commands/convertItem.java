//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.commands;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.utility.loreRebuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class convertItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cms, Command cmd, String arg, String[] args) {
        if(cms.hasPermission("hpsbr.convert")) {
                Player p = (Player) cms;
                ItemStack stack = p.getInventory().getItemInMainHand();
                NBTItem nbti = new NBTItem(stack);
                NBTCompound nbtCompound = nbti.getCompound("Base");
                String type = nbtCompound.getString("Type");
                int hp = nbtCompound.getInteger("BaseHealth");
                int def = nbtCompound.getInteger("BaseDefense");
                int str = nbtCompound.getInteger("BaseStrength");
                int cchance = nbtCompound.getInteger("BaseCritChan");
                int cdamage = nbtCompound.getInteger("BaseCritDmg");
                int damage = nbtCompound.getInteger("BaseDamage");
                int speed = nbtCompound.getInteger("BaseSpeed");
                int intel = nbtCompound.getInteger("BaseIntel");
                int baspeed = nbtCompound.getInteger("BaseAtkSpd");
                int truedef = nbtCompound.getInteger("BaseTrueDef");
                int petluck = nbtCompound.getInteger("BasePetLuck");
                int magicfind = nbtCompound.getInteger("BaseMagicFind");
                int scchance = nbtCompound.getInteger("BaseSCChance");
                int ferocity = nbtCompound.getInteger("BaseFerocity");
                String rarity = nbtCompound.getString("Rarity");
                if(type.equalsIgnoreCase("ACCESSORY")) {
                        String name = stack.getItemMeta().getDisplayName().replace("§0", "").replace("§1", "").replace("§2", "").replace("§3", "").replace
                                ("§4", "").replace("§5", "").replace("§6", "").replace("§7", "").replace("§8", "").replace("§9", "").replace
                                ("§a", "").replace("§b", "").replace("§c", "").replace("§d", "").replace("§e", "").replace("§f", "");
                        nbti.setBoolean("reforgable", true);
                        nbti.setString("rarity", rarity.toLowerCase());
                        nbti.setString("name", name.replace(" ", "_"));
                        nbti.setString("type", type.toLowerCase());
                        nbti.setInteger("damage", damage);
                        nbti.setInteger("str", str);
                        nbti.setInteger("cchance", cchance);
                        nbti.setInteger("cdamage", cdamage);
                        nbti.setInteger("aspeed", baspeed);
                        nbti.setInteger("scchance", scchance);
                        nbti.setInteger("speed", speed);
                        nbti.setInteger("hp", hp);
                        nbti.setInteger("def", def);
                        nbti.setInteger("intel", intel);
                        nbti.setInteger("magicfind", magicfind);
                        nbti.setInteger("petluck", petluck);
                        nbti.setInteger("truedef", truedef);
                        nbti.setInteger("ferocity", ferocity);

                        stack = nbti.getItem();

                        loreRebuilder.rebuild(stack, p, p.getInventory());
                } else {
                        String name = stack.getItemMeta().getDisplayName().replace("§0", "").replace("§1", "").replace("§2", "").replace("§3", "").replace
                                ("§4", "").replace("§5", "").replace("§6", "").replace("§7", "").replace("§8", "").replace("§9", "").replace
                                ("§a", "").replace("§b", "").replace("§c", "").replace("§d", "").replace("§e", "").replace("§f", "");
                        nbti.setBoolean("reforgable", true);
                        nbti.setString("rarity", rarity.toLowerCase());
                        nbti.setString("name", name.replace(" ", "_"));
                        nbti.setString("type", type.toLowerCase());
                        nbti.setInteger("damage", damage);
                        nbti.setInteger("str", str);
                        nbti.setInteger("cchance", cchance);
                        nbti.setInteger("cdamage", cdamage);
                        nbti.setInteger("aspeed", baspeed);
                        nbti.setInteger("scchance", scchance);
                        nbti.setInteger("speed", speed);
                        nbti.setInteger("hp", hp);
                        nbti.setInteger("def", def);
                        nbti.setInteger("intel", intel);
                        nbti.setInteger("magicfind", magicfind);
                        nbti.setInteger("petluck", petluck);
                        nbti.setInteger("truedef", truedef);
                        nbti.setInteger("ferocity", ferocity);

                        stack = nbti.getItem();

                        loreRebuilder.rebuild(stack, p, p.getInventory());
                }
            }
        return true;
    }
}
