package fr.WalexFelwin.OktaliaAPI.BungeeCord.CrashPinger;

import com.google.common.base.Strings;
import com.google.common.io.ByteStreams;
import com.google.common.io.Files;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.CrashPinger.API.ServerReconnectEvent;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.CrashPinger.Pinger.ReconnectBridge;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.BungeeServerInfo;
import net.md_5.bungee.ServerConnection;
import net.md_5.bungee.UserConnection;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.netty.ChannelWrapper;
import net.md_5.bungee.netty.HandlerBoss;

public class ReconnectOnCrash
  implements Listener
{
  private String reconnectingTitle = "&9Reconnexion en cours §7{%dots%}";
  private String reconnectingActionBar = "&a&lNe vous déconnectez pas! Vous serez reconnectée au serveur automatiquement dès que possible";
  private String connectingTitle = "&aConnexion..";
  private String connectingActionBar = "&a§lConnexion vers le serveur ..";
  private String failedTitle = "&4§l Reconnexion échouée !";
  private String failedActionBar = "&cVous allez être dirigée sur un serveur d'attente !";
  private int maxReconnectTries = 40;
  private int reconnectMillis = 2000;
  private int reconnectTimeout = 10000;
  private List<String> ignoredServers = new ArrayList();
  private String shutdownMessage = "Server closed";
  private Pattern shutdownPattern = null;
  private HashMap<UUID, Task> reconnectTasks = new HashMap();
  

  
  @EventHandler
  public void onServerSwitch(ServerSwitchEvent event)
  {
    ProxyServer bungee = BungeeCord.getInstance();
    UserConnection user = (UserConnection)event.getPlayer();
    ServerConnection server = user.getServer();
    ChannelWrapper ch = server.getCh();
    
    ReconnectBridge bridge = new ReconnectBridge(this, bungee, user, server);
    ((HandlerBoss)ch.getHandle().pipeline().get(HandlerBoss.class)).setHandler(bridge);
    if (isReconnecting(user.getUniqueId())) {
      cancelReconnectTask(user.getUniqueId());
    }
  }
  
  public boolean fireServerReconnectEvent(UserConnection user, ServerConnection server)
  {
    if (this.ignoredServers.contains(server.getInfo().getName())) {
      return false;
    }
    ServerReconnectEvent event = (ServerReconnectEvent)BungeeCord.getInstance().getPluginManager().callEvent(new ServerReconnectEvent(user, server.getInfo()));
    return !event.isCancelled();
  }
  
  public boolean isUserOnline(UserConnection user)
  {
    return BungeeCord.getInstance().getPlayer(user.getUniqueId()) != null;
  }
  
  public void reconnectIfOnline(UserConnection user, ServerConnection server)
  {
    if (isUserOnline(user))
    {
      if (!isReconnecting(user.getUniqueId())) {
        reconnect(user, server);
      }
    }
    else {
      cancelReconnectTask(user.getUniqueId());
    }
  }
  
  private void reconnect(UserConnection user, ServerConnection server)
  {
	  Task reconnectTask = (Task)this.reconnectTasks.get(user.getUniqueId());
    if (reconnectTask == null) {
      this.reconnectTasks.put(user.getUniqueId(), reconnectTask = new Task(this, BungeeCord.getInstance(), user, server));
    }
    reconnectTask.tryReconnect();
  }
  
  void cancelReconnectTask(UUID uuid)
  {
    Task task = (Task)this.reconnectTasks.remove(uuid);
    if ((task != null) && (BungeeCord.getInstance().getPlayer(uuid) != null)) {
      task.cancel();
    }
  }
  
  public boolean isReconnecting(UUID uuid)
  {
    return this.reconnectTasks.containsKey(uuid);
  }
  
  public String getReconnectingTitle()
  {
    return ChatColor.translateAlternateColorCodes('&', this.reconnectingTitle);
  }
  
  public String getReconnectingActionBar()
  {
    return ChatColor.translateAlternateColorCodes('&', this.reconnectingActionBar);
  }
  
  public String getConnectingTitle()
  {
    return ChatColor.translateAlternateColorCodes('&', this.connectingTitle);
  }
  
  public String getConnectingActionBar()
  {
    return ChatColor.translateAlternateColorCodes('&', this.connectingActionBar);
  }
  
  public String getFailedTitle()
  {
    return ChatColor.translateAlternateColorCodes('&', this.failedTitle);
  }
  
  public String getFailedActionBar()
  {
    return ChatColor.translateAlternateColorCodes('&', this.failedActionBar);
  }
  
  public int getMaxReconnectTries()
  {
    return this.maxReconnectTries;
  }
  
  public int getReconnectMillis()
  {
    return this.reconnectMillis;
  }
  
  public int getReconnectTimeout()
  {
    return this.reconnectTimeout;
  }
  
  public String getShutdownMessage()
  {
    return this.shutdownMessage;
  }
  
  public Pattern getShutdownPattern()
  {
    return this.shutdownPattern;
  }
}

