import java.util.*;


public class Moves {
    int damage, accuracy, pp;
    String moveName;
    Type typeMove;

    public Moves(int damage, int accuracy, int pp, String moveName, Type typeMove) {
        this.damage = damage;
        this.accuracy = accuracy;
        this.pp = pp;
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

    public int getPP(){
        return pp;
    }
    
    public String getName(){
        return moveName;
    }

    public void changeMovename(String name){
        moveName = name;
    }

}
