package ui;

import entities.User;
import Entities.Pet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainPetDisplay extends JPanel {

    private static final Dimension heartDimensions = new Dimension(20,20);
    JLabel petImage;
    JPanel healthBar;

    User user;

    public void createPetDisplay(){
        if (user.getPet() == null) {
            // Call pet shop displayer
            // call controller/use case to add pet to user
            int x = 1;
        }

        createHealthBar();

    }

    private void loadPetImage(){

    }
    private void createHealthBar(){
        healthBar = new JPanel();
        healthBar.setLayout(new BoxLayout(healthBar, BoxLayout.LINE_AXIS));
        int health = user.getPet().getCurrHealth();
        int maxHealth = Pet.getMaxHealth();
        ImageIcon heart = getHeartImage();
        ImageIcon brokenHeart = getBrokenHeartImage();


        for (int i = 0; i < maxHealth; i++){
            if(i < health){
                healthBar.add(new JLabel(heart));
            } else {
                healthBar.add(new JLabel(brokenHeart));
            }
        }

    }

    private ImageIcon getHeartImage(){
        File f = new File("src/main/resources/miscAssets/heart.png");
        ImageIcon heartIcon;
        try {
            Image heartImage = ImageIO.read(f);
            heartIcon = new ImageIcon(heartImage.getScaledInstance(heartDimensions.width, heartDimensions.height,
                    Image.SCALE_SMOOTH));
            heartIcon.setDescription("heart");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return heartIcon;
    }

    private ImageIcon getBrokenHeartImage(){
        File f = new File("src/main/resources/miscAssets/broken.png");
        ImageIcon brokenIcon;
        try {
            Image brokenImage = ImageIO.read(f);
            brokenIcon = new ImageIcon(brokenImage.getScaledInstance(heartDimensions.width, heartDimensions.height,
                    Image.SCALE_SMOOTH));
            brokenIcon.setDescription("heart");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return brokenIcon;
    }


    //MAIN FOR TESTING
    public static void main(String[] args) {
        Pet p = new Pet("billy", null, null);
        p.ouch(4);
        User u = new User(0, p);
        JFrame frame = new JFrame();
        MainPetDisplay m = new MainPetDisplay();
        m.user = u;
        m.createHealthBar();
        frame.add(m.healthBar);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
