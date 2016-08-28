import java.util.Set;
import java.util.HashSet;
/**
* This class creates a Mailbox object.
* @author Yixin Sun
* @version 1.0
*/
public class Mailbox {
    private String name;
    private Set<Message> messages = new HashSet<>();
/**
Constructor for Mailbox
@param name name
@param messages messages
*/
    public Mailbox(String name, Set<Message> messages) {
        this.name = name;
        this.messages = messages;
    }
/**
@return name
*/
    public String getName() {
        return name;
    }
/**
@return messages
*/
    public Set<Message> getMessages() {
        return messages;
    }
/**
@param a message
*/
    public void add(Message a) {
        messages.add(a);
    }
/**
@param b message
*/
    public void remove(Message b) {
        messages.remove(b);
    }
/**
This method refresh
*/
    public void refresh() {
        Server a = new Server();
        messages = a.getMessages();
    }
    @Override
    public String toString() {
        return name;
    }
}
