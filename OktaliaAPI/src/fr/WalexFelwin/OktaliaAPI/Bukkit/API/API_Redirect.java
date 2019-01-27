package fr.WalexFelwin.OktaliaAPI.Bukkit.API;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerInfo;

public class API_Redirect {

	
	public static void HubSelect(Player p){
		String valide = "false";
  		for(int i = 1; i <= 5; i++) {
  			if(!valide.equalsIgnoreCase("false")){
  				
  			} else {
  			String hubserver = "Hub"+i;
  			
	         ServerInfo hubS = Main.getInstance().getPingAPI().getServer(hubserver);
	         hubS.pingToServer();

	         String ServeurOnline = (hubS.isOnline() ? "En Ligne" : "Déconnectée");
	         if(!hubserver.equalsIgnoreCase(Bukkit.getServerName())){
	         
	         if(ServeurOnline.equalsIgnoreCase("En Ligne")){
	        	 if(hubS.getPlayerCount()==hubS.getMaxPlayers()){
	        		 
	        	 } else {
	        		 valide = "true";
		        	 hubS.teleportPlayer(p);
		        	 p.sendMessage("§c[Systéme] §aVous avez été redirigez vers le hub "+i);
	        	 }
	         }
		
	         }}
  		}
	}	
	public static String WANTHUB(String p){
		
		
		String lastserv = "";	  
		
		int nbHub = 5;
		
  		for(int i = 1; i <= nbHub; i++) {
  			System.out.println("NBL: "+i+" ");

  				
  			String hubserver = "Hub"+i;
  			
	         ServerInfo hubS = Main.getInstance().getPingAPI().getServer(hubserver);
	         hubS.pingToServer();

	         String ServeurOnline = (hubS.isOnline() ? "En Ligne" : "Déconnectée");
	        
	         
	         if(!hubserver.equalsIgnoreCase(Bukkit.getServerName())){
	         
	         if(ServeurOnline.equalsIgnoreCase("En Ligne")){
	        	 
	        	 ServerInfo serv = null;
	        	 
	        	 if(!lastserv.equalsIgnoreCase("")) {
	        		 
	        			 serv = Main.getInstance().getPingAPI().getServer(lastserv);

	        	  			//lastserv = hubserver;
	        	  			
	        	  			
	         	  			serv.pingToServer();
	        	 	     		
	        	        			 
	        		        		 if(hubS.getPlayerCount() > serv.getPlayerCount()) {
	        		        		 	 
	        	    		        	 lastserv = serv.getName();
	        	    	        	 
	        		        		 	} else {
	            		        	
	        	        			 	lastserv = hubS.getName();
	        	        			 	
	        	        			 
	        		        		 	}

	     	        	     		System.out.println("SERV SELECT "+i+" "+lastserv);
	        		        		 
	        	        		 
	        	        	 
	        	 } else {
	        		 
	        		 lastserv = hubS.getName();	
	        		 System.out.println("addserv "+lastserv);


	        	 }
	        	 
	         }
	       
	        	 	
	        	 
	         }
		
    		 if(nbHub == i) {
    			 System.out.println("SERVER FINAL REDIRECT "+lastserv);
    			 return lastserv;
    		 }
	         
  			
  		}
  		
  		return "notfound";
	}
	
	
	public static void REPARTHUB(Player p){
		
		String valide = "false";
		
		String lastserv = "";	  
		
		int nbHub = 5;
		
  		for(int i = 1; i <= nbHub; i++) {
  			
  			if(!valide.equalsIgnoreCase("false")){
  				
  			} else {
  				
  			String hubserver = "Hub"+i;
  			
	         ServerInfo hubS = Main.getInstance().getPingAPI().getServer(hubserver);
	         hubS.pingToServer();

	         String ServeurOnline = (hubS.isOnline() ? "En Ligne" : "Déconnectée");
	        
	         
	         if(!hubserver.equalsIgnoreCase(Bukkit.getServerName())){
	         
	         if(ServeurOnline.equalsIgnoreCase("En Ligne")){
	        	 
	        	 ServerInfo serv = null;
	        	 
	        	 if(!lastserv.equalsIgnoreCase("")) {
	        		 
	        			 serv = Main.getInstance().getPingAPI().getServer(lastserv);
	        	 }
	        	 
	        	 if(serv != null) {
	        		 
	        		 if(nbHub == i) {
	        			 
		        		 if(hubS.getPlayerCount() > serv.getPlayerCount()) {
		        		 	 
	    		        	 lastserv = serv.getName();
	    		        	 serv.teleportPlayer(p);
	    	        	 
		        		 	} else {
    		        	
	        			 	lastserv = hubS.getName();
	        			 	hubS.teleportPlayer(p);
	        			 
		        		 	}
	        			 
	        		 } else {
	        			 
		        		 if(hubS.getPlayerCount() > serv.getPlayerCount()) {
		        		 	 
	    		        	 lastserv = serv.getName();
 	        	 
	        		 } else {
    		        	
	        			 	lastserv = hubS.getName();
	        			 
	        		 }
		        		 
	        		 }
	        		 

	        		 
	        	 }
	       
	        	 	
	        	 
	         }
		
	         }
	         }
  		}
	}
}
