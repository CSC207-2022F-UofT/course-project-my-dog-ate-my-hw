package ui;

import javax.swing.*;

public class Title extends JPanel{

    private static final String titleText = "DOG ATE MY HOMEWORK";
    public void createTitle() {
        JLabel titleLabel = new JLabel(titleText);
        titleLabel.setFont(UIFormat.TITLE_FONT);
        titleLabel.setForeground(UIFormat.GREEN_TEXT);
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        add(titleLabel);
        add(Box.createHorizontalGlue());

        setBackground(UIFormat.MAIN_PANEL_BACKGROUND);
    }
}
