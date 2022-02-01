package com.dima.project1.buttonListeners;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This abstract class is an implementation of the ActionListener interface and is a kind of
 * template for other ButtonListeners in program
 */
public abstract class ButtonListener implements ActionListener {

    /**
     * Object that can switch frame panels
     */
    @Getter
    private final CardLayout cardLayout;

    /**
     * Panel that needs to be cleared after pressing this button
     */
    @Getter
    private final JPanel panel;

    /**
     * Constructor for ButtonListener with given parameters
     * @param cardLayout panels switcher
     * @param panel panel to be cleared
     */
    public ButtonListener(CardLayout cardLayout, JPanel panel){
        this.cardLayout = cardLayout;
        this.panel = panel;
    }

    /**
     * Method that takes action after any button is pressed
     * @param e object of ActionEvent class
     */
    @Override
    public abstract void actionPerformed(ActionEvent e);
}
