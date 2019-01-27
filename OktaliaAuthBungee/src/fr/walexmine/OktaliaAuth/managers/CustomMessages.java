package fr.walexmine.OktaliaAuth.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

import fr.walexmine.OktaliaAuth.AuthPlugin;
import fr.walexmine.OktaliaAuth.utils.Logger;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class CustomMessages
{
  private static Configuration _FILE;
  public static String MOJANGAPI0ERROR_KICK0REASON = "&7L'API de mojang est déconnectée !";
  public static String MULTI0ACCOUNTS0LOGIN = "&7You have other accounts on this server!";
  public static String PLAYER_LOGGED0WITH0PREMIUM = "&aVous êtes bien connecté avec votre compte premium.";
  public static String PLAYER_INVALID0NAME = "&cVotre pseudo est incorrect, il contient des caractére incorrect";
  public static String PLAYER_ALREADY0ONLINE = "&9[Auth] &cThe player with this nickname is already online.";
  public static String PLAYER_AUTHSERVER0IS0FULL = "&9[Auth] &cAuthentication server is alredy full. Try again later!";
  public static String CHANGEPASSWORD_FIRST0REGISTER = "&9[Auth] &7First register please.";
  public static String CHANGEPASSWORD_PLAYER0IS0PREMIUM = "&9[Auth] &7This command is not allowed for premium accounts users.";
  public static String CHANGEPASSWORD_PLAYER0ISNT0LOGGED = "&9[Auth] &cLog in first to change your password.";
  public static String CHANGEPASSWORD_CORRECT0USAGE = "&9[Auth] &cCorrect use: &e/changepass <password> <repeat password>";
  public static String CHANGEPASSWORD_PASSWORD0IS0SAME0THAN0OLD = "&9[Auth] &cNew password can't be the same like old.";
  public static String CHANGEPASSWORD_INCORRECT0PASSWORD = "&9[Auth] &cIncorrect password.";
  public static String CHANGEPASSWORD_CHANGED0PASSWORD = "&9[Auth] &7Your password has been changed successfully.";
  
  public static String REGISTER_CORRECT0USAGE = "&9[Auth] &cCorrect use: &e/register <password> <repeat password>";
  public static String REGISTER_SUCCESSFULLY0REGISTERED = "&9[Auth] &7You have been registered successfully.";
  public static String REGISTER_PASSWORD0DOESNT0MATCH = "&9[Auth] &cPasswords doesn't match.";
  public static String REGISTER_MULTI0ACCOUNTS = "&9[Auth] &cYou have other accounts.";
  public static String UNREGISTER_CORRECT0USAGE = "&9[Auth] &7Correct use: &e/unregister <password>";
  public static String UNREGISTER_FIRST0REGISTER = "&9[Auth] &7First register please.";
  public static String UNREGISTER_PLAYER0IS0PREMIUM = "&9[Auth] &7This command is not allowed for premium accounts users.";
  public static String UNREGISTER_PLAYER0MUST0TO0BE0LOGGED = "&9[Auth] &cYou must be logged.";
  public static String UNREGISTER_INCORRECT0PASSWORD = "&9[Auth] &cIncorrect password.";
  public static String UNREGISTER_SUCCESSFULLY0UNREGISTERED = "&9[Auth] &7You have been unregistered in successfully.";
  public static String AUTHPLUGN_UNREGISTER_CORRECT0USAGE = "&9[Auth] &cCorrect usage: &e/authplugin unregister <player>";
  public static String AUTHPLUGN_UNREGISTER_DONT0FIND0THE0PLAYER = "&9[Auth] &cDon't find a player!";
  public static String AUTHPLUGN_UNREGISTER_PLAYER0ISNT0REGISTERED = "&9[Auth] &cPlayer isn't registered!";
  public static String AUTHPLUGN_UNREGISTER_SUCCESSFULLY0UNREGISTERED = "&9[Auth] &cPlayer unregister successfully!";
  public static String AUTHPLUGN_UNREGISTER_KICK = "&cYour account has been unregistered!";
  public static String AUTHPLUGN_REGISTER_CORRECT0USAGE = "&9[Auth] &cCorrect usage: &e/authplugin register <player> <password>";
  public static String AUTHPLUGN_REGISTER_FIND0PLAYER = "&9[Auth] &cPlayer already in register!";
  public static String AUTHPLUGN_REGISTER_SUCCESSFULLY0REGISTERED0OTHER = "&9[Auth] &7Player have been registered successfully.";
  public static String AUTHPLUGN_REGISTER_SUCCESSFULLY0REGISTERED = "&9[Auth] &7You have been registered successfully.";
  public static String AUTHPLUGN_ALLOW_CORRECT0USAGE = "&9[Auth] &cCorrect usage: &e/authplugin allow <player>";
  public static String AUTHPLUGN_ALLOW_UNALLOWED = "&9[Auth] &7Player haven't been allowed.";
  public static String AUTHPLUGN_ALLOW_ALLOWED = "&9[Auth] &7Player have been allowed.";
  
  public static void loadConfig()
  {
    if (_FILE == null)
    {
      reloadConfig();
      return;
    }
    try
    {
      for (Field localField : CustomMessages.class.getFields()) {
        if (!localField.getName().startsWith("_")) {
          if (_FILE.get(localField.getName().toLowerCase().replace("_", ".").replace("0", "-")) != null)
          {
            Object localObject = _FILE.get(localField.getName().toLowerCase().replace("_", ".").replace("0", "-"));
            localField.set(null, localObject);
          }
        }
      }
    }
    catch (Exception localException)
    {
      Logger.warning(new String[] { "Field isn't static!" });
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
      for (Field localField : CustomMessages.class.getFields()) {
        if (!localField.getName().startsWith("_"))
        {
          Object localObject = localField.get(null);
          _FILE.set(localField.getName().toLowerCase().replace("_", ".").replace("0", "-"), localObject);
        }
      }
      ConfigurationProvider.getProvider(YamlConfiguration.class).save(_FILE, getMessage());
    }
    catch (Exception localException)
    {
      Logger.warning(new String[] { "Field isn't static!" });
    }
  }
  
  public static void reloadConfig()
  {
    File localFile = getMessage();
    if (!localFile.exists()) {
      try
      {
        localFile.createNewFile();
      }
      catch (IOException localIOException)
      {
        Logger.warning(new String[] { "Can't find directory of file!" });
      }
    }
    _FILE = AuthPlugin.INSTANCE.getYamlFile(localFile.getName());
    loadConfig();
    saveConfig();
  }
  
  private static File getMessage()
  {
    File localFile = new File(AuthPlugin.INSTANCE.getDataFolder(), "messages_" + Config.LANGUAGE + ".yml");
    if (!localFile.exists())
    {
      try
      {
        localFile.createNewFile();
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
      }
      InputStream localInputStream = AuthPlugin.INSTANCE.getResourceAsStream("messages_" + Config.LANGUAGE + ".yml");
      if (localInputStream != null)
      {
        FileOutputStream localFileOutputStream = null;
        try
        {
          localFileOutputStream = new FileOutputStream(localFile);
          byte[] arrayOfByte = new byte['?'];
          int i;
          while ((i = localInputStream.read(arrayOfByte)) > 0) {
            localFileOutputStream.write(arrayOfByte, 0, i);
          }
          localFileOutputStream.close();
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localFileNotFoundException.printStackTrace();
        }
        catch (IOException localIOException2)
        {
          if (localFileOutputStream != null) {
            try
            {
              localFileOutputStream.close();
            }
            catch (IOException localIOException4) {}
          }
          localIOException2.printStackTrace();
        }
        try
        {
          localInputStream.close();
        }
        catch (IOException localIOException3)
        {
          localIOException3.printStackTrace();
        }
      }
    }
    return localFile;
  }
}