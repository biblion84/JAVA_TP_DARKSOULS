package lsg.exceptions;

import lsg.weapons.Weapon;

public class WeaponBrokenException extends Exception {

    Weapon brokenWeapon = null;

    public WeaponBrokenException(Weapon weapon){
        super(weapon.getName() + " is broken");
        this.brokenWeapon = weapon;
    }

    public Weapon getBrokenWeapon() {
        return brokenWeapon;
    }
}
