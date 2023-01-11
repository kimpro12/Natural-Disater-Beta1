package me.naturaldisater.Countdown;

import me.naturaldisater.Color.color;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Meteor {
    private int task;
    public void run(int time, JavaPlugin plugin, Player p) {
        String prefix = plugin.getConfig().getString("Prefix");
        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            int second = time;

            @Override
            public void run() {
                Location playerLocation = p.getLocation();
                playerLocation.add(0, 20, 0);
                playerLocation.setPitch(90);
                Fireball fireball1 = (Fireball) playerLocation.getWorld().spawnEntity(playerLocation, EntityType.FIREBALL);
                fireball1.setVelocity(fireball1.getVelocity().setY(-1));
                Location t1 = p.getLocation();
                t1.setPitch(90);
                t1.add(2, 20, 0);
                Fireball fireball2 = (Fireball) t1.getWorld().spawnEntity(t1, EntityType.FIREBALL);
                fireball1.setVelocity(fireball2.getVelocity().setY(-1));
                Location t2 = p.getLocation();
                t2.setPitch(90);
                t2.add(0, 20, 2);
                Fireball fireball3 = (Fireball) t2.getWorld().spawnEntity(t2, EntityType.FIREBALL);
                fireball3.setVelocity(fireball3.getVelocity().setY(-1));
                Location t3 = p.getLocation();
                t3.setPitch(90);
                t3.add(-2, 20, 0);
                Fireball fireball4 = (Fireball) t3.getWorld().spawnEntity(t2, EntityType.FIREBALL);
                fireball4.setVelocity(fireball4.getVelocity().setY(-1));
                Location t4 = p.getLocation();
                t4.setPitch(90);
                t4.add(0, 20, -2);
                Fireball fireball5 = (Fireball) t4.getWorld().spawnEntity(t2, EntityType.FIREBALL);
                fireball5.setVelocity(fireball5.getVelocity().setY(-1));
                if (second <= 0) {
                    Bukkit.getScheduler().cancelTask(task);
                }
                second--;
            }
        }, 60, 20);
    }
}
