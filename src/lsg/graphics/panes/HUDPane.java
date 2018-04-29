package lsg.graphics.panes;

import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class HUDPane extends BorderPane {

    private MessagePane messagePane;

    public HUDPane(){
        buildCenter();
    }

    public MessagePane getMessagePane() {
        return messagePane;
    }
    public void buildCenter(){
        messagePane = new MessagePane();
        AnchorPane.setLeftAnchor(messagePane, 0.0);
        messagePane.setAlignment(Pos.CENTER);
        getChildren().add(messagePane);
    }
}
