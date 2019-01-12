package fr.WalexFelwin.OktaliaFaction.Commandes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaFaction.Inventaire.MenuPrincipal;

public class Menu implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		MenuPrincipal.MenuALL(p);
		
		return false;
	}
	
}
