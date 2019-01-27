package fr.walexmine.OktaliaMascotte.API_Mascotte;

import java.sql.ResultSet;
import java.util.UUID;

import net.minecraft.server.v1_8_R3.NBTTagCompound;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftBlaze;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftWither;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;

import fr.walexmine.OktaliaMascotte.Commands.Mascote;
import fr.walexmine.OktaliaMascotte.Update.Update;


public class API_Mascote {

	public static void Witherriding(Player p){
		
		
		Location wloc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()+2, p.getLocation().getZ());
		
	      
		org.bukkit.entity.Entity as = ((World)Bukkit.getWorld(""+p.getWorld().getName())).spawnEntity(wloc, EntityType.WITHER);
	
	      
	      Wither Wither = (Wither)as;
	      
	      // Mini Wither !
	      //NOAI
	      ((CraftWither)as).getHandle().r(600); 
	      
	      net.minecraft.server.v1_8_R3.Entity nmsEntity = ((CraftEntity) as).getHandle();
	      Mascote.MascoteWither.put(p, as.getUniqueId());
          NBTTagCompound tag = nmsEntity.getNBTTag();
          if (tag == null) {
              tag = new NBTTagCompound();
          }
          nmsEntity.c(tag);
          tag.setInt("Invul", 600);
		  tag.setInt("NoAI", 1);
          nmsEntity.f(tag);
          //
	}
	public static void BlazeSpawn(Player p){
		
		
		Location wloc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()+2, p.getLocation().getZ());
		
	      
		org.bukkit.entity.Entity as = ((World)Bukkit.getWorld(""+p.getWorld().getName())).spawnEntity(wloc, EntityType.BLAZE);
	
	      
	      Blaze Blaze = (Blaze)as;
	      
	      // Mini Wither !
	      //NOAI

	      net.minecraft.server.v1_8_R3.Entity nmsEntity = ((CraftEntity) as).getHandle();
	      Mascote.MascoteBlaze.put(p, as.getUniqueId());
          NBTTagCompound tag = nmsEntity.getNBTTag();
          if (tag == null) {
              tag = new NBTTagCompound();
          }
          nmsEntity.c(tag);
          tag.setInt("Invul", 600);
		  tag.setInt("NoAI", 1);
          nmsEntity.f(tag);
          //
	}
	public static void LoupSpawn(Player p){
		
		
		Location wloc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()+2, p.getLocation().getZ());
		
	      
		org.bukkit.entity.Entity as = ((World)Bukkit.getWorld(""+p.getWorld().getName())).spawnEntity(wloc, EntityType.WOLF);
	
	      

	      //NOAI

	      net.minecraft.server.v1_8_R3.Entity nmsEntity = ((CraftEntity) as).getHandle();
	      Mascote.MascoteLoup.put(p, as.getUniqueId());
          NBTTagCompound tag = nmsEntity.getNBTTag();
          if (tag == null) {
              tag = new NBTTagCompound();
          }
          nmsEntity.c(tag);
          tag.setInt("Invul", 600);
		  tag.setInt("NoAI", 1);
          nmsEntity.f(tag);
          //
	}
	
	public static void GolemSpawn(Player p){
		
		
		Location wloc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()+2, p.getLocation().getZ());
		
	      
		org.bukkit.entity.Entity as = ((World)Bukkit.getWorld(""+p.getWorld().getName())).spawnEntity(wloc, EntityType.IRON_GOLEM);
	
	      
		IronGolem golem = (IronGolem)as;

	      //NOAI

	      net.minecraft.server.v1_8_R3.Entity nmsEntity = ((CraftEntity) as).getHandle();
	      Mascote.MascoteGolem.put(p, as.getUniqueId());
          NBTTagCompound tag = nmsEntity.getNBTTag();
          if (tag == null) {
              tag = new NBTTagCompound();
          }
          nmsEntity.c(tag);
          tag.setInt("Invul", 600);
		  tag.setInt("NoAI", 1);
          nmsEntity.f(tag);
          //
	}
	
	  public static long gettempsblaze(Player p)
	  {
		    long end = -1L;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `TempsBlaze` FROM `InfoMascotte` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  
	  
	  public static void settempsblaze(Player p, Long long1)
	  {
		  
		    long c = gettempsblaze(p);
		    long a = 0;
		    c = a + long1;
		Update.Update("UPDATE `InfoMascotte` SET `FinDuBan`='" + c + "' WHERE `UUID`='" +p.getUniqueId() + "'");
	  }
	  
	  public static long gettempswither(Player p)
	  {
		    long end = -1L;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `TempsWither` FROM `InfoMascotte` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  
	  
	  public static void settempswither(Player p, Long long1)
	  {
		  
		    long c = gettempswither(p);
		    long a = 0;
		    c = a + long1;
		Update.Update("UPDATE `InfoMascotte` SET `TempsWither`='" + c + "' WHERE `UUID`='" +p.getUniqueId() + "'");
	  }
	  
	  public static void settempswitherdeco(UUID p, Long long1)
	  {
		  long c = 0;
		    long a = 0;
		    c = a + long1;
		Update.Update("UPDATE `InfoMascotte` SET `TempsWither`='" + c + "' WHERE `UUID`='" +p + "'");
	  }

	  
	  public static String getwither(Player p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Wither` FROM `InfoMascotte` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  
	  
	  public static void setwither(Player p, String setraison)
	  {
		  
		String status = "UNban";
		status = setraison;
		Update.Update("UPDATE `InfoMascotte` SET `Wither`='" + status + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }	  
	  
	  
	  public static void setwitherdeco(UUID p, String setraison)
	  {
		  
		String status = "UNban";
		status = setraison;
		Update.Update("UPDATE `InfoMascotte` SET `Wither`='" + status + "' WHERE `UUID`='" + p + "'");
	  }
	  
	  public static String getblaze(Player p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Blaze` FROM `InfoMascotte` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  
	  
	  public static void setblaze(Player p, String setraison)
	  {
		  
		String status = "UNban";
		status = setraison;
		Update.Update("UPDATE `InfoMascotte` SET `Blaze`='" + status + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  public static String getgolem(Player p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Golem` FROM `InfoMascotte` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  
	  
	  public static void setgolem(Player p, String setraison)
	  {
		  
		String status = "UNban";
		status = setraison;
		Update.Update("UPDATE `InfoMascotte` SET `Golem`='" + status + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  public static void setgolemdeco(UUID p, String setraison)
	  {
		  
		String status = "UNban";
		status = setraison;
		Update.Update("UPDATE `InfoMascotte` SET `Golem`='" + status + "' WHERE `UUID`='" + p + "'");
	  }
	  
	  public static String getloup(Player p)
	  {
	    String c = "";
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `Loup` FROM `InfoMascotte` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  

	  public static void setloup(Player p, String setraison)
	  {
		  
		String status = "UNban";
		status = setraison;
		Update.Update("UPDATE `InfoMascotte` SET `Loup`='" + status + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  public static void setloupdeco(UUID p, String setraison)
	  {
		  
		String status = "UNban";
		status = setraison;
		Update.Update("UPDATE `InfoMascotte` SET `Loup`='" + status + "' WHERE `UUID`='" + p + "'");
	  }
	  

	  public static long gettempsgolem(Player p)
	  {
		    long end = -1L;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `TempsGolem` FROM `InfoMascotte` WHERE `UUID`='" + p.getUniqueId() + "'");
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

	  
	  
	  public static void settempsgolem(Player p, Long long1)
	  {
		  
		    long c = 0;
		    long a = 0;
		    c = a + long1;
		Update.Update("UPDATE `InfoMascotte` SET `TempsGolem`='" + c + "' WHERE `UUID`='" +p.getUniqueId()+ "'");
	  }
	  
	  
	  public static void settempsgolemdeco(UUID p, Long long1)
	  {
		  
		    long c = 0;
		    long a = 0;
		    c = a + long1;
		Update.Update("UPDATE `InfoMascotte` SET `TempsGolem`='" + c + "' WHERE `UUID`='" +p+ "'");
	  }
	  
	  public static long gettempsloup(Player p)
	  {
		    long end = -1L;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `TempsLoup` FROM `InfoMascotte` WHERE `UUID`='" + p.getUniqueId() + "'");
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
	  
	  
	  
	  public static void settempsloup(Player p, Long long1)
	  {
		  
		    long c = gettempswither(p);
		    long a = 0;
		    c = a + long1;
		Update.Update("UPDATE `InfoMascotte` SET `TempsLoup`='" + c + "' WHERE `UUID`='" +p.getUniqueId() + "'");
	  }  
	  public static void settempsloupdeco(UUID p, Long long1)
	  {
		  
		    long c = 0;
		    long a = 0;
		    c = a + long1;
		Update.Update("UPDATE `InfoMascotte` SET `TempsLoup`='" + c + "' WHERE `UUID`='" +p + "'");
	  }

	  
	
}
