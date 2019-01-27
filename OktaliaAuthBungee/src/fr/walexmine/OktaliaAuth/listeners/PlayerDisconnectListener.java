package fr.walexmine.OktaliaAuth.listeners;



import fr.WalexFelwin.OktaliaAPI.BungeeCord.PluginMessage;
import fr.walexmine.OktaliaAuth.AuthPlugin;
import fr.walexmine.OktaliaAuth.data.DataUser;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.scheduler.ScheduledTask;
import net.md_5.bungee.event.EventHandler;

public class PlayerDisconnectListener
  implements Listener
{
  @EventHandler
  public void onPlayerDisconnect(PlayerDisconnectEvent paramPlayerDisconnectEvent)
  {
    ProxiedPlayer localProxiedPlayer = paramPlayerDisconnectEvent.getPlayer();
    
    DataUser localDataUser = AuthPlugin.INSTANCE.getUser(localProxiedPlayer, false, false);
    if (localDataUser == null) {
      return;
    }
    localDataUser.setLogged(false);
    localDataUser.setTargetServer(null);
    if (localDataUser.getMessageTask() != null)
    {
      localDataUser.getMessageTask().cancel();
      localDataUser.setMessageTask(null);
    }
    if ((!localDataUser.isRegister()) && (localDataUser.mustRegister())) {
      localDataUser.remove();
    } else if (((localDataUser.isRegister()) && (localDataUser.isLogged())) || (localDataUser.getPremium())) {
      localDataUser.setLastDisconnected(System.currentTimeMillis());
    }
    ServerConnectListener.firstlog.remove(localProxiedPlayer);
    PluginMessage.HubRedirect.remove(localProxiedPlayer);
  }
}
