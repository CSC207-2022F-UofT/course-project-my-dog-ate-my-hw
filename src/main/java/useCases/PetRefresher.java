package useCases;

public class PetRefresher{
    public void refresh(){
        MainOutputBoundary m = UserUC.UI();
        PetUIDS petUIDS = new PetUIDS(UserUC.u().getPet());
        m.getPetOutputBoundary().loadPet(petUIDS);
    }
}
