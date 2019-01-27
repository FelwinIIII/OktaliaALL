package fr.walexmine.OktaliaAuth.utils;


import java.util.logging.Level;

import fr.walexmine.OktaliaAuth.AuthPlugin;

public class Logger
{
  public static final String ANSI_RESET = "\033[0m";
  public static final String ANSI_BOLD = "\033[1m";
  public static final String ANSI_ITALIC = "\033[3m";
  public static final String ANSI_UNDERLINE = "\033[4m";
  public static final String ANSI_STRIKETHROUGH = "\033[9m";
  public static final String ANSI_BLACK = "\033[30m";
  public static final String ANSI_RED = "\033[31m";
  public static final String ANSI_GREEN = "\033[32m";
  public static final String ANSI_GOLD = "\033[33m";
  public static final String ANSI_BLUE = "\033[34m";
  public static final String ANSI_PURPLE = "\033[35m";
  public static final String ANSI_CYAN = "\033[36m";
  public static final String ANSI_GRAY = "\033[37m";
  public static final String ANSI_DARK_GRAY = "\033[1;30m";
  public static final String ANSI_LIGHT_RED = "\033[1;31m";
  public static final String ANSI_LIGHT_GREEN = "\033[1;32m";
  public static final String ANSI_YELLOW = "\033[1;33m";
  public static final String ANSI_LIGHT_BLUE = "\033[1;34m";
  public static final String ANSI_LIGHT_CYAN = "\033[1;36m";
  public static final String ANSI_LIGHT_PURPLE = "\033[1;35m";
  public static final String ANSI_WHITE = "\033[1;37m";
  public static final String ANSI_BOLD_OFF = "\033[22m";
  public static final String ANSI_ITALICS_OFF = "\033[23m";
  public static final String ANSI_UNDERLINE_OFF = "\033[24m";
  public static final String ANSI_STRIKETHROUGH_OFF = "\033[29m";
  public static final String ANSI_OFF_ALL = "\033[22m\033[23m\033[24m\033[29m";
  
  public static void log(Level paramLevel, String paramString, String... paramVarArgs)
  {
    for (String str : paramVarArgs)
    {
      str = str + "&r";
      str = paramString + str;
      str = str.replace("&", "§");
      str = str.replace("§r", "\033[22m\033[23m\033[24m\033[29m\033[0m");
      str = str.replace("§l", "\033[22m\033[23m\033[24m\033[29m\033[1m");
      str = str.replace("§n", "\033[22m\033[23m\033[24m\033[29m\033[4m");
      str = str.replace("§o", "\033[22m\033[23m\033[24m\033[29m\033[3m");
      str = str.replace("§m", "\033[22m\033[23m\033[24m\033[29m\033[9m");
      str = str.replace("§0", "\033[22m\033[23m\033[24m\033[29m\033[30m");
      str = str.replace("§1", "\033[22m\033[23m\033[24m\033[29m\033[34m");
      str = str.replace("§2", "\033[22m\033[23m\033[24m\033[29m\033[32m");
      str = str.replace("§3", "\033[22m\033[23m\033[24m\033[29m\033[36m");
      str = str.replace("§4", "\033[22m\033[23m\033[24m\033[29m\033[31m");
      str = str.replace("§5", "\033[22m\033[23m\033[24m\033[29m\033[35m");
      str = str.replace("§6", "\033[22m\033[23m\033[24m\033[29m\033[33m");
      str = str.replace("§7", "\033[22m\033[23m\033[24m\033[29m\033[37m");
      str = str.replace("§8", "\033[22m\033[23m\033[24m\033[29m\033[1;30m");
      str = str.replace("§9", "\033[22m\033[23m\033[24m\033[29m\033[1;34m");
      str = str.replace("§d", "\033[22m\033[23m\033[24m\033[29m\033[1;35m");
      str = str.replace("§f", "\033[22m\033[23m\033[24m\033[29m\033[1;37m");
      str = str.replace("§a", "\033[22m\033[23m\033[24m\033[29m\033[1;32m");
      str = str.replace("§e", "\033[22m\033[23m\033[24m\033[29m\033[1;33m");
      str = str.replace("§b", "\033[22m\033[23m\033[24m\033[29m\033[1;36m");
      str = str.replace("§c", "\033[22m\033[23m\033[24m\033[29m\033[1;31m");
      AuthPlugin.INSTANCE.getLogger().log(paramLevel, str);
    }
  }
  
  public static void info(String... paramVarArgs)
  {
    log(Level.INFO, "&a", paramVarArgs);
  }
  
  public static void all(String... paramVarArgs)
  {
    log(Level.ALL, "&7", paramVarArgs);
  }
  
  public static void warning(String... paramVarArgs)
  {
    log(Level.WARNING, "&c", paramVarArgs);
  }
  
  public static void severe(String... paramVarArgs)
  {
    log(Level.SEVERE, "&b", paramVarArgs);
  }
  
  public static void config(String... paramVarArgs)
  {
    log(Level.CONFIG, "&9", paramVarArgs);
  }
  
  public static void off(String... paramVarArgs)
  {
    log(Level.OFF, "&e", paramVarArgs);
  }
}
