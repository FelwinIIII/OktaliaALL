package fr.walexmine.OktaliaQuete.Inventaire.Interact;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import fr.walexmine.OktaliaQuete.Main;


public class InteractQuete implements Listener{

	public InteractQuete(Main main) {
		
	}
	
	 @EventHandler
	  public void onInventoryClickEvent(InventoryClickEvent e)
	  {
		 
	    Player p = (Player)e.getWhoClicked();
	    

	    
	    if (p.getOpenInventory().getTopInventory().getTitle().equalsIgnoreCase("§7§lQuête"))
	    {

	     
	    	e.setCancelled(true);     
	        if ((e.getCurrentItem() == null) && (e.getCurrentItem().getType() == Material.AIR))
	        {
	        	return;
	        } else {
	        	
	        	ItemStack item = e.getCurrentItem();

	        }
	    }
	    
	  
	   	     
	        
	    
	    
	  }
}
