package characters;

public class Hero {
    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;

    public Hero(String name) {
        this.name = name;
        this.life = 100;
        this.maxLife = 100;
        this.stamina = 50;
        this.maxStamina = 50;
    }

    public Hero() {
        this("Ynovator");
    }

    public String printStats() {
        String isAlive = this.isAlive() ? "ALIVE" : "DEAD";
        String stats = "[ Hero ]\t"+this.name+"\tLIFE: "+this.life+"\tSTAMINA: "+this.life+"\t"+isAlive;
        System.out.println(stats);
        return stats;
    }

    public String toString() {
        return printStats();
    }

    public boolean isAlive() {
        return this.life > 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return this.maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getStamina() {
        return this.stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxStamina() {
        return this.maxStamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }
}
