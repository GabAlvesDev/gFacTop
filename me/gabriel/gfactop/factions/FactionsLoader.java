package me.gabriel.gfactop.factions;

import com.massivecraft.massivecore.ps.*;

import br.com.kickpost.ftopnpc.manager.FortuneManager;

import org.bukkit.scheduler.*;
import org.bukkit.plugin.*;
import me.gabriel.gfactop.*;
import me.gabriel.gfactop.hooks.*;
import me.gabriel.gfactop.inventory.*;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.block.*;
import com.massivecraft.factions.entity.*;

public class FactionsLoader extends FactionsManager
{
    private static HashMap<Faction, Set<PS>> CHUNKS_BY_FACTION;
    @SuppressWarnings("unused")
	private static final String WARZONE = "warzone";
    @SuppressWarnings("unused")
	private static final String SAFEZONE = "safezone";
    @SuppressWarnings("unused")
	private static final String NONE = "none";
    
    static {
        FactionsLoader.CHUNKS_BY_FACTION = new HashMap<Faction, Set<PS>>();
    }
    
    public static void loadAllFactions() {
        InventoryLoader.updateMenu();
        new BukkitRunnable() {
            public void run() {
                FactionsLoader.KDR_BY_FACTION.clear();
                FactionsLoader.COINS_BY_FACTION.clear();
                FactionsLoader.POWER_BY_FACTION.clear();
                FactionsLoader.CHUNKS_BY_FACTION.clear();
                for (final Faction faction : FactionColl.get().getAll()) {
                    final String factionId = faction.getId();
                    if (!factionId.equals("none") && !factionId.equals("warzone")) {
                        if (factionId.equals("safezone")) {
                            continue;
                        }
                        FactionsLoader.KDR_BY_FACTION.put(faction, faction.getKdr());
                        FactionsLoader.COINS_BY_FACTION.put(faction, getFactionCoins(faction));
                        FactionsLoader.POWER_BY_FACTION.put(faction, faction.getPowerRounded());
                        FactionsLoader.CHUNKS_BY_FACTION.put(faction, getFactionChunks(faction));
                    }
                }
                InventoryLoader.updateKdr();
                InventoryLoader.updateCoins();
                InventoryLoader.updatePower();
                updateCreatures();
            }
        }.runTaskTimerAsynchronously((Plugin)Main.get(), 0L, 18000L);
        if (Bukkit.getPluginManager().isPluginEnabled("FTopNPCs")) {
            System.out.println("[FTop] Carregando...");
            new FortuneManager();
        }
    }
    
    private static void updateCreatures() {
        new BukkitRunnable() {
            public void run() {
                FactionsLoader.SPAWNERS_BY_FACTION.clear();
                for (final Map.Entry<Faction, Set<PS>> entry : FactionsLoader.CHUNKS_BY_FACTION.entrySet()) {
                    FactionsLoader.SPAWNERS_BY_FACTION.put(entry.getKey(), getMobSpawners(entry.getKey(), entry.getValue()));
                }
                InventoryLoader.updateCreatures();
            }
        }.runTask((Plugin)Main.get());
    }
    
    private static double getFactionCoins(final Faction fac) {
        return fac.getMPlayers().stream().mapToDouble(r -> VaultHook.getSaldo(r)).sum();
    }
    
    private static Set<PS> getFactionChunks(final Faction fac) {
        return (Set<PS>)BoardColl.get().getChunks(fac);
    }
    
    private static HashMap<EntityType, Integer> getMobSpawners(final Faction fac, final Set<PS> chunks) {
        final HashMap<EntityType, Integer> spawners = new HashMap<EntityType, Integer>();
        for (final PS chunk : chunks) {
            BlockState[] tileEntities;
            for (int length = (tileEntities = chunk.asBukkitChunk().getTileEntities()).length, i = 0; i < length; ++i) {
                final BlockState block = tileEntities[i];
                if (block.getType() == Material.MOB_SPAWNER) {
                    final CreatureSpawner spawner = (CreatureSpawner)block;
                    final EntityType spawnedType = spawner.getSpawnedType();
                    if (spawners.containsKey(spawnedType)) {
                        spawners.replace(spawnedType, spawners.get(spawnedType) + 1);
                    }
                    else {
                        spawners.put(spawnedType, 1);
                    }
                }
            }
        }
        return spawners;
    }
}
