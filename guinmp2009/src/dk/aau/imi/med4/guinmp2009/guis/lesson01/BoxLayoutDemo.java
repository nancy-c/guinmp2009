package dk.aau.imi.med4.guinmp2009.guis.lesson01;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BoxLayoutDemo {
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("BoxLayoutDemo");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JPanel panel1 = new JPanel();
				JPanel panel2 = new JPanel();
				JPanel centerPanel = new JPanel();
				
				frame.getContentPane().add(centerPanel);
				centerPanel.add(panel1);
				centerPanel.add(panel2);
				
				panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
				panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
				
				panel1.add(new JButton("Button11"));
				panel1.add(new JButton("Button12"));
				panel1.add(new JButton("Button13"));

				panel2.add(new JButton("Button21"));
				panel2.add(new JButton("Button22"));
				panel2.add(new JButton("Button23"));
				
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

}
