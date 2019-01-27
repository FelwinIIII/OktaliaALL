package fr.walexmine.OktaliaMine.Inventaire.Interact;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.walexmine.OktaliaMine.Main;
import fr.walexmine.OktaliaMine.Inventaire.StatsMine.Stats;

public class Slots implements Listener{

	
	public Slots(Main main){
		
	}
	

	@EventHandler(priority=EventPriority.HIGHEST)
	public void OnClickHotBar(PlayerInteractEvent e){ 
		
		
		Player p = e.getPlayer();
	     if(p.getItemInHand().getType().equals(Material.CHEST)){

		    	fr.walexmine.OktaliaMine.Inventaire.Reserve.RESERVEMINAGE(p);
	     }

	     if(p.getItemInHand().getType().equals(Material.ENDER_CHEST)){
	    	 Stats.STATISTIQUES(p);
	     }
		
	}
}