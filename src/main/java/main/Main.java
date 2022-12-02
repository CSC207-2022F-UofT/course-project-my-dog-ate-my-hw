package main;

import ui.MainUI;
import useCases.User;

public class Main {

    public static void main(String[] args) {
        entities.Pet p = new entities.Pet("a", null);
        User.declare(new entities.User(0, p));
        MainUI.start(User.u());
    }
}
