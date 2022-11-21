package Database;
import Entities.User;

import java.io.*;

public class Savior {

    public static void save(Object o){
        try {
            FileOutputStream f = new FileOutputStream("./Saves/save.ser");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(o);
            out.close();
            f.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static User load(){
        User o = null;
        try{
            FileInputStream f = new FileInputStream("./Saves/save.ser");
            ObjectInputStream out = new ObjectInputStream(f);
            o = (User) out.readObject();
            out.close();
            f.close();
        }
        catch (IOException i){i.printStackTrace();}
        catch (ClassNotFoundException i){i.printStackTrace();}
        return o;
    }
}
