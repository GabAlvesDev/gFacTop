package me.gabriel.gfactop.events;

import org.bukkit.event.*;
import java.util.*;
import com.massivecraft.factions.entity.*;

public class FactionsTopKdrUpdateEvent extends Event
{
    private static final HandlerList handlers;
    private List<Map.Entry<Faction, Double>> topFactions;
    
    static {
        handlers = new HandlerList();
    }
    
    public HandlerList getHandlers() {
        return FactionsTopKdrUpdateEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return FactionsTopKdrUpdateEvent.handlers;
    }
    
    public FactionsTopKdrUpdateEvent(final List<Map.Entry<Faction, Double>> topFactions) {
        this.topFactions = topFactions;
    }
    
    public List<Map.Entry<Faction, Double>> getTopFactions() {
        return this.topFactions;
    }
}
