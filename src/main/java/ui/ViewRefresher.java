package ui;

import presenters.PetVM;
import presenters.TaskVM;
import presenters.ViewRefresherBoundary;

public class ViewRefresher implements ViewRefresherBoundary{

    public PetVM pet;
    public TaskVM[] tasks;

    private static MainUI2 mainUI;

    public static void setMainUI(MainUI2 main){mainUI = main;}

    public void refresh(PetVM pet, TaskVM[] tasks){
        this.pet = pet;
        this.tasks = tasks;
        refresh(pet.currHealth,
                pet.maxHealth,
                pet.skin,
                pet.name,
                pet.points,
                pet.customizations,
                pet.currCustomization,
                pet.adopted,
                tasks);
    }

    public void refresh(TaskVM[] tasks){
        refresh(pet, tasks);
    }

    public void refresh(PetVM pet){
        refresh(pet, tasks);
    }

    public void refresh(int currHealth, int maxHealth, String skin, String petName, int points, String[] customizations, String currCustomization, boolean petAdopted, presenters.TaskVM[] tasks){
        mainUI.refresh(currHealth, maxHealth, skin, petName, points, customizations, currCustomization, petAdopted, tasks);
    }
}
