package me.sucukya.utility;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Pets;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class convertToItem {

    public static void convert(Player p, ItemStack stack) {
        NBTItem nbti = new NBTItem(stack);
        File pets = new File("plugins//HPSBR//Pets//players//" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration petsconf = YamlConfiguration.loadConfiguration(pets);

        if(nbti.getKeys().contains("id")) {
            String id = nbti.getString("id");
            ConfigurationSection cs = petsconf.getConfigurationSection(id);
            int level = cs.getInt("level");
            String rarity = cs.getString("rarity");
            int xp = cs.getInt("xp");
            String petitem = cs.getString("petitem");
            String type = cs.getString("type");
            String head = cs.getString("head");

            ItemStack pet = Items.createHead(head);
            ItemMeta petmeta = pet.getItemMeta();

            petmeta.setDisplayName("§7[Lvl " + level + "§7] " + Pets.raritycolormap.get(rarity)+type);
            List<String> petlore = new ArrayList<>();
            petlore.add("§8Placeholder Pet");
            petlore.add("");
            petlore.add("§eRight-click to add this pet to");
            petlore.add("§eyour pet menu!");
            petlore.add("");
            petlore.add("§l" + Pets.raritycolormap.get(rarity) + rarity.toUpperCase());
            petmeta.setLore(petlore);
            pet.setItemMeta(petmeta);
            NBTItem petnbt = new NBTItem(pet);
            petnbt.setInteger("level", level);
            petnbt.setInteger("xp", xp);
            petnbt.setString("rarity",rarity);
            petnbt.setString("item",petitem);
            petnbt.setString("id",id);
            petnbt.setString("type",type);
            petnbt.setString("head",head);
            petnbt.setBoolean("pet",true);
            pet = petnbt.getItem();
            p.getInventory().addItem(pet);
            String owned = "";

            String[] elements = petsconf.getString("ownedpets").split(",");
            List<String> list = Arrays.asList(elements);
            ArrayList<String> petslist = new ArrayList<String>(list);
            petslist.remove(id);
            for(int i=0; i < petslist.size(); i++) {
                owned = owned + petslist.get(i) + ",";
            }
            petsconf.set("ownedpets", owned);
            if(!petsconf.getString("equipedpet").equalsIgnoreCase(id)) {
            } else {
                p.sendMessage("test");
                List<Entity> entities = p.getNearbyEntities(10, 10, 10);
                for (Entity entity : entities) {
                    if (entity.getType().equals(EntityType.ARMOR_STAND)) {
                        ArmorStand as = (ArmorStand) entity;
                        as.remove();
                        petStat.remove(p,stack);
                    }
                }
                petsconf.set("equipedpet", "None");
            }

            petsconf.set(id,null);
            try {
                petsconf.save(pets);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
