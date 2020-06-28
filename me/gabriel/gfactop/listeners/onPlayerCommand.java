package me.gabriel.gfactop.listeners;

import org.bukkit.event.player.*;

import me.gabriel.gfactop.inventory.*;
import me.gabriel.gfactop.inventory.utils.*;

import org.bukkit.event.*;

public class onPlayerCommand implements Listener
{
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onCommand(final PlayerCommandPreprocessEvent e) {
        final String message = e.getMessage().toLowerCase();
        if (message.startsWith("/f top") || message.startsWith("/f rank")) {
            e.setCancelled(true);
            InventoryLoader.open(e.getPlayer(), Type.MENU, null);
        }
    }
}
