package com.dima.project1.buttonListeners;

import com.dima.project1.components.MainPanel;
import com.dima.project1.mysql.Connector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginButtonListener extends ButtonListener {

    private final JTextField textField;
    private final JPasswordField passwordField;
    private final JLabel exceptionLabel;

    public LoginButtonListener(JTextField textField, JPasswordField passwordField, JLabel exceptionLabel, CardLayout cardLayout, JPanel panel){
        super(cardLayout, panel);
        this.textField = textField;
        this.passwordField = passwordField;
        this.exceptionLabel = exceptionLabel;
    }

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

    private void clearMainPanel(){
        for (Component component: getPanel().getComponents()){
            if (component instanceof MainPanel) {
                ((MainPanel) component).clean();
            }
        }
    }
}
