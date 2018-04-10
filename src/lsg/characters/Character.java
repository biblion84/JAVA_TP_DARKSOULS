package lsg.characters;

import lsg.bags.Bag;
import lsg.bags.SmallBag;
import lsg.buffs.BuffItem;
import lsg.consumables.Consumable;
import lsg.consumables.drinks.Drink;
import lsg.consumables.food.Food;
import lsg.consumables.repair.RepairKit;
import lsg.helpers.Dice;
import lsg.weapons.Weapon;

public abstract class Character {
    protected String name;
    protected int life;
    protected int maxLife;
    protected int stamina;
    protected int maxStamina;
    protected Dice attackDice = new Dice(101);
    protected Weapon weapon;
    protected BuffItem[] buffItems;
    protected Consumable Consumable;
    private Bag bag;

    public Character() {
        this.bag = new SmallBag();
    }

    /**
     * Affiche les stats du character
     * @return
     */
    public String printStats() {
        System.out.println(this.toString());
        return this.toString();
    }

    /**
     * Renvois les dégats effectué lors de l'attaque
     * @return
     */
    public int attack() {
        int damageBeforBuff = this.attackWith(this.weapon);
        return (int)(damageBeforBuff + (this.computeBuff() * damageBeforBuff));
    }

    protected float computeBuff(){
        float buff = 0f;
        for (int i =0; i < this.buffItems.length; i++){
            if (this.buffItems[i] != null){
                buff += this.buffItems[i].computeBuffValue();
            }
        }
        return buff;
    }

    /**
     * Retourne les stats formatés du character
     * @return
     */
    public String toString() {
        String isAlive = this.isAlive() ? "ALIVE" : "DEAD";
        String[] stats = {this.getClass().getSimpleName(), this.name, "LIFE: " + this.life, "STAMINA: "+this.stamina, isAlive};
        return String.format(
                "%-20s %-20s %-20s %-20s %-20s %-20s",
                "[" + this.getClass().getSimpleName() +"]",
                this.name,
                "LIFE: " + this.life,
                "STAMINA: "+this.stamina,
                "PROTECTION:" + this.computeProtection(),
                isAlive);
    }

    /**
     * @param weapon
     * @return les dégats calculé celon les formules, précision et stamina du character prisent en compte
     */
    public int attackWith(Weapon weapon){

        int damage = computeWeaponDamage(weapon);
        damage = computeDamageWithBuff(damage);

        weapon.use();
        this.setStamina(stamina - weapon.getStamCost());

        return damage;
    }

    /**
     * @param damage
     * @return Les damages avec le buff de dégat ajouté par les buffItems du character
     */
    private int computeDamageWithBuff(int damage){
        int buffPercentage = 0;
        for (BuffItem buffItem: this.buffItems){
            if (buffItem != null){
                buffPercentage += buffItem.computeBuffValue();
            }
        }

        damage = damage + (int)Math.ceil(damage * buffPercentage / 100f);

        return damage;
    }

    /**
     * @param weapon
     * @return Les dégats donnés par l'arme en fonction de son état et de l'état du character
     */
    private int computeWeaponDamage(Weapon weapon){
        if (weapon.isBroken()) return 0;

        int damage = weapon.getMinDamage();
        int normalizedWeaponDamage = weapon.getMaxDamage() - weapon.getMinDamage();
        int precision = Math.round ((this.attackDice.roll() * 100)/ this.attackDice.getFaces()) * normalizedWeaponDamage / 100;
        damage += precision;

        if (damage > weapon.getMaxDamage()){
            damage = weapon.getMaxDamage();
        }

        if (this.stamina < weapon.getStamCost()){
            float modifier = this.stamina/weapon.getStamCost();
            damage = Math.round(damage * modifier);
        }
        return damage;
    }

    /**
     * Retourne si le character est vivant
     * @return
     */
    public boolean isAlive() {
        return this.life > 0;
    }

    private int computeDamageTaken(int damageDealed){
        int damageTaken = damageDealed;
        if (this.computeProtection() > 100){
            damageTaken = 0;
        } else {
            damageTaken = Math.round( damageTaken - (damageTaken *  (this.computeProtection() /100)));
        }
        return damageTaken;
    }

    /**
     * Reçoit un certain nombre de dommages
     * @param damageDealed
     * @return
     */
    public int getHitWith(int damageDealed) {
        damageDealed = computeDamageTaken(damageDealed);
        int newLife = this.life - damageDealed;
        int realDamage = newLife < 1 ? this.life : damageDealed;
        this.setLife(newLife);
        return realDamage;
    }

    /**
     * Méthode proxy de getHitWith permettant de récupérer les 2 opposants afin de les prints de manière formatée
     * @param opponent
     * @return
     */
    public int getHitWith(Character opponent) {
        int damages = opponent.attack();
        int realDamages = this.getHitWith(damages);
        System.out.println("!!! "+opponent.name+" attacks "+this.name+" with " +
                opponent.weapon.getName()+ " ("+ damages +") !!! -> Effective DMG: "+realDamages+ " PV");
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
        } else if (life > this.getMaxLife()){
            this.life = this.getMaxLife();
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
        } else if (stamina > this.getMaxStamina()){
            this.stamina = this.getMaxStamina();
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

    public abstract float computeProtection();

    public abstract void setBuffItems(BuffItem buffItem, int slot);

    public BuffItem[] getBuffItems(){
        return this.buffItems;
    };

    private void drink(Drink drink){
        System.out.println(String.format("%s drinks %s", this.getName(), drink));
        int drinkStamina = drink.use();
        this.setStamina(this.getStamina() + drinkStamina);
        System.out.println(this);
        System.out.println(String.format("Après utilisation : %s", drink));
    }

    private void eat(Food food){
        System.out.println(String.format("%s eats %s", this.getName(), food));
        int foodLife =  food.use();
        this.setLife(this.getLife() + foodLife);
        System.out.println(this);
        System.out.println(String.format("Après utilisation : %s", food));
    }

    public void use(Consumable consumable){
        if(consumable instanceof Drink){
            this.drink((Drink)consumable);
        } else if (consumable instanceof Food){
            this.eat((Food)consumable);
        } else if (consumable instanceof RepairKit){
            this.repairWeaponWith((RepairKit) consumable);
        }
    }

    private void repairWeaponWith(RepairKit kit){
        System.out.println(String.format("%s repairs %s with %s", this.name, this.weapon, kit));
        this.weapon.repairWith(kit);
        System.out.println(this);
        System.out.println(String.format("Après utilisation : %s %s", this.name, kit));
    }

    public Consumable getConsumable() {
        return Consumable;
    }

    public void setConsumable(Consumable consumable) {
        Consumable = consumable;
    }

    public void consume(){
        this.use(getConsumable());
    }
}
