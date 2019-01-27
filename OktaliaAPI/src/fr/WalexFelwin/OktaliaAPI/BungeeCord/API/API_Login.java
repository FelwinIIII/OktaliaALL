package fr.WalexFelwin.OktaliaAPI.BungeeCord.API;

import java.sql.ResultSet;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Update;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class API_Login {
	
	  public static int getprenium(ProxiedPlayer p)
	  {
	    int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `premium` FROM `InfoPrenium` WHERE `UUID`='" + p.getUniqueId() + "'");
	      while (rs.next()) {
	        c = rs.getInt(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.print(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	
	  public static int getregister(ProxiedPlayer p)
	  {
	    int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Register` FROM `InfoLogin` WHERE `Pseudo`='" + p.getName() + "'");
	      while (rs.next()) {
	        c = rs.getInt(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.print(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	  public static void setregister(ProxiedPlayer p, int z)
	  {
	    int c = getregister(p);
	    int a = 0;
	    c = a + z;
	    Update.Update("UPDATE `InfoLogin` SET `Register`='" + c + "' WHERE `Pseudo`='" + p.getName() + "'");
	  }
	  
	  public static int getlogin(ProxiedPlayer p)
	  {
	    int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Login` FROM `InfoLogin` WHERE `Pseudo`='" + p.getName() + "'");
	      while (rs.next()) {
	        c = rs.getInt(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.print(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	  public static void setlogin(ProxiedPlayer p, int z)
	  {
	    int c = getlogin(p);
	    int a = 0;
	    c = a + z;
	    Update.Update("UPDATE `InfoLogin` SET `Login`='" + c + "' WHERE `Pseudo`='" + p.getName() + "'");
	  }
	  
	  public static String getmotsdepasse(ProxiedPlayer p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `motsdepasse` FROM `InfoLogin` WHERE `Pseudo`='" + p.getName() + "'");
	      while (rs.next()) {
	        c = rs.getString(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.print(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	  public static void setmotsdepasse(ProxiedPlayer p, String reason)
	  {
	    String c = "";
	    String a = "";
	    c = a + reason;
	    Update.Update("UPDATE `InfoLogin` SET `motsdepasse`='" + c + "' WHERE `Pseudo`='" + p.getName() + "'");
	  }
	  /*
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   */
	  public static int getregisterstring(String p)
	  {
	    int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Register` FROM `InfoLogin` WHERE `Pseudo`='" + p + "'");
	      while (rs.next()) {
	        c = rs.getInt(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.print(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  

	  public static int getloginstring(String p)
	  {
	    int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Login` FROM `InfoLogin` WHERE `Pseudo`='" + p + "'");
	      while (rs.next()) {
	        c = rs.getInt(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.print(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  

	  public static String getip(String p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `IP` FROM `InfoLogin` WHERE `Pseudo`='" + p + "'");
	      while (rs.next()) {
	        c = rs.getString(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.print(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	  public static void setip(String p, String reason)
	  {
	    String c = "";
	    String a = "";
	    c = a + reason;
	    Update.Update("UPDATE `InfoLogin` SET `IP`='" + c + "' WHERE `Pseudo`='" + p + "'");
	  }
}
