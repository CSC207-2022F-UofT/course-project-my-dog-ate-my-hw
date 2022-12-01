package presenters;

import useCases.MainOutputBoundary;

public class MainPresenter implements MainOutputBoundary {
    PetPresenter petPresenter;

    public PetPresenter getPetOutputBoundary() {
        return petPresenter;
    }

}
