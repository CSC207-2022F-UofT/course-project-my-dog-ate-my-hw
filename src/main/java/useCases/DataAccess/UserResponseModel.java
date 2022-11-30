package useCases.DataAccess;
import entities.User;

import java.util.ArrayList;

public class UserResponseModel {
    //UserResponseModel
    private User user;
    private int points;
    //store the information in checklists in an ArrayList of ArrayList of Strings
    private ArrayList<ArrayList<String>> toDo;
    private ArrayList<ArrayList<String>> done;
    //store the information of pet
    private ArrayList<String> pet;
    //store the information of customizations
    private ArrayList<ArrayList<String>> customizations;

    //constructor
    public UserResponseModel(int points, ArrayList<ArrayList<String>> toDo, ArrayList<ArrayList<String>> done) {
        this.points = points;
        this.toDo = toDo;
        this.done = done;
    }

    public UserResponseModel(User user){
        this.user = user;
    }

    //setters and getters
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) { this.points=points; }

    public ArrayList<ArrayList<String>> getTodo() { return this.toDo; }

    public void setTodo(ArrayList<ArrayList<String>> todo) {
        this.toDo = todo;
    }

    public ArrayList<ArrayList<String>> getDone() { return this.done; }

    public void setDone(ArrayList<ArrayList<String>> done) {
        this.done = done;
        }
}
