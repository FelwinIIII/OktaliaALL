package fr.WalexFelwin.OktaliaAuthLogin;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.WalexFelwin.OktaliaAuthLogin.API.API_Login;


public class Listener implements org.bukkit.event.Listener {

	public Listener(Main main) {
		// TODO Auto-generated constructor stub
	}

	  public static HashMap<Player, Long> Login = new HashMap();
	
	@EventHandler
	public void OnQuit(PlayerQuitEvent e){
	
		Player p = e.getPlayer();
		
		e.setQuitMessage(null);
		p.resetMaxHealth();
		Login.remove(p);
	}

	
	
	
	
	@EventHandler
	public void OnQuit(EntityDamageEvent e){
	

		e.setCancelled(true);
		
		
	}	
	@EventHandler
	public void OnQuit(BlockBreakEvent e){
	
		e.setCancelled(true);
		
		
	}	
	@EventHandler
	public void OnQuit(BlockPlaceEvent e){
	
		e.setCancelled(true);
		
		
	}
	@EventHandler
	public void OnJoin(PlayerJoinEvent e){
		
		Player p = e.getPlayer();
		
		e.setJoinMessage(null);
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1));
		p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
		p.sendMessage("");
		p.sendMessage("§aServeur de Login : §e"+Bukkit.getServerName());
		p.sendMessage("");
		p.sendMessage("");
		

  	  for (Player o : Bukkit.getOnlinePlayers())
  	    {
  		  o.hidePlayer(p);
  		  p.hidePlayer(o);
  	    }
		double x = 1.500;
		double y = 15;
		double z = 0.5;
		Location r = new Location(Bukkit.getWorld("world"), x, y, z);
		p.teleport(r);
		long getservertime = System.currentTimeMillis();
		
		Login.put(p, getservertime + 35 * 1000L);
		
	    long login = API_Login.getlogin(p);
	    long register = API_Login.getregister(p);
	    if (register == 0)
	    {
	    	 p.sendMessage("§c/register <MotsDePasse> <MotsDePasse>");

	    }
	    else if (login == 0)
	    {
	    	p.sendMessage("§c/Login <MotsDePasse>");

	    }
		Listener.SendLoginRepeat(p);
		
	}
	
	@EventHandler
	public void OnMove(PlayerMoveEvent e){
		
		Player p = e.getPlayer();
		
		double x = 1.500;
		double y = 15;
		double z = 0.5;
		Location r = new Location(Bukkit.getWorld("world"), x, y, z);
		
		
	if(p.getLocation().getX() == 1 && p.getLocation().getY() == y && p.getLocation().getZ() == 0){
	
	} else {

    	p.teleport(r);
	}
	    
	}
	
	public static void SendLoginRepeat(final Player p){

	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaLogin"), new Runnable() {
              public void run() {

            	    final int login = API_Login.getlogin(p);
            	  final int register = API_Login.getregister(p);
            	  if (register == 0)
          	    {
          	     p.sendMessage("§c/register <MotsDePasse> <MotsDePasse>");
          	    }
          	    else if (login == 0){
                     p.sendMessage("§c/Login <MotsDePasse>");
          	    }
              }
      }, 200);
	      
	      
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaLogin"), new Runnable() {
              public void run() {

            	    final int login = API_Login.getlogin(p);
            	  final int register = API_Login.getregister(p);
          	    if (register == 0)
          	    {
          	     p.sendMessage("§c/register <MotsDePasse> <MotsDePasse>");
          	    }
          	    else if (login == 0){
                     p.sendMessage("§c/Login <MotsDePasse>");
          	    }
              }
      }, 400);
	      
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaLogin"), new Runnable() {
              public void run() {

            	    final int login = API_Login.getlogin(p);
            	  final int register = API_Login.getregister(p);
          	    if (register == 0)
          	    {
          	     p.sendMessage("§c/register <MotsDePasse> <MotsDePasse>");
          	    }
          	    else if (login == 0){
                     p.sendMessage("§c/Login <MotsDePasse>");
          	    }
              }
      }, 600);
	}
}
