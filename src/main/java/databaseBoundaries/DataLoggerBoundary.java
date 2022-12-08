package databaseBoundaries;

import java.time.LocalDateTime;

public interface DataLoggerBoundary {

    void makeUser();

    void setPoints(int points);

    void makePet(int currHealth, String name, String skin);

    void addCustomization(String name, String type, int price, boolean unlocked, String icon);

    void setEquip(String name, String type, int price, boolean unlocked, String icon);

    void addTodo(LocalDateTime deadline, String name, String course, String priorityString, boolean completion,
                 String assignmentTypeString);

    void addDone(LocalDateTime deadline, String name, String course, String priorityString, boolean completion,
                 String assignmentTypeString);

    void saveUser();

}
