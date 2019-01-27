package fr.WalexFelwin.OktaliaAPI.BungeeCord;

import java.util.concurrent.TimeUnit;

import fr.WalexFelwin.OktaliaAPI.BungeeCord.CrashPinger.ReconnectOnCrash;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;

public class Utils {
	public static String prefix = "§7[§eOktalia§7] ";
	
	  public static void scheduleAsync(ReconnectOnCrash instance, final Runnable runnable, long time, TimeUnit timeUnit)
	  {
	    ProxyServer.getInstance().getScheduler().schedule(BungeeCord.getInstance().getPluginManager().getPlugin("OktaliaAPI"), new Runnable()
	    {


		public void run()
	      {
	        ProxyServer.getInstance().getScheduler().runAsync(BungeeCord.getInstance().getPluginManager().getPlugin("OktaliaAPI"), runnable);
	      }
	    }, time, timeUnit);
	  }
}
