package me.gabriel.gfactop.events;

import org.bukkit.event.*;
import java.util.*;
import com.massivecraft.factions.entity.*;

public class FactionsTopPowerUpdateEvent extends Event
{
    private static final HandlerList handlers;
    private List<Map.Entry<Faction, Integer>> topFactions;
    
    static {
        handlers = new HandlerList();
    }
    
    public HandlerList getHandlers() {
        return FactionsTopPowerUpdateEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return FactionsTopPowerUpdateEvent.handlers;
    }
    
    public FactionsTopPowerUpdateEvent(final List<Map.Entry<Faction, Integer>> topFactions) {
        this.topFactions = topFactions;
    }
    
    public List<Map.Entry<Faction, Integer>> getTopFactions() {
        return this.topFactions;
    }
}
