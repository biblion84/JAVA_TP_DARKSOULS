package lsg;

import characters.Hero;
import characters.Monster;
import lsg.weapons.Sword;

public class LearningSoulsGame {

    public static void main(String[] args) {

        // TODO créer le hero
        Hero hero = new Hero("hero1");
        Monster monster = new Monster("monster1");
        hero.setWeapon(new Sword());
        monster.setWeapon(new Sword());
        System.out.println(hero);
        System.out.println(monster);
        hero.attack();
        System.out.println(hero);
        monster.attack();
        System.out.println(monster);

//        hero.printStats();
//        //hero.printStat
//        for (int i = 0; i < 10; i++){
//            new Monster().printStats();
//        }
    }
}
