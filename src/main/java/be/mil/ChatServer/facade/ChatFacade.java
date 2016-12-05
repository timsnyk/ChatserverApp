package be.mil.ChatServer.facade;

import be.mil.ChatServer.domain.*;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

/**
 * Created by benoit on 01/12/2016.
 */
@Service
public final  class ChatFacade {


    @PostConstruct
    public void test(){
        System.out.println("test");
    }

    private static ChatFacade chatFacade=new ChatFacade();

    private ChatFacade(){}

    @Autowired
    private  Server server;


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
