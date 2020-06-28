package me.gabriel.gfactop.factions;

import com.massivecraft.factions.entity.*;
import org.bukkit.inventory.*;
import com.massivecraft.factions.util.*;
import com.massivecraft.massivecore.ps.PS;

import me.gabriel.gfactop.configuration.*;
import me.gabriel.gfactop.inventory.utils.*;
import me.gabriel.gfactop.inventory.utils.ItemBuilder;

import org.bukkit.inventory.meta.*;
import org.bukkit.entity.*;

import java.util.*;

public class FactionsUtils
{
    private static Map<Type, Faction> olds;
    
    static {
        FactionsUtils.olds = new HashMap<Type, Faction>();
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static ItemStack getFactionBanner(final Faction faction, final List<String> lore, final int pos) {
        final ItemStack bandeira = new ItemBuilder(Banner.getWhiteBanner(faction.getTag())).toItemStack();
        final ItemMeta bandeiraMeta = bandeira.getItemMeta();
        bandeiraMeta.setDisplayName("§f" + pos + "º.§8 [" + faction.getTag() + "§8] " + faction.getName());
        switch (pos) {
		case 1:
	        lore.add(cordenadas("§fCordenadas da facção: §7X: §f@x §7Z: §f@z", faction));
			break;
		case 2:
	        lore.add(cordenadas("§fCordenadas da facção: §7X: §f@x §7Z: §f@z", faction));
			break;
		case 3:
	        lore.add(cordenadas("§fCordenadas da facção: §7X: §f@x §7Z: §f@z", faction));
			break;
		default:
			break;
		}
        bandeiraMeta.setLore((List)lore);
        bandeira.setItemMeta(bandeiraMeta);
        return bandeira;
    }
    
    public static List<Map.Entry<Faction, Double>> organizeMapCoins(final Map<Faction, Double> unsortMap) {
        final List<Map.Entry<Faction, Double>> list = new ArrayList<Map.Entry<Faction, Double>>(unsortMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Faction, Double>>() {
            @Override
            public int compare(final Map.Entry<Faction, Double> o1, final Map.Entry<Faction, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list;
    }
    
    public static List<Map.Entry<Faction, Integer>> organizeMapPower(final Map<Faction, Integer> unsortMap) {
        final List<Map.Entry<Faction, Integer>> list = new ArrayList<Map.Entry<Faction, Integer>>(unsortMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Faction, Integer>>() {
            @Override
            public int compare(final Map.Entry<Faction, Integer> o1, final Map.Entry<Faction, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list;
    }
    
    public static List<Map.Entry<Faction, Double>> organizeMapCreature(final HashMap<Faction, HashMap<EntityType, Integer>> SPAWNERS_BY_FACTION) {
        final Map<Faction, Double> valueMap = new HashMap<Faction, Double>();
        for (final Map.Entry<Faction, HashMap<EntityType, Integer>> s : SPAWNERS_BY_FACTION.entrySet()) {
            valueMap.put(s.getKey(), getMobSpawnersValor(s.getValue()));
        }
        return organizeMapCoins(valueMap);
    }
    
    public static List<Map.Entry<Faction, Double[]>> organizeMapGeneral(final HashMap<Faction, HashMap<EntityType, Integer>> valueMapSpawners, final Map<Faction, Double> valueMapCoins) {
        final Map<Faction, Double[]> valueMap = new HashMap<Faction, Double[]>();
        for (final Map.Entry<Faction, HashMap<EntityType, Integer>> s : valueMapSpawners.entrySet()) {
            final Double[] value = { valueMapCoins.get(s.getKey()), getMobSpawnersValor(s.getValue()) };
            valueMap.put(s.getKey(), value);
        }
        final List<Map.Entry<Faction, Double[]>> list = new ArrayList<Map.Entry<Faction, Double[]>>(valueMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Faction, Double[]>>() {
            @Override
            public int compare(final Map.Entry<Faction, Double[]> o1, final Map.Entry<Faction, Double[]> o2) {
                return Double.compare(o2.getValue()[0] + o2.getValue()[1], o1.getValue()[0] + o1.getValue()[1]);
            }
        });
        return list;
    }
    
    public static void updateEspecialTag(final Faction newf, final Type type) {
        final String color = type.getTag();
        final Faction oldf = FactionsUtils.olds.get(type);
        if (oldf != null) {
            oldf.resetColor();
        }
        newf.setColor(color);
        FactionsUtils.olds.put(type, newf);
    }
    
    @SuppressWarnings("deprecation")
	public static double getMobSpawnersValor(final HashMap<EntityType, Integer> map) {
        double valor = 0.0;
        for (final Map.Entry<EntityType, Integer> s : map.entrySet()) {
            try {
                valor += ConfigurationLoader.ENTITY_BY_PRICE.get(s.getKey().getName().toUpperCase()) * s.getValue();
            }
            catch (Throwable t) {}
        }
        return valor;
    }

    public static String replace(String lore, Faction fac, PS claim) {
        String x, z;
        x = String.valueOf(claim.getLocationX(true).intValue());
        z = String.valueOf(claim.getLocationZ(true).intValue());
        return lore.replace("@x", x).replace("@z", z);
    }
    
    public static String cordenadas(String lore, Faction facção) {
        Iterator<PS> claims = BoardColl.get().getChunks(facção).iterator();
        if (!claims.hasNext()) return "§7A facção não tem nenhuma claim";

        PS claim = claims.next();
        return replace(lore, facção, claim);
    }
}
