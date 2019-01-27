package fr.WalexFelwin.OktaliaHub.Event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import fr.WalexFelwin.OktaliaHub.Main;
import fr.WalexFelwin.OktaliaHub.API.API_HubPlayer;

public class MOTD implements Listener{

	
	public MOTD(Main main){
		
	}
	
	@EventHandler
	public void motdchange(ServerListPingEvent e){
		
		int dev = API_HubPlayer.dev.get("dev");
		int gerant = API_HubPlayer.gerant.get("gerant");
		int admin = API_HubPlayer.admin.get("admin");
		int modo = API_HubPlayer.modo.get("modo");
		int moda = API_HubPlayer.moda.get("moda");
		int manager = API_HubPlayer.manager.get("manager");
		int buildeur = API_HubPlayer.buildeur.get("buildeur");
		int yt = API_HubPlayer.youtubeur.get("youtubeur");
		int ami = API_HubPlayer.ami.get("ami");
		int vip = API_HubPlayer.vip.get("vip");
		int joueur = API_HubPlayer.joueur.get("joueur");
		e.setMotd("O - 0,D - "+dev+",G - "+gerant+",A - "+admin+",MO - "+modo+",MA - "+moda+",MN - "+manager+",B - "+buildeur+",Y - "+yt+",AM - "+ami+",V - "+vip+",J - "+joueur);
		
	}
}
