package fr.WalexFelwin.OktaliaAPI.BungeeCord;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;


public class MySQL {

	
	public int clock;
	
	  public static void clock()
	  {

	        BungeeCord.getInstance().getScheduler().schedule(BungeeCord.getInstance().getPluginManager().getPlugin("OktaliaAPI"), new Runnable() {
	            @Override
	            public void run() {
	     

	            		try {
							Main.conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    	        Main.conn = Main.openConnection();	
		    	        
	
	            }
	        }, 30, 30, TimeUnit.MINUTES);

	  }
	  public static boolean isConnected() {
			try{
				if((Main.conn == null) || (Main.conn.isClosed()) || (Main.conn.isValid(5))) {
					return false;
				}
				return true;
			}catch (SQLException e) {
				System.err.println("isConnected class Database erronee");
			}
			return false;
		}
		
		public int gradesachat;
		
		  public static void gradesachat()
		  {

		        BungeeCord.getInstance().getScheduler().schedule(BungeeCord.getInstance().getPluginManager().getPlugin("OktaliaAPI"), new Runnable() {
		            @Override
		            public void run() {
		            	//BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "buycraft forcecheck");
		            }
		        }, 30, 30, TimeUnit.SECONDS);

		  }
}
