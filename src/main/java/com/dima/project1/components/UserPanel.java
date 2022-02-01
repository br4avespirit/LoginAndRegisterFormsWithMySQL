package com.dima.project1.components;

import com.dima.project1.buttonListeners.LogoutButtonListener;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends Panel{

    private JButton logOut;

    public UserPanel(CardLayout cardLayout, JPanel panel){
        super(cardLayout, panel);
    }

    private void addLabel(){
        JLabel label = new JLabel("Total visits: ");
        label.setBounds(50, 50, 200, 25);
        add(label);
    }

    private void addLogOutButton(){
        logOut = new JButton("Logout");
        logOut.setBounds(100, 100, 100, 25);
        logOut.addActionListener(new LogoutButtonListener(getCardLayout(), getPanel()));
        add(logOut);
    }

    @Override
    void initPanel() {
        addLabel();
        addLogOutButton();
    }
}
