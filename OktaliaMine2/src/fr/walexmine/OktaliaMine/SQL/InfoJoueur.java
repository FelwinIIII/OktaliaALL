package fr.walexmine.OktaliaMine.SQL;

import java.sql.SQLException;
import java.sql.Statement;

import fr.walexmine.OktaliaMine.Main;


public class InfoJoueur {
	
	public static void createTable()
	  {
	    try
	    {
	      Statement state = Main.conn.createStatement();
	      state.executeUpdate("CREATE TABLE IF NOT EXISTS `InfoMine` (`id` int(11) NOT NULL auto_increment,primary KEY (id), `UUID` VARCHAR(36), `Pseudo` VARCHAR(36), `Level` VARCHAR(36), `EXP` VARCHAR(36), `TEMPS` VARCHAR(36))");

	      System.out.println("OktaliaMine Table InfoMine OK");
	    }
	    catch (SQLException e)
	    {
	      System.out.println("OktaliaMine n'a pas plus crée la table InfoMine");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	  }
}
