package fr.WalexFelwin.OktaliaHub;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Redirect;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Tab;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerInfo;
import fr.WalexFelwin.OktaliaHub.API.API_HubPlayer;
import fr.WalexFelwin.OktaliaHub.Event.Essentiels;
import fr.WalexFelwin.OktaliaHub.Event.MOTD;
import fr.WalexFelwin.OktaliaHub.Event.PlayerJoin;
import fr.WalexFelwin.OktaliaHub.Event.PlayerQuit;
import fr.WalexFelwin.OktaliaHub.Inventaire.Interact.InteractHub;
import fr.WalexFelwin.OktaliaHub.Inventaire.Interact.InteractMenuP;
import fr.WalexFelwin.OktaliaHub.Inventaire.RELOAD.InventaireHubRELOAD;
import fr.WalexFelwin.OktaliaHub.Inventaire.RELOAD.InventaireMenuRELOAD;
import fr.WalexFelwin.OktaliaHub.ScoreBoard.Scoreboard;
import fr.WalexFelwin.OktaliaHub.Slots.Interact.InteractSlotsJoueur;
import fr.WalexFelwin.OktaliaHub.Update.UpdateTab;

public class Main extends JavaPlugin implements Listener{



	public void onEnable() {
		
		registerEvents();
		registerPNJ();
		//ServeurRegister.RegisterServeur();
		
		for (Player o : Bukkit.getOnlinePlayers())
	    {
		   Scoreboard.Scoreboardstart(o);
	    }
	 
	    UpdateTab.clock();
	    
	    
	    System.out.println("Plugin Hub lancer !");
	    
	    API_HubPlayer.dev.put("dev", 0);
	    API_HubPlayer.gerant.put("gerant", 0);
	    API_HubPlayer.admin.put("admin", 0);
	    API_HubPlayer.modo.put("modo", 0);
	    API_HubPlayer.moda.put("moda", 0);
	    API_HubPlayer.manager.put("manager", 0);
	    API_HubPlayer.buildeur.put("buildeur", 0);
	    API_HubPlayer.youtubeur.put("youtubeur", 0);
	    API_HubPlayer.ami.put("ami", 0);
	    API_HubPlayer.vip.put("vip", 0);
	    API_HubPlayer.joueur.put("joueur", 0);
    	
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaHub"), new Runnable() {
          public void run() {
        	  ServeurRegister.RegisterServeur();
          }
		}, 40);


	    new InventaireHubRELOAD().runTaskTimerAsynchronously(this, 0L, 25);

	    new InventaireMenuRELOAD().runTaskTimerAsynchronously(this, 0L, 40);
		
	}
	
	
	
	public void onDisable() {
		unregisterPNJ();
		
		for (Player p : Bukkit.getOnlinePlayers())
	    {
		Scoreboard.sslist.get(p).destroy();
		Scoreboard.sslist.remove(p);
			API_Redirect.HubSelect(p);
	    }
		
		//API_Update.update("http://62.210.168.253/plugin/download/HezonNetWorkHub.jar", "HezonNetWorkHub.jar");
		
			World w = (World)Bukkit.getWorld("world");

		        for (LivingEntity ent : w.getLivingEntities()) {
		            if ((ent instanceof ArmorStand) || (ent instanceof Villager)) {
			        	  ent.remove();
			          }
			          
		        }
	}
	

	  public void registerEvents(){
		    PluginManager pm = getServer().getPluginManager();
		    getServer().getPluginManager().registerEvents(this, this);
		    pm.registerEvents(new MOTD(this), this);
		    /*pm.registerEvents(new PlayerJoin(this), this);
		    pm.registerEvents(new PlayerQuit(this), this);
		    pm.registerEvents(new PlayerDrops(this), this);*/
		    pm.registerEvents(new Essentiels(this), this);
		    //pm.registerEvents(new MOTD(this), this);
		    pm.registerEvents(new InteractSlotsJoueur(this), this);
		    pm.registerEvents(new InteractHub(this), this);
		    pm.registerEvents(new InteractMenuP(this), this);
		    pm.registerEvents(new PlayerJoin(this), this);
		    pm.registerEvents(new PlayerQuit(this), this);
	  }
	  

	  public void registerPNJ(){
		 /* API_PNJ.spawn("HEZONPVP", "§6§l★ §e§lHEZONPVP §6§l★", -448.5D, 56, -622.5D, (float)270.49493, (float)-0.5567427);
		  API_PNJ.spawn("PRACTICE", "§e§lPractice §a| §e§lHezon", -399.5D, 56, -573.5D, (float)179.75366, (float)-1.157982);
		  API_PNJ.spawn("PNJUNK2", "§4§l✖ §cEN DEVELOPPEMENT §4§l✖", -399.5D, 56, -671.5D, (float)0.2814331, (float)-0.9576099);
		  API_PNJ.spawn("PNJUNK3", "§4§l✖ §cEN DEVELOPPEMENT §4§l✖", -350.5D, 56, -622.5D, (float)89.86847, (float)-1.3904266);*/
	  }
	  

	  public void unregisterPNJ(){

	/*	  API_PNJ.pnjhololist.remove("HEZONPVP1");
		  API_PNJ.pnjhololist.remove("PRACTICE1");
		  API_PNJ.pnjhololist.remove("PNJUNK21");
		  API_PNJ.pnjhololist.remove("PNJUNK31");
		  API_PNJ.pnjhololist.remove("HEZONPVP2");
		  API_PNJ.pnjhololist.remove("PRACTICE2");
		  API_PNJ.pnjhololist.remove("PNJUNK22");
		  API_PNJ.pnjhololist.remove("PNJUNK32");
		  
		  
		  API_PNJ.pnjlist.remove("HEZONPVP");
		  API_PNJ.pnjlist.remove("PRACTICE1");
		  API_PNJ.pnjlist.remove("PNJUNK21");
		  API_PNJ.pnjlist.remove("PNJUNK31");*/
	  }
}
