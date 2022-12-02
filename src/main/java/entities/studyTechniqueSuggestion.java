package entities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class studyTechniqueSuggestion implements ActionListener {

    private static JLabel label;
    private static JTextField taskType;
    private static JButton button;
    private static JLabel notFound;





    @Override
    public void actionPerformed(ActionEvent e) {
        String type = taskType.getText();
        System.out.println(type);

        if (type.equals("exam")){

        } else{
            notFound.setText("Oops! Try another task type!");
        }
    }

    public class studytechniquesuggestion {
        public void main(String[] args){
            JFrame frame = new JFrame();
            frame.setSize(400,250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            JPanel panel = new JPanel();
            frame.add(panel);

            SpringLayout layout = new SpringLayout();
            panel.setLayout(layout);

            label = new JLabel("Input your task type here!");
            label.setBounds(10, 20, 80, 25);
            panel.add(label);

            taskType = new JTextField(15);
            taskType.setBounds(100, 20, 165,20 );
            panel.add(taskType);

            button = new JButton("Okay");
            button.setBounds(10, 80, 80, 25);
            button.addActionListener(new studyTechniqueSuggestion());
            panel.add(button);

            notFound = new JLabel("Oops! Try another task type!");
            notFound.setBounds(10, 110, 300, 25);
            panel.add(notFound);


        }
    }

}
