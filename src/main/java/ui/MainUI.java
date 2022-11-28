package ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class MainUI extends JFrame {

    User user;

    /**
     * Creates new form MainUI
     */
    public MainUI(User user) {
        this.user = user;
        initComponents();
    }

    private void initComponents() {

        initializeVars();
        formatFrame();
        setBackgrounds();
        setFonts();
        setTextColors();

        makePetDisplay();
        makePointsDisplay();
        makeTaskScrollDisplay();
        makeButtons();
        makeTitle();
        makeToolPanel();
        makeNamePanel();
        finalizeLayout();
        pack();
    }

    // EVENT HANDLERS
    private void customizationBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void editTasksToggleActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void completedTasksToggleActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void newTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void healButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void rouletteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        saveOnClose();
    }

    private void initializeVars() {
        mainPanel = new javax.swing.JPanel();
        taskPanel = new javax.swing.JPanel();
        taskScrollPane = new javax.swing.JScrollPane();
        taskContainer = new javax.swing.JPanel();
        newTaskButton = new javax.swing.JButton();
        completedTasksToggle = new javax.swing.JToggleButton();
        editTasksToggle = new javax.swing.JToggleButton();
        pointsPanel = new PointsPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        pointsLabel = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));

        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        petPanel = new PetDisplayPanel();
        petLabel = new javax.swing.JLabel();
        toolPanel = new javax.swing.JPanel();
        customizationBox = new javax.swing.JComboBox<>();
        healButton = new javax.swing.JButton();
        namePanel = new javax.swing.JPanel();
        petNameLabel = new javax.swing.JLabel();
        healthPanel = new HealthBarPanel();
        rouletteButton = new javax.swing.JButton();
    }

    // Formatting Methods
    private void formatFrame() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1288, 733));
        setMinimumSize(new java.awt.Dimension(1288, 733));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }
    private void setBackgrounds() {
        mainPanel.setBackground(UIFormat.MAIN_PANEL_BACKGROUND);
        taskPanel.setBackground(UIFormat.YEllOW);
        taskScrollPane.setBackground(UIFormat.TASK_SCROLL);
        taskContainer.setBackground(UIFormat.TASK_SCROLL);
        newTaskButton.setBackground(UIFormat.BUTTON_PINK);
        completedTasksToggle.setBackground(UIFormat.BUTTON_PINK);
        editTasksToggle.setBackground(UIFormat.YEllOW);
        pointsPanel.setBackground(UIFormat.LIGHT_GREEN);
        titlePanel.setBackground(UIFormat.MAIN_PANEL_BACKGROUND);
        petPanel.setBackground(UIFormat.BUTTON_PINK);
        toolPanel.setBackground(UIFormat.SIDE_PANEL_BACKGROUND);
        healButton.setBackground(UIFormat.HEAL_BUTTON);
        namePanel.setBackground(UIFormat.SIDE_PANEL_BACKGROUND);
        rouletteButton.setBackground(UIFormat.GREEN);
    }
    private void setFonts() {
        newTaskButton.setFont(UIFormat.BUTTON_FONT);
        completedTasksToggle.setFont(UIFormat.BUTTON_FONT);
        editTasksToggle.setFont(UIFormat.BUTTON_FONT);
        pointsLabel.setFont(UIFormat.POINTS_FONT);
        rouletteButton.setFont(UIFormat.BUTTON_FONT);
        petNameLabel.setFont(UIFormat.PET_NAME_FONT);
        pointsDisplayLabel.setFont(UIFormat.POINTS_FONT);
        titleLabel.setFont(UIFormat.TITLE_FONT);
        customizationBox.setFont(UIFormat.BUTTON_FONT);
        healButton.setFont(UIFormat.BUTTON_FONT);
    }
    private void setTextColors(){
        newTaskButton.setForeground(UIFormat.WHITE_TEXT);
        completedTasksToggle.setForeground(UIFormat.WHITE_TEXT);
        editTasksToggle.setForeground(UIFormat.WHITE_TEXT);
        healButton.setForeground(UIFormat.WHITE_TEXT);
        rouletteButton.setForeground(UIFormat.WHITE_TEXT);
        titleLabel.setForeground(UIFormat.GREEN_TEXT);
        petNameLabel.setForeground(UIFormat.GREEN_TEXT);
        customizationBox.setForeground(UIFormat.PINK_TEXT);
    }

    // Make Contents

    private void makePointsDisplay(){
        pointsPanel.createPointsPanel("Points: ", 0);
    }
    private void makeTaskScrollDisplay(){
        // Make the scroll pane
        taskScrollPane.setBorder(null);
        taskScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        taskScrollPane.setViewportView(taskContainer);
        taskScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.LIGHT_GRAY;
            }
        });

        // Make a container for tasks in scroll pane
        taskContainer.setMaximumSize(new java.awt.Dimension(754, 32767));
        taskContainer.setMinimumSize(new java.awt.Dimension(754, 100));
        taskContainer.setPreferredSize(new java.awt.Dimension(754, 741));

        // Set Layouts
        javax.swing.GroupLayout taskContainerLayout = new javax.swing.GroupLayout(taskContainer);
        taskContainer.setLayout(taskContainerLayout);
        taskContainerLayout.setHorizontalGroup(
                taskContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 754, Short.MAX_VALUE)
        );
        taskContainerLayout.setVerticalGroup(
                taskContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 687, Short.MAX_VALUE)
        );

        //Make the panel containing the scroll pane
        javax.swing.GroupLayout taskPanelLayout = new javax.swing.GroupLayout(taskPanel);
        taskPanel.setLayout(taskPanelLayout);
        taskPanelLayout.setHorizontalGroup(
                taskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(taskPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(taskScrollPane)
                                .addContainerGap())
        );
        taskPanelLayout.setVerticalGroup(
                taskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(taskPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(taskScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }
    private void makeButtons(){
        makeNewTaskButton();
        makeShowCompletedButton();
        makeEditButton();
        makeHealButton();
        makeRouletteButton();
    }
    private void makeNewTaskButton(){

        newTaskButton.setText("New Task");
        newTaskButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(252, 227, 222), new java.awt.Color(252, 227, 222), new java.awt.Color(231, 148, 146), new java.awt.Color(231, 148, 146)));
        newTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTaskButtonActionPerformed(evt);
            }
        });
    }
    private void makeShowCompletedButton(){
        completedTasksToggle.setText("See Completed Tasks");
        completedTasksToggle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(252, 227, 222), new java.awt.Color(252, 227, 222), new java.awt.Color(231, 148, 146), new java.awt.Color(231, 148, 146)));
        completedTasksToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completedTasksToggleActionPerformed(evt);
            }
        });
    }
    private void makeEditButton(){
        editTasksToggle.setText("Edit Tasks");
        editTasksToggle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(254, 230, 191), new java.awt.Color(254, 230, 191), new java.awt.Color(231, 168, 67), new java.awt.Color(231, 168, 67)));
        editTasksToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTasksToggleActionPerformed(evt);
            }
        });
    }
    private void makeHealButton(){
        healButton.setText("HEAL");
        healButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(252, 227, 222), new java.awt.Color(252, 227, 222), new java.awt.Color(231, 148, 146), new java.awt.Color(231, 148, 146)));
        healButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                healButtonActionPerformed(evt);
            }
        });
    }
    private void makeRouletteButton(){
        rouletteButton.setText("Roulette");
        rouletteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(184, 207, 201), new java.awt.Color(184, 207, 201), new java.awt.Color(113, 147, 133), new java.awt.Color(113, 147, 133)));
        rouletteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rouletteButtonActionPerformed(evt);
            }
        });
    }
    private void makeTitle(){
        titleLabel.setText("DOG ATE MY HOMEWORK");
        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleLabel)
        );
        titlePanelLayout.setVerticalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                                .addGap(0, 8, Short.MAX_VALUE)
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }
    private void makePetPanelLayout(){
        javax.swing.GroupLayout petPanelLayout = new javax.swing.GroupLayout(petPanel);
        petPanel.setLayout(petPanelLayout);
        petPanelLayout.setHorizontalGroup(
                petPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(petPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(petLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                                .addContainerGap())
        );
        petPanelLayout.setVerticalGroup(
                petPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(petPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(petLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }
    private void makeToolPanel(){
        toolPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(245, 202, 195), new java.awt.Color(245, 202, 195)));
        customizationBox.setModel(new javax.swing.DefaultComboBoxModel<>(loadCustomizations()));
        customizationBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customizationBoxActionPerformed(evt);
            }
        });
        makeToolPanelLayout();
    }
    private void makeToolPanelLayout(){
        javax.swing.GroupLayout toolPanelLayout = new javax.swing.GroupLayout(toolPanel);
        toolPanel.setLayout(toolPanelLayout);
        toolPanelLayout.setHorizontalGroup(
                toolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(healButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(customizationBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        toolPanelLayout.setVerticalGroup(
                toolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(toolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(customizationBox)
                                        .addComponent(healButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
    }
    private void makeNamePanel(){
        namePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(245, 202, 195), new java.awt.Color(245, 202, 195)));
        namePanel.setLayout(new java.awt.BorderLayout());
        petNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        petNameLabel.setText(loadPetName());
        namePanel.add(petNameLabel, java.awt.BorderLayout.CENTER);
    }
    private void finalizeLayout(){
        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(newTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(editTasksToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rouletteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                                                .addComponent(completedTasksToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(taskPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(15, 15, 15)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(petPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(namePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(healthPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(toolPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pointsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(25, 25, 25))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(newTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(editTasksToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(completedTasksToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(rouletteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(taskPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(petPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(namePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(healthPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(toolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pointsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
    }

    // USECASE BEHAVIOUR METHODS TODO
    private String loadUserPoints(){
        return "0";
    }
    private void saveOnClose() {}
    private String[] loadCustomizations(){
        return new String[]{"Customization", "Hat"};
    }
    private String loadPetName() {
        return "Name";
    }

    // INSTANCE VARIABLES
    private javax.swing.JToggleButton completedTasksToggle, editTasksToggle;
    private javax.swing.JComboBox<String> customizationBox;
    private javax.swing.Box.Filler filler1, filler2, filler3;
    private javax.swing.JButton healButton, newTaskButton, rouletteButton;
    private javax.swing.JPanel mainPanel, namePanel, taskContainer, taskPanel, titlePanel, toolPanel;
    private javax.swing.JLabel pointsLabel, pointsDisplayLabel, petLabel, petNameLabel, titleLabel;
    private javax.swing.JScrollPane taskScrollPane;
    private HealthBarPanel healthPanel;
    private PetDisplayPanel petPanel;
    private PointsPanel pointsPanel;

    //TESTING
    public static void start(User user){
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());

        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        entities.Pet p = new entities.Pet("a", null, null);
        p.ouch(2);
        MainUI ui = new MainUI(user);
        ui.setVisible(true);
    }
}