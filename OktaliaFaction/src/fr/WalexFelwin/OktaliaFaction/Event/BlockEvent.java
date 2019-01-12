package fr.WalexFelwin.OktaliaFaction.Event;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import fr.WalexFelwin.OktaliaFaction.Colonne.Place;


public class BlockEvent implements Listener {
	
	  @EventHandler
	  public void PlaceBlock(BlockPlaceEvent e){
		Block b = (Block) e.getBlock();
		
		Player p = e.getPlayer();
		
		Location loc = e.getBlock().getLocation();
		
		if(p.getItemInHand().getItemMeta().getDisplayName() == "§5Mur D'obsidienne §8(§7250 blocks§8)") {
		
		if(e.getBlock().getType() == Material.OBSIDIAN) {
			
			Place.PlaceObsidian(b, loc);
			
		}
		
	}
		if(p.getItemInHand().getItemMeta().getDisplayName() == "§5Mur de Sable §8(§7250 blocks§8)") {
			
			if(e.getBlock().getType() == Material.SAND) {
				
				Place.PlaceSand(b, loc);
				
			}
			
		}
	  }
	
	
}
