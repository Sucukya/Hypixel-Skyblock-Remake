//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.reforge;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Random;

public class reforge {

    public static void reforge(ItemStack stack, Player p, Inventory inv) {
        NBTItem nbti = new NBTItem(stack);
        ItemStack anvil = inv.getItem(22);
        NBTItem anvilnbti = new NBTItem(anvil);
        int cost = anvilnbti.getInteger("cost");
        NBTItem stat = new NBTItem(p.getInventory().getItemInOffHand());
        double coins = stat.getDouble("purse");
        String type = nbti.getString("type");
        Random rand = new Random();


        if (coins >= cost) {
            coins = coins - cost;
            stat.setDouble("purse", coins);
            p.getInventory().setItemInOffHand(new ItemStack(stat.getItem()));
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1f, 1f);

            HashMap<Integer, String> swordmap = new HashMap<>();
            HashMap<Integer, String> bowmap = new HashMap<>();
            HashMap<Integer, String> talismanmap = new HashMap<>();
            HashMap<Integer, String> armormap = new HashMap<>();

            swordmap.put(0, "Gentle");
            swordmap.put(1, "Odd");
            swordmap.put(2, "Fast");
            swordmap.put(3, "Fair");
            swordmap.put(4, "Epic");
            swordmap.put(5, "Sharp");
            swordmap.put(6, "Heroic");
            swordmap.put(7, "Spicy");
            swordmap.put(8, "Legendary");

            bowmap.put(0, "Awkward");
            bowmap.put(1, "Rich");
            bowmap.put(2, "Fine");
            bowmap.put(3, "Neat");
            bowmap.put(4, "Hasty");
            bowmap.put(5, "Grand");
            bowmap.put(6, "Rapid");
            bowmap.put(7, "Deadly");
            bowmap.put(8, "Unreal");

            armormap.put(0, "Smart");
            armormap.put(1, "Clean");
            armormap.put(2, "Fierce");
            armormap.put(3, "Heavy");
            armormap.put(4, "Light");
            armormap.put(5, "Mythic");
            armormap.put(6, "Titanic");
            armormap.put(7, "Wise");
            armormap.put(8, "Pure");

            talismanmap.put(0, "");
            talismanmap.put(1, "");
            talismanmap.put(2, "");
            talismanmap.put(3, "");
            talismanmap.put(4, "");
            talismanmap.put(5, "");
            talismanmap.put(6, "");
            talismanmap.put(7, "");
            talismanmap.put(8, "");
            talismanmap.put(9, "");
            talismanmap.put(10, "");
            talismanmap.put(11, "");
            talismanmap.put(12, "");
            talismanmap.put(13, "");
            talismanmap.put(14, "");
            talismanmap.put(15, "");
            talismanmap.put(16, "");
            talismanmap.put(17, "");

            if (type.equalsIgnoreCase("sword")) {
                int rdm = rand.nextInt(8);
                String reforge = swordmap.get(rdm);
                me.sucukya.reforge.sword.apply.apply(stack, reforge, p, inv);
            } else if (type.equalsIgnoreCase("bow")) {
                int rdm = rand.nextInt(8);
                String reforge = bowmap.get(rdm);
            } else if (type.equalsIgnoreCase("talisman")) {
                int rdm = rand.nextInt(17);
                String reforge = talismanmap.get(rdm);
            } else if (type.equalsIgnoreCase("helmet") || type.equalsIgnoreCase("leggings") || type.equalsIgnoreCase("chestplate") || type.equalsIgnoreCase("boots")) {
                int rdm = rand.nextInt(8);
                String reforge = armormap.get(rdm);
                me.sucukya.reforge.armor.apply.apply(stack, reforge, p, inv);

            }


        } else {
            p.sendMessage("§cYou don't have enough coins!");
            p.playSound(p.getLocation(),Sound.ENTITY_ENDERMAN_TELEPORT,2f,0.5f);
        }
    }


}
