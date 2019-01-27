package fr.walexmine.OktaliaAuth.listeners;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import fr.walexmine.OktaliaAuth.AuthPlugin;
import fr.walexmine.OktaliaAuth.data.DataUser;
import fr.walexmine.OktaliaAuth.managers.CustomMessages;
import fr.walexmine.OktaliaAuth.utils.StringUtil;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.scheduler.ScheduledTask;
import net.md_5.bungee.api.scheduler.TaskScheduler;
import net.md_5.bungee.event.EventHandler;

public class PostLoginListener
  implements Listener
{
  @EventHandler(priority=64)
  public void onPostLogin(PostLoginEvent e)
  {
    final ProxiedPlayer localProxiedPlayer = e.getPlayer();
    
    DataUser localDataUser = AuthPlugin.INSTANCE.getUser(localProxiedPlayer);
    localDataUser.setNick(localProxiedPlayer.getName());
    long l = System.currentTimeMillis();
    String str1 = localProxiedPlayer.getAddress().getAddress().getHostAddress();
    Boolean login = false;

    if ((localDataUser.getPremium()) && ((!localDataUser.mustRegister()) || (localDataUser.isRegister())))
    {
    	
      localDataUser.setLogged(true);
      localDataUser.setLastJoined(l);
      localDataUser.setLastIP(str1);
      localDataUser.update();
      localProxiedPlayer.sendMessage(TextComponent.fromLegacyText(StringUtil.fixMessage(CustomMessages.PLAYER_LOGGED0WITH0PREMIUM)));
    
      return;
    }


    localDataUser.setLogged(false);
  }
  
}