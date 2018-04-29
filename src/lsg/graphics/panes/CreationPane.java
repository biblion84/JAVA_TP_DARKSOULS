package lsg.graphics.panes;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lsg.graphics.widgets.texts.GameLabel;

public class CreationPane extends VBox {

    private static final Duration ANIMATION_DURATION = Duration.millis(1500);


    private TextField nameField;

    public TextField getNameField() {
        return nameField;
    }

    public CreationPane(){
        GameLabel label = new GameLabel("Player Name");
        getChildren().add(label);
        nameField = new TextField();
        nameField.setMaxWidth(270);
        getChildren().add(nameField);
    }

    public void FadeIn(EventHandler<ActionEvent> finishedHandler) {
        FadeTransition ft = new FadeTransition(ANIMATION_DURATION);
        ft.setFromValue(0);
        ft.setToValue(100);

        ParallelTransition pt = new ParallelTransition(ft);
        pt.setNode(this);
        pt.setCycleCount(1);
        pt.setOnFinished(event -> {
            finishedHandler.handle(event);
        });
        pt.play();
    }
}
