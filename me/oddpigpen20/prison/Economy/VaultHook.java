package me.oddpigpen20.prison.Economy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;

import me.oddpigpen20.prison.Main;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;

public class VaultHook {

	private Main plugin = Main.getInstance();
	private Economy provider;
	
	
	public void hook() {
		provider = plugin.econs;
		
		Bukkit.getServicesManager().register(Economy.class, this.provider, this.plugin, ServicePriority.Normal);
		Bukkit.getConsoleSender().sendMessage("Vault API Hooked into " + ChatColor.GOLD + plugin.getName());
		
	}
	public void unhook() {
		Bukkit.getServicesManager().unregister(Economy.class, this.provider);
	}
	
}
