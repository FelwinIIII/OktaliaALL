package fr.WalexFelwin.OktaliaFaction.Inventaire.MenuPALL;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;

public class GradesMoney {

	
    public static void GradeMoney(Player p){
    	//rtestaze
    	Inventory inv = Bukkit.createInventory(null, 54, "§9§lGrades");
    	
    	ArrayList<String> list = new ArrayList<String>();
    	list.add("");
    	list.add("§c» §7Kit: §6/§epreview §b§lVoyageur");
    	list.add("");
    	list.add("§c» §6Prix§7: §e§l300 000$");
    	
    	ArrayList<String> list2 = new ArrayList<String>();
    	list2.add("");
    	list2.add("§c» §7Kit: §6/§epreview §b§lLegionnaire");
    	list2.add("");
    	list2.add("§c» §6Prix§7: §e§l600 000$");
    	
    	ArrayList<String> list3 = new ArrayList<String>();
    	list3.add("");
    	list3.add("§c» §7Kit: §6/§epreview §b§lMaitre");
    	list3.add("");
    	list3.add("§c» §6Prix§7: §e§l1 000 000$");
    	
    	ArrayList<String> list4 = new ArrayList<String>();
    	list4.add("");
    	list4.add("§c» §7Kit: §6/§epreview §b§lMonarque");
    	list4.add("");
    	list4.add("§c» §6Prix§7: §e§l1 500 000$");
    	
    	ArrayList<String> listvip = new ArrayList<String>();
    	listvip.add("");
    	listvip.add("§c» §7Kit: §6/§epreview §b§lVIP");
    	listvip.add("");
    	listvip.add("§c» §6Prix§7: §e§l1 500 000 POINTS VIP");
    	
    	ArrayList<String> listvip1 = new ArrayList<String>();
    	listvip1.add("");
    	listvip1.add("§c» §7Kit: §6/§epreview §e§lVIP");
    	listvip1.add("");
    	listvip1.add("§c» §6Prix§7: §e§l1 500 000 POINTS VIP");
    	
    	API_Inventaire.additems(268, 1, 0, inv, "§7§lGrade §2§lVoyageur", list, 10);
    	API_Inventaire.additems(272, 1, 0, inv, "§7§lGrade §b§lLegionnaire", list2, 12);
    	API_Inventaire.additems(267, 1, 0, inv, "§7§lGrade §6§lMaitre", list3, 14);
    	API_Inventaire.additems(267, 1, 0, inv, "§7§lGrade §9§lMonarque", list4, 16);
    	
    	API_Inventaire.additems(266, 1, 0, inv, "§7§lGrade §b§lVIP", listvip, 30);
    	API_Inventaire.additems(264, 1, 0, inv, "§7§lGrade §e§lVIP+", listvip1, 32);
    	
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
