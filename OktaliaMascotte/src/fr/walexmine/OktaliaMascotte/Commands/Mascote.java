package fr.walexmine.OktaliaMascotte.Commands;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Entity;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;

import fr.walexmine.OktaliaMascotte.Main;
import fr.walexmine.OktaliaMascotte.API_Mascotte.API_Mascote;
import fr.walexmine.OktaliaMascotte.Update.MySQL;


public class Mascote implements CommandExecutor{


	  public static HashMap<Player, UUID> MascoteWither = new HashMap();
	  public static HashMap<Player, UUID> MascoteBlaze = new HashMap();
	  public static HashMap<Player, UUID> MascoteLoup = new HashMap();
	  public static HashMap<Player, UUID> MascoteGolem = new HashMap();
	  
	  public static void registermascotte(Player p, String UUID){
		  try {
	  			
	  			
  			  PreparedStatement preparedStatement = Main.conn.prepareStatement("SELECT id FROM InfoMascotte WHERE UUID = ?");
  			preparedStatement.setString(1, UUID);
  			
  			ResultSet rs = preparedStatement.executeQuery();
  			if(!rs.next()) {
  				preparedStatement.close();
  				preparedStatement = Main.conn.prepareStatement("INSERT INTO InfoMascotte (UUID, Pseudo, Wither, Blaze, Loup, Golem, TempsWither, TempsBlaze, TempsLoup, TempsGolem) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
  				preparedStatement.setString(1, UUID);
  				preparedStatement.setString(2, p.getName());
  				preparedStatement.setString(3, "FALSE");
  				preparedStatement.setString(4, "FALSE");
  				preparedStatement.setString(5, "FALSE");
  				preparedStatement.setString(6, "FALSE");
  				preparedStatement.setString(7, "0");
  				preparedStatement.setString(8, "0");
  				preparedStatement.setString(9, "0");
  				preparedStatement.setString(10, "0");
  				preparedStatement.executeUpdate();
  		        
  				preparedStatement.close();
  			}
  			
  			
  		} catch (SQLException e1) {
  			e1.printStackTrace();
  			MySQL.openConnection();
  		}
	  }
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		  Player p = (Player) sender;
	    if (label.equalsIgnoreCase("mascotte"))
	    {
	    	if(args.length == 0){
	    		sender.sendMessage("§a/mascotte wither/golem/loup/off §e| Mascote");
	    	}

	    	if(args.length == 3){
	    	  	if(args[0].equalsIgnoreCase("add")){
	    	  		
	    	  		Player mp = Bukkit.getPlayer(args[1]);
	    	  		String UUID = mp.getUniqueId().toString();
	    	  		
	    	  		if(!UUID.isEmpty()){

	    	  			if(args[2].equalsIgnoreCase("golem")){
	    	  				registermascotte(mp, UUID);
	    	  				API_Mascote.setgolem(mp, "TRUE");
	    	    	  	}
	    	  			if(args[2].equalsIgnoreCase("wither")){
	    	  				registermascotte(mp, UUID);
	    	  				
	    	  				API_Mascote.setwither(mp, "TRUE");
	    	  				
	    	  			}
	    	  			if(args[2].equalsIgnoreCase("blaze")){
	    	  				registermascotte(mp, UUID);
	    	  				API_Mascote.setblaze(mp, "TRUE");
					 
	    	  			}
	    	  			if(args[2].equalsIgnoreCase("loup")){
	    	  				registermascotte(mp, UUID);
	    	  				API_Mascote.setloup(mp, "TRUE");
					 
	    	  			}
	    	  		} 
	    	  	}
	    	}
	    	if(args.length == 1){
	    		
	    	  	if(args[0].equalsIgnoreCase("wither")){
	    	  		if(API_Mascote.getwither(p).equalsIgnoreCase("TRUE")){
	    	  		if(MascoteBlaze.containsKey(p)){
	    	  			p.sendMessage("§cVous disposez dêja d'une mascotte");
	    	  			return false;
	    	  		}
		    		sender.sendMessage("§eLa mascotte §7Wither §e");
		    		API_Mascote.Witherriding(p);
	    	  		} else {
	    	  			p.sendMessage("§cLes perms ne sont pas accorder");
	    	  		}
		    	}
	     		
	    	  	if(args[0].equalsIgnoreCase("blaze")){
	    	  		if(API_Mascote.getblaze(p).equalsIgnoreCase("TRUE")){
	    	  		if(MascoteWither.containsKey(p)){
	    	  			p.sendMessage("§cVous disposez dêja d'une mascotte");
	    	  			return false;
	    	  		}
		    		sender.sendMessage("§eLa mascotte §7Blaze §e");
		    		API_Mascote.BlazeSpawn(p);
	    	  		} else {
	    	  			p.sendMessage("§cLes perms ne sont pas accorder");
	    	  		}
		    	}
		    	
		    	
		      	if(args[0].equalsIgnoreCase("off")){

	    			World w = (World)Bukkit.getWorld(""+p.getWorld().getName());
	    			
    	    		for (Entity entity : w.getEntities()) {
			          if (((entity instanceof Wither )) || ((entity instanceof Blaze )) || ((entity instanceof IronGolem )) || ((entity instanceof Wolf ))) {

			        	  if(MascoteWither.containsKey(p)){
		    			
			        	  UUID uid = entity.getUniqueId();
			        	  UUID getuuid = Mascote.MascoteWither.get(p);
			        	  
			        	  if(uid.equals(getuuid)){
			        		  MascoteWither.remove(p);
				          p.sendMessage("§eVotre mascotte §7Wither §ea été désactiver");
			        	  entity.remove();
			        	  }
			        	  
		      		} 
			        	  if(MascoteBlaze.containsKey(p)){
		    			
			        	  UUID uid = entity.getUniqueId();
			        	  UUID getuuid = Mascote.MascoteBlaze.get(p);
			        	  
			        	  if(uid.equals(getuuid)){
			        		  MascoteBlaze.remove(p);
				          p.sendMessage("§eVotre mascotte §7Blaze §ea été désactiver");
			        	  entity.remove();
			        	  }
			        	  
		      		} 
			          }
    	    		}
		      		
		    	}
	    	}
	    }
	  return true;
	  }
}
