package fr.walexmine.OktaliaAuth.listeners;

import fr.walexmine.OktaliaAuth.AuthPlugin;
import fr.walexmine.OktaliaAuth.data.DataUser;
import fr.walexmine.OktaliaAuth.managers.Config;
import fr.walexmine.OktaliaAuth.managers.CustomMessages;
import fr.walexmine.OktaliaAuth.utils.StringUtil;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerChatListener
  implements Listener
{
  @EventHandler(priority=-64)
  public void onChat(ChatEvent paramChatEvent)
  {
    if (!(paramChatEvent.getSender() instanceof ProxiedPlayer)) {
      return;
    }
    ProxiedPlayer localProxiedPlayer = (ProxiedPlayer)paramChatEvent.getSender();
    DataUser localDataUser = AuthPlugin.INSTANCE.getUser(localProxiedPlayer);
    if (((localDataUser.getPremium()) && (!localDataUser.mustRegister())) || ((localDataUser.isLogged()) && (localDataUser.isRegister()))) {
      return;
    }
    String str1 = paramChatEvent.getMessage().split(" ", 2)[0];
    if (!str1.startsWith("/"))
    {
      if (!Config.RESTRICTIONS_ALLOW0CHAT) {}
    }
    else {
      for (String str2 : Config.RESTRICTIONS_ALLOW0COMMANDS) {
        if (str1.equalsIgnoreCase(str2.toLowerCase())) {
          return;
        }
      }
    }
   
  }
}
