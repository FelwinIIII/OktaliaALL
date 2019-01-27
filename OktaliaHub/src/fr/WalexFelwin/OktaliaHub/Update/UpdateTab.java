package fr.WalexFelwin.OktaliaHub.Update;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Tab;


public class UpdateTab {

	public static String tabhaut = 
			"§f§m-----§7§m-------§8§m--------§7§m-------§f§m-----"
	    		
	        + "\n§u§l§oOKTALIA NETWORK"
	    	+ "\n";
	
	public static String tabbas = 
			"\n"
	    	+ "§6/discord§6,§e https://oktalia.fr"
	    			  
	        + "\n§f§m-----§7§m-------§8§m--------§7§m-------§f§m-----";
	
	private static int clock2;

	  public static void clock()
	  {
	    clock2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("OktaliaHub"), new Runnable()
	    {
	      public void run()
	      {	
	    	  
	    	  for (final Player p : Bukkit.getOnlinePlayers())
	    	    {

	          	    API_Tab.setPlayerList(p, tabhaut.replace("§u§l§oOKTALIA NETWORK", "§6§lOKTALIA §f§lNETWORK"), tabbas);
	          	    
	    		    	
	      			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaHub"), new Runnable() {
	    	              public void run() {

	    		          	    API_Tab.setPlayerList(p, tabhaut.replace("§u§l§oOKTALIA NETWORK", "§f§lOKTALIA §6§lNETWORK"), tabbas);
	    	              }
	    	      }, 10);
	      		
	    	    }
	      }
	    }, 20, 20);
	  }
}
