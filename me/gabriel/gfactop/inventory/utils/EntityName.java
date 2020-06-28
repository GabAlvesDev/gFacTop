package me.gabriel.gfactop.inventory.utils;

import org.bukkit.entity.*;

public enum EntityName
{
    AREA_EFFECT_CLOUD("AREA_EFFECT_CLOUD", 0, "\u00c1rea de Efeito de Po\u00e7\u00e3o"), 
    ARMOR_STAND("ARMOR_STAND", 1, "Suporte para Armaduras"), 
    ARROW("ARROW", 2, "Flecha"), 
    BAT("BAT", 3, "Morcego"), 
    BLAZE("BLAZE", 4, "Blaze"), 
    BOAT("BOAT", 5, "Barco"), 
    CAVE_SPIDER("CAVE_SPIDER", 6, "Aranha da Caverna"), 
    CHICKEN("CHICKEN", 7, "Galinha"), 
    COD("COD", 8, "Bacalhau"), 
    COMPLEX_PART("COMPLEX_PART", 9, "Desconhecido"), 
    COW("COW", 10, "Vaca"), 
    CREEPER("CREEPER", 11, "Creeper"), 
    DOLPHIN("DOLPHIN", 12, "Golfinho"), 
    DONKEY("DONKEY", 13, "Burro"), 
    DRAGON_FIREBALL("DRAGON_FIREBALL", 14, "Bola de Fogo"), 
    DROPPED_ITEM("DROPPED_ITEM", 15, "Item dropado"), 
    DROWNED("DROWNED", 16, "Afogado"), 
    EGG("EGG", 17, "Ovo"), 
    ELDER_GUARDIAN("ELDER_GUARDIAN", 18, "Guardi\u00e3o Mestre"), 
    ENDER_CRYSTAL("ENDER_CRYSTAL", 19, "Cristal do End"), 
    ENDER_DRAGON("ENDER_DRAGON", 20, "Drag\u00e3o do Fim"), 
    ENDER_PEARL("ENDER_PEARL", 21, "P\u00e9rola do Fim"), 
    ENDER_SIGNAL("ENDER_SIGNAL", 22, "Olho do Fim"), 
    ENDERMAN("ENDERMAN", 23, "Enderman"), 
    ENDERMITE("ENDERMITE", 24, "Endermite"), 
    EVOKER("EVOKER", 25, "Invocador"), 
    EVOKER_FANGS("EVOKER_FANGS", 26, "Presas do Invocador"), 
    EXPERIENCE_ORB("EXPERIENCE_ORB", 27, "Orb de Experi\u00eancia"), 
    FALLING_BLOCK("FALLING_BLOCK", 28, "Bloco Caindo"), 
    FIREBALL("FIREBALL", 29, "Bola de Fogo"), 
    FIREWORK("FIREWORK", 30, "Fogos de Artif\u00edcio"), 
    FISHING_HOOK("FISHING_HOOK", 31, "Isca da Vara de Pesca"), 
    GHAST("GHAST", 32, "Ghast"), 
    GIANT("GIANT", 33, "Zumbi Gigante"), 
    GUARDIAN("GUARDIAN", 34, "Guardi\u00e3o"), 
    HORSE("HORSE", 35, "Cavalo"), 
    HUSK("HUSK", 36, "Zumbi do Deserto"), 
    ILLUSIONER("ILLUSIONER", 37, "Ilusionista"), 
    IRON_GOLEM("IRON_GOLEM", 38, "Golem de Ferro"), 
    ITEM_FRAME("ITEM_FRAME", 39, "Moldura"), 
    LEASH_HITCH("LEASH_HITCH", 40, "Desconhecido"), 
    LIGHTNING("LIGHTNING", 41, "Raio"), 
    LINGERING_POTION("LINGERING_POTION", 42, "Po\u00e7\u00e3o"), 
    LLAMA("LLAMA", 43, "Lhama"), 
    LLAMA_SPIT("LLAMA_SPIT", 44, "Cuspe de Lhama"), 
    MAGMA_CUBE("MAGMA_CUBE", 45, "Cubo de Magma"), 
    MINECART("MINECART", 46, "Carrinho"), 
    MINECART_CHEST("MINECART_CHEST", 47, "Carrinho com Ba\u00fa"), 
    MINECART_COMMAND("MINECART_COMMAND", 48, "Carrinho com Bloco de Comando"), 
    MINECART_FURNACE("MINECART_FURNACE", 49, "Carrinho com Fornalha"), 
    MINECART_HOPPER("MINECART_HOPPER", 50, "Carrinho com Funil"), 
    MINECART_MOB_SPAWNER("MINECART_MOB_SPAWNER", 51, "Carrinho com Gerador de Monstros"), 
    MINECART_TNT("MINECART_TNT", 52, "Carrinho com Dinamite"), 
    MULE("MULE", 53, "Mula"), 
    MUSHROOM_COW("MUSHROOM_COW", 54, "Vaca de Cogumelo"), 
    OCELOT("OCELOT", 55, "Jaguatirica"), 
    PAINTING("PAINTING", 56, "Pintura"), 
    PARROT("PARROT", 57, "Papagaio"), 
    PHANTOM("PHANTOM", 58, "Phantom"), 
    PIG("PIG", 59, "Porco"), 
    PIG_ZOMBIE("PIG_ZOMBIE", 60, "Porco Zumbi"), 
    PLAYER("PLAYER", 61, "Player"), 
    POLAR_BEAR("POLAR_BEAR", 62, "Urso Polar"), 
    PRIMED_TNT("PRIMED_TNT", 63, "Dinamite"), 
    PUFFERFISH("PUFFERFISH", 64, "Baiacu"), 
    RABBIT("RABBIT", 65, "Coelho"), 
    SALMON("SALMON", 66, "Salm\u00e3o"), 
    SHEEP("SHEEP", 67, "Ovelha"), 
    SHULKER("SHULKER", 68, "Shulker"), 
    SHULKER_BULLET("SHULKER_BULLET", 69, "Dardo de Shulker"), 
    SILVERFISH("SILVERFISH", 70, "Silverfish"), 
    SKELETON("SKELETON", 71, "Esqueleto"), 
    SKELETON_HORSE("SKELETON_HORSE", 72, "Cavalo Esqueleto"), 
    SLIME("SLIME", 73, "Slime"), 
    SMALL_FIREBALL("SMALL_FIREBALL", 74, "Bola de Fogo Pequena"), 
    SNOWBALL("SNOWBALL", 75, "Bola de Neve"), 
    SNOWMAN("SNOWMAN", 76, "Golem de Neve"), 
    SPECTRAL_ARROW("SPECTRAL_ARROW", 77, "Flecha Espectral"), 
    SPIDER("SPIDER", 78, "Aranha"), 
    SPLASH_POTION("SPLASH_POTION", 79, "Po\u00e7\u00e3o Arremess\u00e1vel"), 
    SQUID("SQUID", 80, "Lula"), 
    STRAY("STRAY", 81, "Esqueleto Vagante"), 
    THROWN_EXP_BOTTLE("THROWN_EXP_BOTTLE", 82, "Frasco de Experi\u00eancia"), 
    TIPPED_ARROW("TIPPED_ARROW", 83, "Flecha"), 
    TRIDENT("TRIDENT", 84, "Tridente"), 
    TROPICAL_FISH("TROPICAL_FISH", 85, "Peixe Tropical"), 
    TURTLE("TURTLE", 86, "Tartaruga"), 
    UNKNOWN("UNKNOWN", 87, "Desconhecido"), 
    VEX("VEX", 88, "Fantasma"), 
    VILLAGER("VILLAGER", 89, "Vilager"), 
    VINDICATOR("VINDICATOR", 90, "Vingador"), 
    WEATHER("WEATHER", 91, "Chuva"), 
    WITCH("WITCH", 92, "Bruxa"), 
    WITHER("WITHER", 93, "Wither"), 
    WITHER_SKELETON("WITHER_SKELETON", 94, "Esqueleto Wither"), 
    WITHER_SKULL("WITHER_SKULL", 95, "Cabe\u00e7a do Wither"), 
    WOLF("WOLF", 96, "Lobo"), 
    ZOMBIE("ZOMBIE", 97, "Zumbi"), 
    ZOMBIE_HORSE("ZOMBIE_HORSE", 98, "Cavalo Zumbi"), 
    ZOMBIE_VILLAGER("ZOMBIE_VILLAGER", 99, "Alde\u00e3o Zumbi");
    
    private String name;
    
    private EntityName(final String s, final int n, final String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public static EntityName valueOf(final Entity entity) {
        return valueOf(entity.getType());
    }
    
    public static EntityName valueOf(final EntityType entityType) {
        return valueOf(entityType.name());
    }
}
