package fr.WalexFelwin.OktaliaFaction.Inventaire.MenuPALL;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;

public class InformationALL {

	
	public static void Information(Player p){
		Inventory inv = Bukkit.createInventory(null, 54, "§6Informations");
		    
		ArrayList<String> list = new ArrayList<String>();
    	list.add("");
    	list.add("§6» §eMonde Faction:  §615K par 15K");
    	list.add("§6» §eMonde Minage:  §6Illimité");
    	list.add("");
    	
    	ArrayList<String> list2 = new ArrayList<String>();
    	list2.add("");
    	list2.add("§6» §eSite: oktalia.fr");
    	list2.add("§6» §eDiscord: Soon");
    	list2.add("");
    	
    	ArrayList<String> list3 = new ArrayList<String>();
    	list3.add("");
    	list3.add("§6» §eCliquez pour accèder au §6Tutoriel");
    	list3.add("");
    	
    	ArrayList<String> list4 = new ArrayList<String>();
    	list4.add("");
    	list4.add("§6» §eListe des commandes:");
    	list4.add("");
    	list4.add("   §f- commande1");
    	list4.add("   §f- commande2");
    	
    	ArrayList<String> list5 = new ArrayList<String>();
    	list5.add("");
    	list5.add("§6» §eListe des items / mondes désactivé:");
    	list5.add("");
    	list5.add("   §f- commande1");
    	list5.add("   §f- commande2");
    	
    	ArrayList<String> list6 = new ArrayList<String>();
    	list6.add("");
    	list6.add("§6» §eCliquez pour accèder au §6Planing des Events");
    	list6.add("");
    	

    	ArrayList<String> list7 = new ArrayList<String>();
    	list7.add("");
    	list7.add("§6» §eCliquez pour découvrir les §6Items Inédits");
    	list7.add("");
		
		    	API_Inventaire.additems(2, 1, 0, inv, "§6Taille des Maps", list, 10);
		    	API_Inventaire.additems(421, 1, 0, inv, "§6Liens", list2, 12);
		    	API_Inventaire.additems(279, 1, 0, inv, "§6Items Inédits", list7, 14);
		    	
		    	API_Inventaire.additems(340, 1, 0, inv, "§6Tutoriel", list3, 16);
		    	API_Inventaire.additems(131, 1, 0, inv, "§6Liste Commandes", list4, 29);
		    	API_Inventaire.additems(166, 1, 0, inv, "§6Désactivé", list5, 31);
		    	API_Inventaire.additems(385, 1, 0, inv, "§6Events", list6, 33);
		    	
		    	
		    	//------------------CONTOUR---------------------//
				
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 0);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 1);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 2);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 3);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 4);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 5);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 6);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 7);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 8);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 9);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 17);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 18);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 26);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 27);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 35);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 36);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 44);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 45);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 46);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 47);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 48);
		    			API_Inventaire.additems(399, 1, 0, inv, "§6Menu Principal", null, 49);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 50);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 51);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 52);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 53);
		    			
		    			//------------------CONTOUR---------------------//
		    			
		    			p.openInventory(inv);
			}
}
