/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package be.mil.ChatServer.netty.server;


import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TCPServer {

    @Autowired
    private ServerAdapterInitializer serverAdapterInitializer;




    private int port = 5252;
    private String server = "127.0.0.1";
    private io.netty.channel.Channel channel;

    public TCPServer() {

    }

    public static void main(String[] args) {
        new TCPServer().start();
    }


    public void sendMessage() {


    }


    public void start() {

        EventLoopGroup producer = new NioEventLoopGroup();
        EventLoopGroup consumer = new NioEventLoopGroup();

        try {
             Bootstrap bootstrapClient = new Bootstrap().group(new NioEventLoopGroup())
                    .channel(NioSocketChannel.class)
                    .handler(new ClientAdapterInitializer());


            ServerBootstrap bootstrap = new ServerBootstrap()
                    .group(producer, consumer)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(serverAdapterInitializer);
            System.out.println("Server started");
            bootstrap.bind(port).sync().channel().closeFuture().sync();
            try {
                channel = bootstrapClient.connect(server, port).sync().channel();


                try {


                    channel.write("Hi\n");
                    channel.write("Hi\n");
                    channel.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                    bootstrap.group().shutdownGracefully();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdownGracefully();
            consumer.shutdownGracefully();
        }

    }

}