package me.gabriel.gfactop.inventory.utils;

import org.bukkit.inventory.*;

public class GuiHolder implements InventoryHolder
{
    private Type type;
    private Integer pag;
    
    public GuiHolder(final Type type, final Integer pag) {
        this.type = type;
        this.pag = pag;
    }
    
    public Inventory getInventory() {
        return null;
    }
    
    public Type getType() {
        return this.type;
    }
    
    public Integer getPag() {
        return this.pag;
    }
}
