package be.mil.ChatServer;

/**
 * Created by benoit on 30/11/2016.
 */
public class PrivateMessage extends Message {

    public PrivateMessage(Chatter chatter1, Chatter chatter2,String body) {
        super(body,chatter1);
        this.chatter2 = chatter2;
        this.setBody(body);
    }

    private Chatter chatter1;
    private Chatter chatter2;



    public void setChatters(Chatter chatter1,Chatter chatter2 ){
        this.chatter1=chatter1;
        this.chatter2=chatter2;
    }
}
