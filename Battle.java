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

    //damage calculator (STAB and critical hit included)
    public double calculateDamage(Moves attackingMove, Pokemon attacker, Pokemon target) {
        double damage = 0.0;
        int basePower = attackingMove.getDamage();

        double multiplierT = typeEffectivenesMultiplier(attackingMove, attacker, target);
        double multiplierD = damageMultiplier(attacker, target);

        damage = basePower * multiplierD * multiplierT;

        if(isSTAB(attackingMove, attacker))
            damage *= 1.5;

        if(isCritical())
            damage *= 1.5;

        return damage;

    }

    //damage multiplier based off type matchup is done in a separate method
    public double typeEffectivenesMultiplier(Moves move, Pokemon attacker, Pokemon defender) {
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

    //critical hit for a move (using the 6.25% chance standard)
    public boolean isCritical() {
        boolean answer = false;
        Random ran = new Random();
        int chance = ran.nextInt(100);

        if(chance <= 16)
            answer = true;
        
        return answer;
    }

    public boolean isSTAB(Moves atk, Pokemon attacker) {
        if(atk.getType() == attacker.getPokeType())
            return true;
        else
            return false;
    }

}

