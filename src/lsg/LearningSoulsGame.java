package lsg;

import characters.Hero;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;

public class LearningSoulsGame {

    public static void main(String[] args) {

        // TODO créer le hero
        Hero hero = new Hero();
        System.out.println(hero);
        Weapon sword = new Sword();
        for (int i = 0; i < 10; i++){
            System.out.println(hero.attackWith(sword));
        }
//        hero.printStats();
//        //hero.printStat
//        for (int i = 0; i < 10; i++){
//            new Monster().printStats();
//        }
    }
}
