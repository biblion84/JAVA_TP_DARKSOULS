public class Monster {
    private static int INSTANCE_COUNT = 0;

    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;

    public Monster(String name){
        this.name = name;
        this.life = 10;
        this.maxLife = 10;
        this.stamina = 10;
        this.maxStamina = 10;
    }
    public Monster(){
        this("Monster_" + Monster.INSTANCE_COUNT);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }
}
