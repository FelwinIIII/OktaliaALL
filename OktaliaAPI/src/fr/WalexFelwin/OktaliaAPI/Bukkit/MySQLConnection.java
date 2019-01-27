package fr.WalexFelwin.OktaliaAPI.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;


public class MySQLConnection {

	
	  public static Connection openConnection()
	  {
	    try
	    {
	      Class.forName("com.mysql.jdbc.Driver");
	    }
	    catch (ClassNotFoundException e1)
	    {
	      System.err.println(e1);
	      e1.printStackTrace();
	    }
	    try
	    {
	      Connection conn = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.port + "/" + Main.database, Main.user, Main.pass);
	      System.out.println(org.bukkit.ChatColor.GREEN+"OktaliaAPI est bien connectée a la base de données");
	      return conn;
	    }
	    catch (SQLException e)
	    {
	      System.out.println(org.bukkit.ChatColor.RED+"OktaliaAPI n'est pas bien connectée a la base de données");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	    return null;
	  }

		public static int clock;
		
		
		  public static void clock()
		  {
		    clock = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), new Runnable()
		    {
		      public void run()
		      {
		    	  try {
						Main.conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	        Main.conn = openConnection();	
		    	        
		      }
		    }, 1*60*60*20, 1*60*60*20);
		  }
		  
}
