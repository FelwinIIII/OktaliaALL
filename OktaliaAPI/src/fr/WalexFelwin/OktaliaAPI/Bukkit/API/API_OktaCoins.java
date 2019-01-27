package fr.WalexFelwin.OktaliaAPI.Bukkit.API;

import java.sql.ResultSet;

import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Update;


public class API_OktaCoins {
	
	  public static String getuuid(String playername)
	  {
		    String end = "";
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `UUID` FROM `InfoOktaCoins` WHERE `Pseudo`='" + playername + "'");
		      while (rs.next()) {
		        end = rs.getString(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return end;
	  }
	  
	  public static float getoktacoins(Player p)
	  {
		  float c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `OktaCoins` FROM `InfoOktaCoins` WHERE `UUID`='" + p.getUniqueId() + "'");
	      while (rs.next()) {
	        c = rs.getFloat(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.print(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	  public static void removeoktacoins(Player p, float c2)
	  {
		  float c = getoktacoins(p);
	    c -= c2;
	    Update.Update("UPDATE `InfoOktaCoins` SET `OktaCoins`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  public static void addoktacoins(Player p, float coins)
	  {
		  float c = getoktacoins(p);
	    c += coins;
	    Update.Update("UPDATE `InfoOktaCoins` SET `OktaCoins`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  public static void setoktacoins(Player p, float coins)
	  {
		  float c = 0;
	    c = coins;
	    Update.Update("UPDATE `InfoOktaCoins` SET `OktaCoins`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }

	  
	  public static float getBoutiquecoins(Player p)
	  {
		  float c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `OktaCoins` FROM `InfoOktaCoins` WHERE `UUID`='" + p.getUniqueId() + "'");
	      while (rs.next()) {
	        c = rs.getFloat(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.print(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	  public static void removeBoutiquecoins(Player p, float c2)
	  {
		  float c = getBoutiquecoins(p);
	    c -= c2;
	    Update.Update("UPDATE `InfoOktaCoins` SET `BoutiqueCoins`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  public static void addBoutiquecoins(Player p, float coins)
	  {
		  float c = getBoutiquecoins(p);
	    c += coins;
	    Update.Update("UPDATE `InfoOktaCoins` SET `BoutiqueCoins`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  public static void setBoutiquecoins(Player p, float coins)
	  {
		  float c = 0;
	    c = coins;
	    Update.Update("UPDATE `InfoOktaCoins` SET `BoutiqueCoins`='" + c + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }

	  
 
}
