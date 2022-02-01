package com.dima.project1.buttonListeners;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ButtonListener implements ActionListener {

    @Getter
    private final CardLayout cardLayout;
    @Getter
    private final JPanel panel;

    public ButtonListener(CardLayout cardLayout, JPanel panel){
        this.cardLayout = cardLayout;
        this.panel = panel;
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);
}
