package ui;

import javax.swing.*;

public interface User {
    void adoptPet(String petIcon, String petName);

    Pet getPetUI();
}
