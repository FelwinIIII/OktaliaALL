package fr.WalexFelwin.OktaliaGrades.Chat_Tab;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;

public class Chat {

	  public static String name;
	  
	  public static void sendchatmessage(String name, Player p, String msg){
			

	  	
	      String grades = ""+HASHMAP.Grades.get(p);
	      
	      if (grades.equalsIgnoreCase("developpeur"))
	  {
	    String changemessage = ChatUtils.getdeveloppeurprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	 else if (grades.equalsIgnoreCase("admin"))
	  {
	    String changemessage = ChatUtils.getadminprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("gerant"))
	  {
	    String changemessage =  ChatUtils.getgerantprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("manager"))
	  {
	    String changemessage =  ChatUtils.getmanagerprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("moderateur"))
	  {
	    String changemessage =  ChatUtils.getmodoprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("moderatrice"))
	  {
	    String changemessage =  ChatUtils.getmodaprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("buildeur"))
	  {
	    String changemessage =  ChatUtils.builderprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.contains("youtubeur"))
	  {
	    String changemessage =  ChatUtils.getyoutubeurprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("ami"))
	  {
	    String changemessage =  ChatUtils.amiprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else if (grades.equalsIgnoreCase("vip"))
	  {
	    String changemessage =  ChatUtils.amiprefix() + name + " §f: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  else
	  {
	    String changemessage = "§7" + name + " §7: " + msg;
	    for (Player pls : Bukkit.getOnlinePlayers()) {
	      pls.sendMessage(changemessage);
	    }
	    System.out.println("[Chat] " + p.getName() + " : " + msg);
	  }
	  }
	  
}
