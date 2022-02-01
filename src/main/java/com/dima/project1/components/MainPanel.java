package com.dima.project1.components;

import com.dima.project1.buttonListeners.LoginButtonListener;
import com.dima.project1.buttonListeners.RegisterButtonListener;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends Panel {

    private JTextField textField;
    private JPasswordField passwordField;
    private JLabel exceptionLabel;
    private JButton loginButton, registerButton;

    public MainPanel(CardLayout cardLayout, JPanel panel){
        super(cardLayout, panel);
    }

    private void addLabel(int y, String text){
        JLabel label = new JLabel(text);
        label.setBounds(10, y, 80, 25);
        add(label);
    }

    private void addTextField(){
        textField = new JTextField();
        textField.setBounds(100, 20, 120, 25);
        add(textField);
    }

    private void addPasswordField(){
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 120, 25);
        add(passwordField);
    }

    private void addLoginButton(){
        loginButton = new JButton("Login");
        loginButton.setBounds(10, 110, 80, 25);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new LoginButtonListener(textField, passwordField,
                exceptionLabel, getCardLayout(), getPanel()));
        add(loginButton);
    }

    private void addRegisterButton(){
        registerButton = new JButton("Register");
        registerButton.setBounds(110, 110, 100, 25);
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(new RegisterButtonListener(getCardLayout(), getPanel()));
        add(registerButton);
    }

    private void addExceptionLabel(){
        exceptionLabel = new JLabel("Incorrect login or password");
        exceptionLabel.setBounds(10, 80, 170, 25);
        exceptionLabel.setForeground(Color.RED);
        exceptionLabel.setVisible(false);
        add(exceptionLabel);
    }

    @Override
    public void initPanel(){
        addLabel(20, "Login:");
        addLabel(50, "Password");
        addExceptionLabel();
        addTextField();
        addPasswordField();
        addLoginButton();
        addRegisterButton();
    }
}
