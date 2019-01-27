package fr.walexmine.OktaliaAuth.managers;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import fr.walexmine.OktaliaAuth.AuthPlugin;
import fr.walexmine.OktaliaAuth.utils.DateUtil;
import fr.walexmine.OktaliaAuth.utils.Logger;
import fr.walexmine.OktaliaAuth.utils.ServerValidate;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Config
{
	
  private static final String prefix = "config.";
  private static Configuration _FILE;
  public static String LANGUAGE = "en";
  public static boolean ENABLE0PREMIUM0AUTH = true;
  public static boolean EXISTING0PREMIUM0USERS0WITH0PASSWORD0LOGIN0WITHOUT0PASSWORD = true;
  public static boolean ENABLED0PERMISSIONS = true;
  public static boolean PREMIUM0REGISTER = false;
  public static String PASSWORD_HASH0ALGORITHM = "SHA512";
  public static int password_bCryptLog2Round = 10;
  public static String MYSQL_HOST = "localhost";
  public static int MYSQL_PORT = 3306;
  public static String MYSQL_BASE = "Falcon9";
  public static String MYSQL_USER = "walexmine";
  public static String MYSQL_PASS = "V37bKGhxtzRGbyot";
  public static String MYSQL_TABLE = "InfoPrenium";
  public static String MYSQL_TABLES_ID = "userID";
  public static String MYSQL_TABLES_UUID = "uuid";
  public static String MYSQL_TABLES_NICK = "nick";
  public static String MYSQL_TABLES_PASSWORD = "password";
  public static String MYSQL_TABLES_PREMIUM = "premium";
  public static String MYSQL_TABLES_FIRSTIP = "firstIP";
  public static String MYSQL_TABLES_LASTIP = "lastIP";
  public static String MYSQL_TABLES_FIRSTJOIN = "firstJoined";
  public static String MYSQL_TABLES_LASTJOIN = "lastJoined";
  public static String MYSQL_TABLES_CHECKED = "checked";
  public static String MYSQL_TABLES_REGISTERBYAMIN = "registeredByAdmin";
  public static boolean SESSION_ENABLED = true;
  public static String SESSION_TIME = "30m";
  public static long _SESSION_TIME;
  public static int CLEAN0MEMORY0TIME = 30;
  public static String _AUTH0SERVER = "lobby";
  public static int _AUTH0SERVER0MAX0ONLINE = 50;
  public static ServerInfo __AUTH0SERVER;
  public static List<ServerValidate> _AUTH0SERVERS = new ArrayList();
  private static Iterator<ServerValidate> _AUTH0SERVER_ITERABLE;
  public static int ALLOWED_MULTIACCOUNTS = 1;
  public static boolean ALLOWED_MULTIACCOUNTS0BLOCK_ONJOIN = true;
  public static List<String> PREMIUM0WITH0REGISTER = new ArrayList();
  public static List<String> PREMIUM0NICKNAME0WITHOUT0PREMIUM0CAN0JOIN = new ArrayList();
  public static boolean RESTRICTIONS_ALLOW0CHAT = false;
  public static List<String> RESTRICTIONS_ALLOW0COMMANDS = Arrays.asList(new String[] { "/login", "/register", "/reg", "/l" });
  
  public static void loadConfig()
  {
    if (_FILE == null)
    {
      reloadConfig();
      return;
    }
  }
  
  public static void saveConfig()
  {
    if (_FILE == null)
    {
      reloadConfig();
      return;
    }
    try
    {
      for (Field localField : Config.class.getFields()) {
        if (!localField.getName().startsWith("_")) {
          _FILE.set("config." + localField.getName().toLowerCase().replace("_", ".").replace("0", "-"), localField.get(null));
        }
      }
      ConfigurationProvider.getProvider(YamlConfiguration.class).save(_FILE, new File(AuthPlugin.INSTANCE.getDataFolder(), "config.yml"));
    }
    catch (Exception localException) {}
  }
  
  public static void reloadConfig()
  {
    _FILE = AuthPlugin.INSTANCE.getYamlFile("config.yml");
    loadConfig();
    saveConfig();
  }
  
    
}
