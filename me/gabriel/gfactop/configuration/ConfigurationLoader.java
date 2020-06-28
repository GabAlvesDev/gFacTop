package me.gabriel.gfactop.configuration;

import java.util.*;

import me.gabriel.gfactop.*;

public class ConfigurationLoader
{
    public static final HashMap<String, Double> ENTITY_BY_PRICE;
    
    static {
        ENTITY_BY_PRICE = new HashMap<String, Double>();
    }
    
    public static void load() {
        ConfigurationLoader.ENTITY_BY_PRICE.clear();
        for (final String s : Main.get().getConfig().getStringList("Spawners")) {
            final String[] splitted = s.split(",");
            try {
                ConfigurationLoader.ENTITY_BY_PRICE.put(splitted[0].toUpperCase(), Double.parseDouble(splitted[1]));
            }
            catch (Throwable e) {
                System.out.println("[Ftop] Erro no arquivo de configuracao do plugin! Linha: " + s);
            }
        }
    }
}
