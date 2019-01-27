package fr.WalexFelwin.OktaliaAuthLogin.MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.Bukkit;

public class Mysql {

	  public static Connection conn;
	    public static String host;
	    public static String database;
	    public static String username;
	    public static String password;
	    public static int port;
		public static int clock;
		
		  public static boolean isConnected() {
				try{
					if((conn == null) || (conn.isClosed()) || (conn.isValid(5))) {
						return false;
					}
					return true;
				}catch (SQLException e) {
					System.err.println("isConnected class Database erronee");
				}
				return false;
			}
		  public static void clock()
		  {
			    clock = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("LuminacyAPI"), new Runnable()
			    {
			      public void run()
			      {
			          	try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			          	conn = openConnection();
			        }
			      
			    }, 20*60*30, 20*60*30);
		  }
	    
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
	      Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
	      System.out.println("Luminacy est bien connectée a la base de donn§es");
	   
	      return conn;
	    }
	    catch (SQLException e)
	    {


		      System.out.println("Luminacy n'est pas bien connectée a la base de données");
		      System.out.println("----------------------------------------------------");
		      System.out.println("     Fermetture du BungeeCord MySQL déconnecté");
		      System.out.println("----------------------------------------------------");
		      System.err.println(e);
	      e.printStackTrace();

	    }
	    return null;
	  }
	    
}
