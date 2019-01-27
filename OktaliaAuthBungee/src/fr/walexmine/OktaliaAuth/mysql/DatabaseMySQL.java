package fr.walexmine.OktaliaAuth.mysql;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import fr.walexmine.OktaliaAuth.AuthPlugin;
import fr.walexmine.OktaliaAuth.managers.Config;
import fr.walexmine.OktaliaAuth.utils.Logger;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.scheduler.TaskScheduler;

public class DatabaseMySQL
  extends Database
{
  public boolean connect()
  {
    MysqlDataSource localMysqlDataSource = new MysqlDataSource();
    localMysqlDataSource.setServerName(Config.MYSQL_HOST);
    localMysqlDataSource.setDatabaseName(Config.MYSQL_BASE);
    localMysqlDataSource.setUser(Config.MYSQL_USER);
    localMysqlDataSource.setPassword(Config.MYSQL_PASS);
    localMysqlDataSource.setPort(Config.MYSQL_PORT);
    try
    {
      this.conn = localMysqlDataSource.getConnection();
    }
    catch (SQLException localSQLException)
    {
      Logger.warning(new String[] { "Can not connect to a MySQL server!", "Error: " + localSQLException.getMessage() });
      localSQLException.printStackTrace();
    }
    ProxyServer.getInstance().getScheduler().schedule(AuthPlugin.INSTANCE, new Runnable()
    {
      public void run()
      {
        if (DatabaseMySQL.this.time <= System.currentTimeMillis() - TimeUnit.SECONDS.toMillis(30L)) {
          DatabaseMySQL.this.update(false, "DO 1");
        }
      }
    }, 15L, 15L, TimeUnit.SECONDS);
    
    return isConnected();
  }
  
  public void reconnect()
  {
    if (isConnected()) {
      disconnect();
    }
    connect();
  }
}
