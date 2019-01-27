package fr.WalexFelwin.OktaliaAuthLogin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow.Spigot;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import fr.WalexFelwin.OktaliaAuthLogin.Commands.Login;
import fr.WalexFelwin.OktaliaAuthLogin.Commands.Register;
import fr.WalexFelwin.OktaliaAuthLogin.MySql.Mysql;


public class Main extends JavaPlugin implements Listener, PluginMessageListener{

	@Override
	public void onDisable() {
		
	}

	@Override
	public void onEnable() {
	
		loadlistener();
		Boucle.clock();
		Boucle.clockup();

	    Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	    Bukkit.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
		Mysql.host = "localhost";
		Mysql.port = 3306;
		Mysql.database = "Falcon9";
		Mysql.username = "walexmine";
		Mysql.password = "V37bKGhxtzRGbyot";
	    Mysql.conn = Mysql.openConnection();
	    InfoLogin.createTable();

		  this.getCommand("login").setExecutor(new Login());

		  this.getCommand("l").setExecutor(new Login());

		  this.getCommand("register").setExecutor(new Register());

		  this.getCommand("reg").setExecutor(new Register());
	    	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaLogin"), new Runnable() {
	              public void run() {
	    
	            	  Bukkit.getServer().spigot().restart();
					 
	              }
	      }, 15000);
	}
	
	public void loadlistener(){
		
	    PluginManager pm = getServer().getPluginManager();
	    getServer().getPluginManager().registerEvents(this, this);
	    pm.registerEvents(new fr.WalexFelwin.OktaliaAuthLogin.Listener(this), this);
	}

	@Override
	public void onPluginMessageReceived(String arg0, Player arg1, byte[] arg2) {
		// TODO Auto-generated method stub
		
	}


}
