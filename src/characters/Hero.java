package characters;

import lsg.armor.ArmorItem;

import java.util.ArrayList;

public class Hero  extends Character{

    final private static int MAX_ARMOR_PIECES = 3;
    private ArrayList<ArmorItem> armor = new ArrayList<ArmorItem>(MAX_ARMOR_PIECES);

    /**
     * Constructeur qui instancie un monstre avec les charactéristique par défaut
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
     * Constructeur qui instancie un Hero avec  un nom par défaut
     */
    public Hero() {
        this("Ynovator");
    }

    public void setArmorItem(ArmorItem armorPiece, int slot) {
        if (slot >= 0 && slot < MAX_ARMOR_PIECES){
            this.armor.set(slot, armorPiece);
        }
    }

}
