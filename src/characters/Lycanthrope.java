package characters;

import lsg.weapons.Claw;

public class Lycanthrope extends Monster {

    public Lycanthrope(){
        super();
        this.name = "Lycanthrope";
        this.weapon = new Claw();
        this.skinThickness = 30;
    }
}
