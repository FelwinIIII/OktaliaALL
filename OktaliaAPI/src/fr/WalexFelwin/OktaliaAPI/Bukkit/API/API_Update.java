package fr.WalexFelwin.OktaliaAPI.Bukkit.API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import fr.WalexFelwin.OktaliaAPI.Bukkit.Main;


public class API_Update {

	  
	  public static void update(String urls, String plugin)
	  {
		  System.out.println(Main.getInstance().getDataFolder().toURI());
		  String file = ""+Main.getInstance().getDataFolder().toURI();
		  String filenew = file.replace("file:", "").replace("HezonNetWorkAPI/", "");
    		
		  try{    
	          String target = new String("rm "+filenew+plugin);
	          Runtime rt = Runtime.getRuntime();
	          Process proc = rt.exec(target);
	
	      } catch (Throwable t)
	      {
	          t.printStackTrace();
	      
	      }
		
		try{    
		      String target = new String("wget "+urls+" -P "+filenew);
		      Runtime rt = Runtime.getRuntime();
		      Process proc = rt.exec(target);
		
		  } catch (Throwable t)
		  {
		      t.printStackTrace();
		  
		  }
		
	  }
	  public static String updatesend(String urtl) throws MalformedURLException, IOException{
		    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(urtl).openConnection();
		    try {
				if (localHttpURLConnection.getResponseCode() != 200) {
				  return "";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    InputStream localInputStream = localHttpURLConnection.getInputStream();Object localObject1 = null;
		    try
		    {
		      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
		      StringBuilder localStringBuilder = new StringBuilder();
		      String str1;
		      while ((str1 = localBufferedReader.readLine()) != null) {
		        localStringBuilder.append(str1);
		      }
		      String str2 = localStringBuilder.toString();
		 

			    return str2;
		    }
		    catch (Throwable localThrowable1)
		    {
		      localObject1 = localThrowable1;
		      throw localThrowable1;
		    }
		    finally
		    {
		      if (localInputStream != null) {
		        if (localObject1 != null) {
		          try
		          {
		            localInputStream.close();
		          }
		          catch (Throwable localThrowable4)
		          {
		            ((Throwable)localObject1).addSuppressed(localThrowable4);
		          }
		        } else {
		          localInputStream.close();
		        }
		      }
		    }
	  }
}
