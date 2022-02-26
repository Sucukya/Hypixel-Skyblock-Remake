package me.sucukya.playerStats;

import de.tr7zw.nbtapi.NBTItem;
import me.sucukya.utility.ActionBar;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ActionBarStats {

    public static void send() {
        for (Player p: Bukkit.getOnlinePlayers()) {
            NBTItem nbti = new NBTItem(p.getInventory().getItemInOffHand());
            int basehp = nbti.getInteger("basehp");
            int bonushp = nbti.getInteger("bonushp");
            int hp = basehp + bonushp;
            int basedef = nbti.getInteger("basedef");
            int bonusdef = nbti.getInteger("bonusdef");
            int def = basedef + bonusdef;
            int basemana = nbti.getInteger("basemana");
            int bonusmana = nbti.getInteger("bonusmana");
            int mana = basemana + bonusmana;
            int chp = nbti.getInteger("chp");
            if (def == 0) {
                ActionBar.sendPacket(p, "§c" + chp + "/" + hp + "❤     §b" + mana + "/" + mana + "✎ Mana");
            } else {
                ActionBar.sendPacket(p, "§c" + chp + "/" + hp + "❤     §a" + def + "❈ Defense     §b" + mana + "/" + mana + "✎ Mana");
            }
        }
    }
}