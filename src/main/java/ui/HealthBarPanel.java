package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HealthBarPanel extends JPanel {

    private static final Dimension preferredSize = new Dimension(406, 46);
    private static final Dimension heartDimensions = new Dimension(40,40);
    private static final Dimension fillerDimensions = new Dimension(14,40);
    private ImageIcon heartIcon;
    private ImageIcon brokenHeartIcon;

    public void createHealthBar(int health, int maxHealth){
        loadHeartIcon();
        loadBrokenHeartIcon();

        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setBorder(UIFormat.panelBorder);
        this.setBackground(UIFormat.SIDE_PANEL_BACKGROUND);
        this.add(new Box.Filler(fillerDimensions, fillerDimensions, fillerDimensions));

        for (int i = 0; i < maxHealth; i++){
            if(i < health){
                this.add(makeHeartLabel(heartIcon));

            } else {
                this.add(makeHeartLabel(brokenHeartIcon));
            }
        }
    }

    private void loadHeartIcon(){
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
}
