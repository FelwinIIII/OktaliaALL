package fr.walexmine.OktaliaAuth.mysql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Executor;

import fr.walexmine.OktaliaAuth.AuthPlugin;
import fr.walexmine.OktaliaAuth.utils.Logger;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.scheduler.TaskScheduler;
import net.md_5.bungee.api.scheduler.TaskScheduler.Unsafe;

public abstract class Database
{
  protected Connection conn;
  protected long time;
  protected Executor executor;
  
  public Database()
  {
    this.executor = ProxyServer.getInstance().getScheduler().unsafe().getExecutorService(AuthPlugin.INSTANCE);
  }
  
  public Connection getConnection()
  {
    return this.conn;
  }
  
  public abstract boolean connect();
  
  public void disconnect()
  {
    try
    {
      this.conn.close();
    }
    catch (SQLException localSQLException)
    {
      Logger.warning(new String[] { "Can not close the connection to the MySQL server!", "Error: " + localSQLException.getMessage() });
      localSQLException.printStackTrace();
    }
  }
  
  public abstract void reconnect();
  
  public boolean isConnected()
  {
    try
    {
      return (this.conn != null) && (!this.conn.isClosed());
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return false;
  }
  
  public PreparedStatement preparedStatement(String paramString)
  {
    if (!isConnected()) {
      connect();
    }
    try
    {
      return this.conn.prepareStatement(paramString);
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return null;
  }
  
  public ResultSet query(PreparedStatement paramPreparedStatement)
  {
    if (!isConnected()) {
      connect();
    }
    try
    {
      return paramPreparedStatement.executeQuery();
    }
    catch (SQLException localSQLException1)
    {
      try
      {
        paramPreparedStatement.close();
      }
      catch (SQLException localSQLException2) {}
      localSQLException1.printStackTrace();
    }
    return null;
  }
  
  public ResultSet query(String paramString)
  {
    if (!isConnected()) {
      connect();
    }
    try
    {
      return this.conn.createStatement().executeQuery(paramString);
    }
    catch (SQLException localSQLException)
    {
      Logger.warning(new String[] { "An error occurred with given query '" + paramString + "'!", "Error: " + localSQLException.getMessage() });
      localSQLException.printStackTrace();
    }
    return null;
  }
  
  public void update(boolean paramBoolean, final PreparedStatement paramPreparedStatement)
  {
    if (paramPreparedStatement == null) {
      return;
    }
    if (!isConnected()) {
      connect();
    }
    this.time = System.currentTimeMillis();
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        try
        {
          PreparedStatement localPreparedStatement = paramPreparedStatement;Object localObject1 = null;
          try
          {
            localPreparedStatement.executeUpdate();
          }
          catch (Throwable localThrowable2)
          {
            localObject1 = localThrowable2;throw localThrowable2;
          }
          finally
          {
            if (localPreparedStatement != null) {
              if (localObject1 != null) {
                try
                {
                  localPreparedStatement.close();
                }
                catch (Throwable localThrowable3)
                {
                  ((Throwable)localObject1).addSuppressed(localThrowable3);
                }
              } else {
                localPreparedStatement.close();
              }
            }
          }
        }
        catch (SQLException localSQLException)
        {
          localSQLException.printStackTrace();
        }
      }
    };
    if (paramBoolean) {
      local1.run();
    } else {
      this.executor.execute(local1);
    }
  }
  
  public void update(boolean paramBoolean1, final String paramString, final boolean paramBoolean2)
  {
    if (!isConnected()) {
      connect();
    }
    this.time = System.currentTimeMillis();
    Runnable local2 = new Runnable()
    {
      public void run()
      {
        try
        {
          Statement localStatement = Database.this.conn.createStatement();Object localObject1 = null;
          try
          {
            localStatement.executeUpdate(paramString);
          }
          catch (Throwable localThrowable2)
          {
            localObject1 = localThrowable2;throw localThrowable2;
          }
          finally
          {
            if (localStatement != null) {
              if (localObject1 != null) {
                try
                {
                  localStatement.close();
                }
                catch (Throwable localThrowable3)
                {
                  ((Throwable)localObject1).addSuppressed(localThrowable3);
                }
              } else {
                localStatement.close();
              }
            }
          }
        }
        catch (SQLException localSQLException)
        {
          if (!paramBoolean2) {
            return;
          }
          Logger.warning(new String[] { "An error occurred with given query '" + paramString + "'!", "Error: " + localSQLException.getMessage() });
          localSQLException.printStackTrace();
        }
      }
    };
    if (paramBoolean1) {
      local2.run();
    } else {
      this.executor.execute(local2);
    }
  }
  
  public void update(boolean paramBoolean, String paramString)
  {
    update(paramBoolean, paramString, true);
  }
}
