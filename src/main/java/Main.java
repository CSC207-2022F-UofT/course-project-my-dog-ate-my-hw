import controllers.*;
import database.UserDB;
import database.PetDB;
import database.CustomizationDB;
import entities.*;
import presenters.MainViewUpdater;
import presenters.PetUpdater;
import presenters.TaskVM;
import presenters.TasklistUpdater;
import ui.MainUI2;
import ui.ViewRefresher;
import useCases.*;
import database.DataLogger;
import useCases.interactors.*;

import javax.swing.*;
import java.util.List;

public class Main {

    static MainUI2 mainUI;
    public static void main(String[] args) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());

        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        MainViewUpdater m = new MainViewUpdater();
        UserUC.declareUI(m);

        injectDepend();

        User loadedUser = LoadUserUC.loadUser();
        Pet loadedPet = loadedUser.getPet();

        UserUC.declare(loadedUser);

        if (loadedPet == null) {
            mainUI = new MainUI2(
                    DefaultValueData.DEFAULT_HEALTH,
                    Pet.getMaxHealth(),
                    DefaultValueData.DEFAULT_SKIN,
                    DefaultValueData.DEFAULT_NAME,
                    DefaultValueData.DEFAULT_POINTS,
                    DefaultValueData.DEFAULT_CUSTOMS,
                    DefaultValueData.DEFAULT_CURR_CUSTOM,
                    false,
                    null);
        }
        else {

            List<Task> taskList = loadedUser.getToDo().getTaskList();
            TaskVM[] tasks = new TaskVM[taskList.size()];
            for (int i = 0; i < taskList.size(); i++){
                TaskUIDS taskUIDS = new TaskUIDS(taskList.get(i));
                tasks[i] = new TaskVM(taskUIDS);
            }

            mainUI = new MainUI2(
                    loadedPet.getCurrHealth(),
                    Pet.getMaxHealth(),
                    loadedPet.getSkin(),
                    loadedPet.getName(),
                    loadedUser.getPoints(),
                    loadedPet.getCustomizations().toStringArray(),
                    loadedPet.getCustomizations().getCurrentEquipment().getName(),
                    true,
                    tasks
            );
        }

        initializeViewRefresher();

        Runtime.getRuntime().addShutdownHook(new Thread(SaveUserUC::saveUser));
    }

    private static void injectDepend(){
        BuyHeartController.setUc(new BuyHeartUC());
        BuyItemController.setUc(new BuyItemUC());
        CompleteTaskController.setUc(new CompleteTaskUC());
        CreateTaskController.setUc(new CreateTaskUC());
        ModifyTaskController.setUc(new ModifyTaskUC());
        PetShopUIController.setUc(new AdoptPetUC());
        RouletteController.setUc(new RouletteUC());
        SeeDoneController.setUc(new SeeDoneUC());
        SeeToDoController.setUc(new SeeToDoUC());
        LoadUserUC.setCDB(new CustomizationDB());
        LoadUserUC.setPDB(new PetDB());
        LoadUserUC.setUDB(new UserDB());
        SaveUserUC.setDl(new DataLogger());
    }

    private static void initializeViewRefresher(){
        ViewRefresher vr = new ViewRefresher();
        ViewRefresher.setMainUI(mainUI);
        PetUpdater.setViewRefresher(vr);
        TasklistUpdater.setViewRefresher(vr);
    }
}
