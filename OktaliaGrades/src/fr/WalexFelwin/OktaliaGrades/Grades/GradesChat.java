package fr.WalexFelwin.OktaliaGrades.Grades;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.WalexFelwin.OktaliaGrades.Main;


public class GradesChat implements Listener{

	
	public GradesChat(Main main) {
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void Chat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		fr.WalexFelwin.OktaliaGrades.Chat_Tab.Chat.sendchatmessage(p.getName(), p, e.getMessage());
     	  e.setMessage(null);
     	  e.setCancelled(true);
	}
}
