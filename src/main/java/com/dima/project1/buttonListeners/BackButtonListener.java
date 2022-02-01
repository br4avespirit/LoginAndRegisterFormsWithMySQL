package com.dima.project1.buttonListeners;

import com.dima.project1.components.RegisterPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Inheritor of the ButtonListener class, that will take action after 'Back' button is pressed
 */
public class BackButtonListener extends ButtonListener{

    /**
     * JLabel class objects that inside RegisterPanel which that need to become invisible after pressing 'Back'
     * button on the RegisterPanel
     */
    private final JLabel exceptionLabel, congratulationLabel;

    /**
     * This constructor calls the superclass constructor with the given parameters and adds 2 new parameters
     * @param cardLayout panels switcher
     * @param panel panel to be cleared
     * @param exceptionLabel label to be hidden
     * @param congratulationLabel label to be hidden
     */
    public BackButtonListener(CardLayout cardLayout, JPanel panel, JLabel exceptionLabel, JLabel congratulationLabel) {
        super(cardLayout, panel);
        this.exceptionLabel = exceptionLabel;
        this.congratulationLabel = congratulationLabel;
    }

    /**
     * Method switches panel from current to MainPanel with cardLayout object and calls method to clear RegisterPanel
     * @param e object of ActionEvent class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        getCardLayout().show(getPanel(), "main");
        clearRegisterPanel();
    }

    /**
     * Method that will set exceptionLabel's and congratulationLabel's visibility to false and
     * find on panel field RegisterPanel class object and call method to clean it
     */
    private void clearRegisterPanel(){
        exceptionLabel.setVisible(false);
        congratulationLabel.setVisible(false);
        for (Component component: getPanel().getComponents()){
            if (component instanceof RegisterPanel) {
                ((RegisterPanel) component).clean();
            }
        }
    }
}
