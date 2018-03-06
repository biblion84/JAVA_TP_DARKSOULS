package characters;

public class Hero  extends Character{

    /**
     * Constructeur qui instancie un monstre avec les charactéristique par défaut
     * @param name le nom du monstre
     */
    public Hero(String name) {
        this.name = name;
        this.life = 100;
        this.maxLife = 100;
        this.stamina = 50;
        this.maxStamina = 50;
    }

    /**
     * Constructeur qui instancie un Hero avec  un nom par défaut
     */
    public Hero() {
        this("Ynovator");
    }

}
