package ui;

import javax.swing.*;
import java.awt.*;


public class PetShopWindow extends JFrame {

    JPanel mainPanel;
    JPanel petIconPanel;
    JPanel bottomPanel;
    JLabel petShopLabel;
    JLabel nameLabel;
    JFormattedTextField nameBox;
    JButton adoptButton;
    String petName;
    ImageIcon petIcon;


    public PetShopWindow() {
        createPetShopWindow();
    }


    /**
     * Creates a Pet Shop window with all necessary components.
     */
    private void createPetShopWindow() {
        mainPanel = new JPanel();
        petIconPanel = new JPanel();
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

        //TESTING
        PetIcon i = new PetIcon("https://i.pinimg.com/736x/eb/19/e7/eb19e7ac38d0f9bd83875cfa01e9de41.jpg");
        ImageIcon test1 = i.getPetIcon();
        JLabel test = new JLabel(test1, JLabel.CENTER);

        // Setting up pet icon panel
        GroupLayout jPanel1Layout = new GroupLayout(petIconPanel);
        petIconPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 572, Short.MAX_VALUE)
                        .addComponent(test, GroupLayout.Alignment.LEADING) //TEST
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 293, Short.MAX_VALUE)
                        .addComponent(test, GroupLayout.Alignment.LEADING) //TEST
        );

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
        GroupLayout jPanel3Layout = new GroupLayout(bottomPanel);
        bottomPanel.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(64)
                                .addComponent(nameLabel, 186, 186, 186)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nameBox, 180, 180, 180)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(adoptButton, 82, 82, 82)
                                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel, 29, 29, 29)
                                        .addComponent(nameBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                                        .addComponent(adoptButton, 29, 29, 29))
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        GroupLayout jPanel2Layout = new GroupLayout(mainPanel);
        mainPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(petIconPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                                                        .addComponent(bottomPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(296, 296, 296)
                                                .addComponent(petShopLabel)))
                                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
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
     * selections in the PetShopWindow.
     * @param evt button click
     */
    private void adoptButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //NEED TO ADD CODE TO SELECT PET IMAGES
        petName = nameBox.getText();
        if(petName.strip().equals("")) {
            PopupFactory factory = new PopupFactory();
            Label label = new Label("You must enter a name to proceed");
            label.setForeground(Color.WHITE);
            Panel panel = new Panel();
            panel.setBackground(Color.RED);
            panel.add(label);
            Popup p = factory.getPopup(this, panel, 280, 420);
            p.show();
        } else {
            //CALL UI CONTROLLER
            dispose();
        }

    }

}