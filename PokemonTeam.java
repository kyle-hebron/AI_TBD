import java.util.*;

//PokemonTeam is an instance of an ArrayList of Pokemon objects.
//Normally this would be utilized under the battle simulator as a local variable.
//However, there were functions we could implement better if the ArrayList of Pokemon were it's own object.
public class PokemonTeam{

    //Switched from standard array to ArrayList to optimize insertPokemon().
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

    public String getName(){
        return trainerName;
    }
    //Checks to see if all the Pokemon are fainted.
    public boolean allFainted(){
        for(int i = 0; i < 3; i++){
            if(!team.get(i).isFainted())
                return false;
        }
        return true;
    }

    public void printTeam(){
        for(int i = 0; i < 3; i++){
            int k = i + 1;
            System.out.println(k + ": " + team.get(i).getCurrHP() + "/" + team.get(i).getHP() + ": " + team.get(i).getName());
        }
    }

    public void healAll(){
        for(int i = 0; i < 3; i++){
            team.get(i).heal();
        }
    }

}
