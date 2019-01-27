package fr.WalexFelwin.OktaliaAPI.BungeeCord.CMD.Server;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Update extends Command {

	public Update() {
	    super("Update", null, new String[0]);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] arg1) {
		
		if(sender instanceof ProxiedPlayer) {
			if(sender.hasPermission("update")) {
		  if (arg1.length == 0)
		    {
		    	sender.sendMessage(new TextComponent("§f----------------------------------------"));
		    	sender.sendMessage(new TextComponent("§b           Systéme d'Update Plugin"));
		    	sender.sendMessage(new TextComponent("§f"));
		    	sender.sendMessage(new TextComponent("§b/Update <server/all> <plugin> §e| MAJ"));
		    	sender.sendMessage(new TextComponent("§f"));
		    	sender.sendMessage(new TextComponent("§f----------------------------------------"));
		      return;
		    }
		  

		  if (arg1.length == 1) 
		    {
			  
			  if(arg1[0].equalsIgnoreCase("all")){
				  ProxiedPlayer p =  ProxyServer.getInstance().getPlayer(sender.getName());
			        ByteArrayOutputStream b = new ByteArrayOutputStream();
			        DataOutputStream out = new DataOutputStream(b);
					

					try {
						
						out.writeUTF("Update");
						out.writeUTF("ALL");
						out.writeUTF("OktaliaAPI");
						
						sender.sendMessage("Update lancer");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ServerInfo server = BungeeCord.getInstance().getServerInfo(p.getServer().getInfo().getName());
					
					server.sendData("BungeeInterconnect", b.toByteArray());
			  }
		    }
		} else {
			sender.sendMessage("La command ne peut être éxecutée !");
		}}
	}
}
