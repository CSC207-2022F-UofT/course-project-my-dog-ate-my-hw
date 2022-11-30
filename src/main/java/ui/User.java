package ui;

public class User {

    private int points;
    private Pet myPet;
    private ToDoList todo;
    private DoneList done;

    User(int points, Pet myPet, ToDoList todo, DoneList done){
        this.points = points;
        this.myPet = myPet;
        this.todo = todo;
        this.done = done;
    }
}
