import java.util.*; 

public class Moves {
    int damage, accuracy, pp;
    String moveName;
    Type typeMove;

    public Moves(int damage, int accuracy, int pp, String moveName, Type typeMove) {
        this.damage = damage;
        this.accuracy = accuracy;
        this.pp = pp;
        this.moveName = moveName;
        this.typeMove = typeMove;
    }

    public Type getType(){
        return typeMove;
    }

    public int getDamage(){
        return damage;
    }

    public int getAccuracy(){
        return accuracy;
    }

    public int getPP(){
        return pp;
    }
    
    public String getName(){
        return moveName;
    } 
}


// Proin at placerat nulla, et egestas ante. Morbi quam justo, scelerisque non 
// lectus porttitor, mollis pulvinar metus. Quisque gravida risus sit amet 
// tristique facilisis. Aliquam non diam tortor. Pellentesque dapibus 
// dignissim nisi, et hendrerit est pulvinar non. Aenean id massa ut ante 
// pharetra ornare. Nulla quis maximus sem, ac pulvinar enim. Nunc vulputate 
// aliquet magna, elementum mattis augue laoreet eget. Curabitur pellentesque 
// erat a orci ornare, et pharetra nunc bibendum. Aenean congue lacinia ornare.

