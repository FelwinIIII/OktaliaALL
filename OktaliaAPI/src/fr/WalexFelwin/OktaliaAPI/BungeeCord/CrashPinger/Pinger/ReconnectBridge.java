package fr.WalexFelwin.OktaliaAPI.BungeeCord.CrashPinger.Pinger;


import com.google.common.base.Objects;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.CrashPinger.ReconnectOnCrash;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.ServerConnection;
import net.md_5.bungee.UserConnection;
import net.md_5.bungee.Util;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.config.ListenerInfo;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.event.ServerKickEvent.State;
import net.md_5.bungee.api.plugin.PluginManager;
import net.md_5.bungee.chat.ComponentSerializer;
import net.md_5.bungee.connection.CancelSendSignal;
import net.md_5.bungee.connection.DownstreamBridge;
import net.md_5.bungee.connection.InitialHandler;
import net.md_5.bungee.protocol.packet.Kick;

public class ReconnectBridge
  extends DownstreamBridge
{
  private final ReconnectOnCrash instance;
  private final ProxyServer bungee;
  private final UserConnection user;
  private final ServerConnection server;
  
  public ReconnectBridge(ReconnectOnCrash instance, ProxyServer bungee, UserConnection user, ServerConnection server)
  {
    super(bungee, user, server);
    this.instance = instance;
    this.bungee = bungee;
    this.user = user;
    this.server = server;
  }
  
  public void exception(Throwable t)
    throws Exception
  {
    if (this.server.isObsolete()) {
      return;
    }
    this.server.setObsolete(true);
    if (!this.instance.fireServerReconnectEvent(this.user, this.server))
    {
      ServerInfo def = this.bungee.getServerInfo(this.user.getPendingConnection().getListener().getFallbackServer());
      if (this.server.getInfo() != def)
      {
        this.user.connectNow(def);
        this.user.sendMessage(this.bungee.getTranslation("server_went_down", new Object[0]));
      }
      else
      {
        this.user.disconnect(Util.exception(t));
      }
    }
    else
    {
      this.instance.reconnectIfOnline(this.user, this.server);
    }
  }
  
  public void handle(Kick kick)
    throws Exception
  {
    ServerInfo def = this.bungee.getServerInfo(this.user.getPendingConnection().getListener().getFallbackServer());
    if (Objects.equal(this.server.getInfo(), def)) {
      def = null;
    }
    ServerKickEvent event = (ServerKickEvent)this.bungee.getPluginManager().callEvent(new ServerKickEvent(this.user, this.server.getInfo(), ComponentSerializer.parse(kick.getMessage()), def, ServerKickEvent.State.CONNECTED));
    if ((event.isCancelled()) && (event.getCancelServer() != null))
    {
      this.user.connectNow(event.getCancelServer());
    }
    else
    {
      String kickMessage = ChatColor.stripColor(BaseComponent.toLegacyText(ComponentSerializer.parse(kick.getMessage())));
      
      boolean doReconnect = false;
      if ((this.instance.getShutdownMessage() != null) && (this.instance.getShutdownMessage().equals(kickMessage))) {
        doReconnect = true;
      } else if ((this.instance.getShutdownMessage() == null) && (this.instance.getShutdownPattern() != null)) {
        try
        {
          doReconnect = this.instance.getShutdownPattern().matcher(kickMessage).matches();
        }
        catch (Exception e)
        {
          BungeeCord.getInstance().getLogger().warning("Could not match shutdown-pattern " + this.instance.getShutdownPattern().pattern());
        }
      }
      if ((!doReconnect) || (!this.instance.fireServerReconnectEvent(this.user, this.server))) {
        this.user.disconnect0(event.getKickReasonComponent());
      } else {
        this.instance.reconnectIfOnline(this.user, this.server);
      }
    }
    this.server.setObsolete(true);
    
    throw CancelSendSignal.INSTANCE;
  }
}
