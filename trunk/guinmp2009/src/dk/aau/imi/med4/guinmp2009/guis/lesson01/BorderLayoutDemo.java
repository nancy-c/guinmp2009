package dk.aau.imi.med4.guinmp2009.guis.lesson01;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;

public class BorderLayoutDemo {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("BorderLayoutDemo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Container pane = frame.getContentPane();
                pane.add(new JButton("PAGE_START"), BorderLayout.PAGE_START);
                pane.add(new JButton("CENTER"), BorderLayout.CENTER);
                pane.add(new JButton("LINE_START"), BorderLayout.LINE_START);
                pane.add(new JButton("PAGE_END"), BorderLayout.PAGE_END);
                pane.add(new JButton("LINE_END"), BorderLayout.LINE_END);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
