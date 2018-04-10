package lsg;

import lsg.buffs.rings.RingOfSwords;
import lsg.characters.Character;
import lsg.characters.Hero;
import lsg.characters.Lycanthrope;
import lsg.characters.Monster;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.armor.RingedKnightArmor;
import lsg.consumables.MenuBestOfV1;
import lsg.consumables.MenuBestOfV2;
import lsg.consumables.MenuBestOfV3;
import lsg.consumables.food.Food;
import lsg.consumables.food.Hamburger;
import lsg.consumables.repair.RepairKit;
import lsg.weapons.Claw;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;

import java.util.Scanner;

public class LearningSoulsGame {

    private Hero hero;
    private Monster monster;
    private Scanner scanner = new Scanner(System.in);
    private static RepairKit kit = new RepairKit();

    private void refresh(){
        System.out.println(hero);
        System.out.println(monster);
        this.hero.use(LearningSoulsGame.kit);
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

    private void createExhautedHero(){
        this.hero = new Hero();
        this.hero.getHitWith(99);
        this.hero.setWeapon(new Weapon("Grosse Arme", 0,0,1000,100));
        this.hero.attack();
        System.out.println(hero);
    }

    private void aTable(){

    }

    public static void main(String[] args) {

        LearningSoulsGame game = new LearningSoulsGame();
        game.menuBestOfV3();
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
