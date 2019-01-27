package fr.walexmine.OktaliaMine.API;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class API_Temps {
	  

	  public static HashMap<Player, String> TIMECO = new HashMap();
	  public static HashMap<Player, String> TIME = new HashMap();
	
	  public static String getRemainingTime(Player p)
	  {

			long timeco = Long.parseLong(API_Temps.TIMECO.get(p));
			long timenow = System.currentTimeMillis();
			
			long timesession = timenow - timeco;
			
			long newtimeBDD = timesession+Long.parseLong(API_Temps.TIME.get(p));
		  
		  
		  
		  
		  
	    String remainingTime = "";
	      long difference = newtimeBDD;
	      int seconds = 0;
	      int minutes = 0;
	      int hours = 0;
	      int days = 0;
	      int weeks = 0;
	      while (difference >= 1000L)
	      {
	        difference -= 1000L;
	        seconds++;
	      }
	      while (seconds >= 60)
	      {
	        seconds -= 60;
	        minutes++;
	      }
	      while (minutes >= 60)
	      {
	        minutes -= 60;
	        hours++;
	      }
	      while (hours >= 24)
	      {
	        hours -= 24;
	        days++;
	      }
	      while (days >= 7)
	      {
	        days -= 7;
	        weeks++;
	      }
	      remainingTime = 
	        "§e" + days + " Jour(s), " + hours + " heure(s), " + minutes + " minutes(s) et " + seconds + " secondes.";
	    
	      if(days == 0) {
	    	  remainingTime = remainingTime.replace("§e" + days +" Jour(s),", "");
	      } if(hours == 0) {
	     	  remainingTime = remainingTime.replace(" " + hours +" heure(s),", "");
	      } if(minutes == 0) {
	     	  remainingTime = remainingTime.replace(" " + minutes +" minutes(s) et", "");
	      }
	    return remainingTime;
	}
	  
}
