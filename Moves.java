import java.util.*;


public class Moves {
    int damage, accuracy;
    String moveName;

    public Moves(int damage, int accuracy, String moveName) {
        this.damage = damage;
        this.accuracy = accuracy;
        this.moveName = moveName;
    }

    public boolean hit() {
        Random rand = new Random();
        int randomInt = rand.nextInt(100) + 1;
        if(randomInt < accuracy)
            return true;
        return false;
    }
}
