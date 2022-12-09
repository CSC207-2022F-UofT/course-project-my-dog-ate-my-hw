package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class PointsPanel extends JPanel {

    private static final Dimension preferredSize = new Dimension(410, 46);
    private static final Dimension fillerDimensions = new Dimension(10, 10);
    private JLabel pointsNumber;
    private JLabel pointsTitle;

    public void createPointsPanel(int pointsNumber){
        format();
        String title = "Points: ";
        this.pointsNumber = new JLabel(Integer.toString(pointsNumber));
        this.pointsTitle = new JLabel(title);
        this.pointsTitle.setFont(UIFormat.POINTS_FONT);
        this.pointsNumber.setFont(UIFormat.POINTS_FONT);

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        add(new Box.Filler(fillerDimensions, fillerDimensions, fillerDimensions));
        add(this.pointsTitle);
        add(new Box.Filler(fillerDimensions, fillerDimensions, fillerDimensions));
        add(this.pointsNumber);
        add(Box.createHorizontalGlue());

    }

    private void format(){
        setBackground(UIFormat.LIGHT_GREEN);
        setBorder(new SoftBevelBorder(BevelBorder.RAISED, getBackground().brighter(), getBackground().darker()));
        setMinimumSize(preferredSize);
        setPreferredSize(preferredSize);
    }
}
