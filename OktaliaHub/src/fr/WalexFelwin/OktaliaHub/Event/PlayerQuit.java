package fr.WalexFelwin.OktaliaHub.Event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.WalexFelwin.OktaliaHub.Main;
import fr.WalexFelwin.OktaliaHub.API.API_HubPlayer;
import fr.WalexFelwin.OktaliaHub.ScoreBoard.Scoreboard;

public class PlayerQuit implements Listener{

	
	public PlayerQuit(Main main) {
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void playerquitt(PlayerQuitEvent e){
		Player p = e.getPlayer();
		

	    p.getInventory().clear();

		API_HubPlayer.playergradesremove(p);
		int joueur = Bukkit.getOnlinePlayers().size()-1;
		   for (Player o : Bukkit.getOnlinePlayers())
		    {
			   Scoreboard.sslist.get(o).setLine(3, "§fJoueurs: §6§l"+joueur);
		    }

			Scoreboard.sslist.get(p).destroy();
			Scoreboard.sslist.remove(p);
			e.setQuitMessage(null);
			
			//API_HubPlayer.playergradesremove(p);
		   
	}
	
}
