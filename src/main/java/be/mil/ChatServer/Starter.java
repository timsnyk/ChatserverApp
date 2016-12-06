package be.mil.ChatServer;


import be.mil.ChatServer.facade.ChatFacade;
import be.mil.ChatServer.netty.server.TCPServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication

/**
 * Created by benoit on 30/11/2016.
 */
public class Starter {


    @Autowired
    private ChatFacade chatFacade;

    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(Starter.class, args);


        TCPServer tcpServer = context.getBean(TCPServer.class);
        try {
            tcpServer.start();
         //   tcpServer.sendMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
