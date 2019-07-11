package me.oddpigpen20.prison.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.oddpigpen20.prison.Main;

public class Messages {
	
	private File file;
	private FileConfiguration fileconfiguration;
	
	public File getfile() {
		return this.getfile();
	}
	public FileConfiguration getfileconfiguration() {
		return this.getfileconfiguration();
	}
	public void create() {
		this.file = new File(Main.getInstance().getDataFolder(), "messages.yml");
		if(!this.file.exists()) {
			try {
				this.file.createNewFile();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.fileconfiguration = YamlConfiguration.loadConfiguration(getfile());
		
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
public void  get(String msg) {
	getfileconfiguration().get(msg);
}

}
	


