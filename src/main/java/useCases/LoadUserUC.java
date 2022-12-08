package useCases;

import databaseBoundaries.*;
import entities.*;

/**
 * This UC loads the user
 */
public class LoadUserUC {

    private static UserDBBoundary udb;
    private static PetDBBoundary pdb;
    private static CustomizationDBBoundary cdb;

    /**
     * Setter for the UserDBBoundary
     * @param udb UserDBBoundary
     */
    public static void setUDB(UserDBBoundary udb){
        LoadUserUC.udb = udb;
    }

    /**
     * Setter for the PetDBBoundary
     * @param pdb PetDBBoundary
     */
    public static void setPDB(PetDBBoundary pdb){
        LoadUserUC.pdb = pdb;
    }

    /**
     * Setter for the CustomizationDBBoundary
     * @param cdb CustomizationDBBoundary
     */
    public static void setCDB(CustomizationDBBoundary cdb){
        LoadUserUC.cdb = cdb;
    }

    /**
     * LoadUser loads the User object from the save file and returns it;
     * It calls upon the helper methods, LoadToDoList, LoadDoneList, and LoadPet.
     * @return The Loaded User Object
     */
    public static entities.User loadUser(){

        ToDoList toDoList = loadToDoList();
        DoneList doneList = loadDoneList();
        Pet pet = loadPet();

        return new entities.User(
                udb.getPoints(),
                pet,
                toDoList,
                doneList
        );
    }

    /**
     * LoadToDoList converts TaskDBBoundary objects to Task objects,
     * reading the Priority and AssignmentType as a String,
     * and then setting the Priority and AssignmentType enums via a switch,
     * before finally returning a ToDoList object
     * @return The Loaded ToDoList object
     */
    public static ToDoList loadToDoList() {

        // Create a new ToDoList object
        ToDoList toDoList = new ToDoList();

        // Loop through the loaded ToDoList
        for (TaskDBBoundary taskdb : udb.getTodo()) {

            // Create a Task object, with null Priority and AssignmentType
            entities.Task task = new Task(
                    taskdb.getName(),
                    taskdb.getCourse(),
                    taskdb.getDeadline(),
                    null,
                    null
            );

            // Assign Priority according to priorityString
            String priorityString = taskdb.getPriority();
            switch (priorityString) {
                case "HIGH":
                    task.setPriority(Priority.HIGH);
                    break;
                case "MEDIUM":
                    task.setPriority(Priority.MEDIUM);
                    break;
                case "LOW":
                    task.setPriority(Priority.LOW);
                    break;
            }

            // Assign AssignmentType according to assignmentString
            String assignmentString = taskdb.getAssignmentType();
            switch (assignmentString) {
                case "ESSAY":
                    task.setAssignmentType(AssignmentType.ESSAY);
                    break;
                case "QUIZ":
                    task.setAssignmentType(AssignmentType.QUIZ);
                    break;
                case "EXAM":
                    task.setAssignmentType(AssignmentType.EXAM);
                    break;
                case "LAB_REPORTS":
                    task.setAssignmentType(AssignmentType.LAB_REPORTS);
                    break;
                case "REFLECTION":
                    task.setAssignmentType(AssignmentType.REFLECTION);
                    break;
                case "PROJECT":
                    task.setAssignmentType(AssignmentType.PROJECT);
                    break;
            }

            // Add the Task object to the ToDoList
            toDoList.addTask(task);
        }

        // Return the ToDoList
        return toDoList;
    }

    /**
     * LoadDoneList converts TaskDBBoundary objects to Task objects,
     * reading the Priority and AssignmentType as a String,
     * and then setting the Priority and AssignmentType enums via a switch,
     * before finally returning a DoneList object
     * @return The Loaded DoneList object
     */
    public static DoneList loadDoneList() {

        // Create a new DoneList object
        DoneList doneList = new DoneList();

        // Loop through the loaded ToDoList
        for (TaskDBBoundary taskdb : udb.getDone()) {

            // Create a Task object, with null Priority and AssignmentType
            entities.Task task = new Task(
                    taskdb.getName(),
                    taskdb.getCourse(),
                    taskdb.getDeadline(),
                    null,
                    null
            );

            // Assign Priority according to priorityString
            String priorityString = taskdb.getPriority();
            switch (priorityString) {
                case "HIGH":
                    task.setPriority(Priority.HIGH);
                    break;
                case "MEDIUM":
                    task.setPriority(Priority.MEDIUM);
                    break;
                case "LOW":
                    task.setPriority(Priority.LOW);
                    break;
            }

            // Assign AssignmentType according to assignmentString
            String assignmentString = taskdb.getAssignmentType();
            switch (assignmentString) {
                case "ESSAY":
                    task.setAssignmentType(AssignmentType.ESSAY);
                    break;
                case "QUIZ":
                    task.setAssignmentType(AssignmentType.QUIZ);
                    break;
                case "EXAM":
                    task.setAssignmentType(AssignmentType.EXAM);
                    break;
                case "LAB_REPORTS":
                    task.setAssignmentType(AssignmentType.LAB_REPORTS);
                    break;
                case "REFLECTION":
                    task.setAssignmentType(AssignmentType.REFLECTION);
                    break;
                case "PROJECT":
                    task.setAssignmentType(AssignmentType.PROJECT);
                    break;
            }

            // Add the Task object to the DoneList
            doneList.addTask(task);
        }

        // Return the DoneList
        return doneList;
    }

    /**
     * LoadPet first loads the Customization, loading every
     * customization item into customizations and setting the
     * current equipment (if there is any). It then loads and
     * creates a Pet object, before returning it.
     * @return The Loaded Pet object
     */
    public static Pet loadPet() {

        // Create a new Customization object
        Customization customization = new Customization();

        // Loop through the loaded customizations
        for (ItemDBBoundary itemdb : cdb.getCustomizations()) {

            // Create an Item
            Item item = new Item(
                    itemdb.getType(),
                    itemdb.getName(),
                    itemdb.getPrice(),
                    itemdb.getIcon(),
                    itemdb.isUnlocked()
            );

            // Add the Item to customizations
            customization.addItem(item);
        }

        // Check to see if there is any currentEquipment,
        // if so, create a new Item and equip it
        if (cdb.getCurrentEquipment() != null) {
            Item customizationItem = new Item(
                    cdb.getCurrentEquipment().getType(),
                    cdb.getCurrentEquipment().getName(),
                    cdb.getCurrentEquipment().getPrice(),
                    cdb.getCurrentEquipment().getIcon(),
                    cdb.getCurrentEquipment().isUnlocked()
            );
            customization.equip(customizationItem);
        }

        // Create a new Pet object
        Pet pet = new Pet(
                pdb.getName(),
                pdb.getSkin()
        );

        // Set the Pet Customization
        pet.setCustomization(customization);

        // Return the Pet object
        return pet;
    }

}
