package fr.WalexFelwin.OktaliaHub.API;

import java.util.HashMap;

import org.bukkit.entity.Player;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Utils.HASHMAP;


public class API_HubPlayer {

	  public static HashMap<String, Integer> dev = new HashMap();
	  public static HashMap<String, Integer> gerant = new HashMap();
	  public static HashMap<String, Integer> admin = new HashMap();
	  public static HashMap<String, Integer> modo = new HashMap();
	  public static HashMap<String, Integer> moda = new HashMap();
	  public static HashMap<String, Integer> manager = new HashMap();
	  public static HashMap<String, Integer> buildeur = new HashMap();
	  public static HashMap<String, Integer> youtubeur = new HashMap();
	  public static HashMap<String, Integer> ami = new HashMap();
	  public static HashMap<String, Integer> vip = new HashMap();
	  public static HashMap<String, Integer> joueur = new HashMap();
	
	public static void playergradesadd(Player p){
			
		if(HASHMAP.Grades.get(p).equalsIgnoreCase("developpeur")){
			   if(dev.containsKey("dev")){
				   dev.put("dev", 1+dev.get("dev"));
				   
			   } else {
			   dev.put("dev", 1);
			   }
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("gerant")){
			   if(gerant.containsKey("gerant")){
				   gerant.put("gerant", 1+gerant.get("gerant"));
				   
			   } else {
			   gerant.put("gerant", 1);
			   }
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("admin")){
			   if(admin.containsKey("admin")){
				   admin.put("admin", 1+admin.get("admin"));
				   
			   } else {
			   admin.put("admin", 1);
			   }
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("moderateur")){
			   if(modo.containsKey("modo")){
				   modo.put("modo", 1+modo.get("modo"));
				   
			   } else {
			   modo.put("modo", 1);
			   }
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("moderatrice")){
			   if(moda.containsKey("moda")){
				   moda.put("moda", 1+moda.get("moda"));
				   
			   } else {
			   moda.put("moda", 1);
			   }
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("manager")){
			   if(manager.containsKey("manager")){
				   manager.put("manager", 1+manager.get("manager"));
				   
			   } else {
				   manager.put("manager", 1);
			   }
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("buildeur")){
			   if(buildeur.containsKey("buildeur")){
				   buildeur.put("buildeur", 1+buildeur.get("buildeur"));
				   
			   } else {
				   buildeur.put("buildeur", 1);
			   }
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("youtubeur")){
			   if(youtubeur.containsKey("youtubeur")){
				   youtubeur.put("youtubeur", 1+youtubeur.get("youtubeur"));
				   
			   } else {
				   youtubeur.put("youtubeur", 1);
			   }
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("ami")){
			   if(ami.containsKey("ami")){
				   ami.put("ami", 1+ami.get("ami"));
				   
			   } else {
				   ami.put("ami", 1);
			   }
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("vip")){
			   if(vip.containsKey("vip")){
				   vip.put("vip", 1+vip.get("vip"));
				   
			   } else {
				   vip.put("vip", 1);
			   }
		   } else{
			   if(joueur.containsKey("joueur")){
				   
				   joueur.put("joueur", 1+joueur.get("joueur"));
				   
			   } else {
				   joueur.put("joueur", 1);
			   }
		   }
		   
	}
	
	public static void playergradesremove(Player p){
		
			if(HASHMAP.Grades.get(p).equalsIgnoreCase("developpeur")){

			   dev.put("dev", dev.get("dev")-1);
			   
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("gerant")){
			   
			   gerant.put("gerant", gerant.get("gerant")-1);
			   
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("admin")){
			   
			   admin.put("admin", admin.get("admin")-1);
			   
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("moderateur")){
			   
			   modo.put("modo", modo.get("modo")-1);
			   
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("moderatrice")){
			   
			   moda.put("moda", moda.get("moda")-1);
			   
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("manager")){
			   
			   manager.put("manager", manager.get("manager")-1);

		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("buildeur")){
			   
			   buildeur.put("buildeur", buildeur.get("buildeur")-1);
			   
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("youtubeur")){
			   
			   youtubeur.put("youtubeur", youtubeur.get("youtubeur")-1);
			   
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("ami")){
			   
			   ami.put("ami", ami.get("ami")-1);
			   
		   } else if(HASHMAP.Grades.get(p).equalsIgnoreCase("vip")){
			   vip.put("vip", vip.get("vip")-1);
		   } else{
			   joueur.put("joueur", joueur.get("joueur")-1);
		   }
		   
	}
}
