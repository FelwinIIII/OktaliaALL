package fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL.Interact;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import fr.WalexFelwin.OktaliaFaction.Main;
import fr.WalexFelwin.OktaliaFaction.Inventaire.Utils.FinalInv;

public class InteractBlock implements Listener{
	
	public InteractBlock(Main main) {
		// TODO Auto-generated constructor stub
	}
	
	  @EventHandler
	  public void onInventoryClickEvent(InventoryClickEvent e)
	  {
		 
	    Player p = (Player)e.getWhoClicked();
	    String name = p.getOpenInventory().getTopInventory().getTitle();
	    if (name == "§6Block" || name == "§6Block§8(§71§8)" || name == "§6Farm" || name == "§6Minerais" || name == "§6Alchimie" || name == "§6Nourriture" || name == "§6Potions" || name == "§6Spawner" || name == "§6Kits" || name == "§6Décoration" || name == "§6Enchantement" || name == "§6Pillage")
	    {

	     
	    	e.setCancelled(true);     
	        if ((e.getCurrentItem() == null) && (e.getCurrentItem().getType() == Material.AIR))
	        {
	        	return;
	        } else {
	        	
	        	//Clic Molette VENTE OBJET
	        	
	        	
	        	if(e.isShiftClick()) {

		        	int Prix = Integer.valueOf(e.getCurrentItem().getItemMeta().getLore().get(2).replace("§c» §7Prix Vente: §6", "").replace("$ unité", ""));
		        	
		        	
		        	
	        	} else {
	        		

	        		
	        		ItemStack Item4 = new ItemStack(e.getCurrentItem());
	        		
	        		String newprix = Item4.getItemMeta().getLore().get(1).replace("§c» §7Prix Achat: §6", "").replace("$ unité", "");
	        		int Prix = Integer.valueOf(newprix);
	        		
	        		
	        		
	        		if(FinalInv.getInv.containsKey(p)) {
	        			// FINAL ACHAT


	        			} else {
	        				
	        				// ACHAT REFUS
	        				
	        				
	        			}

	        	
	        			//debut d'achat
	        			FinalInv.FinalInv1(e.getCurrentItem(), Prix, p, p.getOpenInventory().getTopInventory());
	        		
	        			
		        	
	        	
				        
				    
	        
	    } 
	        
	        
	        
	        }

	    
	  
	  if(p.getOpenInventory().getTopInventory().getTitle().contains(" > Achat")) {
	    	
			int Prix =  Integer.valueOf(p.getOpenInventory().getTopInventory().getItem(4).getItemMeta().getLore().get(1).replace("§c» §7Prix Achat: §6", "").replace("$ unité", ""));
			
			int Quantité = Integer.valueOf(p.getOpenInventory().getTopInventory().getItem(4).getItemMeta().getLore().get(3).replace("§bQuantité: §e", ""));
			int Argent = 50000;
			
			if(Prix < Argent) {

				 // ACHAT POSSIBLE
				ItemStack item = new ItemStack(p.getOpenInventory().getTopInventory().getItem(4).getType(), Quantité, ((short)p.getOpenInventory().getTopInventory().getItem(4).getData().getData()));
				p.sendMessage("§aAchat réussit !");
        }
	    
	  }
	  


	    }
	  }
}

