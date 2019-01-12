package fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;

public class Potion {

	public static void PotionALL(Player p){
		Inventory inv = Bukkit.createInventory(null, 54, "§6Potion");

		    	API_Inventaire.additemsShop(373, 1, 8259, inv, "", null, 10, 1, 2);
		    	API_Inventaire.additemsShop(373, 1, 8229, inv, "", null, 11, 1, 2);
		    	API_Inventaire.additemsShop(373, 1, 8265, inv, "", null, 12, 1, 2);
		    	API_Inventaire.additemsShop(373, 1, 8233, inv, "", null, 13, 1, 2);
		    	API_Inventaire.additemsShop(373, 1, 8270, inv, "", null, 14, 1, 2);
		    	API_Inventaire.additemsShop(373, 1, 8258, inv, "", null, 15, 1, 2);
		    	API_Inventaire.additemsShop(373, 1, 8226, inv, "", null, 16, 1, 2);
		    	
		    	API_Inventaire.additemsShop(373, 1, 16451, inv, "", null, 19, 1, 2);
		    	API_Inventaire.additemsShop(373, 1, 16421, inv, "", null, 20, 1, 2);
		    	API_Inventaire.additemsShop(373, 1, 16457, inv, "", null, 21, 1, 2);
		    	API_Inventaire.additemsShop(373, 1, 16425, inv, "", null, 22, 1, 2);
		    	API_Inventaire.additemsShop(373, 1, 16462, inv, "", null, 23, 1, 2);
		    	API_Inventaire.additemsShop(373, 1, 16386, inv, "", null, 24, 1, 2);
		    	API_Inventaire.additemsShop(373, 1, 16418, inv, "", null, 25, 1, 2);
		    	
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
