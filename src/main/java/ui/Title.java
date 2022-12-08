package ui;

import javax.swing.*;

public class Title extends JLabel{

    private static final String titleText = "DOG ATE MY HOMEWORK";
    public void createTitle() {
        setText(titleText);
        setFont(UIFormat.TITLE_FONT);
        setForeground(UIFormat.GREEN_TEXT);
    }
}
