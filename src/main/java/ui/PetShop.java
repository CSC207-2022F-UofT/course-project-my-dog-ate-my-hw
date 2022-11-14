package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetShop {
    /* CLASS VARIABLES */

    JFrame window;
    ImageIcon[] pets;
    ImageIcon selectedPet;
    String petName;
    JButton adoptButton;
    JTextField nameField;
    JLabel label;
    JPanel panel;


    public PetShop() {
        // Set Up Window
        window = new JFrame("Pet Shop");
        window.setSize(800, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        // Create panel and objects for panel
        panel = new JPanel();

        label = new JLabel("Enter a name for your pet:");
        nameField = new JTextField(10);
        adoptButton = new JButton("Adopt");
        nameField.add(adoptButton);

        panel.add(label);
        panel.add(nameField);
        panel.add(adoptButton);

        window.getContentPane().add(BorderLayout.SOUTH, panel);

        Color c = new Color(241, 229, 226, 255);
        window.getContentPane().setBackground(c);
        panel.setBackground(c);
        window.setVisible(true);

        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petName = nameField.getText();
                // add image icon to sleected pet
                // send info somewhere
                System.out.println(petName);
                window.dispose();
            }
        };
        adoptButton.addActionListener(a);
    }



    /* */

    public static void main(String[] args) {
        PetShop shop = new PetShop();

    }
}