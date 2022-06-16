import java.util.*;


public class PokemonAI{

    int[][] type = {
        {2, 2, 1, 1, 0, 0},     //0 = water, 1 = grass, 2 = fire, 3 = ground, 4 = electric, 5 = flying
        {1, 2, 2, 1, 0, 2},     //0 means neutral, 1 means super effective, 2 means not very effective, 3 means no effect
        {2, 1, 2, 0, 0, 0},     //type[attack][defend]
        {0, 2, 1, 0, 1, 3}, 
        {1, 0, 0, 3, 0, 1}, 
        {0, 1, 0, 0, 2, 0}
    };
    

    public static void main(String[] args) throws InterruptedException{

        Scanner scan = new Scanner(System.in);
        String name, rival;

        System.out.println("Hello there! Welcome to the world of POKEMON! My name is OAK! People call me the POKEMON PROF!");
        Thread.sleep(2000);
        System.out.println("This world is inhabited by creatures called POKEMON!");
        Thread.sleep(2000);
        System.out.println("For some people, POKEMON are pets. Others use them for fights. Myself...I study POKEMON as a profession.");
        Thread.sleep(2000);
        System.out.println("First, what is your name?");
        name = scan.nextLine();
        System.out.println("Right! So your name is " + name + "!");
        Thread.sleep(2000);
        System.out.println("This is my grandson. He's been your rival since you were a baby. ...Erm, what is his name again?");
        rival = scan.nextLine();
        Thread.sleep(2000);
        System.out.println("That's right! I remember now! His name was " + rival + "! ");
        Thread.sleep(2000);
        System.out.println( name + "!" + " Your very own POKEMON legend is about to unfold!");
        Thread.sleep(2000);
        System.out.println("A world of dreams and adventures with POKEMON awaits! Let's go!");
        scan.close();
        PokemonTeam user = new PokemonTeam(name);
        PokemonTeam enemy1 = new PokemonTeam(rival);
    }
}
