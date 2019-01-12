package fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;

public class Nourriture {

	public static void NourritureALL(Player p){
		Inventory inv = Bukkit.createInventory(null, 54, "§6Nourriture");

		    
		    	API_Inventaire.additemsShop(320, 1, 0, inv, "", null, 10, 1, 2);
		    	API_Inventaire.additemsShop(364, 1, 0, inv, "", null, 11, 1, 2);
		    	API_Inventaire.additemsShop(366, 1, 0, inv, "", null, 12, 1, 2);
		    	API_Inventaire.additemsShop(412, 1, 0, inv, "", null, 13, 1, 2);
		    	API_Inventaire.additemsShop(424, 1, 0, inv, "", null, 14, 1, 2);
		    	API_Inventaire.additemsShop(393, 1, 0, inv, "", null, 15, 1, 2);
		    	API_Inventaire.additemsShop(322, 1, 0, inv, "", null, 16, 1, 2);
		    	
		    	API_Inventaire.additemsShop(319, 1, 0, inv, "", null, 19, 1, 2);
		    	API_Inventaire.additemsShop(363, 1, 0, inv, "", null, 20, 1, 2);
		    	API_Inventaire.additemsShop(365, 1, 0, inv, "", null, 21, 1, 2);
		    	API_Inventaire.additemsShop(411, 1, 0, inv, "", null, 22, 1, 2);
		    	API_Inventaire.additemsShop(423, 1, 0, inv, "", null, 23, 1, 2);
		    	API_Inventaire.additemsShop(392, 1, 0, inv, "", null, 24, 1, 2);
		    	API_Inventaire.additemsShop(260, 1, 0, inv, "", null, 25, 1, 2);
		    	
		    	API_Inventaire.additemsShop(357, 1, 0, inv, "", null, 39, 1, 2);
		    	API_Inventaire.additemsShop(354, 1, 0, inv, "", null, 40, 1, 2);
		    	API_Inventaire.additemsShop(297, 1, 0, inv, "", null, 41, 1, 2);
		    	
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
		    			API_Inventaire.additems(399, 1, 0, inv, "§2Retour", null, 49);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 50);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 51);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 52);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 53);
		    			
		    			//------------------CONTOUR---------------------//
		    			
		    			p.openInventory(inv);
			}
	
}
