package com.dima.project1.buttonListeners;

import com.dima.project1.components.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegisterButtonListener extends ButtonListener {

    private final JLabel exceptionLabel;

    public RegisterButtonListener(CardLayout cardLayout, JPanel panel, JLabel exceptionLabel) {
        super(cardLayout, panel);
        this.exceptionLabel = exceptionLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clearMainPanel();
        exceptionLabel.setVisible(false);
        getCardLayout().show(getPanel(), "register");
    }

    private void clearMainPanel(){
        for (Component component: getPanel().getComponents()){
            if (component instanceof MainPanel) {
                ((MainPanel) component).clean();
            }
        }
    }
}
