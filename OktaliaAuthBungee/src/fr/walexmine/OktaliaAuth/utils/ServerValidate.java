package fr.walexmine.OktaliaAuth.utils;

import net.md_5.bungee.api.config.ServerInfo;

public class ServerValidate
{
  protected ServerInfo server;
  protected int maxonline;
  
  public ServerValidate(ServerInfo paramServerInfo, int paramInt)
  {
    this.server = paramServerInfo;
    this.maxonline = paramInt;
  }
  
  public ServerInfo getServer()
  {
    return this.server;
  }
  
  public int getMaxOnline()
  {
    return this.maxonline;
  }
}

