package fr.WalexFelwin.OktaliaAPI.Bukkit.API;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_8_R3.Material;

public class API_Inventaire {
	
	public static void additems(int Item, int NB, int data, Inventory inv1, String DisplayName, ArrayList<String> lore, int Place){
		
		int spec = 0;
		
		ItemStack item = null;
		
		if(!(data == 0)){
			spec = data;
			item = new ItemStack(Item, NB, ((short)spec));
		} else {
		item = new ItemStack(Item, NB);
		}
	    ItemMeta itemmeta = item.getItemMeta();
		    itemmeta.setDisplayName(DisplayName);	
		    itemmeta.setLore(lore);	
	    item.setItemMeta(itemmeta);
	    
	    
	    	inv1.setItem(Place, item);
	    
	
		
	}
	
	
	public static void additemsShop(int Item, int NB, int data, Inventory inv1, String DisplayName, ArrayList<String> lore, int Place, int prixachat, int prixvente){
		
		int spec = 0;
		
		ItemStack item = null;
		
		if(!(data == 0)){
			spec = data;
			item = new ItemStack(Item, NB, ((short)spec));
		} else {
		item = new ItemStack(Item, NB);
		}		
		ArrayList<String> list = new ArrayList<String>();
		
    	list.add("");
    	list.add("§c» §7Prix Achat: §6"+prixachat+"$ unité");
    	list.add("§c» §7Prix Vente: §6"+prixvente+"$ unité");
    	list.add("");
    	list.add("§b§lClic molette pour tout vendre");
	    ItemMeta itemmeta = item.getItemMeta();
		    itemmeta.setDisplayName(DisplayName);	
		    itemmeta.setLore(list);	
	    item.setItemMeta(itemmeta);
	    
	    
	    	inv1.setItem(Place, item);
	    
	
		
	}
	
}
