//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.crafting;

import me.sucukya.utility.createI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftInventoryCrafting;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftInventoryView;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;


public class Events implements Listener {


    ArrayList<ItemStack> items = new ArrayList<>();

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        CraftInventoryView civ;
        CraftInventoryCrafting cic = null;

        Inventory inv = Bukkit.createInventory(null, 54, "§8Crafting Menu");
        if(e.getClickedInventory() !=null) {
            if(e.getView().getTitle().equalsIgnoreCase("§8SkyBlock Menu")) {
                if(e.getCurrentItem() !=null || !e.getCurrentItem().getType().equals(Material.AIR)) {
                    if(e.getCurrentItem().getType().equals(Material.CRAFTING_TABLE)) {
                        civ = (CraftInventoryView) p.openWorkbench(p.getLocation(), true);
                        cic = (CraftInventoryCrafting) civ.getTopInventory();
                        int minRow = 0;
                        int maxRow = 54;
                        for(int i = minRow; i < maxRow; i++) {
                            inv.setItem(i, createI.createItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, 0, " "));
                        }



                        int[] clearfields = { 10, 11, 12, 19, 20, 21, 23, 16, 25,34, 28, 29, 30, 45, 46, 47, 48, 49, 50, 51, 52, 53 };
                        int[] redfields = { 45, 46, 47, 48, 50, 51, 52, 53 };

                        for(int id : clearfields) {
                            inv.clear(id);
                        }

                        for (int id : redfields) {
                            inv.setItem(id, createI.createItemStack(Material.RED_STAINED_GLASS_PANE, 1, 0, " "));
                        }

                        inv.setItem(49, createI.createItemStack(Material.ARROW,1,0,"§aGo Back"));

                        p.closeInventory();
                        p.openInventory(inv);
                    }
                    }
                }
            if(e.getView().getTitle().equalsIgnoreCase("§8Crafting Menu")) {
                p.sendMessage("test");
                if (e.getSlot() == 23) {
                    p.sendMessage("test");

                    ItemStack[] matrix = new ItemStack[9];
                    matrix[0] = inv.getItem(10);
                    matrix[1] = inv.getItem(11);
                    matrix[2] = inv.getItem(12);
                    matrix[3] = inv.getItem(19);
                    matrix[4] = inv.getItem(20);
                    matrix[5] = inv.getItem(21);
                    matrix[6] = inv.getItem(28);
                    matrix[7] = inv.getItem(29);
                    matrix[8] = inv.getItem(30);
                    e.setCancelled(true);
                    p.sendMessage(String.valueOf(matrix.length));
                    cic.setMatrix(matrix);
                    p.sendMessage(cic.getResult().toString());
                    inv.setItem(23, cic.getResult());
                }
            }

            }


        }

   /* private boolean containsSmallRecipe(Inventory v) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 53; i++) {
            if (!bannedSlots.contains(i) && i != 26 && v.getItem(i) != null) {

                list.add(i);
            }
        }
        Collections.sort(list);

        if (list.size() == 0)
            return false;

        int smallest = list.get(0);

        if (smallest != 0 && (((smallest <= 42 && v.getItem(smallest + 8) != null)
                || (smallest <= 33 && v.getItem(smallest + 17) != null)))) {

            smallest -= 1;
        }
        if (smallest != 0 && (((smallest <= 42 && v.getItem(smallest + 8) != null)
                || (smallest <= 33 && v.getItem(smallest + 17) != null)))) {

            smallest -= 1;
        }

        List<Integer> comparisonList = new ArrayList<Integer>();

        comparisonList.add(smallest);
        comparisonList.add(smallest + 1);
        comparisonList.add(smallest + 2);
        comparisonList.add(smallest + 9);
        comparisonList.add(smallest + 10);
        comparisonList.add(smallest + 11);
        comparisonList.add(smallest + 18);
        comparisonList.add(smallest + 19);
        comparisonList.add(smallest + 20);

        for (int i : list) {
            if (!comparisonList.contains(i)) {
                return false;
            }
        }

        return true;
    }

    public ItemStack[] getMatrix(Inventory v) {

        if (containsSmallRecipe(v)) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < 53; i++) {
                if (!bannedSlots.contains(i) && i != 26 && v.getItem(i) != null) {
                    list.add(i);

                }
            }
            Collections.sort(list);

            if (list.size() == 0)
                return new ItemStack[9];

            int smallest = list.get(0);

            if (smallest != 0 && (((smallest <= 42 && v.getItem(smallest + 8) != null)
                    || (smallest <= 33 && v.getItem(smallest + 17) != null)))) {

                smallest -= 1;
            }
            if (smallest != 0 && (((smallest <= 42 && v.getItem(smallest + 8) != null)
                    || (smallest <= 33 && v.getItem(smallest + 17) != null)))) {

                smallest -= 1;
            }

            List<Integer> comparisonList = new ArrayList<Integer>();

            comparisonList.add(smallest);
            comparisonList.add(smallest + 1);
            comparisonList.add(smallest + 2);
            comparisonList.add(smallest + 9);
            comparisonList.add(smallest + 10);
            comparisonList.add(smallest + 11);
            comparisonList.add(smallest + 18);
            comparisonList.add(smallest + 19);
            comparisonList.add(smallest + 20);

            ItemStack[] matrix = new ItemStack[9];
            for (int i = 0; i < 9; i++) {

                if (comparisonList.get(i) <= 50) {
                    matrix[i] = v.getItem(comparisonList.get(i));
                } else {
                    matrix[i] = null;
                }

            }
            return matrix;

        } else {

            int size = 0;
            for (int i = 0; i < 53; i++) {

                if (!bannedSlots.contains(i) && i != 26 && v.getItem(i) != null)
                    size++;

            }

            if (size <= 9) {

                List<ItemStack> list = new ArrayList<>();
                for (int i = 0; i < 52; i++) {
                    if (!bannedSlots.contains(i) && i != 26 && v.getItem(i) != null)
                        list.add(v.getItem(i));
                }

                ItemStack[] matrix = new ItemStack[9];

                for (int i = 0; i < list.size(); i++) {

                    matrix[i] = list.get(i);

                }
                return matrix;

            } else {
                ItemStack[] matrix = new ItemStack[36];

                matrix[0] = v.getItem(0);
                matrix[1] = v.getItem(1);
                matrix[2] = v.getItem(2);
                matrix[3] = v.getItem(3);
                matrix[4] = v.getItem(4);
                matrix[5] = v.getItem(5);

                matrix[6] = v.getItem(9);
                matrix[7] = v.getItem(10);
                matrix[8] = v.getItem(11);
                matrix[9] = v.getItem(12);
                matrix[10] = v.getItem(13);
                matrix[11] = v.getItem(14);

                matrix[12] = v.getItem(18);
                matrix[13] = v.getItem(19);
                matrix[14] = v.getItem(20);
                matrix[15] = v.getItem(21);
                matrix[16] = v.getItem(22);
                matrix[17] = v.getItem(23);

                matrix[18] = v.getItem(27);
                matrix[19] = v.getItem(28);
                matrix[20] = v.getItem(29);
                matrix[21] = v.getItem(30);
                matrix[22] = v.getItem(31);
                matrix[23] = v.getItem(32);

                matrix[24] = v.getItem(36);
                matrix[25] = v.getItem(37);
                matrix[26] = v.getItem(38);
                matrix[27] = v.getItem(39);
                matrix[28] = v.getItem(40);
                matrix[29] = v.getItem(41);

                matrix[30] = v.getItem(45);
                matrix[31] = v.getItem(46);
                matrix[32] = v.getItem(47);
                matrix[33] = v.getItem(48);
                matrix[34] = v.getItem(49);
                matrix[35] = v.getItem(50);

                return matrix;
            }

        }

    }*/
}
