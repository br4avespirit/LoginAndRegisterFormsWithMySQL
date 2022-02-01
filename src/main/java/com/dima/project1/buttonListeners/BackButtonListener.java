package com.dima.project1.buttonListeners;

import com.dima.project1.components.RegisterPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BackButtonListener extends ButtonListener{

    private final JLabel exceptionLabel, congratulationLabel;

    public BackButtonListener(CardLayout cardLayout, JPanel panel, JLabel exceptionLable, JLabel congratulationLabel) {
        super(cardLayout, panel);
        this.exceptionLabel = exceptionLable;
        this.congratulationLabel = congratulationLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getCardLayout().show(getPanel(), "main");
        clearRegisterPanel();
    }

    private void clearRegisterPanel(){
        exceptionLabel.setVisible(false);
        congratulationLabel.setVisible(false);
        for (Component component: getPanel().getComponents()){
            if (component instanceof RegisterPanel) {
                ((RegisterPanel) component).clean();
            }
        }
    }
}
