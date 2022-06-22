import java.util.*;

public class PokemonTeam{

    String trainerName;
    Pokemon[] teamList = new Pokemon[3];

    PokemonTeam(String trainerName) {
        this.trainerName = trainerName;
    }

    public void insertPokemon(Pokemon poke){

        for(int i = 0; i < 3; i++) {
            if(teamList[i] == null) {
                teamList[i] = poke;
                break;
            }
            if(i == 2) {
                System.out.println("Team is full");
            }
        }
        
        
    }

    public Pokemon getPokemon(int i) {
        return teamList[i];
    }


}