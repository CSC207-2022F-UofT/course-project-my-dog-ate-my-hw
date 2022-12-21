package useCases;

public class PetRefresher{

    public void refresh(){
        MainOutputBoundary m = UserUC.UI();
        PetUIDS petUIDS = new PetUIDS(UserUC.u().getPet(), UserUC.u());
        m.getPetOutputBoundary().loadPet(petUIDS);
    }

}
