package me.gabriel.gfactop.factions;

import org.bukkit.entity.*;
import java.text.*;
import java.util.*;

import com.massivecraft.factions.entity.*;

import me.gabriel.gfactop.hooks.*;
import me.gabriel.gfactop.inventory.utils.*;

public class FactionsManager
{
    public static HashMap<Faction, HashMap<EntityType, Integer>> SPAWNERS_BY_FACTION;
    public static HashMap<Faction, Integer> POWER_BY_FACTION;
    public static HashMap<Faction, Double> COINS_BY_FACTION;
    public static HashMap<Faction, Double> KDR_BY_FACTION;
    public static LinkedHashMap<Faction, Integer> POS_BY_FACTION;
    public static Boolean ENABLED;
    private static final DecimalFormatSymbols DFS;
    private static final DecimalFormat FORMATTER;
    
    static {
        FactionsManager.SPAWNERS_BY_FACTION = new HashMap<Faction, HashMap<EntityType, Integer>>();
        FactionsManager.POWER_BY_FACTION = new HashMap<Faction, Integer>();
        FactionsManager.COINS_BY_FACTION = new HashMap<Faction, Double>();
        FactionsManager.KDR_BY_FACTION = new HashMap<Faction, Double>();
        FactionsManager.POS_BY_FACTION = new LinkedHashMap<Faction, Integer>();
        FactionsManager.ENABLED = Boolean.FALSE;
        DFS = new DecimalFormatSymbols(new Locale("pt", "BR"));
        FORMATTER = new DecimalFormat("###,###,###", FactionsManager.DFS);
    }
    
    public static ArrayList<String> geradoresToString(final Faction faction, final Double coins) {
        final ArrayList<String> geradoresString = new ArrayList<String>();
        final Integer total = getSpawnersTotal(faction);
        geradoresString.add("§fTotal de coins dos " + total + " geradores: §7" + FactionsManager.FORMATTER.format(coins));
        if (total == 0) {
            return geradoresString;
        }
        geradoresString.add("");
        for (final Map.Entry<EntityType, Integer> s : FactionsManager.SPAWNERS_BY_FACTION.get(faction).entrySet()) {
            geradoresString.add("§f" + getEntityName(s.getKey()) + ": §7" + s.getValue());
        }
        return geradoresString;
    }
    
    public static ArrayList<String> coinsToString(final Faction faction, final Double coins) {
        final ArrayList<String> coinsString = new ArrayList<String>();
        coinsString.add("§fCoins: §7" + FactionsManager.FORMATTER.format(coins));
        coinsString.add("");
        faction.getMPlayers().forEach(p -> coinsString.add("§f" + p.getName() + ": §7" + FactionsManager.FORMATTER.format(VaultHook.getSaldo(p))));
        return coinsString;
    }
    
    public static ArrayList<String> powerToString(final Faction faction, final Integer power) {
        final ArrayList<String> powerString = new ArrayList<String>();
        powerString.add("§fPoder: §7" + power + "/" + faction.getPowerMaxRounded());
        powerString.add("");
        faction.getMPlayers().forEach(p -> powerString.add("§f" + p.getName() + ": §7" + p.getPowerRounded() + "/" + p.getPowerMaxRounded()));
        return powerString;
    }
    
    public static ArrayList<String> kdrToString(final Faction faction) {
        final ArrayList<String> kdrString = new ArrayList<String>();
        kdrString.add("§fKDR: §7" + faction.getKdrRounded());
        kdrString.add("§fAbates: §7" + faction.getKills());
        kdrString.add("§fMortes: §7" + faction.getDeaths());
        kdrString.add("");
        faction.getMPlayers().forEach(p -> kdrString.add("§f" + p.getName() + ": §7" + p.getKdrRounded()));
        return kdrString;
    }
    
    public static ArrayList<String> valueToString(final Double[] values) {
        final ArrayList<String> valueString = new ArrayList<String>();
        valueString.add("§fValor da Fac\u00e7\u00e3o: §6" + FactionsManager.FORMATTER.format(values[0] + values[1]));
        valueString.add("");
        valueString.add("§fTotal em Coins: §7" + FactionsManager.FORMATTER.format(values[0]));
        valueString.add("§fTotal em Geradores: §7" + FactionsManager.FORMATTER.format(values[1]));
        valueString.add("");
        return valueString;
    }
    
    private static int getSpawnersTotal(final Faction faction) {
        return FactionsManager.SPAWNERS_BY_FACTION.containsKey(faction) ? FactionsManager.SPAWNERS_BY_FACTION.get(faction).values().stream().mapToInt(Integer::intValue).sum() : 0;
    }
    
    @SuppressWarnings("deprecation")
	private static String getEntityName(final EntityType tipo) {
        try {
            return EntityName.valueOf(tipo).getName();
        }
        catch (Throwable e) {
            return tipo.getName().replace("_", "");
        }
    }
}
