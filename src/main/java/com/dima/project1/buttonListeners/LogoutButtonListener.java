package com.dima.project1.buttonListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Inheritor of the ButtonListener class, that will take action after 'Logout' button is pressed
 */
public class LogoutButtonListener extends ButtonListener {

    /**
     * This constructor calls the superclass constructor with the given parameters
     * @param cardLayout panels switcher
     * @param panel panel to help find MainPanel on it for redirection
     */
    public LogoutButtonListener(CardLayout cardLayout, JPanel panel) {
        super(cardLayout, panel);
    }

    /**
     * Method switches panel from current to MainPanel with cardLayout object
     * @param e object of ActionEvent class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        getCardLayout().show(getPanel(), "main");
    }
}
