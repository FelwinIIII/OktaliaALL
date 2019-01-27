package fr.WalexFelwin.OktaliaAPI.Bukkit;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerInfo;

public class ServeurHubRegister {
	//
	// SERVEUR IP VPS & DEDIER
	//
	//

	static String SERVEUR_VPS1 = "localhost";
	static String SERVEUR_VPS2 = "";
	
	//
	//
	//
	//
	
	public static void RegisterServeur(){

		ServerInfo Hub1 = Main.getInstance().getPingAPI().addServer("Hub1", ""+SERVEUR_VPS1+"", 25566, 4000);
		Hub1.pingToServer();

		ServerInfo Hub2 = Main.getInstance().getPingAPI().addServer("Hub2", ""+SERVEUR_VPS1+"", 25567, 4000);
		Hub2.pingToServer();
		
		ServerInfo Hub3 = Main.getInstance().getPingAPI().addServer("Hub3", ""+SERVEUR_VPS1+"", 25568, 4000);
		Hub3.pingToServer();
		
		ServerInfo Hub4 = Main.getInstance().getPingAPI().addServer("Hub4", ""+SERVEUR_VPS1+"", 25569, 4000);
		Hub4.pingToServer();
		
		ServerInfo Hub5 = Main.getInstance().getPingAPI().addServer("Hub5", ""+SERVEUR_VPS1+"", 25570, 4000);
		Hub5.pingToServer();
	}
}


