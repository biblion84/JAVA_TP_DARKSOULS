package lsg;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lsg.characters.Hero;
import lsg.characters.Zombie;
import lsg.exceptions.StaminaEmptyException;
import lsg.exceptions.WeaponBrokenException;
import lsg.exceptions.WeaponNullException;
import lsg.graphics.CSSFactory;
import lsg.graphics.ImageFactory;
import lsg.graphics.panes.AnimationPane;
import lsg.graphics.panes.CreationPane;
import lsg.graphics.panes.HUDPane;
import lsg.graphics.panes.TitlePane;
import lsg.graphics.widgets.characters.renderers.HeroRenderer;
import lsg.graphics.widgets.characters.renderers.ZombieRenderer;
import lsg.graphics.widgets.texts.GameLabel;
import lsg.weapons.Sword;

public class LearningSoulsGameApplication extends javafx.application.Application {

    private Scene scene;
    private AnchorPane root;
    private Stage stage;
    private CreationPane creationPane;
    private AnimationPane animationPane;
    private HUDPane hudPane;

    private TitlePane gameTitle;
    private String heroName;

    private Hero hero;
    private HeroRenderer heroRenderer;
    private Zombie zombie;
    private ZombieRenderer zombieRenderer;


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

        animationPane = new AnimationPane(root);

        hudPane = new HUDPane();
        hudPane.setMinHeight(scene.getHeight());
        hudPane.setMinWidth(scene.getWidth());



    }

    private void startGame(){
        gameTitle.ZoomIn(event -> {
            creationPane.FadeIn(callbackHell -> {
                ImageFactory.preloadAll(() -> {
                    System.out.println("préchargement des images terminé !");

                });
            });
        });


        System.out.println("Animation lancée !");//
    }

    private void addListeners() {
        creationPane.getNameField().setOnAction(event -> {
            if (!creationPane.getNameField().getText().equals("")){
                heroName = creationPane.getNameField().getText();
                System.out.println("Nom du héro " + heroName);
                root.getChildren().remove(creationPane);
                gameTitle.ZoomOut(zoomedOut -> {
                    play();
                });
            }
        });
    }

    private void play() {
        root.getChildren().add(animationPane);
        root.getChildren().add(hudPane);

        createHero();
        createZombie( event -> {
            hudPane.getMessagePane().showMessage("FIGHT !");
            try {
                zombie.getHitWith((hero.attack() % 10) + 1);
            } catch (WeaponNullException | WeaponBrokenException | StaminaEmptyException e) {
                hudPane.getMessagePane().showMessage(e.getMessage());
            }

        });
    }

    private void createHero(){
        hero = new Hero(heroName);
        hero.setWeapon(new Sword());
        heroRenderer = animationPane.createHeroRenderer();
        heroRenderer.goTo(animationPane.getPrefWidth()*0.5 - heroRenderer.getFitWidth()*0.65, null);
        hudPane.buildHero(hero);
        hudPane.getHeroStatBar().getLifeBar().progressProperty().bind(hero.lifeRateProperty());
        hudPane.getHeroStatBar().getStamBar().progressProperty().bind(hero.staminaRateProperty());
    }

    private void createZombie(EventHandler<ActionEvent> finishedHandler){
        zombie = new Zombie();
        zombieRenderer = animationPane.createZombieRenderer() ;
        zombieRenderer.goTo(animationPane.getPrefWidth()*0.5 - zombieRenderer.getBoundsInLocal().getWidth() * 0.15, finishedHandler);
        hudPane.buildMonster(zombie);
        hudPane.getMonsterStatBar().getLifeBar().progressProperty().bind(zombie.lifeRateProperty());
        hudPane.getMonsterStatBar().getStamBar().progressProperty().bind(zombie.staminaRateProperty());

    }

}
