package com.dima.project1.components;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;


public abstract class Panel extends JPanel {

    @Getter
    private final CardLayout cardLayout;
    @Getter
    private final JPanel panel;

    public Panel(CardLayout cardLayout, JPanel panel){
        this.cardLayout = cardLayout;
        this.panel = panel;
        setLayout(null);
        initPanel();
    }

    abstract void initPanel();

    public void clean(){
        for (Component component: this.getComponents()){
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            }
        }
    }
}