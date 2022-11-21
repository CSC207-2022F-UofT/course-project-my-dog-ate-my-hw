package useCases;

import ui.*;
import entities.*;

public class Main {

    public static User user;

    public static void main(String[] args){
        entities.Pet p = new entities.Pet("a", null, null);
        user = new User(0, p);
        MainUI.start(user);
    }
}
