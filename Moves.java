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

    public Type getType(){
        return typeMove;
    }

    public int getDamage(){
        return damage;
    }

    public int getAccuracy(){
        return accuracy;
    }

    public String getName(){
        return moveName;
    }
}
