import java.util.*;


class Type{
    
    private int[][] type = {
        {2, 2, 1, 1, 0, 0},     //0 = water, 1 = grass, 2 = fire, 3 = ground, 4 = electric, 5 = flying
        {1, 2, 2, 1, 0, 2},     //0 means neutral, 1 means super effective, 2 means not very effective, 3 means no effect
        {2, 1, 2, 0, 0, 0},     //type[attack][defend]
        {0, 2, 1, 0, 1, 3}, 
        {1, 0, 0, 3, 0, 1}, 
        {0, 1, 0, 0, 2, 0}
    };

    private String typeName;
    private int typeNum;

    public Type(int num){
        typeNum = num;
        switch(num) {
            case 0:
                typeName = "water";
                break;
            case 1:
                typeName = "grass";
                break;
            case 2:
                typeName = "fire";
                break;
            case 3:
                typeName = "ground";
                break;
            case 4:
                typeName = "electric";
                break;
            case 5:
                typeName = "flying";
                break;
            default:
                System.out.println("Error, no type found");
                break;
        }
    }

    public String getTypeName(){
        return typeName;
    }
    
}