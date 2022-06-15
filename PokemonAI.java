import java.util.*;


public class PokemonAI{
    
    

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        String name, rival;
        System.out.println("Hello there! Welcome to the world of POKEMON! My name is OAK! People call me the POKEMON PROF!");
        System.out.println("This world is inhabited by creatures called POKEMON!");
        System.out.println("For some people, POKEMON are pets. Others use them for fights. Myself...I study POKEMON as a profession.");
        System.out.println("First, what is your name?");
        name = scan.nextLine();
        System.out.println("Right! So your name is " + name + "!");
        System.out.println("This is my grandson. He's been your rival since you were a baby. ...Erm, what is his name again?");
        rival = scan.nextLine();
        

        PokemonTeam user = new PokemonTeam(name);
    }
}
