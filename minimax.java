///////////FROM Geeks For Geeks: https://www.geeksforgeeks.org/minimax-algorithm-in-game-theory-set-4-alpha-beta-pruning/
// Java program to demonstrate
// working of Alpha-Beta Pruning
 
class Minimax { //changed class name for our purposes
 
// Initial values of
// Alpha and Beta
static int MAX = 1000;
static int MIN = -1000;

// Returns optimal value for
// current player (Initially called
// for root and maximizer)
static int minimax(int depth, int nodeIndex,
                   Boolean maximizingPlayer,
                   int values[], int alpha,
                   int beta)
{
    // Terminating condition. i.e
    // leaf node is reached
    if (depth == 3)
        return values[nodeIndex];
 
    if (maximizingPlayer)
    {
        int best = MIN;
 
        // Recur for left and
        // right children
        for (int i = 0; i < 2; i++)
        {
            int val = minimax(depth + 1, nodeIndex * 2 + i,
                              false, values, alpha, beta);
            best = Math.max(best, val);
            alpha = Math.max(alpha, best);
 
            // Alpha Beta Pruning
            if (beta <= alpha)
                break;
        }
        return best;
    }
    else
    {
        int best = MAX;
 
        // Recur for left and
        // right children
        for (int i = 0; i < 2; i++)
        {
             
            int val = minimax(depth + 1, nodeIndex * 2 + i,
                              true, values, alpha, beta);
            best = Math.min(best, val);
            beta = Math.min(beta, best);
 
            // Alpha Beta Pruning
            if (beta <= alpha)
                break;
        }
        return best;
    }
}

////////////////////////////////////////////END GEEKS FOR GEEKS CODE
	
	
	//Helper Functions
	
	//determines whether the AI should attack or switch
    public int aiAtkOrSwitch(Pokemon me, Pokemon target){
        //calculate values for each pokemon and attack
        int choice = -1;
        int[] hValues = new int[6];

        for(int i = 0; i < 4; i++){
            Moves move = me.moveList[i];
            hValues[i] = (int)aiChooseAtk(move, target, me);
        }
        for(int i = 4; i < 6; i++){
            hValues[i] = (int)aiPokeSwitch(me, target);
        }
        int res = minimax(0, 0, true, hValues, MIN, MAX); 
        //find the position of the value of res within hvals[] in order to determine the action taken
        //take that action
        for(int i = 0; i < 6; i++){
            int location = hValues[i];
            if(location == res){
                choice = i;
                break;
            }
        }
        return choice;
        //position 0 - 5; 0 - 3 are moves 4 & 5 switch
    }

	//determines a move's heuristic value in the current turn
	public double aiChooseAtk(Moves move, Pokemon target, Pokemon user){
		double hValue = 0.0;

		Type moveType = move.getType();
		Type targetType = target.getPokeType();

		double movePower = move.getDamage();
		double effective = moveType.getEffectiveness(targetType);

        PokemonTeam temps = new PokemonTeam("");    //Filler
        PokemonTeam temper = new PokemonTeam("");
        temps.insertPokemon(target);
        temper.insertPokemon(user);
        Battle temp = new Battle(temps, temper);
        double health = target.getHP();
		hValue =  temp.calculateDamage(move, user, target) / health;
        
        System.out.println(hValue);
		return hValue;
	}
	
	//determines a Pokemon's heuristic value in the current turn
	public double aiPokeSwitch(Pokemon toSwitch, Pokemon target){
		double hValue = 1.0;

		Type toSwitchType = toSwitch.getPokeType();
		Type targetType = target.getPokeType();

		//this is gonna return a very small value compared to aiChooseAtk(), need to determine how to bring up the value -MD
		hValue = hValue * toSwitchType.getEffectiveness(targetType);
        System.out.println(hValue);
		return hValue;
		
	}
	
	
}