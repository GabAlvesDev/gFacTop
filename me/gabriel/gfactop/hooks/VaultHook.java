package me.gabriel.gfactop.hooks;

import net.milkbowl.vault.economy.*;
import com.massivecraft.factions.entity.*;
import com.massivecraft.massivecore.money.*;

public class VaultHook
{
    private static Economy ECONOMY;
    
    @SuppressWarnings("deprecation")
	public static double getSaldo(final MPlayer mp) {
        try {
            return VaultHook.ECONOMY.getBalance(mp.getName());
        }
        catch (Throwable e) {
            return 0.0;
        }
    }
    
    public VaultHook() {
        VaultHook.ECONOMY = MoneyMixinVault.get().getEconomy();
    }
}
