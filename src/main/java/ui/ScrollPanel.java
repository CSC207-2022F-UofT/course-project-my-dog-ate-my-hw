package ui;

import presenters.TaskVM;

import javax.swing.*;
import java.awt.*;

/**
 * This object contains a JScrollPane which contains all TaskPanels.
 */
public class ScrollPanel extends JPanel {

    private static final int borderSpace = 6;
    private static final Dimension preferredSize = new Dimension(754, 630);
    private static final Dimension maxSize = new Dimension(760, 636);
    private TaskScrollPane scrollPane;
    public void createScrollPanel(TaskVM[] tasks){
        format();

        //TODO: Change tasks to task data object
        scrollPane = new TaskScrollPane();
        scrollPane.createTaskScrollPane(tasks);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(borderSpace, borderSpace, borderSpace, borderSpace);
        c.anchor = GridBagConstraints.CENTER;

        add(scrollPane);
    }

    private void format(){
        setBackground(UIFormat.YEllOW);
        setMinimumSize(preferredSize);
        setPreferredSize(preferredSize);
        setMaximumSize(maxSize);
    }
}
