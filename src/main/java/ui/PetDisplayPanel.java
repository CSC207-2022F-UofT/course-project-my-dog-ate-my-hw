package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PetDisplayPanel extends JPanel{

    // STATIC VARIABLES //
    private static final Dimension preferredSize = new Dimension(410, 422);
    private static final Dimension petDimensions = new Dimension(410,410);
    private static final int imageBorderSpace = 15;

    //INSTANCE VARIABLES //
    private JLabel petImage;
    private Button adoptButton;

    // METHODS //
    public void createPetPanel(String skin, String currentEquipment, int currHealth, boolean adopted) {
        format();
        if(adopted) {
            createPetDisplay(skin, currentEquipment, currHealth);
        }
        else{
            createAdoptDisplay();
        }
    }

    /**
     * Displays the User's pet as a JLabel
     * @param skin
     */
    private void createPetDisplay(String skin, String currentEquipment, int currhealth){
        // Get the string for customizations
        String customization = "";
        if(!currentEquipment.equals("None")){
            customization = currentEquipment;
        }
        // get string for health status
        String status = "";
        if(currhealth == 0){
            status = "dead";
        }

        String path = "src/main/resources/petIcons/" + skin + customization + status + ".PNG";

        petImage = makePetJLabel(getPetImage(path));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(imageBorderSpace, imageBorderSpace, imageBorderSpace, imageBorderSpace);
        c.anchor = GridBagConstraints.CENTER;
        add(petImage);
    }

    /**
     * If user has adopted no pet, adopt button will appear in place of pet
     */
    private void createAdoptDisplay(){
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        ButtonBuilder builder = new ButtonBuilder();
        adoptButton = builder.buildAdoptButton(UIFormat.LIGHT_GREEN, Color.WHITE, "Adopt Pet");
        this.add(adoptButton, c);
    }

    /**
     * Gets a pet ImageIcon from the given file path
     * @param path a string which marks the location and name of the pet image
     * @return returns an ImageIcon
     */
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

    /**
     * Makes a JLabel with the correct sizing from an ImageIcon
     * @param icon the icon being added to the JLabel
     * @return the new JLabel
     */
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
