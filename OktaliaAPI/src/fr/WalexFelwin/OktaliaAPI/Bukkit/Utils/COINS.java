package fr.WalexFelwin.OktaliaAPI.Bukkit.Utils;


import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;


public class COINS {
	

	  public static boolean isOFF(Player p)
	  {
		  return Main.getInstance().COINSLOAD;
	  }
	  
	  public static float getoktacoins(Player p)
	  {
		  float c = HASHMAP.Coins.get(p);

	    return c;
	  }
	  
	  public static void removeoktacoins(Player p, float coins)
	  {
		  
		  float c = getoktacoins(p);
		  
		  c -= coins;
		  HASHMAP.Coins.put(p, c);
	  }
	  
	  public static void addoktacoins(Player p, float coins) 
	  {
		  float c = getoktacoins(p);
		  c += coins;
		  HASHMAP.Coins.put(p, c);
	  }
	  
	  public static void setoktacoins(Player p, float coins)
	  {
		  float c = getoktacoins(p);
		  c = coins;
		  HASHMAP.Coins.put(p, c);
	  }

	  
	  public static float getBoutiquecoins(Player p)
	  {
		  float c = HASHMAP.CoinsBoutique.get(p);

	    return c;
	  }
	  
	  public static void removeBoutiquecoins(Player p, float coins)
	  {
		  float c = getBoutiquecoins(p);
		  c -= coins;
		  HASHMAP.CoinsBoutique.put(p, c);
	  }
	  
	  public static void addBoutiquecoins(Player p, float coins)
	  {
		  float c = getBoutiquecoins(p);
		  c += coins;
		  HASHMAP.CoinsBoutique.put(p, c);
	  }
	  
	  public static void setBoutiquecoins(Player p, float coins)
	  {
		  float c = getBoutiquecoins(p);
		  c = coins;
		  HASHMAP.CoinsBoutique.put(p, c);
	  }

}
