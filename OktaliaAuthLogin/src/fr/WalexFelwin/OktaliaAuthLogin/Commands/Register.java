package fr.WalexFelwin.OktaliaAuthLogin.Commands;

import java.sql.ResultSet;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAuthLogin.Listener;
import fr.WalexFelwin.OktaliaAuthLogin.API.API_Connect;
import fr.WalexFelwin.OktaliaAuthLogin.API.API_Login;
import fr.WalexFelwin.OktaliaAuthLogin.MySql.Update;

public class Register implements CommandExecutor{
	

	
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    final Player p = (Player)sender;
	    if (label.equalsIgnoreCase("register") || label.equalsIgnoreCase("reg"))
	    {

		    
		      long register = API_Login.getregister(p);

		      if (register == 1L)
		      {
		        p.sendMessage("§cVous êtes dêjà register.");
		        p.sendMessage("§c/newregister <NouveauMotsDePasse> <NouveauMotsDePasse>.");
		        return false;
		      }
		      if (args.length == 0) {
		        if (register == 0L) {
		          p.sendMessage("§c/register <MotsDePasse> <MotsDePasse>");
		        }
		        
		      }
		      
		      if (args.length >= 1)
		      {
		    	  
		        String mdp1 = args[0];
		        String mdp2 = args[1];
		        if (mdp2 == null) {
		        	
		          p.sendMessage("§cVeulliez saisir un mots de passe");
		          
		        }
		        if (mdp1.equalsIgnoreCase(mdp2))
		        {
		        	

			      boolean existlogin = false;
				    try
				    {
				      ResultSet rs = Update.Query("SELECT `Register` FROM `InfoLogin` WHERE `Pseudo`='" + p.getName() + "'");
				      while (rs.next()) {
				    	  existlogin = Boolean.valueOf(true).booleanValue();
				      }
				    }
				    catch (Exception err)
				    {
	        	          p.sendMessage("§cVous n'avez pas été bien enregistrez veuillez retenter le /register");

		        	  		Listener.Login.remove(p);
	        	  		long getservertime = System.currentTimeMillis();
	        	  			Listener.Login.put(p, getservertime + 35 * 1000L);
				      System.err.println(err);
				      err.printStackTrace();
				    }
				    if (!existlogin) {
				      Update.Update("INSERT INTO `InfoLogin` (`Pseudo`, `motsdepasse`, `Register`, `Login`, `IP`) VALUES ('" + p.getName() + "', '"+mdp2+"', '1', '1', '"+p.getAddress().getHostString()+"')");
				    }


					  p.playSound(p.getLocation(), Sound.LEVEL_UP , 100.0F, 1.0F);
					  p.sendMessage("§eConnexion en cours ...");
		    	    	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaLogin"), new Runnable() {
		    	              public void run() {
		    	    

		    						  p.sendMessage("§eConnexion au serveur §aOktalia§e.");
		    	              }
		    	      }, 25);
		    	    	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("OktaliaLogin"), new Runnable() {
		    	              public void run() {
		    	    

		    		          		API_Connect.connectTo(p, "hub1");
		    	              }
		    	      }, 40);
		        }
		        else
		        {
		        	
		
		          p.sendMessage("§cLes mots de passe ne sont pas identiques");

				  p.playSound(p.getLocation(), Sound.WOLF_GROWL , 100.0F, 1.0F);
		        }
		        
		      }
		  
	  }
	  return true;
	  }

}
