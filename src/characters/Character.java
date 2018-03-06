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

    public int attack() {
        return this.attackWith(this.weapon);
    }

    public String toString() {
        String isAlive = this.isAlive() ? "ALIVE" : "DEAD";
        String[] stats = {this.getClass().getSimpleName(), this.name, "LIFE: " + this.life, "STAMINA: "+this.stamina, isAlive};
        return String.format("%-20s %-20s %-20s %-20s %-20s", "[" + this.getClass().getSimpleName() +"]", this.name, "LIFE: " + this.life, "STAMINA: "+this.stamina, isAlive);
    }

    public int attackWith(Weapon weapon){
        if (weapon.isBroken()) return 0;

        int damage = weapon.getMinDamage();
        int precision = Math.round ((this.attackDice.roll() / this.attackDice.getFaces()) * 100);
        damage += precision;

        if (damage > weapon.getMaxDamage()){
            damage = weapon.getMaxDamage();
        }

        if (this.stamina < weapon.getStamCost()){
            float modifier = this.stamina/weapon.getStamCost();
            damage = Math.round(damage * modifier);
        }

        weapon.use();
        this.setStamina(stamina - weapon.getStamCost());
        return damage;
    }


    public boolean isAlive() {
        return this.life > 0;
    }

    public int getHitWith(int value) {
        int newLife = this.life - value;
        int realDamage = newLife < 1 ? this.life : value;
        this.setLife(newLife);
        return realDamage;
    }

    public int getHitWith(Character opponent) {
        int damages = opponent.attack();
        int realDamages = this.getHitWith(damages);
        System.out.println("!!! "+this.name+" attacks "+opponent.name+" with " +
                this.weapon.getName()+ " ("+ damages +") !!! -> Effective DMG: "+realDamages+ " PV");
        return realDamages;
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
        if (life < 0){
            this.life = 0;
        } else {
            this.life = life;
        }
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
        if (stamina < 0){
            this.stamina = 0;
        } else {
            this.stamina = stamina;
        }
    }

    public int getMaxStamina() {
        return this.maxStamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
