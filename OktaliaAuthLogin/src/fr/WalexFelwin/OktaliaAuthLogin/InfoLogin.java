package fr.WalexFelwin.OktaliaAuthLogin;

import java.sql.SQLException;
import java.sql.Statement;

import fr.WalexFelwin.OktaliaAuthLogin.MySql.Mysql;


public class InfoLogin {
	  
	  public static void createTable()
	  {
	    try
	    {
	      Statement state = Mysql.conn.createStatement();
	      state.executeUpdate("CREATE TABLE IF NOT EXISTS `InfoLogin` (`id` INT, `Pseudo` VARCHAR(36), `motsdepasse` VARCHAR(36), `Register` VARCHAR(36), `Login` INT, `IP` VARCHAR(100))");
	    }
	    catch (SQLException e)
	    {
	      System.out.println("InfoPlayer n'a pas plus cr�e la table ");
	      System.err.println(e);
	      e.printStackTrace();
	    }
	  }
}
