package lsg;

import characters.Hero;
import characters.Monster;
import lsg.weapons.ShotGun;

public class LearningSoulsGame {

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
//        for (int i = 0; i < 10; i++){
//            new Monster().printStats();
//        }
    }
}
