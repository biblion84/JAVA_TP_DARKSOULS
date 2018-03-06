import lsg.helpers.Dice;

public class Main {

    public static void main(String[] args) {
        Dice dice = new Dice(50);
        Integer min = null;
        Integer max = null;
        for (int i = 0; i<500; i++) {
            int value = dice.roll();
            if ( (min == null) || (value < min)) {
                min = value;
            }
            if ( (max == null) || (value > max)) {
                max = value;
            }
            System.out.print(value+" ");
        }
        System.out.println("\nMin : "+min);
        System.out.println("Max : "+max);
    }
}