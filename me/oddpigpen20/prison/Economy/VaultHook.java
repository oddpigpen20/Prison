package me.oddpigpen20.prison.Economy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;

import me.oddpigpen20.prison.Main;
import net.milkbowl.vault.economy.Economy;

public class VaultHook {

	private Main plugin = Main.getInstance();
	private Economy provider;
	
	
	public void hook() {
		provider = plugin.econs;
		
		Bukkit.getServicesManager().register(Economy.class, this.provider, this.plugin, ServicePriority.Normal);
		
	}
	
}
