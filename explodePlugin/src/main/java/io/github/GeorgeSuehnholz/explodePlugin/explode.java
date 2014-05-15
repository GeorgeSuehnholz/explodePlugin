package io.github.GeorgeSuehnholz.explodePlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class explode extends JavaPlugin{

	@Override
	public void onEnable()
	{
		getLogger().info("onEnable has been invoked!");
		
	}
	
	@Override
	public void onDisable()
	{
		getLogger().info("onDisable has been invoked!");
	}
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("explode")) { 
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
			} 
			else {
					
				if (args.length==0) //If a player typed /explode with no arguments it explodes the player
				{
				Player player = (Player) sender;
				player.getWorld().createExplosion(player.getLocation(), 4F);	
				
				}
				else
				{
				Player target = sender.getServer().getPlayer(args[0]);	
				if (target==null)
				{
				sender.sendMessage("Player " + args[0] + " is not online."); //Offline Players Can't Explode :D
				}
				else
				{
				target.getWorld().createExplosion(target.getLocation(), 4f);
				}
				
				}
				
				
			}
			return true;
		} 
		return false;
	}
}
