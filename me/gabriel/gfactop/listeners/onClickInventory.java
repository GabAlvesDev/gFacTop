package me.gabriel.gfactop.listeners;

import org.bukkit.event.inventory.*;

import me.gabriel.gfactop.inventory.*;
import me.gabriel.gfactop.inventory.utils.*;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class onClickInventory implements Listener
{
    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void aoClickar(final InventoryClickEvent e) {
        if (e.getInventory().getHolder() instanceof GuiHolder) {
            e.setCancelled(true);
            e.setResult(Event.Result.DENY);
            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            final Player p = (Player)e.getWhoClicked();
            final int slot = e.getRawSlot();
            final GuiHolder holder = (GuiHolder)e.getInventory().getHolder();
            final Type type = holder.getType();
            final Integer pag = holder.getPag();
            if (e.getInventory().getSize() < slot) {
                return;
            }
            if (type == Type.MENU) {
                if (slot == 12) {
                    InventoryLoader.open(p, Type.GENERAL, 0);
                }
                if (slot == 14) {
                    InventoryLoader.open(p, Type.KDR, 0);
                }
            }
            if (type == Type.GENERAL) {
                if (slot == 49) {
                    InventoryLoader.open(p, Type.MENU, 0);
                }
                if (slot == 26) {
                    InventoryLoader.open(p, type, pag + 1);
                }
                if (slot == 18) {
                    InventoryLoader.open(p, type, pag - 1);
                }
            }
            else {
                if (slot == 47) {
                    InventoryLoader.open(p, Type.MENU, null);
                }
                if (slot == 48) {
                    InventoryLoader.open(p, Type.KDR, 0);
                }
                if (slot == 49) {
                    InventoryLoader.open(p, Type.COINS, 0);
                }
                if (slot == 50) {
                    InventoryLoader.open(p, Type.SPAWNERS, 0);
                }
                if (slot == 51) {
                    InventoryLoader.open(p, Type.POWER, 0);
                }
                if (slot == 26) {
                    InventoryLoader.open(p, type, pag + 1);
                }
                if (slot == 18) {
                    InventoryLoader.open(p, type, pag - 1);
                }
            }
        }
    }
}
