package fr.walexmine.RDOktalia.faucet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import net.md_5.bungee.chat.TextComponentSerializer;
import net.md_5.bungee.chat.TranslatableComponentSerializer;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Class for fetching information of servers
 * @see StatusResponse
 */
public class ServerListPing {
    private int timeout = 7000;
    private static Gson gson = new GsonBuilder()
            .registerTypeAdapter(BaseComponent.class, new ComponentSerializer())
            .registerTypeAdapter(TextComponent.class, new TextComponentSerializer())
            .registerTypeAdapter(TranslatableComponentSerializer.class, new TranslatableComponentSerializer())
            .create();

    private static int readVarInt(DataInputStream in) throws IOException {
        int i = 0;
        int j = 0;
        while (true) {
            int k = in.readByte();
            i |= (k & 0x7F) << j++ * 7;
            if (j > 5) throw new RuntimeException("VarInt too big");
            if ((k & 0x80) != 128) break;
        }
        return i;
    }

    private static void writeVarInt(DataOutputStream out, int paramInt) throws IOException {
        while (true) {
            if ((paramInt & 0xFFFFFF80) == 0) {
                out.writeByte(paramInt);
                return;
            }

            out.writeByte(paramInt & 0x7F | 0x80);
            paramInt >>>= 7;
        }
    }

    public StatusResponse ping(InetSocketAddress host) throws IOException {
        try (Socket socket = new Socket()) {
            socket.setSoTimeout(timeout);
            socket.connect(host, timeout);

            try (DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                 DataInputStream dataInputStream = new DataInputStream(socket.getInputStream())) {
                ByteArrayOutputStream b = new ByteArrayOutputStream();
                DataOutputStream handshake = new DataOutputStream(b);
                handshake.writeByte(0x00); //packet id for handshake
                writeVarInt(handshake, 4); //protocol version
                writeVarInt(handshake, host.getHostString().length()); //host length
                handshake.writeBytes(host.getHostString()); //host string
                handshake.writeShort(host.getPort()); //port
                writeVarInt(handshake, 1); //state (1 for handshake)

                writeVarInt(dataOutputStream, b.size()); //prepend size
                dataOutputStream.write(b.toByteArray()); //write handshake packet


                dataOutputStream.writeByte(0x01); //size is only 1
                dataOutputStream.writeByte(0x00); //packet id for ping
                int size = readVarInt(dataInputStream); //size of packet
                int id = readVarInt(dataInputStream); //packet id

                if (id == -1) {
                    throw new IOException("Premature end of stream.");
                }

                if (id != 0x00) { //we want a status response
                    throw new IOException("Invalid packetID");
                }

                int length = readVarInt(dataInputStream); //length of json string
                if (length == -1) {
                    throw new IOException("Premature end of stream.");
                }

                if (length == 0) {
                    throw new IOException("Invalid string length.");
                }

                byte[] in = new byte[length];
                dataInputStream.readFully(in);  //read json string
                String json = new String(in);


                long now = System.currentTimeMillis();
                dataOutputStream.writeByte(0x09); //size of packet
                dataOutputStream.writeByte(0x01); //0x01 for ping
                dataOutputStream.writeLong(now); //time!?

                readVarInt(dataInputStream);
                id = readVarInt(dataInputStream);
                if (id == -1) {
                    throw new IOException("Premature end of stream.");
                }

                if (id != 0x01) {
                    throw new IOException("Invalid packetID");
                }
                long pingtime = dataInputStream.readLong(); //read response

                StatusResponse response = gson.fromJson(json, StatusResponse.class);
                response.setTime((int) (now - pingtime));
                return response;
            }
        }
    }

    public void setTimeout(int timeout) {
         this.timeout = timeout;
    }

    public int getTimeout() {
        return timeout;
    }
}