package useCases;

import databaseBoundaries.DataLoggerBoundary;
import entities.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * This UC saves the User
 */
public class SaveUserUC {

    private static DataLoggerBoundary dl;

    /**
     * Setter for the DataLoggerBoundary
     * @param dl DataLoggerBoundary
     */
    public static void setDl(DataLoggerBoundary dl) {
        SaveUserUC.dl = dl;
    }

    /**
     * If no User object is provided, saveUser will
     * call the UserUC for a User object
     */
    public void saveUser(){
        this.saveUser(UserUC.u());
    }

    /**
     * SaveUser calls the DataLoggerBoundary to create
     * a serializable UserDB object. The points, Pet,
     * Customization, DoneList, and ToDoList are set,
     * and DataSaver saves the data in a file.
     * @param user the User object to be saved
     */
    public void saveUser(entities.User user){
        // Create the User object to save
        dl.makeUser();

        // Set the points
        dl.setPoints(user.getPoints());

        // Get the Pet object
        entities.Pet pet = user.getPet();

        // Create the Pet object to save
        dl.makePet(pet.getCurrHealth(), pet.getName(), pet.getSkin());

        // Get and create the Customization object
        ArrayList<entities.Item> customizations = pet.getCustomization().possibleCustomizations();
        for (entities.Item item : customizations){
            dl.addCustomization(
                    item.getName(),
                    item.getType(),
                    item.getPrice(),
                    item.isUnlocked(),
                    item.getIcon()
            );
        }

        // Get and crete the DoneList object
        ArrayList<entities.Task> doneList = user.getDone().getTaskList();
        for (entities.Task task : doneList){
            dl.addDone(
                    task.getDeadline(),
                    task.getName(),
                    task.getCourse(),
                    task.getPriority().toString(),
                    task.isCompletion(),
                    task.getAssignmentType().toString()
            );
        }

        // Get and create the ToDoList object
        List<Task> toDoList = user.getToDo().getTaskList();
        for (entities.Task task : toDoList){
            dl.addTodo(
                    task.getDeadline(),
                    task.getName(),
                    task.getCourse(),
                    task.getPriority().toString(),
                    task.isCompletion(),
                    task.getAssignmentType().toString()
            );
        }

        // Get and Equip the currentEquipment, if it exists
        if (user.getPet().getCustomization().currentEquipment != null) {
            entities.Item currentItem = user.getPet().getCustomization().currentEquipment;
            dl.setEquip(
                    currentItem.getName(),
                    currentItem.getType(),
                    currentItem.getPrice(),
                    currentItem.isUnlocked(),
                    currentItem.getIcon()
            );
        }

        // Save all objects
        dl.saveUser();
    }

}
