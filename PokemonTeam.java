import java.util.*;

public class PokemonTeam{

    String trainerName;
    Pokemon[] teamList = new Pokemon[3];

    PokemonTeam(String trainerName) {
        this.trainerName = trainerName;
    }

    public void insertPokemon(String name, int attack, int defense, int speed){

        for(int i = 0; i < 3; i++) {
            if(teamList[i] == null) {
                Pokemon temp = new Pokemon(name, attack, defense, speed);
                break;
            }
            if(i == 2) {
                System.out.println("Team is full");
            }
        }
        
    }


}