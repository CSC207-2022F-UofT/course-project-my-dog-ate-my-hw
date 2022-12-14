package useCases;

public class PetRefresher{
    public void refresh(){
        MainOutputBoundary m = UserUC.UI();
        m.getPetOutputBoundary().loadPet(new PetUIDS(UserUC.u().getPet(), UserUC.u()));
        SaveUserUC.saveUser(UserUC.u());
    }
}
