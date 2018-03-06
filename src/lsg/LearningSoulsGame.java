package lsg;

import characters.Hero;
import characters.Monster;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;

public class LearningSoulsGame {

    public static void main(String[] args) {

        // TODO créer le hero
        Hero hero = new Hero("hero1");
        Monster monster = new Monster("monster1");
        Weapon sword = new Sword();
        hero.setWeapon(sword);
        monster.setWeapon(sword);
        System.out.println(hero);
        System.out.println(monster);
        hero.attack();
        System.out.println(hero);
        monster.attack();
        System.out.println(monster);
        System.out.println(sword.getDurability());
    }

}
