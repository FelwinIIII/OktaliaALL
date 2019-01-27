package fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur;

import java.util.List;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;


/**
 * This is the API class.
 */
public class PingAPI {
	
	/**
	 * This method adds a server in the plugin.
	 * String name = The name of the server where you are pinging to.
	 * (Name of server in Bungeecord is recommended!).
	 * String address = The IP of the server where you are pinging to (without port).
	 * int port = The port of the server where you are pinging to.
	 * int timeout = The timout for the ping.
	 */
	public ServerInfo addServer(String name, String address, int port, int timeout){
		ServerInfo server = new ServerInfo(name, address, port, timeout);
		Main.getInstance().getServers().add(server);
		return server;
	}
	
	/**
	 * This method removes a server of the plugin.
	 * You can't get a server anymore after removing it!
	 */
	public boolean removeServer(String name){
		for(ServerInfo server : Main.getInstance().getServers()){
			if(server.getName().equals(name)){
				Main.getInstance().getServers().remove(server);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * You can get a server with this method, identified by the server name!
	 */
	public ServerInfo getServer(String name){
		for(ServerInfo server : Main.getInstance().getServers()){
			if(server.getName().equals(name)){
				return server;
			}
		}
		return null;
	}
	
	/**
	 * You can check if a server is registered with the name of it!
	 */
	public boolean existServer(String name){
		for(ServerInfo server : Main.getInstance().getServers()){
			if(server.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns a list of all registered servers!
	 */
	public List<ServerInfo> getServers(){
		return Main.getInstance().getServers();
	}
}
