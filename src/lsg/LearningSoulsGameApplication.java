package lsg;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lsg.graphics.CSSFactory;
import lsg.graphics.panes.TitlePane;
import lsg.graphics.widgets.texts.GameLabel;

public class LearningSoulsGameApplication extends javafx.application.Application {

    private Scene scene;
    private AnchorPane root;
    private Stage stage;
    private TitlePane gameTitle;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Learning Souls Game");
        root = new AnchorPane();
        scene = new Scene(root, 1200, 800);
        stage.setScene(scene);
        stage.setResizable(false);

        builUI();

        stage.show();

        startGame();
    }

    private void builUI() {
        scene.getStylesheets().add(CSSFactory.getStyleSheet("LSG.css"));
        gameTitle = new TitlePane(scene, "Learning Souls Game");
        AnchorPane.setLeftAnchor(gameTitle, 0.0);
        AnchorPane.setRightAnchor(gameTitle, 0.0);
        root.getChildren().add(gameTitle);

    }

    private void startGame(){
        gameTitle.ZoomIn(event -> {
                System.out.println("Zoom terminé !");
        });
        System.out.println("Animation lancée !");
    }
}
