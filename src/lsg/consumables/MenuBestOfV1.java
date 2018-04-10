package lsg.consumables;

import lsg.consumables.drinks.Coffe;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

import java.util.Locale;

public class MenuBestOfV1 {
    private Consumable[] menu = new Consumable[]{
            new Hamburger(),
            new Wine(),
            new Americain(),
            new Coffe(),
            new Whisky()
    };


    @Override
    public String toString() {
        String text = "MenuBestOfV1 :\n";
        int i = 1;
        for(Consumable item : menu){
            text+=String.format(Locale.US, "%d : %s\n", i, item) ;
            i++;
        }
        return text;
    }
}
