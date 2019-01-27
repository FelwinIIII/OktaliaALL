package fr.walexmine.OktaliaMine.API;

import java.sql.ResultSet;

import org.bukkit.entity.Player;

import fr.walexmine.OktaliaMine.SQL.Update;

public class API_Joueur {
	
	
	public static void CreateProfil(Player p) {
		
	    boolean exist = false;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `id` FROM `InfoMine` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	      Update.Update("INSERT INTO `InfoMine` (`UUID`, `Pseudo`, `Level`, `EXP`, `TEMPS`) VALUES ('" + p.getUniqueId()+ "', '" + p.getName() +"', '1', '0', '0')");
	    }
	    
	}

	
	  public static void SetLVL(Player p, Integer s)
	  {
		  int i = s;
		  
		Update.Update("UPDATE `InfoMine` SET `Level`='" + i + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  
	  public static Integer getlevel(Player p)
	  {
		  Integer i = null;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `Level` FROM `InfoMine` WHERE `UUID`='" + p.getUniqueId() + "'");
		      while (rs.next()) {
		        i = rs.getInt(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return i;
	  }
	  
	  

		
	  public static void SetEXP(Player p, Integer s)
	  {
		  int i = s;
		  
		Update.Update("UPDATE `InfoMine` SET `EXP`='" + i + "' WHERE `UUID`='" + p.getUniqueId() + "'");
		
	  }
	  
	  public static int getEXP(Player p)
	  {
		  int i = 0;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `EXP` FROM `InfoMine` WHERE `UUID`='" + p.getUniqueId() + "'");
		      while (rs.next()) {
		    	  String inventory;
		        i = rs.getInt(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return i;
	  }
	  
	  
	  public static void addTIME(Player p, long s)
	  {

		  long i = Long.parseLong(API_Temps.TIME.get(p))+s;
		  
		Update.Update("UPDATE `InfoMine` SET `TEMPS`='" + i + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  public static long getTIME(Player p)
	  {
		 long i = 0;
		 
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `TEMPS` FROM `InfoMine` WHERE `UUID`='" + p.getUniqueId() + "'");
		      while (rs.next()) {
		    	  String inventory;
		        i = rs.getLong(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return i;
	  }

}
