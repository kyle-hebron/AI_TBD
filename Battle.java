import java.util.*;


//this class should be the battle simulator, will need to work as a "main" function for the game -MD
public class Battle {
    PokemonTeam userTeam;
    PokemonTeam enemyTeam;
    Pokemon currentPokemon;// = userTeam.getPokemon(0);
    Pokemon enemyCurrent;// = enemyTeam.getPokemon(0);

    public Battle(PokemonTeam userTeam, PokemonTeam enemyTeam) {
        this.userTeam = userTeam;
        this.enemyTeam = enemyTeam;
    }

    public void switchPokemon(int i) {
        if(userTeam.getPokemon(i) == currentPokemon) {
            System.out.println("Pokemon is already out");
        } else {
            currentPokemon = userTeam.getPokemon(i);
        }
    }

    public int calculateDamage(Moves move, Pokemon currentPoke, Pokemon enemyPoke) {

        currentPokemon = currentPoke;       //Used for testing purposes
        enemyCurrent = enemyPoke;

        int attack = currentPokemon.getAtk();
        int defense = enemyCurrent.getDef();
        int basePower = move.getDamage();
        Type tempType = move.getType();
        Type enemyType = enemyPoke.getPokeType();
        int damage = attack - defense;

        if(damage <= 0)
            damage = basePower;

        switch(tempType.getEffectiveness(enemyType)){
            case 0:
                return damage;
            case 1: 
                return 2 * damage;
            case 2:
                return damage / 2;
            case 3:
                return 0;

        }

        return 0;

    }

}

