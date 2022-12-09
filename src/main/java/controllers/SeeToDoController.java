package controllers;

import useCases.SeeToDoInputBoundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeeToDoController implements ActionListener {
    private static SeeToDoInputBoundary uc;

    public static void setUc(SeeToDoInputBoundary useCase){
        uc = useCase;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        uc.refreshTask();
    }
}
