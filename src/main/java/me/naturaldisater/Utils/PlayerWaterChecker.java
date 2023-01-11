package me.naturaldisater.Utils;

import com.google.common.collect.Sets;
import me.naturaldisater.Events.PlayerEntersWaterEvent;
import me.naturaldisater.Events.PlayerLeavesWaterEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

public class PlayerWaterChecker implements Runnable, Listener {

    public static void init(JavaPlugin plugin, long checkInterval) {
        PlayerWaterChecker instance =  new PlayerWaterChecker();
        Bukkit.getScheduler().runTaskTimer(plugin, instance, 0L, checkInterval);
        Bukkit.getPluginManager().registerEvents(instance, plugin);
    }

    private PlayerWaterChecker() {
        this.divingPlayers = Sets.newHashSet();
        this.walkingPlayers = Sets.newHashSet();
        this.pluginManager = Bukkit.getPluginManager();
    }

    private final Set<Player> divingPlayers;
    private final Set<Player> walkingPlayers;
    private Set<Player> divingCopy;
    private Set<Player> walkingCopy;

    private final PluginManager pluginManager;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(this.isPlayerInWater(player)) {
            divingPlayers.add(player);
        }else {
            walkingPlayers.add(player);
        }
    }

    @Override
    public void run() {

        this.divingCopy = Sets.newHashSet(divingPlayers);
        this.walkingCopy = Sets.newHashSet(walkingPlayers);

        for(Player diving : divingCopy) {
            if(!this.isPlayerInWater(diving)) {
                this.divingPlayers.remove(diving);
                this.walkingPlayers.add(diving);
                this.pluginManager.callEvent(new PlayerLeavesWaterEvent(diving));
            }
        }

        for(Player walking : walkingCopy) {
            if(this.isPlayerInWater(walking)) {
                this.walkingPlayers.remove(walking);
                this.divingPlayers.add(walking);
                this.pluginManager.callEvent(new PlayerEntersWaterEvent(walking));
            }
        }

    }

    private boolean isPlayerInWater(Player player) {
        return player.getEyeLocation().getBlock().isLiquid();
    }

}
