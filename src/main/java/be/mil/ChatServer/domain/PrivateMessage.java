package be.mil.ChatServer.domain;

/**
 * Created by benoit on 30/11/2016.
 */
public class PrivateMessage extends Message {

    private Chatter chatter1;
    private Chatter chatter2;

    public PrivateMessage(Chatter chatter1, Chatter chatter2, String body) {
        super(body, chatter1);
        this.chatter2 = chatter2;
        this.setBody(body);
    }

    public void setChatters(Chatter chatter1, Chatter chatter2) {
        this.chatter1 = chatter1;
        this.chatter2 = chatter2;
    }
}
