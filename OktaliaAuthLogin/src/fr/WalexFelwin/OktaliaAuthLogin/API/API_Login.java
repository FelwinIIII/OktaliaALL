package fr.WalexFelwin.OktaliaAuthLogin.API;

import java.sql.ResultSet;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import fr.WalexFelwin.OktaliaAuthLogin.MySql.Update;

public class API_Login
implements Listener
{
	  public static int getlogindeco(String p)
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
	  
	  public static int getregisterdeco(String p)
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
	  
	/*
	 * 
	 * 
	 * 
	 */
	  
	  public static double getvie(Player p)
	  {
		  double c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Vie` FROM `InfoLogin` WHERE `Pseudo`='" + p.getName() + "'");
	      while (rs.next()) {
	        c = rs.getDouble(1);
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.print(err);
	      err.printStackTrace();
	    }
	    return c;
	  }
	  
	  public static void setvie(Player p, double d)
	  {
		  double c = getvie(p);
		  double a = 0;
	    c = a + d;
	    Update.Update("UPDATE `InfoLogin` SET `Vie`='" + c + "' WHERE `Pseudo`='" + p.getName() + "'");
	  }
	  
	  
	  public static int getfeed(Player p)
	  {
		  int c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Feed` FROM `InfoLogin` WHERE `Pseudo`='" + p.getName() + "'");
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
	  
	  public static void setfeed(Player p, int z)
	  {
		  int c = getfeed(p);
		  int a = 0;
	    c = a + z;
	    Update.Update("UPDATE `InfoLogin` SET `Feed`='" + c + "' WHERE `Pseudo`='" + p.getName() + "'");
	  }
	  
	  
	  
	  
	  //**
	  
public static int getregister(Player p)
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

public static void setregister(Player p, int z)
{
  int c = getregister(p);
  int a = 0;
  c = a + z;
  Update.Update("UPDATE `InfoLogin` SET `Register`='" + c + "' WHERE `Pseudo`='" + p.getName() + "'");
}

public static int getlogin(Player p)
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

public static void setlogin(Player p, int z)
{
  int c = getlogin(p);
  int a = 0;
  c = a + z;
  Update.Update("UPDATE `InfoLogin` SET `Login`='" + c + "' WHERE `Pseudo`='" + p.getName() + "'");
}

public static String getmotsdepasse(Player p)
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

public static void setmotsdepasse(Player p, String reason)
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

//



	public static float getX(Player s)
	  {
	    float c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `X` FROM `InfoLogin` WHERE `Pseudo`='" + s.getName() + "'");
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
	  
public static void setx(Player s, double d)
{
	double c = getX(s);
	double a = 0;
  c = a + d;
  Update.Update("UPDATE `InfoLogin` SET `X`='" + c + "' WHERE `Pseudo`='" + s.getName() + "'");
}
	public static float getY(Player s)
	  {
	    float c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Y` FROM `InfoLogin` WHERE `Pseudo`='" + s.getName() + "'");
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
	  
	 
	  public static void sety(Player s, double y)
	  {
		  double c = getY(s);
		  double a = 0;
	    c = a + y;
	    Update.Update("UPDATE `InfoLogin` SET `Y`='" + c + "' WHERE `Pseudo`='" + s.getName() + "'");
	  }
	  
	  public static float getZ(Player s)
	  {
	    float c = 0;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Z` FROM `InfoLogin` WHERE `Pseudo`='" + s.getName() + "'");
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
	  
	 
	  public static void setz(Player s, double z)
	  {
		  double c = getZ(s);
		  double a = 0;
	    c = a + z;
	    Update.Update("UPDATE `InfoLogin` SET `Z`='" + c + "' WHERE `Pseudo`='" + s.getName() + "'");
	  }
	  
	  public static String getWorld(Player p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `World` FROM `InfoLogin` WHERE `Pseudo`='" + p.getName() + "'");
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
	  
	  public static void setWorld(Player p, String string)
	  {
	    String c = "";
	    String a = "";
	    c = a + string;
	    Update.Update("UPDATE `InfoLogin` SET `World`='" + c + "' WHERE `Pseudo`='" + p.getName() + "'");
	  }
		 
		  
		 
}