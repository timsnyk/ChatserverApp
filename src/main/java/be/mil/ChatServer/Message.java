package be.mil.ChatServer;

/**
 * Created by benoit on 30/11/2016.
 */
public class Message implements Comparable<Message> {

    private int id;
    private  String chatRoom;
    private String body;
    private Chatter chatterFrom;

    public Message(String body, Chatter chatterFrom, String chatRoom) {
        this.body = body;
        this.chatterFrom = chatterFrom;
        this.chatRoom=chatRoom;
    }

    public Message(String body, Chatter chatter1) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Chatter getChatterFrom() {
        return chatterFrom;
    }

    public void setChatterFrom(Chatter chatterFrom) {
        this.chatterFrom = chatterFrom;
    }

    public String getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(String chatRoom) {
        this.chatRoom = chatRoom;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        return getChatRoom() != null ? getChatRoom().equals(message.getChatRoom()) : message.getChatRoom() == null;

    }

    @Override
    public int hashCode() {
        return getChatRoom() != null ? getChatRoom().hashCode() : 0;
    }

    @Override
    public int compareTo(Message o) {
        return new Integer(this.id).compareTo(new Integer(o.id));
    }
}
