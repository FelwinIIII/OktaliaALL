package fr.walexmine.OktaliaMine.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Mine implements CommandExecutor{
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if (label.equalsIgnoreCase("minage"))
	    {
	    		//TP MINAGE
	    	
		    	  Location l = new Location(Bukkit.getWorld("minage"), 0, 60, 0);

				  p.sendMessage("");
				  p.sendMessage("");
				  p.sendMessage("§7[§bOktalia§7] §aTéléportation dans le monde §eMinage §c!");
				  p.sendMessage("");
				  p.sendMessage("§aLe monde minage a pour but de pouvoir miner en toute tranquillité §c!");
				  p.sendMessage("§aPour accéder a tout ce que vous miner faites §c/reserve");
				  p.sendMessage("§eVous pouvez transférer votre réserve du monde minage au monde factions.");
				  p.sendMessage("");
		    	  p.teleport(l);
		    	  
		    	  
	    }
	    
	    return true;
	  }

}
