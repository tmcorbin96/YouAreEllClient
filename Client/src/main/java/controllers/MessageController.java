package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

public class MessageController {

    private HashSet<Message> messagesSeen;
    // why a HashSet??
    private  String messageUrl="http://zipcode.rocks:8085/messages";
    private ObjectMapper objectMapper = new ObjectMapper();
    private URL myUrl= null;
    public ArrayList<Message> getMessages() {
        try {
            myUrl = new URL(messageUrl);
            return objectMapper.readValue(myUrl, new TypeReference<ArrayList<Message>>(){});
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Message> getMessagesForId(Id Id) {
        try {
            URL myUrl=new URL("http://zipcode.rocks:8085/ids/"+ Id.getGithub() +"/messages");
            return objectMapper.readValue(myUrl, new TypeReference<ArrayList<Message>>(){});
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Message getMessageForSequence(String seq) {
        return null;
    }
    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        return null;
    }

    public Message postMessage(Id myId, Id toId, Message msg) {
        return null;
    }

}