package fr.walexmine.OktaliaMine.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import fr.walexmine.OktaliaMine.Main;

public class Event implements Listener{

	public Event(Main main) {
		
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onPlayerDamage(EntityDamageEvent e){

		
			e.setCancelled(true);
		
	
	}	
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onPlayerMove(PlayerMoveEvent e){

		Player p = e.getPlayer();
		
		

			p.setHealth(20);
			p.setFoodLevel(20);
			
		
	
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void PlayerDropItem(PlayerDropItemEvent e){

		Player p = e.getPlayer();
		
		

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
