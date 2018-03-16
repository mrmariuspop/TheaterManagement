
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

		
public class AddCashierFrame extends JFrame implements ActionListener {

	 JLabel userLabel = new JLabel("User");
	 JTextField userText = new JTextField(20);
	 JLabel passwordLabel = new JLabel("Password");
	 JLabel passwordLabel2 = new JLabel("Confirm");
	 JPasswordField userText2 = new JPasswordField(20);
	 JPasswordField passwordText = new JPasswordField(20);
	 JButton addCashierBtn = new JButton("Add");
	 JLabel firstnameLbl = new JLabel("Firstname");
	 JLabel lastnameLbl = new JLabel("Lastname");
	 
	 JTextField firstnameTxt = new JTextField(20);
	 JTextField lastnameTxt = new JTextField(20);

	
	public AddCashierFrame()
	{
		JFrame frame = new JFrame("Register Window");
		frame.setSize(300, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);

		frame.setVisible(true);
		panel.setLayout(null);

		
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);
		panel.add(firstnameLbl);
		panel.add(lastnameLbl);
		panel.add(firstnameTxt);
		panel.add(lastnameTxt);
		
		userText2.setBounds(100, 70 ,160, 25);
		panel.add(userText2);
		
		firstnameTxt.setBounds(100, 100 ,160, 25);
		lastnameTxt.setBounds(100, 130 ,160, 25);
		
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		passwordLabel2.setBounds(10,70,80,25);
		panel.add(passwordLabel2);
		
		firstnameLbl.setBounds(10,100,80,25);
		lastnameLbl.setBounds(10,130,80,25);

		
		
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		
		
		addCashierBtn.setBounds(100, 180, 80, 25);
		panel.add(addCashierBtn);
		addCashierBtn.addActionListener(this);
		
	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addCashierBtn)
		{
			if (userText2.getText().equals(passwordText.getText())) 
			{
				try {
					DbConnection.insertCashier(userText.getText(), passwordText.getText(), firstnameTxt.getText(), lastnameTxt.getText());
					JOptionPane.showMessageDialog(null, "Cashier succesfuly added!", "Check", JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);

			}
			
							// pressed
		}

	}



}