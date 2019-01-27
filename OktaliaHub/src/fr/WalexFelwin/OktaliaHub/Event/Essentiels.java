package fr.WalexFelwin.OktaliaHub.Event;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import fr.WalexFelwin.OktaliaHub.Main;


public class Essentiels implements Listener{

	
	public Essentiels(Main main) {
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void Playerbreak(BlockBreakEvent e){
		e.setCancelled(true);
	}	

	@EventHandler
	public void Playerbreak(BlockPlaceEvent e){
		e.setCancelled(true);
	}

	@EventHandler
	public void Playerbreak(WeatherChangeEvent e){
		e.setCancelled(true);
	}


	@EventHandler
	public void Playerbreak(InventoryInteractEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void EntityDamage(EntityDamageEvent e){	
			e.setCancelled(true);
	}
	
	@EventHandler
	public void eventmob(EntitySpawnEvent e){	
		
		if(e.getEntityType() == EntityType.VILLAGER 
				|| e.getEntityType() == EntityType.ARMOR_STAND){
			//test
			
		} else {
		e.setCancelled(true);
		}
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onPlayerDamage(PlayerMoveEvent e){

		Player p = e.getPlayer();
		
			p.setHealth(20);
			
			p.setFoodLevel(20);
			
	
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void PlayerDropItem(PlayerDropItemEvent e){


			e.setCancelled(true);
	
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void PlayerPickupItem(PlayerPickupItemEvent e){

		Player p = e.getPlayer();

			e.setCancelled(true);
		
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void ItemSpawn(ItemSpawnEvent e){

			e.setCancelled(true);
			
	}

	@EventHandler(priority=EventPriority.HIGHEST)
	public void onSpawn(EntitySpawnEvent e){
			e.setCancelled(true);
			
		
	}
}
