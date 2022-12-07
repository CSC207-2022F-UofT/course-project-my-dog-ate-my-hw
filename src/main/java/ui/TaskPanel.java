package ui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class TaskPanel extends JFrame {

    public TaskPanel() {
        init();
    }

    private void init() {
        //JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        //panel.setBackground(Color.LIGHT_GRAY);
        panel2.setBackground(Color.pink);


        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(100, 100));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
       // JLabel label = new JLabel("This is a label");
       // JLabel label2 = new JLabel("This is another label");

        this.setLayout(new BorderLayout());
        //this.add(panel, BorderLayout.CENTER);
        this.add(panel2, BorderLayout.CENTER);

        makeBoxPanels(10, panel2);

    }

    private void makeBoxPanels(int x, JPanel container) {
        for (int i = 0; i < x; i++) {
            JPanel panel = new JPanel();
            JCheckBox checkBox = new JCheckBox();
            checkBox.setHorizontalAlignment(JLabel.LEFT);
            panel.add(new JLabel("TaskName"));
            panel.add(new JLabel("TaskCourse"));
            panel.add(new JLabel("TaskType"));
            panel.add(new JLabel("TaskDeadline"));
            panel.add(new JLabel("TaskPriority"));
            panel.setBorder(new LineBorder(Color.BLACK));
            container.add(panel);
            container.add(checkBox);
        }
    }

    public static void main(String[] args) {
        TaskPanel a = new TaskPanel();
        a.setDefaultCloseOperation(EXIT_ON_CLOSE);
        a.setPreferredSize(new Dimension(100, 100));
        a.setVisible(true);
    }
}