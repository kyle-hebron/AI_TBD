import java.util.*;


//this class should be the battle simulator, will need to work as a "main" function for the game -MD
public class Battle {
    PokemonTeam userTeam;
    PokemonTeam enemyTeam;
    Pokemon currentPokemon;
    Pokemon enemyCurrent;

    public Battle(PokemonTeam userTeam, PokemonTeam enemyTeam) {
        
        this.userTeam = userTeam;
        this.enemyTeam = enemyTeam;
        currentPokemon = userTeam.getPokemon(1);
        enemyCurrent = enemyTeam.getPokemon(0);
    }

    
    public void chooseOption(){ //Maybe have this for the main to call -Kyle
        Scanner scan = new Scanner(System.in);
        

        
            System.out.println("Please pick a move");
            int i = scan.nextInt();
            double damage = calculateDamage(currentPokemon.moveList[i - 1], currentPokemon, enemyCurrent);
            
            enemyCurrent.setHealth(damage);
            
            System.out.println(currentPokemon.name + " used " + currentPokemon.moveList[i - 1].getName() + " dealing " + damage);
            System.out.println(enemyCurrent.getName() + " has " + enemyCurrent.getCurrHP() + " out of " + enemyCurrent.getHP());
            System.out.println("Please pick a move");
            i = scan.nextInt();

            double endamage = calculateDamage(enemyCurrent.moveList[i - 1], enemyCurrent, currentPokemon);
            currentPokemon.setHealth(endamage);
            System.out.println(enemyCurrent.name + " used " + enemyCurrent.moveList[i - 1].getName() + " dealing " + endamage);
            System.out.println(currentPokemon.getName() + " has " + currentPokemon.getCurrHP() + " out of " + currentPokemon.getHP());
                //Need to call the AI here to make their move
                //Check speed
                //Then deal damage
                //Check to see if pokemon fainted
                //If fainted, cannot move

                
                
          
    }

    public void switchPokemon(int i) {
        if(userTeam.getPokemon(i) == currentPokemon) {      //Check to see if pokemon being brought out is fainted
            System.out.println("Pokemon is already out");
        } else {
            currentPokemon = userTeam.getPokemon(i);
        }
    }

    //damage calculator (STAB and critical hit included) //Added accuracy check -Kyle
    public double calculateDamage(Moves attackingMove, Pokemon attacker, Pokemon target) {
        if(!hit(attackingMove)){
            System.out.println("Attack missed");
            return 0.0;
        }
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
        
        return atkType.getEffectiveness(defType);
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

    //Accuracy for move
    public boolean hit(Moves move) {
        Random rand = new Random();
        int randomInt = rand.nextInt(100) + 1;
        if(randomInt < move.getAccuracy())
            return true;
        return false;
    }

}

