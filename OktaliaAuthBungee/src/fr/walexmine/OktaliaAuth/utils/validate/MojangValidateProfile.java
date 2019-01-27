package fr.walexmine.OktaliaAuth.utils.validate;


import java.util.UUID;

public class MojangValidateProfile
{
  private String user;
  private UUID uuid;
  private boolean onlineMode;
  private boolean error;
  
  public MojangValidateProfile(String paramString)
  {
    this.user = paramString;
  }
  
  public String getUser()
  {
    return this.user;
  }
  
  public void setUser(String paramString)
  {
    this.user = paramString;
  }
  
  public UUID getUuid()
  {
    return this.uuid;
  }
  
  public void setUuid(UUID paramUUID)
  {
    this.uuid = paramUUID;
  }
  
  public boolean isOnlineMode()
  {
    return this.onlineMode;
  }
  
  public void setOnlineMode(boolean paramBoolean)
  {
    this.onlineMode = paramBoolean;
  }
  
  public boolean isError()
  {
    return this.error;
  }
  
  public void setError(boolean paramBoolean)
  {
    this.error = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MojangValidateProfile{");
    localStringBuilder.append("user='").append(this.user).append('\'');
    localStringBuilder.append(", uuid=").append(this.uuid);
    localStringBuilder.append(", onlineMode=").append(this.onlineMode);
    localStringBuilder.append(", error=").append(this.error);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
