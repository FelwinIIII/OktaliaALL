package fr.WalexFelwin.OktaliaAPI.Bukkit.Event;

import java.sql.ResultSet;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Update;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_OktaCoins;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;


public class PlayerJoin implements Listener{
	
	
	public PlayerJoin(Main main) {
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public static void Playerj(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		RegisterCoins(p);
		
		if(Main.COINSLOAD == false) {
		
			return;
		}
		
		HASHMAP.Coins.put(p, API_OktaCoins.getoktacoins(p));
		HASHMAP.CoinsBoutique.put(p, API_OktaCoins.getBoutiquecoins(p));
	}	public PlayerJoin() {
		// TODO Auto-generated constructor stub
	}
	@EventHandler
	public static void playerq(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();


		if(Main.COINSLOAD == false) {
		
			return;
		}
		

		API_OktaCoins.setoktacoins(p, HASHMAP.Coins.get(p));
		API_OktaCoins.setBoutiquecoins(p, HASHMAP.CoinsBoutique.get(p));
	}
	
	public static void RegisterCoins(Player p ) {
	    boolean exist = false;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `id` FROM `InfoOktaCoins` WHERE `UUID`='" + p.getUniqueId() + "'");
	      while (rs.next()) {
	    	  
	        exist = Boolean.valueOf(true).booleanValue();
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.println(err);
	      err.printStackTrace();
	    }
	    if (!exist) {
	      Update.Update("INSERT INTO `InfoOktaCoins` (`UUID`, `Pseudo`, `OktaCoins`, `BoutiqueCoins`) VALUES ('" + p.getUniqueId()+ "', '" + p.getName() + "', '0', '0')");
	    }
	}
}
