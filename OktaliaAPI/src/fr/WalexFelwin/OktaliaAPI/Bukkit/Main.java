package fr.WalexFelwin.OktaliaAPI.Bukkit;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.Ping;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.PingAPI;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerInfo;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Commands.Coins;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Commands.Grades;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Commands.Lag;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Event.PlayerJoin;
import fr.WalexFelwin.OktaliaAPI.Bukkit.TableSQL.InfoGrades;
import fr.WalexFelwin.OktaliaAPI.Bukkit.TableSQL.InfoOktaCoins;

public class Main  extends JavaPlugin implements Listener, PluginMessageListener{
	
	
	  private FileConfiguration config = getConfig();
	  public static Connection conn;
	  public static String host;
	  public static int port;
	  public static String user;
	  public static String pass;
	  public static String database;
	  public static boolean COINSLOAD;
	  public static boolean Update;
	  
	private static Main instance;
	private List<ServerInfo> servers = new ArrayList<ServerInfo>();
	private Ping ping;
	private PingAPI pingapi;
	

	public void onEnable() {
		
	    this.config.addDefault("host", "localhost");
	    this.config.addDefault("port", Integer.valueOf(3306));
	    this.config.addDefault("user", "walexmine");
	    this.config.addDefault("pass", "V37bKGhxtzRGbyot");
	    this.config.addDefault("database", "Falcon9");
	    this.config.addDefault("COINSLOAD", true);
	    this.config.addDefault("Update", false);
	    host = "localhost";
	    port = this.config.getInt("port");
	    user = this.config.getString("user");
	    pass = this.config.getString("pass");
	    database = this.config.getString("database");
	    COINSLOAD = this.config.getBoolean("COINSLOAD");
	    Update = this.config.getBoolean("Update");
	    conn = MySQLConnection.openConnection();
	    
	    this.config.options().copyDefaults(true);
	    
	    saveConfig();
	    
	    this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeInterconnect", new fr.WalexFelwin.OktaliaAPI.Bukkit.PluginMessageListener());
	    this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeInterconnect");

		instance = this;
		ping = new Ping(this);
		pingapi = new PingAPI();
	    this.getCommand("lag").setExecutor(new Lag());
	    this.getCommand("grades").setExecutor(new Grades());
	    this.getCommand("coins").setExecutor(new Coins());
	    MySQLConnection.clock();
	    System.out.println("");
	    System.out.println(ChatColor.GOLD+"Oktalia API Bukkit Start");
	    System.out.println("");
	    System.out.println(ChatColor.BLUE+"Configuration:");
	    if(COINSLOAD == false) {
		    System.out.println(ChatColor.RED+"COINS Désactivée !");
	    } else {
		    System.out.println(ChatColor.GREEN+"COINS Activée !");
	    }
	    System.out.println("");
	    System.out.println(ChatColor.GREEN+"Version: "+instance.getDescription().getVersion());
	    
	    /*if(Update){
	    new Updateur().runTaskTimerAsynchronously(this, 0L, 600*4);
	    }*/
	    InfoGrades.createTable();
	    InfoOktaCoins.createTable();
	    registerEvents();
	    ServeurHubRegister.RegisterServeur();


	}
	
	@Override
	public void onLoad() {
	}



	public void onDisable() {
		/*for (Player o : Bukkit.getOnlinePlayers()) {
			API_Redirect.HubSelect(o);
		}

	    System.out.println("");
	    System.out.println("Mise à jour du systéme !");
	    System.out.println("");
		API_Update.update("http://62.210.168.253/plugin/download/HezonNetWorkAPI.jar", "HezonNetWorkAPI.jar");*/

	}

	  public void registerEvents(){
		    PluginManager pm = getServer().getPluginManager();
		    getServer().getPluginManager().registerEvents(this, this);
		    pm.registerEvents(new PlayerJoin(this), this);

	  }

	@Override
	public void onPluginMessageReceived(String arg0, Player arg1, byte[] arg2) {
		// TODO Auto-generated method stub
		System.out.println("test44");
		
	}

	/**
	 * Returns the API, to use the PingAPI.
	 */
	public PingAPI getPingAPI(){
		return pingapi;
	}
	
	public Ping getPinger(){
		return ping;
	}

	public static Main getInstance(){
		return instance;
	}

	/**
	 * Returns a list of all registered servers.
	 */
	public List<ServerInfo> getServers() {
		return servers;
	}
	
	public void callSyncEvent(final Event event){
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
			@Override
			public void run(){
				getServer().getPluginManager().callEvent(event);
			}
		});
	}
}
