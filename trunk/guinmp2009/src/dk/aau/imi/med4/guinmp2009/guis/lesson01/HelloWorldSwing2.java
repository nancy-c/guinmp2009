package dk.aau.imi.med4.guinmp2009.guis.lesson01;

import javax.swing.*;        

public class HelloWorldSwing2 {
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("HelloWorldSwing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setUndecorated(true);
                JLabel label = new JLabel("Hello World");
                frame.getContentPane().add(label);
                frame.pack();
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });
    }
}
