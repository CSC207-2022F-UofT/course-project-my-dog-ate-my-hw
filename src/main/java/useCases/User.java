package useCases;

import ui.Pet;

public class User extends entities.User implements ui.User{

    private static User user = null;

    private User(int n, entities.Pet P){
        super(n, P);
    }

    public static void declare(int n, entities.Pet P){
        user = new User(n, P);
    }

    public static User u(){
        return user;
    }

    public ui.Pet getPetUI(){
        return Pet(user.getPet());
    }
}
