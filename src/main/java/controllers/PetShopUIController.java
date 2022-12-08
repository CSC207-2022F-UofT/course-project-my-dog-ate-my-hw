package controllers;


import useCases.AdoptPetUC;

public class PetShopUIController {

    public void performPetAdoption(String skin, String petName){
        AdoptPetUC uc = new AdoptPetUC();
        uc.adoptPet(skin, petName);
    }
}
