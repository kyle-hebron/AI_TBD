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
    public void setHealth(int newHP) {
        currentHP = newHP;
    }
    public void insertMoves(Moves move) {
        for(int i = 0; i < 4; i++)
            if(moveList[i] == null)
                moveList[i] = move;
    }
    //getter methods
    public String getName() {
        return name;
    }
    public int getHP() {
        return health;
    }
    public int getAtk() {
        return attack;
    }
    public int getDef() {
        return defense;
    }
    public int getSpd() {
        return speed;
    }

    public Type getPokeType(){
        return pokeType;
    }
    
}
