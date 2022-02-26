//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.listerners;

import me.sucukya.utility.saveStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class leaveListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        saveStats.save(p);
    }

}
