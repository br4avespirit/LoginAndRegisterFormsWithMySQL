package com.dima.project1.components;

import com.dima.project1.buttonListeners.LogoutButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Inheritor of the Panel class, which displays the user menu
 */
public class UserPanel extends Panel{

    /**
     * Button for logging out from user account
     */
    private JButton logOut;

    /**
     * This constructor calls the superclass constructor with the given parameters
     * @param cardLayout reference on CardLayout object to switch between panels
     * @param panel reference on JPanel object
     */
    public UserPanel(CardLayout cardLayout, JPanel panel){
        super(cardLayout, panel);
    }

    /**
     * Method that initializes JLabel object that will help us understand how many visits we did to this user account
     * (not showing amount of visits, only string that's inside method body)
     */
    private void addLabel(){
        JLabel label = new JLabel("Total visits: ");
        label.setBounds(50, 50, 200, 25);
        add(label);
    }

    /**
     * Method that initializes JButton object that will log out user from his account
     */
    private void addLogOutButton(){
        logOut = new JButton("Logout");
        logOut.setBounds(100, 100, 100, 25);
        logOut.addActionListener(new LogoutButtonListener(getCardLayout(), getPanel()));
        add(logOut);
    }

    /**
     * Method that initializes whole panel by adding all components on it
     */
    @Override
    void initPanel() {
        addLabel();
        addLogOutButton();
    }
}
