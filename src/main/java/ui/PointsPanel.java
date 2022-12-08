package ui;

import javax.swing.*;
import java.awt.*;

public class PointsPanel extends JPanel {

    private static final Dimension preferredSize = new Dimension(410, 46);
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

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        add(new Box.Filler(fillerDimensions, fillerDimensions, fillerDimensions));
        add(this.pointsTitle);
        add(new Box.Filler(fillerDimensions, fillerDimensions, fillerDimensions));
        add(this.pointsNumber);

    }
}
