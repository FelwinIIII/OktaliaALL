package fr.walexmine.OktaliaMascotte.Event;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Golem;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.ApplicableRegionSet;

import fr.walexmine.OktaliaMascotte.Main;
import fr.walexmine.OktaliaMascotte.Commands.Mascote;

public class PlayerDamage implements Listener{

	
	  public PlayerDamage(Main main) {
		// TODO Auto-generated constructor stub
	}


		  
	  @EventHandler
		public void Playerbreak(BlockBreakEvent e){
		  
		  Location loc = e.getBlock().getLocation();
		  
		  ApplicableRegionSet set = WGBukkit.getRegionManager(loc.getWorld()).getApplicableRegions(loc);
		World w = (World)Bukkit.getWorld(""+e.getBlock().getWorld().getName());
		String regions = set.getRegions().toString();
     	if(regions.equalsIgnoreCase("[ProtectedRegion{id='safezone', type='CUBOID'}, ProtectedRegion{id='warzone', type='CUBOID'}]")){
		
     		if(e.getBlock().getTypeId() == 389 || e.getBlock().getTypeId() == 167) {
     			e.setCancelled(true);
     		}
     		
     	}
     			
     	
     	}

	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onPlayerDamage(EntityDamageEvent e){
		
		org.bukkit.entity.Entity el = e.getEntity();

		if ((el instanceof Blaze)) {
			
			
			for (Player updatetp : Mascote.MascoteBlaze.keySet()) {

				World w = (World)Bukkit.getWorld(""+updatetp.getWorld().getName());
			
	
			        	  
			          
			
				  UUID uid = e.getEntity().getUniqueId();
	        	  UUID getuuid = Mascote.MascoteBlaze.get(updatetp);
	        	  
	        	  if(uid.equals(getuuid)){
	        		  
	        		  
	        			  e.setCancelled(true);
	        			
	        	  	}
			          
			}

		}

		if ((el instanceof Wither)) {
			
			
			for (Player updatetp : Mascote.MascoteWither.keySet()) {

				World w = (World)Bukkit.getWorld(""+updatetp.getWorld().getName());
		
				  UUID uid = e.getEntity().getUniqueId();
	        	  UUID getuuid = Mascote.MascoteWither.get(updatetp);
	        	  
	        	  if(uid.equals(getuuid)){
	        		  
	        		  
	        			  e.setCancelled(true);
	        			
	        	  	}
			          
			}

		}

		if ((el instanceof Golem)) {
			
			
			for (Player updatetp : Mascote.MascoteGolem.keySet()) {

				World w = (World)Bukkit.getWorld(""+updatetp.getWorld().getName());
		
				  UUID uid = e.getEntity().getUniqueId();
	        	  UUID getuuid = Mascote.MascoteGolem.get(updatetp);
	        	  
	        	  if(uid.equals(getuuid)){
	        		  
	        		  
	        			  e.setCancelled(true);
	        			
	        	  	}
			          
			}

		}

		if ((el instanceof Wolf)) {
			
			
			for (Player updatetp : Mascote.MascoteLoup.keySet()) {

				World w = (World)Bukkit.getWorld(""+updatetp.getWorld().getName());
		
				  UUID uid = e.getEntity().getUniqueId();
	        	  UUID getuuid = Mascote.MascoteLoup.get(updatetp);
	        	  
	        	  if(uid.equals(getuuid)){
	        		  
	        		  
	        			  e.setCancelled(true);
	        			
	        	  	}
			          
			}

		}
	}
	  

}
