package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class PetShopUI extends JFrame {

    /* INSTANCE VARIABLES */
    JPanel mainPanel;
    PetShopIconPanel petIconPanel;
    JPanel bottomPanel;
    JLabel petShopLabel;
    JLabel nameLabel;
    JFormattedTextField nameBox;
    JButton adoptButton;
    String petName;
    ImageIcon selectedPetIcon;
    PetShopUIController controller;

    /* CONSTRUCTORS */
    public PetShopUI(PetShopUIController controller) {
        this.controller = controller;
        createPetShopWindow();
    }

    /* METHODS */

    /**
     * Creates and formats a Pet Shop window with all necessary components. (super messy don't look)
     */
    private void createPetShopWindow() {
        mainPanel = new JPanel();
        petIconPanel = new PetShopIconPanel();
        bottomPanel = new JPanel();
        petShopLabel = new JLabel();
        nameLabel = new JLabel();
        adoptButton = new JButton();
        nameBox = new JFormattedTextField();

        // Setting up Frame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pet Shop");
        setResizable(false);
        setBackground(new Color(189, 226, 244));
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        // Setting Background Colors
        mainPanel.setBackground(new Color(209, 209, 249));
        petIconPanel.setBackground(new Color(234, 234, 255));
        bottomPanel.setBackground(new Color(209, 209, 249));

        // Formatting Name Label
        nameLabel.setBackground(new Color(173, 173, 246));
        nameLabel.setFont(new Font("Krungthep", Font.PLAIN, 12)); // NOI18N
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setText("Enter a name for your pet:");
        nameLabel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nameLabel.setOpaque(true);

        // Formatting Name Box
        nameBox.setBackground(new Color(245, 244, 252));
        nameBox.setFont(new Font("Krungthep", Font.PLAIN, 12)); // NOI18N

        // Formatting Adopt Button
        adoptButton.setBackground(new Color(153, 153, 255));
        adoptButton.setFont(new Font("Krungthep", Font.PLAIN, 14)); // NOI18N
        adoptButton.setForeground(Color.WHITE);
        adoptButton.setText("ADOPT");
        adoptButton.addActionListener(this::adoptButtonActionPerformed);

        // Formatting Pet Shop Label
        petShopLabel.setFont(new Font("Brooklyn Line", Font.BOLD, 36)); // NOI18N
        petShopLabel.setForeground(Color.WHITE);
        petShopLabel.setText("- pet shop -");

        // Setting up all panels

        petIconPanel.makePetIconPanel();

        GroupLayout bottomPanelLayout = new GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
                bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(bottomPanelLayout.createSequentialGroup()
                                .addGap(64)
                                .addComponent(nameLabel, 186, 186, 186)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nameBox, 180, 180, 180)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(adoptButton, 82, 82, 82)
                                .addContainerGap(75, Short.MAX_VALUE))
        );
        bottomPanelLayout.setVerticalGroup(
                bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(bottomPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel, 29, 29, 29)
                                        .addComponent(nameBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                                        .addComponent(adoptButton, 29, 29, 29))
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(petIconPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                                                        .addComponent(bottomPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(296, 296, 296)
                                                .addComponent(petShopLabel)))
                                .addContainerGap(43, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(petShopLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(petIconPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(bottomPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    /**
     * Upon the adopt button being clicked, calls the PetShopUIController to create a pet from the user's
     * selections in the PetShopUI and saves the pet as an instance variable.
     * Displays warning if user has not made selection.
     * @param evt button click
     */
    private void adoptButtonActionPerformed(ActionEvent evt) {
        petName = nameBox.getText();
        selectedPetIcon = petIconPanel.getSelectedIcon();

        if(petName.replaceAll("^[ \t]+|[ \t]+$", "").equals("") || selectedPetIcon == null) {
            warningPopup();
        } else {
            controller.performPetAdoption(selectedPetIcon, petName);
            dispose();
        }

    }

    /**
     * Creates a popup to warn the user the have not selected a pet or name.
     */
    private void warningPopup(){
        PopupFactory factory = new PopupFactory();
        Label label = new Label("Select a pet and enter a name");
        label.setForeground(Color.WHITE);
        Panel panel = new Panel();
        panel.setBackground(Color.RED);
        panel.add(label);
        Popup p = factory.getPopup(this, panel, nameBox.getX() + 10, this.getHeight());
        p.show();
    }

}