import java.util.*;


class Type{
    
    //I'm gonna look into making this easier to read -MD
    // private int[][] type = {
    //     {2, 2, 1, 1, 0, 0},     //0 = water, 1 = grass, 2 = fire, 3 = ground, 4 = electric, 5 = flying
    //     {1, 2, 2, 1, 0, 2},     //0 means neutral, 1 means super effective, 0.5 means not very effective, 0 means no effect
    //     {2, 1, 2, 0, 0, 0},     //type[attack][defend]
    //     {0, 2, 1, 0, 1, 3}, 
    //     {1, 0, 0, 3, 0, 1}, 
    //     {0, 1, 0, 0, 2, 0}
    // };

    // The order of appearance - from left to right / top to bottom
    // Normal, Fire, Water, Grass, Electric, Ice, Fighting, 
    //Poison, Ground, Flying, Psychic, Bug, Rock, Ghost, Dragon
    private double[][] type = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.5, 0, 1},      
        {1, 0.5, 0.5, 2, 1, 2, 1, 1, 1, 1, 1, 2, 0.5, 1, 0.5},     
        {1, 2, 0.5, 0.5, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 0.5},     
        {1, 0.5, 2, 0.5, 1, 1, 1, 0.5, 2, 0.5, 1, 0.5, 2, 1, 0.5},
        {1, 1, 2, 0.5, 0.5, 1, 1, 1, 0, 2, 1, 1, 1, 1, 0.5},
        {1, 0.5, 0.5, 2, 1, 0.5, 1, 1, 2, 2, 1, 1, 1, 1, 2},
        {2, 1, 1, 1, 1, 2, 1, 0.5, 1, 0.5, 0.5, 0.5, 2, 0, 1},
        {1, 1, 1, 2, 1, 1, 1, 0.5, 0.5, 1, 1, 1, 0.5, 0.5, 1},
        {1, 2, 1, 0.5, 2, 1, 1, 2, 1, 0, 1, 0.5, 2, 1, 1},
        {1, 1, 1, 2, 0.5, 1, 2, 1, 1, 1, 1, 2, 0.5, 1, 1},
        {1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 0.5, 1, 1, 1, 1},
        {1, 0.5, 1, 2, 1, 1, 0.5, 0.5, 1, 0.5, 2, 1, 1, 0.5, 1},
        {1, 2, 1, 1, 1, 2, 0.5, 1, 0.5, 2, 1, 2, 1, 1, 1},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}
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

    public double getEffectiveness(Type targetDEF) {        
        return type[typeNum][targetDEF.typeNum];
    }
    
    public void changeTypeNum(int i) {
        typeNum = i;
    }
    /* 
    public double isNotEffective(Pokemon ai, Pokemon user){
        int enemyType = ai.getPokeType().getTypeNum();
        int userType = user.getPokeType().getTypeNum();
        //return type[]
            
    }*/

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

