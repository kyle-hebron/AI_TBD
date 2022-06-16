import java.util.*;

public class Pokemon{

    String name;
    int health, attack, defense, speed;

    public Pokemon(String name, int health, int attack, int defense, int speed) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
       
    }
    
    //setter method only really needed for health, other stats should remain the same (for now)
    private void setHealth(int newHP) {
        health = newHP;
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
