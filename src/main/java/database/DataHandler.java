package database;

import entities.*;
import useCases.DataAccess.UserDataInterface;

import javax.swing.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataHandler implements UserDataInterface {

    private final File txtFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private User user = new User();
    private int points = user.getPoints();
    private ToDoList toDoList = new ToDoList();
    private DoneList doneList = new DoneList();

    /**
     * reads data from a txt file
     * @param txtPath The path of the txt file.
     * @throws IOException
     */
    public DataHandler(String txtPath) throws IOException {
        txtFile = new File(txtPath);
        ToDoList todo = new ToDoList();
        DoneList done = new DoneList();
        Customization customization = new Customization();

        if (txtFile.length() == 0) {
            save(new User());
        } else {
            BufferedReader reader = new BufferedReader(new FileReader(txtFile));
            reader.readLine();

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String header = String.valueOf(col[0]);
                switch (header) {
                    case "points":
                        user.setPoints(Integer.parseInt(col[1]));
                    case "todo":
                        //input tasks in the order: name, course, deadline, priority, studyTechniques, assignType
                        String name = String.valueOf(col[1]);
                        String course = String.valueOf(col[2]);
                        String deadline = String.valueOf(col[3]);
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime deadLine = LocalDateTime.parse(deadline, formatter);
                        Priority priority = Priority.valueOf(String.valueOf(col[4]));
                        //creates customTask with the extra two entries
                        if (col.length > 5) {
                            String studyTechniques = String.valueOf(col[5]);
                            AssignmentType assignType = AssignmentType.valueOf(col[6]);
                            CustomTask task = new CustomTask(name, course, deadLine, priority, assignType, studyTechniques);
                            todo.addTask(task);
                        }
                        //creates Task
                        else {
                            Task task = new Task(name, course, deadLine, priority);
                            todo.addTask(task);
                        }
                    case "done":
                        //input tasks in the order: name, course, deadline, priority, studyTechniques, assignType
                        String name2 = String.valueOf(col[1]);
                        String course2 = String.valueOf(col[2]);
                        String deadline2 = String.valueOf(col[3]);
                        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime deadLine2 = LocalDateTime.parse(deadline2, formatter2);
                        Priority priority2 = Priority.valueOf(col[4]);
                        //creates customTask with the extra two entries
                        if (col.length > 5) {
                            String studyTechniques2 = String.valueOf(col[5]);
                            AssignmentType assignType2 = AssignmentType.valueOf(col[6]);
                            CustomTask task = new CustomTask(name2, course2, deadLine2, priority2, assignType2, studyTechniques2);
                            done.addTask(task);
                        }
                        //creates Task
                        else {
                            Task task = new Task(name2, course2, deadLine2, priority2);
                            done.addTask(task);
                        }
                    case "pet":
                        //Input pets in the order: name, skinFileName, currHealth
                        String petName = String.valueOf(col[1]);
                        String skinFileName = String.valueOf(col[2]);
                        ImageIcon skin = new ImageIcon(skinFileName);
                        int currHealth = Integer.parseInt(String.valueOf(col[3]));
                        Pet pet = new Pet(petName, skin, currHealth);
                        user.setPet(pet);
                    case "item":
                        //Input items in the order: type, name, price, iconFileName, unlocked, equipped
                        String type = String.valueOf(col[1]);
                        String itemName = String.valueOf(col[2]);
                        int price = Integer.parseInt(col[3]);
                        ImageIcon icon = new ImageIcon(String.valueOf(col[4]));
                        boolean unlocked = Boolean.parseBoolean(String.valueOf(col[5]));
                        boolean equipped = Boolean.parseBoolean(String.valueOf(col[6]));
                        Item item = new Item(type, itemName, price, icon, unlocked);
                        customization.addItem(item);
                        if (equipped) {
                            customization.equip(item);
                        }
                }

            }
            reader.close();
            user.getPet().setCustomization(customization);
        }
    }

    /**
     * save the data stored in user object to database
     */
    public void save(User user) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(txtFile));
            //write the points
            String line1 = String.format("%s,%s", "points", user.getPoints());
            writer.write(line1);
            writer.newLine();
            //write ToDoList
            for (Task task: user.getTodo().getTaskList()) {
                if (task instanceof CustomTask){
                    CustomTask customTask = (CustomTask) task;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    //input tasks in the order: name, course, deadline, priority, studyTechniques, assignType
                    String line = String.format("%s,%s,%s,%s,%s,%s,%s", "todo", customTask.getName(), customTask.getCourse(),
                                    customTask.getDeadline().format(formatter), customTask.getPriority(),
                                    customTask.getStudyTechniques(), customTask.getAssignmentType());
                    writer.write(line);
                }
                else {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    //input tasks in the order: name, course, deadline, priority, studyTechniques, assignType
                    String line = String.format("%s,%s,%s,%s,%s", "todo", task.getName(), task.getCourse(),
                            task.getDeadline().format(formatter), task.getPriority());
                    writer.write(line);
                }
                writer.newLine();
            }
            //write DoneList
            for (Task task: user.getDone().getTaskList()) {
                if (task instanceof CustomTask){
                    CustomTask customTask = (CustomTask) task;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    //input tasks in the order: name, course, deadline, priority, studyTechniques, assignType
                    String line = String.format("%s,%s,%s,%s,%s,%s,%s", "done", customTask.getName(), customTask.getCourse(),
                            customTask.getDeadline().format(formatter), customTask.getPriority(),
                            customTask.getStudyTechniques(), customTask.getAssignmentType());
                    writer.write(line);
                }
                else {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    //input tasks in the order: name, course, deadline, priority, studyTechniques, assignType
                    String line = String.format("%s,%s,%s,%s,%s", "done", task.getName(), task.getCourse(),
                            task.getDeadline().format(formatter), task.getPriority());
                    writer.write(line);
                }
                writer.newLine();
            }
            //write pet
            Pet pet = user.getPet();
            //Input pets in the order: name, skinFileName, currHealth
            String petLine = String.format("%s,%s,%s,%s", "pet", pet.getName(), pet.getSkin().toString(), pet.getCurrHealth());
            writer.write(petLine);
            writer.newLine();
            //write items
            for (Item item: pet.getCustomization().possibleCustomizations()) {
                //Input items in the order: type, name, price, iconFileName, unlocked, equipped
                boolean equipped = (item.equals(pet.getCustomization().currentEquipment()));
                String itemLine = String.format("%s,%s,%s,%s,%s,%s,%s","item",item.getType(),item.getName(), item.getPrice(),
                                    item.getIcon().toString(),item.isUnlocked(), equipped);
                writer.write(itemLine);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUser() {
        return this.user;
    }
}
