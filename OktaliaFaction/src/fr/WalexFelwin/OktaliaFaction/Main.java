package fr.WalexFelwin.OktaliaFaction;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.WalexFelwin.OktaliaFaction.Commandes.MagasinCommand;
import fr.WalexFelwin.OktaliaFaction.Commandes.Menu;
import fr.WalexFelwin.OktaliaFaction.Commandes.cooldown;
import fr.WalexFelwin.OktaliaFaction.Event.BlockEvent;
import fr.WalexFelwin.OktaliaFaction.Event.InvClickEvent;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL.Interact.InteractBlock;
import fr.WalexFelwin.OktaliaFaction.Inventaire.Utils.FinalInv;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		System.out.println("Plugin OktaliaFaction lancer !");
		
		getCommand("menu").setExecutor(new Menu());
		getCommand("magasin").setExecutor(new MagasinCommand());
		registerEvents();
	}
	@Override
	public void onDisable() {
		
	}
	
	

	  public void registerEvents(){
		    PluginManager pm = getServer().getPluginManager();
		    getServer().getPluginManager().registerEvents(this, this);
		    pm.registerEvents(new FinalInv(this), this);
		    pm.registerEvents(new InteractBlock(this), this);
		    pm.registerEvents(new InvClickEvent(), this);
		    pm.registerEvents(new BlockEvent(), this);
		    pm.registerEvents(new cooldown(), this);
		   
		    
	  }
}
