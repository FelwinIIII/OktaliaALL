package fr.WalexFelwin.OktaliaAPI.BungeeCord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.CrashPinger.ReconnectOnCrash;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

public class Main extends Plugin implements Listener{

    public static Main instance;
    private static Configuration config;
	  public static Connection conn;
    static String host;
	static String database;
    static String username;
    static String password;
    static int port;
    public static Logger log;
    
	@Override
	public void onDisable() {
		
	}

	@Override
	public void onEnable() {
		log = getLogger();
		
		
		  log.info(ChatColor.GRAY+"-------------------------");
		  log.info(ChatColor.YELLOW+"BungeeCoord API");
		  log.info(ChatColor.YELLOW+" Version : 1.0");
		  log.info(ChatColor.YELLOW+"Plugin Start");
		  log.info(ChatColor.GRAY+"===============================");
		  
		  
	    host = "localhost";
	    port = 3306;
	    database = "Falcon9";
	    username = "walexmine";
	    password = "V37bKGhxtzRGbyot";
	    conn = openConnection();
	    
	   // MySQL.clock();
	    

		BungeeCord.getInstance().getPluginManager().registerCommand(this, new fr.WalexFelwin.OktaliaAPI.BungeeCord.CMD.Server.Update());
		
	    
	    BungeeCord.getInstance().getPluginManager().registerListener(this, new ReconnectOnCrash());

	    getProxy().registerChannel("BungeeInterconnect");
	    BungeeCord.getInstance().getPluginManager().registerListener(this, new PluginMessage());
	    
	    MySQL.clock();
		registercommands();
		registerevent();
		
	}
	  @Override
	public ProxyServer getProxy() {
		// TODO Auto-generated method stub
		return super.getProxy();
	}

	@Override
	public void onLoad() {
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

		  log.info(ChatColor.YELLOW+"L'API BungeeCord est bien connectée a la base de données !");
	      return conn;
	    }
	    catch (SQLException e)
	    {

			for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
				all.disconnect("\n§cLes serveurs on rencontré des problémes\n§cPlus d'information :§e https://twitter.com/");
			}
		      System.out.println(ChatColor.RED+"L'API BungeeCord n'est pas bien connectée a la base de données");
		      System.out.println(ChatColor.RED+"----------------------------------------------------");
		      System.out.println(ChatColor.RED+"     Fermetture du BungeeCord MySQL déconnecté");
		      System.out.println(ChatColor.RED+"----------------------------------------------------");
		      System.err.println(e);
	      e.printStackTrace();

	    }
	    return null;
	  }
	
	public void registercommands(){

		//BungeeCord.getInstance().getPluginManager().registerCommand(this, new Friends());
	}


	public void registerevent(){
		
		//BungeeCord.getInstance().getPluginManager().registerListener(this, new PlayerJoin());
		
	}
	
	
	
	
}
