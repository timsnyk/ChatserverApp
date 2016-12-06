package be.mil.ChatServer;

import be.mil.ChatServer.domain.Chatter;
import be.mil.ChatServer.netty.server.ClientAdapterInitializer;
import be.mil.ChatServer.netty.server.ServerMessageService;
import com.thoughtworks.xstream.XStream;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by benoit on 05/12/2016.
 */
public class Client {
    String server;
    int port;
    int containerPort;

    public Client(String server, int port, int containerPort) {
        this.server = server;
        this.port = port;
        this.containerPort = containerPort;
    }

    public static void main(String[] args) {
        String server = "localhost";
        int port = 5252;
        int containerPort = 8094;
        new Client(server, port, containerPort).start();
    }

    public void start() {

        XStream xStream=new XStream();
        Chatter chatter=new Chatter("benoit");
       String xml= xStream.toXML(chatter);

        ServerMessageService serverMessageService=new ServerMessageService();
      //  serverMessageService.getListChatter();

        EventLoopGroup group = new NioEventLoopGroup();



        try {
            Bootstrap bootstrap = new Bootstrap().group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientAdapterInitializer());

            Channel channel = bootstrap.connect(server, port).sync().channel();

            channel.write(xml+"Hi\n");
            channel.write("Hi\n");
            channel.write("Hi\n");
            channel.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

}
