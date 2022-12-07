package ui;

import javax.swing.*;
import java.awt.*;

public class TaskPanel extends JFrame {

    public TaskPanel(){
        init();
    }

    private void init(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.LIGHT_GRAY);

        JLabel label = new JLabel("This is a label");



        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
        this.add(panel2, BorderLayout.LINE_START);
    }


    public static void main(String[] args) {
        TaskPanel a = new TaskPanel();
        a.setDefaultCloseOperation(EXIT_ON_CLOSE);
        a.setPreferredSize(new Dimension(1000, 500));
        a.setMinimumSize(new Dimension(1000, 500));
        a.setResizable(false);
        a.setVisible(true);


    }
}