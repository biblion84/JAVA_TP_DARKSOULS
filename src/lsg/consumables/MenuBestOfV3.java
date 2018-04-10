package lsg.consumables;

import lsg.consumables.drinks.Coffe;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

import java.util.HashSet;
import java.util.Locale;

public class MenuBestOfV3 extends HashSet<Consumable> {

    public MenuBestOfV3() {
        this.add(new Hamburger());
        this.add(new Wine());
        this.add(new Americain());
        this.add(new Coffe());
        this.add(new Whisky());
    }


    @Override
    public String toString() {
        String text = "MenuBestOfV3 :\n";
        int i = 1;
        for(Consumable item : this){
            text+=String.format(Locale.US, "%d : %s\n", i, item) ;
            i++;
        }
        return text;
    }
}
