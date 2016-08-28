import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import java.util.Arrays;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import java.util.Collections;
import javafx.geometry.Insets;
/**
* This class creates a GUI.
* @author Yixin Sun
* @version 1.0
*/
public class Mailreader extends Application {
    private ObservableList<Mailbox> mailboxs;
    private ObservableList<Message> messages;
    private Button sortBySubjectButton = new Button("Sort by Subject");
    private Button sortBySenderButton = new Button("Sort by Sender");
    private Button sortByDateButton = new Button("Sort by Date");
    private Button refreshButton = new Button("Refresh");
    private Button trashButton = new Button("Trash");
    private Button flagButton = new Button("Flag");
    private Label labelSubject = new Label();
    private Label labelSender = new Label();
    private Label labelEmail = new Label();
    private Label labelDateTime = new Label();
    private TextArea textBody = new TextArea();
    private Message tem;
    private BorderPane border = new BorderPane();
    private Server server = new Server();
    private Mailbox inbox = new Mailbox("Inbox", server.getMessages());
    private Mailbox flag = new Mailbox("Flagged", server.getMessages());
    private Mailbox trash = new Mailbox("Trash", server.getMessages());

    /**
    * This method starts a GUI.
    * @param stage the stage
    */
    public void start(Stage stage) {
        mailboxs = FXCollections.observableArrayList(
            Arrays.asList(inbox, flag, trash));
        ListView<Mailbox> boxList = new ListView<Mailbox>(mailboxs);
        messages = FXCollections.observableArrayList();
        boxList.getSelectionModel().selectedItemProperty().addListener(
            (ObservableValue<? extends Mailbox> ov, Mailbox oldval,
                Mailbox newval) -> {
                messages.setAll(newval.getMessages());
            }
        );
        ListView<Message> messageList = new ListView<Message>(messages);
        messageList.getSelectionModel().selectedItemProperty().addListener(
            (ObservableValue<? extends Message> ov, Message oldval,
                Message newval) -> {
                labelSubject.setText(newval.getSubject());
                labelSender.setText(newval.getSender().getName());
                labelEmail.setText(newval.getSender().getEmail());
                labelDateTime.setText(newval.getTime().toString());
                textBody.setText(newval.getBody());
                tem = newval;
            }
        );
        boxList.setPrefSize(100, 500);
        messageList.setPrefSize(300, 800);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(boxList, messageList);
        border.setLeft(hbox);

        HBox toolbar = new HBox();
        toolbar.setSpacing(10);
        toolbar.getChildren().addAll(sortBySenderButton, refreshButton,
            sortByDateButton, trashButton, flagButton, sortBySubjectButton);
        toolbar.setStyle("-fx-background-color: transparent;");
        border.setTop(toolbar);



        HBox senderEmailDateTime = new HBox();
        senderEmailDateTime.getChildren().addAll(labelSender,
            labelEmail, labelDateTime);
        senderEmailDateTime.setSpacing(20);
        senderEmailDateTime.setPadding(new Insets(10, 20, 10, 0));


        VBox heading = new VBox();
        labelSubject.setFont(new Font("Arial", 25));
        heading.getChildren().addAll(labelSubject, senderEmailDateTime);
        heading.setPadding(new Insets(10, 20, 10, 20));


        VBox total = new VBox();
        total.getChildren().addAll(heading, textBody);
        border.setCenter(total);
        sortBySenderButton.setOnAction((ActionEvent e) -> {
                Collections.sort(messages, (Message a, Message b) ->
                    a.getSender().getName().compareTo(b.getSender().getName())
                );
            }
        );
        sortByDateButton.setOnAction((ActionEvent e) -> {
                Collections.sort(messages, (Message a, Message b) ->
                    a.getTime().compareTo(b.getTime())
                );
            }
        );
        sortBySubjectButton.setOnAction((ActionEvent e) -> {
                Collections.sort(messages, (Message a, Message b) ->
                    a.getSubject().compareTo(b.getSubject())
                );
            }
        );
        trashButton.setOnAction((ActionEvent e) -> {
                inbox.remove(tem);
                trash.add(tem);
                messages.setAll(inbox.getMessages());
            }
        );
        flagButton.setOnAction((ActionEvent e) -> {
                inbox.remove(tem);
                flag.add(tem);
                messages.setAll(inbox.getMessages());
            }
        );
        refreshButton.setOnAction((ActionEvent e) -> {
                inbox.refresh();
                messages.setAll(inbox.getMessages());
            }
        );
        Scene scene = new Scene(border, 1000, 600);
        stage.setScene(scene);
        stage.setTitle("Cindy's MailBox");
        stage.show();
    }
}
