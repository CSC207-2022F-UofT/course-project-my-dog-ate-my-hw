package database;

import java.io.*;

public class DataSaver {

    public static final String fileName = "save.txt";

    public static void saveUser(UserDB user){
        File f = new File(fileName);
        if(!f.exists()){
            try {
                if(!f.createNewFile()){
                    System.out.println("DataSaver: Could not make File.");
                    return;
                }
            } catch (IOException exp) {
                exp.printStackTrace();
                System.out.println("DataSaver: Could not make File.");
            }
        }

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
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
        if(!f.exists()){
            return null;
        }

        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName)); {
            return (UserDB) in.readObject();
        }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
