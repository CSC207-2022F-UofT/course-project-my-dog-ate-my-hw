package controllers;

import useCases.BuyHeartInputBoundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyHeartController implements ActionListener {

    private static BuyHeartInputBoundary uc;

    public static void setUc(BuyHeartInputBoundary useCase){
        uc = useCase;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        uc.buyHeart();
        uc.refreshPet();
    }
}
