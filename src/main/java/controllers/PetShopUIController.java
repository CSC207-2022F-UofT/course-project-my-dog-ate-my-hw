package controllers;

import ui.User;
import useCases.AdoptPetUC;

import javax.swing.*;

public class PetShopUIController {

    public void performPetAdoption(String skin, String petName){
        AdoptPetUC uc = new AdoptPetUC();
        uc.adoptPet(skin, petName);
    }
}
