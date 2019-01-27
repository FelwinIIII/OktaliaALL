package fr.walexmine.OktaliaMine;

import java.sql.Connection;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.walexmine.OktaliaMine.API.API_Inventory;
import fr.walexmine.OktaliaMine.API.API_Joueur;
import fr.walexmine.OktaliaMine.API.API_Temps;
import fr.walexmine.OktaliaMine.Commands.Inventory;
import fr.walexmine.OktaliaMine.Commands.Mine;
import fr.walexmine.OktaliaMine.Commands.Reserve;
import fr.walexmine.OktaliaMine.Event.Event;
import fr.walexmine.OktaliaMine.Event.PlayerBreak;
import fr.walexmine.OktaliaMine.Event.PlayerChangeWorld;
import fr.walexmine.OktaliaMine.Event.PlayerJoin;
import fr.walexmine.OktaliaMine.Event.PlayerQuitt;
import fr.walexmine.OktaliaMine.Inventaire.Interact.Slots;
import fr.walexmine.OktaliaMine.Inventaire.Interact.TransfertReserve;
import fr.walexmine.OktaliaMine.Inventaire.StatsMine.Stats;
import fr.walexmine.OktaliaMine.SQL.InfoInventory;
import fr.walexmine.OktaliaMine.SQL.InfoJoueur;
import fr.walexmine.OktaliaMine.SQL.MySQL;


public class Main extends JavaPlugin implements Listener{
	
		  private FileConfiguration config = getConfig();
		  
	public static Connection conn;
	public static String host;
	public static int port;
	public static String user;
	public static String pass;
	public static String database;
	
	@Override
	public void onDisable() {
		
	
	    if(Bukkit.getOnlinePlayers().size() == 0){
	    	
	    } else {
	    for (Player p : Bukkit.getOnlinePlayers())
	    {

			API_Inventory.saveReserveMine(p, API_Inventory.toBase64(PlayerBreak.ReserveM.get(p)));
				
			long timeco = Long.parseLong(API_Temps.TIMECO.get(p));
			long timenow = System.currentTimeMillis();
			
			long timesession = timenow - timeco;
			
			API_Joueur.addTIME(p, timesession);


			API_Joueur.SetEXP(p, Stats.EXP.get(p));
			API_Joueur.SetLVL(p, Stats.LEVEL.get(p));
			System.out.println("DATA save player: "+p.getPlayer());
	    }}
	}

	@Override
	public void onEnable() {


	    this.config.addDefault("MySQL.host", "localhost");
	    this.config.addDefault("MySQL.port", Integer.valueOf(3306));
	    this.config.addDefault("MySQL.user", "walexmine");
	    this.config.addDefault("MySQL.pass", "V37bKGhxtzRGbyot");
	    this.config.addDefault("MySQL.database", "Falcon9");
		    
		    
		    host = this.config.getString("MySQL.host");
		    port = this.config.getInt("MySQL.port");
		    user = this.config.getString("MySQL.user");
		    pass = this.config.getString("MySQL.pass");
		    database = this.config.getString("MySQL.database");
		    
		    
		    conn = MySQL.openConnection();
		    this.config.options().copyDefaults(true);
		    saveConfig();
		    
		    
		    InfoJoueur.createTable();
		    InfoInventory.createTable();
		    MySQL.clock();
		    
		    
		    registerEvents();
		    registerCommands();
		    
	}
	  
	  public void registerEvents(){
		    PluginManager pm = getServer().getPluginManager();
		    getServer().getPluginManager().registerEvents(this, this);

		    pm.registerEvents(new PlayerJoin(this), this);
		    pm.registerEvents(new PlayerChangeWorld(this), this);
		    pm.registerEvents(new PlayerBreak(this), this);
		    pm.registerEvents(new PlayerQuitt(this), this);
		    pm.registerEvents(new TransfertReserve(this), this);
		    pm.registerEvents(new Slots(this), this);
		    pm.registerEvents(new Event(this), this);
	  }

	  public void registerCommands(){

		  this.getCommand("minage").setExecutor(new Mine());
		  this.getCommand("inventaire").setExecutor(new Inventory());
		  this.getCommand("reserve").setExecutor(new Reserve());
		  
		  
	  }
}
