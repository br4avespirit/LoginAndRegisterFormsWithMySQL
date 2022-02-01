package com.dima.project1.buttonListeners;

import com.dima.project1.components.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Inheritor of the ButtonListener class, that will take action after 'Register' button is pressed
 */
public class RegisterButtonListener extends ButtonListener {

    /**
     * JLabel class object that inside MainPanel that should become invisible after pressing 'Register' button on the MainPanel
     */
    private final JLabel exceptionLabel;

    /**
     * This constructor calls the superclass constructor with the given parameters and adds 1 new parameter
     * @param cardLayout panels switcher
     * @param panel panel to be cleared
     * @param exceptionLabel label to be hidden
     */
    public RegisterButtonListener(CardLayout cardLayout, JPanel panel, JLabel exceptionLabel) {
        super(cardLayout, panel);
        this.exceptionLabel = exceptionLabel;
    }

    /**
     * Method calls clearMainPanel function that will clear MainPanel, sets exceptionLabel visibility to false and
     * switches panel from current to RegisterPanel with cardLayout object
     * @param e object of ActionEvent class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        clearMainPanel();
        exceptionLabel.setVisible(false);
        getCardLayout().show(getPanel(), "register");
    }

    /**
     * Method that will find on 'panel' field MainPanel class object and call method to clean it
     */
    private void clearMainPanel(){
        for (Component component: getPanel().getComponents()){
            if (component instanceof MainPanel) {
                ((MainPanel) component).clean();
            }
        }
    }
}
