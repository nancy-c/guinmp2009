package dk.aau.imi.med4.guinmp2009.guis.exercises01;

import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GroupLayoutEx04 {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	JFrame frame = new JFrame("GroupLayout");
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	Container contentPane = frame.getContentPane();
            	
            	/*
            	 * Create a GroupLayout object and associate it with
            	 * the content pane 
            	 */
            	GroupLayout layout = new GroupLayout(contentPane);
            	/*
            	 * Attach the layout to the contentPane
            	 */
            	contentPane.setLayout(layout);
            	
            	/*
            	 * Use automatic gaps
            	 */
            	layout.setAutoCreateGaps(true);
            	layout.setAutoCreateContainerGaps(true);
            	
            	/*
            	 * Create some button objects to put in the layout
            	 */
            	JButton c1 = new JButton("c1");
            	JButton c2 = new JButton("c2");
            	JButton c3 = new JButton("c3");
            	JButton c4 = new JButton("c4");
            	JButton c5 = new JButton("c5");
            	JButton c6 = new JButton("c6");
            	JButton c7 = new JButton("c7");
            	JButton c8 = new JButton("c8");
            	JButton c9 = new JButton("c9");
            	
            	layout.setHorizontalGroup(
            			layout.createSequentialGroup()
            				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            						.addComponent(c1)
            						.addComponent(c8))
            				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            						.addComponent(c3)
            						.addComponent(c6))
            				.addComponent(c5)
            				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            						.addComponent(c4)
            						.addComponent(c7))
              				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             						.addComponent(c2)
               						.addComponent(c9))
            	);
            	
            	layout.setVerticalGroup(
            			layout.createSequentialGroup()
            				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            						.addComponent(c1)
            						.addComponent(c2))
            				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            						.addComponent(c3)
            						.addComponent(c4))
            				.addComponent(c5)
            						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            						.addComponent(c6)
            						.addComponent(c7))
            				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            						.addComponent(c8)
            						.addComponent(c9))
            	);
            	
            	frame.pack();
            	frame.setVisible(true);
            }
        });
    }

}
