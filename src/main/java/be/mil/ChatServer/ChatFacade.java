package be.mil.ChatServer;

/**
 * Created by benoit on 01/12/2016.
 */
public class ChatFacade {

    private Server server=new Server();



    public void addMessage(Message message){

        server.addMessage(message);
    }

    public void subscribe(ChatRoom chatRoom){
      //  server.subscribe(chatRoom);
    }



}
