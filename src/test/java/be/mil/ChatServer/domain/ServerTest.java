package be.mil.ChatServer.domain;

import be.mil.ChatServer.domain.ChatroomNotFound;
import be.mil.ChatServer.domain.Chatter;
import be.mil.ChatServer.domain.Message;
import be.mil.ChatServer.domain.Server;

import static org.junit.Assert.*;

/**
 * Created by benoit on 02/12/2016.
 */
public class ServerTest {

    private Server server;

    @org.junit.Before
    public void setUp() throws Exception {
        server=new Server();
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void addMessage() throws Exception, AllreadyExist {
        Chatter chatter=new Chatter("benoit");
        server.addChatter(chatter);
        server.createChatroom("chat1");
        server.subscribe("chat1",chatter);
        assertEquals(1,server.getChatterList().size());
        assertEquals(1,server.chatRooms().size());
        Message message=new Message("fsfsdf",chatter,"chat1");
        message.setId(1);
        Message message2=new Message("fsfsdfsdqd",chatter,"chat1");
        message2.setId(2);
        server.addMessage(message);
        server.addMessage(message2);
        assertEquals(2,server.getChatRoom("chat1").getMessages().size());
    }

    @org.junit.Test
    public void addChatter() throws Exception {
        Chatter chatter=new Chatter("benoit");
        server.addChatter(chatter);
        assertEquals(1,server.getChatterList().size());
    }

    @org.junit.Test
    public void getChatterList() throws Exception, AllreadyExist {
        Chatter chatter=new Chatter("benoit");
        server.addChatter(chatter);
        server.createChatroom("chat1");
        server.subscribe("chat1",chatter);
        assertEquals(1,server.getChatterList().size());
        assertEquals(1,server.chatRooms().size());
        Message message=new Message("fsfsdf",chatter,"chat1");
        message.setId(1);
        Message message2=new Message("fsfsdfsdqd",chatter,"chat1");
        message2.setId(2);
        server.addMessage(message);
        server.addMessage(message2);
        assertEquals(2,server.getChatRoom("chat1").getMessages().size());
        server.deleteChatter(chatter);
        assertEquals(0,server.getChatterList().size());
    }

    @org.junit.Test(expected = ChatroomNotFound.class)
    public void unSubsribeNotFoundChatRoom() throws Exception, ChatroomNotFound, AllreadyExist {
        Chatter chatter=new Chatter("benoit");
        server.addChatter(chatter);
        server.createChatroom("chat1");
        server.subscribe("chat1",chatter);
        assertEquals(1,server.getChatterList().size());
        assertEquals(1,server.chatRooms().size());
        server.removeChatterFromChatRoom("chat2",chatter);
        assertFalse(server.getChatRoom("chat1").chatterList.contains(chatter));
    }

    @org.junit.Test(expected = ChatroomNotFound.class)
    public void unSubsribeNotFound() throws Exception, ChatroomNotFound, AllreadyExist {
        Chatter chatter=new Chatter("benoit");
        Chatter bad=new Chatter("benoit");
        server.addChatter(chatter);
        server.createChatroom("chat1");
        server.subscribe("chat1",bad);
        assertEquals(1,server.getChatterList().size());
        assertEquals(1,server.chatRooms().size());
        server.removeChatterFromChatRoom("chat2",chatter);
        assertFalse(server.getChatRoom("chat1").chatterList.contains(chatter));
    }



    @org.junit.Test
    public void unSubsribe() throws Exception, ChatroomNotFound, AllreadyExist {
        Chatter chatter=new Chatter("benoit");
        server.addChatter(chatter);
        server.createChatroom("chat1");
        server.subscribe("chat1",chatter);
        assertEquals(1,server.getChatterList().size());
        assertEquals(1,server.chatRooms().size());
        server.removeChatterFromChatRoom("chat1",chatter);
        assertFalse(server.getChatRoom("chat1").chatterList.contains(chatter));
    }


    @org.junit.Test
    public void subscribe() throws Exception, AllreadyExist {
        Chatter chatter=new Chatter("benoit");
        server.addChatter(chatter);
        server.createChatroom("chat1");
        server.subscribe("chat1",chatter);
        assertEquals(1,server.getChatterList().size());
        assertEquals(1,server.chatRooms().size());

    }

}