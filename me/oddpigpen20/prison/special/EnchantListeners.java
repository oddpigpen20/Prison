package me.oddpigpen20.prison.special;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.oddpigpen20.prison.Main;

public class EnchantListeners implements Listener{
	
	private Main plugin;
	
	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	public void onClick(PlayerItemBreakEvent e) {
		Player p = e.getPlayer();
		ItemStack b = e.getBrokenItem();
		
		if(p.getInventory().contains(plugin.PrisonPic())) {
			if(b.equals(Material.IRON_ORE)) {
				
				
				
			}
		}
	}
}
