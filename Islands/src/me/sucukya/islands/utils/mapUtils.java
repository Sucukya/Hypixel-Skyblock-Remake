//Programmed by Sucukya
//Don't pretend this code is yours.

package me.sucukya.islands.utils;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.entity.Player;

import java.io.*;

public class mapUtils {

    public static String getSelectedProfile(Player p) {
        NBTItem nbti = new NBTItem(p.getInventory().getItemInOffHand());
        int profile = nbti.getInteger("profile");
        String prof = profile + "";
        return prof;
    }

    public static void copyDirectory(File sourceDirectory, File destinationDirectory) throws IOException {
        if (!destinationDirectory.exists()) {
            destinationDirectory.mkdir();
        }
        for (String f : sourceDirectory.list()) {
            copyDirectoryCompatibityMode(new File(sourceDirectory, f), new File(destinationDirectory, f));
        }
    }

    public static void copyDirectoryCompatibityMode(File source, File destination) throws IOException {
        if (source.isDirectory()) {
            copyDirectory(source, destination);
        } else {
            copyFile(source, destination);
        }
    }

    private static void copyFile(File sourceFile, File destinationFile)
            throws IOException {
        try (InputStream in = new FileInputStream(sourceFile);
             OutputStream out = new FileOutputStream(destinationFile)) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        }
    }

}
