package me.gabriel.gfactop;

import com.massivecraft.factions.entity.*;

import me.gabriel.gfactop.factions.*;

import java.util.*;

public class FTop
{
    private static FTop i;
    
    static {
        FTop.i = new FTop();
    }
    
    public static FTop get() {
        return FTop.i;
    }
    
    public int getTopPosition(final Faction faction) {
        try {
            return FactionsManager.POS_BY_FACTION.get(faction);
        }
        catch (Throwable e) {
            return -1;
        }
    }
    
    public Collection<Faction> getTopFactions() {
        return FactionsManager.POS_BY_FACTION.keySet();
    }
    
    public boolean isEnabled() {
        return FactionsManager.ENABLED;
    }
}
