package lsg.armor;

import lsg.bags.Collectible;

public class ArmorItem implements Collectible{
    private String name;
    private float armorValue;

    public ArmorItem(String name, float armorValue) {
        this.name = name;
        this.armorValue = armorValue;
    }

    public String toString() {
        return this.name+"("+this.armorValue+")";
    }

    public String getName() {
        return name;
    }

    public float getArmorValue() {
        return armorValue;
    }

    @Override
    public int getWeight() {
        return 4;
    }
}
