package lsg.graphics.panes;

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lsg.graphics.widgets.texts.GameLabel;
import sun.plugin.javascript.navig.Anchor;

public class MessagePane extends VBox {

    public void showMessage(String msg){
        GameLabel label = new GameLabel(msg);
        AnchorPane.setLeftAnchor(label, 0.0);
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
