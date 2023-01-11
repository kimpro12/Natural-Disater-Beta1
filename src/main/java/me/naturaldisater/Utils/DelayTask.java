package me.naturaldisater.Utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class DelayTask implements Runnable{

    public DelayTask(JavaPlugin plugin, int second) {
        int time = second * 20;
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, this, time);
    }
}
