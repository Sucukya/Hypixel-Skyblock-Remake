//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.npc.commands;

import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class reforge implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cms, Command cmd, String arg, String[] args) {
        Player p = (Player)cms;
        if(p.hasPermission("hpsbr.reforge")) {
            Villager villager = (Villager) p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
            LivingEntity vlg = villager;
            villager.setAdult();
            villager.setProfession(Villager.Profession.TOOLSMITH);
            villager.setCustomName("§fBlacksmith");
            villager.setCustomNameVisible(true);
            villager.setInvulnerable(true);
            villager.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
            villager.setCollidable(false);
            villager.setGravity(false);


            Location loc = villager.getLocation();
            double y = villager.getLocation().getY() - 0.25;
            loc.setY(y);
            loc.setZ(villager.getLocation().getZ());
            loc.setX(villager.getLocation().getX());
            ArmorStand astand = (ArmorStand) p.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
            astand.setInvulnerable(true);
            astand.setGravity(false);
            astand.setCustomName("§e§lCLICK");
            astand.setCustomNameVisible(true);
        }
        return true;
    }



}
