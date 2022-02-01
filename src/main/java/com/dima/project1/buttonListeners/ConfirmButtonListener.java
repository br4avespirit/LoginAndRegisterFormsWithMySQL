package com.dima.project1.buttonListeners;

import com.dima.project1.components.RegisterPanel;
import com.dima.project1.mysql.Connector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfirmButtonListener extends ButtonListener{

    private final JTextField textField;
    private final JPasswordField passwordField;
    private final JLabel exceptionLabel;
    private final JLabel congratulationLabel;

    public ConfirmButtonListener(CardLayout cardLayout, JPanel panel, JLabel exceptionLabel, JLabel congratulationLabel,
                                 JTextField textField, JPasswordField passwordField) {
        super(cardLayout, panel);
        this.textField = textField;
        this.passwordField = passwordField;
        this.exceptionLabel = exceptionLabel;
        this.congratulationLabel = congratulationLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Connector connector = new Connector();
        try {
            connector.connect();

            connector.getPreparedStatementCheckUser().setString(1, textField.getText());
            ResultSet rs = connector.getPreparedStatementCheckUser().executeQuery();
            if (rs.next() || textField.getText().length() == 0){
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

    private void clearRegisterPanel(){
        for (Component component: getPanel().getComponents()){
            if (component instanceof RegisterPanel) {
                ((RegisterPanel) component).clean();
            }
        }
    }
}
