package controllers;

import useCases.SeeDoneInputBoundary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeeDoneController implements ActionListener {
    private static SeeDoneInputBoundary uc;

    public static void setUc(SeeDoneInputBoundary useCase){
        uc = useCase;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        uc.refreshTask();
    }
}
