package lsg.characters;

import lsg.weapons.Weapon;

public class Zombie extends Monster {
    public Zombie() {
        super("Zombie", 10, 10, 10, 10 );
        setWeapon(new Weapon("Zombie's hand", 5, 20, 1, 1000));
    }
}
