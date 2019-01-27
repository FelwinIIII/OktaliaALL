package fr.WalexFelwin.OktaliaAuthLogin.MySql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update {
	
	  public static void Update(String qry)
	  {
	    try
	    {
	      Statement stmt = Mysql.conn.createStatement();
	      stmt.executeUpdate(qry);
	      
	      stmt.close();
	    }
	    catch (Exception ex)
	    {
	      Mysql.openConnection();
	      System.err.println(ex);
	    }
	  }
	  
	  public static Connection getConnection()
	  {
	    return Mysql.conn;
	  }
	  
	  public static ResultSet Query(String qry)
	  {
	    ResultSet rs = null;
	    try
	    {
	      Statement stmt = Mysql.conn.createStatement();
	      rs = stmt.executeQuery(qry);
	    }
	    catch (Exception ex)
	    {
	      Mysql.openConnection();
	      System.err.println(ex);
	    }
	    return rs;
	  }
}
