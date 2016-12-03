package be.mil.ChatServer.domain;

import java.util.*;

/**
 * Created by benoit on 01/12/2016.
 */
public abstract class ChatRoom {

    protected final Set<Chatter> chatterList = new HashSet<Chatter>();
    private int id;
    private String name;
    private Set<Message> messages = new TreeSet<Message>();

    public ChatRoom(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean addMessage(Message message) {
        messages.add(message);
        //  chatterList.add(message.getChatter());
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatRoom)) return false;

        ChatRoom chatRoom = (ChatRoom) o;

        return name != null ? name.equals(chatRoom.name) : chatRoom.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public void subscribehatter(Chatter chatter) {
        chatterList.add(chatter);
    }

    public void removeChatter(Chatter chatter) {
        chatterList.remove(chatter);
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chatterList=" + chatterList +
                ", messages=" + messages +
                '}';
    }

    public boolean isSubscribed(Chatter chatter) {
        if (chatterList.contains(chatter)) {
            return true;
        }
        return false;
    }

    public List<Message> getMessages() {

        return new ArrayList<>(messages);
    }
}
