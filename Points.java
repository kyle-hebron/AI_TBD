import java.util.*;
import java.util.ArrayList;

public class Points{

    ArrayList<Integer> ptsArr;
    int totalPts; 

    public Points(int totalPts){ 
    
        this.totalPts = totalPts;
        ptsArr = new ArrayList<Integer>();
    }  

    public void setPoints(Moves damage){   

        ptsArr.add(damage.getDamage()); 

        totalPts = 0;

        for(int i = 0; i < ptsArr.size(); i++){
            totalPts += ptsArr.get(i);
        }
            
    }

    public int getPoints(){ 
        return totalPts;
    }

}