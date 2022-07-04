import java.util.*;


//this class should be the battle simulator, will need to work as a "main" function for the game -MD
public class Battle extends Minimax{
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

    public void test(){
        System.out.println("The best move to use is " + enemyCurrent.getMoveName(aiAtkOrSwitch(enemyCurrent, currentPokemon)));
    }

    
    public void chooseMove(){ //Maybe have this for the main to call -Kyle
        Scanner scan = new Scanner(System.in);
        

            currentPokemon.printMoves();;
            System.out.println("Please pick a move");
            int i = scan.nextInt();
            double damage = calculateDamage(currentPokemon.moveList[i - 1], currentPokemon, enemyCurrent);
            

            /* 
            System.out.println("Please pick a move");
            i = scan.nextInt();
        */
            Random tempRand = new Random();
            int temp = tempRand.nextInt(4) + 1;
            double endamage = calculateDamage(enemyCurrent.moveList[temp - 1], enemyCurrent, currentPokemon);
            
                if(currentPokemon.getSpd() > enemyCurrent.getSpd()){
                    //Then deal damage
                    enemyCurrent.setHealth(damage);
                    System.out.println(currentPokemon.name + " used " + currentPokemon.moveList[i - 1].getName() + " dealing " + damage);
                    System.out.println(enemyCurrent.getName() + " has " + enemyCurrent.getCurrHP() + " out of " + enemyCurrent.getHP());

                    //Check to see if pokemon fainted
                    if(enemyCurrent.isFainted()){
                        if(enemyTeam.allFainted()){     //Checks to see if enemy has all fainted pokemon
                            System.out.println("Congrats! You have defeated " + enemyTeam.trainerName);
                            return;
                        }  else {       //Switches out for the next pokemon in the party
                            enemyCurrent = enemyTeam.getPokemon(++ntemp);
                            System.out.println(enemyTeam.trainerName + " has brought out " + enemyCurrent.getName());
                        }
                    } else {    //If the pokemon has not fainted, enemy deals damage to user
                        currentPokemon.setHealth(endamage);
                        System.out.println(enemyCurrent.name + " used " + enemyCurrent.moveList[i - 1].getName() + " dealing " + endamage);
                        System.out.println(currentPokemon.getName() + " has " + currentPokemon.getCurrHP() + " out of " + currentPokemon.getHP());
                        if(currentPokemon.isFainted()){ //If user fainted, switches pokemon
                            if(userTeam.allFainted()){
                                System.out.println("You have been defeated. :( Sucks to suck");
                                return;
                            }  else {
                                faintedPokemonSwap();
                            }
                        } 
                        
                    }

                    

                }
                
                else if(currentPokemon.getSpd() < enemyCurrent.getSpd()){
                    currentPokemon.setHealth(endamage);
                    System.out.println(enemyCurrent.name + " used " + enemyCurrent.moveList[i - 1].getName() + " dealing " + endamage);
                    System.out.println(currentPokemon.getName() + " has " + currentPokemon.getCurrHP() + " out of " + currentPokemon.getHP());

                    if(currentPokemon.isFainted()){     //Checls to see if user pokemon has fainted
                        if(userTeam.allFainted()){
                            System.out.println("You have been defeated. :( Sucks to suck");
                            return;
                        }  else {       //If user fainted, switches pokemon
                            faintedPokemonSwap();
                        }
                    } else {
                        enemyCurrent.setHealth(damage);
                        System.out.println(currentPokemon.name + " used " + currentPokemon.moveList[i - 1].getName() + " dealing " + damage);
                        System.out.println(enemyCurrent.getName() + " has " + enemyCurrent.getCurrHP() + " out of " + enemyCurrent.getHP());
                        if(enemyCurrent.isFainted()){
                            if(enemyTeam.allFainted()){     //Checks to see if enemy has all fainted pokemon
                                System.out.println("Congrats! You have defeated " + enemyTeam.trainerName);
                                return;
                            }  else {       //Switches out for the next pokemon in the party
                                enemyCurrent = enemyTeam.getPokemon(++ntemp);
                                System.out.println(enemyTeam.trainerName + " has brought out " + enemyCurrent.getName());
                            }
                        }
                    }
                }
                
                else if(currentPokemon.getSpd() == enemyCurrent.getSpd()){
                     Random rand = new Random();
                     int a = rand.nextInt(2);

                     if(a == 0){            //User attacks first
                         enemyCurrent.setHealth(damage);
                         System.out.println(currentPokemon.name + " used " + currentPokemon.moveList[i - 1].getName() + " dealing " + damage);
                          System.out.println(enemyCurrent.getName() + " has " + enemyCurrent.getCurrHP() + " out of " + enemyCurrent.getHP());

                         //Check to see if pokemon fainted
                         if(enemyCurrent.isFainted()){
                            if(enemyTeam.allFainted()){
                                System.out.println("You have been defeated. :( Sucks to suck");
                                return;
                            }  else {
                                if(enemyTeam.allFainted()){
                                    System.out.println("Congrats! You have defeated " + enemyTeam.trainerName);
                                    return;
                                }  else {
                                    enemyCurrent = enemyTeam.getPokemon(++ntemp);
                                    System.out.println(enemyTeam.trainerName + " has brought out " + enemyCurrent.getName());
                                }
                            }
                    } else {
                        currentPokemon.setHealth(endamage);
                        System.out.println(enemyCurrent.name + " used " + enemyCurrent.moveList[i - 1].getName() + " dealing " + endamage);
                        System.out.println(currentPokemon.getName() + " has " + currentPokemon.getCurrHP() + " out of " + currentPokemon.getHP());}
                        if(currentPokemon.isFainted()){ //If user fainted, switches pokemon
                            if(userTeam.allFainted()){
                                System.out.println("You have been defeated. :( Sucks to suck");
                                return;
                            }  else {
                                faintedPokemonSwap();
                            }
                        } 
                     } 
                     
                     else {           //Enemy attacks first
                        currentPokemon.setHealth(endamage);
                        System.out.println(enemyCurrent.name + " used " + enemyCurrent.moveList[i - 1].getName() + " dealing " + endamage);
                        System.out.println(currentPokemon.getName() + " has " + currentPokemon.getCurrHP() + " out of " + currentPokemon.getHP());

                        if(currentPokemon.isFainted()){
                            if(userTeam.allFainted()){
                                System.out.println("You have been defeated. :( Sucks to suck");
                                return;
                            }  else {
                                faintedPokemonSwap();
                            }
                    } else {
                        enemyCurrent.setHealth(damage);
                        System.out.println(currentPokemon.name + " used " + currentPokemon.moveList[i - 1].getName() + " dealing " + damage);
                        System.out.println(enemyCurrent.getName() + " has " + enemyCurrent.getCurrHP() + " out of " + enemyCurrent.getHP());
                        if(enemyCurrent.isFainted()){
                            if(enemyTeam.allFainted()){
                                System.out.println("Congrats! You have defeated " + enemyTeam.trainerName);
                                return;
                            }  else {
                                enemyCurrent = enemyTeam.getPokemon(++ntemp);
                                System.out.println(enemyTeam.trainerName + " has brought out " + enemyCurrent.getName());
                            }
                        }
                    }
                     }
      
                }

                
                
          
    }

    public void switchPokemon() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Which pokemon would you like to switch out?");
        userTeam.printTeam();
        int i = scan.nextInt();
        
        while(true){
        if(userTeam.getPokemon(i - 1) == currentPokemon) {      
            System.out.println("Pokemon is already out, please pick another pokemon");
            i = scan.nextInt();
        } if(userTeam.getPokemon(i - 1).isFainted())  {
            System.out.println("Pokemon is fainted, please pick another pokemon");
            i = scan.nextInt();
        }
            else {
            currentPokemon = userTeam.getPokemon(i - 1);
            break;
        } 
    }
    /* 
        if(userTeam.getPokemon(i) == currentPokemon) {      //Check to see if pokemon being brought out is fainted
             while(true){
        if(userTeam.getPokemon(i) == currentPokemon) {      
            System.out.println("Pokemon is already out");
        } 
        
         if(userTeam.getPokemon(i).isFainted())  {
            System.out.println("Pokemon is fainted");
        } else {
            currentPokemon = userTeam.getPokemon(i);
            break;
            }
        }
        */

        Random rand = new Random();
        int temp = rand.nextInt(4) + 1;
        double endamage = calculateDamage(enemyCurrent.moveList[temp - 1], enemyCurrent, currentPokemon);
        currentPokemon.setHealth(endamage);
        System.out.println(enemyCurrent.name + " used " + enemyCurrent.moveList[temp- 1].getName() + " dealing " + endamage);
        System.out.println(currentPokemon.getName() + " has " + currentPokemon.getCurrHP() + " out of " + currentPokemon.getHP());

        if(currentPokemon.isFainted()){
            if(userTeam.allFainted()){
                System.out.println("You have been defeated. :( Sucks to suck");
                return;
            }  else {
                faintedPokemonSwap();
            }
        }
        }

        public void faintedPokemonSwap(){
            Scanner scan = new Scanner(System.in);
            System.out.println("Which pokemon would you like to switch out?");
            userTeam.printTeam();
            int i = scan.nextInt();
            i--;
            while(true){
            if(userTeam.getPokemon(i) == currentPokemon) {      
                System.out.println("Pokemon is already out, please pick another pokemon");
                i = scan.nextInt();
            } if(userTeam.getPokemon(i).isFainted())  {
                System.out.println("Pokemon is fainted, please pick another pokemon");
                i = scan.nextInt();
            }
                else {
                currentPokemon = userTeam.getPokemon(i);
                break;
            } 
        }
        }
        
        /* 
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        double damage = calculateDamage(enemyCurrent.moveList[a - 1], enemyCurrent, currentPokemon);
        currentPokemon.setHealth(damage);
        */
    

    public void damage(Pokemon offense, Pokemon defense, Moves move){       //Used to calculate damage after switch

    }

    public void switchEnemy(int i) {            //Used for AI
        enemyCurrent = enemyTeam.getPokemon(i);
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

        if(isCritical()) {
            damage *= 1.5;
            System.out.println(attacker.getName() + " has crit");
        }
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

