package fr.WalexFelwin.OktaliaGrades.Grades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Update;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;
import fr.WalexFelwin.OktaliaGrades.Main;
import fr.WalexFelwin.OktaliaGrades.Chat_Tab.ChatUtils;
import fr.WalexFelwin.OktaliaGrades.Chat_Tab.Tab;


public class GradesJoin implements Listener{
	
	public GradesJoin(Main main){
		
	}
	

	@EventHandler(priority=EventPriority.HIGHEST)
	public void GradesJoin(PlayerLoginEvent e){
		
		Player p = e.getPlayer();
		

		String grades = null;
		//RegisterPlayer(p);
	try{
		PreparedStatement preparedStatement = fr.WalexFelwin.OktaliaAPI.Bukkit.Main.conn.prepareStatement("SELECT Grades FROM InfoGrades WHERE UUID = ?");
		preparedStatement.setString(1, p.getUniqueId().toString());
		
		ResultSet rs = preparedStatement.executeQuery();
		if(!rs.next()) {

			grades = "";
			
		} else {
			grades = rs.getString(1);
		}
		 
	} catch (SQLException e1) {

		e1.printStackTrace();
		
	}
		
		if(HASHMAP.Grades.containsKey(p)){

			HASHMAP.Grades.remove(p);
			  HASHMAP.Grades.put(p, ""+grades);
		} else {
			  HASHMAP.Grades.put(p, ""+grades);
		}
		// ADD TO TABLE PLAYER INFO GRADE
		//ReloadGrades.ReloadRank(p, grades);
	
	}
	
	public static void RegisterPlayer(Player p){
	
	    boolean exist = false;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `FinDuGrades` FROM `InfoGrades` WHERE `UUID`='" + p.getUniqueId() + "'");
	      while (rs.next()) {
	        exist = Boolean.valueOf(true).booleanValue();
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.println(err);
	      err.printStackTrace();
	    }
	    if (!exist) {
	      Update.Update("INSERT INTO `InfoGrades` (`UUID`, `Pseudo`, `Grades`, `Temps`) VALUES ('" + p.getUniqueId()+ "', '" + p.getName() + "', 'joueur', '0')");
	    }
		
	   
	    
	    
		
	}
	

	@EventHandler
	  public void playerjoin(PlayerJoinEvent e)
	  {
	    Player p = e.getPlayer();
	    String ip = p.getAddress().getHostString();
	
	    String grades = HASHMAP.Grades.get(p);
	    	
	    ReloadGrades.ReloadRank(p, grades);
	    
	    Tab.ReloadTeam(p);
	    	
	    p.setScoreboard(Tab.sb);
	    if(grades.equalsIgnoreCase("admin")){
	    	e.setJoinMessage(ChatUtils.getadminprefix()+p.getName()+"§e a rejoint le serveur");
	    } else if(grades.equalsIgnoreCase("developpeur")){
	    	e.setJoinMessage(ChatUtils.getdeveloppeurprefix()+p.getName()+"§e a rejoint le serveur");
	    } else if(grades.equalsIgnoreCase("gerant")){
	    	e.setJoinMessage(ChatUtils.getgerantprefix()+p.getName()+"§e a rejoint le serveur");
	    } else if(grades.equalsIgnoreCase("moderateur")){
	    	e.setJoinMessage(ChatUtils.getmodoprefix()+p.getName()+"§e a rejoint le serveur");
	    } else if(grades.equalsIgnoreCase("moderatrice")){
	    	e.setJoinMessage(ChatUtils.getmodaprefix()+p.getName()+"§e a rejoint le serveur");
	    } else if(grades.equalsIgnoreCase("ami")){
	    	e.setJoinMessage(ChatUtils.amiprefix()+p.getName()+"§e a rejoint le serveur");
	    } else if(grades.equalsIgnoreCase("buildeur")){
	    	e.setJoinMessage(ChatUtils.builderprefix()+p.getName()+"§e a rejoint le serveur");
	    } else if(grades.equalsIgnoreCase("youtubeur")){
	    	e.setJoinMessage(ChatUtils.getyoutubeurprefix()+p.getName()+"§e a rejoint le serveur");
	    } else {
	    	e.setJoinMessage(null);
	    }
	    
  }

}
