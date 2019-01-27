package fr.WalexFelwin.OktaliaAPI.Bukkit;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Redirect;
import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;
import fr.WalexFelwin.OktaliaAPI.BungeeCord.API.API_Coins;

public class PluginMessageListener implements org.bukkit.plugin.messaging.PluginMessageListener{

	@Override
	public void onPluginMessageReceived(String channel, Player arg1, byte[] bytes) {
		// TODO Auto-generated method 

		

		if(channel.equals("BungeeInterconnect")) {
			
			final ByteArrayDataInput in = ByteStreams.newDataInput(bytes);
			final String sub = in.readUTF();

			if(sub.equals("Update")) {

				final String sub2 = in.readUTF();
				final String sub3 = in.readUTF();
				
				if(sub2.equals("ALL")) {
					
					if(sub3.equals("OktaliaAPI")) {
						
						System.out.println("Update as started !");
						
					}
					
					
					
				}
				
				
			}
			
			if(sub.equals("WantHub")) {
				
			
				final String sub2 = in.readUTF();
				
				if(sub2.equals(""+Bukkit.getServerName())) {
				
				final String player = in.readUTF(); 

		        ByteArrayOutputStream b = new ByteArrayOutputStream();
		        DataOutputStream out = new DataOutputStream(b);
				
		        String hubselect = API_Redirect.WANTHUB(player);
				
				try {
					out.writeUTF("SendHub");
					out.writeUTF(player);
					out.writeUTF(hubselect);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("test44");
				Bukkit.getServer().sendPluginMessage(Bukkit.getPluginManager().getPlugin("OktaliaAPI"), "BungeeInterconnect", b.toByteArray());
			}
		  }
			

			if(sub.equals("CoinsC")) {

				final String player = in.readUTF();
				Player p = Bukkit.getPlayer(player);

				final String sub2 = in.readUTF();
				final float coins = in.readFloat();
				
				if(sub2.equals("ADD")) {
					
					HASHMAP.Coins.put(p, HASHMAP.Coins.get(p)+coins);
					
				} else if(sub2.equals("REMOVE")) {

					HASHMAP.Coins.put(p, HASHMAP.Coins.get(p)-coins);
					
				} else if(sub2.equals("SET")) {

					HASHMAP.Coins.put(p, coins);
					
				}
				
			}
			
			
			
			
			
			
			
			
			
		}
		
		
		
			
	}

}
