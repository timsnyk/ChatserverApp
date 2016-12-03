package be.mil.ChatServer.domain;


import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.*;

/**
 * Created by benoit on 01/12/2016.
 */
public class Server {

    private final List<Chatter> chatterList = new ArrayList<Chatter>();

    private final Map<String, ChatRoom> chatRoomset = new HashMap<String, ChatRoom>();


    public Set<String> chatRooms() {
        return chatRoomset.keySet();
    }


    public boolean addMessage(Message message) {

        if (!chatRoomset.containsValue(message.getChatRoom())) {
            ChatRoom room = chatRoomset.get(message.getChatRoom());
            if (room.isSubscribed(message.getChatterFrom())) {
                room.addMessage(message);
                return true;
            }
        }
        return false;
    }

    public void addChatter(Chatter chatter) {
        chatterList.add(chatter);
    }

    public List<Chatter> getChatterList() {
        return chatterList;
    }

    public boolean deleteChatter(Chatter chatter) {

        final long c = chatRoomset.values().stream().filter(f -> f.isSubscribed(chatter)).count();
        if (c != 0) {
            chatterList.remove(chatter);
            return true;
        }
        return false;
    }


    public void subscribe(String chatRoom, Chatter chatter) {
        if (chatRoomset.containsKey(chatRoom) && chatterList.contains(chatter)) {
            ChatRoom chatR = chatRoomset.get(chatRoom);
            chatR.subscribehatter(chatter);
        }
    }

    public void createChatroom(String nameChatRoom) throws AllreadyExist {
        if (!chatRoomset.containsKey(nameChatRoom)) {
            ChatRoom chatRoom = new PublicChatRoom(nameChatRoom);
            chatRoomset.put(nameChatRoom, chatRoom);

        } else {
            throw new AllreadyExist();
        }
    }

    public ChatRoom getChatRoom(String chatRoom) {
        return chatRoomset.get(chatRoom);
    }

    public void removeChatterFromChatRoom(String chatRoom, Chatter chatter) throws NotFound, ChatroomNotFound {

        if (getChatRoom(chatRoom) != null) {
            boolean ret = getChatRoom(chatRoom).chatterList.remove(chatter);
            if (!ret) throw new NotFound();
        } else {
            throw new ChatroomNotFound();
        }


    }
}
