package me.naturaldisater.ReloadMap;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.world.DataException;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class ReloadMap {
    private final JavaPlugin plugin;
    public ReloadMap(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    public void loadaxitmap() {
        try {
            Location l = new Location(Bukkit.getWorld("world"), plugin.getConfig().getInt("AxitMap.x"), plugin.getConfig().getInt("AxitMap.y"), plugin.getConfig().getInt("AxitMap.z"));
            WorldEditPlugin worldEditPlugin = (WorldEditPlugin)Bukkit.getPluginManager().getPlugin("WorldEdit");
            File schematic = new File("plugins//WorldEdit//schematics//axit.schematic");
            CuboidClipboard cc;
            EditSession es = new EditSession(new BukkitWorld(l.getWorld()), -1);
            cc = CuboidClipboard.loadSchematic(schematic);
            cc.paste(es, new Vector(l.getBlockX(), l.getBlockY(), l.getBlockZ()), false);
        }
        catch (DataException | IOException | MaxChangedBlocksException ex) {
            ex.printStackTrace();
        }
    }
    public void loadfiremap() {
        try {
            Location l = new Location(Bukkit.getWorld("world"), plugin.getConfig().getInt("FireMap.x"), plugin.getConfig().getInt("FireMap.y"), plugin.getConfig().getInt("FireMap.z"));
            WorldEditPlugin worldEditPlugin = (WorldEditPlugin)Bukkit.getPluginManager().getPlugin("WorldEdit");
            File schematic = new File("plugins//WorldEdit//schematics//fire.schematic");
            CuboidClipboard cc;
            EditSession es = new EditSession(new BukkitWorld(l.getWorld()), -1);
            cc = CuboidClipboard.loadSchematic(schematic);
            cc.paste(es, new Vector(l.getBlockX(), l.getBlockY(), l.getBlockZ()), false);
        }
        catch (DataException | IOException | MaxChangedBlocksException ex) {
            ex.printStackTrace();
        }
    }
    public void loadghastmap() {
        try {
            Location l = new Location(Bukkit.getWorld("world"), plugin.getConfig().getInt("GhastMap.x"), plugin.getConfig().getInt("GhastMap.y"), plugin.getConfig().getInt("GhastMap.z"));
            WorldEditPlugin worldEditPlugin = (WorldEditPlugin)Bukkit.getPluginManager().getPlugin("WorldEdit");
            File schematic = new File("plugins//WorldEdit//schematics//ghast.schematic");
            CuboidClipboard cc;
            EditSession es = new EditSession(new BukkitWorld(l.getWorld()), -1);
            cc = CuboidClipboard.loadSchematic(schematic);
            cc.paste(es, new Vector(l.getBlockX(), l.getBlockY(), l.getBlockZ()), false);
        }
        catch (DataException | IOException | MaxChangedBlocksException ex) {
            ex.printStackTrace();
        }
    }
    public void loadwithermap() {
        try {
            Location l = new Location(Bukkit.getWorld("world"), plugin.getConfig().getInt("WitherMap.x"), plugin.getConfig().getInt("WitherMap.y"), plugin.getConfig().getInt("WitherMap.z"));
            WorldEditPlugin worldEditPlugin = (WorldEditPlugin)Bukkit.getPluginManager().getPlugin("WorldEdit");
            File schematic = new File("plugins//WorldEdit//schematics//wither.schematic");
            CuboidClipboard cc;
            EditSession es = new EditSession(new BukkitWorld(l.getWorld()), -1);
            cc = CuboidClipboard.loadSchematic(schematic);
            cc.paste(es, new Vector(l.getBlockX(), l.getBlockY(), l.getBlockZ()), false);
        }
        catch (DataException | IOException | MaxChangedBlocksException ex) {
            ex.printStackTrace();
        }
    }
    public void loadmeteormap() {
        try {
            Location l = new Location(Bukkit.getWorld("world"), plugin.getConfig().getInt("WitherMap.x"), plugin.getConfig().getInt("WitherMap.y"), plugin.getConfig().getInt("WitherMap.z"));
            WorldEditPlugin worldEditPlugin = (WorldEditPlugin)Bukkit.getPluginManager().getPlugin("WorldEdit");
            File schematic = new File("plugins//WorldEdit//schematics//wither.schematic");
            CuboidClipboard cc;
            EditSession es = new EditSession(new BukkitWorld(l.getWorld()), -1);
            cc = CuboidClipboard.loadSchematic(schematic);
            cc.paste(es, new Vector(l.getBlockX(), l.getBlockY(), l.getBlockZ()), false);
        }
        catch (DataException | IOException | MaxChangedBlocksException ex) {
            ex.printStackTrace();
        }
    }
}
