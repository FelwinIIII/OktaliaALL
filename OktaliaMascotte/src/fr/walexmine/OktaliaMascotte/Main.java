package fr.walexmine.OktaliaMascotte;

import java.sql.Connection;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.walexmine.OktaliaMascotte.Commands.Mascote;
import fr.walexmine.OktaliaMascotte.Event.PlayerDamage;
import fr.walexmine.OktaliaMascotte.Event.PlayerQuitt;
import fr.walexmine.OktaliaMascotte.Update.MySQL;
import fr.walexmine.OktaliaMascotte.Update.UpdateTp;


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
	    	World w1 = (World)Bukkit.getWorld(""+p.getWorld().getName());
			
			for (Entity entity : w1.getEntities()) {
	          if (((entity instanceof Wither )) || ((entity instanceof Blaze ))) {
	        	  
	  		if(Mascote.MascoteBlaze.containsKey(p)){
	  			
	        	  UUID uid = entity.getUniqueId();
	        	  UUID getuuid = Mascote.MascoteBlaze.get(p);
	        	  
	        	  if(uid.equals(getuuid)){
	        	  
	        	  p.sendMessage("§eVotre mascotte §6Blaze §ea été désactiver");
	        	  entity.remove();
	        	  }
	  			
	  		} else if(Mascote.MascoteWither.containsKey(p)){
				
	        	  UUID uid = entity.getUniqueId();
	        	  UUID getuuid = Mascote.MascoteWither.get(p);
	        	  
	        	  if(uid.equals(getuuid)){
		          p.sendMessage("§eVotre mascotte §7Wither §ea été désactiver");
	        	  entity.remove();
	        	  }
	        	  
	  		} else {
	  			p.sendMessage("§cVous ne disposez d'aucune mascotte en ce moment !");
	  		}
	  		
	          }
			}
	  		
	  
	    }
	    }
		
		
	}

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
	    InfoMascotte.createTable();

	    Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new UpdateTp(), 0L, 1L);
	    
	    registerEvents();
	    registerCommands();
	    
	}
	  
	  public void registerEvents(){
		    PluginManager pm = getServer().getPluginManager();
		    getServer().getPluginManager().registerEvents(this, this);

		    pm.registerEvents(new PlayerQuitt(this), this);
		    pm.registerEvents(new PlayerDamage(this), this);
	  }
	
	  public void registerCommands(){
	
		  this.getCommand("mascotte").setExecutor(new Mascote());
		  
	  }
	}
