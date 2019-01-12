package fr.WalexFelwin.OktaliaFaction.Inventaire;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;


public class MenuPrincipal {
	
	public static void MenuALL(Player p){
		Inventory inv = Bukkit.createInventory(null, 54, "§6Menu Principal");
		
		ArrayList<String> list = new ArrayList<String>();
    	list.add("");
    	list.add("§6» §eIci achetez et vendez vos ressources");

    	ArrayList<String> list2 = new ArrayList<String>();
    	list2.add("");
    	list2.add("§6» §eIci faites du commerce avec les joueurs");
    	
    	ArrayList<String> list3 = new ArrayList<String>();
    	list3.add("");
    	list3.add("§6» §eIci achetez un§6§l Grade");
    	
    	ArrayList<String> list4 = new ArrayList<String>();
    	list4.add("");
    	list4.add("§6» §eIci consultez toutes les informations liées à §6§lOktalia");
		    	
    	ArrayList<String> list5 = new ArrayList<String>();
    	list5.add("");
    	list5.add("§6» §eIci consultez et modifiez toutes vos§6§l Options");
    	
    	ArrayList<String> list6 = new ArrayList<String>();
    	list6.add("");
    	list6.add("§6» §eIci consultez tout les§6§l Warp !");
    	
    	ArrayList<String> list7 = new ArrayList<String>();
    	list7.add("");
    	list7.add("§6» §eIci votez et échangez vos§6§l VoteCoins !");
    	
    	ArrayList<String> list8 = new ArrayList<String>();
    	list8.add("");
    	list8.add("§6» §eIci accèdez à toutes les prévisualisations des kits !");
    	
    	ArrayList<String> list9 = new ArrayList<String>();
    	list9.add("");
    	list9.add("§6» §eIci achetez des murs d'Obsidienne ou de Sable !");
    	
		    	API_Inventaire.additems(328, 1, 0, inv, "§e§lMagasin", list, 11);
		    	API_Inventaire.additems(388, 1, 0, inv, "§6§lHDV", list2, 13);
		    	API_Inventaire.additems(311, 1, 0, inv, "§9§lGrades", list3, 15);
		    	API_Inventaire.additems(421, 1, 0, inv, "§d§lInformations", list4, 22);
		    	API_Inventaire.additems(347, 1, 0, inv, "§2§lOptions", list5, 24);
		    	API_Inventaire.additems(381, 1, 0, inv, "§2§lWarps", list6, 20);
		    	API_Inventaire.additems(339, 1, 0, inv, "§a§lVote", list7, 29);
		    	API_Inventaire.additems(130, 1, 0, inv, "§9§lPreview Kit", list7, 31);
		    	API_Inventaire.additems(279, 1, 0, inv, "§6§lItems Inédits", list7, 33);
		    	API_Inventaire.additems(49, 1, 0, inv, "§5§lMur Obsidienne§7/§5§lSable", list7, 40);
		    	
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
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 49);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 50);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 51);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 52);
		    			API_Inventaire.additems(160, 1, 7, inv, "", null, 53);
		    			
		    			//------------------CONTOUR---------------------//
		    			
		    			p.openInventory(inv);
			}

}
