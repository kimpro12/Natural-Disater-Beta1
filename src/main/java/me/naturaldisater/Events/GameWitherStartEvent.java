package me.naturaldisater.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class GameWitherStartEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();

    public GameWitherStartEvent(Player who) {
        super(who);
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
