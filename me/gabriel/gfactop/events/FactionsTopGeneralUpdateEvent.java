package me.gabriel.gfactop.events;

import org.bukkit.event.*;
import java.util.*;
import com.massivecraft.factions.entity.*;

public class FactionsTopGeneralUpdateEvent extends Event
{
    private static final HandlerList handlers;
    private List<Map.Entry<Faction, Double[]>> topFactions;
    
    static {
        handlers = new HandlerList();
    }
    
    public HandlerList getHandlers() {
        return FactionsTopGeneralUpdateEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return FactionsTopGeneralUpdateEvent.handlers;
    }
    
    public FactionsTopGeneralUpdateEvent(final List<Map.Entry<Faction, Double[]>> topFactions) {
        this.topFactions = topFactions;
    }
    
    public List<Map.Entry<Faction, Double[]>> getTopFactions() {
        return this.topFactions;
    }
}
