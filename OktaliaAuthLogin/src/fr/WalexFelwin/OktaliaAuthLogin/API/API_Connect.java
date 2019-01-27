package fr.WalexFelwin.OktaliaAuthLogin.API;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class API_Connect {

	
	
	  
	  public static void connectTo(Player p, String servername)
	  {
	    ByteArrayDataOutput out = ByteStreams.newDataOutput();
	    out.writeUTF("Connect");
	    out.writeUTF(servername);
	    
	    p.sendPluginMessage(Bukkit.getPluginManager().getPlugin("OktaliaLogin"), "BungeeCord", out.toByteArray());
	  }
}
