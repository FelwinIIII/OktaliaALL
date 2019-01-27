package fr.WalexFelwin.OktaliaHub.Inventaire.Interact;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerInfo;
import fr.WalexFelwin.OktaliaHub.Inventaire.InventaireHub;

public class InteractMenuP implements Listener{

		
		public InteractMenuP(Main main){
			
		}

		  public InteractMenuP(fr.WalexFelwin.OktaliaHub.Main main) {
			// TODO Auto-generated constructor stub
		}

		@EventHandler
		  public void onInventoryClickEvent(InventoryClickEvent e)
		  {
			 
		    Player p = (Player)e.getWhoClicked();
		    if (p.getOpenInventory().getTopInventory().getTitle().startsWith("§aMenu Principal"))
		    {
		      	e.setCancelled(true);     
		        if ((e.getCurrentItem() == null) && (e.getCurrentItem().getType() == Material.AIR))
		        {
		        	return;
		        }
				
			     if(e.getCurrentItem().getType() == Material.EMERALD_BLOCK){

			         p.sendMessage("§eVous êtes maintenant sur le serveur §aFaction");
			         
			         ServerInfo Faction = Main.getInstance().getPingAPI().getServer("Faction");
			         Faction.teleportPlayer(p);
			         
			         
			     }	else if(e.getCurrentItem().getType() == Material.EMERALD_ORE){

			         p.sendMessage("§eVous êtes maintenant sur le serveur §aMinage");
			         
			         ServerInfo Minage = Main.getInstance().getPingAPI().getServer("Minage");
			         Minage.teleportPlayer(p);
			         
			         
			     }		
		     if(e.getCurrentItem().getType() == Material.NETHER_STAR){
				    
			  		for(int i = 1; i <= 5; i++) {
			  			String hubserver = "Hub"+i;
			  			
				         ServerInfo hubS = Main.getInstance().getPingAPI().getServer(hubserver);
				         hubS.pingToServer();
			  		}
		    	 InventaireHub.Inventory(p);
		     }
		 	
		     if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD){

		
		         
		     }
		    

		     if(e.getCurrentItem().getTypeId() == 101){

		     }
		     
		    }
		  
		  }

	}
