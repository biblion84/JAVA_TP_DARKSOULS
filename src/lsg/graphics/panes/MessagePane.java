package lsg.graphics.panes;

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.util.Duration;
import lsg.graphics.widgets.texts.GameLabel;
import sun.plugin.javascript.navig.Anchor;

public class MessagePane extends VBox {

    public MessagePane() {
        setAlignment(Pos.CENTER);
        AnchorPane.setTopAnchor(this, (double) 375);
        AnchorPane.setLeftAnchor(this, (double) 400);
    }

    public void showMessage(String msg){
        GameLabel label = new GameLabel(msg);
        label.setAlignment(Pos.CENTER);
        label.setMinHeight(Region.USE_PREF_SIZE);
        label.setMinWidth(Region.USE_PREF_SIZE);

        TranslateTransition tt = new TranslateTransition(Duration.millis(3000));
        tt.setToY(label.getHeight() - 200);

        getChildren().add(label);

        tt.setNode(label);
        tt.setCycleCount(1);
        tt.setOnFinished(event -> {
            getChildren().remove(label);
        });

        tt.play();


    }
}
