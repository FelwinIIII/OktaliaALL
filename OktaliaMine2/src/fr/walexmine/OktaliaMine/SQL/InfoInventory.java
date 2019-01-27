package fr.walexmine.OktaliaMine.SQL;

import java.sql.SQLException;
import java.sql.Statement;

import fr.walexmine.OktaliaMine.Main;

public class InfoInventory {

	
	public static void createTable()
	  {
	    try
	    {
	      Statement state = Main.conn.createStatement();
	      state.executeUpdate("CREATE TABLE IF NOT EXISTS `InfoInventory` (`id` int(11) NOT NULL auto_increment,primary KEY (id), `UUID` VARCHAR(36), `Pseudo` VARCHAR(36), `ReserveMine` TEXT(5500))");
	      
	      System.out.println("OktaliaMine Table InfoInventory OK");
	    }
	    catch (SQLException e)
	    {
	      System.out.println("OktaliaMine n'a pas plus crée la table InfoInventory");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	  }
}
