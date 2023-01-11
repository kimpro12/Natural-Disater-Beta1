package me.naturaldisater.Countdown;

import me.naturaldisater.Color.color;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Axit {
    private int task;

    public void run(int time, JavaPlugin plugin, Player p) {
        String prefix = plugin.getConfig().getString("Prefix");
        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            int second = time;

            @Override
            public void run() {
                Block block = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
                if (block.getType() != Material.BARRIER || block.getType() != Material.GOLD_BLOCK || block.getType() != Material.QUARTZ_BLOCK) {
                    p.getPlayer().damage(0.5);
                    p.sendMessage(color.transalate(prefix + " " + plugin.getConfig().getString("Message-Axit")));
                }
                if (second <= 0) {
                    Bukkit.getScheduler().cancelTask(task);
                }
                second--;
            }
        }, 60, 20);
    }
}
