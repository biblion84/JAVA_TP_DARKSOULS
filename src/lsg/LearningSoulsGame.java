package lsg;

import characters.Character;
import characters.Hero;
import characters.Monster;
import lsg.armor.ArmorItem;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.armor.RingedKnightArmor;
import lsg.weapons.Claw;
import lsg.weapons.Sword;

import java.util.Scanner;

public class LearningSoulsGame {

    private Hero hero;
    private Monster monster;
    private Scanner scanner = new Scanner(System.in);

    private void refresh(){
        System.out.println(hero);
        System.out.println(monster);
    }


    private void fight1v1(){
        Character winner = null;
        do {
            this.refresh();
            System.out.println("Appuyez sur entrée pour lancer le tour suivant");
            this.scanner.nextLine();
            this.monster.getHitWith(hero);

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

    }

    public void play_v1(){
        this.init();
        this.fight1v1();
    }

    public void play_v2(){
        this.init();
        this.hero.setArmorItem(new BlackWitchVeil(), 1);
        this.hero.setArmorItem(new DragonSlayerLeggings(), 2);
        this.hero.setArmorItem(new RingedKnightArmor(), 3);
        this.fight1v1();
    }

    public static void main(String[] args) {

        LearningSoulsGame game = new LearningSoulsGame();
        game.play_v2();
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
