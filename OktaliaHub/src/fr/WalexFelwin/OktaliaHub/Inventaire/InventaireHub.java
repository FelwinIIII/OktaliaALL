package fr.WalexFelwin.OktaliaHub.Inventaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Inventaire;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerInfo;
import fr.WalexFelwin.OktaliaGrades.Chat_Tab.ChatUtils;
import fr.WalexFelwin.OktaliaHub.API.API_HubPlayer;

public class InventaireHub {
	private static Inventory inv1;
	

	  public static HashMap<Player, String> InvHub = new HashMap();
	  
	
	  public static void Inventory(Player p)
	  {
		  
		  inv1 = Bukkit.createInventory(null, 9, "§aListe des Hubs");
		  
		    
	  		for(int i = 1; i <= 5; i++) {
	  			String hubserver = "Hub"+i;
	  			
		         ServerInfo hubS = Main.getInstance().getPingAPI().getServer(hubserver);
		         hubS.pingToServer();

		         String ServeurOnline = (hubS.isOnline() ? "En Ligne" : "Déconnectée");
		         
		         if(ServeurOnline.equalsIgnoreCase("En Ligne")){


						 System.out.println(hubserver+": "+ServeurOnline);
						 
		        	 if(hubserver.replace("Hub", "Lobby").equalsIgnoreCase(Bukkit.getServerName())){
			        	 String player = hubS.getMotd();
							 ArrayList<String> Names = new ArrayList<String>();
							
							ArrayList<String> Namess = new ArrayList<String>(Arrays.asList(player.split(",")));
							
							
							for(String s : Namess){
								Names.add(s);
							}
							
							
							int dev = Integer.valueOf(Names.get(1).replace("D - ", ""));
							int gerant = Integer.valueOf(Names.get(2).replace("G - ", ""));
							int admin = Integer.valueOf(Names.get(3).replace("A - ", ""));
							int modo = Integer.valueOf(Names.get(4).replace("MO - ", ""));
							int moda = Integer.valueOf(Names.get(5).replace("MA - ", ""));
							int manager = Integer.valueOf(Names.get(6).replace("MN - ", ""));
							int buildeur = Integer.valueOf(Names.get(7).replace("B - ", ""));
							int yt = Integer.valueOf(Names.get(8).replace("Y - ", ""));
							int ami = Integer.valueOf(Names.get(9).replace("AM - ", ""));
							int vip = Integer.valueOf(Names.get(10).replace("V - ", ""));
							int joueur = Integer.valueOf(Names.get(11).replace("J - ", ""));
							
							
							 ArrayList<String> HubLore = new ArrayList();
							 HubLore.add("");
							 HubLore.add("§7Présence (§e"+hubS.getPlayerCount()+"§7/§e"+hubS.getMaxPlayers()+"§7)");
							 HubLore.add("");
						
							 if(dev != 0){
							 HubLore.add("§7"+dev+" "+ChatUtils.getdeveloppeurprefix());
							 }
							 if(gerant != 0){
							 HubLore.add("§7"+gerant+" "+ChatUtils.getgerantprefix());
							 }
							 if(admin != 0){
							 HubLore.add("§7"+admin+" "+ChatUtils.getadminprefix());
							 }
							 if(modo != 0){
							 HubLore.add("§7"+modo+" "+ChatUtils.getmodoprefix());
							 }
							 if(moda != 0){
							 HubLore.add("§7"+moda+" "+ChatUtils.getmodaprefix());
							 }
							 if(manager != 0){
							 HubLore.add("§7"+manager+" "+ChatUtils.getmanagerprefix());
							 }
							 if(buildeur != 0){
							 HubLore.add("§7"+buildeur+" "+ChatUtils.builderprefix());
							 }
							 if(yt != 0){
							 HubLore.add("§7"+yt+" "+ChatUtils.getyoutubeurprefix());
							 }
							 if(ami != 0){
							 HubLore.add("§7"+ami+" "+ChatUtils.amiprefix());
							 }
							 if(vip != 0){
							 HubLore.add("§7"+vip+" "+ChatUtils.getVIPprefix());
							 }
							 if(joueur != 0){
							 HubLore.add("§7"+joueur+" Joueur(s)");
							 }
							 HubLore.add("");
							 
			         API_Inventaire.additems(159, hubS.getPlayerCount(), 5, inv1, "§aHub "+i+" §7(Hub Actuele)", HubLore, i-1);
		        	 } else {
			        	 String player = hubS.getMotd();
							 ArrayList<String> Names = new ArrayList<String>();
							
							ArrayList<String> Namess = new ArrayList<String>(Arrays.asList(player.split(",")));
							
							
							for(String s : Namess){
								Names.add(s);
							}
							
							int dev = Integer.valueOf(Names.get(1).replace("D - ", ""));
							int gerant = Integer.valueOf(Names.get(2).replace("G - ", ""));
							int admin = Integer.valueOf(Names.get(3).replace("A - ", ""));
							int modo = Integer.valueOf(Names.get(4).replace("MO - ", ""));
							int moda = Integer.valueOf(Names.get(5).replace("MA - ", ""));
							int manager = Integer.valueOf(Names.get(6).replace("MN - ", ""));
							int buildeur = Integer.valueOf(Names.get(7).replace("B - ", ""));
							int yt = Integer.valueOf(Names.get(8).replace("Y - ", ""));
							int ami = Integer.valueOf(Names.get(9).replace("AM - ", ""));
							int vip = Integer.valueOf(Names.get(10).replace("V - ", ""));
							int joueur = Integer.valueOf(Names.get(11).replace("J - ", ""));
							
							
							 ArrayList<String> HubLore = new ArrayList();
							 HubLore.add("");
							 HubLore.add("§7Présence (§e"+hubS.getPlayerCount()+"§7/§e"+hubS.getMaxPlayers()+"§7)");
							 HubLore.add("");
						
							 if(dev != 0){
							 HubLore.add("§7"+dev+" "+ChatUtils.getdeveloppeurprefix());
							 }
							 if(gerant != 0){
							 HubLore.add("§7"+gerant+" "+ChatUtils.getgerantprefix());
							 }
							 if(admin != 0){
							 HubLore.add("§7"+admin+" "+ChatUtils.getadminprefix());
							 }
							 if(modo != 0){
							 HubLore.add("§7"+modo+" "+ChatUtils.getmodoprefix());
							 }
							 if(moda != 0){
							 HubLore.add("§7"+moda+" "+ChatUtils.getmodaprefix());
							 }
							 if(manager != 0){
							 HubLore.add("§7"+manager+" "+ChatUtils.getmanagerprefix());
							 }
							 if(buildeur != 0){
							 HubLore.add("§7"+buildeur+" "+ChatUtils.builderprefix());
							 }
							 if(yt != 0){
							 HubLore.add("§7"+yt+" "+ChatUtils.getyoutubeurprefix());
							 }
							 if(ami != 0){
							 HubLore.add("§7"+ami+" "+ChatUtils.amiprefix());
							 }
							 if(vip != 0){
							 HubLore.add("§7"+vip+" "+ChatUtils.getVIPprefix());
							 }
							 if(joueur != 0){
							 HubLore.add("§7"+joueur+" Joueur(s)");
							 }
							 HubLore.add("");
		        		 
		        	 API_Inventaire.additems(159, hubS.getPlayerCount(), 5, inv1, "§aHub "+i, HubLore, i-1);
		        	 }
			   
		         } else {
		        	 
		        	 API_Inventaire.additems(159, 0, 9, inv1, "§4§l✖ §cHub "+i+" §4§l✖", null, i-1);
		        	 
		         }
		       
		         }
	  		
	  		InvHub.put(p, "");
	         


		    p.openInventory(inv1);
	  }
}
