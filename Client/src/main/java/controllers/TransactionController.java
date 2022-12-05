package controllers;

import models.Id;
import models.Message;

import java.util.List;

public class TransactionController {
    private String rootURL = "http://zipcode.rocks:8085";
    private MessageController msgCtrl;
    private IdController idCtrl;

    public TransactionController(MessageController m, IdController j) {
        this.msgCtrl=m;
        this.idCtrl=j;
    }

    public List<Id> getIds() {
        return idCtrl.getIds();
    }
    public List<Message> getMessages() {
        return msgCtrl.getMessages();
    }
    public String postId(String idtoRegister, String githubName) {
        Id tid = new Id(idtoRegister, githubName);
        tid = idCtrl.postId(tid);
        return ("User Registered "+tid.toString());
    }
    public List<Message> getMessagesToId(String gitHubId) {
        return msgCtrl.getMessagesForId(new Id("", gitHubId));
    }
    //public String makecall(String s, String get, String s1) {return null;}
}