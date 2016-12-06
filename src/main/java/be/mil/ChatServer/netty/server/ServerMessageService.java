package be.mil.ChatServer.netty.server;

import be.mil.ChatServer.domain.Chatter;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benoit on 6/12/2016.
 */
public class ServerMessageService  {
private XStream xStream=new XStream();

    private int id;



    public String createMesagge(){
        return null;
    }


    public String Subscribbe(){
        return null;
    }

    public List<Chatter> getListChatter(String chat){
        List<Chatter> chatters=new ArrayList<Chatter>() ;
        chatters= (List<Chatter>) xStream.fromXML(chat);

        return chatters;
    }



    public String Encoded(){

        String ret="";




        return ret;

    }

}
