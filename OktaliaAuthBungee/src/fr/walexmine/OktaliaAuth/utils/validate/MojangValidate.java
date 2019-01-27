package fr.walexmine.OktaliaAuth.utils.validate;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MojangValidate
{
  private final Logger logger;
  private final Gson gson = new GsonBuilder().create();
  private long lastMojangError;
  
  public MojangValidate(Logger paramLogger)
  {
    this.logger = paramLogger;
  }
  
  public MojangValidateProfile getPremiumProfile(String paramString) throws Throwable
  {
    MojangValidateProfile localMojangValidateProfile = new MojangValidateProfile(paramString);
    try
    {
      ValidateProfile localValidateProfile = System.currentTimeMillis() - this.lastMojangError > TimeUnit.MINUTES.toMillis(10L) ? getValidateProfile(paramString, Api.MOJANG) : getValidateProfile(paramString, Api.CRAFTAPI);
      if ((localValidateProfile == null) || (localValidateProfile.getName() == null) || (localValidateProfile.getId() == null)) {
        return localMojangValidateProfile;
      }
      localMojangValidateProfile.setUser(localValidateProfile.getName());
      localMojangValidateProfile.setUuid(localValidateProfile.getUniqueId());
      localMojangValidateProfile.setOnlineMode(true);
    }
    catch (Exception localIOException)
    {
      localMojangValidateProfile.setError(true);
    }
    return localMojangValidateProfile;
  }
  
  private ValidateProfile getValidateProfile(String paramString, Api paramApi) throws Throwable
  {
    switch (paramApi)
    {
    case MOJANG: 
      try
      {
        return getMojang(paramString);
      }
      catch (IOException localIOException1)
      {
        this.logger.log(Level.WARNING, "Problem with Mojang API. It has been disabled for 10 minutes and it was used Craft API.", localIOException1.getMessage());
        this.lastMojangError = System.currentTimeMillis();
        return getValidateProfile(paramString, Api.CRAFTAPI);
      }
    case MCAPI: 
      try
      {
        return getMcApi(paramString);
      }
      catch (IOException localIOException2)
      {
        this.logger.log(Level.WARNING, "Problem with MC API.", localIOException2.getMessage());
      }
    case CRAFTAPI: 
      try
      {
        return getCraftApi(paramString);
      }
      catch (IOException localIOException3)
      {
        this.logger.log(Level.WARNING, "Problem with Craft API. It was used MC API.", localIOException3.getMessage());
        return getValidateProfile(paramString, Api.MCAPI);
      }
    }
    return null;
  }
  
  private ValidateProfile getCraftApi(String paramString) throws Throwable
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("http://craftapi.com/api/user/uuid/" + paramString.toLowerCase()).openConnection();
    if (localHttpURLConnection.getResponseCode() != 200) {
      return null;
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
      ValidateProfile localValidateProfile;
      if (str2.isEmpty()) {
        return null;
      }
      return readProfile(CraftApiProfile.class, str2);
    }
    catch (Throwable localThrowable1)
    {
      localObject1 = localThrowable1;throw localThrowable1;
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
  
  private ValidateProfile getMcApi(String paramString) throws Throwable
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("http://us.mc-api.net/v3/uuid/" + paramString.toLowerCase()).openConnection();
    if (localHttpURLConnection.getResponseCode() == 404) {
      return null;
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
      ValidateProfile localValidateProfile;
      if (str2.isEmpty()) {
        return null;
      }
      return readProfile(McApiProfile.class, str2);
    }
    catch (Throwable localThrowable1)
    {
      localObject1 = localThrowable1;throw localThrowable1;
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
  
  private ValidateProfile getMojang(String paramString) throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("https://api.mojang.com/users/profiles/minecraft/" + paramString.toLowerCase()).openConnection();
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
      ValidateProfile localValidateProfile;
      if (str2.isEmpty()) {
        return null;
      }
      return readProfile(MojangProfile.class, str2);
    }
    catch (Throwable localThrowable1)
    {
      localObject1 = localThrowable1;throw localThrowable1;
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
  
  private <T extends ValidateProfile> T readProfile(Class<T> paramClass, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (T)this.gson.fromJson(paramString, paramClass);
  }
  
  public static enum Api
  {
    MOJANG,  MCAPI,  CRAFTAPI;
    
    private Api() {}
  }
  
  public static abstract interface ValidateProfile
  {
    public abstract String getId();
    
    public abstract UUID getUniqueId();
    
    public abstract String getName();
    
    public abstract MojangValidate.Api getApi();
  }
  
  private class MojangProfile
    implements MojangValidate.ValidateProfile
  {
    private String id;
    private String name;
    private MojangValidate.Api api = MojangValidate.Api.MOJANG;
    
    private MojangProfile() {}
    
    public String getId()
    {
      return this.id;
    }
    
    public UUID getUniqueId()
    {
      String str = this.id;
      return UUID.fromString(str.substring(0, 8) + "-" + str.substring(8, 12) + "-" + str.substring(12, 16) + "-" + str.substring(16, 20) + "-" + str.substring(20, 32));
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public MojangValidate.Api getApi()
    {
      return this.api;
    }
    
    public void setApi(MojangValidate.Api paramApi)
    {
      this.api = paramApi;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("MojangProfile{");
      localStringBuilder.append("id='").append(this.id).append('\'');
      localStringBuilder.append(", name='").append(this.name).append('\'');
      localStringBuilder.append(", api=").append(this.api);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  private class McApiProfile
    implements MojangValidate.ValidateProfile
  {
    private String uuid;
    private String full_uuid;
    private String name;
    private MojangValidate.Api api = MojangValidate.Api.MCAPI;
    
    private McApiProfile() {}
    
    public String getId()
    {
      return this.uuid;
    }
    
    public UUID getUniqueId()
    {
      return UUID.fromString(this.full_uuid);
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public MojangValidate.Api getApi()
    {
      return this.api;
    }
    
    public void setApi(MojangValidate.Api paramApi)
    {
      this.api = paramApi;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("McApiProfile{");
      localStringBuilder.append("uuid='").append(this.uuid).append('\'');
      localStringBuilder.append(", full_uuid='").append(this.full_uuid).append('\'');
      localStringBuilder.append(", name='").append(this.name).append('\'');
      localStringBuilder.append(", api=").append(this.api);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  private class CraftApiProfile
    implements MojangValidate.ValidateProfile
  {
    private String uuid;
    private String username;
    private MojangValidate.Api api = MojangValidate.Api.CRAFTAPI;
    
    private CraftApiProfile() {}
    
    public String getId()
    {
      return this.uuid;
    }
    
    public UUID getUniqueId()
    {
      return UUID.fromString(this.uuid.substring(0, 8) + "-" + this.uuid.substring(8, 12) + "-" + this.uuid.substring(12, 16) + "-" + this.uuid.substring(16, 20) + "-" + this.uuid.substring(20, 32));
    }
    
    public String getName()
    {
      return this.username;
    }
    
    public MojangValidate.Api getApi()
    {
      return this.api;
    }
    
    public void setApi(MojangValidate.Api paramApi)
    {
      this.api = paramApi;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("CraftApiProfile{");
      localStringBuilder.append("uuid='").append(this.uuid).append('\'');
      localStringBuilder.append(", username='").append(this.username).append('\'');
      localStringBuilder.append(", api=").append(this.api);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}