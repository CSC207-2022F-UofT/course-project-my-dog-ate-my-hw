package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainPetDisplay extends JPanel {

    /* STATIC VARIABLES */
    private static final Dimension heartDimensions = new Dimension(40,40);
    private static final Dimension petDimensions = new Dimension(410,410);
    private static final Dimension fillerDimensions = new Dimension(14,40);

    /* INSTANCE VARIABLES */
    private ImageIcon heartIcon;
    private ImageIcon brokenHeartIcon;
    private JLabel petImage;
    private JPanel healthBar;
    User user;

    public MainPetDisplay(User user){
        this.user = user;
        this.healthBar = new JPanel();
        loadHeartIcon();
        loadBrokenHeartIcon();

    }

    /* GETTERS AND SETTERS */
    public JPanel getHealthBar() {
        return healthBar;
    }

    /* METHODS */
    public void createHealthBar(){
        //replace with presenter
        int health = user.getPetUI().getCurrHealth();
        int maxHealth = user.getPetUI().getMaxHealthUI();

        healthBar.setLayout(new BoxLayout(healthBar, BoxLayout.LINE_AXIS));
        healthBar.setBorder(UIFormat.panelBorder);
        healthBar.setBackground(UIFormat.SIDE_PANEL_BACKGROUND);
        healthBar.add(new Box.Filler(fillerDimensions, fillerDimensions, fillerDimensions));

        for (int i = 0; i < maxHealth; i++){
            if(i < health){
                healthBar.add(makeHeartLabel(heartIcon));
            } else {
                healthBar.add(makeHeartLabel(brokenHeartIcon));
            }
        }
    }


    private void loadHeartIcon() {
        File f = new File("src/main/resources/miscAssets/heart.png");
        heartIcon = convertFileToHeartIcon(f);
    }

    private void loadBrokenHeartIcon(){
        File f = new File("src/main/resources/miscAssets/broken.png");
        brokenHeartIcon = convertFileToHeartIcon(f);
    }
    private ImageIcon convertFileToHeartIcon(File f){
        ImageIcon icon;
        try {
            Image image = ImageIO.read(f);
            icon = new ImageIcon(image.getScaledInstance(heartDimensions.width, heartDimensions.height, Image.SCALE_SMOOTH));
            icon.setDescription("heart");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return icon;

    }

    private JLabel makeHeartLabel(ImageIcon icon){
        JLabel label = new JLabel(icon);
        label.setMinimumSize(heartDimensions);
        return label;
    }

    public ImageIcon getPetImage(String path){
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

}
