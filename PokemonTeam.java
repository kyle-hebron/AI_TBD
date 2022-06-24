import java.util.*;

public class PokemonTeam{

    //switched from standard array to ArrayList to optimize insertPokemon()
    String trainerName;
    ArrayList<Pokemon> team = new ArrayList<Pokemon>();

    PokemonTeam(String trainerName) {
        this.trainerName = trainerName;
    }

    public void insertPokemon(Pokemon poke){
        if(team.size() > 3) {
            System.out.println("Team is full! Max party of 3.");
            return;
        }
        
        team.add(poke);
    }

    public Pokemon getPokemon(int i) {
        return team.get(i);
    }

    //Checks to see if all the pokemon are fainted
    public boolean allFainted(){
        for(int i = 0; i < 3; i++){
            if(!team.get(i).isFainted())
                return false;
        }
        return true;
    }

}