package dk.aau.imi.med4.guinmp2009.guis.lesson02;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class SquareSliders extends JFrame {
	
	private JSlider rootSlider;
	private JSlider squareSlider;
	private JLabel rootHeaderLabel;
	private JLabel rootValueLabel;
	private JLabel squareHeaderLabel;
	private JLabel squareValueLabel;

	
	public SquareSliders() {
		
		//Set up the main window frame
		setTitle("Squaring Sliders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//Initialize the components
		rootSlider = new JSlider(SwingConstants.VERTICAL,0,100,0);
		squareSlider = new JSlider(SwingConstants.VERTICAL,0,10000,0);
		rootHeaderLabel = new JLabel("x");
		squareHeaderLabel = new JLabel("x^2");
		rootValueLabel = new JLabel(((Integer)(rootSlider.getValue())).toString());
		squareValueLabel = new JLabel(((Integer)(squareSlider.getValue())).toString());

		
		//Set up the layout of the components
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					.addGroup(
							layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(rootHeaderLabel)
								.addComponent(rootValueLabel)
								.addComponent(rootSlider))
					.addGroup(
							layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(squareHeaderLabel)
							.addComponent(squareValueLabel)
							.addComponent(squareSlider))
		);
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addGroup(
							layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(rootHeaderLabel)
								.addComponent(squareHeaderLabel))
					.addGroup(
							layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(rootValueLabel)
								.addComponent(squareValueLabel))
					.addGroup(
							layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(rootSlider)
								.addComponent(squareSlider))
							);
		
		//Register ChangeListeners on sliders
		rootSlider.addChangeListener(new RootChangeListener());
		squareSlider.addChangeListener(new SquareChangeListener());
		
		pack();
		setVisible(true);

	}
	
	private class RootChangeListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			int root = rootSlider.getValue();
			rootValueLabel.setText(((Integer)root).toString());
			int square = root * root;
			if (square <= squareSlider.getMaximum()) {
				squareSlider.setValue(square);
				squareValueLabel.setText(((Integer)square).toString());
			}
		}
		
	}
	
	private class SquareChangeListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			int square = squareSlider.getValue();
			squareValueLabel.setText(((Integer)square).toString());
			int root = (int)Math.sqrt(square);
			rootSlider.setValue(root);
			rootValueLabel.setText(((Integer)root).toString());
		}
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SquareSliders();
			}
		});
	}



}
