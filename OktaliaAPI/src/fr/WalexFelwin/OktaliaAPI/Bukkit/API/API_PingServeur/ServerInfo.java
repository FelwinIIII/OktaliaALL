package fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;



/**
 * This is the class which allows you to ping & to get info to & from the servers that you defined with the PingAPI.
 */
public class ServerInfo {
	
	private ServerPing ping;
	private String name;
	private InetSocketAddress address;
	private int timeout;
	private boolean local;
	private boolean online;
	private int playercount;
	private int maxplayers;
	private String motd;
	private String version;
	private String protocol;
	private long pingStartTime;
	private long pingEndTime;
	
	/**
	 * This constructor makes a new Server and is being stored in the Pinger.java class.
	 */
	
	public ServerInfo(String servername, String address, int port, int timeout){
		this.ping = new ServerPing();
		this.online = false;
		this.name = servername;
	    this.address = new InetSocketAddress(address, port);
	    this.timeout = timeout;
	    this.pingStartTime = System.currentTimeMillis();
	    this.pingEndTime = System.currentTimeMillis();
	    
	    if(Bukkit.getServer().getIp().equals(address) && Bukkit.getServer().getPort() == Integer.valueOf(port)){
	    	this.local = true;
	    }
	}
	
	/**
	 * Return the ping of the server. (ServerPing.java)
	 */
	public ServerPing getPing(){
		return ping;
	}
	
	public void setPing(ServerPing ping){
		this.ping = ping;
	}
	
	/**
	 * Returns the name of the server which has been set while creating it.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of a server.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the address of a server.
	 */
	public InetSocketAddress getAddress(){
		return address;
	}
	
	/**
	 * Sets the address of the server.
	 */
	public void setAddress(InetSocketAddress address){
		this.address = address;
	}
	   
	/**
	 * Returns the timeout time of the server, which has been set while creating it.
	 */
	public int getTimeout(){
        return this.timeout;
	}
  
	/**
	 * Sets the timeout of the server.
	 */
	public void setTimeout(int timeout){
	    this.timeout = timeout;
	}
	   
	/**
	 * Returns if the server is local or not.
	 * It will be true when the address = Bukkit.getServer().getIp(); and the port = Bukkit.getServer().getPort();
	 */
    public boolean isLocal(){
		return local;
	}

	/**
	 * Sets the local status.
	 */
	public void setLocal(boolean local) {
		this.local = local;
	}

	/**
	 * Returns the status of the server, if it's online or not.
	 */
	public boolean isOnline(){
	    return this.online;
	}
	
	/**
	 * Sets the status of the server, online or not.
	 */
	public void setOnline(boolean online){
	    this.online = online;
	}
	
	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * Returns the version of the server.
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Sets the version of the server.
	 */
	public void setVersion(String version){
		this.version = version;
	}

	/**
	 * Returns the playercount of the server.
	 */
	public int getPlayerCount(){
	    return this.playercount;
	}
	   
	/**
	 * Sets the playercount of the server.
	 */
	public void setPlayerCount(int playercount){
	    this.playercount = playercount;
	}
	   
	/**
	 * Returns the max player count of the server.
	 */
	public int getMaxPlayers(){
	    return this.maxplayers;
	}
	   
	/**
	 * Sets the max player count of the server.
	 */
	public void setMaxPlayers(int maxplayers){
	    this.maxplayers = maxplayers;
	}
	   
	/**
	 * Returns the motd of the server.
	 */
	public String getMotd(){
	    return this.motd;
	}
	  
	/**
	 * Sets the motd of the server.
	 */
	public void setMotd(String motd){
	    this.motd = motd;
	}
	
	/**
	 * Returns the ping delay of the server.
	 */
	public long getPingDelay(){
		return this.calculatePingDelay();
	}
	
	/**
	 * Sets the ping start of the server.
	 */
	public void setPingStart(long time){
		this.pingStartTime = time;
	}
	
	/**
	 * Sets the ping end of the server.
	 */
	public void setPingEnd(long time){
		this.pingEndTime = time;
	}
	
	/**
	 * Resets the ping delay.
	 */
	public void resetPingDelay(){
		this.pingStartTime = System.currentTimeMillis();
	}
	
	private long calculatePingDelay(){
		long result = (this.pingEndTime - this.pingStartTime);
		return result;
	}
	
	/**
	 * Pings to the server!
	 * VERY IMPORTANT, use this to ping to the server!
	 */
	public void pingToServer(){
		Main.getInstance().getPinger().ping(this);
	}
	
	/**
	 * Teleport the player to the server in the BungeeCord.
	 * This is being based on the server name.
	 */
	public void teleportPlayer(Player player){
		
        String ServeurOnline = (this.isOnline() ? "En Ligne" : "Déconnectée");
        if(ServeurOnline.equalsIgnoreCase("Déconnectée")) {
        	player.sendMessage("§cLe serveur "+this.name+" n'est pas accessible" );
        return;
        }
		
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
				
		try {
			out.writeUTF("Connect");
			out.writeUTF(this.name);
			out.writeUTF(""+player.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(Main.getInstance(), "BungeeInterconnect", b.toByteArray());
	}
}
