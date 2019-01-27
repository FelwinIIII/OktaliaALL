package fr.walexmine.OktaliaMine.Inventaire;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import fr.walexmine.OktaliaMine.API.API_Joueur;

public class Minage {
	  public static void itemSpawn(Player p)
	  {
		  Integer level = API_Joueur.getlevel(p);
		  
		  ItemStack Pioche = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		    ItemMeta Piochesm = Pioche.getItemMeta();
		    Piochesm.setDisplayName("§bPioche");
		    if(level == 1) {
			    Piochesm.addEnchant(Enchantment.DIG_SPEED, 1, true);
		    } else  if (level == 2) {
			    Piochesm.addEnchant(Enchantment.DIG_SPEED, 2, true);
		    } else  if (level == 3) {
			    Piochesm.addEnchant(Enchantment.DIG_SPEED, 3, true);
		    } else  if (level == 4) {
			    Piochesm.addEnchant(Enchantment.DIG_SPEED, 4, true);
		    } else  if (level == 5) {
			    Piochesm.addEnchant(Enchantment.DIG_SPEED, 5, true);	
		    }
		    Piochesm.spigot().setUnbreakable(true);
		    Pioche.setItemMeta(Piochesm);
		    
			ItemStack hache = new ItemStack(Material.DIAMOND_AXE, 1);
		 ItemMeta hachesm = hache.getItemMeta();
			    hachesm.setDisplayName("§bHache");
			    if(level == 1) {
			    	hachesm.addEnchant(Enchantment.DIG_SPEED, 1, true);
			    } else  if (level == 2) {
			    	hachesm.addEnchant(Enchantment.DIG_SPEED, 2, true);
			    } else  if (level == 3) {
			    	hachesm.addEnchant(Enchantment.DIG_SPEED, 3, true);
			    } else  if (level == 4) {
			    	hachesm.addEnchant(Enchantment.DIG_SPEED, 4, true);
			    } else  if (level == 5) {
			    	hachesm.addEnchant(Enchantment.DIG_SPEED, 5, true);	
			    }
			    hachesm.spigot().setUnbreakable(true);
			    hache.setItemMeta(hachesm);

			    
				ItemStack pelle = new ItemStack(Material.DIAMOND_SPADE, 1);
			 ItemMeta pellesm = hache.getItemMeta();
			 pellesm.setDisplayName("§bPelle");
			    if(level == 1) {
			    	pellesm.addEnchant(Enchantment.DIG_SPEED, 1, true);
			    } else  if (level == 2) {
			    	pellesm.addEnchant(Enchantment.DIG_SPEED, 2, true);
			    } else  if (level == 3) {
			    	pellesm.addEnchant(Enchantment.DIG_SPEED, 3, true);
			    } else  if (level == 4) {
			    	pellesm.addEnchant(Enchantment.DIG_SPEED, 4, true);
			    } else  if (level == 5) {
			    	pellesm.addEnchant(Enchantment.DIG_SPEED, 5, true);	
			    }
			 pellesm.spigot().setUnbreakable(true);
			 pelle.setItemMeta(pellesm);
			 
			 
				ItemStack Reserve = new ItemStack(Material.CHEST, 1);
			 ItemMeta Reservesm = hache.getItemMeta();
			 Reservesm.setDisplayName("§aRéserve");
			 Reserve.setItemMeta(Reservesm);
				    

			    
				ItemStack Stats = new ItemStack(Material.ENDER_CHEST, 1);
			 ItemMeta statsm = hache.getItemMeta();
			 statsm.setDisplayName("§eStatistiques");
			 Stats.setItemMeta(statsm);
				    
			  
		 		    
		    ItemStack MenuPrincipale = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		    SkullMeta MenuPrincipalem = (SkullMeta)MenuPrincipale.getItemMeta();
		    MenuPrincipalem.setOwner(""+p.getName());
		    MenuPrincipalem.setDisplayName("§6Menu Principale");
		    MenuPrincipale.setItemMeta(MenuPrincipalem);
		    p.getInventory().clear();

		    p.getInventory().setItem(0, Pioche);
		    p.getInventory().setItem(1, hache);
		    p.getInventory().setItem(2, pelle);
		    p.getInventory().setItem(7, Reserve);
		    p.getInventory().setItem(8, Stats);
		 
		  
		  
		  
		  
	  }
}
