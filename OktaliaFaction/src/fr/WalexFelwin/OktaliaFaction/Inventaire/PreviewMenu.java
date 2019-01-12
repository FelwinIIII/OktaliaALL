package fr.WalexFelwin.OktaliaFaction.Inventaire;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;

public class PreviewMenu {
	
	public static void PreviewALL(Player p){
		Inventory inv = Bukkit.createInventory(null, 54, "§6Preview Kits");
		    
		ArrayList<String> list = new ArrayList<String>();
    	list.add("");
    	list.add("§c» §7Cliquez pour voir le kit §b§lVoyageur");
    	list.add("");
    	
    	ArrayList<String> list2 = new ArrayList<String>();
    	list2.add("");
    	list2.add("§c» §7Cliquez pour voir le kit §b§lLegionnaire");
    	list2.add("");
    	
    	ArrayList<String> list3 = new ArrayList<String>();
    	list3.add("");
    	list3.add("§c» §7Cliquez pour voir le kit §b§lMaitre");
    	list3.add("");
    	
    	ArrayList<String> list4 = new ArrayList<String>();
    	list4.add("");
    	list4.add("§c» §7Cliquez pour voir le kit §b§lMonarque");
    	list4.add("");
    	
    	ArrayList<String> listvip = new ArrayList<String>();
    	listvip.add("");
    	listvip.add("§c» §7Cliquez pour voir le kit §b§lVIP");
    	listvip.add("");
    	
    	ArrayList<String> listvip1 = new ArrayList<String>();
    	listvip1.add("");
    	listvip1.add("§c» §7Cliquez pour voir le kit §e§lVIP");
    	listvip1.add("");
    	
    	API_Inventaire.additems(268, 1, 0, inv, "§7§lKit §2§lVoyageur", list, 10);
    	API_Inventaire.additems(272, 1, 0, inv, "§7§lKit §b§lLegionnaire", list2, 12);
    	API_Inventaire.additems(267, 1, 0, inv, "§7§lKit §6§lMaitre", list3, 14);
    	API_Inventaire.additems(267, 1, 0, inv, "§7§lKit §9§lMonarque", list4, 16);
    	
    	API_Inventaire.additems(266, 1, 0, inv, "§7§lKit §b§lVIP", listvip, 30);
    	API_Inventaire.additems(264, 1, 0, inv, "§7§lKit §e§lVIP+", listvip1, 32);
		    	
		    	
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
