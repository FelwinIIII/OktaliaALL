package fr.walexmine.OktaliaAuth.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerPing.StatusResponse.Player;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.PluginMessage;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_Login;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_SendMessageSpigot;
import fr.walexmine.OktaliaAuth.AuthPlugin;
import fr.walexmine.OktaliaAuth.data.DataUser;
import fr.walexmine.OktaliaAuth.managers.Config;
import fr.walexmine.OktaliaAuth.utils.Logger;
import fr.walexmine.OktaliaAuth.utils.ServerValidate;
import fr.walexmine.RDOktalia.RandomHub.PlayerLocker;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.Callback;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerConnectListener
  implements Listener
{
	

	  public static HashMap<ProxiedPlayer, String> firstlog = new HashMap();
	  public static HashMap<ProxiedPlayer, String> Lastserv = new HashMap();



	public static void REPARTHUBP2(ProxiedPlayer p, String lastserv, int nbHub, int i, ServerInfo hubS){
       	 
       	 ServerInfo serv = null;
       	 
       	 if(Lastserv.get(p).equalsIgnoreCase("")) {
       		 
       			 serv = hubS;
       			 System.err.println("TEST1");
       	 } else 
       	 {
   			 System.err.println("TEST is not empty");
       		 serv = BungeeCord.getInstance().getServerInfo(Lastserv.get(p));
       	 }
       	 
       	 if(serv != null) {

   			 System.err.println("TEST2");
       		 if(nbHub == i) {

       			 System.err.println("TEST3");
	        		 if(hubS.getPlayers().size() > serv.getPlayers().size()) {
	        		 	 
   		        	 lastserv = serv.getName();
   		        	// serv.teleportPlayer(p);
   		        	 
	        		 	} else {
		        	
       			 	lastserv = hubS.getName();
       			 //	hubS.teleportPlayer(p);
       			 
	        		 	}

		       	      Lastserv.put(p, lastserv);
	       	         AuthPlugin.log.info(p.getName()+" REDIRECT FINAL: "+Lastserv.get(p));
	       	      Lastserv.remove(p);
	       	      
       		 } else {

       			 System.err.println("TEST4");
	        		 if(hubS.getPlayers().size() > serv.getPlayers().size()) {
	        		 	 
   		        	 lastserv = serv.getName();
        	 
	        		 } else {
		        	
       			 	lastserv = hubS.getName();
       			 
	        		 }

		       	      Lastserv.put(p, lastserv);
       		 }
       		 
       	 }
       		 
       	 
      
	}

	
	public static void REPARTHUB(final ProxiedPlayer p){
		
		String valide = "false";
		Lastserv.put(p, "");
		final String lastserv = Lastserv.get(p);	  
		
		final int nbHub = 5;
		
        
  		for(int i = 1; i <= nbHub; i++) {
  			
  			if(!valide.equalsIgnoreCase("false")){
  				
  			} else {
  				
  			final String hubserver = "hub"+i;
  			
	         final ServerInfo hubS = BungeeCord.getInstance().getServerInfo(hubserver);
	         
	         final int newwi = i;
	         
	         hubS.ping(new Callback<ServerPing>(){
	        	 boolean test = false;
	        	  @Override
	        	  public void done(ServerPing ping, Throwable throwable){
	        	    if(throwable == null){
	        	      //Server is online
	        	    	test = true;
	        	    	
	        	    	REPARTHUBP2(p, lastserv, nbHub, newwi, hubS);
	       	      
	       	        
	       	         AuthPlugin.log.info(p.getName()+" REDIRECT NB"+newwi+": Connectée "+hubserver);
	       	         
	       	         
	        	    } else {
		       	         AuthPlugin.log.info(p.getName()+" REDIRECT NB"+newwi+": Déconnectée "+hubserver);
		       	         
	        	    	if(nbHub == newwi) {

	   	       	         AuthPlugin.log.info(p.getName()+" REDIRECT FINAL:  "+Lastserv.get(p));
	        	    	}
	        	      //Server is offline
	        	    }
	        	  }
	        	});
	         
	         
	         
	        	 	
	        	 
	         }
		
	         
	         
  		}
	}
  @EventHandler(priority=96)
  public void onServerConnect(ServerConnectEvent paramServerConnectEvent)
  {
    ServerInfo localServerInfo = paramServerConnectEvent.getTarget();
    ProxiedPlayer p = paramServerConnectEvent.getPlayer();
    DataUser localDataUser = AuthPlugin.INSTANCE.getUser(paramServerConnectEvent.getPlayer());
    if (localDataUser == null) {
      return;
    }
  //  if (localDataUser.isLogged()) {
    	
    	if(firstlog.containsKey(p)) {
    		return;
    	} else {

    		//paramServerConnectEvent.setCancelled(true);
        	//firstlog.put(p, "true");
    	}

    	/*if(PluginMessage.HubRedirect.containsKey(p)) {
        	ServerInfo HUB = BungeeCord.getInstance().getServerInfo(PluginMessage.HubRedirect.get(p));
        	System.out.println(""+HUB.getName());
        	paramServerConnectEvent.setTarget(HUB);   		         	
        	firstlog.put(p, "true");
    	}*/

    	//REPARTHUB(p);	        	 
    	/*ServerInfo red = BungeeCord.getInstance().getServerInfo(Lastserv.get(p));
    	paramServerConnectEvent.setTarget(red);*/
   /*   return;
    }*/
    
    if ((localDataUser.getPremium()) && (!localDataUser.mustRegister())) {

    /*	ServerInfo hub1 = BungeeCord.getInstance().getServerInfo("hub1");
    	ServerInfo hub2 = BungeeCord.getInstance().getServerInfo("hub2");
    	
    	if(hub1.getPlayers().size() > hub2.getPlayers().size()) {
        	paramServerConnectEvent.setTarget(hub2);

        	
    	} else {        	
        	paramServerConnectEvent.setTarget(hub1);
    	}*/
    	
    	
      return;
    }
	/*PlayerLocker.lock(p);
	if(PlayerLocker.isLocked(p)) {
		System.out.println("LOCKED");
	}*//*
    int l = API_Login.getlogin(p);
	if(l == 1){
		return;
	}
	
	
	
	ServerInfo loginauth1 = BungeeCord.getInstance().getServerInfo("login1");
	ServerInfo loginauth2 = BungeeCord.getInstance().getServerInfo("login2");
	ServerInfo loginauth3 = BungeeCord.getInstance().getServerInfo("login3");
	ServerInfo loginauth4 = BungeeCord.getInstance().getServerInfo("login4");


	int loginsizeplayer1 = BungeeCord.getInstance().getServerInfo("login1").getPlayers().size();
	int loginsizeplayer2 = BungeeCord.getInstance().getServerInfo("login2").getPlayers().size();
	int loginsizeplayer3 = BungeeCord.getInstance().getServerInfo("login3").getPlayers().size();
	int loginsizeplayer4 = BungeeCord.getInstance().getServerInfo("login4").getPlayers().size();
	
	
	if(loginsizeplayer1 > loginsizeplayer2){
		
		
		paramServerConnectEvent.setTarget(loginauth2);
	
	} else {
		
		paramServerConnectEvent.setTarget(loginauth1);
	
	}*/
	//random--;
/*	if(loginauth1 != null){
		
		if(loginsizeplayer1 > loginsizeplayer2){

			paramServerConnectEvent.setTarget(loginauth2);
			
			if(loginsizeplayer2 > loginsizeplayer4){

				paramServerConnectEvent.setTarget(loginauth4);
			} else {

				paramServerConnectEvent.setTarget(loginauth2);
			}
				
		
		} else {
			paramServerConnectEvent.setTarget(loginauth1);
			
			if(loginsizeplayer1 > loginsizeplayer3){

				paramServerConnectEvent.setTarget(loginauth3);
			} else {

				paramServerConnectEvent.setTarget(loginauth1);
			}
		
		}
		
	} else {
	if(loginsizeplayer2 > loginsizeplayer3){
		
		
		paramServerConnectEvent.setTarget(loginauth3);
	
	} else {
		
		paramServerConnectEvent.setTarget(loginauth2);
	
	}
	}*/
	
	
  }
}
