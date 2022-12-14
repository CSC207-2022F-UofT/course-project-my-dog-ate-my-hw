package useCases.interactors;

import entities.User;
import useCases.outputBoundaries.MainOutputBoundary;

/**
 * A User Use-Case Interactor
 */
public class UserUC extends User{

    private static UserUC user = null;
    private static MainOutputBoundary MainUI = null;

    private UserUC(User user) {
        super(user.getPoints(), user.getPet(), user.getToDo(), user.getDone());
    }

    public static void declare(User u){
        user = new UserUC(u);
    }

    public static void declareUI(MainOutputBoundary m){MainUI = m;}

    public static UserUC u(){
        return user;
    }

    public static MainOutputBoundary UI(){return MainUI;}
}
