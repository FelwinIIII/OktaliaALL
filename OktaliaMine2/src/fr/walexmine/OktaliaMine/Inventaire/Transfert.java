package fr.walexmine.OktaliaMine.Inventaire;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.walexmine.OktaliaMine.API.API_Inventory;


public class Transfert {
	
	  private static Inventory inv1;
	
	  public static void Transfert(Player p, ItemStack item, int i) {

		  inv1 = Bukkit.createInventory(null, 27, "§eTransfère >> Faction");


	  		ArrayList<String> lorewoolred = new ArrayList<>();

	  		ArrayList<String> lorewoolgreen = new ArrayList<>();
					API_Inventory.addnewitems(35, 1, 5, inv1, lorewoolgreen, "§a✔  Valider ✔", 11);
					
					  ArrayList<String> lore = new ArrayList<>();
					    lore.add("");
					    lore.add("§cQuantité: §e"+i);
					    lore.add("");
					    lore.add("§eClic droit §7>> §apour modifier la quantité");
					    lore.add("§cBientôt disponible !");
					API_Inventory.addnewitems(item.getTypeId(), 1, item.getData().getData(), inv1, lore, "Transfère: "+item.getType(), 13);
					
					API_Inventory.addnewitems(35, 1, 14, inv1, lorewoolred, "§c✖  Annuler ✖", 15);
		    	  
				p.openInventory(inv1);
	  }	  
}
