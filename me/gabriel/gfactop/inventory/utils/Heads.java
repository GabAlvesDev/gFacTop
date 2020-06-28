package me.gabriel.gfactop.inventory.utils;

import org.bukkit.inventory.*;
import org.bukkit.*;
import java.util.*;
import com.mojang.authlib.*;
import org.apache.commons.codec.binary.Base64;

import com.mojang.authlib.properties.*;
import org.bukkit.inventory.meta.*;
import java.lang.reflect.*;

public class Heads
{
    public static ItemStack VERDE_KDR;
    public static ItemStack VERDE_COINS;
    public static ItemStack VERDE_POWER;
    public static ItemStack VERDE_GERADORES;
    public static ItemStack CINZA_KDR;
    public static ItemStack CINZA_COINS;
    public static ItemStack CINZA_POWER;
    public static ItemStack CINZA_GERADORES;
    public static ItemStack ARROW;
    
    public Heads() {
        final ItemStack VERDE = getSkull("http://textures.minecraft.net/texture/361e5b333c2a3868bb6a58b6674a2639323815738e77e053977419af3f77");
        final ItemStack CINZA = getSkull("http://textures.minecraft.net/texture/f2f085c6b3cb228e5ba81df562c4786762f3c257127e9725c77b7fd301d37");
        Heads.VERDE_KDR = new ItemBuilder(VERDE.clone()).setName("§eOrdenar por KDR").setLore("§7Clique para ordenar de acordo", "§7com o KDR de cada Fac\u00e7\u00e3o.").toItemStack();
        Heads.VERDE_COINS = new ItemBuilder(VERDE.clone()).setName("§eOrdenar por Coins").setLore("§7Clique para ordenar de acordo", "§7com os Coins de cada Fac\u00e7\u00e3o.").toItemStack();
        Heads.VERDE_POWER = new ItemBuilder(VERDE.clone()).setName("§eOrdenar por Poder").setLore("§7Clique para ordenar de acordo", "§7com o Poder de cada Fac\u00e7\u00e3o.").toItemStack();
        Heads.VERDE_GERADORES = new ItemBuilder(VERDE.clone()).setName("§eOrdenar por Geradores").setLore("§7Clique para ordenar de acordo", "§7com o n\u00famero de Geradores de cada Fac\u00e7\u00e3o.").toItemStack();
        Heads.CINZA_KDR = new ItemBuilder(CINZA.clone()).setName("§eOrdenar por KDR").setLore("§7Clique para ordenar de acordo", "§7com o KDR de cada Fac\u00e7\u00e3o.").toItemStack();
        Heads.CINZA_COINS = new ItemBuilder(CINZA.clone()).setName("§eOrdenar por Coins").setLore("§7Clique para ordenar de acordo", "§7com os Coins de cada Fac\u00e7\u00e3o.").toItemStack();
        Heads.CINZA_POWER = new ItemBuilder(CINZA.clone()).setName("§eOrdenar por Poder").setLore("§7Clique para ordenar de acordo", "§7com o Poder de cada Fac\u00e7\u00e3o.").toItemStack();
        Heads.CINZA_GERADORES = new ItemBuilder(CINZA.clone()).setName("§eOrdenar por Geradores").setLore("§7Clique para ordenar de acordo", "§7com o n\u00famero de Geradores de cada Fac\u00e7\u00e3o.").toItemStack();
        Heads.ARROW = new ItemBuilder(Material.ARROW).setName("§aVoltar").toItemStack();
    }
    
    private static ItemStack getSkull(final String url) {
        final ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        final SkullMeta skullMeta = (SkullMeta)skull.getItemMeta();
        final GameProfile profile = new GameProfile(UUID.randomUUID(), (String)null);
        final byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        try {
            final Field profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, profile);
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
        skull.setItemMeta((ItemMeta)skullMeta);
        return skull;
    }
}
