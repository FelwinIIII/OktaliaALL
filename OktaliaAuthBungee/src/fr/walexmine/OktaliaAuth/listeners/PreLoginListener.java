package fr.walexmine.OktaliaAuth.listeners;


import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.mysql.jdbc.log.Log;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_SendMessageSpigot;
import fr.walexmine.OktaliaAuth.AuthPlugin;
import fr.walexmine.OktaliaAuth.data.DataUser;
import fr.walexmine.OktaliaAuth.managers.Config;
import fr.walexmine.OktaliaAuth.managers.CustomMessages;
import fr.walexmine.OktaliaAuth.utils.Logger;
import fr.walexmine.OktaliaAuth.utils.ServerValidate;
import fr.walexmine.OktaliaAuth.utils.StringUtil;
import fr.walexmine.OktaliaAuth.utils.validate.MojangValidate;
import fr.walexmine.OktaliaAuth.utils.validate.MojangValidateProfile;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ListenerInfo;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.PendingConnection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.event.EventHandler;

public class PreLoginListener
  implements Listener
{
  private final AuthPlugin plugin;
  
  public PreLoginListener(AuthPlugin paramAuthPlugin)
  {
    this.plugin = paramAuthPlugin;
  }
  
  @EventHandler(priority=64)
  public void onPreLogin(PreLoginEvent e) throws Throwable
  {
    PendingConnection playerpending = e.getConnection();
    String str1 = playerpending.getName();
    if (!str1.matches("[a-zA-Z0-9_]{3,16}"))
    {
      e.setCancelled(true);
      e.setCancelReason(StringUtil.fixMessage(CustomMessages.PLAYER_INVALID0NAME));
      return;
    }
    ProxiedPlayer localProxiedPlayer = ProxyServer.getInstance().getPlayer(str1);
 
    String str2 = playerpending.getAddress().getAddress().getHostAddress();
    
    UUID localUUID = playerpending.getUniqueId();
    if (localUUID == null)
    {
      String localObject1 = AuthPlugin.INSTANCE.UUID_NICKNAMES.getString(str1.toLowerCase());
      if ((localObject1 != null) && (!((String)localObject1).isEmpty()) && (((String)localObject1).split("-").length == 5)) {
        localUUID = UUID.fromString((String)localObject1);
      } else {
        localUUID = UUID.nameUUIDFromBytes(("OfflinePlayer:" + str1).getBytes(StandardCharsets.UTF_8));
      }
    }
    DataUser localObject1 = AuthPlugin.INSTANCE.getUser(str1, localUUID, false, true);
    if (localObject1 == null) {
      localObject1 = new DataUser(str1, str2);
    }
    if ((Config.ALLOWED_MULTIACCOUNTS0BLOCK_ONJOIN) && (!((DataUser)localObject1).getPremium()) && (!((DataUser)localObject1).isRegister()) && (!AuthPlugin.ALLOW.contains(str1.toLowerCase())))
    {
    	List<DataUser> localObject2 = AuthPlugin.INSTANCE.getUsersByIP(str2);
      if (((List)localObject2).size() > Config.ALLOWED_MULTIACCOUNTS)
      {
        int i = 0;
        Object localObject3 = null;
        for (DataUser localDataUser2 : localObject2) {
          
        if (localDataUser2.isRegister())
          {
            if (localDataUser2.getNick().equalsIgnoreCase(str1))
            {
              localObject3 = localDataUser2;
              break;
            }
            if ((!localDataUser2.getPremium()) && (!AuthPlugin.ALLOW.contains(localDataUser2.getNick()))) {
              i++;
            }
          }
        }
        if ((localObject3 == null) && (i > Config.ALLOWED_MULTIACCOUNTS))
        {
          e.setCancelled(true);
          e.setCancelReason(StringUtil.fixMessage(CustomMessages.MULTI0ACCOUNTS0LOGIN));
          return;
        }
      }
    }
    if (!((DataUser)localObject1).getChecked())
    {
    	MojangValidateProfile localObject2 = this.plugin.getMojangValidate().getPremiumProfile(str1);
      if ((localObject2 != null) && (((MojangValidateProfile)localObject2).isOnlineMode()))
      {
        ((DataUser)localObject1).setUuid(((MojangValidateProfile)localObject2).getUuid());
        ((DataUser)localObject1).setNick(((MojangValidateProfile)localObject2).getUser());
      }
      else if ((localObject2 == null) || (((MojangValidateProfile)localObject2).isError()))
      {
        e.setCancelled(true);
        e.setCancelReason(StringUtil.fixMessage(CustomMessages.MOJANGAPI0ERROR_KICK0REASON));
        return;
      }
      ((DataUser)localObject1).setPremium(((MojangValidateProfile)localObject2).isOnlineMode());
      ((DataUser)localObject1).setChecked(true);
      if ((((DataUser)localObject1).isRegister()) || ((((DataUser)localObject1).getPremium()) && (!((DataUser)localObject1).mustRegister())))
      {
        if (((MojangValidateProfile)localObject2).isOnlineMode())
        {
          DataUser localDataUser1 = AuthPlugin.INSTANCE.getUser(((MojangValidateProfile)localObject2).getUser(), ((MojangValidateProfile)localObject2).getUuid(), false, true);
          if (localDataUser1 != null) {
            ((DataUser)localObject1).setInDatabase(true);
          }
        }
        if (!((DataUser)localObject1).isInDatabase()) {
          ((DataUser)localObject1).insert();
        } else {
          ((DataUser)localObject1).update();
        }
      }
    }
   
    playerpending.setOnlineMode(((DataUser)localObject1).getPremium());
    if (!((DataUser)localObject1).getPremium())
    {
      playerpending.setUniqueId(localUUID);
      ((DataUser)localObject1).setUuid(localUUID);
      if (!((DataUser)localObject1).isInDatabase()) {
        ((DataUser)localObject1).insert();
      } else {
        ((DataUser)localObject1).update();
      }
    }
    if (playerpending.getUniqueId() != null) {
      AuthPlugin.INSTANCE.UUID_NICKNAMES.set(playerpending.getName().toLowerCase(), playerpending.getUniqueId().toString());
    }
    AuthPlugin.INSTANCE.getUsers().put(((DataUser)localObject1).toString(), localObject1);
    //Logger.info(new String[] { "Handled " + str1 + " [" + (((DataUser)localObject1).getPremium() ? "PREMIUM" : "NON-PREMIUM") + "]" + " [" + (playerpending.isOnlineMode() ? "PREMIUM" : "NON-PREMIUM") + "]" + (playerpending.getUniqueId() != null ? " [" + playerpending.getUniqueId() + "]" : "") });
    if(((DataUser)localObject1).getPremium()){
    	
    	Logger.info("&aConnection : &e"+str1+"&a Compte Prenium");
      /*  ServerInfo server2 = BungeeCord.getInstance().getServerInfo("hub1");
        API_SendMessageSpigot.sendmsgserver(str1, server2);*/
    } else {
    	Logger.info("&aConnection : &e"+str1+"&4 Compte cracké");

    }
  }
}
