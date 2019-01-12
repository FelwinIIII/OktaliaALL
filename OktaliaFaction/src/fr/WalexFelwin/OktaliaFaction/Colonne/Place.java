package fr.WalexFelwin.OktaliaFaction.Colonne;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class Place {

	public static void PlaceObsidian(Block b, Location loc) {

		for(double i = loc.getY(); i < 255; i++) {
			
			Block dessus = b.getRelative(BlockFace.UP);
			dessus.setType(Material.OBSIDIAN);
			b = dessus;
		}
		
	}
	public static void PlaceSand(Block b, Location loc) {

		for(double i = loc.getY(); i < 255; i++) {
			
			Block dessus = b.getRelative(BlockFace.UP);
			dessus.setType(Material.SAND);
			b = dessus;
		}
		
	}
	
}
