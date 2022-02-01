package com.dima.project1.buttonListeners;

import com.dima.project1.components.RegisterPanel;
import com.dima.project1.mysql.Connector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Inheritor of the ButtonListener class, that will take action after 'Confirm' button is pressed
 */
public class ConfirmButtonListener extends ButtonListener{

    /**
     * TextField class object that contains entered login
     */
    private final JTextField textField;

    /**
     * PasswordField class object that contains entered password
     */
    private final JPasswordField passwordField;

    /**
     * JLabel class object that indicates us if it was error when we were entering data
     */
    private final JLabel exceptionLabel;

    /**
     * JLabel class object that indicates us that the data was entered correct
     */
    private final JLabel congratulationLabel;

    /**
     * This constructor calls the superclass constructor with the given parameters and adds 4 new parameters
     * @param cardLayout panels switcher
     * @param panel panel to be cleared
     * @param exceptionLabel label to be hidden
     * @param congratulationLabel label to be hidden
     * @param textField textField with user's login
     * @param passwordField password field with user's password
     */
    public ConfirmButtonListener(CardLayout cardLayout, JPanel panel, JLabel exceptionLabel, JLabel congratulationLabel,
                                 JTextField textField, JPasswordField passwordField) {
        super(cardLayout, panel);
        this.textField = textField;
        this.passwordField = passwordField;
        this.exceptionLabel = exceptionLabel;
        this.congratulationLabel = congratulationLabel;
    }

    /**
     * Method creates connection with MySQL database with JDBC and tries to register new user in database.
     * If login is already in database or password and login were entered incorrect it blocks us to register a new user.
     * In other cases, user will be added to a database
     * @param e object of ActionEvent class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Connector connector = new Connector();
        try {
            connector.connect();

            connector.getPreparedStatementCheckUser().setString(1, textField.getText());
            ResultSet rs = connector.getPreparedStatementCheckUser().executeQuery();
            if (rs.next() || textField.getText().length() == 0 || new String(passwordField.getPassword()).length() == 0){
                exceptionLabel.setVisible(true);
                congratulationLabel.setVisible(false);
            }
            else{
                connector.getPreparedStatementConfirm().setString(1, textField.getText());
                connector.getPreparedStatementConfirm().setString(2, new String(passwordField.getPassword()));
                connector.getPreparedStatementConfirm().executeUpdate();
                exceptionLabel.setVisible(false);
                congratulationLabel.setVisible(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            connector.disconnect();
        }

        clearRegisterPanel();
    }

    /**
     * Method that will find on 'panel' field RegisterPanel class object and call method to clean it
     */
    private void clearRegisterPanel(){
        for (Component component: getPanel().getComponents()){
            if (component instanceof RegisterPanel) {
                ((RegisterPanel) component).clean();
            }
        }
    }
}
