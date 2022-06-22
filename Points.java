import java.util.*; 

public class Points{
 
    int totalPts; 

    public Points(int totalPts){ 
    
        this.totalPts = totalPts; 
    }   

    public void addDamage(Moves damage){ 
        totalPts += damage.getDamage();
    }

    public int getPoints(){ 
        return totalPts;
    }

}