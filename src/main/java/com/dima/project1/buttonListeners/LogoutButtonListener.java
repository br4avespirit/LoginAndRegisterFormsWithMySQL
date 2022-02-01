package com.dima.project1.buttonListeners;

import com.dima.project1.components.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LogoutButtonListener extends ButtonListener {

    public LogoutButtonListener(CardLayout cardLayout, JPanel panel) {
        super(cardLayout, panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getCardLayout().show(getPanel(), "main");
    }
}
