package dk.aau.imi.med4.guinmp2009.guis.lesson02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Convert extends JFrame implements ActionListener {
	
	private JTextField 	celsiusTextField = 	new JTextField();
	private JLabel 		celsiusLabel = 		new JLabel("celsius");
	private JButton 	button = 			new JButton("Convert");
	private JLabel 		fahrenheitLabel = 	new JLabel("fahrenheit");
	private JLabel 		fahrenheitValue = 	new JLabel("?");
	
	public Convert() {
		setTitle("Convert");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);

		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING)
								.addComponent(celsiusTextField)
								.addComponent(fahrenheitValue)
								.addComponent(button)).addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING)
								.addComponent(celsiusLabel)
								.addComponent(fahrenheitLabel)));

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE)
								.addComponent(celsiusTextField)
								.addComponent(celsiusLabel)).addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE)
								.addComponent(fahrenheitValue)
								.addComponent(fahrenheitLabel))
				.addComponent(button));

		// linkSize method causes all argument fields to be at least the
		// preferred size of the component with the largest preferred
		// size
//		layout.linkSize(celsiusTextField, button, fahrenheitValue);

		//Register an ActionListener to listen for ActionEvents emitted by the button.
		button.addActionListener(this);
		celsiusTextField.addActionListener(this);
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		try {
			Double celsius = Double.parseDouble(celsiusTextField.getText());
			Double fahrenheit = 32 + celsius * 9 / 5;
			fahrenheitValue.setText(String.format("%.2f", fahrenheit));
		} catch (NumberFormatException e) {
			fahrenheitValue.setText("Unknown");
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Convert();
			}
		});
	}

}
