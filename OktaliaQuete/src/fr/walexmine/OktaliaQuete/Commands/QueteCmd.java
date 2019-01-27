package fr.walexmine.OktaliaQuete.Commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.walexmine.OktaliaQuete.Inventaire.Quete;


public class QueteCmd implements CommandExecutor{
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if (label.equalsIgnoreCase("quete"))
	    {
	    		
	    	Quete.openQuete(p);
	    
	    }
	    return true;
	  }

}
