package be.mil.ChatServer.netty.server;

/**
 * Created by benoit on 6/12/2016.
 */
public enum TypeMessage {
    SUBSCRIBE(1),
    UNSUBSCRIBE(2),
    GETROOMS(3),
    CREATECHATROOM(4),
    MESSAGE(4),
    ONLINECHATTERS(5);

    TypeMessage(int i) {
        type=i;
    }

    private int type;
}
