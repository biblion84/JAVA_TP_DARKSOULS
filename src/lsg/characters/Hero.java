package characters;

import lsg.armor.ArmorItem;

import java.util.ArrayList;

public class Hero  extends Character{

    final private static int MAX_ARMOR_PIECES = 3;
    private ArmorItem[] armor = new ArmorItem[3];

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
            this.armor[slot-1] = armorPiece;
        }
    }

    public float getTotalArmor(){
        float totalArmor = 0;
        for (ArmorItem armorItem: this.armor){
            if (armorItem != null){
                totalArmor += armorItem.getArmorValue();
            }
        }
        return totalArmor;
    }

    public String armorToString(){
        String armorSummary = String.format("%-10s", "ARMOR");
        for (int i = 0; i < this.armor.length; i++){
            ArmorItem armorItem = this.armor[i];
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

}
