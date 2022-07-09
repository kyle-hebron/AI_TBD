
import java.util.*;

//Battle class is an instance of the Battle object that runs a simulation of a single Pokemon battle using AI.
//The AI algorithm used is the minimax algorithm, which is extended in this class.
public class Battle extends Minimax {

    PokemonTeam userTeam;
    PokemonTeam enemyTeam;
    Pokemon currentPokemon;
    Pokemon enemyCurrent;
    int ntemp = 0;
    int utemp = 0;

    public Battle(PokemonTeam userTeam, PokemonTeam enemyTeam) {
        this.userTeam = userTeam;
        this.enemyTeam = enemyTeam;
        currentPokemon = userTeam.getPokemon(0);
        enemyCurrent = enemyTeam.getPokemon(0);
    }

    //Tester function for the minimax algorithm.
    public void test() {
        System.out.println("--------The best move to use is " + aiAtkOrSwitch(enemyTeam, enemyCurrent, currentPokemon));
    }

    //Takes in user input, ints 1-4, and chooses the move from the Pokemon object's moveList array.
    //After a move is made, AI starts processing the minimax algorithm to determine it's best move.
    public void chooseMove() {

        Scanner scan = new Scanner(System.in);

        //User's input for their turn starts here.
        currentPokemon.printMoves();;
        System.out.println("Please pick a move");
        int i = scan.nextInt();
        while (i > 4 || i < 1) {
            System.out.println("Please pick a valid move choice (1, 2, 3, or 4):");
            currentPokemon.printMoves();
            i = scan.nextInt();
        }
        double damage = calculateDamage(currentPokemon.moveList[i - 1], currentPokemon, enemyCurrent);

        //User's input for their turn ends. AI's advesarial search begins. Starts processing the algorithms.
        int temp = aiAtkOrSwitch(enemyTeam, enemyCurrent, currentPokemon);

        //The AI determines that attacking/using a move is the best option.
        if (temp < 4) {
            double endamage = calculateDamage(enemyCurrent.moveList[temp], enemyCurrent, currentPokemon);

            //Speed checks are done for each Pokemon, and determines who goes first in the turn.
            //The user's Pokemon is faster than the AI.
            if (currentPokemon.getSpd() > enemyCurrent.getSpd()) {
                //User deals damage.
                enemyCurrent.setHealth(damage);
                System.out.println(currentPokemon.name + " used " + currentPokemon.moveList[i - 1].getName() + " dealing " + damage);
                System.out.println(enemyCurrent.getName() + " has " + enemyCurrent.getCurrHP() + " out of " + enemyCurrent.getHP());

                //Check to see if the current Pokemon fainted after the user's move.
                if (enemyCurrent.isFainted()) {
                    if (enemyTeam.allFainted()) {     //Checks to see if enemy has no remaining Pokemon in their team.
                        System.out.println("Congrats! You have defeated " + enemyTeam.trainerName);
                        return;
                    } else {
                        //Switches out for the next Pokemon in the party.
                        enemyCurrent = searchAvailable();
                        System.out.println(enemyTeam.trainerName + " has brought out " + enemyCurrent.getName());
                    }
                } else {
                    //If the Pokemon has not fainted, enemy deals damage to user.
                    currentPokemon.setHealth(endamage);
                    System.out.println(enemyCurrent.name + " used " + enemyCurrent.moveList[temp].getName() + " dealing " + endamage);
                    System.out.println(currentPokemon.getName() + " has " + currentPokemon.getCurrHP() + " out of " + currentPokemon.getHP());
                    if (currentPokemon.isFainted()) { //If user fainted, attempt to switch to an available Pokemon.
                        if (userTeam.allFainted()) { //If all the user's Pokemon fainted, game over.
                            System.out.println("You have been defeated. :( Restart to try again!");
                            System.exit(0);
                        } else {
                            faintedPokemonSwap();
                        }
                    }
                }
            } else if (currentPokemon.getSpd() < enemyCurrent.getSpd()) { //The AI's Pokemon is faster than the user.
                //AI deals damage.
                currentPokemon.setHealth(endamage);
                System.out.println(enemyCurrent.name + " used " + enemyCurrent.moveList[temp].getName() + " dealing " + endamage);
                System.out.println(currentPokemon.getName() + " has " + currentPokemon.getCurrHP() + " out of " + currentPokemon.getHP());

                if (currentPokemon.isFainted()) {     //Checks to see if user's Pokemon has fainted.
                    if (userTeam.allFainted()) {    //User's Pokemon team has fainted, game over.
                        System.out.println("You have been defeated. :( Restart to try again!");
                        System.exit(0);
                    } else {       //If the user's Pokemon fainted and has an available Pokemon on the team, switch Pokemon.
                        faintedPokemonSwap();
                    }
                } else {    //If the user's Pokemon hasn't fainted, deal damage to the enemy.
                    enemyCurrent.setHealth(damage);
                    System.out.println(currentPokemon.name + " used " + currentPokemon.moveList[i - 1].getName() + " dealing " + damage);
                    System.out.println(enemyCurrent.getName() + " has " + enemyCurrent.getCurrHP() + " out of " + enemyCurrent.getHP());
                    if (enemyCurrent.isFainted()) {
                        if (enemyTeam.allFainted()) {     //Checks to see if enemy has all fainted Pokemon.
                            System.out.println("Congrats! You have defeated " + enemyTeam.trainerName);
                            return;
                        } else {       //AI switches out for the next Pokemon in the party.
                            enemyCurrent = searchAvailable();
                            System.out.println(enemyTeam.trainerName + " has brought out " + enemyCurrent.getName());
                        }
                    }
                }
            } else if (currentPokemon.getSpd() == enemyCurrent.getSpd()) { //The user's Pokemon and AI's Pokemon have the same speed, a coin flip is done to see who goes first.

                Random rand = new Random();
                int a = rand.nextInt(2);

                if (a == 0) {            //User attacks first.
                    enemyCurrent.setHealth(damage);
                    System.out.println(currentPokemon.name + " used " + currentPokemon.moveList[i - 1].getName() + " dealing " + damage);
                    System.out.println(enemyCurrent.getName() + " has " + enemyCurrent.getCurrHP() + " out of " + enemyCurrent.getHP());

                    //Check to see if Pokemon fainted.
                    if (enemyCurrent.isFainted()) {
                        if (enemyTeam.allFainted()) {
                            System.out.println("You have been defeated. :( Restart the game to try again!");
                            System.exit(0);
                        } else {
                            if (enemyTeam.allFainted()) {
                                System.out.println("Congrats! You have defeated " + enemyTeam.trainerName);
                                return;
                            } else {
                                enemyCurrent = searchAvailable();
                                System.out.println(enemyTeam.trainerName + " has brought out " + enemyCurrent.getName());
                            }
                        }
                    } else {
                        currentPokemon.setHealth(endamage);
                        System.out.println(enemyCurrent.name + " used " + enemyCurrent.moveList[temp].getName() + " dealing " + endamage);
                        System.out.println(currentPokemon.getName() + " has " + currentPokemon.getCurrHP() + " out of " + currentPokemon.getHP());
                    }
                    if (currentPokemon.isFainted()) { //If user fainted, switches pokemon
                        if (userTeam.allFainted()) {
                            System.out.println("You have been defeated. :( Restart the game to try again!");
                            System.exit(0);
                        } else {
                            faintedPokemonSwap();
                        }
                    }
                } else {           //Enemy attacks first.
                    currentPokemon.setHealth(endamage);
                    System.out.println(enemyCurrent.name + " used " + enemyCurrent.moveList[temp].getName() + " dealing " + endamage);
                    System.out.println(currentPokemon.getName() + " has " + currentPokemon.getCurrHP() + " out of " + currentPokemon.getHP());

                    if (currentPokemon.isFainted()) {
                        if (userTeam.allFainted()) {
                            System.out.println("You have been defeated. :( Restart to try again!");
                            System.exit(0);
                        } else {
                            faintedPokemonSwap();
                        }
                    } else {
                        enemyCurrent.setHealth(damage);
                        System.out.println(currentPokemon.name + " used " + currentPokemon.moveList[i - 1].getName() + " dealing " + damage);
                        System.out.println(enemyCurrent.getName() + " has " + enemyCurrent.getCurrHP() + " out of " + enemyCurrent.getHP());
                        if (enemyCurrent.isFainted()) {
                            if (enemyTeam.allFainted()) {
                                System.out.println("Congrats! You have defeated " + enemyTeam.trainerName);
                                return;
                            } else {
                                enemyCurrent = searchAvailable();
                                System.out.println(enemyTeam.trainerName + " has brought out " + enemyCurrent.getName());
                            }
                        }
                    }
                }
            }

        } else {    //The AI determines that switching to another Pokemon is the best option.

            temp = temp - 4;
            if (enemyTeam.getPokemon(temp).isFainted()) {
                for (int k = 0; k < 3; k++) {
                    if (!enemyTeam.getPokemon(k).isFainted()) {
                        enemyCurrent = enemyTeam.getPokemon(k);
                        break;
                    }
                }
            } else {
                if(enemyTeam.getPokemon(temp) == enemyCurrent) {
                    temp++;
                }
            }
            System.out.println(enemyTeam.trainerName + " has brought out " + enemyCurrent.getName());
            enemyCurrent = enemyTeam.getPokemon(temp);

            System.out.println("AI switching to " + enemyCurrent.getName());
            enemyCurrent.setHealth(damage);
            System.out.println(currentPokemon.name + " used " + currentPokemon.moveList[i - 1].getName() + " dealing " + damage);
            System.out.println(enemyCurrent.getName() + " has " + enemyCurrent.getCurrHP() + " out of " + enemyCurrent.getHP());
            if (enemyCurrent.isFainted()) {
                for (int k = 0; k < 3; k++) {
                    if (!enemyTeam.getPokemon(k).isFainted()) {
                        enemyCurrent = enemyTeam.getPokemon(k);
                        System.out.println("Switch completed");
                        break;
                    }
                }
            }
        }
    }

    //Takes in user input for which available Pokemon to swap out into the field.
    public void switchPokemon() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Which pokemon would you like to switch out?");
        userTeam.printTeam();
        int i = scan.nextInt();
        Boolean track = true;
        while (track == true) {
            if (i <= 0 || i > 3) {
                System.out.println("Invalid input, please try again!");
                i = scan.nextInt();
            } else {
                track = false;
            }
        }

        //Makes sure that a fainted Pokemon is not brought out.
        while (true) {
            if (userTeam.getPokemon(i - 1) == currentPokemon) {
                System.out.println("Pokemon is already out, please pick another pokemon");
                i = scan.nextInt();
            }
            if (userTeam.getPokemon(i - 1).isFainted()) {
                System.out.println("Pokemon is fainted, please pick another pokemon");
                i = scan.nextInt();
            } else {
                currentPokemon = userTeam.getPokemon(i - 1);
                break;
            }
        }

        //AI's mini-max algorithm is done since their turn still occurs during the user's Pokemon swap.
        //Current AI works ahead of the user's turn, and predicts what the user sends out.
        //Need to implement a toggle difficulty option for this method since under the original game's rule, this would be considered cheating.
        int temp = aiAtkOrSwitch(enemyTeam, enemyCurrent, currentPokemon);
        //The AI determines that attacking is the best option.
        if (temp < 4) {
            double endamage = calculateDamage(enemyCurrent.moveList[temp], enemyCurrent, currentPokemon);
            currentPokemon.setHealth(endamage);
            System.out.println(enemyCurrent.name + " used " + enemyCurrent.moveList[temp].getName() + " dealing " + endamage);
            System.out.println(currentPokemon.getName() + " has " + currentPokemon.getCurrHP() + " out of " + currentPokemon.getHP());

            if (currentPokemon.isFainted()) {
                if (userTeam.allFainted()) {
                    System.out.println("You have been defeated. :( Restart to try again!");
                    System.exit(0);
                } else {
                    faintedPokemonSwap();
                }
            }
        } else {    //AI determines that switching is the best option.
            temp = temp - 4;
            if (enemyTeam.getPokemon(temp).isFainted()) {
                for (int k = 0; k < 3; k++) {
                    if (!enemyTeam.getPokemon(k).isFainted()) {
                        enemyCurrent = enemyTeam.getPokemon(k);
                        break;
                    }
                }
            } else {
                if(enemyTeam.getPokemon(temp) == enemyCurrent) {
                    temp++;
                }
            }
            enemyCurrent = enemyTeam.getPokemon(temp);
            System.out.println(enemyTeam.trainerName + " has brought out " + enemyCurrent.getName());
        }
    }

    //Returns an available Pokemon from the team (i.e. a Pokemon that is not fainted).
    public Pokemon searchAvailable() {
        for (int k = 0; k < 3; k++) {

            if (!enemyTeam.getPokemon(k).isFainted()) {
                return enemyTeam.getPokemon(k);
            }
        }
        return null;
    }

    //If the current Pokemon has fainted, this allows a Pokemon to be swapped out.
    public void faintedPokemonSwap() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Which pokemon would you like to switch out?");
        userTeam.printTeam();
        int i = scan.nextInt();
        Boolean track = true;
        while (track == true) {
            if (i <= 0 || i >= 4) {
                System.out.println("Invalid input, please try again!");
                i = scan.nextInt();
            } else {
                track = false;
            }
        }
        i--;

        while (true) {
            if (userTeam.getPokemon(i) == currentPokemon) {
                System.out.println("Pokemon is already out, please pick another pokemon");
                i = scan.nextInt();
                i--;
            }
            if (userTeam.getPokemon(i).isFainted()) {
                System.out.println("Pokemon is fainted, please pick another pokemon");
                i = scan.nextInt();
                i--;
            } else {
                currentPokemon = userTeam.getPokemon(i);
                break;
            }
        }
    }

    public void switchEnemy(int i) {            //Used for AI.
        enemyCurrent = enemyTeam.getPokemon(i);
    }

    //damage calculator (STAB and critical hit included), with an accuracy check.
    public double calculateDamage(Moves attackingMove, Pokemon attacker, Pokemon target) {
        if (!hit(attackingMove)) {
            System.out.println("Attack missed");
            return 0.0;
        }
        double damage = 0.0;
        int basePower = attackingMove.getDamage();

        double multiplierT = typeEffectivenesMultiplier(attackingMove, attacker, target);
        double multiplierD = damageMultiplier(attacker, target);

        damage = basePower * multiplierD * multiplierT;

        if (isSTAB(attackingMove, attacker)) {
            damage *= 1.5;
        }

        if (isCritical()) {
            damage *= 1.5;
            System.out.println(attacker.getName() + " has crit");
        }
        return damage;
    }

    //Calculates the potential damage of a move without a critical multiplier.
    //Mainly used for AI checks.
    //Standard damage calculator will be used for all moves.
    public double calculateDamageNoCrit(Moves attackingMove, Pokemon attacker, Pokemon target) {

        double damage = 0.0;
        int basePower = attackingMove.getDamage();

        double multiplierT = typeEffectivenesMultiplier(attackingMove, attacker, target);
        double multiplierD = damageMultiplier(attacker, target);

        damage = basePower * multiplierD * multiplierT;

        if (isSTAB(attackingMove, attacker)) {
            damage *= 1.5;
        }

        return damage;
    }

    //Damage multiplier based off type matchup is done in a separate method.
    public double typeEffectivenesMultiplier(Moves move, Pokemon attacker, Pokemon defender) {
        // double multiplier = 1.0;
        Type atkType, defType;

        //The type of the attacker's move.
        atkType = move.getType();
        //The type of the target pokemon.
        defType = defender.getPokeType();

        return atkType.getEffectiveness(defType);
    }

    //Damage multiplier based off of attacker's ATK stat and defender's DEF stat.
    public double damageMultiplier(Pokemon attacker, Pokemon defender) {
        double multiplier = 1.0;
        int attackerATK, defenderDEF;

        attackerATK = attacker.getAtk();
        defenderDEF = defender.getDef();

        multiplier = (((2.4) * (attackerATK / defenderDEF)) / 50) + 2;

        return multiplier;
    }

    //Critical hit for a move (using the 6.25% chance standard).
    public boolean isCritical() {
        boolean answer = false;
        Random ran = new Random();
        int chance = ran.nextInt(100);

        if (chance <= 16) {
            answer = true;
        }

        return answer;
    }

    //Checks if a move is STAB (same-type attack bonus, which is calculated to 50% more damage).
    public boolean isSTAB(Moves atk, Pokemon attacker) {
        if (atk.getType() == attacker.getPokeType()) {
            return true;
        } else {
            return false;
        }
    }

    //Accuracy for a move.
    public boolean hit(Moves move) {
        Random rand = new Random();
        int randomInt = rand.nextInt(100) + 1;
        if (randomInt <= move.getAccuracy()) {
            return true;
        }
        return false;
    }

}
