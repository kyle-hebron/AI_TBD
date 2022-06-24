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
    void generateTeams(){

        //Initialize Teams
        PokemonTeam Leader1;
        PokemonTeam Leader2;
        PokemonTeam Leader3;
        PokemonTeam Leader4;
        PokemonTeam Leader5;
        PokemonTeam Leader6;
        PokemonTeam Leader7;
        PokemonTeam Leader8;

        //Generate Mon
        //Geodude, Leader 1
        Pokemon geodude = new Pokemon("Geodude", 221, 196, 236, 96, 12);
        Moves ancientPwr = new Moves(60, 100, "Ancient Power", rock);
        Moves bodySlam = new Moves(85, 100, "Body Slam", normal);
        Moves earthquake = new Moves(100, 100, "Earthquake", ground);
        Moves brickBreak = new Moves(75, 100, "Brick Break", fighting);
        geodude.insertMoves(ancientPwr);
        geodude.insertMoves(bodySlam);
        geodude.insertMoves(earthquake);
        geodude.insertMoves(brickBreak);
        //Sandshrew, Leader 1
        Pokemon sandshrew = new Pokemon("Sandshrew", 241, 186, 206, 116, 8);
        Moves focusPunch = new Moves(150, 100, "Focus Punch", fighting);
        Moves poisonJab = new Moves(80, 100, "Poison Jab", poison);
        sandshrew.insertMoves(bodySlam);
        sandshrew.insertMoves(brickBreak);
        sandshrew.insertMoves(focusPunch);
        sandshrew.insertMoves(poisonJab);
        //Onix, Leader 1
        Pokemon onix = new Pokemon("Onix", 211, 126, 356, 176, 12);
        Moves dragonPulse = new Moves(85, 100, "Dragon Pulse", dragon);
        onix.insertMoves(bodySlam);
        onix.insertMoves(earthquake);
        onix.insertMoves(ancientPwr);
        onix.insertMoves(dragonPulse);

        //Magmar, Leader 5
        Pokemon magmar = new Pokemon("Magmar", 333, 288, 212, 284, 1);
        Moves fireBlast = new Moves(120, 85, "Fire Blast", fire);
        Moves flamethrower = new Moves(95, 100, "Flamethrower", fire);
        Moves hyperBeam = new Moves(150, 90, "Hyper Beam", normal);
        magmar.insertMoves(fireBlast);
        magmar.insertMoves(bodySlam);
        magmar.insertMoves(flamethrower);
        magmar.insertMoves(hyperBeam);



        //Add Mon to Teams

        //Leader 1
        Leader1.insertPokemon(geodude);
        Leader1.insertPokemon(sandshrew);
        Leader1.insertPokemon(onix);

        //Leader 2
        Leader5.insertPokemon(pidgeot);
        Leader5.insertPokemon(hitmonchan);
        Leader5.insertPokemon(electabuzz);

        //Leader 3
        Leader5.insertPokemon(flareon);
        Leader5.insertPokemon(jolteon);
        Leader5.insertPokemon(vaporeon);

        //Leader 4
        Leader5.insertPokemon(starmie);
        Leader5.insertPokemon(wartortle);
        Leader5.insertPokemon(seadra);

        //Leader 5
        Leader5.insertPokemon(magmar);
        Leader5.insertPokemon(charmeleon);
        Leader5.insertPokemon(arcanine);


        //Leader 6
        Leader5.insertPokemon(ivysaur);
        Leader5.insertPokemon(tangela);
        Leader5.insertPokemon(vileplume);

        //Leader 7
        Leader5.insertPokemon(articuno);
        Leader5.insertPokemon(moltres);
        Leader5.insertPokemon(zapdos);

        //Leader 8
        Leader5.insertPokemon(dragonite);
        Leader5.insertPokemon(mew);
        Leader5.insertPokemon(mewtwo);
    }
    
}
