package com.dima.project1.components;

import com.dima.project1.buttonListeners.BackButtonListener;
import com.dima.project1.buttonListeners.ConfirmButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Inheritor of the Panel class, which contains the registration form in the program
 */
public class RegisterPanel extends Panel{

    /**
     * A text field that contains the login entered by the user
     */
    private JTextField textField;

    /**
     * A password field that contains the password entered by the user
     */
    private JPasswordField passwordField;

    /**
     * Buttons for logging into an account or for registering a new user in the database
     */
    private JButton backButton, confirmButton;

    /**
     * Text that indicates an error or success that the user has entered incorrect/correct data in the registration form
     */
    private JLabel exceptionLabel, congratulationLabel;

    /**
     * This constructor calls the superclass constructor with the given parameters
     * @param cardLayout reference on CardLayout object to switch between panels
     * @param panel reference on JPanel object
     */
    public RegisterPanel(CardLayout cardLayout, JPanel panel) {
        super(cardLayout, panel);
    }

    /**
     * Method that initializes JLabel object that will indicate if the registration was successful or not
     */
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

    /**
     * Method that initializes JLabel objects and adds it to panel. Since on this panel two JLabel
     * objects differ only in the vertical coordinate and name, they were combined in this method
     * @param y vertical coordinate of an object of class JLabel
     * @param text the text that is inside the JPanel class object
     */
    private void addLabel(int y, String text){
        JLabel label = new JLabel(text);
        label.setBounds(10, y, 100, 25);
        add(label);
    }

    /**
     * Method that initializes JTextField objects that will contain user's login in it and adds it to panel
     */
    private void addTextField(){
        textField = new JTextField();
        textField.setBounds(120, 20, 120, 25);
        add(textField);
    }

    /**
     * Method that initializes JPasswordField objects that will contain user's password in it and adds it to panel
     */
    private void addPasswordField(){
        passwordField = new JPasswordField();
        passwordField.setBounds(120, 50, 120, 25);
        add(passwordField);
    }

    /**
     * Method that initializes JButton object that will switch frame from RegistrationPanel to MainPanel
     */
    private void addBackButton(){
        backButton = new JButton("Back");
        backButton.setBounds(10, 110, 80, 25);
        backButton.setFocusPainted(false);
        backButton.addActionListener(new BackButtonListener(getCardLayout(), getPanel(), exceptionLabel, congratulationLabel));
        add(backButton);
    }

    /**
     * Method that initializes JButton object who have handler which will check if the data in the form could be registered
     */
    private void addConfirmButton(){
        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(100, 110, 80, 25);
        confirmButton.setFocusPainted(false);
        confirmButton.addActionListener(new ConfirmButtonListener(getCardLayout(), getPanel(), exceptionLabel, congratulationLabel, textField, passwordField));
        add(confirmButton);
    }

    /**
     * Method that initializes whole panel by adding all components on it
     */
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
