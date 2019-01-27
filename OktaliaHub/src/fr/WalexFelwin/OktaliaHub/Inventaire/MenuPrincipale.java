package fr.WalexFelwin.OktaliaHub.Inventaire;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerInfo;
import fr.WalexFelwin.OktaliaHub.ServeurRegister;


public class MenuPrincipale {

	private static Inventory inv1;
	

	  public static HashMap<Player, String> InvMenu = new HashMap();
	
	  public static void InventoryMenuPrincipale(Player p)
	  {
		  
		  inv1 = Bukkit.createInventory(null, 45, "§aMenu Principal");
		  
	  int playerFaction;
         ServerInfo Factions = Main.getInstance().getPingAPI().getServer("Faction");
         Factions.pingToServer();
         playerFaction = Factions.getPlayerCount() ;			  
		  int playerMinage;
	         ServerInfo Minages = Main.getInstance().getPingAPI().getServer("Minage");
	         Minages.pingToServer();
	         playerMinage = Minages.getPlayerCount() ;

			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 0);
			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 1);
			 API_Inventaire.additems(101, 1, 0, inv1, "§cServeur Priver !", null, 2);
			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 3);
			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 5);
			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 6);
			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 7);
			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 9);
			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 18);
			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 27);
			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 36);

			 ArrayList<String> Faction = new ArrayList();
			 Faction.add("");
			 Faction.add("§8§l FACTIONS §7| §e§l★★ §cNEW ! §e§l★★");
			 Faction.add("");
			 Faction.add("§7"+playerFaction+" §eJoueurs connectés ");
			 Faction.add("");
			 Faction.add("§aPrincipe: §fà décrire");
			 
			 API_Inventaire.additems(133, 1, 0, inv1, "§6§l★ §e§lFACTIONS §6§l★", Faction, 20);
			 
			 ArrayList<String> Minage = new ArrayList();
			 Minage.add("");
			 Minage.add("§8§l MINAGE §7| §e§l★★ §cNEW ! §e§l★★");
			 Minage.add("");
			 Minage.add("§7"+playerMinage+" §eJoueurs connectés ");
			 Minage.add("");
			 Minage.add("§aPrincipe: §fà décrire");
			 
			 API_Inventaire.additems(129, 1, 0, inv1, "§6§l★ §a§lMINAGE §6§l★", Minage, 21);
			 API_Inventaire.additems(166, 1, 0, inv1, "", null, 22);
			 API_Inventaire.additems(166, 1, 0, inv1, "", null, 23);
			 API_Inventaire.additems(166, 1, 0, inv1, "", null, 24);
			 

			 API_Inventaire.additems(399, 1, 0, inv1, "§aListe des Hubs", null, 4);

			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 37);
			 ArrayList<String> MAJ = new ArrayList();
			 MAJ.add("");
			 MAJ.add("§e§lNouveauté: §aAucune Nouveauté");
			 MAJ.add("");
			 API_Inventaire.additems(339, 1, 0, inv1, "§6§lInfo Mise à jour", MAJ, 38);

			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 39);
			 
			 API_Inventaire.additems(347, 1, 0, inv1, "§bAmi(s)", null, 40);
			 ArrayList<String> Statistiques = new ArrayList();
			 Statistiques.add("");
			 Statistiques.add("§eGrade:");
			 Statistiques.add("");
			 Statistiques.add("");
			 Statistiques.add("§aOktaCoins: §e0 §6$");
			 Statistiques.add("");
			 
			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 41);
			 
			 API_Inventaire.additems(321, 1, 0, inv1, "§eStatistiques:", Statistiques, 42);
			 
			// if(API_Permission.havepermission(p, "serveur.priver")){

			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 43);
			 
			 
			// } else {
			// }
			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 8);
			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 17);
			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 26);
			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 35);
			 API_Inventaire.additems(160, 1, 0, inv1, "", null, 44);
			 
		    p.openInventory(inv1);
		    
		    InvMenu.put(p, "");
	  }
}