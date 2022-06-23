import java.util.*;


public class PokemonAI{

    //Battle AI needs to determine how to attack, or switch pokemon

    /*

    //AI checks both active pokemon on the field, their type matchup, and determines if it should stay on the field
    public Pokemon shouldSwitch(PokemonTeam user, PokemonTeam computer) {
        if(user.getCurrentPokemon().getPokeType().getEffectiveness() == 1) {
            for(team size) {
                if(any pokemon on the team are super effective against the user)
                    switch to that pokemon
                else if(any pokemon on the team aren't weak to the user)
                    switch to that pokemon
                else //i.e. all the pokemon are weak to the user
                    switch to the pokemon with the most health
            }
        } else {
            return NULL;
        }
    }

    //AI checks the user's pokemon type, and searches for the best attack to use
    public Moves shouldSwitch(PokemonTeam user, PokemonTeam computer) {
        Type userType = user.getCurrentPokemon().getPokeType();
        Moves[] computerMovesList = computer.getCurrentPokemon().getMovesList();
        ArrayList<Moves> bestMoves = new ArrayList<Moves>();

        //gather which moves are the best
        for(movelist size) {
            if(moveslist[i].getType.getEffectiveness() == 1)
                bestMoves.add(moveslist[i]);
        }

        //out of all the moves, which deals the most damage
        for(bestMoves.size()) {
            if(size == 1)
                return bestmoves.get(i);
            else {
                if(bestmoves.get(i).getDamage() > bestmoves.get(i + 1).getDamage())
                    bestmoves.remove(i + 1);
            }
        }
    }
    */

    public static void main(String[] args) throws InterruptedException{

        Scanner scan = new Scanner(System.in);
        String name, rival;
        double damage = 0.0;

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
        //int damage = currentBattle.calculateDamage(ember, charmander, bulbasaur);
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
