package fr.walexmine.OktaliaQuete.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;

import fr.walexmine.OktaliaQuete.Main;

public class MySQL {
	
	
	public static int clock;
	
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
	      System.out.println(ChatColor.GREEN+"OktaliaQuete est bien connectée a la base de données");
	      return conn;
	    }
	    catch (SQLException e)
	    {
	      System.out.println(ChatColor.RED+"OktaliaQuete n'est pas bien connectée a la base de données");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	    return null;
	  }
	  
	  
	  public static void clock()
	  {
	    clock = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("OktaliaQuete"), new Runnable()
	    {
	      public void run()
	      {
	        Main.conn = MySQL.openConnection();
	      	Update.Update(null);
	      	Update.Query(null);
	      }
	    }, 60000L, 60000L);
	  }
	  
}
