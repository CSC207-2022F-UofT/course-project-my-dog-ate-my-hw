package useCases;

public class User extends entities.User{

    private static User user = null;
    private static MainOutputBoundary MainUI = null;

    private User(int n, entities.Pet P){
        super(n, P);
    }

    private User(entities.User user){super(user.getPoints(), user.getPet(), user.getToDo(), user.getDone());}

    public static void declare(entities.User u){
        user = new User(u);
    }

    public static void declareUI(MainOutputBoundary m){MainUI = m; }

    public static User u(){
        return user;
    }

    public static MainOutputBoundary UI(){return MainUI; }
}
