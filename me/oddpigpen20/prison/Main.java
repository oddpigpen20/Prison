package me.oddpigpen20.prison;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import me.oddpigpen20.prison.files.Messages;
import me.oddpigpen20.prison.special.Enchants;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{
	
	public Enchants ench = new Enchants(169);
	private static Main plugin;
	public static Messages messages;
	@Override
	public void onEnable() {
	if(!this.getDataFolder().exists()) {
		
	}
		
	loadEnchant();
	reloadConfig();
	getConfig().addDefault("Worlds", "");
		
	}
	
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	public void onDisable() {
		try {
			Field byIdFeild = Enchantment.class.getDeclaredField("byId");
			Field byNameFeild = Enchantment.class.getDeclaredField("byName");
			byIdFeild.setAccessible(true);
			byNameFeild.setAccessible(true);
			
			HashMap<Integer, Enchantment> byId = (HashMap<Integer , Enchantment>) byIdFeild.get(null);
			HashMap<Integer, Enchantment> byName = (HashMap<Integer , Enchantment>) byIdFeild.get(null);
			
			if(byId.containsKey(ench.getID())) {
				byId.remove(ench.getID());
				
			}
			
			if(byName.containsKey(ench.getName())) {
				byName.remove(ench.getName());
			}
		}catch(Exception ignored) {
			
		}
	}
	
	
	private void loadEnchant() {
		try {
			try {
				Field f = Enchantment.class.getDeclaredField("acceptingNew");
				f.setAccessible(false);
				f.set(null, true);
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
			Enchantment.registerEnchantment(ench);
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static Main getInstance() {
		return plugin;
	}
	
	public ItemStack PrisonPic() {
		ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + ench.getName());
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		item.addUnsafeEnchantment(ench, 1);
		return item;
	
	}
	
	
	
	public void utils() {
		if(!messages.getfile().exists()) {
		messages = new Messages();
		messages.create();	
		messages.addDefault("Prefix", "&5[Prison by piggy]");
		messages.addDefault("Help-Message", "/prison - help menu for prison!");
		messages.addDefault("HelpAdmin", "Admin Help menu");
		messages.addDefault("SmelterPick", "You just recived the Smelter Pick");
		}else return;
	}

}
