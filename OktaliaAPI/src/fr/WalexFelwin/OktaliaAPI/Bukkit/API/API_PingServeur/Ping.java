package fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur;

import java.net.ConnectException;
import java.net.InetSocketAddress;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur.ServerPing.StatusResponse;

public class Ping implements Listener {
	
	private final Main plugin;
	
	public Ping(Main plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	

	public void ping(ServerInfo server){
		PingEvent event = new PingEvent(server);
		Bukkit.getPluginManager().callEvent(event);
	}
	
	@EventHandler
	public void onEvent(PingEvent e){
		if(!e.isCancelled()){
			ServerInfo server = e.getServer();
			if(!server.isLocal()){
				pingAsync(server);
			} else {
				final String status = server.getMotd();
				ServerListPingEvent ping = new ServerListPingEvent(new InetSocketAddress(Bukkit.getIp(), Bukkit.getPort()).getAddress(), Bukkit.getMotd(), Bukkit.getOnlinePlayers().size(), Bukkit.getMaxPlayers());
				Bukkit.getPluginManager().callEvent(ping);
				server.setProtocol(getBukkitVersion());
				server.setMotd(ping.getMotd());
				server.setPlayerCount(ping.getNumPlayers());
				server.setMaxPlayers(ping.getMaxPlayers());
				server.setPingStart(System.currentTimeMillis());
				server.setPingEnd(System.currentTimeMillis());
				server.setOnline(true);
				
				if(!server.getMotd().equals(status)){
					ServerChangeStatusEvent sevent = new ServerChangeStatusEvent(server, server.getMotd());
					plugin.callSyncEvent(sevent);
				}
			}
		}
	}
	
	private void pingAsync(final ServerInfo server){
		final ServerPing ping = server.getPing();
		if(!ping.isFetching()){
			Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable(){
				public void run() {
					long pingStartTime = System.currentTimeMillis();
					ping.setAddress(server.getAddress());
					ping.setTimeout(server.getTimeout());
					ping.setFetching(true);
					
					try {
						final String status = server.getMotd();
						StatusResponse response = ping.fetchData();
						server.setVersion(formatVersion(response.getVersion().getName()));
						server.setProtocol(response.getVersion().getProtocol());
						server.setMotd(response.getDescription());
						server.setPlayerCount(response.getPlayers().getOnline());
						server.setMaxPlayers(response.getPlayers().getMax());
						server.setPingStart(pingStartTime);
						server.setOnline(true);
						
						 ServerPingResponseEvent revent = new ServerPingResponseEvent(server, ping, response);
						plugin.callSyncEvent(revent);
						
						if(!server.getMotd().equals(status)){
							ServerChangeStatusEvent sevent = new ServerChangeStatusEvent(server, server.getMotd());
							plugin.callSyncEvent(sevent);
						}
					} catch(Exception e) {
						server.setOnline(false);
						if(!(e instanceof ConnectException)){
							System.out.println("[API-PingServeur] Erreur de récupération des données server: " + server.getAddress().toString());
							e.getCause();						}
					} finally {
						ping.setFetching(false);
						server.setPingEnd(System.currentTimeMillis());
					}
				}
			});
		}
	}
	
	private String getBukkitVersion(){
		String version = Bukkit.getVersion();
		version = version.replace("(", "");
		version = version.replace(")", "");
		version = version.split(" ")[2];
		return version;
	}
	
	private String formatVersion(String version) {
		char[] numbers = "0123456789".toCharArray();
		for (int i = 0; i < version.length(); i++){
			char c = version.charAt(i);
			for (char ch : numbers) {
				if (ch == c) {
					version = version.substring(i);
					break;
				}
			}
		}
		return version;
	}
}
