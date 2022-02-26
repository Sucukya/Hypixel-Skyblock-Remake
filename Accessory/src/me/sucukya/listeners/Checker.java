package me.sucukya.listeners;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.utility.ChangeAccStats;
import me.sucukya.utility.inventoryManager;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class Checker {

    public static void check(Player p){
        ChangeAccStats.reset(p);
        checkBag(p);
        File file = new File("plugins//HPSBR//accessories//" + p.getUniqueId() + ".yml");
        for (ItemStack item : p.getInventory().getContents()) {
            if(item != null && !item.getType().isAir()) {
                if (item.hasItemMeta()) {
                    NBTItem itemnbt = new NBTItem(item);
                    NBTItem stats = new NBTItem(p.getInventory().getItemInOffHand());
                    if (itemnbt.getString("type").equalsIgnoreCase("accessory")) {
                            YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
                            if (itemnbt.getKeys().contains("hp")) {
                                conf.set("hp", itemnbt.getDouble("hp"));
                                stats.setDouble("bonushp", stats.getDouble("bonushp") + itemnbt.getDouble("hp"));
                            }
                            if (itemnbt.getKeys().contains("def")) {
                                conf.set("def", itemnbt.getDouble("def"));
                                stats.setDouble("bonusdef", stats.getDouble("bonusdef") + itemnbt.getDouble("def"));
                            }
                            if (itemnbt.getKeys().contains("str")) {
                                conf.set("str", itemnbt.getDouble("str"));
                                stats.setDouble("bonusstr", stats.getDouble("bonusstr") + itemnbt.getDouble("str"));
                            }
                            if (itemnbt.getKeys().contains("speed")) {
                                conf.set("speed", itemnbt.getDouble("speed"));
                                stats.setDouble("bonusspeed", stats.getDouble("bonusspeed") + itemnbt.getDouble("speed"));
                            }
                            if (itemnbt.getKeys().contains("intel")) {
                                conf.set("intel", itemnbt.getDouble("intel"));
                                stats.setDouble("bonusmana", stats.getDouble("bonusmana") + itemnbt.getDouble("intel"));
                            }
                            if (itemnbt.getKeys().contains("cchance")) {
                                conf.set("cchance", itemnbt.getDouble("cchance"));
                                stats.setDouble("bonuscchance", stats.getDouble("bonuscchance") + itemnbt.getDouble("cchance"));
                            }
                            if (itemnbt.getKeys().contains("cdamage")) {
                                conf.set("cdamage", itemnbt.getDouble("cdamage"));
                                stats.setDouble("bonuscdamage", stats.getDouble("bonuscdamage") + itemnbt.getDouble("cdamage"));
                            }
                            if (itemnbt.getKeys().contains("petluck")) {
                                conf.set("petluck", itemnbt.getDouble("petluck"));
                                stats.setDouble("bonuspetluck", stats.getDouble("bonuspetluck") + itemnbt.getDouble("petluck"));
                            }
                            if (itemnbt.getKeys().contains("bonusas")) {
                                conf.set("bonusas", itemnbt.getDouble("bonusas"));
                                stats.setDouble("bonusbonusas", stats.getDouble("bonusbonusas") + itemnbt.getDouble("bonusas"));
                            }
                            if (itemnbt.getKeys().contains("magicfind")) {
                                conf.set("magicfind", itemnbt.getDouble("magicfind"));
                                stats.setDouble("bonusmagicfind", stats.getDouble("bonusmagicfind") + itemnbt.getDouble("magicfind"));
                            }
                            if (itemnbt.getKeys().contains("scchance")) {
                                conf.set("scchance", itemnbt.getDouble("scchance"));
                                stats.setDouble("bonusscchance", stats.getDouble("bonusscchance") + itemnbt.getDouble("scchance"));
                            }
                            if (itemnbt.getKeys().contains("truedef")) {
                                conf.set("truedef", itemnbt.getDouble("truedef"));
                                stats.setDouble("bonustruedef", stats.getDouble("bonustruedef") + itemnbt.getDouble("truedef"));
                            }
                            if (itemnbt.getKeys().contains("ferocity")) {
                                conf.set("ferocity", itemnbt.getDouble("ferocity"));
                                stats.setDouble("bonusferocity", stats.getDouble("bonusferocity") + itemnbt.getDouble("ferocity"));
                            }

                            ItemStack stack = stats.getItem();
                            p.getInventory().setItemInOffHand(stack);

                            try {
                                conf.save(file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                  }
              }
           }
        }
    public static void checkBag(Player p) {
        File file = new File("plugins//HPSBR//accessories//" + p.getUniqueId() + ".yml");
        File inventory = new File("plugins//HPSBR//inventories//" + p.getUniqueId() + ".yml");
        if(inventory.exists()) {
            YamlConfiguration invconf = YamlConfiguration.loadConfiguration(inventory);
            if(invconf.contains("accessorybagpage1")) {
                String accbag = invconf.getString("accessorybagpage1");
                Inventory inv = inventoryManager.stringToInventory(accbag);
                for (ItemStack item : inv.getContents()) {
                    if (item != null && !item.getType().isAir()) {
                        if (item.hasItemMeta()) {
                            NBTItem itemnbt = new NBTItem(item);
                            NBTItem stats = new NBTItem(p.getInventory().getItemInOffHand());
                            if (itemnbt.getString("type").equalsIgnoreCase("accessory")) {
                                YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
                                if (itemnbt.getKeys().contains("hp")) {
                                    conf.set("hp", itemnbt.getDouble("hp"));
                                    stats.setDouble("bonushp", stats.getDouble("bonushp") + itemnbt.getDouble("hp"));
                                }
                                if (itemnbt.getKeys().contains("def")) {
                                    conf.set("def", itemnbt.getDouble("def"));
                                    stats.setDouble("bonusdef", stats.getDouble("bonusdef") + itemnbt.getDouble("def"));
                                }
                                if (itemnbt.getKeys().contains("str")) {
                                    conf.set("str", itemnbt.getDouble("str"));
                                    stats.setDouble("bonusstr", stats.getDouble("bonusstr") + itemnbt.getDouble("str"));
                                }
                                if (itemnbt.getKeys().contains("speed")) {
                                    conf.set("speed", itemnbt.getDouble("speed"));
                                    stats.setDouble("bonusspeed", stats.getDouble("bonusspeed") + itemnbt.getDouble("speed"));
                                }
                                if (itemnbt.getKeys().contains("intel")) {
                                    conf.set("intel", itemnbt.getDouble("intel"));
                                    stats.setDouble("bonusmana", stats.getDouble("bonusmana") + itemnbt.getDouble("intel"));
                                }
                                if (itemnbt.getKeys().contains("cchance")) {
                                    conf.set("cchance", itemnbt.getDouble("cchance"));
                                    stats.setDouble("bonuscchance", stats.getDouble("bonuscchance") + itemnbt.getDouble("cchance"));
                                }
                                if (itemnbt.getKeys().contains("cdamage")) {
                                    conf.set("cdamage", itemnbt.getDouble("cdamage"));
                                    stats.setDouble("bonuscdamage", stats.getDouble("bonuscdamage") + itemnbt.getDouble("cdamage"));
                                }
                                if (itemnbt.getKeys().contains("petluck")) {
                                    conf.set("petluck", itemnbt.getDouble("petluck"));
                                    stats.setDouble("bonuspetluck", stats.getDouble("bonuspetluck") + itemnbt.getDouble("petluck"));
                                }
                                if (itemnbt.getKeys().contains("bonusas")) {
                                    conf.set("bonusas", itemnbt.getDouble("bonusas"));
                                    stats.setDouble("bonusbonusas", stats.getDouble("bonusbonusas") + itemnbt.getDouble("bonusas"));
                                }
                                if (itemnbt.getKeys().contains("magicfind")) {
                                    conf.set("magicfind", itemnbt.getDouble("magicfind"));
                                    stats.setDouble("bonusmagicfind", stats.getDouble("bonusmagicfind") + itemnbt.getDouble("magicfind"));
                                }
                                if (itemnbt.getKeys().contains("scchance")) {
                                    conf.set("scchance", itemnbt.getDouble("scchance"));
                                    stats.setDouble("bonusscchance", stats.getDouble("bonusscchance") + itemnbt.getDouble("scchance"));
                                }
                                if (itemnbt.getKeys().contains("truedef")) {
                                    conf.set("truedef", itemnbt.getDouble("truedef"));
                                    stats.setDouble("bonustruedef", stats.getDouble("bonustruedef") + itemnbt.getDouble("truedef"));
                                }
                                if (itemnbt.getKeys().contains("ferocity")) {
                                    conf.set("ferocity", itemnbt.getDouble("ferocity"));
                                    stats.setDouble("bonusferocity", stats.getDouble("bonusferocity") + itemnbt.getDouble("ferocity"));
                                }

                                ItemStack stack = stats.getItem();
                                p.getInventory().setItemInOffHand(stack);

                                try {
                                    conf.save(file);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}

