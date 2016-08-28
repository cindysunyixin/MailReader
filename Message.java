import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;
/**
* This class represents a Message object.
* @author Yixin Sun
* @version 1.0
*/
public class Message {
    private Person sender;
    private Set<Person> recipients = new HashSet<>();
    private String subject;
    private LocalDateTime time;
    private String body;
/**
This constructs message
@param sender sender
@param recipients recipients
@param subject subject
@param time time
@param body body
*/
    public Message(Person sender, Set<Person> recipients,
        String subject, LocalDateTime time, String body) {
        this.sender = sender;
        this.recipients = recipients;
        this.subject = subject;
        this.time = time;
        this.body = body;
    }
    @Override
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Message)) {
            return false;
        }
        Message that = (Message) other;
        return this.sender.equals(that.sender)
            && this.recipients.equals(that.recipients)
            && this.subject.equals(that.subject)
            && this.time.equals(that.time)
            && this.body.equals(that.body);
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + sender.hashCode();
        result = result * 31 + recipients.hashCode();
        result = result * 31 + subject.hashCode();
        result = result * 31 + time.hashCode();
        result = result * 31 + body.hashCode();
        return result;

    }
/**This method returns time
@return that.time
@param that thattime
*/
    public int compareTo(Message that) {
        return (this.time).compareTo(that.time);
    }
/**
This method returns sender
@return sender
*/
    public Person getSender() {
        return sender;
    }
/**
This method returns recipients
@return recipients
*/
    public Set<Person> getRecipients() {
        return recipients;
    }
/**
this method returns subject
@return subject
*/
    public String getSubject() {
        return subject;
    }
/**
This method returns time
@return time
*/
    public LocalDateTime getTime() {
        return time;
    }
/**
This method returns body
@return body
*/
    public String getBody() {
        return body;
    }
    @Override
    public String toString() {
        return subject;
    }
}
