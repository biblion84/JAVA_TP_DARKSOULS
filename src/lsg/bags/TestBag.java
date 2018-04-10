package lsg.bags;

import lsg.armor.DragonSlayerLeggings;
import lsg.armor.RingedKnightArmor;
import lsg.characters.Hero;

public class TestBag {

    public static void main(String[] args) {
        Bag medium = new MediumBag();
        medium.push(new RingedKnightArmor());
        medium.push(new DragonSlayerLeggings());
        medium.push(new DragonSlayerLeggings());
        medium.push(new DragonSlayerLeggings());
        medium.push(new DragonSlayerLeggings());

        Bag  small = new SmallBag();

        Bag.transfer(medium, small);


        System.out.println(small);

        Hero h = new Hero();
        h.pickUp(new RingedKnightArmor());
        Collectible dragonSlayerLeggings = new DragonSlayerLeggings();
        h.pickUp(dragonSlayerLeggings);
        h.printBag();
        h.pullOut(dragonSlayerLeggings);
        h.printBag();
    }
}
