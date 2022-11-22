package presenters;

import java.util.ArrayList;

public class CompleteTaskResponseModel {
    private int points;
    //store the information in checklists in an ArrayList of ArrayList of Strings
    private ArrayList<ArrayList<String>> toDo;
    private ArrayList<ArrayList<String>> done;

    //constructor
    public CompleteTaskResponseModel(int points, ArrayList<ArrayList<String>> toDo, ArrayList<ArrayList<String>> done) {
        this.points = points;
        this.toDo = toDo;
        this.done = done;
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
