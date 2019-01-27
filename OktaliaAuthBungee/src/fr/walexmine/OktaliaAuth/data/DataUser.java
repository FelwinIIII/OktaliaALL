package fr.walexmine.OktaliaAuth.data;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import fr.walexmine.OktaliaAuth.AuthPlugin;
import fr.walexmine.OktaliaAuth.managers.Config;
import fr.walexmine.OktaliaAuth.mysql.Database;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.scheduler.ScheduledTask;

public class DataUser
{
  private UUID uuid;
  private String nick;
  private String pass;
  private String firstIP;
  private String lastIP;
  private boolean premium;
  private boolean checked;
  private boolean registeredByAdmin;
  private long firstJoined;
  private long lastJoined;
  private boolean isInDatabase;
  private ServerInfo targetServer;
  private boolean loggedIn;
  private ScheduledTask messageTask;
  private long lastDisconnected;
  
  public DataUser(String paramString1, String paramString2)
  {
    this(null, paramString1, paramString2);
  }
  
  public DataUser(UUID paramUUID, String paramString1, String paramString2)
  {
    this.uuid = paramUUID;
    setNick(paramString1);
    setFirstIP(paramString2);
    setLastIP(paramString2);
    long l = System.currentTimeMillis();
    setFirstJoined(l);
    setLastJoined(l);
  }
  
  public DataUser(ResultSet paramResultSet) throws SQLException
  {
    String str = paramResultSet.getString(Config.MYSQL_TABLES_UUID);
    if ((str != null) && (str.split("-").length == 5)) {
      this.uuid = UUID.fromString(str);
    }
    this.nick = paramResultSet.getString(Config.MYSQL_TABLES_NICK);
    this.pass = paramResultSet.getString(Config.MYSQL_TABLES_PASSWORD);
    if ((this.pass != null) && (this.pass.isEmpty())) {
      this.pass = null;
    }
    this.premium = paramResultSet.getBoolean(Config.MYSQL_TABLES_PREMIUM);
    this.firstIP = paramResultSet.getString(Config.MYSQL_TABLES_FIRSTIP);
    this.lastIP = paramResultSet.getString(Config.MYSQL_TABLES_LASTIP);
    this.firstJoined = paramResultSet.getLong(Config.MYSQL_TABLES_FIRSTJOIN);
    this.lastJoined = paramResultSet.getLong(Config.MYSQL_TABLES_LASTJOIN);
    this.checked = paramResultSet.getBoolean(Config.MYSQL_TABLES_CHECKED);
    this.registeredByAdmin = paramResultSet.getBoolean(Config.MYSQL_TABLES_REGISTERBYAMIN);
    this.isInDatabase = true;
  }
  
  public void setNick(String paramString)
  {
    this.nick = paramString;
  }
  
  
  
  public void setUuid(UUID paramUUID)
  {
    this.uuid = paramUUID;
  }
  
  public void setPremium(boolean paramBoolean)
  {
    this.premium = paramBoolean;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.checked = paramBoolean;
  }
  
  public void setFirstIP(String paramString)
  {
    this.firstIP = paramString;
  }
  
  public void setLastIP(String paramString)
  {
    this.lastIP = paramString;
  }
  
  public void setFirstJoined(long paramLong)
  {
    this.firstJoined = paramLong;
  }
  
  public void setInDatabase(boolean paramBoolean)
  {
    this.isInDatabase = paramBoolean;
  }
  
  public void setLastJoined(long paramLong)
  {
    this.lastJoined = paramLong;
    setLastDisconnected(0L);
  }
  
  public void setRegisteredByAdmin(boolean paramBoolean)
  {
    this.registeredByAdmin = paramBoolean;
  }
  
  public String getNick()
  {
    return this.nick;
  }
  
  public String getPassword()
  {
    return this.pass;
  }
  
  public boolean getPremium()
  {
    return (this.premium) && (Config.ENABLE0PREMIUM0AUTH) && (!AuthPlugin.INSTANCE.canLoginWithoutPremium(this.nick));
  }
  
  public UUID getUuid()
  {
    return this.uuid;
  }
  
  public boolean mustRegister()
  {
    return (!getPremium()) || (Config.PREMIUM0REGISTER) || (AuthPlugin.INSTANCE.premiumNicknameMustLoginWithRegister(this.nick));
  }
  
  public boolean getChecked()
  {
    return this.checked;
  }
  
  public String getFirstIP()
  {
    return this.firstIP;
  }
  
  public String getLastIP()
  {
    return this.lastIP;
  }
  
  public long getFirstJoined()
  {
    return this.firstJoined;
  }
  
  public long getLastJoined()
  {
    return this.lastJoined;
  }
  
  public boolean isInDatabase()
  {
    return this.isInDatabase;
  }
  
  public boolean getRegisteredByAdmin()
  {
    return this.registeredByAdmin;
  }
  
  public boolean isRegister()
  {
    return (getPassword() != null) && (!getPassword().isEmpty()) && (getPassword().length() != 0);
  }
  
  public boolean isActiveSession()
  {
    long l = System.currentTimeMillis() - (this.lastDisconnected <= 0L ? this.lastJoined : this.lastDisconnected);
    
    return (Config.SESSION_ENABLED) && (l <= Config._SESSION_TIME);
  }
  
  public ServerInfo getTargetServer()
  {
    return this.targetServer;
  }
  
  public void setTargetServer(ServerInfo paramServerInfo)
  {
    this.targetServer = paramServerInfo;
  }
  
  public boolean isLogged()
  {
    return this.loggedIn;
  }
  
  public void setLogged(boolean paramBoolean)
  {
    this.loggedIn = paramBoolean;
  }
  
  public ScheduledTask getMessageTask()
  {
    return this.messageTask;
  }
  
  public void setMessageTask(ScheduledTask paramScheduledTask)
  {
    this.messageTask = paramScheduledTask;
  }
  
  public long getLastDisconnected()
  {
    return this.lastDisconnected;
  }
  
  public void setLastDisconnected(long paramLong)
  {
    this.lastDisconnected = paramLong;
  }
  
  public boolean isOnline()
  {
    ProxiedPlayer localProxiedPlayer = ProxyServer.getInstance().getPlayer(this.nick);
    return localProxiedPlayer != null;
  }
  
  public void insert()
  {
    try
    {
      PreparedStatement localPreparedStatement = AuthPlugin.INSTANCE.BASE.preparedStatement(String.format("INSERT INTO `%s` (`%s`, `%s`, `%s`, `%s`, `%s`, `%s`, `%s`, `%s`, `%s`, `%s`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new Object[] { Config.MYSQL_TABLE, Config.MYSQL_TABLES_UUID, Config.MYSQL_TABLES_NICK, Config.MYSQL_TABLES_PASSWORD, Config.MYSQL_TABLES_PREMIUM, Config.MYSQL_TABLES_FIRSTIP, Config.MYSQL_TABLES_LASTIP, Config.MYSQL_TABLES_FIRSTJOIN, Config.MYSQL_TABLES_LASTJOIN, Config.MYSQL_TABLES_CHECKED, Config.MYSQL_TABLES_REGISTERBYAMIN }));
      
      localPreparedStatement.setString(1, this.uuid.toString());
      localPreparedStatement.setString(2, this.nick);
      localPreparedStatement.setString(3, this.pass);
      localPreparedStatement.setBoolean(4, this.premium);
      localPreparedStatement.setString(5, this.firstIP);
      localPreparedStatement.setString(6, this.lastIP);
      localPreparedStatement.setLong(7, this.firstJoined);
      localPreparedStatement.setLong(8, this.lastJoined);
      localPreparedStatement.setBoolean(9, this.checked);
      localPreparedStatement.setBoolean(10, this.registeredByAdmin);
      
      AuthPlugin.INSTANCE.BASE.update(false, localPreparedStatement);
      
      this.isInDatabase = true;
    }
    catch (SQLException localSQLException) {}
  }
  
  public void update()
  {
    try
    {
      PreparedStatement localPreparedStatement = AuthPlugin.INSTANCE.BASE.preparedStatement(String.format("UPDATE `%s` SET `%s`=?,`%s`=?,`%s`=?,`%s`=?,`%s`=?,`%s`=?,`%s`=?,`%s`=?,`%s`=?,`%s`=? WHERE `%s`=? OR `%s`=?", new Object[] { Config.MYSQL_TABLE, Config.MYSQL_TABLES_UUID, Config.MYSQL_TABLES_NICK, Config.MYSQL_TABLES_PASSWORD, Config.MYSQL_TABLES_PREMIUM, Config.MYSQL_TABLES_FIRSTIP, Config.MYSQL_TABLES_LASTIP, Config.MYSQL_TABLES_FIRSTJOIN, Config.MYSQL_TABLES_LASTJOIN, Config.MYSQL_TABLES_CHECKED, Config.MYSQL_TABLES_REGISTERBYAMIN, Config.MYSQL_TABLES_NICK, Config.MYSQL_TABLES_UUID }));
      
      localPreparedStatement.setString(1, this.uuid == null ? null : this.uuid.toString());
      localPreparedStatement.setString(2, this.nick);
      localPreparedStatement.setString(3, this.pass);
      localPreparedStatement.setBoolean(4, this.premium);
      localPreparedStatement.setString(5, this.firstIP);
      localPreparedStatement.setString(6, this.lastIP);
      localPreparedStatement.setLong(7, this.firstJoined);
      localPreparedStatement.setLong(8, this.lastJoined);
      localPreparedStatement.setBoolean(9, this.checked);
      localPreparedStatement.setBoolean(10, this.registeredByAdmin);
      localPreparedStatement.setString(11, this.nick);
      localPreparedStatement.setString(12, this.uuid == null ? "EMPTY_UUID" : this.uuid.toString());
      
      AuthPlugin.INSTANCE.BASE.update(false, localPreparedStatement);
    }
    catch (SQLException localSQLException) {}
  }
  
  public void delete()
  {
    try
    {
      PreparedStatement localPreparedStatement = AuthPlugin.INSTANCE.BASE.preparedStatement(String.format("DELETE FROM `%s` WHERE `%s`=?", new Object[] { Config.MYSQL_TABLE, this.uuid == null ? Config.MYSQL_TABLES_NICK : Config.MYSQL_TABLES_UUID }));
      
      localPreparedStatement.setString(1, this.uuid == null ? this.nick : this.uuid.toString());
      
      AuthPlugin.INSTANCE.BASE.update(false, localPreparedStatement);
      
      this.isInDatabase = false;
    }
    catch (SQLException localSQLException) {}
  }
  
  public void remove()
  {
    AuthPlugin.INSTANCE.getUsers().remove(toString());
  }
  
  private String getValue(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      String str = (String)paramObject;
      if (str.isEmpty()) {
        return "''";
      }
      return "'" + str + "'";
    }
    if (paramObject == null) {
      return "''";
    }
    return paramObject.toString();
  }
  
  public String toString()
  {
    return this.uuid == null ? this.nick.toLowerCase() : this.uuid.toString();
  }
}
