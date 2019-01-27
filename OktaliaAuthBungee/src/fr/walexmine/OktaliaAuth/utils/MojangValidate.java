package fr.walexmine.OktaliaAuth.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

@Deprecated
public class MojangValidate
  implements Runnable
{
  public static final String HTTP_HASPAID = "https://api.mojang.com/users/profiles/minecraft/{PLAYER}";
  private String user;
  private UUID uuid;
  private boolean onlineMode;
  private boolean error;
  
  public MojangValidate(String paramString)
  {
    this.user = paramString;
    this.onlineMode = false;
    this.error = false;
  }
  
  public boolean isOnlineMode()
  {
    return this.onlineMode;
  }
  
  public String getUser()
  {
    return this.user;
  }
  
  public UUID getUuid()
  {
    return this.uuid;
  }
  
  public boolean isError()
  {
    return this.error;
  }
  
  public void run()
  {
    this.onlineMode = false;
    this.error = false;
    try
    {
      URL localURL = new URL("https://api.mojang.com/users/profiles/minecraft/{PLAYER}".replace("{PLAYER}", this.user.toLowerCase()));
      URLConnection localURLConnection = localURL.openConnection();
      localURLConnection.setConnectTimeout(1000);
      localURLConnection.setReadTimeout(1000);
      try
      {
        InputStream localInputStream = localURLConnection.getInputStream();Object localObject1 = null;
        try
        {
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
          StringBuilder localStringBuilder = new StringBuilder();
          String str1 = null;
          while ((str1 = localBufferedReader.readLine()) != null) {
            localStringBuilder.append(str1);
          }
          String str2 = localStringBuilder.toString();
          if (!str2.isEmpty())
          {
            Gson localGson = new GsonBuilder().create();
            MojangProfile localMojangProfile = (MojangProfile)localGson.fromJson(str2, MojangProfile.class);
            this.user = localMojangProfile.getName();
            String str3 = localMojangProfile.getId();
            this.uuid = UUID.fromString(str3.substring(0, 8) + "-" + str3.substring(8, 12) + "-" + str3.substring(12, 16) + "-" + str3.substring(16, 20) + "-" + str3.substring(20, 32));
            this.onlineMode = true;
          }
          else
          {
            this.onlineMode = false;
          }
        }
        catch (Throwable localThrowable2)
        {
          localObject1 = localThrowable2;throw localThrowable2;
        }
        finally
        {
          if (localInputStream != null) {
            if (localObject1 != null) {
              try
              {
                localInputStream.close();
              }
              catch (Throwable localThrowable3)
              {
                ((Throwable)localObject1).addSuppressed(localThrowable3);
              }
            } else {
              localInputStream.close();
            }
          }
        }
      }
      catch (IOException localIOException2)
      {
        this.error = true;
      }
    }
    catch (IOException localIOException1)
    {
      this.error = true;
    }
  }
  
  public class MojangProfile
  {
    private String id;
    private String name;
    
    public MojangProfile() {}
    
    public String getId()
    {
      return this.id;
    }
    
    public String getName()
    {
      return this.name;
    }
  }
}
