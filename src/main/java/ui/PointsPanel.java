package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class PointsPanel extends JPanel {

    private static final Dimension preferredSize = new Dimension();
    private static final Dimension fillerDimensions = new Dimension(10, 10);
    private JLabel pointsNumber;
    private JLabel pointsTitle;

    public void setPointsNumber(int pointsNumber) {
        this.pointsNumber.setText(Integer.toString(pointsNumber));
    }

    public void createPointsPanel(int pointsNumber){
        String title = "Points: ";
        this.pointsNumber = new JLabel(Integer.toString(pointsNumber));
        this.pointsTitle = new JLabel(title);

        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(new Box.Filler(fillerDimensions, fillerDimensions, fillerDimensions));
        this.add(this.pointsTitle);
        this.add(new Box.Filler(fillerDimensions, fillerDimensions, fillerDimensions));
        this.add(this.pointsNumber);
        this.add(new Box.Filler(fillerDimensions, fillerDimensions, fillerDimensions));

        format();
    }

    private void format(){
        setBackground(UIFormat.LIGHT_GREEN);
        setBorder(new SoftBevelBorder(BevelBorder.RAISED, getBackground().brighter(), getBackground().brighter()));
        setMinimumSize(preferredSize);
        setPreferredSize(preferredSize);
    }
}
