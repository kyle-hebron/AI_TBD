import java.util.*;


public class Moves {
    int damage, accuracy;
    String moveName;
    Type typeMove;

    public Moves(int damage, int accuracy, String moveName, Type typeMove) {
        this.damage = damage;
        this.accuracy = accuracy;
        this.moveName = moveName;
        this.typeMove = typeMove;
    }

    //not sure if this needs to be under Moves.java or Battle.java -MD
    public boolean hit() {
        Random rand = new Random();
        int randomInt = rand.nextInt(100) + 1;
        if(randomInt < accuracy)
            return true;
        return false;
    }

    public Type getType(){
        return typeMove;
    }

    public int getDamage(){
        return damage;
    }
}
