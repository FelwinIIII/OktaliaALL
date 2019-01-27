package fr.WalexFelwin.OktaliaAPI.Bukkit.API;

import java.sql.ResultSet;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Update;

public class API_Grades {

	  
	  public static String getgrades(UUID uuid)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Grades` FROM `InfoGrades` WHERE `UUID`='" + uuid + "'");
	      while (rs.next()) {
	        c = rs.getString(1);

	      }
	    }
	    catch (Exception err)
	    {
	      System.err.println(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	  public static void setgrades(UUID uuid, String setgrades)
	  {
		  
		String status = "UNban";
		status = setgrades;
		Update.Update("UPDATE `InfoGrades` SET `Grades`='" + status + "' WHERE `UUID`='" + uuid + "'");
	  }
	  
	  
	  
	  
	  public static long getEnd(String playername)
	  {
		    long end = -1L;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `Temps` FROM `InfoGrades` WHERE `UUID`='" + playername + "'");
		      while (rs.next()) {
		        end = rs.getLong(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return end;
	  }
	  
	  
	  
	  public static void setend(String p, Long long1)
	  {
		  
		    long c = getEnd(p);
		    long a = 0;
		    c = a + long1;
		Update.Update("UPDATE `InfoGrades` SET `Temps`='" + c + "' WHERE `UUID`='" + p + "'");
	  }
	  
	  public static void register(Player p){
		    boolean exist = false;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `Temps` FROM `InfoGrades` WHERE `UUID`='" + p.getUniqueId() + "'");
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
		      Update.Update("INSERT INTO `InfoGrades` (`UUID`, `Pseudo`, `Grades`, `Temps`) VALUES ('" + p.getUniqueId()+ "', '" + p.getName() + "', 'joueur', '0')");
		    }
			
	  }
	  
	  
	  

}


