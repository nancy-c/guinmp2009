package dk.aau.imi.med4.guinmp2009.guis.exercises02;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class CubicSliders extends JFrame implements ChangeListener {
	
	private JSlider rootSlider;
	private JSlider squareSlider;
	private JSlider cubicSlider;
	private JLabel rootHeaderLabel;
	private JLabel rootValueLabel;
	private JLabel squareHeaderLabel;
	private JLabel squareValueLabel;
	private JLabel cubicHeaderLabel;
	private JLabel cubicValueLabel;

	
	public CubicSliders() {
		
		//Set up the main window frame
		setTitle("Cubic Sliders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//Initialize the components
		rootSlider = new JSlider(SwingConstants.VERTICAL,0,100,0);
		squareSlider = new JSlider(SwingConstants.VERTICAL,0,10000,0);
		cubicSlider = new JSlider(SwingConstants.VERTICAL,0,1000000,0);
		rootHeaderLabel = new JLabel("x");
		squareHeaderLabel = new JLabel("x^2");
		cubicHeaderLabel = new JLabel("x^3");
		rootValueLabel = new JLabel(((Integer)(rootSlider.getValue())).toString());
		squareValueLabel = new JLabel(((Integer)(squareSlider.getValue())).toString());
		cubicValueLabel = new JLabel(((Integer)(cubicSlider.getValue())).toString());

		
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
					.addGroup(
							layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(cubicHeaderLabel)
							.addComponent(cubicValueLabel)
							.addComponent(cubicSlider))
		);
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addGroup(
							layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(rootHeaderLabel)
								.addComponent(squareHeaderLabel)
								.addComponent(cubicHeaderLabel))
					.addGroup(
							layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(rootValueLabel)
								.addComponent(squareValueLabel)
								.addComponent(cubicValueLabel))
					.addGroup(
							layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(rootSlider)
								.addComponent(squareSlider)
								.addComponent(cubicSlider))
							);
		
		//Register ChangeListeners on sliders
		rootSlider.addChangeListener(this);
		squareSlider.addChangeListener(this);
		cubicSlider.addChangeListener(this);

		pack();
		setVisible(true);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource().equals(rootSlider)) {
			int root = rootSlider.getValue();
			rootValueLabel.setText(((Integer)root).toString());
			int square = root * root;
			squareSlider.setValue(square);
			squareValueLabel.setText(((Integer)square).toString());
			int cube = root * root * root;
			cubicSlider.setValue(cube);
			cubicValueLabel.setText(((Integer)cube).toString());		
		}
		if (e.getSource().equals(squareSlider)) {
			int square = squareSlider.getValue();
			squareValueLabel.setText(((Integer)square).toString());
			int root = (int)Math.sqrt(square);
			rootSlider.setValue(root);
			rootValueLabel.setText(((Integer)root).toString());
			int cube = root * root * root;
			cubicSlider.setValue(cube);
			cubicValueLabel.setText(((Integer)cube).toString());		
		}
		if (e.getSource().equals(cubicSlider)) {
			int cube = cubicSlider.getValue();
			cubicValueLabel.setText(((Integer)cube).toString());
			int root = (int)Math.cbrt(cube);
			rootSlider.setValue(root);
			rootValueLabel.setText(((Integer)root).toString());
			int square = root * root;
			squareSlider.setValue(square);
			squareValueLabel.setText(((Integer)square).toString());
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CubicSliders();
			}
		});
	}



}
