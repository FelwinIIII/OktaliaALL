package fr.walexmine.OktaliaMine.Inventaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.walexmine.OktaliaMine.API.API_Inventory;
import fr.walexmine.OktaliaMine.Event.PlayerBreak;

public class Reserve {

	  public static HashMap<Player, String> Reserve = new HashMap();

	  public static HashMap<Player, String> ReserveMine = new HashMap();

	  private static Inventory inv1;
	  private static Inventory inv2;
	
	  public static void RESERVE(Player p) {

		  inv1 = Bukkit.createInventory(null, 36, "§eReserve Factions");
		  

		  String a = Reserve.get(p);
		  
		  if(a.contains(",")) {
		  
		  		ArrayList<String> Names = new ArrayList<String>();
				
				ArrayList<String> Namess = new ArrayList<String>(Arrays.asList(a.split(",")));
				
				
				for(String s : Namess){
					Names.add(s);
				}
				
				int nbA =  Names.size();


		    	  for(int i = 1; i <= nbA; i++) {
		    		  
		    		  String b = Names.get(i-1);
		    		  
		    			 ArrayList<String> Block = new ArrayList<String>();
		    				
		    				ArrayList<String> Block2 = new ArrayList<String>(Arrays.asList(b.split("-")));
		    				
		    				
		    				for(String s : Block2){
		    					Block.add(s);
		    				}
		    				
		    				if(Block.get(0).contains(":")) {
			    	
							
							 ArrayList<String> DATA = new ArrayList<String>();
			    				
			    				ArrayList<String> Block3 = new ArrayList<String>(Arrays.asList(Block.get(0).split(":")));
			    				
			    				
			    				for(String s : Block3){
			    					DATA.add(s);
			    				}
			    				
			    				int data = Integer.valueOf(DATA.get(1).replace(" ", ""));
								int IDBlock = Integer.valueOf(DATA.get(0).replace(" ", ""));
								int Quantity = Integer.valueOf(Block.get(1).replace(" ", ""));
								
								
							
							API_Inventory.additemsfac(IDBlock, Quantity, data, inv1, "", i-1);
		    				
		    				} else {
								
								
				    				
									int IDBlock = Integer.valueOf(Block.get(0).replace(" ", ""));
									int Quantity = Integer.valueOf(Block.get(1).replace(" ", ""));
									
									
								
								API_Inventory.additemsfac(IDBlock, Quantity, 0, inv1, "", i-1);
			    				
		    				}
							
		    	  }
		  }
				p.openInventory(inv1);
	  }	  
	  
	  public static void RESERVEMINAGE(Player p) {

		  inv2 = Bukkit.createInventory(null, 36, "§eReserve Minage");
		  
		  
		  
		  p.openInventory(PlayerBreak.ReserveM.get(p));
	/*
		  if(ReserveMine.get(p).contains(",")) {
		  String a = ReserveMine.get(p);
			 ArrayList<String> Names = new ArrayList<String>();
				
				ArrayList<String> Namess = new ArrayList<String>(Arrays.asList(a.split(",")));
				
				
				for(String s : Namess){
					Names.add(s);
				}
				
				int nbA =  Names.size();

		    	  for(int i = 1; i <= nbA; i++) {
		    		  
		    		  String b = Names.get(i-1);
		    		  
		    			 ArrayList<String> Block = new ArrayList<String>();
		    				
		    				ArrayList<String> Block2 = new ArrayList<String>(Arrays.asList(b.split("-")));
		    				
		    				
		    				for(String s : Block2){
		    					Block.add(s);
		    				}
		    				
		    				if(Block.get(0).contains(":")) {
			    	
							
							 ArrayList<String> DATA = new ArrayList<String>();
			    				
			    				ArrayList<String> Block3 = new ArrayList<String>(Arrays.asList(Block.get(0).split(":")));
			    				
			    				
			    				for(String s : Block3){
			    					DATA.add(s);
			    				}
			    				int data;
			    				int IDBlock;
			    				int Quantity;
			    				
			    				if(DATA.get(0).contains(" ")) {
			    					
				    				IDBlock = Integer.valueOf(DATA.get(0).replace(" ", ""));
				    				
			    				} else {

				    				IDBlock = Integer.valueOf(DATA.get(0));
			    					
			    				}
			    					
			    				if (DATA.get(1).contains(" ")) {
			    					
			    					data = Integer.valueOf(DATA.get(1).replace(" ", ""));
				    				
			    				} else {

			    					data = Integer.valueOf(DATA.get(1));
			    					
			    				}
			    				
			    				if (Block.get(1).contains(" ")) {
			    					
				    				Quantity = Integer.valueOf(Block.get(1).replace(" ", ""));
				    				
			    				} else {
			    					
				    				Quantity = Integer.valueOf(Block.get(1));
			    					
			    				}
			    				
			    				data = Integer.valueOf(DATA.get(1).replace(" ", ""));
			    				IDBlock = Integer.valueOf(DATA.get(0).replace(" ", ""));
			    				Quantity = Integer.valueOf(Block.get(1).replace(" ", ""));
								
								
							
							API_Inventory.additems(IDBlock, Quantity, data, inv2, "", i-1);
		    				
		    				} else {
			    				int IDBlock;
			    				int Quantity;
			    				
			    			
			    					
			    				if (Block.get(0).contains(" ")) {
			    					
			    					IDBlock = Integer.valueOf(Block.get(0).replace(" ", ""));
				    				
			    				} else {

			    					IDBlock = Integer.valueOf(Block.get(0));
			    					
			    				}
			    				
			    				if (Block.get(1).contains(" ")) {
			    					
				    				Quantity = Integer.valueOf(Block.get(1).replace(" ", ""));
				    				
			    				} else {
			    					
				    				Quantity = Integer.valueOf(Block.get(1));
			    					
			    				}
								
				    				
									int IDBlock = Integer.valueOf(Block.get(0).replace(" ", ""));
									int Quantity = Integer.valueOf(Block.get(1).replace(" ", ""));
									
									
								
								API_Inventory.additems(IDBlock, Quantity, 0, inv2, "", i-1);
			    				
		    				}
							
		    	  }
				p.openInventory(inv2);
		  }
		  */
	  }
}
