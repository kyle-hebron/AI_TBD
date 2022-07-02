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

    

// }

// A simple java program to find maximum score that
// maximizing player can get.
 
import java.io.*;
 
class GFG {
   
 
// Returns the optimal value a maximizer can obtain.
// depth is current depth in game tree.
// nodeIndex is index of current node in scores[].
// isMax is true if current move is of maximizer, else false
// scores[] stores leaves of Game tree.
// h is maximum height of Game tree
 static int minimax(int depth, int nodeIndex, boolean  isMax,
            int scores[], int h)
{
    // Terminating condition. i.e leaf node is reached
    if (depth == h)
        return scores[nodeIndex];
 
    // If current move is maximizer, find the maximum attainable
    // value
    if (isMax)
    return Math.max(minimax(depth+1, nodeIndex*2, false, scores, h),
            minimax(depth+1, nodeIndex*2 + 1, false, scores, h));
 
    // Else (If current move is Minimizer), find the minimum
    // attainable value
    else
        return Math.min(minimax(depth+1, nodeIndex*2, true, scores, h),
            minimax(depth+1, nodeIndex*2 + 1, true, scores, h));
}
 
// A utility function to find Log n in base 2
 static int log2(int n)
{
return (n==1)? 0 : 1 + log2(n/2);
}
 
// Driver code
 
    public static void main (String[] args) {
            // The number of elements in scores must be
    // a power of 2.
    int scores[] = {3, 5, 2, 9, 12, 5, 23, 23};
    int n = scores.length;
    int h = log2(n);
    int res = minimax(0, 0, true, scores, h);
    System.out.println( "The optimal value is : "  +res);
         
    }
	
	
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