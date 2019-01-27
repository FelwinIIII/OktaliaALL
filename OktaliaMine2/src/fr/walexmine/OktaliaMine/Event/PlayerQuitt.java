package fr.walexmine.OktaliaMine.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.walexmine.OktaliaMine.Main;
import fr.walexmine.OktaliaMine.API.API_Inventory;
import fr.walexmine.OktaliaMine.API.API_Joueur;
import fr.walexmine.OktaliaMine.API.API_Temps;
import fr.walexmine.OktaliaMine.Inventaire.Reserve;
import fr.walexmine.OktaliaMine.Inventaire.StatsMine.Stats;

public class PlayerQuitt implements Listener {
	
	public PlayerQuitt(Main main) {
		
	}

	@EventHandler
	public void PlayerQuitt(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();

			
			API_Inventory.saveReserveMine(p, API_Inventory.toBase64(PlayerBreak.ReserveM.get(p)));

			long timeco = Long.parseLong(API_Temps.TIMECO.get(p));
			long timenow = System.currentTimeMillis();
			
			long timesession = timenow - timeco;
			
			API_Joueur.addTIME(p, timesession);


			API_Joueur.SetEXP(p, Stats.EXP.get(p));
			API_Joueur.SetLVL(p, Stats.LEVEL.get(p));
			
			
			Stats.EXP.remove(p);
			Stats.LEVEL.remove(p);
	}
	

}
