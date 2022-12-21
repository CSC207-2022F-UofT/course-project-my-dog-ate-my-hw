package controllers;

import useCases.RouletteInputBoundary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RouletteController implements ActionListener {
    private static RouletteInputBoundary uc;

    public static void setUc(RouletteInputBoundary rouletteInputBoundary){
        uc = rouletteInputBoundary;
    }

    public void actionPerformed(ActionEvent evt){
        uc.roulette();
        uc.refreshTask();
    }
}
