package database;

import java.io.*;

/**
 * This class is for writing and reading the saved data from save.txt
 */
public class DataSaver {

    // The filename
    public static final String fileName = "src/main/java/database/save.txt";

    // Save User in fileName
    public static void saveUser(UserDB user){
        File f = new File(fileName);

        // Check if file exists
        if (!f.exists()) {
            try {
                // Create new file
                boolean createdNewFile = f.createNewFile();
                if (!createdNewFile) {
                    System.out.println("DataSaver: Could not make File.");
                    return;
                }
            } catch (IOException exp) {
                exp.printStackTrace();
                System.out.println("DataSaver: Could not make File.");
            }
        }

        try {
            // Write data into file
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName, false));
            out.writeObject(user);
            out.close();
        } catch (FileNotFoundException not){
            not.printStackTrace();
            System.out.println("DataSaver: Could not find File.");
        } catch (IOException exp){
            exp.printStackTrace();
        }
    }

    public static UserDB loadUser(){
        File f = new File(fileName);
        // Check if file exists
        if(!f.exists()){
            return null;
        }

        try{
            // Read file data
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName)); {
            return (UserDB) in.readObject();
        }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
