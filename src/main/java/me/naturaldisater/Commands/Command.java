package me.naturaldisater.Commands;

import me.naturaldisater.Color.color;
import me.naturaldisater.Events.*;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Command implements CommandExecutor {
    private final JavaPlugin plugin;
    private boolean finish = true;
    public Command(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getCommand("nd").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        String prefix = plugin.getConfig().getString("Prefix");
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player");
        }
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("nd")) {
                if (args.length == 0) {
                    sender.sendMessage(color.transalate(prefix + " " + "Plugin made by FIP"));
                    sender.sendMessage(color.transalate(prefix + " " + "/nd help to see how to use plugin"));
                }
                if (args.length == 1 && isFinish()) {
                    if (args[0].equalsIgnoreCase("Axit") && (player.hasPermission("NaturalDisater.Axit") || player.hasPermission("NaturalDisater"))) {
                        player.sendMessage(color.transalate(prefix + " " + plugin.getConfig().getString("Message-Axit-Event")));
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            Bukkit.getPluginManager().callEvent(new GameAxitStartEvent(p));
                        }
                        setFinish(false);
                    }
                    if (args[0].equalsIgnoreCase("meteor") && (player.hasPermission("NaturalDisater.Meteor") || player.hasPermission("NaturalDisater"))) {
                        player.sendMessage(color.transalate(prefix + " " + plugin.getConfig().getString("Message-Meteor-Event")));
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            Bukkit.getPluginManager().callEvent(new GameMeteorStartEvent(p));
                        }
                        setFinish(false);
                    }
                    if (args[0].equalsIgnoreCase("fire") && (player.hasPermission("NaturalDisater.Fire") || player.hasPermission("NaturalDisater"))) {
                        player.sendMessage(color.transalate(prefix + " " + plugin.getConfig().getString("Message-Fire-Event")));
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            Bukkit.getPluginManager().callEvent(new GameFireStartEvent(p));
                        }
                        setFinish(false);
                    }
                    if (args[0].equalsIgnoreCase("wither") && (player.hasPermission("NaturalDisater.Wither") || player.hasPermission("NaturalDisater"))) {
                        player.sendMessage(color.transalate(prefix + " " + plugin.getConfig().getString("Message-Wither-Event")));
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            Bukkit.getPluginManager().callEvent(new GameWitherStartEvent(p));
                        }
                        setFinish(false);
                    }
                    if (args[0].equalsIgnoreCase("ghast") && (player.hasPermission("NaturalDisater.Ghast") || player.hasPermission("NaturalDisater"))) {
                        player.sendMessage(color.transalate(prefix + " " + plugin.getConfig().getString("Message-Ghast-Event")));
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            Bukkit.getPluginManager().callEvent(new GameGhastStartEvent(p));
                        }
                        setFinish(false);
                    }
                }
                if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage("Idk");
                }
            }
        }
        return true;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}
