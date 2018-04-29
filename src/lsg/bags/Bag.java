package lsg.bags;

import lsg.exceptions.BagFullException;

import java.util.HashSet;

public class Bag {
    private int capacity;
    private int weight;
    private HashSet<Collectible> items;

    public static void transfer(Bag from, Bag into) throws BagFullException {
        if (from == null || into == null){
            return;
        }

        for (Collectible collectible: from.getItems()){
            if (into.push(collectible)){
                from.pop(collectible);
            }
        }
    }

    public Bag(int capacity){
        this.capacity = capacity;
        this.items = new HashSet<Collectible>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWeight() {
        int weight = 0;
        for (Collectible collectible: this.items){
            if (collectible != null){
                weight += collectible.getWeight();
            }
        }
        return weight;
    }

    public boolean push(Collectible collectible) throws BagFullException {
        if (collectible.getWeight() < getCapacity() - getWeight()){
            this.items.add(collectible);
            return true;
        }
        throw new BagFullException(this);
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

    @Override
    public String toString(){
        String retour = String.format("Bag [ %d items | %d/%d kg ]\n", items.size(), getWeight(), getCapacity());
        for (Collectible collectible: this.items){
            if (collectible != null){
                retour += String.format("- %s [%d kg]\n", collectible, collectible.getWeight());
            }
        }
        if (items.size() == 0){
            retour += "\nempty";
        }
        return  retour;
    }
}
