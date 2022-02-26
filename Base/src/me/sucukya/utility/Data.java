package me.sucukya.utility;

public class Data {
    //Essential Data (like Prefix) is stored here.
    public static String consolePrefix = "HPSBR | ";
    public static String prefix = Files.conf.getString("Prefix");

    public static void refresh() {
          String prefix = Files.conf.getString("Prefix");
    }
}
