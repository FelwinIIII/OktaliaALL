package fr.WalexFelwin.OktaliaHub.Inventaire.Interact;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerInfo;
import fr.WalexFelwin.OktaliaHub.Main;


public class InteractHub implements Listener{

	
	public InteractHub(Main main){
		
	}

	  @EventHandler
	  public void onInventoryClickEvent(InventoryClickEvent e)
	  {
		 
	    Player p = (Player)e.getWhoClicked();
	    if (p.getOpenInventory().getTopInventory().getTitle().startsWith("§aListe des Hubs"))
	    {

	   	e.setCancelled(true);     
        if ((e.getCurrentItem() == null) && (e.getCurrentItem().getType() == Material.AIR))
        {
        	return;
        }
	    
	     if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Hub 1")){
	         ServerInfo hubS = fr.WalexFelwin.OktaliaAPI.Bukkit.Main.getInstance().getPingAPI().getServer("Hub1");
	         hubS.pingToServer();
	         hubS.teleportPlayer(p);
	     } else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Hub 2")){

	         ServerInfo hubS = fr.WalexFelwin.OktaliaAPI.Bukkit.Main.getInstance().getPingAPI().getServer("Hub2");
	         hubS.pingToServer();
	         hubS.teleportPlayer(p);
	     } else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Hub 3")){

	         ServerInfo hubS = fr.WalexFelwin.OktaliaAPI.Bukkit.Main.getInstance().getPingAPI().getServer("Hub3");
	         hubS.pingToServer();
	         hubS.teleportPlayer(p);
	     } else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Hub 4")){

	         ServerInfo hubS = fr.WalexFelwin.OktaliaAPI.Bukkit.Main.getInstance().getPingAPI().getServer("Hub4");
	         hubS.pingToServer();
	         hubS.teleportPlayer(p);
	     } else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Hub 5")){

	         ServerInfo hubS = fr.WalexFelwin.OktaliaAPI.Bukkit.Main.getInstance().getPingAPI().getServer("Hub5");
	         hubS.pingToServer();
	         hubS.teleportPlayer(p);
	     }
	     p.closeInventory();
	    }
	  
	  }

}