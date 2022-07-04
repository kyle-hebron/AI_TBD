// public class Temp {
    
 

//     //calculate heuristic value
      
//     if(heuristic_val > enemy.heuristicVal){ 
//         switch; 
//     }else if(heuristic_val < enemy.heuristicVal){
//         return;
//     }else{
//         if(health < 25%){
//             switch;
//         }
//         if(health > 75%){
//             return;
//         }
//     }

    

// Java program to demonstrate
// working of Alpha-Beta Pruning
import java.io.*;
 
class Temp {
 
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
 
    // Driver Code
    public static void main (String[] args)
    {
         
        int values[] = {3, 5, 6, 9, 1, 2, 0, -1};
        System.out.println("The optimal value is : " +
                            minimax(0, 0, true, values, MIN, MAX));
     
    }
}
 
// This code is contributed by vt_m.
	
	
	//Helper Functions
	
	//determines whether the AI should attack or switch
	public void aiAtkOrSwitch(Pokemon me, Pokemon target){
		//calculate values for each pokemon and attack
		double[] hValues = new double[6];
		
		for(int i = 0; i < 4; i++){
			Moves move = me.moveList[i];
			hValues[i] = aiChooseAtk(move, target);
		}
		for(int i = 4; i < 6; i++){
			hValues[i] = aiPokeSwitch(me, target);
		}
		int res = minimax(0, 0, true, hValues, h); //broke
		//find the position of the value of res within hvals[] in order to determine the action taken
		//take that action
	}

	//determines a move's heuristic value in the current turn
	public double aiChooseAtk(Moves move, Pokemon target){
		double hValue = 0.0;

		Type moveType = move.getType();
		Type targetType = target.getPokeType();

		double movePower = move.getDamage();
		double effective = moveType.getEffectiveness(targetType);

		hValue = movePower * effective;

		return hValue;
	}
	
	//determines a Pokemon's heuristic value in the current turn
	public double aiPokeSwitch(Pokemon toSwitch, Pokemon target){
		double hValue = 1.0;

		Type toSwitchType = toSwitch.getPokeType();
		Type targetType = target.getPokeType();

		//this is gonna return a very small value compared to aiChooseAtk(), need to determine how to bring up the value -MD
		hValue = hValue * toSwitchType.getEffectiveness(targetType);

		return hValue;
		
	}
	
	
}