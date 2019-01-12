package fr.WalexFelwin.OktaliaFaction.Inventaire;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;

public class Magasin {

	public static void MagasinAll(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, "§8§lMagasin §7(§8Catégories§7)");
		
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("");
		list.add("§c» §7Kit: §6/§epreview §e§lVIP");
		list.add("");
		
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
		
		API_Inventaire.additems(296, 1, 0, inv, "§6Farm", null, 11);
		API_Inventaire.additems(2, 1, 0, inv, "§6Block", null, 12);
		API_Inventaire.additems(264, 1, 0, inv, "§6Minerais", null, 13);
		API_Inventaire.additems(379, 1, 0, inv, "§6Alchimie", null, 14);
		API_Inventaire.additems(364, 1, 0, inv, "§6Nourriture", null, 15);
		API_Inventaire.additems(373, 1, 8229, inv, "§6Potions", null, 21);
		API_Inventaire.additems(52, 1, 0, inv, "§6Spawner", null, 22);
		API_Inventaire.additems(311, 1, 0, inv, "§6Kits", null, 23);
		API_Inventaire.additems(321, 1, 0, inv, "§6Décoration", null, 30);
		API_Inventaire.additems(384, 1, 0, inv, "§6Enchantement", null, 31);
		API_Inventaire.additems(46, 1, 0, inv, "§6Pillage", null, 32);
		
		p.openInventory(inv);
	}
	
}
