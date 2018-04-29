package lsg.characters;

import lsg.armor.ArmorItem;
import lsg.buffs.BuffItem;
import lsg.buffs.talismans.Talisman;

public class Monster extends Character {
    private static int INSTANCE_COUNT = 0;
    final private static int MAX_BUFF_PIECES = 1;
    protected float skinThickness;

    /**
     * Constructeur qui instancie un monstre avec les charactéristique par défaut
     * @param name le nom du monstre
     */
    public Monster(String name){
        this(name, 100, 100, 10, 10);
        this.skinThickness = 20;
        this.buffItems = new BuffItem[MAX_BUFF_PIECES];
    }

    public Monster(String name,
                   int life,
                   int maxLife,
                   int stamina,
                   int maxStamina){
        super(name, life, maxLife, stamina, maxStamina);
    }


    /**
     * Constructeur par défaut retournant un monstre
     * nommé Monster_N + le numéro d'instanciation du monstre
     */
    public Monster(){
        this("Monster_" + Monster.INSTANCE_COUNT);
        Monster.INSTANCE_COUNT++;
    }

    public float getSkinThickness() {
        return skinThickness;
    }

    protected void setSkinThickness(float skinThickness) {
        this.skinThickness = skinThickness;
    }

    public float computeProtection(){
        return this.getSkinThickness();
    }

    public void setBuffItems(BuffItem buffItem, int slot){
        if (buffItem instanceof Talisman){
            setTalisman((Talisman)buffItem, slot);
        }
    }

    public void setTalisman(Talisman talisman, int slot){
        if (slot >= 1 && slot <= MAX_BUFF_PIECES){
            this.buffItems[slot -1] = talisman;
        }
    }

    public BuffItem[] getBuffItems() {
        return buffItems;
    }
}
