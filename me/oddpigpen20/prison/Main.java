package me.oddpigpen20.prison;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import me.oddpigpen20.prison.Economy.Economys;
import me.oddpigpen20.prison.Economy.VaultHook;
import me.oddpigpen20.prison.files.Messages;
import me.oddpigpen20.prison.special.Enchants;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{
	
	public Messages msg;
	public HashMap<UUID, Double> playerBank = new HashMap<>();
	private VaultHook vaultHook;
	public Commands commands;
	public Enchants ench = new Enchants(169);
	public static Main plugin;
	public Economys econs;
	@Override
	public void onEnable() {
	
		//on start run these two voids
		runEnable();
	
		
		//Check when enabled only needed once
	if(!this.getDataFolder().exists()) {
		getDataFolder().mkdir();
	}
		
	loadEnchant();
	
	
	
	
	
getConfig().options().copyDefaults(true);
	
	
	reloadConfig();
	getConfig().addDefault("Worlds", "");
	
	}

	private void instanceClasses() {
		plugin = this;
		econs = new Economys();
		vaultHook = new VaultHook();
	}
	
	public void runEnable() {
		instanceClasses();
		vaultHook.hook();
		this.getCommand("Prison").setExecutor(new Commands(this));
		this.getCommand("PrisonPick").setExecutor(new Commands(this));
		this.getCommand("PrisonAdmin").setExecutor(new Commands(this));
		
		//Messages initalization
		msg = new Messages(this);
		
		msg.initCustomMessage();
		msg.getfileconfiguration();
		msg.saveDefaultConfig();
		
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
}

