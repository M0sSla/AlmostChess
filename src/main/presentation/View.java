package main.presentation;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {


    public View() {
        super("CHESS");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);


        setupUi();
        setupActions();
    }

    private void setupUi() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(10, 12));
        Color lightSquare = new Color(240, 217, 181);
        Color darkSquare = new Color(181, 136, 99);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                JPanel square = new JPanel();
                if ((i + j) % 2 == 0) {
                    square.setBackground(lightSquare);
                } else {
                    square.setBackground(darkSquare);
                }
                mainPanel.add(square);
            }
        }

        add(mainPanel);
    }

    private void setupActions() {

    }
}
