package com.dima.project1.components;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

/**
 * This class is an abstraction of the JPanel class and is a kind of
 * template for other panels that make up the application.
 */
public abstract class Panel extends JPanel {

    /**
     * Object that will be passed to the JButton handler class object
     * to switch between panels of a JFrame class object
     */
    @Getter
    private final CardLayout cardLayout;

    /**
     * Reference to the JPanel class object to pass this link to the JButton
     * handler in the future to clear the text in this panel
     */
    @Getter
    private final JPanel panel;

    /**
     * This constructor initializes fields cardLayout and panel and sets up current panel
     * @param cardLayout reference on CardLayout object to switch between panels
     * @param panel reference on JPanel object
     */
    public Panel(CardLayout cardLayout, JPanel panel){
        this.cardLayout = cardLayout;
        this.panel = panel;
        setLayout(null);
        initPanel();
    }

    /**
     * Method that adds components to the current panel
     */
    abstract void initPanel();

    /**
     * A method that clears the panel from the text that is present
     * in the JTextField class and its descendants
     */
    public void clean(){
        for (Component component: this.getComponents()){
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            }
        }
    }
}