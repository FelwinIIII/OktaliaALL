package fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;

public class Farm {

	
public static void FarmAll(Player p){
    	
    	Inventory inv = Bukkit.createInventory(null, 54, "§6Farm");
    	

    			
    	API_Inventaire.additemsShop(296, 1, 0, inv, "", null, 10, 2, 1);
    	API_Inventaire.additemsShop(338, 1, 0, inv, "", null, 11, 1, 2);
    	API_Inventaire.additemsShop(372, 1, 0, inv, "", null, 12, 1, 2);
    	API_Inventaire.additemsShop(392, 1, 0, inv, "", null, 13, 1, 2);
    	API_Inventaire.additemsShop(391, 1, 0, inv, "", null, 14, 1, 2);
    	API_Inventaire.additemsShop(351, 1, 0, inv, "", null, 15, 1, 2);
    	API_Inventaire.additemsShop(360, 1, 0, inv, "", null, 16, 1, 2);
    	API_Inventaire.additemsShop(81, 1, 0, inv, "", null, 19, 1, 2);
    	API_Inventaire.additemsShop(86, 1, 0, inv, "", null, 20, 1, 2);
    	
    	API_Inventaire.additemsShop(295, 1, 0, inv, "", null, 28, 1, 2);
    	API_Inventaire.additemsShop(361, 1, 0, inv, "", null, 29, 1, 2);
    	API_Inventaire.additemsShop(362, 1, 0, inv, "", null, 30, 1, 2);


    	
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
