package fr.walexmine.OktaliaMascotte.Event;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Golem;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.walexmine.OktaliaMascotte.Main;
import fr.walexmine.OktaliaMascotte.Commands.Mascote;

public class PlayerQuitt
  implements Listener
{
  public PlayerQuitt(Main main) {}
  
  
  @EventHandler
  public void onquittpl(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();

    e.setQuitMessage(null);/*scoreboard.sslist.get(p).destroy();
    scoreboard.sslist.remove(p);*/


		for (Entity entity : p.getWorld().getEntities()) {
        if (((entity instanceof Wither )) || ((entity instanceof Blaze )) || ((entity instanceof Golem )) || ((entity instanceof Wolf ))) {
      	  
		if(Mascote.MascoteBlaze.containsKey(p)){
			
      	  UUID uid = entity.getUniqueId();
      	  UUID getuuid = Mascote.MascoteBlaze.get(p);
      	  
      	  if(uid.equals(getuuid)){

      		  Mascote.MascoteBlaze.remove(p);
      	  entity.remove();
      	  }
			
		} else if(Mascote.MascoteWither.containsKey(p)){
			
	      	  UUID uid = entity.getUniqueId();
	      	  UUID getuuid = Mascote.MascoteWither.get(p);
	      	  
	      	  if(uid.equals(getuuid)){
	      		  Mascote.MascoteWither.remove(p);
	      	  entity.remove();
	      	  }
	      	  
			} else if(Mascote.MascoteGolem.containsKey(p)){
				
		      	  UUID uid = entity.getUniqueId();
		      	  UUID getuuid = Mascote.MascoteGolem.get(p);
		      	  
		      	  if(uid.equals(getuuid)){
		      		  Mascote.MascoteGolem.remove(p);
		      	  entity.remove();
		      	  }
		      	  
				}else if(Mascote.MascoteLoup.containsKey(p)){
					
			      	  UUID uid = entity.getUniqueId();
			      	  UUID getuuid = Mascote.MascoteLoup.get(p);
			      	  
			      	  if(uid.equals(getuuid)){
			      		  Mascote.MascoteLoup.remove(p);
			      	  entity.remove();
			      	  }
			      	  
					}
		}
		
        }
		
  }
  
  

}
