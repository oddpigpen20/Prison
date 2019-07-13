package me.oddpigpen20.prison.files;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.InputStreamReader;

import me.oddpigpen20.prison.Main;

public class Messages {
	
	private File file = null;
	private FileConfiguration message = null;
	
	private Main plugin;
	
	public Messages(Main instance) {
		plugin = instance;
	}
	
	public FileConfiguration getfileconfiguration() {
		if (message == null) {
			reloadFile();
		}
		
		return message;
		
	}
	public void initCustomMessage() {
		if(file == null) {
			reloadFile();
		}
		
		if(file != null) {
		this.getfileconfiguration().addDefault("Prefix", "&5[Prison by piggy]");
		this.getfileconfiguration().addDefault("Help-Message", "/prison - help menu for prison!");
		this.getfileconfiguration().addDefault("HelpAdmin", "Admin Help menu");
		this.getfileconfiguration().addDefault("SmelterPick", "You just recived the Smelter Pick");
		
		this.getfileconfiguration().options().copyDefaults(true);
		this.saveDefaultConfig();
		this.saveFile();

		}
	}
	
	public void saveFile() {
		if(message == null || file == null) {
			return;
		}
		try {
			getfileconfiguration().save(file);
		}catch (IOException e) {
			plugin.getLogger().log(Level.SEVERE, "Could not save " + file.getName() + " to " + message, e);
		}
	}
	public void addDefault(String path , String message) {
		getfileconfiguration().options().copyDefaults(true);
		getfileconfiguration().addDefault(path, message);
		
		try {
			getfileconfiguration().save(file);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void reloadFile() {
		if(file == null) {
			file = new File(plugin.getDataFolder() , "messages.yml");
		}
		message = YamlConfiguration.loadConfiguration(file);
	
	}
	
	public void saveDefaultConfig() {
		if(file == null) {
			file = new File(plugin.getDataFolder() , "messages.yml");
		}
		if(!file.exists()) {
			this.plugin.saveResource("messages.yml", false);
		}
		
	}
	public String getString(String s) {
		return this.getfileconfiguration().getString(s);
	}
}
	


