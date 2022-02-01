package com.dima.project1.components;

import javax.swing.*;

/**
 * This class is an abstraction of the JFrame class and is a kind of template for other frames that make up the application.
 */
public abstract class Window extends JFrame{

    /**
     * Width of frame (more than 0)
     */
    private final int width;

    /**
     * Height of frame (more than 0)
     */
    private final int height;

    /**
     * Title of frame
     */
    private final String title;

    /**
     * Constructor that initializes necessary fields of our frame and then initializes this frame inside
     * @param width frame width
     * @param height frame height
     * @param title frame title
     */
    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;

        initFrame();
        setVisible(true);
    }

    /**
     * Method to initialize frame
     */
    private void initFrame() {
        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * Method that requires each Window class to add the panel as a component
     * @param panel Panel object that will contain other components
     */
    public void addPanel(JPanel panel){
        add(panel);
    }
}
