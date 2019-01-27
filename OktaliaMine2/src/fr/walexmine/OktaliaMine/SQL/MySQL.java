package fr.walexmine.OktaliaMine.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;

import fr.walexmine.OktaliaMine.Main;


public class MySQL {
	
	
	public static int clock;
	private String host = "";
	private Integer port = Integer.valueOf(3306);
	private String database = "";
	private String user = "";
	private String pass = "";
	
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
	      System.out.println(ChatColor.GREEN+"OktaliaMine est bien connect�e a la base de donn�es");
	      return conn;
	    }
	    catch (SQLException e)
	    {
	      System.out.println(ChatColor.RED+"OktaliaMine n'est pas bien connect�e a la base de donn�es");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	    return null;
	  }
	  
	  
	  public static void clock()
	  {
	    clock = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("OktaliaMine"), new Runnable()
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
