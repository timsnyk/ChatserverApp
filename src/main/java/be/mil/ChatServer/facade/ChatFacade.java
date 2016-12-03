package be.mil.ChatServer.facade;

import be.mil.ChatServer.domain.*;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.List;
import java.util.Set;

/**
 * Created by benoit on 01/12/2016.
 */
public final  class ChatFacade {

    private static ChatFacade chatFacade=new ChatFacade();

    private ChatFacade(){}

    private final Server server = new Server();


    public List<Chatter> getOnlineChatters() {
        return server.getChatterList();
    }

    public Set<String> getChatrooms() {
        return server.chatRooms();
    }

    public void createChatroom(String chatRoom) {

        try {
            server.createChatroom(chatRoom);
        } catch (AllreadyExist allreadyExist) {
            allreadyExist.printStackTrace();
        }

    }


    public void addMessage(Message message) {

        server.addMessage(message);
    }

    public void subscribe(String chatRoom, Chatter chatter) {
        server.subscribe(chatRoom, chatter);
    }

    public void unSubscribe(String chatRoom, Chatter chatter) {
        try {
            server.removeChatterFromChatRoom(chatRoom, chatter);
        } catch (NotFound notFound) {
            notFound.printStackTrace();
        } catch (ChatroomNotFound chatroomNotFound) {
            chatroomNotFound.printStackTrace();
        }
    }


    public static ChatFacade getInstance(){
        return chatFacade;
    }

}
