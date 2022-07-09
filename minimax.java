///////////FROM Geeks For Geeks: https://www.geeksforgeeks.org/minimax-algorithm-in-game-theory-set-4-alpha-beta-pruning/
// Java program to demonstrate the working of Alpha-Beta pruning.

class Minimax { //Changed class name for our purposes.

    // Initial values of Alpha and Beta.
        static int MAX = Integer.MAX_VALUE;
        static int MIN = Integer.MIN_VALUE;
    
    // Returns optimal value for current player.
    // Initially called for root and maximizer.
        static int minimax(int depth, int nodeIndex,
                Boolean maximizingPlayer,
                int values[], int alpha,
                int beta) {
            // Terminating condition. i.e. Leaf node is reached.
            if (depth == 3) {
                return values[nodeIndex];
            }
    
            if (maximizingPlayer) {
    
                int best = MIN;
    
                // Recursion for the left and right children.
                for (int i = 0; i < 2; i++) {
    
                    int val = minimax(depth + 1, nodeIndex * 2 + i,
                            false, values, alpha, beta);
                    best = Math.max(best, val);
                    alpha = Math.max(alpha, best);
    
                    // Alpha-Beta pruning.
                    if (beta <= alpha) {
                        break;
                    }
                }
                return best;
            } else {
                int best = MAX;
    
                // Recursion for the left and right children.
                for (int i = 0; i < 2; i++) {
    
                    int val = minimax(depth + 1, nodeIndex * 2 + i,
                            true, values, alpha, beta);
                    best = Math.min(best, val);
                    beta = Math.min(beta, best);
    
                    // Alpha-Beta pruning.
                    if (beta >= alpha) {
                        break;
                    }
                }
                return best;
            }
        }
    
    ////////////////////////////////////////////END GEEKS FOR GEEKS CODE
        //Helper functions for the mini-max algorithm to work for the Pokemon battle simulator.

        //Determines whether the AI should attack or switch.
        public int aiAtkOrSwitch(PokemonTeam myTeam, Pokemon me, Pokemon target) {
            //Calculate heuristic values for each Pokemon and attack.
            int choice = -1;
            int[] hValues = new int[8];
    
            //Initializes the h-values in an array, the first four values being the moves, and the last two values being the other two Pokemon on the team.
            for (int i = 0; i < 4; i++) {
                Moves move = me.moveList[i];
                hValues[i] = (int) aiChooseAtk(move, target, me);
            }
            for (int i = 4; i < 6; i++) {
                hValues[i] = (int) aiPokeSwitch(myTeam, me, target);
            }
            for (int i = 6; i < 8; i++) {
                hValues[i] = 0;
            }
            int res = minimax(0, 0, true, hValues, MIN, MAX);
            //Find the position of the value of mini-max's result within hValues[] in order to determine the action taken.
            //Take that action.
            for (int i = 0; i < 6; i++) {
                int location = hValues[i];
                if (location == res) {
                    choice = i;
                    break;
                }
            }
            return choice;
            //Position 0 - 5: 0 - 3 are moves, 4 and 5 are Pokemon to switch to.
        }
    
        //Determines a move's heuristic value in the current turn.
        public double aiChooseAtk(Moves move, Pokemon target, Pokemon user) {
            double hValue = 0.0;

            PokemonTeam temps = new PokemonTeam("");
            PokemonTeam temper = new PokemonTeam("");
            temps.insertPokemon(target);
            temper.insertPokemon(user);
            Battle temp = new Battle(temps, temper);
            double health = target.getHP();
            hValue = temp.calculateDamageNoCrit(move, target, user);
    
            return hValue;
        }
    
        //Determines a Pokemon's heuristic value in the current turn.
        //This is the first version of the switch heuristic function.
        //Keep implemented (and commented) just in case the current fuction breaks as we add new features.
        //This implementation works, just does not occur as accurately as it should.
        /*
        public double aiPokeSwitch(Pokemon toSwitch, Pokemon target){
            double hValue = 1.0;
    
            Type toSwitchType = toSwitch.getPokeType();
            Type targetType = target.getPokeType();
    
            if(toSwitchType.getEffectiveness(targetType) == 2.0) {
                Moves moveList[] = toSwitch.getMoveList();
                for(int i = 0; i < moveList.length; i++) {
                    double newHValue = aiChooseAtk(moveList[i], target, toSwitch);
                    if(newHValue > hValue)
                        hValue = newHValue;
                }
            }
            return hValue; 
        }
         */
        
         //Current version of the switch heuristic function.
         //Does NOT yet determine the health of the remaining Pokemon into the heuristic value calculation. (Maybe in the next patch?)
        public double aiPokeSwitch(PokemonTeam team, Pokemon me, Pokemon target) {
            double hValue = 1.0;
    
            Type myType = me.getPokeType();
            Type targetType = target.getPokeType();
    
            //Ff the enemy is effective against me, I should switch.
            if (targetType.getEffectiveness(myType) == 2.0) {
                int i = 1;
                while (i < 3) {
                    Pokemon toSwitch = team.getPokemon(i);
                    if (toSwitch.isFainted()) {
                        return 0;
                    }
                    Type toSwitchType = toSwitch.getPokeType();
                    if (team.getPokemon(i).equals(me)) {
                        i++;
                    }
                    if (i == 3) {
                        Moves moveList[] = toSwitch.getMoveList();
                        for (int j = 0; j < moveList.length; j++) {
                            double newHValue = aiChooseAtk(moveList[j], target, toSwitch);
                            if (newHValue > hValue) {
                                hValue = newHValue * 2;
                            }
                        }
                        break;
                    }
                    //If the Pokemon I want to switch to is super effective against the enemy, switch to that Pokemon.
                    if (toSwitchType.getEffectiveness(targetType) == 2.0) {
                        Moves moveList[] = toSwitch.getMoveList();
                        for (int j = 0; j < moveList.length; j++) {
                            double newHValue = aiChooseAtk(moveList[j], target, toSwitch);
                            if (newHValue > hValue) {
                                hValue = newHValue * 2;
                            }
                        }
                        break;
                    }
                    i++;
                }
            }
            return hValue;
        }
    
    }
    