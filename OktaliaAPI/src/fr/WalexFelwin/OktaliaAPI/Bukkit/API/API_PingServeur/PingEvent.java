package fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PingEvent extends Event implements Cancellable {
	
	private static final HandlerList handlers = new HandlerList();
	private ServerInfo server;
	private boolean cancelled;
	
	public PingEvent(ServerInfo server){
		this.server = server;
	}
	
	public HandlerList getHandlers() {
        return handlers;
    }
	
	public static HandlerList getHandlerList() {
        return handlers;
    }
	
	public ServerInfo getServer(){
		return server;
	}
	
	public void setCancelled(boolean cancel){
		this.cancelled = cancel;
	}

	public boolean isCancelled() {
		return cancelled;
	}
}
