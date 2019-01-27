package fr.WalexFelwin.OktaliaHub;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerInfo;

public class ServeurRegister {
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


		ServerInfo Faction = fr.WalexFelwin.OktaliaAPI.Bukkit.Main.getInstance().getPingAPI().addServer("Faction", ""+SERVEUR_VPS1+"", 25580, 4000);
		Faction.pingToServer();
		ServerInfo Minage = fr.WalexFelwin.OktaliaAPI.Bukkit.Main.getInstance().getPingAPI().addServer("Minage", ""+SERVEUR_VPS1+"", 25581, 4000);
		Minage.pingToServer();


	}
}
