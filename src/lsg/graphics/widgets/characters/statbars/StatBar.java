package lsg.graphics.widgets.characters.statbars;

import com.sun.javaws.progress.Progress;
import javafx.scene.control.Control;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import lsg.characters.Hero;
import lsg.characters.Monster;
import lsg.characters.Zombie;
import lsg.graphics.ImageFactory;
import lsg.graphics.widgets.texts.GameLabel;

import static lsg.graphics.ImageFactory.SPRITES_ID.HERO_HEAD;

public class StatBar extends BorderPane {

    private ImageView avatar;
    private GameLabel name;
    private ProgressBar lifeBar;
    private ProgressBar stamBar;


    public StatBar(lsg.characters.Character character){
        setPrefHeight(100);
        setPrefWidth(350);

        HBox hbox = new HBox();

        avatar = new ImageView();
        if (character instanceof Hero){
            avatar.setImage(ImageFactory.getSprites(HERO_HEAD)[0]);
        } else {
            avatar.setImage(ImageFactory.getSprites(ImageFactory.SPRITES_ID.ZOMBIE_HEAD)[0]);
        }
        avatar.setPreserveRatio(true);
        avatar.setFitHeight(100);

        hbox.getChildren().add(avatar);
        VBox vBox = new VBox();
        vBox.setMaxWidth(Double.MAX_VALUE);
        vBox.setMinWidth(Control.USE_PREF_SIZE);
        hbox.getChildren().add(vBox);

        name = new GameLabel(character.getName());
        name.setStyle("-fx-font-size: 33px");
        name.setMinWidth(Control.USE_PREF_SIZE);
        vBox.getChildren().add(name);


        lifeBar = new ProgressBar();
        lifeBar.setMaxWidth(Double.MAX_VALUE);
        lifeBar.setMinWidth(Control.USE_PREF_SIZE);
        setStyle("-fx-background-color: red");
        vBox.getChildren().add(lifeBar);
        HBox.setHgrow(lifeBar, Priority.ALWAYS);


        stamBar = new ProgressBar();
        stamBar.setMaxWidth(Double.MAX_VALUE);
        stamBar.setMinWidth(Control.USE_PREF_SIZE);
        setStyle("-fx-accent: green");
        vBox.getChildren().add(stamBar);

        getChildren().add(hbox);

        if (character instanceof Monster){
            flip();
        }



    }

    public ImageView getAvatar() {
        return avatar;
    }

    public GameLabel getName() {
        return name;
    }

    public ProgressBar getLifeBar() {
        return lifeBar;
    }

    public ProgressBar getStamBar() {
        return stamBar;
    }

    public void flip(){
        setScaleX(-getScaleX());
        name.setScaleX(-name.getScaleX());
    }
}
