package fr.WalexFelwin.OktaliaHub.Event;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Tab;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Title;
import fr.WalexFelwin.OktaliaHub.Main;
import fr.WalexFelwin.OktaliaHub.API.API_HubPlayer;
import fr.WalexFelwin.OktaliaHub.ScoreBoard.Scoreboard;
import fr.WalexFelwin.OktaliaHub.Slots.SlotsJoueur;
import fr.WalexFelwin.OktaliaHub.Update.UpdateTab;

public class PlayerJoin implements Listener{

	public PlayerJoin(Main main) {
		
	}
	
	@EventHandler
	public void OnClickHotBar(PlayerJoinEvent e){ 
		
		Player p = e.getPlayer();
		
		Location loc = new Location(Bukkit.getWorld("world"), 147.5, 70.5, -118.5);
		
		p.setGameMode(GameMode.ADVENTURE);
		p.teleport(loc);
		
		SlotsJoueur.Item(p);
		
		Scoreboard.Scoreboardstart(p);
		API_HubPlayer.playergradesadd(p);
		
	    API_Title.sendTitle(p, "§f» §6OKTALIA §fNETWORK §6«", "§fUn serveur qui sort de l'ordinaire §6!", 60);

		int joueur = Bukkit.getOnlinePlayers().size();
		   for (Player o : Bukkit.getOnlinePlayers())
		    {
			   Scoreboard.sslist.get(o).setLine(3, "§fJoueurs: §6§l"+joueur);
		    }
	    API_Tab.setPlayerList(p, UpdateTab.tabhaut
	    	  , UpdateTab.tabbas);
	    
	}
}
