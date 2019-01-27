package fr.walexmine.OktaliaQuete.API;

import java.util.ArrayList;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class API_Inventory {
	

	
	@SuppressWarnings("deprecation")
	public static void addnewitems(int Item, int NB, int data, Inventory inv1, ArrayList<String> lore, String DisplayName, int Place){
		
		int spec = 0;
		
		ItemStack item = null;
		
		if(!(data == 0)){
			spec = data;
			item = new ItemStack(Item, NB, ((short)spec));
		} else {
		item = new ItemStack(Item, NB);
		}
	    ItemMeta itemmeta = item.getItemMeta();
		    itemmeta.setDisplayName(itemmeta.getDisplayName());	
		  
		    itemmeta.setLore(lore);	
		    
		    itemmeta.setDisplayName(DisplayName);
	    item.setItemMeta(itemmeta);
	    
	    
	    	inv1.setItem(Place, item);
	    
		
	}
	
	
	
}
