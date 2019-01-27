package fr.walexmine.OktaliaMine.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.walexmine.OktaliaMine.Main;
import fr.walexmine.OktaliaMine.API.API_Joueur;
import fr.walexmine.OktaliaMine.Inventaire.Minage;
import fr.walexmine.OktaliaMine.Inventaire.Reserve;
import fr.walexmine.OktaliaMine.Inventaire.StatsMine.Stats;

public class PlayerBreak implements Listener{
	
	public PlayerBreak(Main main) {
		
	}

	  public static HashMap<Player, Inventory> ReserveM = new HashMap();

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public  void PlayerBreakz(BlockPlaceEvent e) {
		 
	    Player p = (Player)e.getPlayer();
	    	if(p.isOp()) {
	    		if(e.getBlock().getType() == Material.CHEST || e.getBlock().getType() == Material.ENDER_CHEST) {
	    			 e.setCancelled(true);
	    		}
	    	 } else {
	    	e.setCancelled(true);
	    	 }
	    
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public  void PlayerBreakz(BlockBreakEvent e) {
		Player p = e.getPlayer();

			
			ItemStack dropn = null;
			String dropc = ""+e.getBlock();
		if( e.getBlock().getDrops() == null || dropc.contains("LEAVES")) {
			dropn = null;
		} else {
			
			String drops  = ""+e.getBlock().getDrops();
			
			 if(e.getBlock().getState().getLightLevel() == 15) {
				 ItemStack drop1 = new ItemStack(e.getBlock().getTypeId(), 1, ((short)e.getBlock().getData()));
				 dropn = drop1;
			 } else {

				 dropn = e.getBlock().getDrops().iterator().next();
				 

			 }
		}
		
		if(!(dropn == null)) {
			
			
			int exp = Stats.EXP.get(p)+1;
			
			Stats.EXP.remove(p);
			Stats.EXP.put(p, exp);
			
			if(exp == 25000) {
				
				//LEVEL 2
				
				Stats.LEVEL.remove(p);
				Stats.LEVEL.put(p, 2);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 100.0F, 1.0F);

				p.sendMessage("§b LEVEL UP §7| §6Niveau 2 §l!");
				p.sendMessage("§aVous disposez désormais d'outils avec Efficacité 2");
				Minage.itemSpawn(p);
			} else if(exp == 55000){
				
				//LEVEL 3
				
				Stats.LEVEL.remove(p);
				Stats.LEVEL.put(p, 3);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 100.0F, 1.0F);

				p.sendMessage("§b LEVEL UP §7| §6Niveau 3 §l!");
				p.sendMessage("§aVous disposez désormais d'outils avec Efficacité 3");

				Minage.itemSpawn(p);
			} else if(exp == 55000 + 30000){
				
				//LEVEL 4
				
				Stats.LEVEL.remove(p);
				Stats.LEVEL.put(p, 4);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 100.0F, 1.0F);

				p.sendMessage("§b LEVEL UP §7| §6Niveau 4 §l!");
				p.sendMessage("§aVous disposez désormais d'outils avec Efficacité 4");

				Minage.itemSpawn(p);
			} else if(exp == 55000 + 30000 + 30000){
				
				//LEVEL 5
				
				Stats.LEVEL.remove(p);
				Stats.LEVEL.put(p, 5);

				p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 100.0F, 1.0F);

				p.sendMessage("§b LEVEL UP §7| §6Niveau 5 §l!");
				p.sendMessage("§aVous disposez désormais d'outils avec Efficacité 5");
				Minage.itemSpawn(p);
			}
			//p.sendMessage("test : "+ablockiod+" ListBlock: "+blocklist);
			//p.sendMessage("DROP: "+drop.getTypeId()+" DATA: "+drop.getData().getData());
			
		/*	if(blocklist.isEmpty()) {
				
			} else {*/
			Inventory reserve = ReserveM.get(p);

			
            for (int i =0; i < reserve.getSize(); i++) {

       
            	if(reserve.getItem(i) == null) { 
            		if (i == 35){
                 	   
                   		ItemStack newitem = new ItemStack(dropn.getType(), dropn.getAmount(), dropn.getData().getData());
                	    ItemMeta itemmeta = newitem.getItemMeta();
            		    itemmeta.setDisplayName(itemmeta.getDisplayName());	
            		    ArrayList<String> lore = new ArrayList<>();
            		    lore.add("");
            		    lore.add("");
            		    lore.add("§bQuantité: §e"+dropn.getAmount());
            		    lore.add("");
            		    lore.add("");
            		    itemmeta.setLore(lore);	
            		    newitem.setItemMeta(itemmeta);
            		    
            		    reserve.addItem(newitem);
            		    
            		    ReserveM.put(p, reserve);

            		}
            	} else {
			if(reserve.getItem(i).getType().equals(dropn.getType())) {
				
				if (reserve.getItem(i).getData().getData() == dropn.getData().getData()) {
                	
                
                	ItemStack item = reserve.getItem(i);

                	//if (item == dropn && item.getData().getData() == dropn.getData().getData()) {
                	//System.out.print(""+i+ " "+reserve.getItem(i).getItemMeta().getLore().get(2));
                		int q = Integer.valueOf(reserve.getItem(i).getItemMeta().getLore().get(2).replace("§bQuantité: §e", ""));

                		int quantité = q+dropn.getAmount();
                		int realquantité = q+dropn.getAmount();
                		
                		if(q >= 64) {
                			quantité = 64;
                		}
                		
                		ItemStack newitem = new ItemStack(item.getType(), quantité, item.getData().getData());
                		newitem.setAmount(quantité);
                	    ItemMeta itemmeta = newitem.getItemMeta();
            		    itemmeta.setDisplayName(itemmeta.getDisplayName());	
            		    ArrayList<String> lore = new ArrayList<>();
            		    lore.add("");
            		    lore.add("");
            		    lore.add("§bQuantité: §e"+realquantité);
            		    lore.add("");
            		    lore.add("");
            		    itemmeta.setLore(lore);	
            		    newitem.setItemMeta(itemmeta);
            		   // p.sendMessage("Quantité drop: "+dropn.getAmount()+" NewQ: "+realquantité);
            		    
            		    reserve.setItem(i, newitem);
            		    
            		    ReserveM.put(p, reserve);
                		break;
                		
                	}
                	
                
                
           } else if (i == 35){
        	   
       		ItemStack newitem = new ItemStack(dropn.getType(), dropn.getAmount(), dropn.getData().getData());
    	    ItemMeta itemmeta = newitem.getItemMeta();
		    itemmeta.setDisplayName(itemmeta.getDisplayName());	
		    ArrayList<String> lore = new ArrayList<>();
		    lore.add("");
		    lore.add("");
		    lore.add("§bQuantité: §e"+dropn.getAmount());
		    lore.add("");
		    lore.add("");
		    itemmeta.setLore(lore);	
		    newitem.setItemMeta(itemmeta);
		    
		    reserve.addItem(newitem);
		    
		    ReserveM.put(p, reserve);

    		break;
           }
			
			
            }
			
		}
		
		
		}
			
			
			
			

		
	}
}
