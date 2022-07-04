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



    static PokemonTeam player = new PokemonTeam("player");
        
    static PokemonTeam Leader1 = new PokemonTeam("Mo");
    static PokemonTeam Leader2 = new PokemonTeam("Kelly Evans");
    static PokemonTeam Leader3 = new PokemonTeam("John Noga");
    static PokemonTeam Leader4 = new PokemonTeam("Richard Lorentz");
    static PokemonTeam Leader5 = new PokemonTeam("Adam Kaplan");
    static PokemonTeam Leader6 = new PokemonTeam("Donald Trump");
    static PokemonTeam Leader7 = new PokemonTeam("Chad");
    static PokemonTeam Leader8 = new PokemonTeam("Abhishek Verma");
    
    public static void main(String[] args) throws InterruptedException{

       

        
        // String name, rival;
        // double damage = 0.0;
        //Function to generate the player's team and all 8 Leaders' teams
        generateTeams();
        Battle temp = new Battle(player, Leader1);
        //temp.test();
        doBattle(new Battle(Leader1, player));
        /* 
        doBattle(new Battle(player, Leader1));

        player.healAll();
        System.out.println("Continue to " + Leader2.trainerName);
        doBattle(new Battle(player, Leader2));
        player.healAll();

        doBattle(new Battle(player, Leader3));
        player.healAll();

        doBattle(new Battle(player, Leader4));
        player.healAll();

        doBattle(new Battle(player, Leader5));
        player.healAll();

        doBattle(new Battle(player, Leader6));
        player.healAll();

        doBattle(new Battle(player, Leader7));
        player.healAll();

        doBattle(new Battle(player, Leader8));
        player.healAll();
        
        */
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

    public static void printBattle(Battle currentBattle){
        Pokemon userPoke = currentBattle.currentPokemon;
        Pokemon enemyPoke = currentBattle.enemyCurrent;
        System.out.println("---------------------");
        System.out.println(userPoke.getName());
        
        System.out.println(userPoke.getCurrHP() + "/" + userPoke.getHP());
        System.out.println("---------------------");
        System.out.println(enemyPoke.getName());
        
        System.out.println(enemyPoke.getCurrHP() + "/" + enemyPoke.getHP());
        System.out.println("---------------------");
    }

    public static void doBattle(Battle currentBattle){
        Scanner scan = new Scanner(System.in);
        while(!player.allFainted() && !currentBattle.enemyTeam.allFainted()){
            printBattle(currentBattle);
            System.out.println("play (YOU)[10] or switch (YOU)[20]?");
            int playOp = scan.nextInt();
            /* 
            System.out.println("play (PC)[10] or switch (PC)[20]?");
            int pcOp = scan.nextInt();
            */
            // YOUr move
            if(playOp == 10){ 
                 currentBattle.chooseMove();
            }
            /* 
            // PC's move
            if(pcOp == 10){
                 currentBattle.chooseMove();
            } 
            */
            // YOUr fighter
            if(playOp == 20){
                System.out.println("Choose your Pokemon.");
                
                currentBattle.switchPokemon();
            }
            /* 
            // PC's fighter
            if(playOp == 20){
                System.out.println("Choose PC's Pokemon.");
                
                currentBattle.switchPokemon();
            }
            */
            if(player.allFainted() || currentBattle.enemyTeam.allFainted()){
                break;
            }
        }
    }

    static void generateTeams(){
        //create Types? not sure if we still need this but did it anyway -- sam
        Type normal = new Type(0);
        Type fire = new Type(1);
        Type water = new Type(2);
        Type grass = new Type(3);
        Type electric = new Type(4);
        Type ice = new Type(5);
        Type fighting = new Type(6);
        Type poison = new Type(7);
        Type ground = new Type(8);
        Type flying = new Type(9);
        Type psychic = new Type(10);
        Type bug = new Type(11);
        Type rock = new Type(12);
        Type ghost = new Type(13);
        Type dragon = new Type(14);

        //Initialize Teams
        
        

        //Generate Mon

//PLAYER
        //Charizard, Player
        Pokemon charizard = new Pokemon("Charizard", 359, 266, 268, 1 /*298*/, 1);
        Moves fireBlast = new Moves(120, 85, 8, "Fire Blast", fire);
        Moves flamethrower = new Moves(95, 100, 24, "Flamethrower", fire);
        Moves ancientPwr = new Moves(60, 100, 8, "Ancient Power", rock);
        Moves fly = new Moves(90, 95, 24, "Fly", flying);
        charizard.insertMoves(fireBlast);
        charizard.insertMoves(flamethrower);
        charizard.insertMoves(fly);
        charizard.insertMoves(ancientPwr);
        //Venusaur, Player
        Pokemon venusaur = new Pokemon("Venusaur", 363, 262, 298,1 /*258*/, 3);
        Moves earthquake = new Moves(100, 100, 16, "Earthquake", ground);
        Moves bodySlam = new Moves(85, 100, 24, "Body Slam", normal);
        Moves nrgBall = new Moves(90, 100, 16, "Energy Ball", grass);
        Moves sludgeBomb = new Moves(90, 100, 16, "Sludge Bomb", poison);
        venusaur.insertMoves(earthquake);
        venusaur.insertMoves(bodySlam);
        venusaur.insertMoves(nrgBall);
        venusaur.insertMoves(sludgeBomb);
        //Blastoise, Player
        Pokemon blastoise = new Pokemon("Blastoise", 361, 264, 298, 1/*254*/, 2);
        Moves dragonPulse = new Moves(85, 100, 16, "Dragon Pulse", dragon);
        Moves hydroPump = new Moves(110, 80, 8, "Hydro Pump", water);
        blastoise.insertMoves(bodySlam);
        blastoise.insertMoves(earthquake);
        blastoise.insertMoves(dragonPulse);
        blastoise.insertMoves(hydroPump);

        //Insert mon for Player
        player.insertPokemon(charizard);
        player.insertPokemon(venusaur);
        player.insertPokemon(blastoise);

//LEADER 1
        //Geodude, Leader 1
        Pokemon geodude = new Pokemon("Geodude", 221, 196, 236, 96, 12);
        Moves brickBreak = new Moves(75, 100, 24, "Brick Break", fighting);
        geodude.insertMoves(ancientPwr);
        geodude.insertMoves(bodySlam);
        geodude.insertMoves(earthquake);
        geodude.insertMoves(brickBreak);
        //Sandshrew, Leader 1
        Pokemon sandshrew = new Pokemon("Sandshrew", 241, 186, 206, 116, 8);
        Moves focusPunch = new Moves(150, 100, 32, "Focus Punch", fighting);
        Moves poisonJab = new Moves(80, 100, 32, "Poison Jab", poison);
        sandshrew.insertMoves(bodySlam);
        sandshrew.insertMoves(brickBreak);
        sandshrew.insertMoves(focusPunch);
        sandshrew.insertMoves(poisonJab);
        //Onix, Leader 1
        Pokemon onix = new Pokemon("Onix", 211, 126, 356, 176, 12);
        onix.insertMoves(bodySlam);
        onix.insertMoves(earthquake);
        onix.insertMoves(ancientPwr);
        onix.insertMoves(dragonPulse);

        //Leader 1
        Leader1.insertPokemon(geodude);
        Leader1.insertPokemon(sandshrew);
        Leader1.insertPokemon(onix);

//LEADER 2
        //Pidgeot, Leader 2
        Pokemon pidgeot = new Pokemon("Pidgeot", 307, 196, 186, 238, 9);
        Moves braveBird = new Moves(120, 100, 24, "Brave Bird", flying);
        Moves hurricane = new Moves(110, 70, 16, "Hurricane", flying);
        Moves uTurn = new Moves(70, 100, 32, "U-Turn", bug);
        pidgeot.insertMoves(braveBird);
        pidgeot.insertMoves(hurricane);
        pidgeot.insertMoves(uTurn);
        pidgeot.insertMoves(fly);
        //Hitmonchan, Leader 2
        Pokemon hitmonchan = new Pokemon("Hitmonchan", 241, 246, 194, 188, 6);
        Moves closeCombat = new Moves(120, 100, 8, "Close Combat", fighting);
        Moves firePunch = new Moves(75, 100, 24, "Fire Punch", fire);
        Moves icePunch = new Moves(75, 100, 24, "Ice Punch", ice);
        Moves thunderPunch = new Moves(75, 100, 24, "Thunder Punch", electric);
        hitmonchan.insertMoves(closeCombat);
        hitmonchan.insertMoves(firePunch);
        hitmonchan.insertMoves(icePunch);
        hitmonchan.insertMoves(thunderPunch);
        //Electabuzz, Leader 2
        Pokemon electabuzz = new Pokemon("ELectabuzz", 211, 126, 356, 176, 12);
        Moves thunder = new Moves(110, 70, 16, "Thunder", electric);
        electabuzz.insertMoves(bodySlam);
        electabuzz.insertMoves(thunder);
        electabuzz.insertMoves(icePunch);
        electabuzz.insertMoves(firePunch);

        //Leader 2
        Leader2.insertPokemon(pidgeot);
        Leader2.insertPokemon(hitmonchan);
        Leader2.insertPokemon(electabuzz);

//LEADER 3
        //Flareon, Leader 3
        Pokemon flareon = new Pokemon("Flareon", 271, 296, 256, 166, 1);
        Moves hyperVoice = new Moves(90, 100, 16, "Hyper Voice", normal);
        flareon.insertMoves(bodySlam);
        flareon.insertMoves(fireBlast);
        flareon.insertMoves(flamethrower);
        flareon.insertMoves(hyperVoice);
        //Jolteon, Leader 3
        Pokemon jolteon = new Pokemon("Jolteon", 271, 256, 226, 296, 4);
        Moves shadowBall = new Moves(80, 100, 24, "Shadow Ball", ghost);
        Moves discharge = new Moves(80, 100, 24, "Discharge", electric);
        jolteon.insertMoves(hyperVoice);
        jolteon.insertMoves(thunder);
        jolteon.insertMoves(shadowBall);
        jolteon.insertMoves(discharge);
        //Vaporeon, Leader 3
        Pokemon vaporeon = new Pokemon("Vaporeon", 401, 256, 226, 166, 2);
        Moves blizzard = new Moves(110, 70, 8, "Blizzard", ice);
        vaporeon.insertMoves(blizzard);
        vaporeon.insertMoves(hyperVoice);
        vaporeon.insertMoves(shadowBall);
        vaporeon.insertMoves(hydroPump);

        //Leader 3
        Leader3.insertPokemon(flareon);
        Leader3.insertPokemon(jolteon);
        Leader3.insertPokemon(vaporeon);

//LEADER 4
        //Starmie, Leader 4
        Pokemon starmie = new Pokemon("Starmie", 261, 236, 206, 266, 2);
        Moves psychicMove = new Moves(90, 100, 16, "Psychic", psychic);
        Moves iceBeam = new Moves(90, 100, 16, "Ice Beam", ice);
        starmie.insertMoves(iceBeam);
        starmie.insertMoves(hydroPump);
        starmie.insertMoves(psychicMove);
        starmie.insertMoves(thunder);
        //Blastoise, Leader 4
        //Seadra, Leader 4
        Pokemon seadra = new Pokemon("Seadra", 251, 226, 226, 206, 2);
        Moves waterfall = new Moves(80, 100, 16, "Waterfall", water);
        seadra.insertMoves(waterfall);
        seadra.insertMoves(dragonPulse);
        seadra.insertMoves(iceBeam);
        seadra.insertMoves(hydroPump);

        //Leader 4
        Leader4.insertPokemon(starmie);
        Leader4.insertPokemon(blastoise);
        Leader4.insertPokemon(seadra);

//LEADER 5
        //Magmar, Leader 5
        Pokemon magmar = new Pokemon("Magmar", 333, 288, 212, 284, 1);
        Moves hyperBeam = new Moves(150, 90, 5, "Hyper Beam", normal);
        magmar.insertMoves(fireBlast);
        magmar.insertMoves(bodySlam);
        magmar.insertMoves(flamethrower);
        magmar.insertMoves(hyperBeam);
        //Arcanine, Leader 5
        Pokemon arcanine = new Pokemon("Arcanine", 321, 256, 196, 226, 1);
        Moves superPwr = new Moves(120, 100, 8, "Super Power", fighting);
        Moves psychicFangs = new Moves(85, 100, 16, "Psychic Fangs", psychic);
        arcanine.insertMoves(superPwr);
        arcanine.insertMoves(psychicFangs);
        arcanine.insertMoves(fireBlast);
        arcanine.insertMoves(dragonPulse);
        //Charizard, Leader 5

        //Leader 5
        Leader5.insertPokemon(magmar);
        Leader5.insertPokemon(charizard);
        Leader5.insertPokemon(arcanine);

//LEADER 6
        //Venusaur, Leader 6
        //Tangela, Leader 6
        Pokemon tangela = new Pokemon("Tangela", 271, 236, 266, 156, 3);
        Moves leafStorm = new Moves(130, 90, 8, "Leaf Storm", grass);
        Moves vinewhip = new Moves(45, 100, 25, "Vine Whip", grass);
        tangela.insertMoves(vinewhip);
        tangela.insertMoves(nrgBall);
        tangela.insertMoves(leafStorm);
        tangela.insertMoves(sludgeBomb);
        //Vileplume, Leader 6
        Pokemon vileplume = new Pokemon("Vileplume", 291, 256, 216, 136, 3);
        Moves drainPunch = new Moves(75, 100, 16, "Drain Punch", fighting);
        vileplume.insertMoves(drainPunch);
        vileplume.insertMoves(nrgBall);
        vileplume.insertMoves(sludgeBomb);
        vileplume.insertMoves(bodySlam);

        //Leader 6
        Leader6.insertPokemon(venusaur);
        Leader6.insertPokemon(tangela);
        Leader6.insertPokemon(vileplume);

//LEADER 7
        //Articuno, Leader 7
        Pokemon articuno = new Pokemon("Articuno", 321, 226, 286, 206, 5);
        Moves extrasensory = new Moves(80, 100, 32, "Extrasensory", psychic);
        articuno.insertMoves(blizzard);
        articuno.insertMoves(ancientPwr);
        articuno.insertMoves(braveBird);
        articuno.insertMoves(extrasensory);
        //Moltres, Leader 7
        Pokemon moltres = new Pokemon("Moltres", 321, 286, 216, 216, 1);
        moltres.insertMoves(fireBlast);
        moltres.insertMoves(ancientPwr);
        moltres.insertMoves(braveBird);
        moltres.insertMoves(extrasensory);
        //Zapdos, Leader 7
        Pokemon zapdos = new Pokemon("Zapdos", 321, 286, 216, 236, 4);
        zapdos.insertMoves(thunder);
        zapdos.insertMoves(ancientPwr);
        zapdos.insertMoves(braveBird);
        zapdos.insertMoves(extrasensory);

        //Leader 7
        Leader7.insertPokemon(articuno);
        Leader7.insertPokemon(moltres);
        Leader7.insertPokemon(zapdos);

//LEADER 8
        //Dragonite, Leader 8
        Pokemon dragonite = new Pokemon("Dragonite", 323, 304, 236, 196, 14);
        Moves dracoMeteor = new Moves(130, 90, 8, "Draco Meteor", dragon);
        dragonite.insertMoves(bodySlam);
        dragonite.insertMoves(dracoMeteor);
        dragonite.insertMoves(iceBeam);
        dragonite.insertMoves(thunder);
        //Mewtwo, Leader 8
        Pokemon mewtwo = new Pokemon("Mewtwo", 353, 344, 216, 296, 10);
        Moves thunderBolt = new Moves(90, 100, 24, "Thunderbolt", electric);
        mewtwo.insertMoves(shadowBall);
        mewtwo.insertMoves(psychicMove);
        mewtwo.insertMoves(thunderBolt);
        mewtwo.insertMoves(iceBeam);
        //Mew, Leader 8
        Pokemon mew = new Pokemon("Mew", 341, 236, 236, 236, 10);
        mew.insertMoves(shadowBall);
        mew.insertMoves(psychicMove);
        mew.insertMoves(thunderBolt);
        mew.insertMoves(braveBird);

        //Leader 8
        Leader8.insertPokemon(dragonite);
        Leader8.insertPokemon(mew);
        Leader8.insertPokemon(mewtwo);
    }
    
}
