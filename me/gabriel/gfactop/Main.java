package me.gabriel.gfactop;

import org.bukkit.plugin.java.*;

import me.gabriel.gfactop.configuration.*;
import me.gabriel.gfactop.factions.*;
import me.gabriel.gfactop.hooks.*;
import me.gabriel.gfactop.inventory.utils.*;
import me.gabriel.gfactop.listeners.*;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;

public class Main extends JavaPlugin{
	
	private static Main main;
	
    public void onEnable() {
    	main = this;
        this.loadConfiguration();
        this.registerListeners();
        this.loadFactions();
        this.loadHeads();
        this.loadHook();
    }
    
    private void registerListeners() {
        final PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents((Listener)new onPlayerCommand(), (Plugin)this);
        pm.registerEvents((Listener)new onClickInventory(), (Plugin)this);
    }
    
    private void loadFactions() {
        FactionsLoader.loadAllFactions();
    }
    
    private void loadHook() {
        new VaultHook();
    }
    
    private void loadHeads() {
        new Heads();
    }
    
    private void loadConfiguration() {
        this.saveDefaultConfig();
        ConfigurationLoader.load();
    }
    
	public static Main get() {
        return main;
    }
}
