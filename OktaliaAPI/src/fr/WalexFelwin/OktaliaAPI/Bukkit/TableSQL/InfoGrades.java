package fr.WalexFelwin.OktaliaAPI.Bukkit.TableSQL;

import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.ChatColor;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;


public class InfoGrades {
	
	  public static void createTable()
	  {
	    try
	    {
	      Statement state = Main.conn.createStatement();
	      state.executeUpdate("CREATE TABLE IF NOT EXISTS `InfoGrades` (`id` int(11) NOT NULL auto_increment,primary KEY (id), `UUID` VARCHAR(36), `Pseudo` VARCHAR(36), `Grades` VARCHAR(100), `Temps` VARCHAR(100))");
	    }
	    catch (SQLException e)
	    {
	      System.out.println(ChatColor.RED+"OktaliaAPI n'a pas plus crée la table d'info grades des joueurs ");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	  }
}
