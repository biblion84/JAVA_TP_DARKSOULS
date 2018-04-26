package lsg.consumables;

import lsg.bags.Collectible;
import lsg.exceptions.ConsumeEmptyException;

import java.util.Locale;

public abstract class Consumable implements Collectible {

	private String name;
    private int capacity;
    private String stat;

	public Consumable(String name, int capacity, String stat) {
		this.name = name;
		this.capacity = capacity;
		this.stat = stat;
	}

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStat() {
        return stat;
    }

    private String getPlural() {
	    if (getCapacity() > 1) {
	        return "s";
        }else {
	        return "";
        }
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int use() throws ConsumeEmptyException {

	    if (getCapacity() == 0){
	        throw new ConsumeEmptyException();
        }

	    int cap = getCapacity();
	    setCapacity(0);
	    return cap;
    }

    @Override
	public String toString() {
		return String.format(Locale.US, "%s [%d %s point%s]", getName(), getCapacity(), getStat(), getPlural()) ;
	}

    @Override
    public int getWeight() {
        return 1;
    }
	
}
