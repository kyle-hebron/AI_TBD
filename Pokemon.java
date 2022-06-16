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
    private String getHP() {
        return health;
    }
    private String getAtk() {
        return attack;
    }
    private String getDef() {
        return defense;
    }
    private String getSpd() {
        return speed;
    }
    
}
