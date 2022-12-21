package useCases.interactors;

import database.ItemDB;
import database.TaskDB;
import database.UserDB;
import databaseBoundaries.DataLoggerBoundary;
import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

/*
Test cases for SaveUserUC and LoadUserUC
Used DataLoggerFaker to avoid changing to the main database
Code Coverage:
SaveUserUC: 66% methods, 97% lines covered
LoadUserUC: 100% methods, 84% lines covered
 */
public class SaveAndLoadUserUCTest {
    DataLoggerFaker dataLogger;
    Pet pet;
    User user;
    Customization customization;
    Item item1;
    Item item2;
    Item item3;
    UserDB userDB;
    Task task1;
    LocalDateTime time;

    @BeforeEach
    public void Setup() {
        dataLogger = new DataLoggerFaker();
        customization = new Customization();
        pet = new Pet("dog", null);
        item1 = new Item("Hat", "Straw Hat", 3, "icon",false);
        item2 = new Item("Hat", "Cap", 5, "icon",false);
        item3 = new Item("Hat", "Baseball Cap", 1, "icon",true);
        customization.addItem(item1);
        customization.addItem(item2);
        customization.addItem(item3);
        pet.setCustomization(customization);
        user = new User(4, pet, new ToDoList(), new DoneList());
        time = LocalDateTime.now().plusDays(5);
        task1 = new Task("task1", "csc207", time, Priority.HIGH, AssignmentType.ESSAY);
    }

    /*
    Test saving the user with pet
     */
    @Test
    public void SaveUserTest() {
        SaveUserUC.setDl(dataLogger);
        SaveUserUC.saveUser(user);
        userDB = dataLogger.user;
        Assertions.assertEquals(userDB.points, user.getPoints());
    }

    /*
    Test saving user with ToDoList
     */
    @Test
    public void SaveUserTest2() {
        ToDoList toDoList = new ToDoList();
        toDoList.addTask(task1);
        user = new User(4, pet, toDoList, new DoneList());
        SaveUserUC.setDl(dataLogger);
        SaveUserUC.saveUser(user);
        userDB = dataLogger.user;
        Assertions.assertFalse(userDB.getToDo().isEmpty());
    }

    /*
    Test saving user with DoneList
     */
    @Test
    public void SaveUserTest3() {
        DoneList doneList = new DoneList();
        doneList.addTask(task1);
        user = new User(4, pet, new ToDoList(), doneList);
        SaveUserUC.setDl(dataLogger);
        SaveUserUC.saveUser(user);
        userDB = dataLogger.user;
        Assertions.assertFalse(userDB.getDone().isEmpty());
    }

    /*
    Test saving a user with equipment item for pet
     */
    @Test
    public void SaveEquipmentTest() {
        customization.equip(item3);
        SaveUserUC.setDl(dataLogger);
        SaveUserUC.saveUser(user);
        userDB = dataLogger.user;
        Assertions.assertEquals(userDB.getPet().getCustomization().getCurrentEquipment().getName(), item3.getName() );
    }

    /*
    Test Loading the user
     */
    @Test
    public void LoadUserTest() {
        customization.equip(item3);
        SaveUserUC.setDl(dataLogger);
        SaveUserUC.saveUser(user);
        userDB = dataLogger.user;
        LoadUserUC.setUDB(userDB);
        LoadUserUC.setCDB(userDB.getPet().getCustomization());
        LoadUserUC.setPDB(userDB.getPet());
        User user1 = LoadUserUC.loadUser();
        Assertions.assertEquals(user1.getPoints(), user.getPoints());
        Assertions.assertEquals(user1.getPet().getName(), pet.getName());
    }

    /*
    Test loading the ToDoList
     */
    @Test
    public void LoadTodoTest() {
        ToDoList toDoList = new ToDoList();
        toDoList.addTask(task1);
        user = new User(4, pet, toDoList, new DoneList());
        SaveUserUC.setDl(dataLogger);
        SaveUserUC.saveUser(user);
        userDB = dataLogger.user;
        LoadUserUC.setUDB(userDB);
        LoadUserUC.setCDB(userDB.getPet().getCustomization());
        LoadUserUC.setPDB(userDB.getPet());
        User user1 = LoadUserUC.loadUser();
        Assertions.assertFalse(user1.getToDo().getTaskList().isEmpty());
    }

    /*
    Test loading the DoneList
     */
    @Test
    public void LoadDoneTest() {
        DoneList doneList = new DoneList();
        doneList.addTask(task1);
        user = new User(4, pet, new ToDoList(), doneList);
        SaveUserUC.setDl(dataLogger);
        SaveUserUC.saveUser(user);
        userDB = dataLogger.user;
        LoadUserUC.setUDB(userDB);
        LoadUserUC.setCDB(userDB.getPet().getCustomization());
        LoadUserUC.setPDB(userDB.getPet());
        User user1 = LoadUserUC.loadUser();
        Assertions.assertFalse(user1.getDone().getTaskList().isEmpty());
    }

    /*
    Test SetPriority for task1
     */
    @Test
    public void setPriorityTest() {
        LoadUserUC.setPriority(task1, String.valueOf(Priority.HIGH));
        Assertions.assertEquals(task1.getPriority(), Priority.HIGH);
    }

    /*
    Test SetAssignmentType for task1
     */
    @Test
    public void setAssignmentTypeTest() {
        LoadUserUC.setAssignmentType(task1, String.valueOf(AssignmentType.EXAM));
        Assertions.assertEquals(task1.getAssignmentType(), AssignmentType.EXAM);
    }

    /*
    A fake implementation of DataLoggerBoundary for testing
     */
    public static class DataLoggerFaker implements DataLoggerBoundary {
        public UserDB user;

        /**
         * Constructor
         */
        public DataLoggerFaker(){
            this.user = new UserDB();
        }

        /**
         * Create UserDB object
         */
        public void makeUser(){this.user = new UserDB();}

        /**
         * A Setter for points
         * @param points the number of points the user has
         */
        public void setPoints(int points){
            this.user.points = points;
        }

        /**
         * Create PetDB object
         * @param currHealth the currentHealth
         * @param name the name of the pet
         * @param skin the skinID of the pet
         */
        public void makePet(int currHealth, String name, String skin){
            this.user.myPet.currHealth = currHealth;
            this.user.myPet.name = name;
            this.user.myPet.skin = skin;
        }

        /**
         * Create ItemDB object for customizations
         * @param name the name of the item
         * @param type the type of the item
         * @param price the price of the item
         * @param unlocked the lock-status of the item
         * @param icon the iconID of the item
         */
        public void addCustomization(String name, String type, int price, boolean unlocked, String icon){
            this.user.myPet.customization.customizations.add(new ItemDB(name, type, price, unlocked, icon));
        }

        /**
         * Create currentEquipment object for Customization
         * @param name the name of the current item
         * @param type the type of the current item
         * @param price the price of the current item
         * @param unlocked the lock-status of the current item
         * @param icon the iconID of the current item
         */
        public void setEquip(String name, String type, int price, boolean unlocked, String icon){
            this.user.myPet.customization.currentEquipment = new ItemDB(name, type, price, unlocked, icon);
        }

        /**
         * Create a Task object for ToDoList
         * @param deadline the deadline for the task
         * @param name the name of the task
         * @param course the task course
         * @param priorityString the priority of the course (HIGH, MEDIUM, or LOW)
         * @param completion the completion-status of the course
         * @param assignmentTypeString the assignment type of the course (see AssignmentType enum)
         */
        public void addToDo(LocalDateTime deadline, String name, String course, String priorityString, boolean completion,
                            String assignmentTypeString){
            this.user.toDo.add(new TaskDB(deadline, name, course, priorityString, completion, assignmentTypeString));
        }

        /**
         * Create a Task object for DoneList
         * @param deadline the deadline for the task
         * @param name the name of the task
         * @param course the task course
         * @param priorityString the priority of the course (HIGH, MEDIUM, or LOW)
         * @param completion the completion-status of the course
         * @param assignmentTypeString the assignment type of the course (see AssignmentType enum)
         */
        public void addDone(LocalDateTime deadline, String name, String course, String priorityString, boolean completion,
                            String assignmentTypeString){
            this.user.done.add(new TaskDB(deadline, name, course, priorityString, completion, assignmentTypeString));
        }

        /**
         * Save the constructed UserDB object by calling DataSaver.saveUser()
         */
        public void saveUser(){

        }
    }
}
