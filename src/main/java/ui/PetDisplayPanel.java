package ui;

import presenters.PetPresenter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PetDisplayPanel extends JPanel{

    // STATIC VARIABLES //
    private static final Dimension petDimensions = new Dimension(410,410);
    private static final int imageBorderSpace = 15;

    //INSTANCE VARIABLES //
    private final PetPresenter pet;
    private JLabel petImage;
    private Button adoptButton;

    public PetDisplayPanel(PetPresenter pet){
        this.pet = pet;
        this.setLayout(new GridBagLayout());
        //format self
    }

    // METHODS //

    public void createPetDisplay(){
        String path = "src/main/resources/petIcons/cow.jpeg"; //TODO: Make it check which pet user has
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(imageBorderSpace, imageBorderSpace, imageBorderSpace, imageBorderSpace);
        c.anchor = GridBagConstraints.CENTER;
        this.add(makePetJLabel(getPetImage(path)), c);
    }

    public void createAdoptDisplay(){
        //make and display adopt button
        //remove button from panel when done?
    }

    public void updatePetDisplay(){
        //do this
    }

    private ImageIcon getPetImage(String path) {
        //String path = "src/main/resources/petIcons/" + user.getPet().getSkin().getDescription();
        File f = new File(path);
        ImageIcon petImage;
        try {
            Image brokenImage = ImageIO.read(f);
            petImage = new ImageIcon(brokenImage.getScaledInstance(petDimensions.width, petDimensions.height,
                    Image.SCALE_SMOOTH));
            petImage.setDescription("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return petImage;
    }

    private JLabel makePetJLabel(ImageIcon icon){
        JLabel label = new JLabel(icon);
        label.setMinimumSize(petDimensions);
        return label;
    }
}
