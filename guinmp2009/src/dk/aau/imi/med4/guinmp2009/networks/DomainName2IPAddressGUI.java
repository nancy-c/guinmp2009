package dk.aau.imi.med4.guinmp2009.networks;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class DomainName2IPAddressGUI extends JFrame implements ActionListener {
	
	JLabel domainNameLabel;
	JTextField domainNameTextField;
	JLabel ipAddressLabel;
	JTextArea ipAddressTextArea;
	JScrollPane scrollPane;
	
	public DomainName2IPAddressGUI() {
		super("DomainName2IPAddress");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		GroupLayout layout = new GroupLayout(contentPane);
		contentPane.setLayout(layout);
		
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		
		domainNameLabel = new JLabel("Domain name: ");
		domainNameTextField = new JTextField(20);
		ipAddressLabel = new JLabel("IP Addresses:");
		ipAddressTextArea = new JTextArea(5,20);
		scrollPane = new JScrollPane(ipAddressTextArea); 
		ipAddressTextArea.setEditable(false);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(domainNameLabel)
								.addComponent(domainNameTextField))
						.addComponent(ipAddressLabel)
						.addComponent(scrollPane)));
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(domainNameLabel)
						.addComponent(domainNameTextField))
				.addComponent(ipAddressLabel)
				.addComponent(scrollPane));
		
		domainNameTextField.addActionListener(this);
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String domainName = domainNameTextField.getText();
		InetAddress[] ipAddresses;
		ipAddressTextArea.setText(null);
		try {
			ipAddresses = InetAddress.getAllByName(domainName);
			for(InetAddress inetAddress : ipAddresses) {
				ipAddressTextArea.append(inetAddress.getHostAddress()+"\n");
			}
		} catch (UnknownHostException e) {
			ipAddressTextArea.append("Unknown host\n");
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DomainName2IPAddressGUI();
			}
		});
	}
}
