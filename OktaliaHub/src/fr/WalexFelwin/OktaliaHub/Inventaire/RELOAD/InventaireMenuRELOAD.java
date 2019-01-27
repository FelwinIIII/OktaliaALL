package fr.WalexFelwin.OktaliaHub.Inventaire.RELOAD;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerInfo;
import fr.WalexFelwin.OktaliaHub.Inventaire.MenuPrincipale;

public class InventaireMenuRELOAD extends BukkitRunnable
{
	  public void run()
	  {
	    for (Player p :  MenuPrincipale.InvMenu.keySet()) {
	      if ((p.getOpenInventory().getTopInventory() != null) && (p.getOpenInventory().getTopInventory().getTitle().startsWith("§aMenu Principal")))
	      {
	        //String o = serveurup.getOpenInventory().getTopInventory().getName().split("> ")[1];
	    	  


			         
			         int playerFaction;
			         ServerInfo Factions = Main.getInstance().getPingAPI().getServer("Faction");
			         Factions.pingToServer();
			         playerFaction = Factions.getPlayerCount() ;			  
			         
					  int playerMinage;
				         ServerInfo Minages = Main.getInstance().getPingAPI().getServer("Minage");
				         Minages.pingToServer();
				         playerMinage = Minages.getPlayerCount() ;

				         String SOnlineF = (Factions.isOnline() ? "§a§lEn Ligne" : "§c§lDéconnectée");
				         String SOnlineM = (Minages.isOnline() ? "§a§lEn Ligne" : "§c§lDéconnectée");

						 ArrayList<String> Faction = new ArrayList();
						 Faction.add("");
						 Faction.add("§8§l FACTIONS §7| §e§l★★ §cNEW ! §e§l★★");
						 Faction.add("");
						 Faction.add("§7"+playerFaction+" §eJoueurs connectés ");
						 Faction.add("");
						 Faction.add("§eEtat: "+SOnlineF);
						 Faction.add("");
						 Faction.add("§aPrincipe: §fà décrire");
						 
						 API_Inventaire.additems(133, 1, 0, p.getOpenInventory().getTopInventory(), "§6§l★ §e§lFACTIONS §6§l★", Faction, 20);
						 
						 ArrayList<String> Minage = new ArrayList();
						 Minage.add("");
						 Minage.add("§8§l MINAGE §7| §e§l★★ §cNEW ! §e§l★★");
						 Minage.add("");
						 Minage.add("§7"+playerMinage+" §eJoueurs connectés ");
						 Minage.add("");
						 Minage.add("§eEtat: "+SOnlineM);

						 Minage.add("");
						 Minage.add("§aPrincipe: §fà décrire");
						 
						 API_Inventaire.additems(129, 1, 0, p.getOpenInventory().getTopInventory(), "§6§l★ §a§lMINAGE §6§l★", Minage, 21);

	
	      }
	      else
	      {
	    	  MenuPrincipale.InvMenu.remove(p);
	      }
	    }
	  }

}