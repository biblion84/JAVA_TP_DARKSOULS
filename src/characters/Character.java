package characters;

import lsg.helpers.Dice;
import lsg.weapons.Weapon;

public class Character {
    protected String name;
    protected int life;
    protected int maxLife;
    protected int stamina;
    protected int maxStamina;
    protected Dice attackDice = new Dice(101);
    protected Weapon weapon;

    public String printStats() {
        System.out.println(this.toString());
        return this.toString();
    }

    public String toString() {
        String isAlive = this.isAlive() ? "ALIVE" : "DEAD";
        String[] stats = {this.getClass().getSimpleName(), this.name, "LIFE: " + this.life, "STAMINA: "+this.stamina, isAlive};
        return String.format("%s %s %s %s %s",this.getClass().getSimpleName(), this.name, "LIFE: " + this.life, "STAMINA: "+this.stamina, isAlive);
    }

    public int attackWith(Weapon weapon){

        if (weapon.isBroken()) return 0;

        int damage = weapon.getMinDamage();
        int precision = this.attackDice.roll();
        damage += precision;

        if (damage > weapon.getMaxDamage()){
            return weapon.getMaxDamage();
        }

        return damage;
    }


    public boolean isAlive() {
        return this.life > 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return this.maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getStamina() {
        return this.stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxStamina() {
        return this.maxStamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }
}
