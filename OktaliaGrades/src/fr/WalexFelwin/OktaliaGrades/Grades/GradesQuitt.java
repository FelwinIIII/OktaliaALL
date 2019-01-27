package fr.WalexFelwin.OktaliaGrades.Grades;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;
import fr.WalexFelwin.OktaliaGrades.Main;


public class GradesQuitt implements Listener{
	
	public GradesQuitt(Main main){
		
	}
	
	@EventHandler
	public void playerquitt(PlayerQuitEvent e){

	    Player p = e.getPlayer();
	
	    String grades = HASHMAP.Grades.get(p);
	    UnReloadGrades.UnReloadRank(p, grades);
	    
	}
	
}
