package me.sucukya.utility;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.Pets;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class spawnArmorStand {

    public static void spawn(ItemStack stack, Player p) {

        List<Entity> entities = p.getNearbyEntities(10, 10, 10);
        for (Entity entity : entities) {
            if (entity.getType().equals(EntityType.ARMOR_STAND)) {
                ArmorStand as = (ArmorStand) entity;
                if(as.getEquipment().getHelmet() == null || as.getEquipment().getHelmet().getType() == Material.AIR) {
                } else {
                    NBTItem nbti = new NBTItem(as.getEquipment().getHelmet());
                    if(nbti.getString("owner").equalsIgnoreCase(p.getUniqueId().toString())) {
                        as.remove();
                    }
                }
            }
        }

        File pets = new File("plugins//HPSBR//Pets//players//" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration petsconfig = YamlConfiguration.loadConfiguration(pets);
        NBTItem nbti = new NBTItem(stack);
        String id = nbti.getString("id");
        if (!petsconfig.getString("equipedpet").equalsIgnoreCase(id)) {
            if(!petsconfig.getString("equipedpet").equalsIgnoreCase("None")) {
                p.sendMessage("yesfa");
                petStat.removeStand(p, petsconfig.getString("equipedpet"));
            }
            petsconfig.set("equipedpet", nbti.getString("id"));
            try {
                petsconfig.save(pets);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            ConfigurationSection cs = petsconfig.getConfigurationSection(id);
            int lvl = cs.getInt("level");
            String type = cs.getString("type");
            String rarity = cs.getString("rarity");
            String head = cs.getString("head");



            p.sendMessage("§aYou summoned your " + Pets.raritycolormap.get(rarity) + type + "§a!");
            petStat.add(p,stack);

            Location loc = p.getLocation();
            loc.setY(p.getLocation().getY() + 1);
            loc.setX(p.getLocation().getX());
            loc.setZ(p.getLocation().getZ());

            if(Pets.hidepets.contains(p.getUniqueId())) {
            } else {
                ArmorStand as = (ArmorStand) p.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
                as.setInvulnerable(true);
                as.setInvisible(true);
                as.setCustomName("§8[§7Lv" + lvl + "§8] " + Pets.raritycolormap.get(rarity) + p.getDisplayName() + "'s " + type);
                as.setCustomNameVisible(true);
                as.setGravity(false);
                as.setSmall(true);
                ItemStack pet = Items.createHead(head);
                NBTItem petnbt = new NBTItem(pet);
                petnbt.setString("owner", p.getUniqueId().toString());
                pet = petnbt.getItem();
                as.getEquipment().setHelmet(pet);
            }
        } else {
            ConfigurationSection cs = petsconfig.getConfigurationSection(id);
            String type = cs.getString("type");
            String rarity = cs.getString("rarity");


            p.sendMessage("§aYou despawned your " + Pets.raritycolormap.get(rarity) + type + "§a!");
            petStat.remove(p,stack);
            petsconfig.set("equipedpet", "None");
            try {
                petsconfig.save(pets);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void spawnUnHide(Player p) {

        /*List<Entity> entities = p.getNearbyEntities(10, 10, 10);
        for (Entity entity : entities) {
            if (entity.getType().equals(EntityType.ARMOR_STAND)) {
                ArmorStand as = (ArmorStand) entity;
                if (as.getEquipment().getHelmet() == null || as.getEquipment().getHelmet().getType() == Material.AIR) {
                } else {
                    NBTItem nbti = new NBTItem(as.getEquipment().getHelmet());
                    if (nbti.getString("owner").equalsIgnoreCase(p.getUniqueId().toString())) {
                        as.remove();
                    }
                }
            }
        }*/
        File pets = new File("plugins//HPSBR//Pets//players//" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration petsconfig = YamlConfiguration.loadConfiguration(pets);
        String id = petsconfig.getString("equipedpet");

        if (id.equalsIgnoreCase("None")) {
        } else {
            p.sendMessage("testz");
            ConfigurationSection cs = petsconfig.getConfigurationSection(id);
            int lvl = cs.getInt("level");
            String type = cs.getString("type");
            String rarity = cs.getString("rarity");
            String head = cs.getString("head");



            Location loc = p.getLocation();
            loc.setY(p.getLocation().getY() + 1);
            loc.setX(p.getLocation().getX());
            loc.setZ(p.getLocation().getZ());

            ArmorStand as = (ArmorStand) p.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
            as.setInvulnerable(true);
            as.setInvisible(true);
            as.setCustomName("§8[§7Lv" + lvl + "§8] " + Pets.raritycolormap.get(rarity) + p.getDisplayName() + "'s " + type);
            as.setCustomNameVisible(true);
            as.setGravity(false);
            as.setSmall(true);

            ItemStack pet = Items.createHead(head);
            NBTItem petnbt = new NBTItem(pet);
            petnbt.setString("owner", p.getUniqueId().toString());
            pet = petnbt.getItem();
            as.getEquipment().setHelmet(pet);
        }
    }
}
