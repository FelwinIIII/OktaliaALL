package fr.walexmine.OktaliaMine.Commands;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.avaje.ebean.validation.Length;

import fr.walexmine.OktaliaMine.API.API_Inventory;

public class Inventory implements CommandExecutor{
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if (label.equalsIgnoreCase("inventaire"))
	    {
	    		//TP MINAGE
	    	if(p.isOp()) {
	    	if (args.length == 0 || args.length > 1) {
	    		p.sendMessage("§e/Inventaire <save/restore> §7| §aPermet de sauvegarder ou restauré sont inventaire");
	    	}
	    	if (args.length == 1) {
	    		

	    	    if(args[0].equalsIgnoreCase("save")){

	    	    	API_Inventory.setinventoryw(p, API_Inventory.toBase64(p.getInventory()));
	    	    	API_Inventory.setinventorywArmor(p, API_Inventory.itemStackArrayToBase64(p.getInventory().getArmorContents()));

	    	    }

	    	    if(args[0].equalsIgnoreCase("restore")){

	    			org.bukkit.inventory.Inventory inv = null;
	    			ItemStack[] invcontent = null;
	    			
	    			try {
	    				inv = API_Inventory.fromBase64(API_Inventory.getinventory(""+p.getUniqueId()));
	    				invcontent = API_Inventory.itemStackArrayFromBase64(API_Inventory.getinvcontent(""+p.getUniqueId()));
	    				
	    			} catch (IOException e1) {
	    				// TODO Auto-generated catch block
	    				e1.printStackTrace();
	    			}
	    			p.getInventory().setContents(inv.getContents());
	    			p.getInventory().setArmorContents(invcontent);
	    	    }
	    	    
	    	   }
		    	  
	    }
	    }
	    return true;
	  }

}
