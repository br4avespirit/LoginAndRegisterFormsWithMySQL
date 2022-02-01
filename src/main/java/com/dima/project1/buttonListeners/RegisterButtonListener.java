package com.dima.project1.buttonListeners;

import com.dima.project1.components.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegisterButtonListener extends ButtonListener {

    public RegisterButtonListener(CardLayout cardLayout, JPanel panel) {
        super(cardLayout, panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clearMainPanel();
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
