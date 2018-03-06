package lsg;

import characters.Hero;
import characters.Monster;
import lsg.weapons.ShotGun;

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
        this.refresh();
        boolean ended = false;
        while (!ended){
            System.out.println("Appuyez sur entrée pour lancer le tour");
            this.scanner.nextLine();


        }



    }

    public static void main(String[] args) {

        // TODO créer le hero
        Hero hero = new Hero("rick");
        Monster monster = new Monster("zombie");
        hero.setWeapon(new ShotGun());
        monster.setWeapon(new ShotGun());
        System.out.println(hero);
        System.out.println(monster);
        monster.getHitWith(hero);
        System.out.println(monster);

//        hero.printStats();
//        //hero.printStat
        for (int i = 0; i < 100; i++){
        monster.getHitWith(hero);

//            new Monster().printStats();
        }
    }
}
