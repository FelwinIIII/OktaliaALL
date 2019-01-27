package fr.WalexFelwin.OktaliaHub.ScoreBoard;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Scoreboard;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.COINS;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;
import fr.WalexFelwin.OktaliaGrades.Chat_Tab.ChatUtils;

public class Scoreboard {

	public static Map<Player, API_Scoreboard> sslist = new HashMap<Player, API_Scoreboard>();

	
	public static void Scoreboardstart(Player p){
		
		
		API_Scoreboard sb = new API_Scoreboard(p, "ScoreBoard1");
		sb.create();
		sb.setObjectiveName(" §6§lOKTALIA §f§lNETWORK ");

		sb.setLine(9, "§9");
		sb.setLine(8, "§b§lInfo:");
		sb.setLine(7, "§aOktaCoins: §e"+COINS.getoktacoins(p)+" §6$");
		sb.setLine(6, "§fGrade: §7"+grades(p));
		sb.setLine(5, "§§   ");
		sb.setLine(4, "§fServeur: §a"+Bukkit.getServerName());
		sb.setLine(3, "§fJoueurs: §6§l"+Bukkit.getOnlinePlayers().size());
		sb.setLine(2, "§c   ");
		sb.setLine(1, "§6play.oktalia.fr");
		
		sslist.put(p, sb); 
	}
	
	
	public static String grades(Player p){
		
		String grades = ""+HASHMAP.Grades.get(p);
		if (grades.equalsIgnoreCase("developpeur")){
			  return ChatUtils.getdeveloppeurprefix();
		  }
		  else if (grades.equalsIgnoreCase("gerant")){
			  return ChatUtils.getgerantprefix();
		  }
		  else if (grades.equalsIgnoreCase("admin")){
			  return ChatUtils.getadminprefix();
		  }
		  else if (grades.equalsIgnoreCase("manager")){
			  return ChatUtils.getmanagerprefix();
		  }
		  else if (grades.equalsIgnoreCase("buildeur")){
			  return ChatUtils.builderprefix();
		  }
		  else if (grades.contains("youtubeur")){
			  return ChatUtils.getyoutubeurprefix();
		  }
		  else if (grades.equalsIgnoreCase("ami")){
			  return ChatUtils.amiprefix();
		  } 
		  else if (grades.equalsIgnoreCase("moderateur")){
			  return ChatUtils.getmodoprefix();
		  } 
		  else if (grades.equalsIgnoreCase("moderatrice")){
			  return ChatUtils.getmodaprefix();
		  }  
		  else if (grades.equalsIgnoreCase("VIP")){
			  return ChatUtils.getVIPprefix();
		  }
		  else {
				return "§7Joueur";
		  }
		
	}
}
