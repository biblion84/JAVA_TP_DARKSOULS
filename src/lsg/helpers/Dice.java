package lsg.helpers;

import java.util.Random;

public class Dice {
    private int faces;
    private Random random;

    public Dice(int faces) {
        this.faces = faces;
        this.random = new Random();
    }

    public int getFaces(){ return this.faces;}

    public int roll() {
        return random.nextInt((this.faces - 1) + 1);
    }

}
