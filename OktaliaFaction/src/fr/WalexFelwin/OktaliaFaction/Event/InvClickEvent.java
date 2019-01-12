package fr.WalexFelwin.OktaliaFaction.Event;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.WalexFelwin.OktaliaFaction.Inventaire.Magasin;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MenuPrincipal;
import fr.WalexFelwin.OktaliaFaction.Inventaire.PreviewMenu;
import fr.WalexFelwin.OktaliaFaction.Inventaire.InformationALL.ItemsInedits;
import fr.WalexFelwin.OktaliaFaction.Inventaire.InformationALL.PlaningEvent;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL.Alchimie;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL.Block;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL.Decoration;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL.Enchantement;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL.Farm;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL.Kits;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL.Minerai;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL.Nourriture;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL.Pillage;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL.Potion;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MagasinALL.Spawners;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MenuPALL.GradesMoney;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MenuPALL.InformationALL;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MenuPALL.Mur;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MenuPALL.OptionALL;
import fr.WalexFelwin.OktaliaFaction.Inventaire.MenuPALL.WarpALL;
import fr.WalexFelwin.OktaliaFaction.Inventaire.PreviewALL.Legionnaire;
import fr.WalexFelwin.OktaliaFaction.Inventaire.PreviewALL.Maitre;
import fr.WalexFelwin.OktaliaFaction.Inventaire.PreviewALL.Monarque;
import fr.WalexFelwin.OktaliaFaction.Inventaire.PreviewALL.VIP;
import fr.WalexFelwin.OktaliaFaction.Inventaire.PreviewALL.VIPPLUS;
import fr.WalexFelwin.OktaliaFaction.Inventaire.PreviewALL.Voyageur;

public class InvClickEvent implements Listener {

	@EventHandler
	  public void onInventoryClickEvent(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getInventory();
        ItemStack it = e.getCurrentItem();
        
        
        		//-----------------[  Inventaire Preview Menu  ]------------------//
	        
	        if(inv != null && inv.getName().equalsIgnoreCase("§6Warps")){
	            if(it == null || it.getType() == null)return;
	            e.setCancelled(true);
	            if(it.hasItemMeta()) {
	            	if(it.getItemMeta().getDisplayName().contains("§7Téléportation vers l'§5END")) {
	                	e.setCancelled(true);
	                	p.closeInventory();
	                }
	            	if(it.getItemMeta().getDisplayName().contains("§7Téléportation vers le §eTutoriel")) {
	                	e.setCancelled(true);
	                	p.closeInventory();
	                	Bukkit.dispatchCommand(p, "warp tuto");
	                }
	            	if(it.getItemMeta().getDisplayName().contains("§7Téléportation vers §9Warp Enchantement")) {
	                	e.setCancelled(true);
	                	p.closeInventory();
	                	Bukkit.dispatchCommand(p, "warp enchant");
	                }
	            	if(it.getItemMeta().getDisplayName().contains("§7Téléportation vers la §eZone d'Investissement")) {
	                	e.setCancelled(true);
	                	p.closeInventory();
	                	Bukkit.dispatchCommand(p, "warp invest");
	                }
	            	if(it.getItemMeta().getDisplayName().contains("§7Téléportation vers la §6Zone des Caisse")) {
	                	e.setCancelled(true);
	                	p.closeInventory();
	                	Bukkit.dispatchCommand(p, "warp box");
	                }
	            }else {
	            	e.setCancelled(true);
	            }
	            }
        
        			//-----------------------------------//
        
        
        
        
        		//-----------------[  Inventaire Preview Menu  ]------------------//
        
        if(inv != null && inv.getName().equalsIgnoreCase("§6Preview Kits")){
            if(it == null || it.getType() == null)return;
            e.setCancelled(true);
            if(it.hasItemMeta()) {
            	if(it.getItemMeta().getDisplayName().contains("§7§lKit §2§lVoyageur")) {
                	e.setCancelled(true);
                	Voyageur.VoyageurPreview(p);
                }
            	if(it.getItemMeta().getDisplayName().contains("§7§lKit §b§lLegionnaire")) {
                	e.setCancelled(true);
                	Legionnaire.LegionnairePreview(p);
                }
            	if(it.getItemMeta().getDisplayName().contains("§7§lKit §6§lMaitre")) {
                	e.setCancelled(true);
                	Maitre.MaitrePreview(p);
                }
            	if(it.getItemMeta().getDisplayName().contains("§7§lKit §9§lMonarque")) {
                	e.setCancelled(true);
                	Monarque.MonarquePreview(p);
                }
            	if(it.getItemMeta().getDisplayName().contains("§7§lKit §b§lVIP")) {
                	e.setCancelled(true);
                	VIP.VIPPreview(p);
                }
            	if(it.getItemMeta().getDisplayName().contains("§7§lKit §e§lVIP+")) {
                	e.setCancelled(true);
                	VIPPLUS.VIPPLUSPreview(p);
                }
            }else {
            	e.setCancelled(true);
            }
            }
        
        			//-----------------------------------//
        
        
        
        
        	//-----------------[  Inventaire Information  ]------------------//
        
        if(inv != null && inv.getName().equalsIgnoreCase("§6Informations")){
            if(it == null || it.getType() == null)return;
            e.setCancelled(true);
            if(it.hasItemMeta()) {
            	if(it.getItemMeta().getDisplayName().contains("§6Items Inédits")) {
                	e.setCancelled(true);
                	ItemsInedits.ItemsALL(p);
                }
            	if(it.getItemMeta().getDisplayName().contains("§6Events")) {
                	e.setCancelled(true);
                	PlaningEvent.ItemsALL(p);
                }
            }else {
            	e.setCancelled(true);
            }
            }
        
        			//-----------------------------------//
        
        
        

    	//-----------------[  Inventaire Mur  ]------------------//
    
    if(inv != null && inv.getName().equalsIgnoreCase("§6Mur")){
        if(it == null || it.getType() == null)return;
        e.setCancelled(true);
        if(it.hasItemMeta()) {
        	if(it.getItemMeta().getDisplayName().contains("§5Mur D'obsidienne §8(§7250 blocks§8)")) {
        		
        		ItemStack grade = new ItemStack(Material.OBSIDIAN, 1);
                ItemMeta grademeta = grade.getItemMeta();
                grademeta.setDisplayName("§5Mur D'obsidienne §8(§7250 blocks§8)");
                grade.setItemMeta(grademeta);
               
            	e.setCancelled(true);
            	p.getInventory().addItem(grade);
            }
        	if(it.getItemMeta().getDisplayName().contains("§5Mur de Sable §8(§7250 blocks§8)")) {
        		
        		ItemStack grade1 = new ItemStack(Material.SAND, 1);
                ItemMeta grade1meta = grade1.getItemMeta();
                grade1meta.setDisplayName("§5Mur de Sable §8(§7250 blocks§8)");
                grade1.setItemMeta(grade1meta);
               
            	e.setCancelled(true);
            	p.getInventory().addItem(grade1);
            }
        }else {
        	e.setCancelled(true);
        }
        }
    
    			//-----------------------------------//
        
        
        
        
        	//-----------------[  Inventaire Menu Principal  ]------------------//
        
        if(inv != null && inv.getName().equalsIgnoreCase("§6Menu Principal")){
            if(it == null || it.getType() == null)return;
            e.setCancelled(true);
            if(it.hasItemMeta()) {
            	if(it.getItemMeta().getDisplayName().contains("§e§lMagasin")) {
                	e.setCancelled(true);
                	Magasin.MagasinAll(p);
                }
            	if(it.getItemMeta().getDisplayName().contains("§5§lMur Obsidienne§7/§5§lSable")) {
                	e.setCancelled(true);
                	Mur.MurALL(p);
                }
            	if(it.getItemMeta().getDisplayName().contains("§2§lWarps")) {
                	e.setCancelled(true);
                	WarpALL.Warp(p);
                }
            	if(it.getItemMeta().getDisplayName().contains("§d§lInformations")) {
                	e.setCancelled(true);
                	InformationALL.Information(p);
                }
            	if(it.getItemMeta().getDisplayName().contains("§2§lOptions")) {
                	e.setCancelled(true);
                	OptionALL.Option(p);
                }
            	if(it.getItemMeta().getDisplayName().contains("§9§lGrades")) {
                	e.setCancelled(true);
                	GradesMoney.GradeMoney(p);
                }
            	if(it.getItemMeta().getDisplayName().contains("§9§lPreview Kit")) {
                	e.setCancelled(true);
                	PreviewMenu.PreviewALL(p);
                }
            	if(it.getItemMeta().getDisplayName().contains("§6§lItems Inédits")) {
                	e.setCancelled(true);
                	ItemsInedits.ItemsALL(p);
                }
            	if(it.getItemMeta().getDisplayName().contains("§6§lItems Inédits")) {
                	e.setCancelled(true);
                	ItemsInedits.ItemsALL(p);
                }
            }else {
            	e.setCancelled(true);
            }
            }
        
        			//-----------------------------------//
        
        
        
        	//-----------------[  Retour ALL ]------------------//
        
        if(e.getInventory() == p.getOpenInventory().getTopInventory()) {
        	if(it.getType() == Material.STAINED_GLASS_PANE) {
        		e.setCancelled(true);
        	}
        	if(it.hasItemMeta()) {
        		if(it.getItemMeta().getDisplayName().equalsIgnoreCase("§2Retour")) {
                	e.setCancelled(true);
                	Magasin.MagasinAll(p);
                }
        		if(it.getItemMeta().getDisplayName().equalsIgnoreCase("§2Retour Preview")) {
                	e.setCancelled(true);
                	PreviewMenu.PreviewALL(p);
                }
                
                    
                    	if(it.getItemMeta().getDisplayName().contains("§6Menu Principal")) {
                        	e.setCancelled(true);
                        	MenuPrincipal.MenuALL(p);
                        
                    }
        	}
        }
        
            			//-----------------------------------//
            
            
            
            
            //-----------------[  Inventaire Block  ]------------------//
            
        if(inv != null && inv.getName().equalsIgnoreCase("§6Block")){
            if(it == null || it.getType() == null)return;
            e.setCancelled(true);
            if(it.hasItemMeta()) {
            	if(it.getItemMeta().getDisplayName().contains("§ePage Suivante")) {
                	e.setCancelled(true);
                	Block.BlockPage2(p);
                }
            }
            }
        
        if(inv != null && inv.getName().equalsIgnoreCase("§6Block§8(§71§8)")){
            if(it == null || it.getType() == null)return;
            e.setCancelled(true);
            if(it.hasItemMeta()) {
            	if(it.getItemMeta().getDisplayName().contains("§ePage Précèdente")) {
                	e.setCancelled(true);
                	Block.BlockPage1(p);
                }
            }
            }
        				//-----------------------------------//
        
        
        		//-----------------[  Inventaire Items Inédit  ]------------------//
        
		    if(inv != null && inv.getName().equalsIgnoreCase("§6Items Inédits")){
		        if(it == null || it.getType() == null)return;
		        e.setCancelled(true);

		        }
    				//-----------------------------------//
        
        
        
        
        	//-----------------[  Inventaire Magasin ALL  ]------------------//
        
        if(inv != null && inv.getName().equalsIgnoreCase("§8§lMagasin §7(§8Catégories§7)")){
            if(it == null || it.getType() == null)return;
            e.setCancelled(true);
            if(it.hasItemMeta()) {
                if(it.getItemMeta().getDisplayName().contains("§6Farm")) {
                	e.setCancelled(true);
                	Farm.FarmAll(p);
                }
                if(it.getItemMeta().getDisplayName().contains("§6Block")) {
                	e.setCancelled(true);
                	Block.BlockPage1(p);
                }
                if(it.getItemMeta().getDisplayName().contains("§6Minerais")) {
                	e.setCancelled(true);
                	Minerai.MineraiALL(p);
                }
				if(it.getItemMeta().getDisplayName().contains("§6Alchimie")) {
					Alchimie.AlchimieALL(p);
					e.setCancelled(true);

				}
				if(it.getItemMeta().getDisplayName().contains("§6Nourriture")) {
					e.setCancelled(true);
					Nourriture.NourritureALL(p);
				}
				if(it.getItemMeta().getDisplayName().contains("§6Potions")) {
					e.setCancelled(true);
					Potion.PotionALL(p);

				}
				if(it.getItemMeta().getDisplayName().contains("§6Spawner")) {
					e.setCancelled(true);
					Spawners.SpawnerALL(p);
				}
				if(it.getItemMeta().getDisplayName().contains("§6Kits")) {
					e.setCancelled(true);
					Kits.KitsALL(p);
				}
				if(it.getItemMeta().getDisplayName().contains("§6Décoration")) {
					e.setCancelled(true);
					Decoration.DecorationALL(p);
				}
				if(it.getItemMeta().getDisplayName().contains("§6Enchantement")) {
					e.setCancelled(true);
					Enchantement.EnchantementALL(p);
				}
				if(it.getItemMeta().getDisplayName().contains("§6Pillage")) {
					e.setCancelled(true);
					Pillage.PillageALL(p);
				}
				
		
	  }
	
}
        			//-----------------------------------//
	}
}
