package fr.WalexFelwin.OktaliaHub.Slots.Interact;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerInfo;
import fr.WalexFelwin.OktaliaHub.Main;
import fr.WalexFelwin.OktaliaHub.Inventaire.InventaireHub;
import fr.WalexFelwin.OktaliaHub.Inventaire.MenuPrincipale;

public class InteractSlotsJoueur  implements Listener{

	
	public InteractSlotsJoueur(Main main){
		
	}
	

	@EventHandler(priority=EventPriority.HIGHEST)
	public void OnClickHotBar(PlayerInteractEvent e){ 
		
		
		Player p = e.getPlayer();

	     if(p.getItemInHand().getType().equals(Material.COMPASS)){
	    	 
	    	 MenuPrincipale.InventoryMenuPrincipale(p);
	     }

	     if(p.getItemInHand().getType().equals(Material.NETHER_STAR)){
	

		  		for(int i = 1; i <= 5; i++) {
		  			String hubserver = "Hub"+i;
		  			
			         ServerInfo hubS = fr.WalexFelwin.OktaliaAPI.Bukkit.Main.getInstance().getPingAPI().getServer(hubserver);
			         hubS.pingToServer();
		  		}
		  		
	    	 InventaireHub.Inventory(p);
	     }
	     
		
	}
}

