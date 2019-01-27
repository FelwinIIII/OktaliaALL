package fr.WalexFelwin.OktaliaGrades.Grades.GradesPerm;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

public class BuildeurTest {
	
	   public static void Perm(Player p){
		   
		   PermissionAttachment attachment = p.addAttachment(Bukkit.getPluginManager().getPlugin("HezonNetWorkGrades"));

		   attachment.setPermission("essentials.gamemode", true);
		   attachment.setPermission("", true);
		   
	   }
	   
	   public static void UnPerm(Player p){
		   
		   PermissionAttachment attachment = p.addAttachment(Bukkit.getPluginManager().getPlugin("HezonNetWorkGrades"));

		   attachment.setPermission("essentials.gamemode", false);
		   attachment.setPermission("", false);
		   
	   }
}
