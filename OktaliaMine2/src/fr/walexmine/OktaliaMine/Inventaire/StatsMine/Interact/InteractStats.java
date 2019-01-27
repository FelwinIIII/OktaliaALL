package fr.walexmine.OktaliaMine.Inventaire.StatsMine.Interact;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.walexmine.OktaliaMine.Main;

public class InteractStats implements Listener{

	public InteractStats(Main main) {
		
	}
	
	 @EventHandler
	  public void onInventoryClickEvent(InventoryClickEvent e)
	  {
		 
	    Player p = (Player)e.getWhoClicked();


	    
	    if (p.getOpenInventory().getTopInventory().getTitle().equalsIgnoreCase("§6Statistiques"))
	    {

	     
	    	e.setCancelled(true);     
	        if ((e.getCurrentItem() == null) && (e.getCurrentItem().getType() == Material.AIR))
	        {
	        	return;
	        }
	
	    }
	 }
}
