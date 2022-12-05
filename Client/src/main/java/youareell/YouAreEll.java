package youareell;

import controllers.*;

public class YouAreEll {

    TransactionController tt;

    public YouAreEll (TransactionController t) {
        this.tt = t;
    }

    public static void main(String[] args) {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(
                new TransactionController(
                        new MessageController(), new IdController()
                ));
        // System.out.println(urlhandler.get_messages());
        // System.out.println(urlhandler.get_ids());
        // System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        // System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

//    private String MakeURLCall(String s, String get, String s1) {
//        return null;
//    }

    public String get_ids() {return tt.getIds().toString();}//tt.makecall("/ids", "GET", "");
    public String get_messages() {return tt.getMessages().toString();}//MakeURLCall("/messages", "GET", "");

    public String addUser(String name,String github) {return tt.postId(name, github);}
    public String getMessagesById(String gitHubId) {return tt.getMessagesToId(gitHubId).toString();
    }
}