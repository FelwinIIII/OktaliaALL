package fr.WalexFelwin.OktaliaAPI.BungeeCord.CrashPinger;


import com.google.common.base.Strings;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.Main;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.Utils;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.CrashPinger.Pinger.BasicChannelInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.util.internal.PlatformDependent;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.BungeeServerInfo;
import net.md_5.bungee.ServerConnection;
import net.md_5.bungee.UserConnection;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.Title;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.netty.PipelineUtils;
import net.md_5.bungee.protocol.packet.KeepAlive;

public class Task
{
  private static final Random RANDOM = new Random();
  private static final TextComponent EMPTY = new TextComponent("");
  private final ReconnectOnCrash instance;
  private final ProxyServer bungee;
  private final UserConnection user;
  private final ServerConnection server;
  private final BungeeServerInfo target;
  private int tries;
  
  public Task(ReconnectOnCrash instance, ProxyServer bungee, UserConnection user, ServerConnection server)
  {
    this.instance = instance;
    this.bungee = bungee;
    this.user = user;
    this.server = server;
    this.target = server.getInfo();
  }
  
  public void tryReconnect()
  {
    if (this.tries + 1 > this.instance.getMaxReconnectTries())
    {
      this.instance.cancelReconnectTask(this.user.getUniqueId());
      
      ServerInfo def = this.bungee.getServerInfo(this.user.getPendingConnection().getListener().getFallbackServer());
      if (this.target != def)
      {
        this.server.setObsolete(true);
        this.user.connectNow(def);
        this.user.sendMessage(this.bungee.getTranslation("server_went_down", new Object[0]));
        if (!this.instance.getFailedTitle().isEmpty()) {
          this.user.sendTitle(createFailedTitle());
        } else {
          this.user.sendTitle(ProxyServer.getInstance().createTitle().reset());
        }
        if (!this.instance.getFailedActionBar().isEmpty()) {
          sendFailedActionBar(this.user);
        } else {
          this.user.sendMessage(ChatMessageType.ACTION_BAR, EMPTY);
        }
      }
      else
      {
        this.user.disconnect(this.bungee.getTranslation("lost_connection", new Object[0]));
      }
      return;
    }
    if (this.user.getPendingConnects().contains(this.target))
    {
      BungeeCord.getInstance().getLogger().warning("User already connecting to " + this.target);
      return;
    }
    this.user.getPendingConnects().add(this.target);
    
    this.tries += 1;
    if (!this.instance.getReconnectingTitle().isEmpty()) {
      createReconnectTitle().send(this.user);
    }
    if (!this.instance.getReconnectingActionBar().isEmpty()) {
      sendReconnectActionBar(this.user);
    }
    ChannelInitializer<Channel> initializer = new BasicChannelInitializer(this.bungee, this.user, this.target);
    ChannelFutureListener listener = new ChannelFutureListener()
    {
      public void operationComplete(ChannelFuture future)
        throws Exception
      {
        if (future.isSuccess())
        {
          Task.this.instance.cancelReconnectTask(Task.this.user.getUniqueId());
          if (!Task.this.instance.getConnectingTitle().isEmpty()) {
            Task.this.createConnectingTitle().send(Task.this.user);
            Task.this.user.sendMessage("§eVous avez été reconnecté(e) sur le serveur oktalia");
            Task.this.user.sendMessage("§cL'équipe de oktalia s'excuse pour ce dérangement ");
            Task.this.user.sendMessage("");
          }
          if (!Task.this.instance.getConnectingActionBar().isEmpty()) {
            Task.this.sendConnectActionBar(Task.this.user);
          }
        }
        else
        {
          future.channel().close();
          Task.this.user.getPendingConnects().remove(Task.this.target);
          
          Task.this.user.unsafe().sendPacket(new KeepAlive(Task.RANDOM.nextInt()));
          
          Utils.scheduleAsync(Task.this.instance, new Runnable()
          {
            public void run()
            {
              if ((Task.this.instance.isUserOnline(Task.this.user)) && (Objects.equals(Task.this.user.getServer(), Task.this.server))) {
                Task.this.tryReconnect();
              } else {
                Task.this.instance.cancelReconnectTask(Task.this.user.getUniqueId());
              }
            }
          }, Task.this.instance.getReconnectMillis(), TimeUnit.MILLISECONDS);
        }
      }
    };
    Bootstrap b = ((Bootstrap)((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().channel(PipelineUtils.getChannel())).group(this.server.getCh().getHandle().eventLoop())).handler(initializer)).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, Integer.valueOf(this.instance.getReconnectTimeout()))).remoteAddress(this.target.getAddress());
    if ((this.user.getPendingConnection().getListener().isSetLocalAddress()) && (!PlatformDependent.isWindows())) {
      b.localAddress(this.user.getPendingConnection().getListener().getHost().getHostString(), 0);
    }
    b.connect().addListener(listener);
  }
  
  private Title createReconnectTitle()
  {
    Title title = ProxyServer.getInstance().createTitle();
    title.title(EMPTY);
    title.subTitle(new TextComponent(this.instance.getReconnectingTitle().replace("{%dots%}", getDots())));
    
    title.stay((this.instance.getReconnectMillis() + this.instance.getReconnectTimeout() + 1000) / 1000 * 20);
    title.fadeIn(0);
    title.fadeOut(0);
    
    return title;
  }
  
  private void sendReconnectActionBar(UserConnection user)
  {
    user.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(this.instance.getReconnectingActionBar().replace("{%dots%}", getDots())));
  }
  
  private Title createConnectingTitle()
  {
    Title title = ProxyServer.getInstance().createTitle();
    title.title(EMPTY);
    title.subTitle(new TextComponent(this.instance.getConnectingTitle()));
    title.stay(20);
    title.fadeIn(10);
    title.fadeOut(10);
    
    return title;
  }
  
  private void sendConnectActionBar(UserConnection user)
  {
    user.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(this.instance.getConnectingActionBar()));
  }
  
  private Title createFailedTitle()
  {
    Title title = ProxyServer.getInstance().createTitle();
    title.title(EMPTY);
    title.subTitle(new TextComponent(this.instance.getFailedTitle()));
    title.stay(80);
    title.fadeIn(10);
    title.fadeOut(10);
    
    return title;
  }
  
  private void sendFailedActionBar(final UserConnection user)
  {
    user.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(this.instance.getFailedActionBar()));
    
    this.bungee.getScheduler().schedule(Main.instance, new Runnable()
    {
      public void run()
      {
        user.sendMessage(ChatMessageType.ACTION_BAR, Task.EMPTY);
      }
    }, 5L, TimeUnit.SECONDS);
  }
  
  private String getDots()
  {
    String dots = "";
    
    int i = 0;
    for (int max = this.tries % 4; i < max; i++) {
      dots = dots + ".";
    }
    return dots;
  }
  
  public void cancel()
  {
    if (this.instance.isUserOnline(this.user))
    {
      if ((!Strings.isNullOrEmpty(this.instance.getReconnectingTitle())) || (!Strings.isNullOrEmpty(this.instance.getConnectingTitle()))) {
        this.bungee.createTitle().reset().clear().send(this.user);
      }
      if (!Strings.isNullOrEmpty(this.instance.getConnectingActionBar())) {
        this.user.sendMessage(ChatMessageType.ACTION_BAR, EMPTY);
      }
    }
  }
}
