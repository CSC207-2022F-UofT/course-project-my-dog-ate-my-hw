package database;

import java.time.LocalDateTime;

public class DataLogger {
    UserDB user;

    public DataLogger(){
        this.user = new UserDB();
    }

    public void makeUser(){this.user = new UserDB();}

    public void setPoints(int points){
        this.user.points = points;
    }

    public void makePet(int curr, String name, String skin){
        this.user.myPet.curr = curr;
        this.user.myPet.name = name;
        this.user.myPet.skin = skin;
    }

    public void addCustomization(String name, String type, int price, boolean unlocked, String icon){
        this.user.myPet.customization.customizations.add(new ItemDB(name, type, price, unlocked, icon));
    }

    public void setEquip(String name, String type, int price, boolean unlocked, String icon){
        this.user.myPet.customization.current_equipment = new ItemDB(name, type, price, unlocked, icon);
    }

    public void addTodo(LocalDateTime deadline, String name, String course, String priorityString, boolean completion,
                        String assignmentTypeString){
        this.user.todo.add(new TaskDB(deadline, name, course, priorityString, completion, assignmentTypeString));
    }

    public void addDone(LocalDateTime deadline, String name, String course, String priorityString, boolean completion,
                        String assignmentTypeString){
        this.user.done.add(new TaskDB(deadline, name, course, priorityString, completion, assignmentTypeString));
    }

    public void saveUser(){
        DataSaver.saveUser(this.user);
    }

}
