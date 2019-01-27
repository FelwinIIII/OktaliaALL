package fr.walexmine.OktaliaMine.Inventaire.StatsMine;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import fr.walexmine.OktaliaMine.API.API_Temps;


public class Stats {


	  public static HashMap<Player, Integer> EXP = new HashMap();
	  public static HashMap<Player, Integer> LEVEL = new HashMap();
	
	  private static Inventory inv1;
		
	  public static void STATISTIQUES(Player p) {

		  inv1 = Bukkit.createInventory(null, 27, "§6Statistiques");

	  		ArrayList<String> stats = new ArrayList<>();
	  		stats.add("");
	  		stats.add("§7§l-----------------");
	  		stats.add("");
	  		stats.add("§bTemps Connectées §7§l: §e"+API_Temps.getRemainingTime(p));
	  		stats.add("");
	  		stats.add("§bEXP §7§l: §a"+EXP.get(p));
	  		stats.add("");
	  		stats.add("§6LEVEL §7§l: §a"+LEVEL.get(p));
	  		stats.add("");
	  		stats.add("§7§l-----------------");
	  		
		    ItemStack Stats = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		    SkullMeta Statsmeta = (SkullMeta)Stats.getItemMeta();   	
		    Statsmeta.setOwner(p.getName());
		    Statsmeta.setDisplayName("§6§lStatistiques:");
		    Statsmeta.setLore(stats);
		    Stats.setItemMeta(Statsmeta);

	  	

					
			inv1.setItem(13, Stats);
			
			
				p.openInventory(inv1);
	  }	 
	  
	  
	  
}
