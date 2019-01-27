package fr.WalexFelwin.OktaliaHub.Slots;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class SlotsJoueur {

	
	public static void Item(Player p){

	    p.getInventory().clear();
		  
	  	ItemStack MPrincipale = new ItemStack(Material.COMPASS, 1);
	    ItemMeta MPrincipalesm = MPrincipale.getItemMeta();
	    MPrincipalesm.setDisplayName("§aMenu principal §7(Clic droit)");
	    ArrayList<String> MPrincipalelore = new ArrayList();
	    MPrincipalelore.add("");
	    MPrincipalesm.setLore(MPrincipalelore);
	    MPrincipale.setItemMeta(MPrincipalesm);		  
		  
	  	ItemStack Grades = new ItemStack(Material.TRIPWIRE_HOOK, 1);
	    ItemMeta Gradessm = Grades.getItemMeta();
	    Gradessm.setDisplayName("§5Grades §7(Clic droit)");
	    ArrayList<String> Gradeslore = new ArrayList();
	    Gradeslore.add("");
	    Gradessm.setLore(Gradeslore);
	    Grades.setItemMeta(Gradessm);		  
		  
	  	ItemStack Hub = new ItemStack(Material.NETHER_STAR, 1);
	    ItemMeta Hubsm = Hub.getItemMeta();
	    Hubsm.setDisplayName("§bHub §7(Clic droit)");
	    ArrayList<String> Hublore = new ArrayList();
	    Hublore.add("");
	    Hubsm.setLore(Hublore);
	    Hub.setItemMeta(Hubsm);		  
		  
	  	ItemStack Accessoires = new ItemStack(Material.ENDER_CHEST, 1);
	    ItemMeta Accessoiressm = Accessoires.getItemMeta();
	    Accessoiressm.setDisplayName("§eAccessoires §7(Clic droit)");
	    ArrayList<String> Accessoireslore = new ArrayList();
	    Accessoireslore.add("");
	    Accessoiressm.setLore(Accessoireslore);
	    Accessoires.setItemMeta(Accessoiressm);		  
		   

		  	ItemStack BedRock = new ItemStack(Material.BEDROCK, 1);
		  		
		    p.getInventory().setItem(0, Accessoires);	
		    p.getInventory().setItem(1, Grades);		  	
		    p.getInventory().setItem(4, MPrincipale);		  	
		    p.getInventory().setItem(8, Hub);

	}
}
