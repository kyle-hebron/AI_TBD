import java.util.*;


class Type{
    
    //I'm gonna look into making this easier to read -MD
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
                typeName = "normal";
                break;
            case 1:
                typeName = "fire";
                break;
            case 2:
                typeName = "water";
                break;
            case 3:
                typeName = "grass";
                break;
            case 4:
                typeName = "electric";
                break;
            case 5:
                typeName = "ice";
                break;
            case 6:
                typeName = "fighting";
                break;
            case 7:
                typeName = "poison";
                break;
            case 8:
                typeName = "ground";
                break;
            case 9:
                typeName = "flying";
                break;
            case 10:
                typeName = "psychic";
                break;
            case 11:
                typeName = "bug";
                break;
            case 12:
                typeName = "rock";
                break;
            case 13:
                typeName = "ghost";
                break;
            case 14:
                typeName = "dragon";
                break;
            default:
                System.out.println("Error, no type found");
                break;
        }
    }

    public int getTypeNum(){
        return typeNum;
    }

    public String getTypeName(){
        return typeName;
    }

    public int getEffectiveness(Type targetDEF) {        
        return type[typeNum][targetDEF.typeNum];
    }
    
}

//Ignore this too