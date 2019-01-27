package fr.walexmine.OktaliaMine.Inventaire.Interact;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.entity.Player;

import fr.walexmine.OktaliaMine.Inventaire.Reserve;

public class Transfert {

	
	public static void addblockinv(Player p, int id, int nb, int data2) {
		

		String blocklist = Reserve.Reserve.get(p);
		
		if(blocklist.contains(id+":"+data2+" -")) {
			
			
			  String a = blocklist;
			  
				 ArrayList<String> Names = new ArrayList<String>();
					
					ArrayList<String> Namess = new ArrayList<String>(Arrays.asList(a.split(",")));
					
					
					for(String s : Namess){
						Names.add(s);
					}
					
					int nbA =  Names.size();

			    	  for(int i = 1; i <= nbA; i++) {
			    		  
			    		  String b = Names.get(i-1);
			    		   if(!b.contains("-")) {
			    			   
			    		   } else {
				    			 ArrayList<String> Block = new ArrayList<String>();
				    				
				    				ArrayList<String> Block2 = new ArrayList<String>(Arrays.asList(b.split("-")));
				    				
				    				
				    				for(String s : Block2){
				    					Block.add(s);
				    				}
				     				
									 ArrayList<String> DATA = new ArrayList<String>();
					    				
					    				ArrayList<String> Block3 = new ArrayList<String>(Arrays.asList(Block.get(0).split(":")));
					    				
					    				
					    				for(String s : Block3){
					    					DATA.add(s);
					    				}
					    				
					    				int data = Integer.valueOf(DATA.get(1).replace(" ", ""));
										int IDBlock = Integer.valueOf(DATA.get(0).replace(" ", ""));
										int Quantity = Integer.valueOf(Block.get(1).replace(" ", ""));
										
										
										if (IDBlock == id && data == data2) {
											
								//			p.sendMessage("Avant "+a);
											int newq = Quantity+nb;
											String newa = a.replace(b, id+":"+data2+" - "+newq);
											
									//		p.sendMessage("Apres: "+newa);
											Reserve.Reserve.put(p, newa);
										} else {
										//	p.sendMessage("No");
				
											}
									
									
				    	  }
			    		   }
		
			
			
			
					} else {
						
						
								
							  String a = blocklist;
							  
								 ArrayList<String> Names = new ArrayList<String>();
									
									ArrayList<String> Namess = new ArrayList<String>(Arrays.asList(a.split(",")));
									
									
									for(String s : Namess){
										Names.add(s);
									}
									
									int datan = data2;
									
									if (id == 295) {
										datan = 0;
									}
									
									String newlist = a+" "+id+":"+datan+" - "+nb+",";
											
											Reserve.Reserve.put(p, newlist);	
							
							
							
						
						
					}
	}
}
