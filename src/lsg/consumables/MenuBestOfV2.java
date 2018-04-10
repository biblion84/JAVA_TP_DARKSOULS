package lsg.consumables;

import lsg.consumables.drinks.Coffe;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

import java.util.Locale;
import java.util.HashSet;

public class MenuBestOfV2 {
    private HashSet<Consumable> menu = new HashSet<>();

    public MenuBestOfV2() {
        menu.add(new Hamburger());
        menu.add(new Wine());
        menu.add(new Americain());
        menu.add(new Coffe());
        menu.add(new Whisky());
    }


    @Override
    public String toString() {
        String text = "MenuBestOfV2 :\n";
        int i = 1;
        for(Consumable item : menu){
            text+=String.format(Locale.US, "%d : %s\n", i, item) ;
            i++;
        }
        return text;
    }
}
