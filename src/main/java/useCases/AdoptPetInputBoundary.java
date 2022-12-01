package useCases;

import javax.swing.*;

public interface AdoptPetInputBoundary {

    void adoptPet(ImageIcon petIcon, String petName);

    void refreshPet();
}
