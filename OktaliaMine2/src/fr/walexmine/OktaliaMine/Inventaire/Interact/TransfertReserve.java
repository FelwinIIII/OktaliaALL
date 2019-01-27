package fr.walexmine.OktaliaMine.Inventaire.Interact;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import fr.walexmine.OktaliaMine.Main;
import fr.walexmine.OktaliaMine.Inventaire.Reserve;
import fr.walexmine.OktaliaMine.Inventaire.Transfert;


public class TransfertReserve implements Listener{

	public TransfertReserve(Main main) {
		
	}
	
	 @EventHandler
	  public void onInventoryClickEvent(InventoryClickEvent e)
	  {
		 
	    Player p = (Player)e.getWhoClicked();
	    	if(p.isOp()) {
	    		
	    	 } else {
	    	e.setCancelled(true);
	    	 }
	    
	    if (p.getOpenInventory().getTopInventory().getTitle().equalsIgnoreCase("§eReserve Minage"))
	    {

	     
	    	e.setCancelled(true);     
	        if ((e.getCurrentItem() == null) && (e.getCurrentItem().getType() == Material.AIR))
	        {
	        	return;
	        } else {
	        	
	        	ItemStack item = e.getCurrentItem();
		    	int Quantité = Integer.valueOf(item.getItemMeta().getLore().get(2).replace("§bQuantité: §e", ""));
				 Transfert.Transfert(p, item, Quantité);
	        }
	    }  
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    if (p.getOpenInventory().getTopInventory().getTitle().equalsIgnoreCase("§eReserve Factions"))
	    {

	     
	    	e.setCancelled(true);     
	        if ((e.getCurrentItem() == null) && (e.getCurrentItem().getType() == Material.AIR))
	        {
	        	
	        	return;
	        } else {
	        	if(e.isRightClick()) {
	        	
	 			ItemStack transfertitem = e.getCurrentItem();

	    		 int Quantité = Integer.valueOf(transfertitem.getItemMeta().getLore().get(2).replace("§bQuantité: §e", ""));
	    		 
	    		 
	 			ItemStack itemadd = new ItemStack(e.getCurrentItem().getType(), Quantité, e.getCurrentItem().getData().getData());
		    		 
		    		 
		    		 
		    		 String reservem = Reserve.Reserve.get(p);
		    		 
		    		 String newreservem = reservem.replace(transfertitem.getTypeId()+":"+transfertitem.getData().getData() + " - " +Quantité+",", "");
		    		 
		    		 if(newreservem.equalsIgnoreCase("")) {
		    			 
		    			newreservem = " ";
		    			 
		    		 }
		    			Reserve.Reserve.put(p, newreservem);
		    		 
		    			p.closeInventory();
		    			

		    			p.getInventory().addItem(itemadd);
	        	}
	        }
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    if (p.getOpenInventory().getTopInventory().getTitle().equalsIgnoreCase("§eTransfère >> Faction"))
	    {

	     
	    	e.setCancelled(true);     
	        if ((e.getCurrentItem() == null) && (e.getCurrentItem().getType() == Material.AIR))
	        {
	        	return;
	        } else {
	        	
	            
	   	     if(e.getCurrentItem().getType() == Material.WOOL){
	   	    	 
	   		    	 if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a✔  Valider ✔")){
	   		    		 
	   		    		 // TRANSFERT DE L'OBJET
	   		    		 
	   		    		 			ItemStack transfertitem = p.getOpenInventory().getItem(13);
	   		    		 
	   		    		 
	   		    		 int Quantité = Integer.valueOf(transfertitem.getItemMeta().getLore().get(1).replace("§cQuantité: §e", ""));
	   		    		 
	   		    		 
	   		    		 String reservem = Reserve.ReserveMine.get(p);
	   		    		 
	   		    		 String newreservem = reservem.replace(transfertitem.getTypeId()+":"+transfertitem.getData().getData() + " - " +Quantité+",", "");
	   		    		 
	   		    		 if(newreservem.equalsIgnoreCase("")) {
	   		    			 
	   		    			newreservem = " ";
	   		    			 
	   		    		 }
	   		    			Reserve.ReserveMine.put(p, newreservem);
	   		    		 
	   		    		 String faccheck = transfertitem.getTypeId()+":"+transfertitem.getData().getData();
							p.closeInventory();
	   		    		 
	fr.walexmine.OktaliaMine.Inventaire.Interact.Transfert.addblockinv(p, transfertitem.getTypeId(), Quantité, Integer.valueOf(transfertitem.getData().getData()));
	   		    		

						p.sendMessage("§7[§bOktalia§7] §aLe transfère a bien été effectuée");
	   		    	 } else {   		

	   		    		 if(e.getCurrentItem().getData().getData() == 14) {
	   		    		 p.closeInventory();
							p.sendMessage("§7[§bOktalia§7] §cLe transfère a échoué");
	   		    		 } else {
	   		    			 
	   		    		 }
	   		    		 
	   		    		 
	   		    	 }
	   		    	 
	   	     } else if (e.getCurrentItem().getType().equals(e.getCurrentItem().getType())){
	   	    	 
	   	     
		   	  if(e.getClick().isRightClick()){
		   		  
		   	  	}
		   	  
		   	  
	   	     }
	   	     
	        }
	    }
	    
	  }
}
