package fr.WalexFelwin.OktaliaGrades;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.WalexFelwin.OktaliaGrades.Chat_Tab.Tab;
import fr.WalexFelwin.OktaliaGrades.Grades.GradesChat;
import fr.WalexFelwin.OktaliaGrades.Grades.GradesJoin;
import fr.WalexFelwin.OktaliaGrades.Grades.GradesQuitt;


public class Main extends JavaPlugin implements Listener{ 


	public void onEnable() {
		
	    Tab.sb = Bukkit.getScoreboardManager().getNewScoreboard();
	    Tab.obj = Tab.sb.registerNewObjective("dummy", "begin");
	    Tab.registerTeams();
	    Tab.setprefixtab();
	    registerevent();
	}
	
	public void onDisable() {

	}
	
	  public static Plugin getplPlugin(){
		  
		  return Bukkit.getPluginManager().getPlugin("LuminacyGrades");
		  
	  }
	public void registerevent(){

	    PluginManager pm = getServer().getPluginManager();
	    getServer().getPluginManager().registerEvents(this, this);

	    pm.registerEvents(new GradesJoin(this), this);
	    pm.registerEvents(new GradesQuitt(this), this);
	    pm.registerEvents(new GradesChat(this), this);
	}
}
