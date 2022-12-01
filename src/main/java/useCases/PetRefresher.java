package useCases;

public class PetRefresher implements Refresher {
    public void refresh(){
        MainOutputBoundary m = User.UI();
        m.getPetOutputBoundary().loadPet(new PetUI(User.u().getPet()));
    }
}
