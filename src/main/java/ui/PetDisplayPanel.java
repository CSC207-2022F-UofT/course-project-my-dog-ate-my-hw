package ui;

import viewModels.MainViewModel;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PetDisplayPanel extends JPanel{

    // STATIC VARIABLES //
    private static final Dimension preferredSize = new Dimension(410, 422);
    private static final Dimension petDimensions = new Dimension(410,410);
    private static final int imageBorderSpace = 15;

    //INSTANCE VARIABLES //
    MainViewModel viewModel;
    private JLabel petImage;
    private Button adoptButton;

    // METHODS //
    public void createPetPanel(String skin, boolean adopted) {
        format();
        if(adopted) {
            createPetDisplay(skin);
        }
        else{
            createAdoptDisplay();
        }
    }
    private void createPetDisplay(String skin){
        setLayout(new GridBagLayout());
        String path = "src/main/resources/petIcons/" + skin + ".PNG"; //TODO: add customization functionality
        petImage = makePetJLabel(getPetImage(path));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(imageBorderSpace, imageBorderSpace, imageBorderSpace, imageBorderSpace);
        c.anchor = GridBagConstraints.CENTER;
        add(petImage);
    }

    private void createAdoptDisplay(){

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        ButtonBuilder builder = new ButtonBuilder();
        Border b = BorderFactory.createBevelBorder(BevelBorder.RAISED, UIFormat.LIGHT_GREEN.brighter(), UIFormat.LIGHT_GREEN.darker());
        adoptButton = builder.buildAdoptButton(UIFormat.LIGHT_GREEN, Color.WHITE, b, "Adopt Pet");
        this.add(adoptButton, c);
    }

    private ImageIcon getPetImage(String path){
        File f = new File(path);
        ImageIcon petImage;
        try {
            Image brokenImage = ImageIO.read(f);
            petImage = new ImageIcon(brokenImage.getScaledInstance(petDimensions.width, petDimensions.height,
                    Image.SCALE_SMOOTH));
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

    private void format(){
        setBackground(UIFormat.BUTTON_PINK);
        setMinimumSize(preferredSize);
        setPreferredSize(preferredSize);

    }

}
