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

    //need to look into STAB (same type attack bonus) -MD
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

    //damage multiplier based off type matchup is done in a separate method
    public double typeEffectivenesMultiplier(Moves move, Pokemon defender) {
        double multiplier = 1.0;
        Type atkType, defType;
        
        //the type of the attacker's move
        atkType = move.getType();
        //the type of the target pokemon
        defType = defender.getPokeType();

    
        if(atkType.getEffectiveness(defType) == 1) {
            multiplier = 2.0;
        } else if(atkType.getEffectiveness(defType) == 2) {
            multiplier = 0.5;
        } else if(atkType.getEffectiveness(defType) == 3) {
            multiplier = 0.0;
        }
        
        return multiplier;
    }

    //damage multiplier based off of attacker's ATK stat and defender's DEF stat
    public double damageMultiplier(Pokemon attacker, Pokemon defender) {
        double multiplier = 1.0;
        int attackerATK, defenderDEF;

        attackerATK = attacker.getAtk();
        defenderDEF = defender.getDef();

        multiplier = (((2.4) * (attackerATK / defenderDEF)) / 50) + 2;

        return multiplier;
    }

    //critical hit for a move
    public boolean isCritical() {
        boolean answer = false;
        Random ran = new Random();
        int coin = ran.nextInt(2);

        if(coin == 1)
            answer = true;
        
        return answer;
    }

}

