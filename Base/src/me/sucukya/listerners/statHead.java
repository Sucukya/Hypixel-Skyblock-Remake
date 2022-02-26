package me.sucukya.listerners;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Main;
import me.sucukya.playerStats.calculateStat;
import me.sucukya.utility.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class statHead implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getClickedInventory() == null) {
        }else {
            if(e.getCurrentItem() ==null || e.getCurrentItem().getType() == Material.AIR) {
            }else {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aYour Profile Stats")) {
                    Inventory inv = Bukkit.createInventory(null,54,"§8Your SkyBlock Profile");
                    int minRow = 0;
                    int maxRow = 54;
                    for(int i = minRow; i < maxRow; i++) {
                        inv.setItem(i, Items.createItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, 0, " "));
                    }

                    Main.getMain().reloadConfig();
                    ItemStack statHead = new ItemStack(Material.PLAYER_HEAD);
                    ItemStack stack = p.getInventory().getItemInOffHand();
                    NBTItem nbtistack = new NBTItem(stack);
                    SkullMeta skullMeta = (SkullMeta) statHead.getItemMeta();
                    skullMeta.setDisplayName("§aYour Profile Stats!");
                    skullMeta.setOwningPlayer(p);
                    List< String > lore = new ArrayList< String >();
                    lore.add("  §c❤ Health §f" + calculateStat.calculate(p,"hp") + " HP");
                    lore.add("  §a❈ Defense §f" + calculateStat.calculate(p,"def"));
                    lore.add("  §c❁ Strength §f" + calculateStat.calculate(p,"str"));
                    lore.add("  §f✦ Speed §f" + calculateStat.calculate(p,"speed"));
                    if(calculateStat.calculate(p,"cchance") <= 100) {
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
                    skullMeta.setLore(lore);
                    statHead.setItemMeta(skullMeta);
                    inv.setItem(4, statHead);


                    //HP
                    ItemStack hp = new ItemStack(Material.GOLDEN_APPLE);
                    ItemMeta meta = hp.getItemMeta();
                    double regen2 = (calculateStat.calculate(p,"hp") / 100) + 1.5;
                    DecimalFormat df = new DecimalFormat("#.#");
                    String regen = df.format(regen2);
                    int fullhp = calculateStat.calculate(p,"hp");
                    int hpbonus = nbtistack.getInteger("bonushp");
                    meta.setDisplayName("§c❤ Health §f" + fullhp +" HP");
                    List< String > loreshp = new ArrayList< String >();
                    loreshp.add("§7Health is your total maximum");
                    loreshp.add("§7health. Your natural");
                    loreshp.add("§7regeneration gives §a" + regen +" HP");
                    loreshp.add("§7every §a2s.");
                    loreshp.add("");
                    loreshp.add("§7Base Health: §a" + nbtistack.getInteger("basehp") + " HP");
                    loreshp.add("§8 Increase your base Health by");
                    loreshp.add("§8 leveling your Farming and");
                    loreshp.add("§8 Fishing Skills and contributing");
                    loreshp.add("§8 to the §dFairy §8in the");
                    loreshp.add("§2 Wilderness§8.");
                    loreshp.add("");
                    loreshp.add("§7Bonus Health: +§e" + hpbonus +" HP");
                    loreshp.add("§8 Increase your bonus Health");
                    loreshp.add("§8 by equipping Armor and holding");
                    loreshp.add("§8 Talismans in your inventory.");
                    meta.setLore(loreshp);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    hp.setItemMeta(meta);
                    inv.setItem(19,hp);

                    //def
                    ItemStack def = new ItemStack(Material.IRON_CHESTPLATE);
                    ItemMeta meta2 = def.getItemMeta();
                    int defbonus = nbtistack.getInteger("bonusdef");
                    double def2 = calculateStat.calculate(p,"def");
                    double dmgreduction = def2 / (def2 + 100);
                    double ehp;
                    if(def2 == 0) {
                         ehp = calculateStat.calculate(p,"hp");
                    } else {
                        ehp = Math.ceil(dmgreduction * 100) / 10 * calculateStat.calculate(p, "hp");
                    }
                    meta2.setDisplayName("§a❈ Defense §f" + calculateStat.calculate(p,"def"));
                    List< String > loresdef = new ArrayList< String >();
                    loresdef.add("§7Defense reduces the damage that");
                    loresdef.add("§7you take from enimies.");
                    loresdef.add("");
                    loresdef.add("§7Base Defense: §a" + nbtistack.getInteger("basedef"));
                    loresdef.add("§8 Increase your base Defense");
                    loresdef.add("§8 by leveling your Mining Skill");
                    loresdef.add("§8 and contributing to the §dFairy");
                    loresdef.add("§8 in the §2Wilderness§8.");
                    loresdef.add("");
                    loresdef.add("§7Bonus Defense: +§e" + defbonus);
                    loresdef.add("§8 Increase your bonus Defense");
                    loresdef.add("§8 by equipping Armor and holding");
                    loresdef.add("§8 Talismans in your inventory.");
                    loresdef.add("");
                    loresdef.add("§7Damage Reduction: §a" + Math.ceil(dmgreduction * 100) + "%");
                    loresdef.add("§7Effective Health : §c" + (int)ehp);
                    meta2.setLore(loresdef);
                    meta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    def.setItemMeta(meta2);
                    inv.setItem(20,def);

                    //str
                    ItemStack str = new ItemStack(Material.BLAZE_POWDER);
                    ItemMeta meta3 = str.getItemMeta();
                    int str2 = nbtistack.getInteger("basestr");
                    int str3 = calculateStat.calculate(p,"str");
                    int basedmg = (5 + 0 + (str3 / 5) * (1 + str3/100));
                    meta3.setDisplayName("§c❁ Strength §f" + calculateStat.calculate(p,"str"));
                    List< String > loresstr = new ArrayList< String >();
                    loresstr.add("§7Strength increases your base");
                    loresstr.add("§7melee damage, including punching");
                    loresstr.add("§7and weapons.");
                    loresstr.add("");
                    loresstr.add("§7Base Strength: §a" + nbtistack.getInteger("str"));
                    loresstr.add("§8 Increase your base Strength by");
                    loresstr.add("§8 leveling your Foraging Skill");
                    loresstr.add("§8 and contributing to the §dFairy");
                    loresstr.add("§8 in the §2Wilderness§8.");
                    loresstr.add("");
                    loresstr.add("§7Bonus Strength: +§e" + nbtistack.getInteger("bonusstr"));
                    loresstr.add("§8 Increase your bonus Strength");
                    loresstr.add("§8 by equipping Armor and holding");
                    loresstr.add("§8 Talismans in your inventory.");
                    loresstr.add("");
                    loresstr.add("§7Base Damage:§a " + basedmg);
                    meta3.setLore(loresstr);
                    meta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta3.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    str.setItemMeta(meta3);
                    inv.setItem(21,str);

                    //speed
                    ItemStack speed = new ItemStack(Material.SUGAR);
                    ItemMeta meta4 = speed.getItemMeta();
                    int speed2 = nbtistack.getInteger("bonusspeed");
                    meta4.setDisplayName("§f✦ Speed §f" + calculateStat.calculate(p,"speed"));
                    List< String > loresspeed = new ArrayList< String >();
                    loresspeed.add("§7Speed increases your walk speed.");
                    loresspeed.add("");
                    loresspeed.add("§7Base Speed: §a" + nbtistack.getInteger("basespeed"));
                    loresspeed.add("§8 Increase your base Speed by");
                    loresspeed.add("§8 contributing to the §dFairy");
                    loresspeed.add("§8 in the §2Wilderness§8.");
                    loresspeed.add("");
                    loresspeed.add("§7Bonus Speed: +§e" + speed2);
                    loresspeed.add("§8 Increase your bonus Speed by");
                    loresspeed.add("§8 equipping Armor and holding");
                    loresspeed.add("§8 Talismans in your inventory.");
                    loresspeed.add("");
                    loresspeed.add("§7You are §a" + speed2 + "% §7faster!");
                    meta4.setLore(loresspeed);
                    meta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta4.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta4.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    speed.setItemMeta(meta4);
                    inv.setItem(22,speed);

                    //ccchance
                    ItemStack ccchance = Items.createHead("http://textures.minecraft.net/texture/3e4f49535a276aacc4dc84133bfe81be5f2a4799a4c04d9a4ddb72d819ec2b2b");
                    SkullMeta meta5 = (SkullMeta) ccchance.getItemMeta();
                    int cchance2 = (nbtistack.getInteger("basecchance"));
                    if(cchance2 < 0) {
                        cchance2 = 0;
                    }
                    if(calculateStat.calculate(p,"cchance") <= 100) {
                        meta5.setDisplayName("§9☣ Crit Chance §f" + calculateStat.calculate(p, "cchance") + "%");
                    } else {
                        meta5.setDisplayName("§9☣ Crit Chance §f" + "100%");
                    }
                    List< String > lorescchance = new ArrayList< String >();
                    int cchance3 = nbtistack.getInteger("bonuscchance");
                    lorescchance.add("§7Crit Chance is your chance to");
                    lorescchance.add("§7deal extra damage on enemies.");
                    lorescchance.add("");
                    lorescchance.add("§7Base Crit Chance: §a" + nbtistack.getInteger("basecchance") + "%");
                    lorescchance.add("§8 Increase your base Crit");
                    lorescchance.add("§8 Chance by leveling your Combat Skill.");
                    lorescchance.add("");
                    if(cchance3 >= 70) {
                        lorescchance.add("§7Bonus Crit Chance: +§e" + cchance3 + "%");
                    } else {
                        lorescchance.add("§7Bonus Crit Chance: +§e" + "70%");
                    }
                    lorescchance.add("§8 Increase your bonus Crit");
                    lorescchance.add("§8 Chances by equipping Armor and");
                    lorescchance.add("§8 holding Talismans in your");
                    lorescchance.add("§8 inventory.");
                    meta5.setLore(lorescchance);
                    meta5.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta5.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    ccchance.setItemMeta(meta5);
                    inv.setItem(23,ccchance);

                    //cdamage
                    ItemStack cdamage = Items.createHead("http://textures.minecraft.net/texture/ddafb23efc57f251878e5328d11cb0eef87b79c87b254a7ec72296f9363ef7c");
                    SkullMeta meta6 = (SkullMeta) cdamage.getItemMeta();
                    int cdmg = nbtistack.getInteger("basecdamage");
                    if(cdmg < 0) {
                        cdmg = 0;
                    }
                    meta6.setDisplayName("§9☠ Crit Damage §f" + calculateStat.calculate(p,"cdamage") + "%");
                    int cdamage3 = nbtistack.getInteger("bonuscdamage");
                    List< String > lorescdamage = new ArrayList< String >();
                    lorescdamage.add("§7Crit Damage is the amount");
                    lorescdamage.add("§7deal extra damage you deal when");
                    lorescdamage.add("§7landing a critical hit.");
                    lorescdamage.add("");
                    lorescdamage.add("§7Base Crit Damage: §a" + nbtistack.getInteger("basecdamage") + "%");
                    lorescdamage.add("§8 Increase your base Crit");
                    lorescdamage.add("§8 Chance by exploring the world!");
                    lorescdamage.add("");
                    lorescdamage.add("§7Bonus Crit Damage: +§e" + cdamage3 + "%");
                    lorescdamage.add("§8 Increase your bonus Crit");
                    lorescdamage.add("§8 Damage by equipping Armor and");
                    lorescdamage.add("§8 holding Talismans in your");
                    lorescdamage.add("§8 inventory.");
                    meta6.setLore(lorescdamage);
                    meta6.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta6.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta6.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    cdamage.setItemMeta(meta6);
                    inv.setItem(24,cdamage);

                    //bas
                    ItemStack bas = new ItemStack(Material.GOLDEN_AXE);
                    ItemMeta meta7 = bas.getItemMeta();
                    if(calculateStat.calculate(p,"bonusas") <= 100) {
                        meta7.setDisplayName("§e⚔ Bonus Attack Speed §f" + calculateStat.calculate(p, "bonusas") + "%");
                    } else {
                        meta7.setDisplayName("§e⚔ Bonus Attack Speed §f" + "100%");
                    }
                    List< String > loresbas = new ArrayList< String >();
                    loresbas.add("§7Bonus Attack Speed decreases the");
                    loresbas.add("§7time between hits on your");
                    loresbas.add("§7opponent.");
                    loresbas.add("");
                    loresbas.add("§7Base Attack Speed: §a"+ nbtistack.getInteger("basebonusas") + "%");
                    loresbas.add("§8 All players have the same");
                    loresbas.add("§8 base bonus speed.");
                    loresbas.add("");
                    loresbas.add("§7Bonus Bonus Attack Speed: §e+"+ nbtistack.getInteger("bonusbonusas") + "%");
                    loresbas.add("§8 Increase your bonus Bonus");
                    loresbas.add("§8 Attack Speed by equipping Armor");
                    loresbas.add("§8 and holding Talismans in your");
                    loresbas.add("§8 inventory.");
                    loresbas.add("");
                    if(calculateStat.calculate(p,"bonusas") <= 100) {
                        loresbas.add("§7You now attack §a" + calculateStat.calculate(p, "bonusas") + "% §7faster!");
                    } else {
                        loresbas.add("§7You now attack §a" + "100% §7faster!");
                    }
                    meta7.setLore(loresbas);
                    meta7.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta7.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta7.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    bas.setItemMeta(meta7);
                    inv.setItem(25,bas);

                    //intel
                    ItemStack intel = new ItemStack(Material.ENCHANTED_BOOK);
                    ItemMeta meta8 = intel.getItemMeta();
                    int mana2 = nbtistack.getInteger("basemana");
                    if(mana2 < 0) {
                        mana2 = 0;
                    }
                    meta8.setDisplayName("§b✎ Intelligence §f" + mana2) ;
                    int mana3 = nbtistack.getInteger("bonusmana");
                    List< String > loresintel = new ArrayList< String >();
                    loresintel.add("§7Intelligence increases both your");
                    loresintel.add("§7Mana Pool and the damage of your");
                    loresintel.add("§7magical items");
                    loresintel.add("");
                    loresintel.add("§7Base Intelligence: §a" + nbtistack.getInteger("basemana"));
                    loresintel.add("§8 Increase your base");
                    loresintel.add("§8 Intelligence by leveling your");
                    loresintel.add("§8 Enchanting and Alchemy Skills.");
                    loresintel.add("");
                    loresintel.add("§7Bonus Intelligence: +§e" + mana3);
                    loresintel.add("§8 Increase your bonus");
                    loresintel.add("§8 Intelligence by equipping Armor and");
                    loresintel.add("§8 and holding Talismans in your");
                    loresintel.add("§8 inventory");
                    loresintel.add("");
                    loresintel.add("§7Magic Damage:§b " + mana2 + "%");
                    loresintel.add("§7Mana Pool:§b " + calculateStat.calculate(p,"mana"));
                    meta8.setLore(loresintel);
                    meta8.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta8.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta8.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    intel.setItemMeta(meta8);
                    inv.setItem(28,intel);

                    //scchance
                    ItemStack scchance = new ItemStack(Material.PRISMARINE_CRYSTALS);
                    ItemMeta meta9 = scchance.getItemMeta();
                    if(calculateStat.calculate(p,"scchance") <= 100) {
                        meta9.setDisplayName("§3α Sea Creature Chance §f" + calculateStat.calculate(p, "scchance") + "%");
                    } else {
                        meta9.setDisplayName("§3α Sea Creature Chance §f" + "100%");
                    }
                    List< String > loresscchance = new ArrayList< String >();
                    loresscchance.add("§7Sea Creature Chance is your");
                    loresscchance.add("§7chance to catch Sea Creatures");
                    loresscchance.add("§7while fishing.");
                    loresscchance.add("");
                    loresscchance.add("§7Base Sea Creature Chance: §a"+ nbtistack.getInteger("basescchance") + "%");
                    loresscchance.add("§8 All players have the same");
                    loresscchance.add("§8 base chance.");
                    loresscchance.add("");
                    loresscchance.add("§7Bonus Sea Creature Chance: +§e" + nbtistack.getInteger("bonusscchance")  + "%");
                    loresscchance.add("§8 Increase your bonus Sea");
                    loresscchance.add("§8 Creature Chance by equipping");
                    loresscchance.add("§8 Armor and holding Talismans in");
                    loresscchance.add("§8 your inventory.");
                    meta9.setLore(loresscchance);
                    meta9.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta9.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta9.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    scchance.setItemMeta(meta9);
                    inv.setItem(29,scchance);


                    //magicfind
                    ItemStack magicfind = new ItemStack(Material.STICK);
                    ItemMeta meta10 = magicfind.getItemMeta();
                    meta10.setDisplayName("§b✯ Magic Find §f " + calculateStat.calculate(p,"magicfind"));
                    List< String > loresmagic = new ArrayList< String >();
                    loresmagic.add("§7Magic Find increases how many");
                    loresmagic.add("§7rare items you find");
                    loresmagic.add("");
                    loresmagic.add("§7Base Magic Find: §a" + nbtistack.getInteger("basemagicfind"));
                    loresmagic.add("§8 Increase your base Magic");
                    loresmagic.add("§8 Find by collecting unique pets.");
                    loresmagic.add("");
                    loresmagic.add("§7Bonus Magic Find: +§e" + nbtistack.getInteger("bonusmagicfind"));
                    loresmagic.add("§8 Increase your bonus Magic");
                    loresmagic.add("§8 Find by equipping Armor and");
                    loresmagic.add("§8 and holding Talismans in your");
                    loresmagic.add("§8 inventory.");
                    meta10.setLore(loresmagic);
                    meta10.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta10.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta10.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    magicfind.setItemMeta(meta10);
                    inv.setItem(30,magicfind);


                    //petluck
                    ItemStack petluck = Items.createHead("http://textures.minecraft.net/texture/93c8aa3fde295fa9f9c27f734bdbab11d33a2e43e855accd7465352377413b");
                    ItemMeta meta11 = petluck.getItemMeta();
                    meta11.setDisplayName("§d♣ Pet Luck §f" + calculateStat.calculate(p,"petluck"));
                    List< String > lorespet = new ArrayList< String >();
                    lorespet.add("§7Pet Luck increases how many pets");
                    lorespet.add("§7you find and gives you better luck when crafting pets");
                    lorespet.add("");
                    lorespet.add("§7Base Pet Luck §a" + nbtistack.getInteger("basepetluck"));
                    lorespet.add("§8 Increase your base Pet Luck");
                    lorespet.add("§8 by leveling your Taming Skill.");
                    lorespet.add("");
                    lorespet.add("§7Bonus Pet Luck: +§e" + nbtistack.getInteger("bonuspetluck"));
                    lorespet.add("§8 Increase your bonus Pet Luck");
                    lorespet.add("§8 by equipping Armor and holding");
                    lorespet.add("§8 Talismans in your inventory.");
                    meta11.setLore(lorespet);
                    meta11.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta11.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta11.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    petluck.setItemMeta(meta11);
                    inv.setItem(31,petluck);

                    //truedef
                    ItemStack truedef = Items.createItemStack(Material.BONE_MEAL, 1, 0, "§f❂ True Defense " + calculateStat.calculate(p,"truedef"));
                    ItemMeta meta12 = truedef.getItemMeta();
                    List< String > lorestruedef = new ArrayList< String >();
                    lorestruedef.add("");
                    lorestruedef.add("§7Base True Defense §a" + nbtistack.getInteger("basetruedef"));
                    lorestruedef.add("§8 Increase your base True");
                    lorestruedef.add("§8 Defense by exploring the world!");
                    lorestruedef.add("");
                    lorestruedef.add("§7Bonus True Defense: +§e" + nbtistack.getInteger("bonusferocity"));
                    lorestruedef.add("§8 Increase your bonus True");
                    lorestruedef.add("§8 Defense by equipping items and");
                    lorestruedef.add("§8 armor, and storing accessories");
                    lorestruedef.add("§8 in your inventory.");
                    meta12.setLore(lorestruedef);
                    meta12.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta12.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta12.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    truedef.setItemMeta(meta12);
                    inv.setItem(32,truedef);

                    //ferocity
                    ItemStack ferocity = Items.createItemStack(Material.RED_DYE, 1,0 , "§c⫽ Ferocity §f" + calculateStat.calculate(p, "ferocity"));
                    ItemMeta meta13 = ferocity.getItemMeta();
                    List< String > loresferocity = new ArrayList< String >();
                    loresferocity.add("§7Ferocity grants percent chance");
                    loresferocity.add("§7to double-strike enemies.");
                    loresferocity.add("§7Increments of 100 increases the");
                    loresferocity.add("§7base number of strikes.");
                    loresferocity.add("");
                    loresferocity.add("§7Base Ferocity §a" + nbtistack.getInteger("baseferocity"));
                    loresferocity.add("§8 Increase your base Ferocity");
                    loresferocity.add("§8 by exploring the world!");
                    loresferocity.add("");
                    loresferocity.add("§7Bonus Ferocity: +§e" + nbtistack.getInteger("bonusferocity"));
                    loresferocity.add("§8 Increase your bonus Ferocity");
                    loresferocity.add("§8 by equipping items and armor,");
                    loresferocity.add("§8 and storing accessories in your ");
                    loresferocity.add("§8 inventory.");
                    loresferocity.add("");
                    loresferocity.add("§7Base extra strikes: §c" + (int) Math.ceil(calculateStat.calculate(p,"ferocity") / 100));
                    loresferocity.add("§7Chance for 1 more: §c" + (calculateStat.calculate(p,"ferocity") % 100) + "%");
                    meta13.setLore(loresferocity);
                    meta13.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta13.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    meta13.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    ferocity.setItemMeta(meta13);
                    inv.setItem(33,ferocity);

                    inv.setItem(49,Items.createItemStack(Material.BARRIER,1,0,"§cClose"));

                    ItemStack back = new ItemStack(Material.ARROW);
                    NBTItem nbti2 = new NBTItem(back);
                    nbti2.setString("backTo","SbMenu");
                    back = nbti2.getItem();
                    ItemMeta backmeta = back.getItemMeta();
                    List< String > backlore  = new ArrayList< String >();
                    backmeta.setDisplayName("§aGo Back");
                    backlore.add("§7To Skyblock Menu");
                    backmeta.setLore(backlore);
                    back.setItemMeta(backmeta);
                    inv.setItem(48,back);


                    p.openInventory(inv);
                }
            }
        }


    }
    @EventHandler
    public void onClick2(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getClickedInventory() == null) {
        } else {
            if(e.getClickedInventory().getType().equals(InventoryType.ANVIL)) {

            } else {
            if(e.getView().getTitle().equalsIgnoreCase("§aProfile Stats")) {
                if (e.getCurrentItem() == null || e.getCurrentItem().getType().isAir()) {
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGo Back")) {
                    menuOpen.openMenu(p);
                } else {
                    e.setCancelled(true);
                }
            }
            }
        }
    }



}
