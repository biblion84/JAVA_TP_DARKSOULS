package lsg;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lsg.graphics.CSSFactory;
import lsg.graphics.panes.CreationPane;
import lsg.graphics.panes.TitlePane;
import lsg.graphics.widgets.texts.GameLabel;

public class LearningSoulsGameApplication extends javafx.application.Application {

    private Scene scene;
    private AnchorPane root;
    private Stage stage;
    private TitlePane gameTitle;
    private CreationPane creationPane;
    private String heroName;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Learning Souls Game");
        root = new AnchorPane();
        scene = new Scene(root, 1200, 800);
        stage.setScene(scene);
        stage.setResizable(false);

        builUI();
        addListeners();
        stage.show();
        startGame();
    }

    private void builUI() {
        scene.getStylesheets().add(CSSFactory.getStyleSheet("LSG.css"));
        gameTitle = new TitlePane(scene, "Learning Souls Game");
        AnchorPane.setLeftAnchor(gameTitle, 0.0);
        AnchorPane.setRightAnchor(gameTitle, 0.0);
        root.getChildren().add(gameTitle);

        creationPane = new CreationPane();
        AnchorPane.setRightAnchor(creationPane, 0.0);
        AnchorPane.setLeftAnchor(creationPane, 0.0);
        AnchorPane.setTopAnchor(creationPane, 0.0);
        AnchorPane.setBottomAnchor(creationPane, 0.0);
        creationPane.setAlignment(Pos.CENTER);
        creationPane.setOpacity(0);
        root.getChildren().add(creationPane);


    }

    private void startGame(){
        gameTitle.ZoomIn(event -> {
            creationPane.FadeIn(callbackHell -> {
                System.out.println("Fade terminé !");
            });
        });


        System.out.println("Animation lancée !");
    }

    private void addListeners() {
        creationPane.getNameField().setOnAction(event -> {
            if (!creationPane.getNameField().getText().equals("")){
                heroName = creationPane.getNameField().getText();
                System.out.println("Nom du héro " + heroName);
                root.getChildren().remove(creationPane);
                gameTitle.ZoomOut(zoomedOut -> {
                });
            }
        });
    }
}
