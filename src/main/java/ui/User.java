package ui;

import javax.swing.*;

public interface User {
    void adoptPet(ImageIcon petIcon, String petName);

    Pet getPetUI();
}
