package entities;

//the user class stores all information needed for the user
public class User {


    private int points;
    private Pet myPet;
    private ToDoList todo;
    private DoneList done;

    // Default Constructor
    public User(){
        points = 0;
        myPet = null;
        todo = new ToDoList();
        done = new DoneList();
    }
    // For UserUC and loading saves
    public User(int points, Pet myPet, ToDoList todo, DoneList done){
        this.points = points;
        this.myPet = myPet;
        this.todo = todo;
        this.done = done;
    }


    // ==GETTERS==

    public int getPoints() {
        return points;
    }

    public Pet getPet() {
        return myPet;
    }

    public ToDoList getToDo() {
        return this.todo;
    }

    public DoneList getDone() {
        return this.done;
    }


    // ==SETTERS==

    public void setPoints(int points) {
        this.points = points;
    }


    // ==CLASS METHODS==

    /**
     * The user gains points based on the inputted number.
     *
     * @param points Number of points to add
     */
    public void gainPoints(int points) {
        this.points += points;
    }

    /**
     * The user loses points
     * If the user does not have enough points, returns a false boolean
     * If the user has enough points, returns true and deducts points
     *
     * @param points Points to lose
     * @return Boolean that represents whether the user has enough points to lose or not
     */
    public boolean losePoints(int points) {
        if (this.points < points) {
            return false;
        }
        this.points -= points;
        return true;
    }

    public void adpotPet(String name, String skin){
        if(myPet == null) {
            myPet = new Pet(name, skin);
        }
    }

    /**
     * Turn the user into a string
     *
     * @return A String that contains the user's points and pet's name
     */
    @Override
    public String toString() {
        return "User with points: " + this.points + ", Pet: " + this.myPet.getName();
    }
}