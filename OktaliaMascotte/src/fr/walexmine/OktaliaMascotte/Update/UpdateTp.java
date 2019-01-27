package fr.walexmine.OktaliaMascotte.Update;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftCreature;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Entity;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.scheduler.BukkitRunnable;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;

import fr.walexmine.OktaliaMascotte.API_Mascotte.API_Mascote;
import fr.walexmine.OktaliaMascotte.Commands.Mascote;


public class UpdateTp extends BukkitRunnable
{
	  public void run()
	  {
		for (Player updatetp : Mascote.MascoteBlaze.keySet()) {
			
			Location loc = updatetp.getLocation(); 
			
			ApplicableRegionSet set = WGBukkit.getRegionManager(loc.getWorld()).getApplicableRegions(loc);
			World w = (World)Bukkit.getWorld(""+updatetp.getWorld().getName());
			String regions = set.getRegions().toString();
			updatetp.sendMessage(regions);
		/*	if(regions.equalsIgnoreCase("[ProtectedRegion{id='spawn', type='POLYGON'}, ProtectedRegion{id='warzone', type='CUBOID'}]")
					|| regions.contains("f3as")
					|| regions.contains("lion")
					|| regions.contains("loup")
					|| regions.contains("ours")){*/
				
				String yes = "no";
        		for (Entity entity : w.getEntities()) {
  		          if (entity instanceof Blaze ) {
  		        	  
  		          
  		
  			  UUID uid = entity.getUniqueId();
          	  UUID getuuid = Mascote.MascoteBlaze.get(updatetp);
          	  
          	  if(uid.equals(getuuid)){
          		  
          	//	double ye = o.getLocation().getYaw();
          		//(ye < -0){
          			  
          			  double x = updatetp.getLocation().getX();
  	        		  double y = updatetp.getLocation().getY() + 2;
  	        		  double z = updatetp.getLocation().getZ();
  	        		  
  	        		
  	        		  Location tp = new Location(updatetp.getLocation().getWorld(), x, y, z, updatetp.getLocation().getYaw(), updatetp.getLocation().getPitch()) ; 			        		  
  	        	
  	        		  
  	        		entity.teleport(tp);
  	        		yes = "here";
          	  	}
  		          }
  		       }
        		if(yes.equalsIgnoreCase("no")){
        			API_Mascote.BlazeSpawn(updatetp);
  		    	
        		}
    /*      }else {
          	
      		for (Entity entity : w.getEntities()) {
		          if (entity instanceof Blaze ) {
		        	  
		          
		
			  UUID uid = entity.getUniqueId();
        	  UUID getuuid = Mascote.MascoteBlaze.get(updatetp);
        	  
        	  if(uid.equals(getuuid)){
	        		entity.remove();
        	  	}
		          }
		       }
          }*/

                
            }

		
	    for (Player updatetp : Mascote.MascoteWither.keySet()) {
		Location loc = updatetp.getLocation(); 
			
			ApplicableRegionSet set = WGBukkit.getRegionManager(loc.getWorld()).getApplicableRegions(loc);
			World w = (World)Bukkit.getWorld(""+updatetp.getWorld().getName());
		/*	String regions = set.getRegions().toString();
			if(regions.equalsIgnoreCase("[ProtectedRegion{id='spawn', type='POLYGON'}, ProtectedRegion{id='warzone', type='CUBOID'}]")
					|| regions.contains("f3as")
					|| regions.contains("lion")
					|| regions.contains("loup")
					|| regions.contains("ours")){*/
				String yes = "no";
        		for (Entity entity : w.getEntities()) {
  		          if (entity instanceof Wither ) {
  		        	  
  		          
  		
  			  UUID uid = entity.getUniqueId();
          	  UUID getuuid = Mascote.MascoteWither.get(updatetp);
          	  
          	  if(uid.equals(getuuid)){
          		  
          	//	double ye = o.getLocation().getYaw();
          		//(ye < -0){
          			  
          			  double x = updatetp.getLocation().getX();
  	        		  double y = updatetp.getLocation().getY() + 2;
  	        		  double z = updatetp.getLocation().getZ();
  	        		  
  	        		
  	        		  Location tp = new Location(updatetp.getLocation().getWorld(), x, y, z, updatetp.getLocation().getYaw(), updatetp.getLocation().getPitch()) ; 			        		  
  	        	
  	        		  
  	        		entity.teleport(tp);
  	        		yes = "here";
          	  	}
  		          }
  		       }
        		if(yes.equalsIgnoreCase("no")){
        			API_Mascote.Witherriding(updatetp);
  		    	
        		}
         /* }else {
          	
      		for (Entity entity : w.getEntities()) {
		          if (entity instanceof Wither ) {
		        	  
		          
		
			  UUID uid = entity.getUniqueId();
        	  UUID getuuid = Mascote.MascoteWither.get(updatetp);
        	  
        	  if(uid.equals(getuuid)){
	        		entity.remove();
        	  	}
		          }
		       }
          }*/
	  }
	    
	    
		
	    for (Player updatetp : Mascote.MascoteLoup.keySet()) {
		Location loc = updatetp.getLocation(); 
			
			ApplicableRegionSet set = WGBukkit.getRegionManager(loc.getWorld()).getApplicableRegions(loc);
			World w = (World)Bukkit.getWorld(""+updatetp.getWorld().getName());
			String regions = set.getRegions().toString();
			if(regions.equalsIgnoreCase("[ProtectedRegion{id='spawn', type='POLYGON'}, ProtectedRegion{id='warzone', type='CUBOID'}]")
					|| regions.contains("f3as")
					|| regions.contains("lion")
					|| regions.contains("loup")
					|| regions.contains("ours")){
				String yes = "no";
        		for (Entity entity : w.getEntities()) {
  		          if (entity instanceof Wolf ) {
  		        	  
  		          
  		
  			  UUID uid = entity.getUniqueId();
          	  UUID getuuid = Mascote.MascoteLoup.get(updatetp);
          	  
          	  if(uid.equals(getuuid)){
          		  
          	//	double ye = o.getLocation().getYaw();
          		//(ye < -0){
          			  
          			  double x = updatetp.getLocation().getX();
  	        		  double y = updatetp.getLocation().getY() + 2;
  	        		  double z = updatetp.getLocation().getZ();
  	        		  
  	        		
  	        		  Location tp = new Location(updatetp.getLocation().getWorld(), x, y, z, updatetp.getLocation().getYaw(), updatetp.getLocation().getPitch()) ; 			        		  
  	        	
  	        		  
  	        		entity.teleport(tp);
  	        		yes = "here";
          	  	}
  		          }
  		       }
        		if(yes.equalsIgnoreCase("no")){
        			API_Mascote.LoupSpawn(updatetp);
  		    	
        		}
          }else {
          	
      		for (Entity entity : w.getEntities()) {
		          if (entity instanceof Wolf ) {
		        	  
		          
		
			  UUID uid = entity.getUniqueId();
        	  UUID getuuid = Mascote.MascoteLoup.get(updatetp);
        	  
        	  if(uid.equals(getuuid)){
	        		entity.remove();
        	  	}
		          }
		       }
          }
	  }
	    for (Player updatetp : Mascote.MascoteGolem.keySet()) {
	  	  
			World w = (World)Bukkit.getWorld(""+updatetp.getWorld().getName());
    		for (Entity ent : w.getEntities()) {
		          if (((ent instanceof IronGolem ))) {
		        		  
		        	  
		        	  UUID uid = ent.getUniqueId();
		        	  UUID getuuid = Mascote.MascoteGolem.get(updatetp);
		        	  
		        	  if(uid.equals(getuuid)){
		        		  
		        	//	double ye = o.getLocation().getYaw();
		        		//(ye < -0){
		        			  
		        			  double x = updatetp.getLocation().getX();
			        		  double y = updatetp.getLocation().getY();
			        		  double z = updatetp.getLocation().getZ();
			        		  
			        		
			        		  Location tp = new Location(updatetp.getLocation().getWorld(), x, y, z, updatetp.getLocation().getYaw(), updatetp.getLocation().getPitch()) ; 			        		  

			        		    Entity e = (Entity)ent;
			        		    Location loc = updatetp.getLocation();
			        		    loc.subtract(2.0D, 0.0D, 2.0D);
			        		  updatetp.getLocation().getDirection();
			        		      CraftCreature cc = (CraftCreature)e;
			        		      cc.getHandle().getNavigation().a(loc.getX(), loc.getY(), loc.getZ(), 1.7D);
			        		    
			        		    //if (updatetp.getLocation().distance(e.getLocation()) > 10.0D) {
			        		      e.teleport(updatetp.getLocation().subtract(2.0D, 0.0D, 2.0D));
			        		    //}
			        		  
			        	//	ent.teleport(tp);
		        		  
		        	  }
		          }
		     
	    		
	    }
	  }

	  }

	private WorldGuardPlugin getWorldGuard() {
		// TODO Auto-generated method stub
		return null;
	}
}

	/*
	  private static int clock2;

	  public static void clock()
	  {
	    clock2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("LuminacyAPI"), new Runnable()
	    {
	      public void run()
	      {	
	    	  
	    	  for (Player o : Bukkit.getOnlinePlayers())
	    	    {
	    		  
	    			World w = (World)Bukkit.getWorld(""+o.getWorld().getName());
    	    		for (Entity ent : w.getEntities()) {
	    	    		for (Entity entity : w.getEntities()) {
  			          if (((ent instanceof Wither )) || ((entity instanceof Blaze ))) {
  			        	  if(Mascote.MascoteWither.containsKey(o)){
  			        		  
  			        	  
  			        	  UUID uid = entity.getUniqueId();
  			        	  UUID getuuid = Mascote.MascoteWither.get(o);
  			        	  
  			        	  if(uid.equals(getuuid)){
  			        		  
  			        	//	double ye = o.getLocation().getYaw();
  			        		//(ye < -0){
  			        			  
  			        			  double x = o.getLocation().getX();
	  			        		  double y = o.getLocation().getY() + 2;
	  			        		  double z = o.getLocation().getZ();
	  			        		  
	  			        		
	  			        		  Location tp = new Location(o.getLocation().getWorld(), x, y, z, o.getLocation().getYaw(), o.getLocation().getPitch()) ; 			        		  
	  			        	
	  			        		  
	  			        		entity.teleport(tp);
  			        		  
  			        	  }
  			          }
  			        	  
  			          if(Mascote.MascoteBlaze.containsKey(o)){
  			        	  UUID uid = entity.getUniqueId();
  			        	  UUID getuuid = Mascote.MascoteBlaze.get(o);
  			        	  
  			        	  if(uid.equals(getuuid)){
  			        		  
  			        	//	double ye = o.getLocation().getYaw();
  			        		//(ye < -0){
  			        			  
  			        			  double x = o.getLocation().getX();
	  			        		  double y = o.getLocation().getY() + 2;
	  			        		  double z = o.getLocation().getZ();
	  			        		  
	  			        		
	  			        		  Location tp = new Location(o.getLocation().getWorld(), x, y, z, o.getLocation().getYaw(), o.getLocation().getPitch()) ; 			        		  
	  			        	
	  			        		  
	  			        		entity.teleport(tp);
  			        		  
  			        	  }
  			          
  			          }
  			        	  
  			          }
	    	    		}
    	    		}
	    	    }
	      }
	    }, 1L, 1L);
	  }*/

