package useCases;

public class PetRefresher implements Refresher {
    public void refresh(){
        MainOutputBoundary m = UserUC.UI();
        m.getPetOutputBoundary().loadPet(new PetUIDS(UserUC.u().getPet()));
    }
}
