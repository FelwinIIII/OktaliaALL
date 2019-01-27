package fr.walexmine.OktaliaAuth;


import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.walexmine.OktaliaAuth.data.DataUser;
import fr.walexmine.OktaliaAuth.listeners.PlayerChatListener;
import fr.walexmine.OktaliaAuth.listeners.PlayerDisconnectListener;
import fr.walexmine.OktaliaAuth.listeners.PostLoginListener;
import fr.walexmine.OktaliaAuth.listeners.PreLoginListener;
import fr.walexmine.OktaliaAuth.listeners.ServerConnectListener;
import fr.walexmine.OktaliaAuth.managers.Config;
import fr.walexmine.OktaliaAuth.managers.CustomMessages;
import fr.walexmine.OktaliaAuth.mysql.Database;
import fr.walexmine.OktaliaAuth.mysql.DatabaseMySQL;
import fr.walexmine.OktaliaAuth.tasks.DeleteRedundantUsersFromMemoryTask;
import fr.walexmine.OktaliaAuth.utils.StringUtil;
import fr.walexmine.OktaliaAuth.utils.validate.MojangValidate;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import net.md_5.bungee.api.scheduler.ScheduledTask;
import net.md_5.bungee.api.scheduler.TaskScheduler;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class AuthPlugin
  extends Plugin
{
  public Database BASE;
  public static AuthPlugin INSTANCE;
  public static List<String> ALLOW = new ArrayList();
  private static ConcurrentHashMap<String, DataUser> USERS = new ConcurrentHashMap();
  private MojangValidate mojangValidate;
  private static ScheduledTask DELETE_REDUNDANT_USER_TASK;
  public Configuration UUID_NICKNAMES;
  public static Logger log;
  
  public void onEnable()
  {
    loadConfig();
    INSTANCE = this;
    Config.reloadConfig();
    CustomMessages.reloadConfig();
	log = getLogger();
    this.BASE = new DatabaseMySQL();
    if (!this.BASE.connect())
    {
      fr.walexmine.OktaliaAuth.utils.Logger.warning(new String[] { "Database connection is ended!" });
      onDisable();
      return;
    }
    this.BASE.update(true, "CREATE TABLE IF NOT EXISTS `" + Config.MYSQL_TABLE + "` (`" + Config.MYSQL_TABLES_ID + "` INT AUTO_INCREMENT, `" + Config.MYSQL_TABLES_UUID + "` VARCHAR(36) NULL, `" + Config.MYSQL_TABLES_NICK + "` VARCHAR(16), `" + Config.MYSQL_TABLES_PASSWORD + "` VARCHAR(255), `" + Config.MYSQL_TABLES_PREMIUM + "` TINYINT(1), `" + Config.MYSQL_TABLES_FIRSTIP + "` VARCHAR(15), `" + Config.MYSQL_TABLES_LASTIP + "` VARCHAR(15), `" + Config.MYSQL_TABLES_FIRSTJOIN + "` BIGINT(20), `" + Config.MYSQL_TABLES_LASTJOIN + "` BIGINT(20), `" + Config.MYSQL_TABLES_CHECKED + "` TINYINT(1), `" + Config.MYSQL_TABLES_REGISTERBYAMIN + "` TINYINT(1), PRIMARY KEY (`" + Config.MYSQL_TABLES_ID + "`)) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2;");
    
    this.BASE.update(true, "ALTER TABLE `" + Config.MYSQL_TABLE + "` ADD `" + Config.MYSQL_TABLES_UUID + "` VARCHAR(36) NULL AFTER `" + Config.MYSQL_TABLES_ID + "`;", false);
    
    fr.walexmine.OktaliaAuth.utils.Logger.info(new String[] { "Successfully connected to database!" });
    
    PluginManager localPluginManager = getProxy().getPluginManager();
    /*
    localPluginManager.registerCommand(this, new ChangePasswordCommand());
    localPluginManager.registerCommand(this, new LoginCommand());
    localPluginManager.registerCommand(this, new RegisterCommand());
    localPluginManager.registerCommand(this, new AuthPluginCommand());
    localPluginManager.registerCommand(this, new UnregisterCommand());
    */
    localPluginManager.registerListener(this, new PlayerChatListener());
    localPluginManager.registerListener(this, new PlayerDisconnectListener());
    localPluginManager.registerListener(this, new PostLoginListener());
    localPluginManager.registerListener(this, new PreLoginListener(this));
    localPluginManager.registerListener(this, new ServerConnectListener());
    
    int i = Config.CLEAN0MEMORY0TIME < 1 ? 30 : Config.CLEAN0MEMORY0TIME;
    DELETE_REDUNDANT_USER_TASK = getProxy().getScheduler().schedule(this, new DeleteRedundantUsersFromMemoryTask(), i, i, TimeUnit.MINUTES);
    
    this.UUID_NICKNAMES = getYamlFile("uuid.yml");
    
    this.mojangValidate = new MojangValidate(getLogger());
  }
  
  private void loadConfig() {
	// TODO Auto-generated method stub
	
}

	public void onDisable()
	  {
	    USERS.clear();
	    this.BASE.disconnect();
	    DELETE_REDUNDANT_USER_TASK.cancel();
	    try
	    {
	      ConfigurationProvider.getProvider(YamlConfiguration.class).save(this.UUID_NICKNAMES, new File(getDataFolder(), "uuid.yml"));
	    }
	    catch (IOException localIOException)
	    {
	      localIOException.printStackTrace();
	    }
	  }
		  
	  public boolean premiumNicknameMustLoginWithRegister(String paramString)
	  {
	    for (String str : Config.PREMIUM0WITH0REGISTER) {
	      if (str.equalsIgnoreCase(paramString)) {
	        return true;
	      }
	    }
	    return false;
	  }
	  
	  public boolean canLoginWithoutPremium(String paramString)
	  {
	    for (String str : Config.PREMIUM0NICKNAME0WITHOUT0PREMIUM0CAN0JOIN) {
	      if (str.equalsIgnoreCase(paramString)) {
	        return true;
	      }
	    }
	    return false;
	  }
	  
	  
	  public Configuration getYamlFile(String paramString)
	  {
	    try
	    {
	      if (!getDataFolder().exists()) {
	        getDataFolder().mkdir();
	      }
	      File localFile = new File(INSTANCE.getDataFolder(), paramString);
	      if (!localFile.exists()) {
	        localFile.createNewFile();
	      }
	      return ConfigurationProvider.getProvider(YamlConfiguration.class).load(localFile);
	    }
	    catch (IOException localIOException)
	    {
	      localIOException.printStackTrace();
	    }
	    return null;
	  }
	  
	  public List<DataUser> getUsersByIP(String paramString)
	  {
	    ArrayList localArrayList = new ArrayList();
	    if (paramString == null) {
	      return localArrayList;
	    }
	    try
	    {
	      PreparedStatement localPreparedStatement = this.BASE.preparedStatement(String.format("SELECT * FROM `%s` WHERE `%s`=? OR `%s`=?", new Object[] { Config.MYSQL_TABLE, Config.MYSQL_TABLES_FIRSTIP, Config.MYSQL_TABLES_LASTIP }));Object localObject1 = null;
	      try
	      {
	        localPreparedStatement.setString(1, paramString);
	        localPreparedStatement.setString(2, paramString);
	        try
	        {
	          ResultSet localResultSet = this.BASE.query(localPreparedStatement);Object localObject2 = null;
	          try
	          {
	            while (localResultSet.next()) {
	              if (!localResultSet.getBoolean(Config.MYSQL_TABLES_PREMIUM)) {
	                localArrayList.add(new DataUser(localResultSet));
	              }
	            }
	          }
	          catch (Throwable localThrowable4)
	          {
	            localObject2 = localThrowable4;throw localThrowable4;
	          }
	          finally {}
	        }
	        catch (SQLException localSQLException2) {}
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
	            catch (Throwable localThrowable6)
	            {
	              ((Throwable)localObject1).addSuppressed(localThrowable6);
	            }
	          } else {
	            localPreparedStatement.close();
	          }
	        }
	      }
	    }
	    catch (SQLException localSQLException1)
	    {
	      localSQLException1.printStackTrace();
	    }
	    return localArrayList;
	  }
	  
	  public ConcurrentHashMap<String, DataUser> getUsers()
	  {
	    return USERS;
	  }
	  
	  public DataUser getUser(String paramString, UUID paramUUID, boolean paramBoolean1, boolean paramBoolean2)
	  {
	    DataUser localDataUser1 = (DataUser)USERS.get(paramUUID != null ? paramUUID.toString() : paramString.toLowerCase());
	    if (localDataUser1 != null) {
	      return localDataUser1;
	    }
	    if (!paramBoolean2) {
	      return null;
	    }
	    try
	    {
	      PreparedStatement localPreparedStatement = this.BASE.preparedStatement(String.format("SELECT * FROM `%s` WHERE `%s`=? OR `%s`=?", new Object[] { Config.MYSQL_TABLE, Config.MYSQL_TABLES_NICK, Config.MYSQL_TABLES_UUID }));Object localObject1 = null;
	      try
	      {
	        localPreparedStatement.setString(1, paramString);
	        localPreparedStatement.setString(2, paramUUID == null ? "EMPTY_UUID" : paramUUID.toString());
	        try
	        {
	          ResultSet localResultSet = this.BASE.query(localPreparedStatement);Object localObject2 = null;
	          try
	          {
	            if (localResultSet.next())
	            {
	              localDataUser1 = new DataUser(localResultSet);
	              if (paramBoolean1) {
	                USERS.put(localDataUser1.toString(), localDataUser1);
	              }
	              return localDataUser1;
	            }
	          }
	          catch (Throwable localThrowable4)
	          {
	            localObject2 = localThrowable4;throw localThrowable4;
	          }
	          finally {}
	        }
	        catch (SQLException localSQLException2) {}
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
	            catch (Throwable localThrowable8)
	            {
	              ((Throwable)localObject1).addSuppressed(localThrowable8);
	            }
	          } else {
	            localPreparedStatement.close();
	          }
	        }
	      }
	    }
	    catch (SQLException localSQLException1)
	    {
	      localSQLException1.printStackTrace();
	    }
	    return null;
	  }
	  
	  public DataUser getUser(String paramString, UUID paramUUID, boolean paramBoolean)
	  {
	    return getUser(paramString, paramUUID, paramBoolean, true);
	  }
	  
	  public DataUser getUser(String paramString, UUID paramUUID)
	  {
	    return getUser(paramString, paramUUID, false, true);
	  }
	  
	  public DataUser getUser(ProxiedPlayer paramProxiedPlayer, boolean paramBoolean1, boolean paramBoolean2)
	  {
	    return getUser(paramProxiedPlayer.getName(), paramProxiedPlayer.getUniqueId(), paramBoolean1, paramBoolean2);
	  }
	  
	  public DataUser getUser(ProxiedPlayer paramProxiedPlayer, boolean paramBoolean)
	  {
	    return getUser(paramProxiedPlayer, paramBoolean, true);
	  }
	  
	  public DataUser getUser(ProxiedPlayer paramProxiedPlayer)
	  {
	    return getUser(paramProxiedPlayer, false);
	  }
	  
	  public MojangValidate getMojangValidate()
	  {
	    return this.mojangValidate;
	  }
}