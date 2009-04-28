package dk.aau.imi.med4.guinmp2009.guis.lesson01;

import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GroupLayoutDemo {
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
            	
            	/*
            	 * Define the layout.
            	 * 
            	 * Establish root horizontal and vertical groups
            	 * using setHorizontalGroup and setVerticalGroup.
            	 * 
            	 * Each group has to be created for the layout
            	 * using createSequentialGroup() and 
            	 * createParallelGroup().
            	 * 
            	 * The group is added to the layout using addGroup().
            	 * 
            	 * A component is added to the layout using addComponent().
            	 * 
            	 * Specify the alignment for parallel groups using the
            	 * GroupLayout.Alignment enum which has values:
            	 * LEADING (left-aligned or top-aligned)
            	 * TRAILING (right-aligned or bottom-aligned)
            	 * CENTER (center in both dimensions)
            	 * BASELINE (baseline in vertical dimension only)
            	 * 
            	 * Note that the component does not have to be added
            	 * directly to the container. This is done automatically
            	 * using the addComponent() method.
            	 */
            	layout.setHorizontalGroup(
            			layout.createSequentialGroup()
            				.addComponent(c1)
            				.addComponent(c2)
            				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            						.addComponent(c3)
            						.addComponent(c4)));
            	
            	layout.setVerticalGroup(
            			layout.createSequentialGroup()
            				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            						.addComponent(c1)
            						.addComponent(c2)
            						.addComponent(c3))
            				.addComponent(c4));
            	
            	frame.pack();
            	frame.setVisible(true);
            }
        });
    }
}
