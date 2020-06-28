package me.gabriel.gfactop.inventory.utils;

public enum Type
{
    KDR("KDR", 0, "KDR", "§c"), 
    COINS("COINS", 1, "Coins", "§e"), 
    SPAWNERS("SPAWNERS", 2, "Geradores", "§a"), 
    POWER("POWER", 3, "Poder", "§b"), 
    GENERAL("GENERAL", 4, "Valor", "§6"), 
    MENU("MENU", 5, (String)null, (String)null);
    
    private String name;
    private String tag;
    
    private Type(final String s, final int n, final String name, final String tag) {
        this.name = name;
        this.tag = tag;
    }
    
    public String getNome() {
        return this.name;
    }
    
    public String getTag() {
        return this.tag;
    }
}
