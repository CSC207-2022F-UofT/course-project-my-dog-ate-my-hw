package useCases;

public class PetRefresher{
    public void refresh(){
        MainOutputBoundary m = UserUC.UI();
        m.getPetOutputBoundary().loadPet(new PetUIDS(UserUC.u().getPet()));
        SaveUserUC.saveUser(UserUC.u());
    }
}
