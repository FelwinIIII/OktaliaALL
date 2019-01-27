package fr.walexmine.OktaliaQuete.Inventaire;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.walexmine.OktaliaQuete.API.API_Inventory;

public class Quete {
	
	
	  private static Inventory inv1;
		
	  public static void openQuete(Player p) {

		  inv1 = Bukkit.createInventory(null, 54, "§7§lQuête");


		  ArrayList<String> Quete1 = new ArrayList<>();
		  Quete1.add("");
		  Quete1.add("§cDisponible 1er janvier");
		  Quete1.add("");
		  Quete1.add("§eObjectifs:");
		  Quete1.add("");
		  Quete1.add("§7Non défini..");
		  ArrayList<String> Quetesemaine = new ArrayList<>();
		  Quetesemaine.add("");
		  Quetesemaine.add("§cDisponible 1er janvier");
		  Quetesemaine.add("");
		  Quetesemaine.add("§eObjectifs:");
		  Quetesemaine.add("");
		  Quetesemaine.add("§7Non défini..");
		  ArrayList<String> Quetemois = new ArrayList<>();
		  Quetemois.add("");
		  Quetemois.add("§cDisponible 1er janvier");
		  Quetemois.add("");
		  Quetemois.add("§eObjectifs:");
		  Quetemois.add("");
		  Quetemois.add("§7Non défini..");
		  ArrayList<String> glass = new ArrayList<>();

			API_Inventory.addnewitems(54, 1, 0, inv1, Quete1, "§eQuête du jour", 20);
			API_Inventory.addnewitems(54, 1, 0, inv1, Quetesemaine, "§eQuête de la semaine ", 24);
			API_Inventory.addnewitems(130, 1, 0, inv1, Quetemois, "§eQuête du§7§l mois", 31);
			
					  // first glass blue
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 0);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 1);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 2);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 3);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 4);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 5);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 6);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 7);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 8);
						
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 9);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 10);
						  // first glass black
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 11);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 12);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 13);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 14);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 15);
						
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 16);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 17);
						
						
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 18);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 19);
						

						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 21);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 22);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 23);
						

						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 25);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 26);
						
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 27);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 28);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 29);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 30);
						
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 32);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 33);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 34);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 35);

						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 36);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 37);

						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 38);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 39);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 40);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 41);
						API_Inventory.addnewitems(160, 1, 15, inv1, glass, " ", 42);

						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 43);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 44);

						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 45);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 46);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 47);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 48);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 49);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 50);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 51);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 52);
						API_Inventory.addnewitems(160, 1, 11, inv1, glass, " ", 53);
						
				p.openInventory(inv1);
	  }	  
}
