package fr.WalexFelwin.OktaliaGrades.Grades.GradesPerm;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;


public class Buildeur {


	
	   public static void Perm(Player p){
		   
		   PermissionAttachment attachment = p.addAttachment(Bukkit.getPluginManager().getPlugin("HezonNetWorkGrades"));

		   attachment.setPermission("voxelsniper.sniper", true);
		   attachment.setPermission("voxelsniper.ignorelimitations", true);
		   attachment.setPermission("voxelsniper.goto", true);
		   attachment.setPermission("voxelsniper.brush.*", true);
		   attachment.setPermission("worldedit.*", true);
		   attachment.setPermission("essentials.gamemode", true);
		   attachment.setPermission("", true);
		   
	   }
	   
	   public static void UnPerm(Player p){
		   
		   PermissionAttachment attachment = p.addAttachment(Bukkit.getPluginManager().getPlugin("HezonNetWorkGrades"));

		   attachment.setPermission("voxelsniper.sniper", false);
		   attachment.setPermission("voxelsniper.ignorelimitations", false);
		   attachment.setPermission("voxelsniper.goto", false);
		   attachment.setPermission("voxelsniper.brush.*", false);
		   attachment.setPermission("worldedit.*", false);
		   attachment.setPermission("essentials.gamemode", false);
		   attachment.setPermission("", false);
		   
	   }
}
