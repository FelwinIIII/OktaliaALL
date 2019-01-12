package fr.WalexFelwin.OktaliaFaction.Inventaire.InformationALL;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;

public class ItemsInedits {

	public static void ItemsALL(Player p){
    	Inventory inv = Bukkit.createInventory(null, 54, "§6§lItems Inédits");
    	
    	ArrayList<String> list = new ArrayList<String>();
    	list.add("");
    	list.add("§c» §7Effet: §6Speed II, Force II, Résistance au feu");
    	list.add("");
    	
    	ArrayList<String> list2 = new ArrayList<String>();
    	list2.add("");
    	list2.add("§c» §7Farmable toutes les 5 minutes");
    	list2.add("");
    	
    	ArrayList<String> list3 = new ArrayList<String>();
    	list3.add("");
    	list3.add("§c» §7Une fois ce block posé une colonne");
    	list3.add("§7d'obsidienne apparaît");
    	list3.add("");

    	
    	
    	API_Inventaire.additems(279, 1, 0, inv, "§7§lHache §2§lLégendaire", list, 20);
    	API_Inventaire.additems(397, 1, 0, inv, "§6§lRuche", list2, 22);
    	API_Inventaire.additems(49, 1, 0, inv, "§5§lColonne d'obsidienne", list3, 24);

    	
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
