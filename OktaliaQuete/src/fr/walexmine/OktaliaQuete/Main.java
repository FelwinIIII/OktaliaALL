package fr.walexmine.OktaliaQuete;

import java.sql.Connection;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.walexmine.OktaliaQuete.Commands.QueteCmd;
import fr.walexmine.OktaliaQuete.Event.PlayerBreak;
import fr.walexmine.OktaliaQuete.Inventaire.Interact.InteractQuete;
import fr.walexmine.OktaliaQuete.SQL.MySQL;


public class Main extends JavaPlugin implements Listener{

	  private FileConfiguration config = getConfig();
	  
	public static Connection conn;
	public static String host;
	public static int port;
	public static String user;
	public static String pass;
	public static String database;


	@Override
	public void onEnable() {

	    this.config.addDefault("MySQL.host", "178.32.113.35");
	    this.config.addDefault("MySQL.port", Integer.valueOf(3306));
	    this.config.addDefault("MySQL.user", "minesr_10629");
	    this.config.addDefault("MySQL.pass", "MMqLH9Wi");
	    this.config.addDefault("MySQL.database", "minesr_10629");
	    
	    
	    host = this.config.getString("MySQL.host");
	    port = this.config.getInt("MySQL.port");
	    user = this.config.getString("MySQL.user");
	    pass = this.config.getString("MySQL.pass");
	    database = this.config.getString("MySQL.database");
	    
	    
	    conn = MySQL.openConnection();
	    this.config.options().copyDefaults(true);
	    saveConfig();
	    MySQL.clock();
	    
	    registerEvents();
	    registerCommands();
		
	}
	
	
	
	
	@Override
	public void onDisable() {

		
		
	}

	
	
	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		super.onLoad();
	}

	
	
	  
	  public void registerEvents(){
		    PluginManager pm = getServer().getPluginManager();
		    getServer().getPluginManager().registerEvents(this, this);

			  pm.registerEvents(new InteractQuete(this), this);
			  pm.registerEvents(new PlayerBreak(this), this);
	  }

	  public void registerCommands(){

		  this.getCommand("quete").setExecutor(new QueteCmd());
		  
	  }
}
