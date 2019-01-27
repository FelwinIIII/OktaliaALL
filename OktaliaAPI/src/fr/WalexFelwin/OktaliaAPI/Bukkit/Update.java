package fr.WalexFelwin.OktaliaAPI.Bukkit;


import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Update
{
  public Update(Main main) {}
  
  public static void Update(String qry)
  {
    try
    {
      Statement stmt = Main.conn.createStatement();
      stmt.executeUpdate(qry);
      
      stmt.close();
    }
    catch (Exception ex)
    {
    MySQLConnection.openConnection();
      System.err.println(ex);
    }
  }
  
  public static Connection getConnection()
  {
    return Main.conn;
  }
  
  public static ResultSet Query(String qry)
  {
    ResultSet rs = null;
    try
    {
      Statement stmt = Main.conn.createStatement();
      rs = stmt.executeQuery(qry);
    }
    catch (Exception ex)
    {
    	MySQLConnection.openConnection();
      System.err.println(ex);
    }
    return rs;
  }
}