package controllers;


import useCases.AdoptPetInputBoundary;

public class PetShopUIController {
    private static AdoptPetInputBoundary uc;

    public static void setUc(AdoptPetInputBoundary useCase){
        uc = useCase;
    }
    public void performPetAdoption(String skin, String petName){
        uc.adoptPet(skin, petName);
        uc.refreshPet();
    }
}
