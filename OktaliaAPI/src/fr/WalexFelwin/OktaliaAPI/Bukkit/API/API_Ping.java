package fr.WalexFelwin.OktaliaAPI.Bukkit.API;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class API_Ping {

	
	  public static int getPing(Player player)
	  {
	    try
	    {
	      int ping = 0;
	      Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + getServerVersion() + ".entity.CraftPlayer");
	      Object converted = craftPlayer.cast(player);
	      Method handle = converted.getClass().getMethod("getHandle", new Class[0]);
	      Object entityPlayer = handle.invoke(converted, new Object[0]);
	      Field pingField = entityPlayer.getClass().getField("ping");
	      return pingField.getInt(entityPlayer);
	    }
	    catch (Exception ex)
	    {
	      ex.printStackTrace();
	    }
	    return 0;
	  }
	  
	  public static String getServerVersion()
	  {
	    Pattern brand = Pattern.compile("(v|)[0-9][_.][0-9][_.][R0-9]*");
	    String pkg = Bukkit.getServer().getClass().getPackage().getName();
	    String version = pkg.substring(pkg.lastIndexOf('.') + 1);
	    if (!brand.matcher(version).matches()) {
	      version = "";
	    }
	    return version;
	  }
	
	
	/*
	  public static int getPing(Player p)
	  {
		 
	    String bpName = Bukkit.getServer().getClass().getPackage().getName();
	    String version = bpName.substring(bpName.lastIndexOf(".") + 1, bpName.length());
	    try
	    {
	      Class<?> CPClass = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
	      Object CraftPlayer = CPClass.cast(p);
	      
	      Method getHandle = CraftPlayer.getClass().getMethod("getHandle", new Class[0]);
	      Object EntityPlayer = getHandle.invoke(CraftPlayer, new Object[0]);
	      
	      Field ping = EntityPlayer.getClass().getDeclaredField("ping");
	      
	      return ping.getInt(EntityPlayer);
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    return 0;
	  }*/
}
