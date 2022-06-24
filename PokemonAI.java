import java.util.*;


public class PokemonAI{

    //Battle AI needs to determine how to attack, or switch pokemon

    /*
    //Should AI have their own class? -Kyle
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
    public Moves whichAttack(PokemonTeam user, PokemonTeam computer) {
        Type userType = user.getCurrentPokemon().getPokeType();
        Moves[] computerMovesList = computer.getCurrentPokemon().getMovesList();
        ArrayList<Moves> bestMoves = new ArrayList<Moves>();

        //gather which moves are the best
        for(movelist size) {
            if(moveslist[i].getType.getEffectiveness() == 1)
                bestMoves.add(moveslist[i]);
        }

        //if no moves are super effective, check for any neutral attacks
        if(bestmoves.size() == 0) {
            for(movelist size) {
            if(moveslist[i].getType.getEffectiveness() == 0)
                bestMoves.add(moveslist[i]);
            }
        }
        //if no moves are neutral, check for any least effective attacks
        if(bestmoves.size() == 0) {
            for(movelist size) {
            if(moveslist[i].getType.getEffectiveness() == 2)
                bestMoves.add(moveslist[i]);
            }
        }
        //at this point, switch pokemon or use a move
        if(bestmoves.size() == 0) {
            switch pokemon if possible,
            otherwise use first available move
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

        // Scanner scan = new Scanner(System.in);
        // String name, rival;
        // double damage = 0.0;

        Type fire = new Type(2);
        // Type water = new Type(0);
        Type grass = new Type(1);

        PokemonTeam user = new PokemonTeam("User");
        PokemonTeam enemy1 = new PokemonTeam("Doodoo head");

        Moves ember = new Moves(40,100, "Ember", fire);
        // Moves watergun = new Moves(40, 100, "Water Gun", water);
        Moves vinewhip = new Moves(60, 100, "Vine Whip", grass);

        Pokemon charizard = new Pokemon("Charizard", 359, 266, 268, 298, 2);
        Pokemon venasaur = new Pokemon("Venasaur", 363, 262, 298, 258, 1);
        Pokemon blastoise = new Pokemon("Blastoise", 361, 264, 298, 254, 0);
        charizard.insertMoves(ember);
        venasaur.insertMoves(vinewhip);

        user.insertPokemon(charizard);
        user.insertPokemon(venasaur);
        user.insertPokemon(blastoise);
        enemy1.insertPokemon(blastoise);
        Battle currentBattle = new Battle(user, enemy1);
        currentBattle.chooseOption();
        System.out.println(blastoise.getCurrHP() + " out of " + blastoise.getHP());
                
        //Ignore this
                
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
