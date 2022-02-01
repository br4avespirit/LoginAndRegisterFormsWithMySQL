package com.dima.project1;

import com.dima.project1.components.MainPanel;
import com.dima.project1.components.MainWindow;
import com.dima.project1.components.RegisterPanel;
import com.dima.project1.components.UserPanel;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        MainWindow window = new MainWindow(350, 200, "Project1");

        CardLayout cardLayout = new CardLayout();

        JPanel panel = new JPanel(cardLayout);
        MainPanel mainPanel = new MainPanel(cardLayout, panel);
        UserPanel userPanel = new UserPanel(cardLayout, panel);
        RegisterPanel registerPanel = new RegisterPanel(cardLayout, panel);
        panel.add(mainPanel, "main");
        panel.add(userPanel, "user");
        panel.add(registerPanel, "register");

        window.addPanel(panel);
        cardLayout.show(panel, "main");

        window.setVisible(true);
    }
}
