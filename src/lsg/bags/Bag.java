package lsg.bags;

import java.util.HashSet;

public class Bag {
    private int capacity;
    private int weight;
    private HashSet<Collectible> items;


    public Bag(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWeight() {
        return weight;
    }

    public void push(Collectible collectible){
        if (collectible.getWeight() < capacity - weight){
            this.items.add(collectible);
        }
    }

    public Collectible pop(Collectible collectible){
        if (this.items.contains(collectible)){
            this.items.remove(collectible);
            return  collectible;
        }
        return null;
    }

    public boolean contains(Collectible collectible){
        return this.items.contains(collectible);
    }

    public Collectible[] getItems(){
        return this.items.toArray(new Collectible[items.size()]);
    }
}
