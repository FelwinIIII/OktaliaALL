package fr.WalexFelwin.OktaliaAPI.Bukkit.Commands;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_OktaCoins;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Redirect;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;


public class Coins implements CommandExecutor{
	

	 
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {

	    
	    if (label.equalsIgnoreCase("coins"))
	    {                  
	    	if(sender instanceof Player){
	    	

	    	    Player p = (Player)sender;
	    	    
	    	if(p.hasPermission("perm.admin")||p.hasPermission("perm.owner")||p.isOp()){
	    		
	    	    if (args.length == 0)
			      {

		            p.sendMessage("§a/coins add <joueur> <nombre>");
		            p.sendMessage("§a/coins get <joueur>");
		            p.sendMessage("§a/coins set <joueur> <nombre>");
		            p.sendMessage("§a/coins remove <joueur> <nombre>");

			      }
			      
			      if (p.hasPermission("perm.coins"))
			      {

			        if ((args.length == 2) && 
			          (args[0].equalsIgnoreCase("get")))
			        {
			          Player target = p.getServer().getPlayer(args[1]);
			          p.sendMessage(target.getName() + " : §" + API_OktaCoins.getoktacoins(target) + " oktaCoins.");
			        }
			        if (args.length == 3)
			        {
			        
			            

			            Player target = p.getServer().getPlayer(args[1]);
			            
			            if(!target.isOnline()) {
				            
					          if (args[0].equalsIgnoreCase("add"))
					          {
					            float c = Integer.valueOf(args[2]);
					            ByteArrayOutputStream b = new ByteArrayOutputStream();
						        DataOutputStream out = new DataOutputStream(b);
								
								
								try {
									out.writeUTF("Coins");
									out.writeUTF(p.getName());
									out.writeUTF("ADD");
									out.writeFloat(c);
									
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								Bukkit.getServer().sendPluginMessage(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), "BungeeInterconnect", b.toByteArray());
					          }				            
					          if (args[0].equalsIgnoreCase("set"))
					          {
					            float c = Integer.valueOf(args[2]);
					            ByteArrayOutputStream b = new ByteArrayOutputStream();
						        DataOutputStream out = new DataOutputStream(b);
								
								
								try {
									out.writeUTF("Coins");
									out.writeUTF(p.getName());
									out.writeUTF("SET");
									out.writeFloat(c);
									
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								Bukkit.getServer().sendPluginMessage(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), "BungeeInterconnect", b.toByteArray());
					          }					          
					          if (args[0].equalsIgnoreCase("remove"))
					          {
						            float c = Integer.valueOf(args[2]);
						            ByteArrayOutputStream b = new ByteArrayOutputStream();
							        DataOutputStream out = new DataOutputStream(b);
									
									
									try {
										out.writeUTF("Coins");
										out.writeUTF(p.getName());
										out.writeUTF("REMOVE");
										out.writeFloat(c);
										
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									Bukkit.getServer().sendPluginMessage(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), "BungeeInterconnect", b.toByteArray());
						          }
			            	return false;
			            }
			            
			            
			          if (args[0].equalsIgnoreCase("add"))
			          {
			            float c = Integer.valueOf(args[2]);
			            HASHMAP.Coins.put(p, HASHMAP.Coins.get(p)+c);
			            p.sendMessage( "§aTu as ajouté " + c + " oktaCoins au compte de " + target.getName());

			            
			          }
			          if (args[0].equalsIgnoreCase("set"))
			          {
			        	  float c = Integer.valueOf(args[2]);

				            HASHMAP.Coins.put(p, c);
			            p.sendMessage( "§aVous avez défini " + c + " oktaCoins au compte de " + target.getName());
			
			          }
			          if (args[0].equalsIgnoreCase("remove"))
			          {
			        	  float c = Integer.valueOf(args[2]);

				            HASHMAP.Coins.put(p, HASHMAP.Coins.get(p)-c);
			            p.sendMessage( "§aVous avez suprimée " + c + " oktaCoins au compte de " + target.getName());
			       
			          }
			
			        
			        }
			     
			      } else {
				    	
			      }
			        
	    		
	    	}
	    	} else {
	    		if(args.length == 1){
	    			
	    		}
	    	}
	    }
	    return true;
	  }

	  
}