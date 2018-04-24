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
        System.out.println(BULLET_POINT + "WEAPON : " + hero.getWeapon());
        hero.printConsumable();
        hero.printRings();
        System.out.println(BULLET_POINT + monster);
        System.out.println(BULLET_POINT + "WEAPON : " + monster.getWeapon());
    }

    private void executeAction(int actionType){
        switch (actionType){
            case 0:
                this.monster.getHitWith(this.hero);
                break;
            case 1:
                this.hero.consume();
                break;
            case 2:
                this.hero.fastDrink();
                break;
            case 3:
                this.hero.fastEat();
                break;
            case 4:
                this.hero.fastRepair();
                break;
        }
    }


    private void fight1v1(){
        Character winner = null;
        int action;
        do {
            this.refresh();

            do {
                System.out.println(String.format("  Entrez 1 pour attaquer; 0 pour consommer votre %s, 2 pour boire, 3 pour manger et 4 pour réparer rapidement", this.hero.getConsumable().getName() ));
                action = this.scanner.nextInt();
            } while (action > 4 || action < 0);

            this.executeAction(action);

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

        this.fight1v1();
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
        game.init();
    }
}
