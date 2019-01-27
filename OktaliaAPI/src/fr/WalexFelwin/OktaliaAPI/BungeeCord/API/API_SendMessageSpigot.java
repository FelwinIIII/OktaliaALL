package fr.WalexFelwin.OktaliaAPI.BungeeCord.API;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_Redirect;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class API_SendMessageSpigot {

	
	public static void sendmsgserver(String player, ServerInfo server) {
		
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
		

		try {
			System.out.println("test");
			out.writeUTF("WantHub");
			out.writeUTF("Lobby1");
			out.writeUTF(player);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		server.sendData("BungeeInterconnect", b.toByteArray());
		System.out.println("test2");
	}
}
