package ui;

import viewModels.MainViewModel;
import viewModels.ThemeFormat;
import viewModels.ViewFormattingData;

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
    MainViewModel viewModel;
    private JLabel petImage;
    private Button adoptButton;

    // METHODS //
    public void createPetPanel(String skin, boolean adopted) {
        if(adopted) {
            createPetDisplay(skin);
        }
        else{
            createAdoptDisplay();
        }
    }
    public void createPetDisplay(String skin){
        this.setLayout(new GridBagLayout());
        String path = "src/main/resources/petIcons/" + skin + ".PNG"; //TODO: add customization functionality
        petImage = makePetJLabel(getPetImage(path));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(imageBorderSpace, imageBorderSpace, imageBorderSpace, imageBorderSpace);
        c.anchor = GridBagConstraints.CENTER;
        this.add(petImage);
    }

    public void createAdoptDisplay(){
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        ButtonBuilder builder = new ButtonBuilder();
        ViewFormattingData format = viewModel.getAdoptButtonFormat();
        ThemeFormat theme = format.getThemeFormat();
        adoptButton = builder.buildAdoptButton(theme.getBackground(), theme.getTextColor(), theme.getBorder(), format.getText());
        this.add(adoptButton, c);
    }

    public void refresh(String skin){
        // TODO
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

}
