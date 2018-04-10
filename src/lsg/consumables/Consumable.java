package lsg.consumables;

import java.util.Locale;

public abstract class Consumable {

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

    public String getPlurial() {
	    if (getCapacity() > 1) {
	        return "s";
        }else {
	        return "";
        }
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int use() {
	    capacity = getCapacity();
	    setCapacity(0);
	    return capacity;
    }

    @Override
	public String toString() {
		return String.format(Locale.US, "%s [%d %s point%s]", getName(), getCapacity(), getStat(), getPlurial()) ;
	}
	
}
