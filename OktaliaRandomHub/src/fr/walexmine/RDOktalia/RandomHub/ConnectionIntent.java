package fr.walexmine.RDOktalia.RandomHub;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class ConnectionIntent {
    public ConnectionIntent(RandomHub plugin, ProxiedPlayer player) {

    	//player.sendMessage(ConfigEntries.CONNECTING_MESSAGE.get());

        ServerInfo target = fetchServer(plugin);
        if (target != null) {
            this.connect(target);
        	player.sendMessage("§aConnexion au §e"+target.getName()+" §aréussit !");
        } else {
        	player.sendMessage(ConfigEntries.NO_SERVER_FOUND.get());
        }
    }

    private static ServerInfo fetchServer(RandomHub plugin) {
        List<ServerInfo> storage = new ArrayList<>();
        storage.addAll(plugin.getServers());

        int intents = ConfigEntries.SERVER_CHECK_INTENTS.get();
        while (intents-- >= 1) {
            ServerInfo server = storage.get(ThreadLocalRandom.current().nextInt(storage.size()));
            if (server == null) continue;

            if (storage.size() == 0) break;
            if (storage.size() == 1) {
                return storage.get(0);
            }

            StatusInfo status = plugin.getStatusManager().getStatus(server);
            if (status.isAccessible()) {
                return server;
            } else {
                storage.remove(server);
            }
        }

        return null;
    }

    public abstract void connect(ServerInfo server);
}
