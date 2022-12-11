import controllers.*;
import entities.Pet;
import entities.User;
import presenters.MainViewUpdater;
import presenters.PetUpdater;
import presenters.TaskVM;
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
        String[] s = {"None", "Halo"};
        String[] t = new String[0];
        MainViewUpdater m = new MainViewUpdater();
        UserUC.declareUI(m);
        mainUI = new MainUI2(0, 0, "", "", 0, s, "", false, null);
        injectDepend();
        initializeUser();
    }


    private static void initializeUser(){
        entities.User user = new User();
        UserUC.declare(user);
    }
    private static void injectDepend(){
        BuyHeartController.setUc(new BuyHeartUC());
        CompleteTaskController.setUc(new CompleteTaskUC());
        CreateTaskController.setUc(new CreateTaskUC());
        ModifyTaskController.setUc(new ModifyTaskUC());
        PetShopUIController.setUc(new AdoptPetUC());
        RouletteController.setUc(new RouletteUC());
        SeeDoneController.setUc(new SeeDoneUC());
        SeeToDoController.setUc(new SeeToDoUC());

        ViewRefresher vr = new ViewRefresher();
        ViewRefresher.setMainUI(mainUI);
        PetUpdater.setViewRefresher(vr);
        TasklistUpdater.setViewRefresher(vr);
    }
}
