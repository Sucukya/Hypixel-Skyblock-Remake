//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.utility;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.org.apache.commons.codec.binary.Base64;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class createI {
    public static ItemStack createItemStack(Material material, int amount, int subid, String displayName) {
        ItemStack item = new ItemStack(material, amount, (short) subid);
        ItemMeta imeta = item.getItemMeta();
        imeta.setDisplayName(displayName);
        item.setItemMeta(imeta);

        return item;
    }
    public static ItemStack createHead(String url) {
        ItemStack head = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
        if(url.isEmpty())return head;


        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }
}
