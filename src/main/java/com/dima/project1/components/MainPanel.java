package com.dima.project1.components;

import com.dima.project1.buttonListeners.LoginButtonListener;
import com.dima.project1.buttonListeners.RegisterButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Inheritor of the Panel class, which displays the main menu of the program
 */
public class MainPanel extends Panel {

    /**
     * A text field that contains the login entered by the user
     */
    private JTextField textField;

    /**
     * A password field that contains the password entered by the user
     */
    private JPasswordField passwordField;

    /**
     * Text that indicates an error that the user has entered incorrect data in the form
     */
    private JLabel exceptionLabel;

    /**
     * Buttons for logging into an account or for registering a new user in the database
     */
    private JButton loginButton, registerButton;

    /**
     * This constructor calls the superclass constructor with the given parameters
     * @param cardLayout reference on CardLayout object to switch between panels
     * @param panel reference on JPanel object
     */
    public MainPanel(CardLayout cardLayout, JPanel panel){
        super(cardLayout, panel);
    }

    /**
     * Method that initializes JLabel objects and adds it to panel. Since on this panel two JLabel
     * objects differ only in the vertical coordinate and name, they were combined in this method
     * @param y vertical coordinate of an object of class JLabel
     * @param text the text that is inside the JPanel class object
     */
    private void addLabel(int y, String text){
        JLabel label = new JLabel(text);
        label.setBounds(10, y, 80, 25);
        add(label);
    }

    /**
     * Method that initializes JTextField objects that will contain user's login in it and adds it to panel
     */
    private void addTextField(){
        textField = new JTextField();
        textField.setBounds(100, 20, 120, 25);
        add(textField);
    }

    /**
     * Method that initializes JPasswordField objects that will contain user's password in it and adds it to panel
     */
    private void addPasswordField(){
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 120, 25);
        add(passwordField);
    }

    /**
     * Method that initializes JButton object for logging into user's account and adds it to panel
     */
    private void addLoginButton(){
        loginButton = new JButton("Login");
        loginButton.setBounds(10, 110, 80, 25);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new LoginButtonListener(textField, passwordField,
                exceptionLabel, getCardLayout(), getPanel()));
        add(loginButton);
    }

    /**
     * Method that initializes JButton object for registering a new account in database and adds it to panel
     */
    private void addRegisterButton(){
        registerButton = new JButton("Register");
        registerButton.setBounds(110, 110, 100, 25);
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(new RegisterButtonListener(getCardLayout(), getPanel(), exceptionLabel));
        add(registerButton);
    }

    /**
     * Method that initializes JLabel that will appear on the screen only when user's input will be incorrect
     */
    private void addExceptionLabel(){
        exceptionLabel = new JLabel("Incorrect login or password");
        exceptionLabel.setBounds(10, 80, 170, 25);
        exceptionLabel.setForeground(Color.RED);
        exceptionLabel.setVisible(false);
        add(exceptionLabel);
    }

    /**
     * Method that initializes whole panel by adding all components on it
     */
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
