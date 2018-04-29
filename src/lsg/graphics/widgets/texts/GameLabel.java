package lsg.graphics.widgets.texts;

import javafx.scene.Node;
import lsg.graphics.CSSFactory;

public class GameLabel extends javafx.scene.control.Label {

    public GameLabel(){
        initStyle();
    }
    public GameLabel(String text){
        super(text);
        initStyle();
    }
    public GameLabel(String text, Node graphic){
        super(text, graphic);
        initStyle();
    }

    private void initStyle(){
        this.getStylesheets().add(CSSFactory.getStyleSheet("LSGFont.css"));
        this.getStyleClass().addAll("game-font", "game-font-fx");
    }

}
