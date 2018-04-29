package lsg;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LearningSoulsGameApplication extends javafx.application.Application {

    private Scene scene;
    private AnchorPane root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Learning Souls Game");
        root = new AnchorPane();
        scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        builUI();
        primaryStage.show();
    }

    private void builUI() {
    }
}
