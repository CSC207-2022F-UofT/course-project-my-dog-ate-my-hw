package ui;

import entities.Pet;
import entities.User;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class MainUI extends JFrame {

    User u;

    /**
     * Creates new form MainUI
     */
    public MainUI(User u) {
        this.u = u;
        initComponents();
    }

    private void initComponents() {

        initializeVars();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(247, 237, 226));
        setMaximumSize(new java.awt.Dimension(1288, 733));
        setMinimumSize(new java.awt.Dimension(1288, 733));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainPanel.setBackground(new java.awt.Color(247, 237, 226));
        mainPanel.setPreferredSize(new java.awt.Dimension(26, 771));

        taskPanel.setBackground(new java.awt.Color(246, 189, 96));

        taskScrollPane.setBackground(new java.awt.Color(251, 223, 178));
        taskScrollPane.setBorder(null);
        taskScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        taskScrollPane.setToolTipText("");
        taskScrollPane.setViewportView(taskContainer);

        taskContainer.setBackground(new java.awt.Color(251, 223, 178));
        taskContainer.setMaximumSize(new java.awt.Dimension(754, 32767));
        taskContainer.setMinimumSize(new java.awt.Dimension(754, 100));
        taskContainer.setSize(new java.awt.Dimension(754, 741));

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

        taskScrollPane.setViewportView(taskContainer);
        taskScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.LIGHT_GRAY;
            }
        });

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

        newTaskButton.setBackground(new java.awt.Color(240, 177, 168));
        newTaskButton.setFont(UIFormat.buttonFont);
        newTaskButton.setForeground(new java.awt.Color(255, 255, 255));
        newTaskButton.setText("New Task");
        newTaskButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(252, 227, 222), new java.awt.Color(252, 227, 222), new java.awt.Color(231, 148, 146), new java.awt.Color(231, 148, 146)));
        newTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTaskButtonActionPerformed(evt);
            }
        });

        completedTasksToggle.setBackground(new java.awt.Color(240, 177, 168));
        completedTasksToggle.setFont(UIFormat.buttonFont);
        completedTasksToggle.setForeground(new java.awt.Color(255, 255, 255));
        completedTasksToggle.setText("See Completed Tasks");
        completedTasksToggle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(252, 227, 222), new java.awt.Color(252, 227, 222), new java.awt.Color(231, 148, 146), new java.awt.Color(231, 148, 146)));
        completedTasksToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completedTasksToggleActionPerformed(evt);
            }
        });

        editTasksToggle.setBackground(new java.awt.Color(246, 189, 96));
        editTasksToggle.setFont(UIFormat.buttonFont); // NOI18N
        editTasksToggle.setForeground(new java.awt.Color(255, 255, 255));
        editTasksToggle.setText("Edit Tasks");
        editTasksToggle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(254, 230, 191), new java.awt.Color(254, 230, 191), new java.awt.Color(231, 168, 67), new java.awt.Color(231, 168, 67)));
        editTasksToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTasksToggleActionPerformed(evt);
            }
        });

        pointsPanel.setBackground(new java.awt.Color(167, 187, 182));
        pointsPanel.setLayout(new javax.swing.BoxLayout(pointsPanel, javax.swing.BoxLayout.LINE_AXIS));
        pointsPanel.add(filler1);

        pointsLabel.setFont(UIFormat.pointsFont); // NOI18N
        pointsLabel.setForeground(new java.awt.Color(255, 255, 255));
        pointsLabel.setText("Points:");
        pointsPanel.add(pointsLabel);
        pointsPanel.add(filler2);

        pointsDisplayLabel.setFont(UIFormat.pointsFont); // NOI18N
        pointsDisplayLabel.setForeground(new java.awt.Color(255, 255, 255));
        pointsDisplayLabel.setText("0");
        pointsPanel.add(pointsDisplayLabel);
        pointsPanel.add(filler3);

        titlePanel.setBackground(new java.awt.Color(247, 237, 226));

        titleLabel.setFont(UIFormat.titleFont); // NOI18N
        titleLabel.setForeground(new java.awt.Color(97, 152, 142));
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

        petPanel.setBackground(new java.awt.Color(245, 202, 195));

        javax.swing.GroupLayout petPanelLayout = new javax.swing.GroupLayout(petPanel);
        petPanel.setLayout(petPanelLayout);
        petPanelLayout.setHorizontalGroup(
                petPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(petPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(petLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        petPanelLayout.setVerticalGroup(
                petPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(petPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(petLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                                .addContainerGap())
        );

        toolPanel.setBackground(new java.awt.Color(247, 238, 233));
        toolPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(245, 202, 195), new java.awt.Color(245, 202, 195)));

        customizationBox.setFont(UIFormat.buttonFont); // NOI18N
        customizationBox.setForeground(new java.awt.Color(242, 132, 130));
        customizationBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customization", "Hat" }));
        customizationBox.setMixingCutoutShape(null);
        customizationBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customizationBoxActionPerformed(evt);
            }
        });

        healButton.setBackground(new java.awt.Color(242, 132, 130));
        healButton.setFont(UIFormat.buttonFont); // NOI18N
        healButton.setForeground(new java.awt.Color(255, 255, 255));
        healButton.setText("HEAL");
        healButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(252, 227, 222), new java.awt.Color(252, 227, 222), new java.awt.Color(231, 148, 146), new java.awt.Color(231, 148, 146)));
        healButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                healButtonActionPerformed(evt);
            }
        });

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

        namePanel.setBackground(new java.awt.Color(247, 238, 233));
        namePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(245, 202, 195), new java.awt.Color(245, 202, 195)));
        namePanel.setLayout(new java.awt.BorderLayout());

        petNameLabel.setFont(UIFormat.petNameFont); // NOI18N
        petNameLabel.setForeground(new java.awt.Color(97, 152, 142));
        petNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        petNameLabel.setText("NAME");
        namePanel.add(petNameLabel, java.awt.BorderLayout.CENTER);

        MainPetDisplay petDisplay= new MainPetDisplay(u);
        petDisplay.createHealthBar();
        healthPanel = petDisplay.getHealthBar();

        rouletteButton.setBackground(new java.awt.Color(132, 165, 157));
        rouletteButton.setFont(UIFormat.buttonFont);
        rouletteButton.setForeground(new java.awt.Color(255, 255, 255));
        rouletteButton.setText("Roulette");
        rouletteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(184, 207, 201), new java.awt.Color(184, 207, 201), new java.awt.Color(113, 147, 133), new java.awt.Color(113, 147, 133)));
        rouletteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rouletteButtonActionPerformed(evt);
            }
        });

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

        pack();
    }

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
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        entities.Pet p = new Pet("a", null, null);
        p.ouch(2);
        User i = new User(0, p);
        MainUI ui = new MainUI(i);
        ui.setVisible(true);
    }


    private void initializeVars(){
        mainPanel = new javax.swing.JPanel();
        taskPanel = new javax.swing.JPanel();
        taskScrollPane = new javax.swing.JScrollPane();
        taskContainer = new javax.swing.JPanel();
        newTaskButton = new javax.swing.JButton();
        completedTasksToggle = new javax.swing.JToggleButton();
        editTasksToggle = new javax.swing.JToggleButton();
        pointsPanel = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        pointsLabel = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        pointsDisplayLabel = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        petPanel = new javax.swing.JPanel();
        petLabel = new javax.swing.JLabel();
        toolPanel = new javax.swing.JPanel();
        customizationBox = new javax.swing.JComboBox<>();
        healButton = new javax.swing.JButton();
        namePanel = new javax.swing.JPanel();
        petNameLabel = new javax.swing.JLabel();
        healthPanel = new javax.swing.JPanel();
        rouletteButton = new javax.swing.JButton();
    }



    // Variables declaration - do not modify
    private javax.swing.JToggleButton completedTasksToggle, editTasksToggle;
    private javax.swing.JComboBox<String> customizationBox;
    private javax.swing.Box.Filler filler1, filler2, filler3;
    private javax.swing.JButton healButton, newTaskButton, rouletteButton;
    private javax.swing.JPanel healthPanel, mainPanel, namePanel, petPanel, pointsPanel, taskContainer, taskPanel, titlePanel, toolPanel;
    private javax.swing.JLabel pointsLabel, pointsDisplayLabel, petLabel, petNameLabel, titleLabel;
    private javax.swing.JScrollPane taskScrollPane;

    // End of variables declaration
}
