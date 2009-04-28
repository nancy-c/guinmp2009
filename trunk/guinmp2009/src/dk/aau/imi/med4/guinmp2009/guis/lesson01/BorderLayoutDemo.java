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
                //Following puts a button at the top of the window
                pane.add(new JButton("PAGE_START"), BorderLayout.PAGE_START);
                
                //Following puts a button in the centre of the window
                //Centre expands to fill all available space
                //By default, component added to CENTER region
                pane.add(new JButton("CENTER"), BorderLayout.CENTER);
//                pane.add(new JButton("ANOTHER_CENTER"));
                
                //Following puts a button in the middle on the left
                pane.add(new JButton("LINE_START"), BorderLayout.LINE_START);
//                JTextField textField = new JTextField("Hello");
//                pane.add(textField, BorderLayout.LINE_START);
//                pane.remove(textField);

                //Following puts a button in the middle on the right
                pane.add(new JButton("LINE_END"), BorderLayout.LINE_END);
                
                //Following puts a button at the bottom of the page
                pane.add(new JButton("PAGE_END"), BorderLayout.PAGE_END);
                
                //We can specify vertical and horizontal gaps between areas
                //in the content pane as follows
//                BorderLayout layout = (BorderLayout)(pane.getLayout());
//                layout.setHgap(10);
//                layout.setVgap(10);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
