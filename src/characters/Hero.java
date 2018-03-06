package characters;

public class Hero  extends Character{


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

}
