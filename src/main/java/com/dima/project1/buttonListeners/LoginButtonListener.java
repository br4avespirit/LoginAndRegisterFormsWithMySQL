package com.dima.project1.buttonListeners;

import com.dima.project1.components.MainPanel;
import com.dima.project1.mysql.Connector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Inheritor of the ButtonListener class, that will take action after 'Login' button is pressed
 */
public class LoginButtonListener extends ButtonListener {

    /**
     * TextField class object that contains entered login
     */
    private final JTextField textField;

    /**
     * PasswordField class object that contains entered password
     */
    private final JPasswordField passwordField;

    /**
     * JLabel class object that indicates us if try to log into account was successful or not
     */
    private final JLabel exceptionLabel;

    /**
     * This constructor calls the superclass constructor with the given parameters and adds 3 new parameters
     * @param textField textField with user's login
     * @param passwordField password field with user's password
     * @param exceptionLabel label to be hidden
     * @param cardLayout panels switcher
     * @param panel panel to be cleared
     */
    public LoginButtonListener(JTextField textField, JPasswordField passwordField, JLabel exceptionLabel, CardLayout cardLayout, JPanel panel){
        super(cardLayout, panel);
        this.textField = textField;
        this.passwordField = passwordField;
        this.exceptionLabel = exceptionLabel;
    }

    /**
     * Method creates connection with MySQL database with JDBC and tries to log into user account with entered
     * login and password. If login and password are not in database, it blocks us to log into user account.
     * In other cases, user will be redirected to his page
     * @param e object of ActionEvent class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Connector connector = new Connector();
        try {
            connector.connect();
            connector.getPreparedStatementLogin().setString(1, textField.getText());
            connector.getPreparedStatementLogin().setString(2, new String(passwordField.getPassword()));
            ResultSet rs = connector.getPreparedStatementLogin().executeQuery();
            if (rs.next()) {
                exceptionLabel.setVisible(false);
                getCardLayout().show(getPanel(), "user");
            }
            else{
                exceptionLabel.setVisible(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            connector.disconnect();
        }

        clearMainPanel();
    }

    /**
     * Method that will find on 'panel' field MainPanel class object and call method to clean it
     */
    private void clearMainPanel(){
        for (Component component: getPanel().getComponents()){
            if (component instanceof MainPanel) {
                ((MainPanel) component).clean();
            }
        }
    }
}
