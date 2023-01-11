package me.naturaldisater.Events;

import me.naturaldisater.Color.color;
import me.naturaldisater.Commands.Command;
import me.naturaldisater.Countdown.Axit;
import me.naturaldisater.Countdown.Meteor;
import me.naturaldisater.Naturaldisater;
import me.naturaldisater.ReloadMap.ReloadMap;
import me.naturaldisater.Utils.DelayTask;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Events implements Listener {
    private final JavaPlugin plugin;
    private final Economy eco = Naturaldisater.getEconomy();

    public Events(JavaPlugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void PlayerWaterKill(PlayerEntersWaterEvent e) {
        Player p = e.getPlayer();
        p.getKiller();
        p.sendMessage(color.transalate(plugin.getConfig().getString("Message-When-PlayerWater-Kill")));
    }
    @EventHandler
    public void Axit(GameAxitStartEvent e) {
        Player p = e.getPlayer();
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "title @a times 20 40 20");
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                "title @a subtitle {\"text\":\"Go to your home\"}");
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                "title @a title {\"text\":\"Axit World start\",\"color\":\"aqua\"}");
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "weather rain");
        new Axit().run(plugin.getConfig().getInt("Time-Happen-Axit"), plugin, p);
        new DelayTask(plugin, plugin.getConfig().getInt("Time-Happen-Axit") + plugin.getConfig().getInt("Time-Between-GameEnd-And-Teleport")) {
            @Override
            public void run() {
                new DelayTask(plugin, 5) {
                    @Override
                    public void run() {
                        Bukkit.getServer().broadcastMessage(color.transalate(plugin.getConfig().getString("Reload-Map-Message")));
                        new ReloadMap(plugin).loadaxitmap();
                        Bukkit.getServer().broadcastMessage(color.transalate(plugin.getConfig().getString("Reload-Map-Successful-Message")));
                    }
                };
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Congraculation! " + p.getName() + " is winner");
                eco.depositPlayer(p, plugin.getConfig().getInt("Winner-Axit-Money"));
                p.sendMessage(color.transalate(plugin.getConfig().getString("Giving-Money-Message") + " " + plugin.getConfig().getInt("Winner-Axit-Money")));
                Location loc = new Location(p.getWorld(), plugin.getConfig().getInt("SpawnAxit.x"), plugin.getConfig().getInt("SpawnAxit.y"), plugin.getConfig().getInt("SpawnAxit.z"));
                p.setHealth(20);
                p.teleport(loc);
            }
        };
        new Command(plugin).setFinish(true);
    }
    @EventHandler
    public void Meteor(GameMeteorStartEvent e) {
        Player p = e.getPlayer();
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "title @a times 20 40 20");
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                "title @a subtitle {\"text\":\"Avoid being hit\"}");
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                "title @a title {\"text\":\"The Meteor coming\",\"color\":\"aqua\"}");
        new Meteor().run(plugin.getConfig().getInt("Time-Happen-Meteor"), plugin, p);
        new DelayTask(plugin, plugin.getConfig().getInt("Time-Happen-Meteor") + plugin.getConfig().getInt("Time-Between-GameEnd-And-Teleport")) {
            @Override
            public void run() {
                new DelayTask(plugin, 5) {
                    @Override
                    public void run() {
                        Bukkit.getServer().broadcastMessage(color.transalate(plugin.getConfig().getString("Reload-Map-Message")));
                        new ReloadMap(plugin).loadmeteormap();
                        Bukkit.getServer().broadcastMessage(color.transalate(plugin.getConfig().getString("Reload-Map-Successful-Message")));
                    }
                };
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Congraculation! " + p.getName() + " is winner");
                eco.depositPlayer(p, plugin.getConfig().getInt("Winner-Meteor-Money"));
                p.sendMessage(color.transalate(plugin.getConfig().getString("Giving-Money-Message") + " " + plugin.getConfig().getInt("Winner-Meteor-Money")));
                Location loc = new Location(p.getWorld(), plugin.getConfig().getInt("SpawnMeteor.x"), plugin.getConfig().getInt("SpawnMeteor.y"), plugin.getConfig().getInt("SpawnMeteor.z"));
                p.setHealth(20);
                p.teleport(loc);
            }
        };
    }
    public String getPrefix() {
        return plugin.getConfig().getString("Prefix");
    }
}
