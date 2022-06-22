import java.util.*;


public class PokemonAI{

    
    

    public static void main(String[] args) throws InterruptedException{

        Scanner scan = new Scanner(System.in);
        String name, rival;

        Type fire = new Type(2);
        Type water = new Type(0);
        Type grass = new Type(1);

        PokemonTeam user = new PokemonTeam("User");
        PokemonTeam enemy1 = new PokemonTeam("Doodoo head");

        Moves ember = new Moves(40,100, "Ember", fire);
        Moves watergun = new Moves(40, 100, "Water Gun", water);
        Moves vinewhip = new Moves(40, 100, "Vine Whip", grass);

        Pokemon charmander = new Pokemon("Charmander", 39, 52, 43, 65, 2);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 45, 49, 50, 45, 1);
        Pokemon squirtle = new Pokemon("Squirtle", 44, 48, 65, 43, 0);

        Battle currentBattle = new Battle(user, enemy1);
        int damage = currentBattle.calculateDamage(ember, charmander, bulbasaur);
        System.out.println(damage);


        

        /* 
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
        */

        
    }
}
