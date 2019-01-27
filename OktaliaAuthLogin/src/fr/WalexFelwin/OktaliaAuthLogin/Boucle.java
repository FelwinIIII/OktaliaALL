package fr.WalexFelwin.OktaliaAuthLogin;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAuthLogin.MySql.Mysql;

public class Boucle {


	  private static int clock2;
	  private static int clockup;

	  public static void clock()
	  {
	    clock2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("OktaliaLogin"), new Runnable()
	    {
	      public void run()
	      {	
	    	  
	    	  for (Player p : Bukkit.getOnlinePlayers())
	    	    {
	    	  if(Listener.Login.containsKey(p)){
	    		long gettime = Listener.Login.get(p);
	    		long getservertime = System.currentTimeMillis();
	    		
	    		if(gettime < getservertime){
	    			
	    			Listener.Login.remove(p.getName());
	    			p.kickPlayer("§cVous avez pris trop de temps a vous login\n \n §c");
	    	
	    		}
	    	  } else {
	    		 return;
	    	  }
	        }
	      }
	    }, 20, 20);
	  }
	  public static void clockup()
	  {
		  clockup = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("OktaliaLogin"), new Runnable()
	    {
	      public void run()
	      {	
	    	  try {
	    		  Mysql.conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	  		Mysql.conn = Mysql.openConnection();	
	    	        
	        
	      }
	    }, 6000L, 6000L);
	  }
}
