package be.mil.ChatServer;

import java.util.*;

/**
 * Created by benoit on 30/11/2016.
 */
public class PublicChatRoom extends ChatRoom {




    public PublicChatRoom(String name) {
        super(name);
    }

    public void addChatter(Chatter chatter){
        chatterList.add(chatter);
    }
}
