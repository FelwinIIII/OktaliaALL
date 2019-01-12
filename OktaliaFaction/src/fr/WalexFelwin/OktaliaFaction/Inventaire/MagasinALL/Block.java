package fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;


public class Block {
	public static void BlockPage1(Player p){
		Inventory inv = Bukkit.createInventory(null, 54, "§6Block");
		
    	API_Inventaire.additemsShop(4, 1, 0, inv, "", null, 10, 2, 1);
    	API_Inventaire.additemsShop(1, 1, 0, inv, "", null, 11, 2, 1);
    	API_Inventaire.additemsShop(1, 1, 1, inv, "", null, 12, 2, 1);
    	API_Inventaire.additemsShop(1, 1, 2, inv, "", null, 13, 2, 1);
    	API_Inventaire.additemsShop(1, 1, 3, inv, "", null, 14, 2, 1);
    	API_Inventaire.additemsShop(1, 1, 4, inv, "", null, 15, 2, 1);
    	API_Inventaire.additemsShop(1, 1, 5, inv, "", null, 16, 2, 1);
    	API_Inventaire.additemsShop(1, 1, 6, inv, "", null, 19, 2, 1);
    	API_Inventaire.additemsShop(17, 1, 0, inv, "", null, 20, 2, 1);
    	API_Inventaire.additemsShop(17, 1, 1, inv, "", null, 21, 2, 1);
    	API_Inventaire.additemsShop(17, 1, 2, inv, "", null, 22, 2, 1);
    	API_Inventaire.additemsShop(17, 1, 3, inv, "", null, 23, 2, 1);
    	API_Inventaire.additemsShop(5, 1, 0, inv, "", null, 24, 2, 1);
    	API_Inventaire.additemsShop(5, 1, 1, inv, "", null, 25, 2, 1);
    	API_Inventaire.additemsShop(5, 1, 2, inv, "", null, 27, 2, 1);
    	API_Inventaire.additemsShop(5, 1, 3, inv, "", null, 28, 2, 1);
    	API_Inventaire.additemsShop(5, 1, 4, inv, "", null, 29, 2, 1);
    	API_Inventaire.additemsShop(5, 1, 5, inv, "", null, 30, 2, 1);
    	API_Inventaire.additemsShop(3, 1, 2, inv, "", null, 31, 2, 1);
    	API_Inventaire.additemsShop(2, 1, 0, inv, "", null, 32, 2, 1);
    	API_Inventaire.additemsShop(13, 1, 0, inv, "", null, 33, 2, 1);
    	API_Inventaire.additemsShop(12, 1, 0, inv, "", null, 34, 2, 1);
    	API_Inventaire.additemsShop(12, 1, 1, inv, "", null, 37, 2, 1);
    	API_Inventaire.additemsShop(24, 1, 0, inv, "", null, 38, 2, 1);
    	API_Inventaire.additemsShop(24, 1, 1, inv, "", null, 39, 2, 1);
    	API_Inventaire.additemsShop(24, 1, 2, inv, "", null, 40, 2, 1);
    	API_Inventaire.additemsShop(47, 1, 0, inv, "", null, 41, 2, 1);
    	API_Inventaire.additemsShop(45, 1, 0, inv, "", null, 42, 2, 1);
    	API_Inventaire.additemsShop(48, 1, 0, inv, "", null, 43, 2, 1);
    	
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
    			API_Inventaire.additems(339, 1, 0, inv, "§ePage Suivante", null, 50);
    			API_Inventaire.additems(160, 1, 7, inv, "", null, 51);
    			API_Inventaire.additems(160, 1, 7, inv, "", null, 52);
    			API_Inventaire.additems(160, 1, 7, inv, "", null, 53);
    			
    			//------------------CONTOUR---------------------//
    			
    	    	
    	    	p.openInventory(inv);
	}
	public static void BlockPage2(Player p){
		Inventory inv = Bukkit.createInventory(null, 54, "§6Block§8(§71§8)");
		

    	
    	API_Inventaire.additemsShop(35, 1, 0, inv, "", null, 10, 2, 1);
    	API_Inventaire.additemsShop(159, 1, 0, inv, "", null, 11, 2, 1);
    	API_Inventaire.additemsShop(20, 1, 0, inv, "", null, 12, 2, 1);
    	API_Inventaire.additemsShop(102, 1, 0, inv, "", null, 13, 2, 1);
    	API_Inventaire.additemsShop(98, 1, 0, inv, "", null, 14, 2, 1);
    	API_Inventaire.additemsShop(98, 1, 1, inv, "", null, 15, 2, 1);
    	API_Inventaire.additemsShop(98, 1, 2, inv, "", null, 16, 2, 1);
    	API_Inventaire.additemsShop(98, 1, 3, inv, "", null, 19, 2, 1);
    	API_Inventaire.additemsShop(110, 1, 0, inv, "", null, 20, 2, 1);
    	API_Inventaire.additemsShop(121, 1, 0, inv, "", null, 21, 2, 1);
    	API_Inventaire.additemsShop(155, 1, 0, inv, "", null, 22, 2, 1);
    	API_Inventaire.additemsShop(155, 1, 1, inv, "", null, 23, 2, 1);
    	API_Inventaire.additemsShop(155, 1, 2, inv, "", null, 24, 2, 1);
    	API_Inventaire.additemsShop(79, 1, 0, inv, "", null, 25, 2, 1);
    	API_Inventaire.additemsShop(174, 1, 0, inv, "", null, 28, 2, 1);

    	
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
    			API_Inventaire.additems(339, 1, 0, inv, "§ePage Précèdente", null, 48);
    			API_Inventaire.additems(399, 1, 0, inv, "§2Retour", null, 49);
    			API_Inventaire.additems(160, 1, 7, inv, "", null, 50);
    			API_Inventaire.additems(160, 1, 7, inv, "", null, 51);
    			API_Inventaire.additems(160, 1, 7, inv, "", null, 52);
    			API_Inventaire.additems(160, 1, 7, inv, "", null, 53);
    			
    			//------------------CONTOUR---------------------//
    			
    	    	
    	    	p.openInventory(inv);
	}

}
