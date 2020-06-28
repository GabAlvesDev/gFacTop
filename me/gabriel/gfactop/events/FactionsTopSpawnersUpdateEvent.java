package me.gabriel.gfactop.events;

import org.bukkit.event.*;
import java.util.*;
import com.massivecraft.factions.entity.*;

public class FactionsTopSpawnersUpdateEvent extends Event
{
    private static final HandlerList handlers;
    private List<Map.Entry<Faction, Double>> topFactions;
    
    static {
        handlers = new HandlerList();
    }
    
    public HandlerList getHandlers() {
        return FactionsTopSpawnersUpdateEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return FactionsTopSpawnersUpdateEvent.handlers;
    }
    
    public FactionsTopSpawnersUpdateEvent(final List<Map.Entry<Faction, Double>> topFactions) {
        this.topFactions = topFactions;
    }
    
    public List<Map.Entry<Faction, Double>> getTopFactions() {
        return this.topFactions;
    }
}
