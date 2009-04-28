package dk.aau.imi.med4.guinmp2009.guis.lesson01;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ContentPanes {
	 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("ContentPanes");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JLabel label1 = new JLabel("Hello World");
                JLabel label2 = new JLabel("Goodbye World");
                JTextField textField = new JTextField();
                frame.getContentPane().add(label1);
                frame.getContentPane().add(label2);
                frame.getContentPane().add(textField);
                frame.getContentPane().remove(textField);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

}
