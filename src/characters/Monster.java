package characters;

public class Monster extends Character {
    private static int INSTANCE_COUNT = 0;

    private float skinThickness;

    /**
     * Constructeur qui instancie un monstre avec les charactéristique par défaut
     * @param name le nom du monstre
     */
    public Monster(String name){
        this.name = name;
        this.life = 10;
        this.maxLife = 10;
        this.stamina = 10;
        this.maxStamina = 10;
        this.skinThickness = 20;
    }

    /**
     * Constructeur par défaut retournant un monstre
     * nommé Monster_N + le numéro d'instanciation du monstre
     */
    public Monster(){
        this("Monster_" + Monster.INSTANCE_COUNT);
        Monster.INSTANCE_COUNT++;
    }

    public float getSkinThickness() {
        return skinThickness;
    }

    protected void setSkinThickness(float skinThickness) {
        this.skinThickness = skinThickness;
    }

    public float computeProtection(){
        return this.getSkinThickness();
    }
}
