package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PetShopIconPanel extends JPanel{

    /* CLASS VARIABLES */

    private static final int NUMBER_OF_PETS = 6;
    private static final int PET_PANEL_COLUMNS = 4;
    private static final int PET_ICON_WIDTH = 150;
    private static final int PET_ICON_HEIGHT = 150;
    private ImageIcon selectedIcon = null;

    /* GETTERS */

    public ImageIcon getSelectedIcon() {
        return selectedIcon;
    }

    /* METHODS */

    /**
     * Creates a panel displaying all pet images located in the petIcons folder.
     * Precondition: folder must not be empty
     */
    public void makePetIconPanel() {
        File[] folder = new File("src/main/resources/petIcons").listFiles();
        int rows = (int) Math.ceil(NUMBER_OF_PETS / (double) PET_PANEL_COLUMNS);
        this.setLayout(new GridLayout(0, PET_PANEL_COLUMNS));
        this.setMaximumSize(new Dimension((PET_ICON_WIDTH * PET_PANEL_COLUMNS), (PET_ICON_HEIGHT * rows)));

        for (File file : folder) {
            if(!file.getName().equals(".DS_Store")) {
                this.add(makePetIconButton(makePetIcon(file)));
            }
        }

    }

    /**
     * Creates and returns an ImageIcon from the inputted file f
     * @param f the image file to be used
     * @return the ImageIcon created from f
     */
    private ImageIcon makePetIcon(File f) {
        try {
            Image petImage = ImageIO.read(f);
            ImageIcon i = new ImageIcon(petImage.getScaledInstance(PET_ICON_WIDTH, PET_ICON_HEIGHT, Image.SCALE_SMOOTH));
            i.setDescription(f.getName());
            return i;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates and returns a JButton from the imputed ImageIcon. Adds ActionListener to button which determines
     * user's pet selection
     * @param icon the image of the pet
     * @return a JButton displaying icon
     */
    private JButton makePetIconButton(ImageIcon icon){
        JButton button = new JButton(icon);
        button.setPreferredSize(new Dimension(PET_ICON_WIDTH, PET_ICON_HEIGHT));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(new Color(234, 234, 255));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetIconBorders();
                button.setBorder(BorderFactory.createLoweredSoftBevelBorder());
                selectedIcon = (ImageIcon) button.getIcon();
            }
        });

        return button;
    }

    /**
     * Sets all buttons in the panel to have an empty border.
     */
    private void resetIconBorders(){
        Component[] components = getComponents();
        for(Component c : components){
            if(c instanceof JButton){
                ((JButton) c).setBorder(BorderFactory.createEmptyBorder());
            }
        }
    }

}