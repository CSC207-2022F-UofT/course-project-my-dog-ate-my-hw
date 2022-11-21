package ui;

import javax.swing.*;

public class PetShopUIController {

    User user;

    public PetShopUIController(User user){
        this.user = user;
    }
    public void performPetAdoption(ImageIcon petIcon, String petName){
        user.adoptPet(petIcon, petName);
    }
}
