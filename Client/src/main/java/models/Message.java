package models;

/* 
 * POJO for an Message object
 *
 *   {
    "sequence": "-",
    "timestamp": "_",
    "fromid": "xt0fer",
    "toid": "kristofer",
    "message": "Hello, Kristofer!"
  },
*
 */
public class Message implements Comparable {

    private String message = "";
    private String toid = "";
    private String fromid = "";
    private String timestamp="";
    private String sequence = "";
    public Message(){

    }
    public Message (String message, String fromid, String toid) {
        this.sequence="-";
        this.message = message;
        this.fromid = fromid;
        this.toid = toid;
        this.timestamp="-";
    }

    public Message (String message, String fromid) {
        this.message = message;
        this.fromid = fromid;
        this.toid = "";
        this.sequence="-";
        this.timestamp="-";
    }

    @Override
    public String toString() {
        return "\nsequence: " + this.getSequence() + "\ntimestamp: " + this.getTimestamp() +
                "\nto: " + this.toid + "\nfrom: "+ this.fromid + "\n" + this.message + "\n----\n";
        //return "to: " + this.toid + "\nfrom: "+ this.fromid + "\n" + this.message + "\n----\n";
    }

    public int compareTo(Object o) {
        return this.sequence.compareTo(((Message) o).getSequence());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toId) {
        this.toid = toId;
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSequence() {
        return sequence;
    }
    public void setSequence(String sequence){this.sequence=sequence;}
}