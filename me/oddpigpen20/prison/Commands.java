package me.oddpigpen20.prison;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import me.oddpigpen20.prison.files.Messages;
import net.md_5.bungee.api.ChatColor;


public class Commands implements CommandExecutor{
	

	
	private Messages msg;
	
	
	
	
	
	private static Main plugin;
	public Commands(Main instance) {
		plugin = instance;
	}
	
	//public String Prefix = msg.getfileconfiguration().getString("Prefix");
	//public String Help = msg.getfileconfiguration().getString("Help");	
	//public String Admin = msg.getfileconfiguration().getString("HelpAdmin");
	//public String Pick = msg.getfileconfiguration().getString("Pick");
	
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		//ADD if(p.getWorld().getName() == plugin.getConfig().getString("World"))  { back
		if(cmd.getLabel().equalsIgnoreCase("Prison")) {
			if(args.length == 0) {
			if(sender instanceof Player) {
					p.sendMessage(msg.getString("Prefix").replace("&", "§") + " "
			+ msg.getString("Help").replace("&", "§"));
			}
		}
			if(cmd.getLabel().equalsIgnoreCase("PrisonPick")) {
				if(args.length == 0) {
				if (sender instanceof Player) {
				if(p.hasPermission("Prison.pick")) {
					p.getInventory().addItem(plugin.PrisonPic());
					p.sendMessage(msg.getString("Prefix").replace("&", "§") + " " + msg.getString("SmelterPick").replace("&", "§"));
				}
			}else {
				sender.sendMessage("Only Players can do that console dweler");
			}
		}
			if (args.length > 0 ) {
				p.sendMessage(ChatColor.GOLD + "Test to see if it returns with message");
			}
		}
			
	
				
			
		}
		if(cmd.getLabel().equals("PrisonAdmin")) {
			if(p.hasPermission("prison.admin.general")) {
				p.sendMessage(msg.getString("Prefix").replace("&", "§") + " " + msg.getString("HelpAdmin").replace("&", "§"));
			}
		
	}

		
		
		
		
		return true;
	}

}
