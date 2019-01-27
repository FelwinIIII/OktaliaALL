package fr.WalexFelwin.OktaliaAPI.BungeeCord.API;

import java.sql.ResultSet;
import java.util.UUID;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Update;


public class API_Coins {

	
	  public static String getuuid(String UUIDname)
	  {
		    String end = "";
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `UUID` FROM `InfoOktaCoins` WHERE `Pseudo`='" + UUIDname + "'");
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
	  
	  public static float getoktacoins(UUID p)
	  {
		  float c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `OktaCoins` FROM `InfoOktaCoins` WHERE `UUID`='" + p + "'");
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
	  
	  public static void removeoktacoins(UUID p, float c2)
	  {
		  float c = getoktacoins(p);
	    c -= c2;
	    Update.Update("UPDATE `InfoOktaCoins` SET `OktaCoins`='" + c + "' WHERE `UUID`='" + p + "'");
	  }
	  
	  public static void addoktacoins(UUID p, float coins)
	  {
		  float c = getoktacoins(p);
	    c += coins;
	    Update.Update("UPDATE `InfoOktaCoins` SET `OktaCoins`='" + c + "' WHERE `UUID`='" + p + "'");
	  }
	  
	  public static void setoktacoins(UUID p, float coins)
	  {
		  float c = 0;
	    c = coins;
	    Update.Update("UPDATE `InfoOktaCoins` SET `OktaCoins`='" + c + "' WHERE `UUID`='" + p + "'");
	  }

	  
	  public static float getBoutiquecoins(UUID p)
	  {
		  float c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `OktaCoins` FROM `InfoOktaCoins` WHERE `UUID`='" + p + "'");
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
	  
	  public static void removeBoutiquecoins(UUID p, float c2)
	  {
		  float c = getBoutiquecoins(p);
	    c -= c2;
	    Update.Update("UPDATE `InfoOktaCoins` SET `BoutiqueCoins`='" + c + "' WHERE `UUID`='" + p + "'");
	  }
	  
	  public static void addBoutiquecoins(UUID p, float coins)
	  {
		  float c = getBoutiquecoins(p);
	    c += coins;
	    Update.Update("UPDATE `InfoOktaCoins` SET `BoutiqueCoins`='" + c + "' WHERE `UUID`='" + p + "'");
	  }
	  
	  public static void setBoutiquecoins(UUID p, float coins)
	  {
		  float c = 0;
	    c = coins;
	    Update.Update("UPDATE `InfoOktaCoins` SET `BoutiqueCoins`='" + c + "' WHERE `UUID`='" + p + "'");
	  }
	
	
}
