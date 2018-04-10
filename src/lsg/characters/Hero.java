package lsg.characters;

import lsg.armor.ArmorItem;
import lsg.buffs.BuffItem;
import lsg.buffs.rings.Ring;

public class Hero  extends Character{

    final private static int MAX_ARMOR_PIECES = 3;
    final private static int MAX_BUFF_PIECES = 2;
    private ArmorItem[] armorItems = new ArmorItem[MAX_ARMOR_PIECES];

    /**
     * Constructeur qui instancie un hero avec les charactéristique par défaut
     * @param name le nom du monstre
     */
    public Hero(String name) {
        this.name = name;
        this.life = 100;
        this.maxLife = 100;
        this.stamina = 50;
        this.maxStamina = 50;
        this.buffItems = new BuffItem[MAX_BUFF_PIECES];
    }

    /**
     * Constructeur qui instancie un hero
     * nommé Ynovator
     */
    public Hero() {
        this("Ynovator");
    }

    public void setArmorItem(ArmorItem armorPiece, int slot) {
        if (slot >= 1 && slot <= MAX_ARMOR_PIECES){
            this.armorItems[slot-1] = armorPiece;
        }
    }

    public float getTotalArmor(){
        float totalArmor = 0;
        for (ArmorItem armorItem: this.armorItems){
            if (armorItem != null){
                totalArmor += armorItem.getArmorValue();
            }
        }
        return totalArmor;
    }

    public String armorToString(){
        String armorSummary = String.format("%-10s", "ARMOR");
        for (int i = 0; i < this.armorItems.length; i++){
            ArmorItem armorItem = this.armorItems[i];
            if (armorItem != null){
                armorSummary += String.format("%s:%-30s",i+1 , armorItem);
            } else {
                armorSummary += String.format("%s:%-30s", i+1, "EMPTY");
            }
        }
        armorSummary += String.format("%s:%-15s","TOTAL", this.getTotalArmor());
        return armorSummary;
    }

    public float computeProtection(){
        return this.getTotalArmor();
    }

    public void setBuffItems(BuffItem buffItem, int slot){
        if (buffItem instanceof Ring){
            setRing((Ring)buffItem, slot);
        }
    }

    private void setRing(Ring ring, int slot) {
        if (slot >= 1 && slot <= MAX_BUFF_PIECES){
            ring.setHero(this);
            this.buffItems[slot -1] = ring;
        }
    }

    public ArmorItem[] getArmorItems(){
        return this.armorItems;
    }

    public BuffItem[] getBuffItems() {
        return buffItems;
    }

}
