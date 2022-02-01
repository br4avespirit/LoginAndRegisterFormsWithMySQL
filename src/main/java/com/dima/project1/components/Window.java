package com.dima.project1.components;

import javax.swing.*;

public abstract class Window extends JFrame{

    private final int width;
    private final int height;
    private final String title;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;

        initFrame();
        setVisible(true);
    }

    private void initFrame() {
        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void addPanel(JPanel panel){
        add(panel);
    }
}
