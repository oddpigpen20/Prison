package me.oddpigpen20.prison;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import me.oddpigpen20.prison.files.Messages;


public class Commands implements CommandExecutor{
	
	
	private Messages messages;
	
	private static Main plugin;
	public Commands(Main instance) {
		plugin = instance;
	}
	
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		String Prefix = messages.getfileconfiguration().getString("Prefix");
		String Help = messages.getfileconfiguration().getString("Help");	
		String Admin = messages.getfileconfiguration().getString("HelpAdmin");
		String Pick = messages.getfileconfiguration().getString("Pick");
		
		if(p.getWorld().getName() == plugin.getConfig().getString("World"))  {
		if(cmd.getLabel().equalsIgnoreCase("Prison")) {
			if(args.length == 0) {
			if(sender instanceof Player) {
					p.sendMessage(Prefix.replace("&", "§") + " " 
				+ Help.replace("&", "§"));
				
			}
			if(cmd.getLabel().equalsIgnoreCase("PrisonPick")) {
				if(p.hasPermission("Prison.pick")) {
					p.getInventory().addItem(plugin.PrisonPic());
					p.sendMessage(Prefix.replace("&", "§") + " " + Pick.replace("&", "§") );
				}
			}
			
	
				
			}
		}
		if(cmd.getLabel().equals("PrisonAdmin")) {
			if(p.hasPermission("prison.admin.general")) {
				p.sendMessage(Prefix.replace("&", "§") + " " + Admin.replace("&", "§"));
			}
		
	}
}else return true;

		
		
		
		
		return true;
	}

}
