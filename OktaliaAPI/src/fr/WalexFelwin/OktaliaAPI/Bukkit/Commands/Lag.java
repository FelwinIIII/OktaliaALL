package fr.WalexFelwin.OktaliaAPI.Bukkit.Commands;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.minecraft.server.v1_8_R3.MinecraftServer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Ping;

public class Lag implements CommandExecutor{
	

	 
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    String date = new SimpleDateFormat("d/MMMMM/y / HH:mm:ss").format(new Date(System.currentTimeMillis()));
	    if (label.equalsIgnoreCase("lag"))
	    {                  
	    	//double TPS = fr.walexmine.luminacyGrades.Update.Lag.getTPS();
	    		DecimalFormat TpsFormat = new DecimalFormat("#.##");
	    	 StringBuilder sb = new StringBuilder( ChatColor.GOLD + "TPS from last 1m, 5m, 15m: §a" );
	         for ( double tps : MinecraftServer.getServer().recentTps )
	         {
	             sb.append(TpsFormat( tps ) );
	             sb.append( ", " );
	         }
	        int pingchek = API_Ping.getPing(p);
	    	String ping = null;

	    	if(pingchek > 500){
	    		ping = "§c"+pingchek;
	    	} else if(pingchek > 200){
	    		ping = "§6"+pingchek;
	    	} else if(pingchek > 100){
	    		ping = "§e"+pingchek;
	    	} else {
	    		ping = "§a"+pingchek;
	    	}
	    	
	        p.sendMessage("§b--------------------------------------------");
	        p.sendMessage("§7Serveur: §a"+Bukkit.getServerName()+" §eDate: "+date);
	        p.sendMessage("§7Votre Temps de réponse avec le serveur");
	        p.sendMessage("§6Votre latence avec le serveur "+ping+" §6ms");
	        p.sendMessage("§7Les TPS serveur indiquent si le serveur lag :§a *20 §f= §bAucun lag");
		    p.sendMessage( sb.substring( 0, sb.length() - 2 ) );
	        p.sendMessage("§cSi les TPS sont en dessous de 19.50 ");
	        p.sendMessage("§cScreen le message et contact un développeur du serveur.");
	        p.sendMessage("§b--------------------------------------------");
	    }
	    return true;
	  }

	private Object TpsFormat(double tps) {
		// TODO Auto-generated method stub
  	DecimalFormat TpsFormat = new DecimalFormat("#.##");
  	String tps2 = null;
  	String tps3 = ""+TpsFormat.format(tps);
  	
     	if(tps > 20.0){
  		tps2 = "*20.0";
  	} else if(tps3.equalsIgnoreCase("20")){
     		tps2 = "20.0";
     	} else {
  		tps2 = TpsFormat.format(tps);
  	}
		return tps2;
	}
}