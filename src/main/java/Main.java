import controllers.*;
import database.UserDB;
import database.PetDB;
import database.CustomizationDB;
import entities.Pet;
import entities.User;
import presenters.MainViewUpdater;
import presenters.PetUpdater;
import presenters.TasklistUpdater;
import ui.MainUI2;
import ui.ViewRefresher;
import useCases.*;

import javax.swing.*;

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
        mainUI = new MainUI2(DefaultValueData.DEFAULT_HEALTH, Pet.getMaxHealth(), DefaultValueData.DEFAULT_SKIN, DefaultValueData.DEFAULT_NAME, DefaultValueData.DEFAULT_POINTS, DefaultValueData.DEFAULT_CUSTOMS, DefaultValueData.DEFAULT_CURR_CUSTOM, false, null);
        injectDepend();
        initializeUser();
    }

    private static void initializeUser(){
        User loadedUser = LoadUserUC.loadUser();
        UserUC.declare(loadedUser);
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

        ViewRefresher vr = new ViewRefresher();
        ViewRefresher.setMainUI(mainUI);
        PetUpdater.setViewRefresher(vr);
        TasklistUpdater.setViewRefresher(vr);
    }
}
