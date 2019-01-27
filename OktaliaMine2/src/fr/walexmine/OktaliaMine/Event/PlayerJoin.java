package fr.walexmine.OktaliaMine.Event;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.walexmine.OktaliaMine.Main;
import fr.walexmine.OktaliaMine.API.API_Inventory;
import fr.walexmine.OktaliaMine.API.API_Joueur;
import fr.walexmine.OktaliaMine.API.API_Temps;
import fr.walexmine.OktaliaMine.Inventaire.Minage;
import fr.walexmine.OktaliaMine.Inventaire.Reserve;
import fr.walexmine.OktaliaMine.Inventaire.minestats;
import fr.walexmine.OktaliaMine.Inventaire.StatsMine.Stats;

public class PlayerJoin implements Listener{
	
	public PlayerJoin(Main main) {
		
	}


	@EventHandler
	public void playerjoin (PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		API_Inventory.CreateProfil(p);
		API_Joueur.CreateProfil(p);
		
		Minage.itemSpawn(p);

		Stats.EXP.put(p, API_Joueur.getEXP(p));
		Stats.LEVEL.put(p, API_Joueur.getlevel(p));
		API_Temps.TIMECO.put(p, ""+System.currentTimeMillis());
		API_Temps.TIME.put(p, ""+API_Joueur.getTIME(p));
		
		
		String invinit = API_Inventory.getReserveMine(""+p.getUniqueId());
		Inventory inv = null;
		try {
			inv = API_Inventory.fromBase64(invinit);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(inv != null) {
			
			Inventory inv2 = Bukkit.createInventory(null, 36, "§eReserve Minage");
			inv2.setContents(inv.getContents());
				PlayerBreak.ReserveM.put(p, inv2);
	
		}
	
	}
	

}
