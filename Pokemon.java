import java.util.*;

public class Pokemon{

    String name;
    int health, attack, defense, speed, currentHP;
    Type pokeType;
    Moves[] moveList = new Moves[4];

    public Pokemon(String name, int health, int attack, int defense, int speed, int typeNum) {
        this.name = name;
        this.health = health;
        currentHP = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        pokeType = new Type(typeNum);
       
    }
    
    //setter method only really needed for health, other stats should remain the same (for now)
    private void setHealth(int newHP) {
        currentHP = newHP;
    }
    private void insertMoves(Moves move) {
        for(int i = 0; i < 4; i++)
            if(moveList[i] == null)
                moveList[i] = move;
    }
    //getter methods
    private String getName() {
        return name;
    }
    private int getHP() {
        return health;
    }
    private int getAtk() {
        return attack;
    }
    private int getDef() {
        return defense;
    }
    private int getSpd() {
        return speed;
    }
    
}
