import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
/**
* This class represents a Server object.
* @author Yixin Sun
* @version 1.0
*/
public class Server {
    private Random random = new Random();
    private Person person1 = new Person("T-Square",
        "no-reply@t-square.gatech.edu");
    private Person person2 = new Person("Sephora Beauty Insider",
        "sephora@sephora.com");
    private Person person3 = new Person("KateSpade", "katespade@katespade.com");
    private Person person4 = new Person("ASOS", "asos@asos.com");
    private Person person5 = new Person("Min Shi", "shimin@126.com");
    private Person person6 = new Person("Ran Yi", "raynayi@gatech.edu");
    private Person person7 = new Person("Maroon 5", "adamlevine@gmail.com");
    private Person person8 = new Person("James Blunt", "jamesblunt@gmail.com");
    private Person person9 = new Person("Ariana Grande", "ariana@gmail.com");
    private Person person10 = new Person("Leonardo DiCaprio",
        "leonardo@gmail.com");
    private Person person11 = new Person("Avril", "avril@gmail.com");
    private Person person12 = new Person("HM", "sales@hm.com");
    private String subject1 = "Grades Out!";
    private String subject2 = "Welcome!";
    private String subject3 = "Long time no see!";
    private String subject4 = "Your package is on the way.";
    private String subject5 = "Date?";
    private String subject6 = "MLGB";
    private String body1 = "Hi!!!";
    private String body2 = "Hey!!!";
    private String body3 = "You like that, huh?";
    private String body4 = "Pretty nice";
    private String body5 = "Miss you babe";
    private String body6 = "REALLY??";
    private ArrayList<Person> senders = new ArrayList<>(
        Arrays.asList(person1, person2, person3, person4, person5, person6));
    private ArrayList<Person> recipients = new ArrayList<>(
        Arrays.asList(person7, person8, person9, person10, person11, person12));
    private ArrayList<String> subjects = new ArrayList<>(
        Arrays.asList(subject1, subject2, subject3, subject4,
            subject5, subject6));
    private ArrayList<String> bodys = new ArrayList<>(
        Arrays.asList(body1, body2, body3, body4, body5, body6));
    /**
    * This method constructs a Server object.
    */
    public Server() { }
    /**
    * This method randomly creates messages.
    * @return random messages
    */
    public Message getMessage() {
        Set<Person> recipient = new HashSet<>();
        for (int i = random.nextInt(6); i > 1; i--) {
            Person re = recipients.get(random.nextInt(6));
            recipient.add(re);
        }
        return new Message(senders.get(random.nextInt(6)), recipient,
            subjects.get(random.nextInt(6)), LocalDateTime.now(),
            bodys.get(random.nextInt(6)));
    }
    /**
    * This method randomly creates messages.
    * @return a set of messages
    */
    public Set<Message> getMessages() {
        Set<Message> msg = new HashSet<>();
        for (int i = random.nextInt(12); i > 1; i--) {
            msg.add(getMessage());
        }
        return msg;
    }
}
