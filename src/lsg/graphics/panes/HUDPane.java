package lsg.graphics.panes;

import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import lsg.graphics.widgets.characters.statbars.StatBar;

public class HUDPane extends BorderPane {

    private MessagePane messagePane;
    private StatBar heroStatBar;
    private StatBar monsterStatBar;

    public HUDPane(){
        buildCenter();
    }

    public MessagePane getMessagePane() {
        return messagePane;
    }

    private void buildCenter(){
        messagePane = new MessagePane();
        setCenter(messagePane);
    }

    public void buildTop(lsg.characters.Character hero, lsg.characters.Character zombie){
        BorderPane topPane = new BorderPane();
        setTop(topPane);

        heroStatBar = new StatBar(hero);
        topPane.setLeft(heroStatBar);

        monsterStatBar = new StatBar(zombie);
        topPane.setRight(monsterStatBar);
    }
}
