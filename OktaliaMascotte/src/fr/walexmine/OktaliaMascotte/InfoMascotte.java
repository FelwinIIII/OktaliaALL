package fr.walexmine.OktaliaMascotte;

import java.sql.SQLException;
import java.sql.Statement;


public class InfoMascotte {

	public static void createTable()
	  {
	    try
	    {
	      Statement state = Main.conn.createStatement();																																							
	      state.executeUpdate("CREATE TABLE IF NOT EXISTS `InfoMascotte` (`id` INT(11), `UUID` VARCHAR(100), `Pseudo` VARCHAR(100), `Wither` VARCHAR(100), `Blaze` VARCHAR(100), `Loup` VARCHAR(100), `Golem` VARCHAR(100), `TempsWither` VARCHAR(100), `TempsBlaze` VARCHAR(100), `TempsLoup` VARCHAR(100), `TempsGolem` VARCHAR(100))");
	    }																																																																																								
	    catch (SQLException e)
	    {
	      System.out.println("Oktalia n'a pas plus crée la table d'info Mascotte du joueur ");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	  }
}
