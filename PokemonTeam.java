import java.util.*;

public class PokemonTeam{

    //switched from standard array to ArrayList to optimize insertPokemon()
    String trainerName;
    ArrayList<Pokemon> team = new ArrayList<Pokemon>();

    PokemonTeam(String trainerName) {
        this.trainerName = trainerName;
    }

    public void insertPokemon(Pokemon poke){
        if(team.size() > 3) {
            System.out.println("Team is full! Max party of 3.");
            return;
        }
        
        team.add(poke);
    }

    public Pokemon getPokemon(int i) {
        return team.get(i);
    }

    public String getName(){
        return trainerName;
    }
    //Checks to see if all the pokemon are fainted
    public boolean allFainted(){
        for(int i = 0; i < 3; i++){
            if(!team.get(i).isFainted())
                return false;
        }
        return true;
    }

    public void printTeam(){
        for(int i = 0; i < 3; i++){
            int k = i + 1;
            System.out.println(k + ": " + team.get(i).getCurrHP() + "/" + team.get(i).getHP() + ": " + team.get(i).getName());
        }
    }

    public void healAll(){
        for(int i = 0; i < 3; i++){
            team.get(i).heal();
        }
    }

}


// In non orci quis augue vehicula imperdiet. Ut a erat in ex congue bibendum 
// sit amet quis dui. Class aptent taciti sociosqu ad litora torquent per 
// conubia nostra, per inceptos himenaeos. Vivamus blandit mollis nisi eget 
// efficitur. Donec et rutrum sapien, ac iaculis mi. Phasellus molestie lacus 
// sapien. Morbi sem quam, malesuada eleifend augue tempus, rhoncus tempor 

// sem. Duis pulvinar ex elit, non dignissim ex sagittis quis. Vivamus pretium 
// congue enim ac finibus. Aliquam ut elit ac sem ornare hendrerit non ac 
// sapien. Nullam imperdiet viverra egestas. Donec et dignissim dui. Praesent 
// maximus, dolor a dignissim sagittis, nisi neque elementum magna, laoreet 
// varius felis erat a mauris. Phasellus ligula ante, efficitur vel imperdiet 
// vitae, porttitor eu magna.



// Fusce condimentum lacus vel eros aliquet, eu aliquet est hendrerit. 
// Vestibulum suscipit venenatis eleifend. Pellentesque sollicitudin malesuada 
// sapien, et imperdiet lacus viverra ut. Nulla gravida sapien in cursus 
// mollis. Quisque purus ligula, aliquet interdum augue non, fermentum aliquet 
// nibh. Integer sed finibus tellus, vel laoreet mi. Donec vehicula ligula non 
// neque scelerisque vulputate eget ut dui. Proin mattis ante vitae mi egestas 
// blandit. Sed a lobortis magna.

// Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec imperdiet
//  lorem sapien, bibendum interdum augue suscipit nec. Phasellus rhoncus 
//  auctor rhoncus. Nulla facilisi. Nam egestas augue est, a luctus erat 
//  condimentum vel. Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
//  Suspendisse varius ac mi vel mattis. Nullam tristique rhoncus elit, non 
//  maximus risus hendrerit a. Proin dictum tortor quis iaculis congue. 
//  Quisque facilisis non nunc efficitur condimentum. Pellentesque condimentum 
//  ante ut leo dictum cursus. Praesent lacus sem, mattis quis nunc sit amet, 
//  convallis molestie risus.
// In non orci quis augue vehicula imperdiet. Ut a erat in ex congue bibendum 
// sit amet quis dui. Class aptent taciti sociosqu ad litora torquent per 
// conubia nostra, per inceptos himenaeos. Vivamus blandit mollis nisi eget 
// efficitur. Donec et rutrum sapien, ac iaculis mi. Phasellus molestie lacus 
// sapien. Morbi sem quam, malesuada eleifend augue tempus, rhoncus tempor 

// sem. Duis pulvinar ex elit, non dignissim ex sagittis quis. Vivamus pretium 
// congue enim ac finibus. Aliquam ut elit ac sem ornare hendrerit non ac 
// sapien. Nullam imperdiet viverra egestas. Donec et dignissim dui. Praesent 
// maximus, dolor a dignissim sagittis, nisi neque elementum magna, laoreet 
// varius felis erat a mauris. Phasellus ligula ante, efficitur vel imperdiet 
// vitae, porttitor eu magna.



// Fusce condimentum lacus vel eros aliquet, eu aliquet est hendrerit. 
// Vestibulum suscipit venenatis eleifend. Pellentesque sollicitudin malesuada 
// sapien, et imperdiet lacus viverra ut. Nulla gravida sapien in cursus 
// mollis. Quisque purus ligula, aliquet interdum augue non, fermentum aliquet 
// nibh. Integer sed finibus tellus, vel laoreet mi. Donec vehicula ligula non 
// neque scelerisque vulputate eget ut dui. Proin mattis ante vitae mi egestas 
// blandit. Sed a lobortis magna.

// Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec imperdiet
//  lorem sapien, bibendum interdum augue suscipit nec. Phasellus rhoncus 
//  auctor rhoncus. Nulla facilisi. Nam egestas augue est, a luctus erat 
//  condimentum vel. Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
//  Suspendisse varius ac mi vel mattis. Nullam tristique rhoncus elit, non 
//  maximus risus hendrerit a. Proin dictum tortor quis iaculis congue. 
//  Quisque facilisis non nunc efficitur condimentum. Pellentesque condimentum 
//  ante ut leo dictum cursus. Praesent lacus sem, mattis quis nunc sit amet, 
//  convallis molestie risus.
// In non orci quis augue vehicula imperdiet. Ut a erat in ex congue bibendum 
// sit amet quis dui. Class aptent taciti sociosqu ad litora torquent per 
// conubia nostra, per inceptos himenaeos. Vivamus blandit mollis nisi eget 
// efficitur. Donec et rutrum sapien, ac iaculis mi. Phasellus molestie lacus 
// sapien. Morbi sem quam, malesuada eleifend augue tempus, rhoncus tempor 

// sem. Duis pulvinar ex elit, non dignissim ex sagittis quis. Vivamus pretium 
// congue enim ac finibus. Aliquam ut elit ac sem ornare hendrerit non ac 
// sapien. Nullam imperdiet viverra egestas. Donec et dignissim dui. Praesent 
// maximus, dolor a dignissim sagittis, nisi neque elementum magna, laoreet 
// varius felis erat a mauris. Phasellus ligula ante, efficitur vel imperdiet 
// vitae, porttitor eu magna.



// Fusce condimentum lacus vel eros aliquet, eu aliquet est hendrerit. 
// Vestibulum suscipit venenatis eleifend. Pellentesque sollicitudin malesuada 
// sapien, et imperdiet lacus viverra ut. Nulla gravida sapien in cursus 
// mollis. Quisque purus ligula, aliquet interdum augue non, fermentum aliquet 
// nibh. Integer sed finibus tellus, vel laoreet mi. Donec vehicula ligula non 
// neque scelerisque vulputate eget ut dui. Proin mattis ante vitae mi egestas 
// blandit. Sed a lobortis magna.

// Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec imperdiet
//  lorem sapien, bibendum interdum augue suscipit nec. Phasellus rhoncus 
//  auctor rhoncus. Nulla facilisi. Nam egestas augue est, a luctus erat 
//  condimentum vel. Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
//  Suspendisse varius ac mi vel mattis. Nullam tristique rhoncus elit, non 
//  maximus risus hendrerit a. Proin dictum tortor quis iaculis congue. 
//  Quisque facilisis non nunc efficitur condimentum. Pellentesque condimentum 
//  ante ut leo dictum cursus. Praesent lacus sem, mattis quis nunc sit amet, 
//  convallis molestie risus.