package fr.WalexFelwin.OktaliaAPI.BungeeCord.CrashPinger.Pinger;


import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import net.md_5.bungee.BungeeServerInfo;
import net.md_5.bungee.ServerConnector;
import net.md_5.bungee.UserConnection;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.connection.InitialHandler;
import net.md_5.bungee.netty.HandlerBoss;
import net.md_5.bungee.netty.PipelineUtils;
import net.md_5.bungee.netty.PipelineUtils.Base;
import net.md_5.bungee.protocol.MinecraftDecoder;
import net.md_5.bungee.protocol.MinecraftEncoder;
import net.md_5.bungee.protocol.Protocol;

public class BasicChannelInitializer
  extends ChannelInitializer<Channel>
{
  private final ProxyServer bungee;
  private final UserConnection user;
  private final BungeeServerInfo target;
  
  public BasicChannelInitializer(ProxyServer bungee, UserConnection user, BungeeServerInfo target)
  {
    this.bungee = bungee;
    this.user = user;
    this.target = target;
  }
  
  protected void initChannel(Channel ch)
    throws Exception
  {
    PipelineUtils.BASE.initChannel(ch);
    ch.pipeline().addAfter("frame-decoder", "packet-decoder", new MinecraftDecoder(Protocol.HANDSHAKE, false, this.user.getPendingConnection().getVersion()));
    ch.pipeline().addAfter("frame-prepender", "packet-encoder", new MinecraftEncoder(Protocol.HANDSHAKE, false, this.user.getPendingConnection().getVersion()));
    ((HandlerBoss)ch.pipeline().get(HandlerBoss.class)).setHandler(new ServerConnector(this.bungee, this.user, this.target));
  }
}
