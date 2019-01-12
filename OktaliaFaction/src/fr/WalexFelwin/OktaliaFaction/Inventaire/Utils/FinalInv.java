package fr.WalexFelwin.OktaliaFaction.Inventaire.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;
import fr.WalexFelwin.OktaliaFaction.Main;

public class FinalInv implements Listener{
	
	public static String name = "";
	public static Integer nb = 0;
	public static int valeurasadd = 0;
	public static Map<Player, Inventory> getInv = new HashMap<Player, Inventory>();
	
	public FinalInv(Main main) {
		// TODO Auto-generated constructor stub
	}

	public static void FinalInv1(ItemStack item,Integer Prix,Player p,Inventory invname) {

		name= invname.getName();
		
		Inventory inv = Bukkit.createInventory(null, 9, invname.getName()+" > Achat");
		
		item.getItemMeta().getLore().get(1);
		API_Inventaire.additems(160, 10, 14, inv, "-10", null, 1);
		API_Inventaire.additems(160, 1, 14, inv, "-1", null, 2);
		
		API_Inventaire.additems(160, 1, 4, inv, "+1", null, 6);
		API_Inventaire.additems(160, 10, 4, inv, "+10", null, 7);

		ArrayList<String> list = new ArrayList<String>();
		
    	list.add("");
    	list.add(item.getItemMeta().getLore().get(1));
    	list.add("");
    	list.add("§bQuantité: §e"+item.getAmount());
    	list.add("");
    	list.add("§b§lClic droit pour acheté");

		API_Inventaire.additems(item.getTypeId(), 1, 0, inv, "", list, 4);

		
		p.openInventory(inv);

		getInv.put(p, inv);
	}
	  
		@EventHandler
		public void closeinv(InventoryCloseEvent e)
		{

		    Player p = (Player) e.getPlayer();
		    
			if(e.getInventory().equals(getInv.get(p))) {
				getInv.remove(p);
			}
		}
		  
	  @EventHandler
	  public void onInventoryClickEvent(InventoryClickEvent e)
	  {
		 
	    Player p = (Player)e.getWhoClicked();
	    if(getInv.containsKey(p)) {
	    		
	 
	     
	    	e.setCancelled(true);     
	        if ((e.getCurrentItem() == null) && (e.getCurrentItem().getType() == Material.AIR))
	        {
	        	return;
	        } else {
	        	if(e.getClickedInventory().getName().equalsIgnoreCase(getInv.get(p).getName())) {
	        	int newamount = Integer.valueOf(p.getOpenInventory().getTopInventory().getItem(4).getItemMeta().getLore().get(3).replace("§bQuantité: §e", ""));
	        	
	        	Integer prix = Integer.valueOf(p.getOpenInventory().getTopInventory().getItem(4).getItemMeta().getLore().get(1).replace("§c» §7Prix Achat: §6", "").replace("$ unité", ""));
	        	
	        	ItemStack newitemplace = e.getClickedInventory().getItem(4);

	        	ItemStack it = e.getCurrentItem();
	        	
	        	if(newitemplace.getItemMeta().getDisplayName() == null)
	        	{
	        		if(it.getType() == newitemplace.getType()) {
		    			p.sendMessage("§8[§bOktalia§8]§6 Tu as acheté ces items pour §e"+newamount* prix+" $ §6!");
		    			
		    			getInv.remove(p);
	        			p.closeInventory();
	        			
	        		} else {

	    	    ItemMeta itemmeta = newitemplace.getItemMeta();
	    	    

	    		ArrayList<String> list = new ArrayList<String>();
	    		
	        	list.add("");
	        	list.add("§c» §7Prix Achat: §6"+ p.getOpenInventory().getTopInventory().getItem(4).getItemMeta().getLore().get(1).replace("§c» §7Prix Achat: §6", "").replace("$ unité", ""));
	        	list.add("");

	        	
	        	if(it.getItemMeta().getDisplayName().equalsIgnoreCase("+1")) {
	        		
		        	list.add("§bQuantité: §e"+(newamount+1));
		        	list.add("");
		        	valeurasadd = 1;
	        		
	        	} else if(it.getItemMeta().getDisplayName().equalsIgnoreCase("+10")) {

		        	list.add("§bQuantité: §e"+(newamount+10));
		        	list.add("");
		        	valeurasadd = 10;

	        		
	        	} else if(it.getItemMeta().getDisplayName().equalsIgnoreCase("-1")) {
	        		if((newamount) < 1) {
	        			return;
	        		}
		        	list.add("§bQuantité: §e"+ (newamount - 1));
		        	list.add("");
		        	valeurasadd = -1;

	        		
	        	} else if(it.getItemMeta().getDisplayName().equalsIgnoreCase("-10")) {
	        		if((newamount) < 10) {
	        			return;
	        		}
		        	list.add("§bQuantité: §e"+ (newamount - 10));
		        	list.add("");

		        	valeurasadd = -10;
	        		 
	        	} 

	        	newamount = Integer.valueOf(p.getOpenInventory().getTopInventory().getItem(4).getItemMeta().getLore().get(3).replace("§bQuantité: §e", ""));
	        	list.add("§7§lPrix Total: §e"+((newamount + valeurasadd) * prix )+" §6$");
	        	list.add("");
	        	list.add("§b§lClic droit pour acheté");
	        	

	        	itemmeta.setLore(list);
	        	newitemplace.setItemMeta(itemmeta);
        		p.getOpenInventory().getTopInventory().setItem(4, newitemplace);
	        	}
	        	
	        	
	    }
	        	
	        	} 	
	   

}
	    }
}
}