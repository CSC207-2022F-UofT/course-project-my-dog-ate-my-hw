package ui;

import presenters.PetVM;
import presenters.TaskVM;
import presenters.ViewRefresherBoundary;

public class ViewRefresher implements ViewRefresherBoundary{

    public PetVM pet;
    public TaskVM tasks;


    private static MainUI2 mainUI;

    public static void setMainUI(MainUI2 main){ mainUI = main;}

    public void refresh(int currHealth, int maxHealth, String skin, String petName, int points, String[] customizations, boolean petAdopted, presenters.TaskVM[] tasks){
        mainUI.createMainUI(currHealth, maxHealth, skin, petName, points, customizations, petAdopted, tasks);
    }
}
