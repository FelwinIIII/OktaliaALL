package fr.walexmine.OktaliaMine.API;

import java.sql.ResultSet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import fr.walexmine.OktaliaMine.Event.PlayerBreak;
import fr.walexmine.OktaliaMine.Inventaire.Reserve;
import fr.walexmine.OktaliaMine.SQL.Update;

public class API_Inventory {
	
	
	public static void additems(int Item, int NB, int data, Inventory inv1, String DisplayName, int Place){
		
		int spec = 0;
		
		ItemStack item = null;
		
		if(!(data == 0)){
			spec = data;
			item = new ItemStack(Item, NB, ((short)spec));
		} else {
		item = new ItemStack(Item, NB);
		}
	    ItemMeta itemmeta = item.getItemMeta();
		    itemmeta.setDisplayName(itemmeta.getDisplayName());	
		    ArrayList<String> lore = new ArrayList<>();
		    lore.add("");
		    lore.add("");
		    lore.add("§bQuantité: §e"+NB);
		    lore.add("");
		    lore.add("");
		    itemmeta.setLore(lore);	
	    item.setItemMeta(itemmeta);
	    
	    
	    	inv1.setItem(Place, item);
	}	
	
	
	public static void additemsfac(int Item, int NB, int data, Inventory inv1, String DisplayName, int Place){
		
		int spec = 0;
		
		ItemStack item = null;
		
		if(!(data == 0)){
			spec = data;
			item = new ItemStack(Item, NB, ((short)spec));
		} else {
		item = new ItemStack(Item, NB);
		}
	    ItemMeta itemmeta = item.getItemMeta();
		    itemmeta.setDisplayName(itemmeta.getDisplayName());	
		    ArrayList<String> lore = new ArrayList<>();
		    lore.add("");
		    lore.add("");
		    lore.add("§bQuantité: §e"+NB);
		    lore.add("");
		    lore.add("§eClic droit §7>> §aRécuperer l'item");
		    lore.add("");
		    lore.add("");
		    itemmeta.setLore(lore);	
	    item.setItemMeta(itemmeta);
	    
	    
	    	inv1.setItem(Place, item);
	}
	
	public static void addnewitems(int Item, int NB, int data, Inventory inv1, ArrayList<String> lore, String DisplayName, int Place){
		
		int spec = 0;
		
		ItemStack item = null;
		
		if(!(data == 0)){
			spec = data;
			item = new ItemStack(Item, NB, ((short)spec));
		} else {
		item = new ItemStack(Item, NB);
		}
	    ItemMeta itemmeta = item.getItemMeta();
		    itemmeta.setDisplayName(itemmeta.getDisplayName());	
		  
		    itemmeta.setLore(lore);	
		    
		    itemmeta.setDisplayName(DisplayName);
	    item.setItemMeta(itemmeta);
	    
	    
	    	inv1.setItem(Place, item);
	    
		
	}
	
	
	public static void CreateProfil(Player p) {
		
	    boolean exist = false;
	    try
	    {
	      ResultSet rs = Update.Query("SELECT `id` FROM `InfoInventory` WHERE `UUID`='" + p.getUniqueId() + "'");
	      while (rs.next()) {
	    	  
	        exist = Boolean.valueOf(true).booleanValue();
	      }
	    }
	    catch (Exception err)
	    {
	      System.err.println(err);
	      err.printStackTrace();
	    }
	    if (!exist) {
	      Update.Update("INSERT INTO `InfoInventory` (`UUID`, `Pseudo`, `ReserveMine`) VALUES ('" + p.getUniqueId()+ "', '" + p.getName() + "', '')");
	      resetreserveminage(p);
	    }
	    
	}

	  public static String getinventory(String uuid)
	  {
		  String i = null;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `Inventory1` FROM `InfoInventory` WHERE `UUID`='" + uuid + "'");
		      while (rs.next()) {
		    	  String inventory;
		        i = rs.getString(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return i;
	  }

	  public static String getinvcontent(String uuid)
	  {
		  String i = null;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `Content1` FROM `InfoInventory` WHERE `UUID`='" + uuid + "'");
		      while (rs.next()) {
		    	  String inventory;
		        i = rs.getString(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return i;
	  }
	  
	  public static String getminage(String uuid)
	  {
		  String i = null;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `InventoryMine` FROM `InfoInventory` WHERE `UUID`='" + uuid + "'");
		      while (rs.next()) {
		    	  String inventory;
		        i = rs.getString(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return i;
	  }

	  public static String getmincontent(String uuid)
	  {
		  String i = null;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `ContentMine` FROM `InfoInventory` WHERE `UUID`='" + uuid + "'");
		      while (rs.next()) {
		    	  String inventory;
		        i = rs.getString(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return i;
	  }
	  
	  public static void setinventoryw(Player p, String s)
	  {
		  
		
		Update.Update("UPDATE `InfoInventory` SET `Inventory1`='" + s + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  public static void setinventorywArmor(Player p, String s)
	  {
		  
		
		Update.Update("UPDATE `InfoInventory` SET `Content1`='" + s + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  
	  public static void setminagew(Player p, String s)
	  {
		  
		
		Update.Update("UPDATE `InfoInventory` SET `InventoryMine`='" + s + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  public static void setminagewArmor(Player p, String s)
	  {
		  
		
		Update.Update("UPDATE `InfoInventory` SET `ContentMine`='" + s + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	    /*
	     *
	     * RESERVE
	     * 
	     */

	  
	  public static String getReserveFaction(String uuid)
	  {
		  String i = null;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `ReserveFaction` FROM `InfoInventory` WHERE `UUID`='" + uuid + "'");
		      while (rs.next()) {
		    	  String inventory;
		        i = rs.getString(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return i;
	  }
	  
	  public static String getReserveMine(String uuid)
	  {
		  String i = null;
		    try
		    {
		      ResultSet rs = Update.Query("SELECT `ReserveMine` FROM `InfoInventory` WHERE `UUID`='" + uuid + "'");
		      while (rs.next()) {
		    	  String inventory;
		        i = rs.getString(1);
		      }
		    }
		    catch (Exception err)
		    {
		      System.err.println(err);
		      err.printStackTrace();
		    }
	    return i;
	  }
	  
	  
	  
	  public static void saveReserveFactions(Player p, String s)
	  {
		  
		
		Update.Update("UPDATE `InfoInventory` SET `ReserveFaction`='" + s + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  public static void saveReserveMine(Player p, String s)
	  {
		  
		
		Update.Update("UPDATE `InfoInventory` SET `ReserveMine`='" + s + "' WHERE `UUID`='" + p.getUniqueId() + "'");
	  }
	  
	  public static void resetreserveminage(Player p)
	  {
		  Inventory inv = Bukkit.createInventory(null, 36, "§eReserve Minage");
		  
		  saveReserveMine(p, API_Inventory.toBase64(inv));
		  PlayerBreak.ReserveM.put(p, inv);
		  
	  }
	  
	  
	  
	  
	  
	    /*
	     * 
	     * 
	     * INVENTAIRE
	     * 
	     * 
	     * */
	  
	  public static String toBase64(Inventory inventory) {
	        try {
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
	            
	            // Write the size of the inventory
	            dataOutput.writeInt(inventory.getSize());
	            
	            // Save every element in the list
	            for (int i = 0; i < inventory.getSize(); i++) {
	                dataOutput.writeObject(inventory.getItem(i));
	            }
	            
	            // Serialize that array
	            dataOutput.close();
	            return Base64Coder.encodeLines(outputStream.toByteArray());
	        } catch (Exception e) {
	            throw new IllegalStateException("Unable to save item stacks.", e);
	        }        
	    }
	    
	    public static Inventory fromBase64(String data) throws IOException {
	        try {
	            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
	            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
	            Inventory inventory = Bukkit.getServer().createInventory(null, dataInput.readInt());
	    
	            // Read the serialized inventory
	            for (int i = 0; i < inventory.getSize(); i++) {
	                inventory.setItem(i, (ItemStack) dataInput.readObject());
	            }
	            dataInput.close();
	            return inventory;
	        } catch (ClassNotFoundException e) {
	            throw new IOException("Unable to decode class type.", e);
	        }
	}
	    
	    
	    
	    
	    /*
	     * 
	     * 
	     * ARMURE
	     * 
	     * 
	     * */
	    
	    public static String itemStackArrayToBase64(ItemStack[] items) throws IllegalStateException {
	    	try {
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
	            
	            // Write the size of the inventory
	            dataOutput.writeInt(items.length);
	            
	            // Save every element in the list
	            for (int i = 0; i < items.length; i++) {
	                dataOutput.writeObject(items[i]);
	            }
	            
	            // Serialize that array
	            dataOutput.close();
	            return Base64Coder.encodeLines(outputStream.toByteArray());
	        } catch (Exception e) {
	            throw new IllegalStateException("Unable to save item stacks.", e);
	        }
	}
	
	    
	    public static ItemStack[] itemStackArrayFromBase64(String data) throws IOException {
	    	try {
	            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
	            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
	            ItemStack[] items = new ItemStack[dataInput.readInt()];
	    
	            // Read the serialized inventory
	            for (int i = 0; i < items.length; i++) {
	            	items[i] = (ItemStack) dataInput.readObject();
	            }
	            
	            dataInput.close();
	            return items;
	        } catch (ClassNotFoundException e) {
	            throw new IOException("Unable to decode class type.", e);
	        }
	}
}
