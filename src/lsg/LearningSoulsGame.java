package lsg;

import lsg.buffs.rings.RingOfSwords;
import lsg.characters.Character;
import lsg.characters.Hero;
import lsg.characters.Lycanthrope;
import lsg.characters.Monster;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.armor.RingedKnightArmor;
import lsg.consumables.*;
import lsg.consumables.food.Food;
import lsg.consumables.food.Hamburger;
import lsg.consumables.repair.RepairKit;
import lsg.weapons.Claw;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;

import java.util.Scanner;

public class LearningSoulsGame {

    public static final String BULLET_POINT = "\u2219";

    private Hero hero;
    private Monster monster;
    private Scanner scanner = new Scanner(System.in);

    private void refresh(){
        System.out.println(hero);
        System.out.println(BULLET_POINT + hero.getWeapon());
        System.out.println(BULLET_POINT + hero.getConsumable());
        System.out.println(BULLET_POINT + monster);
    }


    private void fight1v1(){
        Character winner = null;
        int action;
        do {
            this.refresh();

            do {
                System.out.println(String.format("  Entrez 1 pour attaquer; 0 pour consommer votre %s", this.hero.getConsumable().getName() ));
                action = this.scanner.nextInt();
            } while (action > 2 || action < 0);

            if (action == 0){
                this.monster.getHitWith(this.hero);
            } else if (action == 1) {
                this.hero.consume();
            }

            if (!this.monster.isAlive()){
                winner = this.hero;
                continue;
            }
            this.hero.getHitWith(monster);
            if (!this.hero.isAlive()){
                winner = this.monster;
            }
        } while (this.hero.isAlive() && this.monster.isAlive());
        this.refresh();
        System.out.println(winner.getName()+ " est vainqueur !!");
    }

    private void init(){
        this.monster = new Monster();
        this.hero = new Hero();

        this.hero.setWeapon(new Sword());
        this.monster.setWeapon(new Claw());

        this.hero.setConsumable(new Hamburger());

    }

    private void play_v1(){
        this.init();
        this.fight1v1();
    }

    private void play_v2(){
        this.init();
        this.hero.setArmorItem(new BlackWitchVeil(), 1);
        this.hero.setArmorItem(new DragonSlayerLeggings(), 2);
        this.hero.setArmorItem(new RingedKnightArmor(), 3);
        this.fight1v1();
    }

    private void play_v3(){
        this.init();
        this.monster = new Lycanthrope();
        this.hero.setBuffItems(new RingOfSwords(), 1);
        Food f = new Hamburger();
        this.hero.use(f);
        this.fight1v1();
    }

    private void play_v4(){
        this.init();
        createExhautedHero();
        aTable();
    }

    private void menuBestOfV1(){
        this.init();
        MenuBestOfV1 c = new MenuBestOfV1();
        System.out.println(c);
    }

    private void menuBestOfV2(){
        this.init();
        MenuBestOfV2 c = new MenuBestOfV2();
        System.out.println(c);
    }

    private void menuBestOfV3(){
        this.init();
        MenuBestOfV3 c = new MenuBestOfV3();
        System.out.println(c);
    }

    private void menuBestOfV4(){
        this.init();
        MenuBestOfV4 c = new MenuBestOfV4();
        System.out.println(c);
    }

    private void aTable(){
        MenuBestOfV4 bestOf = new MenuBestOfV4();
        for(Consumable item : bestOf){
            this.hero.use(item);
        }
        System.out.println(this.hero.getWeapon());
    }

    private void createExhautedHero(){
        this.hero.getHitWith(99);
        this.hero.setWeapon(new Weapon("Grosse Arme", 0,0,1000,100));
        this.hero.attack();
        System.out.println(hero);
    }

    public void title(){
        String title = "\n" +
                "\n" +
                " __    ____    __    ____  _  _  ____  _  _  ___    ___  _____  __  __  __       ___    __    __  __  ____ \n" +
                "(  )  ( ___)  /__\\  (  _ \\( \\( )(_  _)( \\( )/ __)  / __)(  _  )(  )(  )(  )     / __)  /__\\  (  \\/  )( ___)\n" +
                " )(__  )__)  /(__)\\  )   / )  (  _)(_  )  (( (_-.  \\__ \\ )(_)(  )(__)(  )(__   ( (_-. /(__)\\  )    (  )__) \n" +
                "(____)(____)(__)(__)(_)\\_)(_)\\_)(____)(_)\\_)\\___/  (___/(_____)(______)(____)   \\___/(__)(__)(_/\\/\\_)(____)\n" +
                "\n";
        String centaur = "         ,     .\n" +
                "        /(     )\\               A\n" +
                "   .--.( `.___.' ).--.         /_\\\n" +
                "   `._ `%_&%#%$_ ' _.'     /| <___> |\\\n" +
                "      `|(@\\*%%/@)|'       / (  |L|  ) \\\n" +
                "       |  |%%#|  |       J d8bo|=|od8b L\n" +
                "        \\ \\$#%/ /        | 8888|=|8888 |\n" +
                "        |\\|%%#|/|        J Y8P\"|=|\"Y8P F\n" +
                "        | (.\".)%|         \\ (  |L|  ) /\n" +
                "    ___.'  `-'  `.___      \\|  |L|  |/\n" +
                "  .'#*#`-       -'$#*`.       / )|\n" +
                " /#%^#%*_ *%^%_  #  %$%\\    .J (__)\n" +
                " #&  . %%%#% ###%*.   *%\\.-'&# (__)\n" +
                " %*  J %.%#_|_#$.\\J* \\ %'#%*^  (__)\n" +
                " *#% J %$%%#|#$#$ J\\%   *   .--|(_)\n" +
                " |%  J\\ `%%#|#%%' / `.   _.'   |L|\n" +
                " |#$%||` %%%$### '|   `-'      |L|\n" +
                " (#%%||` #$#$%%% '|            |L|\n" +
                " | ##||  $%%.%$%  |            |L|\n" +
                " |$%^||   $%#$%   |  VK/cf     |L|\n" +
                " |&^ ||  #%#$%#%  |            |L|\n" +
                " |#$*|| #$%$$#%%$ |\\           |L|\n" +
                " ||||||  %%(@)$#  |\\\\          |L|\n" +
                " `|||||  #$$|%#%  | L|         |L|\n" +
                "      |  #$%|$%%  | ||l        |L|\n" +
                "      |  ##$H$%%  | |\\\\        |L|\n" +
                "      |  #%%H%##  | |\\\\|       |L|\n" +
                "      |  ##% $%#  | Y|||       |L|\n" +
                "      J $$#* *%#% L  |E/\n" +
                "      (__ $F J$ __)  F/\n" +
                "      J#%$ | |%%#%L\n" +
                "      |$$%#& & %%#|\n" +
                "      J##$ J % %%$F\n" +
                "       %$# * * %#&\n" +
                "       %#$ | |%#$%\n" +
                "       *#$%| | #$*\n" +
                "      /$#' ) ( `%%\\\n" +
                "     /#$# /   \\ %$%\\\n" +
                "    ooooO'     `Ooooo";
        System.out.println(title);
        System.out.println(centaur);
    }

    public static void main(String[] args) {

        LearningSoulsGame game = new LearningSoulsGame();
        game.title();
        game.play_v1();
//        game.play_v4();
//        game.menuBestOfV3();
//        game.menuBestOfV2();
//        game.menuBestOfV1();
//        game.play_v3();
//        Hero hero = new Hero("rick");
//        ArmorItem veil = new BlackWitchVeil();
//        hero.setArmorItem(veil, 2);
//        System.out.println(hero.armorToString());

//        Monster monster = new Monster("zombie");
//        hero.setWeapon(new ShotGun());
//        monster.setWeapon(new ShotGun());
//        System.out.println(hero);
//        System.out.println(monster);
//        monster.getHitWith(hero);
//        System.out.println(monster);
//
////        hero.printStats();
////        //hero.printStat
//        for (int i = 0; i < 100; i++){
//        monster.getHitWith(hero);
//
////            new Monster().printStats();
//        }
    }
}
