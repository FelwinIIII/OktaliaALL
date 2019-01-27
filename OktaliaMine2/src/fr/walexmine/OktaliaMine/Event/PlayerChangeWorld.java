package fr.walexmine.OktaliaMine.Event;

import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.ItemStack;

import fr.walexmine.OktaliaMine.Main;
import fr.walexmine.OktaliaMine.API.API_Inventory;
import fr.walexmine.OktaliaMine.Inventaire.Minage;

public class PlayerChangeWorld implements Listener{
	
	public PlayerChangeWorld(Main main) {
		
	}

	
	@EventHandler
	public void World(PlayerChangedWorldEvent e) {
		
		Player p = e.getPlayer();
		
		
	}
	
	
}
 