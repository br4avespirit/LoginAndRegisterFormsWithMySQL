package com.dima.project1.components;

import com.dima.project1.buttonListeners.BackButtonListener;
import com.dima.project1.buttonListeners.ConfirmButtonListener;

import javax.swing.*;
import java.awt.*;

public class RegisterPanel extends Panel{

    private JTextField textField;
    private JPasswordField passwordField;
    private JButton backButton, confirmButton;
    private JLabel exceptionLabel, congratulationLabel;

    public RegisterPanel(CardLayout cardLayout, JPanel panel) {
        super(cardLayout, panel);
    }

    private void addExceptionAndCongratulationLabels(){
        exceptionLabel = new JLabel("User with this nickname is already exists");
        congratulationLabel = new JLabel("Congratulations! You've registered new user");
        exceptionLabel.setBounds(10, 80, 200, 25);
        congratulationLabel.setBounds(10, 80, 350, 25);
        exceptionLabel.setForeground(Color.RED);
        congratulationLabel.setForeground(Color.GREEN);
        exceptionLabel.setVisible(false);
        congratulationLabel.setVisible(false);
        add(exceptionLabel);
        add(congratulationLabel);
    }

    private void addLabel(int y, String text){
        JLabel label = new JLabel(text);
        label.setBounds(10, y, 100, 25);
        add(label);
    }

    private void addTextField(){
        textField = new JTextField();
        textField.setBounds(120, 20, 120, 25);
        add(textField);
    }

    private void addPasswordField(){
        passwordField = new JPasswordField();
        passwordField.setBounds(120, 50, 120, 25);
        add(passwordField);
    }

    private void addBackButton(){
        backButton = new JButton("Back");
        backButton.setBounds(10, 110, 80, 25);
        backButton.setFocusPainted(false);
        backButton.addActionListener(new BackButtonListener(getCardLayout(), getPanel(), exceptionLabel, congratulationLabel));
        add(backButton);
    }

    private void addConfirmButton(){
        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(100, 110, 80, 25);
        confirmButton.setFocusPainted(false);
        confirmButton.addActionListener(new ConfirmButtonListener(getCardLayout(), getPanel(), exceptionLabel, congratulationLabel, textField, passwordField));
        add(confirmButton);
    }

    @Override
    void initPanel() {
        addLabel(20, "Create name:");
        addLabel(50, "Create password:");
        addExceptionAndCongratulationLabels();
        addTextField();
        addPasswordField();
        addBackButton();
        addConfirmButton();
    }
}
