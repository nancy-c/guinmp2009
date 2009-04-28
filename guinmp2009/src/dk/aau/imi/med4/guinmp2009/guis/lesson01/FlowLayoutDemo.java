package dk.aau.imi.med4.guinmp2009.guis.lesson01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class FlowLayoutDemo {
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("FlowLayoutDemo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//Get the content pane
				//The layout manager for contentPane is BorderLayout.
				Container contentPane = frame.getContentPane();
				
				//Create a JPanel to put into one of the areas of the
				//JFrame's BorderLayout.
				JPanel centerPanel = new JPanel();
				//JPanel's layout manager is FlowLayout by default.
				
//				FlowLayout layout = (FlowLayout)centerPanel.getLayout();
//				layout.setAlignment(FlowLayout.LEFT);
//				layout.setHgap(20);
//				layout.setVgap(20);
				
				contentPane.add(centerPanel); 
				//goes in the center region by default
				
				JPanel lineStartPanel = new JPanel();
				contentPane.add(lineStartPanel,BorderLayout.LINE_START);
				
				lineStartPanel.add(new JButton("LineStart1"));
				lineStartPanel.add(new JButton("LineStart2"));
				
				centerPanel.add(new JButton("Center1"));
				centerPanel.add(new JButton("Center2"));
								
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}
