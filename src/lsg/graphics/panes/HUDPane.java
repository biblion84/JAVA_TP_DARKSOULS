package lsg.graphics.panes;

import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import lsg.graphics.widgets.characters.statbars.StatBar;

public class HUDPane extends BorderPane {

    private MessagePane messagePane;
    private StatBar heroStatBar;
    private StatBar monsterStatBar;

    private BorderPane topPane;

    public HUDPane(){
        buildCenter();
        buildTop();
    }

    public MessagePane getMessagePane() {
        return messagePane;
    }

    private void buildCenter(){
        messagePane = new MessagePane();
        setCenter(messagePane);
    }

    private void buildTop(){
        topPane = new BorderPane();
        setTop(topPane);
    }

    public void buildHero(lsg.characters.Character hero){
        heroStatBar = new StatBar(hero);
        topPane.setLeft(heroStatBar);
    }

    public void buildMonster(lsg.characters.Character monster){
        monsterStatBar = new StatBar(monster);
        topPane.setRight(monsterStatBar);
    }



    public StatBar getHeroStatBar() {
        return heroStatBar;
    }

    public StatBar getMonsterStatBar() {
        return monsterStatBar;
    }
}
