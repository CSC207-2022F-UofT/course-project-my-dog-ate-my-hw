package ui;

import controllers.BuyHeartController;
import controllers.RouletteController;
import controllers.SeeDoneController;
import controllers.SeeToDoController;
import presenters.TaskVM;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Builds Buttons based on their type. Gives them the Action Listeners associated with their type.
 */
public class ButtonBuilder {

    // STATIC VARIABLES
    private static final Dimension STANDARD_BUTTONS_SIZE = new Dimension(80, 33);
    private static final Dimension COMPLETED_TOGGLE_SIZE = new Dimension(120, 33);

    // METHODS
    public Button buildHealButton(Color background, Color textColor, String label){
        Button b = new Button(background, textColor,createBevel(background), label, STANDARD_BUTTONS_SIZE, UIFormat.BUTTON_FONT);
        b.addActionListener(new BuyHeartController());
        return b;
    }

    public Button buildRouletteButton(Color background, Color textColor, String label){
        Button b = new Button(background, textColor, createBevel(background), label, STANDARD_BUTTONS_SIZE, UIFormat.BUTTON_FONT);
        b.addActionListener(new RouletteController());
        return b;
    }

    public Button buildNewTaskButton(Color background, Color textColor, String label){
        Button b = new Button(background, textColor, createBevel(background), label, STANDARD_BUTTONS_SIZE, UIFormat.BUTTON_FONT);
        b.addActionListener(e -> {
            TaskView v = new TaskView();
            v.createTaskView();

        });
        return b;
    }

    public Button buildAdoptButton(Color background, Color textColor, String label){
        Button b = new Button(background, textColor, createBevel(background), label, STANDARD_BUTTONS_SIZE, UIFormat.BUTTON_FONT);
        b.addActionListener(e -> {
            PetShopDisplayerInterface shopDisplayer = new PetShopDisplayer();
            shopDisplayer.createPetShop();
            b.getParent().remove(b);

        });
        return b;
    }

    public Button buildEditButton(Color background, Color textColor, String label, TaskVM task) {
        Button b = new Button(background, textColor, createBevel(background), label, STANDARD_BUTTONS_SIZE, UIFormat.BUTTON_FONT);
        b.addActionListener(e -> {
            TaskView v = new TaskView();
            v.createTaskView(task);
        });
        return b;
    }

    public Button buildSeeDoneButton(Color background, Color textColor, String label) {
        Button b = new Button(background, textColor, createBevel(background), label, COMPLETED_TOGGLE_SIZE, UIFormat.BUTTON_FONT);
        b.addActionListener(new SeeDoneController());
        return b;
    }

    public Button buildSeeToDoButton(Color background, Color textColor, String label) {
        Button b = new Button(background, textColor, createBevel(background), label, STANDARD_BUTTONS_SIZE, UIFormat.BUTTON_FONT);
        b.addActionListener(new SeeToDoController());
        return b;
    }

    /**
     * Creates a BevelBorder using the button background as reference
     * @param background the color of the button's background
     * @return a BevelBorder with certain highlight and shadow colors based on background color
     */
    private Border createBevel(Color background){
        return BorderFactory.createBevelBorder(BevelBorder.RAISED, background.brighter(), background.darker());
    }
}
