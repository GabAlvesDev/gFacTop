package me.gabriel.gfactop.inventory;

import org.bukkit.entity.*;

import com.massivecraft.factions.entity.*;

import me.gabriel.gfactop.*;
import me.gabriel.gfactop.events.*;
import me.gabriel.gfactop.factions.*;
import me.gabriel.gfactop.inventory.utils.*;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;
import org.bukkit.inventory.*;
import java.util.*;
import org.bukkit.inventory.meta.*;

public class InventoryLoader
{
    private static List<Inventory> KDR_INVENTORYS;
    private static List<Inventory> COINS_INVENTORYS;
    private static List<Inventory> SPAWNERS_INVENTORYS;
    private static List<Inventory> POWER_INVENTORYS;
    private static List<Inventory> GENERAL_INVENTORYS;
    private static Inventory MENU;
    private static boolean coinsUpdated;
    private static boolean spawnerUpdated;
    
    static {
        InventoryLoader.KDR_INVENTORYS = new ArrayList<Inventory>();
        InventoryLoader.COINS_INVENTORYS = new ArrayList<Inventory>();
        InventoryLoader.SPAWNERS_INVENTORYS = new ArrayList<Inventory>();
        InventoryLoader.POWER_INVENTORYS = new ArrayList<Inventory>();
        InventoryLoader.GENERAL_INVENTORYS = new ArrayList<Inventory>();
        InventoryLoader.coinsUpdated = false;
        InventoryLoader.spawnerUpdated = false;
    }
    
    public static void open(final Player p, final Type type, final Integer pag) {
        switch (type) {
            case KDR: {
                if (InventoryLoader.KDR_INVENTORYS.isEmpty()) {
                    p.sendMessage("§cO Ranking esta sendo atualizado aguarde...");
                    break;
                }
                p.openInventory((Inventory)InventoryLoader.KDR_INVENTORYS.get(pag));
                break;
            }
            case COINS: {
                if (InventoryLoader.COINS_INVENTORYS.isEmpty()) {
                    p.sendMessage("§cO Ranking esta sendo atualizado aguarde...");
                    break;
                }
                p.openInventory((Inventory)InventoryLoader.COINS_INVENTORYS.get(pag));
                break;
            }
            case POWER: {
                if (InventoryLoader.POWER_INVENTORYS.isEmpty()) {
                    p.sendMessage("§cO Ranking esta sendo atualizado aguarde...");
                    break;
                }
                p.openInventory((Inventory)InventoryLoader.POWER_INVENTORYS.get(pag));
                break;
            }
            case SPAWNERS: {
                if (InventoryLoader.SPAWNERS_INVENTORYS.isEmpty()) {
                    p.sendMessage("§cO Ranking esta sendo atualizado aguarde...");
                    break;
                }
                p.openInventory((Inventory)InventoryLoader.SPAWNERS_INVENTORYS.get(pag));
                break;
            }
            case GENERAL: {
                if (InventoryLoader.GENERAL_INVENTORYS.isEmpty()) {
                    p.sendMessage("§cO Ranking esta sendo atualizado aguarde...");
                    break;
                }
                p.openInventory((Inventory)InventoryLoader.GENERAL_INVENTORYS.get(pag));
                break;
            }
            case MENU: {
                if (InventoryLoader.MENU == null) {
                    p.sendMessage("§cO Ranking esta sendo atualizado aguarde...");
                    break;
                }
                p.openInventory(InventoryLoader.MENU);
                break;
            }
            default: {
                throw new NoSuchFieldError("Tipo de inventario invalido!");
            }
        }
    }
    
    public static void updateKdr() {
        Bukkit.getScheduler().runTaskAsynchronously((Plugin)Main.get(), (Runnable)new Runnable() {
            @Override
            public void run() {
                InventoryLoader.KDR_INVENTORYS.clear();
                final List<Map.Entry<Faction, Double>> facs = FactionsUtils.organizeMapCoins(FactionsManager.KDR_BY_FACTION);
                int pos = 1;
                int pag = 1;
                int slot = 10;
                final int lastPag = (int)Math.ceil(facs.size() / 21.0);
                Inventory inventory = null;
                for (final Map.Entry<Faction, Double> entry : facs) {
                    if (slot == 10) {
                        inventory = Bukkit.createInventory((InventoryHolder)new GuiHolder(Type.KDR, pag - 1), 54, "Ranking Geral - KDR");
                        inventory.setItem(47, Heads.ARROW);
                        inventory.setItem(48, Heads.VERDE_KDR);
                        inventory.setItem(49, Heads.CINZA_COINS);
                        inventory.setItem(50, Heads.CINZA_GERADORES);
                        inventory.setItem(51, Heads.CINZA_POWER);
                        if (pag > 1) {
                            inventory.setItem(18, new ItemBuilder(Material.ARROW).setName("§aP\u00e1gina " + (pag - 1)).setLore(new String[] { "§7Clique para voltar", "§7de p\u00e1gina." }).toItemStack());
                        }
                        if (pag++ != lastPag) {
                            inventory.setItem(26, new ItemBuilder(Material.ARROW).setName("§aP\u00e1gina " + pag).setLore(new String[] { "§7Clique para avan\u00e7ar", "§7de p\u00e1gina." }).toItemStack());
                        }
                        InventoryLoader.KDR_INVENTORYS.add(inventory);
                    }
                    inventory.setItem(slot, FactionsUtils.getFactionBanner(entry.getKey(), FactionsManager.kdrToString(entry.getKey()), pos++));
                    slot += ((slot == 34) ? -24 : ((slot == 16 || slot == 25) ? 3 : 1));
                }
                if (!facs.isEmpty()) {
                    Bukkit.getPluginManager().callEvent((Event)new FactionsTopKdrUpdateEvent(facs));
                    try {
                        FactionsUtils.updateEspecialTag(facs.get(0).getKey(), Type.KDR);
                    }
                    catch (Throwable t) {}
                }
            }
        });
    }
    
    public static void updateCoins() {
        Bukkit.getScheduler().runTaskAsynchronously((Plugin)Main.get(), (Runnable)new Runnable() {
            @Override
            public void run() {
                InventoryLoader.COINS_INVENTORYS.clear();
                final List<Map.Entry<Faction, Double>> facs = FactionsUtils.organizeMapCoins(FactionsManager.COINS_BY_FACTION);
                int pos = 1;
                int pag = 1;
                int slot = 10;
                final int lastPag = (int)Math.ceil(facs.size() / 21.0);
                Inventory inventory = null;
                for (final Map.Entry<Faction, Double> entry : facs) {
                    if (slot == 10) {
                        inventory = Bukkit.createInventory((InventoryHolder)new GuiHolder(Type.COINS, pag - 1), 54, "Ranking Geral - Coins");
                        inventory.setItem(47, Heads.ARROW);
                        inventory.setItem(48, Heads.CINZA_KDR);
                        inventory.setItem(49, Heads.VERDE_COINS);
                        inventory.setItem(50, Heads.CINZA_GERADORES);
                        inventory.setItem(51, Heads.CINZA_POWER);
                        if (pag > 1) {
                            inventory.setItem(18, new ItemBuilder(Material.ARROW).setName("§aP\u00e1gina " + (pag - 1)).setLore(new String[] { "§7Clique para voltar", "§7de p\u00e1gina." }).toItemStack());
                        }
                        if (pag++ != lastPag) {
                            inventory.setItem(26, new ItemBuilder(Material.ARROW).setName("§aP\u00e1gina " + pag).setLore(new String[] { "§7Clique para avan\u00e7ar", "§7de p\u00e1gina." }).toItemStack());
                        }
                        InventoryLoader.COINS_INVENTORYS.add(inventory);
                    }
                    inventory.setItem(slot, FactionsUtils.getFactionBanner(entry.getKey(), FactionsManager.coinsToString(entry.getKey(), entry.getValue()), pos++));
                    slot += ((slot == 34) ? -24 : ((slot == 16 || slot == 25) ? 3 : 1));
                }
                if (!facs.isEmpty()) {
                    Bukkit.getPluginManager().callEvent((Event)new FactionsTopCoinsUpdateEvent(facs));
                    try {
                        FactionsUtils.updateEspecialTag(facs.get(0).getKey(), Type.COINS);
                    }
                    catch (Throwable t) {}
                }
                InventoryLoader.access$3(true);
                if (InventoryLoader.updateIsAvailable()) {
                    InventoryLoader.updateGeneral();
                }
            }
        });
    }
    
    public static void updateCreatures() {
        Bukkit.getScheduler().runTaskAsynchronously((Plugin)Main.get(), (Runnable)new Runnable() {
            @Override
            public void run() {
                InventoryLoader.SPAWNERS_INVENTORYS.clear();
                final List<Map.Entry<Faction, Double>> facs = FactionsUtils.organizeMapCreature(FactionsManager.SPAWNERS_BY_FACTION);
                int pos = 1;
                int pag = 1;
                int slot = 10;
                final int lastPag = (int)Math.ceil(facs.size() / 21.0);
                Inventory inventory = null;
                for (final Map.Entry<Faction, Double> entry : facs) {
                    if (slot == 10) {
                        inventory = Bukkit.createInventory((InventoryHolder)new GuiHolder(Type.SPAWNERS, pag - 1), 54, "Ranking Geral - Geradores");
                        inventory.setItem(47, Heads.ARROW);
                        inventory.setItem(48, Heads.CINZA_KDR);
                        inventory.setItem(49, Heads.CINZA_COINS);
                        inventory.setItem(50, Heads.VERDE_GERADORES);
                        inventory.setItem(51, Heads.CINZA_POWER);
                        if (pag > 1) {
                            inventory.setItem(18, new ItemBuilder(Material.ARROW).setName("§aP\u00e1gina " + (pag - 1)).setLore(new String[] { "§7Clique para voltar", "§7de p\u00e1gina." }).toItemStack());
                        }
                        if (pag++ != lastPag) {
                            inventory.setItem(26, new ItemBuilder(Material.ARROW).setName("§aP\u00e1gina " + pag).setLore(new String[] { "§7Clique para avan\u00e7ar", "§7de p\u00e1gina." }).toItemStack());
                        }
                        InventoryLoader.SPAWNERS_INVENTORYS.add(inventory);
                    }
                    inventory.setItem(slot, FactionsUtils.getFactionBanner(entry.getKey(), FactionsManager.geradoresToString(entry.getKey(), entry.getValue()), pos++));
                    slot += ((slot == 34) ? -24 : ((slot == 16 || slot == 25) ? 3 : 1));
                }
                if (!facs.isEmpty()) {
                    Bukkit.getPluginManager().callEvent((Event)new FactionsTopSpawnersUpdateEvent(facs));
                    try {
                        FactionsUtils.updateEspecialTag(facs.get(0).getKey(), Type.SPAWNERS);
                    }
                    catch (Throwable t) {}
                }
                InventoryLoader.access$5(true);
                if (InventoryLoader.updateIsAvailable()) {
                    InventoryLoader.updateGeneral();
                }
            }
        });
    }
    
    public static void updatePower() {
        Bukkit.getScheduler().runTaskAsynchronously((Plugin)Main.get(), (Runnable)new Runnable() {
            @Override
            public void run() {
                InventoryLoader.POWER_INVENTORYS.clear();
                final List<Map.Entry<Faction, Integer>> facs = FactionsUtils.organizeMapPower(FactionsManager.POWER_BY_FACTION);
                int pos = 1;
                int pag = 1;
                int slot = 10;
                final int lastPag = (int)Math.ceil(facs.size() / 21.0);
                Inventory inventory = null;
                for (final Map.Entry<Faction, Integer> entry : facs) {
                    if (slot == 10) {
                        inventory = Bukkit.createInventory((InventoryHolder)new GuiHolder(Type.POWER, pag - 1), 54, "Ranking Geral - Poder");
                        inventory.setItem(47, Heads.ARROW);
                        inventory.setItem(48, Heads.CINZA_KDR);
                        inventory.setItem(49, Heads.CINZA_COINS);
                        inventory.setItem(50, Heads.CINZA_GERADORES);
                        inventory.setItem(51, Heads.VERDE_POWER);
                        if (pag > 1) {
                            inventory.setItem(18, new ItemBuilder(Material.ARROW).setName("§aP\u00e1gina " + (pag - 1)).setLore(new String[] { "§7Clique para voltar", "§7de p\u00e1gina." }).toItemStack());
                        }
                        if (pag++ != lastPag) {
                            inventory.setItem(26, new ItemBuilder(Material.ARROW).setName("§aP\u00e1gina " + pag).setLore(new String[] { "§7Clique para avan\u00e7ar", "§7de p\u00e1gina." }).toItemStack());
                        }
                        InventoryLoader.POWER_INVENTORYS.add(inventory);
                    }
                    inventory.setItem(slot, FactionsUtils.getFactionBanner(entry.getKey(), FactionsManager.powerToString(entry.getKey(), entry.getValue()), pos++));
                    slot += ((slot == 34) ? -24 : ((slot == 16 || slot == 25) ? 3 : 1));
                }
                if (!facs.isEmpty()) {
                    Bukkit.getPluginManager().callEvent((Event)new FactionsTopPowerUpdateEvent(facs));
                    try {
                        FactionsUtils.updateEspecialTag(facs.get(0).getKey(), Type.POWER);
                    }
                    catch (Throwable t) {}
                }
            }
        });
    }
    
    public static void updateGeneral() {
        Bukkit.getScheduler().runTaskAsynchronously((Plugin)Main.get(), (Runnable)new Runnable() {
            @Override
            public void run() {
                InventoryLoader.GENERAL_INVENTORYS.clear();
                final List<Map.Entry<Faction, Double[]>> facs = FactionsUtils.organizeMapGeneral(FactionsManager.SPAWNERS_BY_FACTION, FactionsManager.COINS_BY_FACTION);
                int pos = 1;
                int pag = 1;
                int slot = 10;
                final int lastPag = (int)Math.ceil(facs.size() / 21.0);
                Inventory inventory = null;
                for (final Map.Entry<Faction, Double[]> entry : facs) {
                    if (slot == 10) {
                        inventory = Bukkit.createInventory((InventoryHolder)new GuiHolder(Type.GENERAL, pag - 1), 54, "Ranking Geral - Valor");
                        inventory.setItem(49, Heads.ARROW);
                        if (pag > 1) {
                            inventory.setItem(18, new ItemBuilder(Material.ARROW).setName("§aP\u00e1gina " + (pag - 1)).setLore(new String[] { "§7Clique para voltar", "§7de p\u00e1gina." }).toItemStack());
                        }
                        if (pag++ != lastPag) {
                            inventory.setItem(26, new ItemBuilder(Material.ARROW).setName("§aP\u00e1gina " + pag).setLore(new String[] { "§7Clique para avan\u00e7ar", "§7de p\u00e1gina." }).toItemStack());
                        }
                        InventoryLoader.GENERAL_INVENTORYS.add(inventory);
                    }
                    FactionsManager.POS_BY_FACTION.put(entry.getKey(), pos);
                    inventory.setItem(slot, FactionsUtils.getFactionBanner(entry.getKey(), FactionsManager.valueToString(entry.getValue()), pos++));
                    slot += ((slot == 34) ? -24 : ((slot == 16 || slot == 25) ? 3 : 1));
                }
                if (!facs.isEmpty()) {
                    Bukkit.getPluginManager().callEvent((Event)new FactionsTopGeneralUpdateEvent(facs));
                    try {
                        FactionsUtils.updateEspecialTag(facs.get(0).getKey(), Type.GENERAL);
                    }
                    catch (Throwable t) {}
                }
                FactionsManager.ENABLED = Boolean.TRUE;
                InventoryLoader.access$5(false);
                InventoryLoader.access$3(false);
            }
        });
    }
    
    public static void updateMenu() {
        Bukkit.getScheduler().runTaskAsynchronously((Plugin)Main.get(), (Runnable)new Runnable() {
            @SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
            public void run() {
                InventoryLoader.access$8(Bukkit.createInventory((InventoryHolder)new GuiHolder(Type.MENU, null), 27, "Escolha uma categoria:"));
                final ItemStack netherStar = new ItemStack(Material.NETHER_STAR);
                final ItemStack blockGrass = new ItemStack(Material.GRASS);
                final ItemMeta netherMeta = netherStar.getItemMeta();
                final ItemMeta blockMeta = blockGrass.getItemMeta();
                netherMeta.setLore((List)Arrays.asList("§7Veja as fac\u00e7\u00f5es com", "§7mais valor no servidor."));
                blockMeta.setLore((List)Arrays.asList("§7Veja as fac\u00e7\u00f5es com mais desempenho", "§7no servidor em diversas categorias."));
                netherMeta.setDisplayName("§aRanking de Valor");
                blockMeta.setDisplayName("§aRanking Geral");
                netherStar.setItemMeta(netherMeta);
                blockGrass.setItemMeta(blockMeta);
                InventoryLoader.MENU.setItem(12, netherStar);
                InventoryLoader.MENU.setItem(14, blockGrass);
            }
        });
    }
    
    public static boolean updateIsAvailable() {
        return InventoryLoader.coinsUpdated && InventoryLoader.spawnerUpdated;
    }
    
    static void access$3(final boolean coinsUpdated) {
        InventoryLoader.coinsUpdated = coinsUpdated;
    }
    
    static void access$5(final boolean spawnerUpdated) {
        InventoryLoader.spawnerUpdated = spawnerUpdated;
    }
    
    static void access$8(final Inventory menu) {
        InventoryLoader.MENU = menu;
    }
}
