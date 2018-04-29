package lsg;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lsg.graphics.CSSFactory;
import lsg.graphics.widgets.texts.GameLabel;

public class LearningSoulsGameApplication extends javafx.application.Application {

    private Scene scene;
    private AnchorPane root;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Learning Souls Game");
        root = new AnchorPane();
        scene = new Scene(root, 1200, 800);
        stage.setScene(scene);
        stage.setResizable(false);
        root.getChildren().addAll(new GameLabel("Test d'utilisation de Label"));

        builUI();

        stage.show();

    }

    private void builUI() {
        scene.getStylesheets().add(CSSFactory.getStyleSheet("LSG.css"));
    }
}
