package fr.walexmine.OktaliaMine.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.walexmine.OktaliaMine.API.API_Inventory;

public class Reserve implements CommandExecutor{
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if (label.equalsIgnoreCase("Reserve"))
	    {
	    		//Reserve
	    	if (args.length == 0) {
	    		

	    	if(p.getWorld().getName().equalsIgnoreCase("world")) {
	    		
	    	fr.walexmine.OktaliaMine.Inventaire.Reserve.RESERVE(p);
	    		
	    	}
	    	if(p.getWorld().getName().equalsIgnoreCase("minage")) {
	    		
	    	fr.walexmine.OktaliaMine.Inventaire.Reserve.RESERVEMINAGE(p);
	    		
	    	}
	    	}
	    	if(p.isOp()) {
	    		
	    		
		    	if (args.length == 1) {
		    		
    	    	    if(args[0].equalsIgnoreCase("debug"))
    	    	    {
    	    	    	p.sendMessage(""+fr.walexmine.OktaliaMine.Inventaire.Reserve.ReserveMine.get(p));
    	    	    } else {
		    		p.sendMessage("§c /reserve reset <player>");
    	    	    }
		    	}	    	
		    	
		    	if (args.length == 2) {
		    		
		    	    	    if(args[0].equalsIgnoreCase("reset")){
		    	    	    	

		    		    		Player p2 = Bukkit.getPlayer(args[1]);
		    		    		
		    	    	    	API_Inventory.resetreserveminage(p2);
		    	    	    	
		    	    	    	p.sendMessage("§cLa réserve du joueur §e"+p2.getName()+" §ca été reset §7!");
		    	    	    }
		    	}
	    	
	    	
	    	}
	    }
	    
	    return true;
	  }

}
