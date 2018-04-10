package lsg.weapons;

import lsg.bags.Collectible;
import lsg.consumables.repair.RepairKit;

public class Weapon implements Collectible{
    public static final String  DURABILITY_STAT_STRING = "durability";

    private String name;
    private int minDamage;
    private int maxDamage;
    private int stamCost;
    private int durability;

    public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.stamCost = stamCost;
        this.durability = durability;
    }

    public String toString() {
        return this.name+" " +
                "(min:"+this.minDamage+
                " max:"+this.maxDamage+
                " stam:"+this.stamCost+
                " dur:"+this.durability+")";
    }

    public void use() {

        this.setDurability(this.durability - 1);
    }

    public boolean isBroken() {
        return this.durability == 0;
    }

    public String getName() {
        return name;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getStamCost() {
        return stamCost;
    }

    public int getDurability() {
        return durability;
    }

    private void setDurability(int durability) {
        if (durability < 0){
            this.durability = 0;
        } else {
            this.durability = durability;
        }
    }

    public void repairWith(RepairKit kit){
        this.setDurability(this.getDurability() + kit.use());
    }

    @Override
    public int getWeight() {
        return 2;
    }
}
