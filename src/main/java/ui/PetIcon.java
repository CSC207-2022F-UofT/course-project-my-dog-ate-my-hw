package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class PetIcon {

    private final ImageIcon petIcon;

    /**
     * Constructs a PetIcon from the given url
     * @param url the URL from which the image is sourced
     */
    public PetIcon(String url) {
        try {
            URL petURL = new URL(url);
            Image petImage = ImageIO.read(petURL);
            petIcon = new ImageIcon(petImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ImageIcon getPetIcon() {
        return petIcon;
    }


}
