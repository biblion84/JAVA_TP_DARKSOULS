package lsg.exceptions;

import lsg.bags.Bag;

public class BagFullException extends Exception{

    private Bag bag;

    public BagFullException(Bag bag){
        super(String.format("%s is full", bag.getClass().getName()));
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }
}
