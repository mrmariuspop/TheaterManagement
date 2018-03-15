
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

		
public class RemoveCashierFrame extends JFrame implements ActionListener {

	 JLabel userLabel = new JLabel("Username");
	 JTextField userText = new JTextField(20);
	 JButton deleteCashierBtn = new JButton("Delete");

	
	public RemoveCashierFrame()
	{
		JFrame frame = new JFrame("Register Window");
		frame.setSize(300, 150);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);

		frame.setVisible(true);
		panel.setLayout(null);

		
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);
		
		
		
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		

		
		
		deleteCashierBtn.setBounds(100, 70, 80, 25);
		panel.add(deleteCashierBtn);
		deleteCashierBtn.addActionListener(this);
		
	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == deleteCashierBtn)
		{
			try {
				DbConnection.removeCashierbyUsername(userText.getText());
				JOptionPane.showMessageDialog(null, "Cashier succesfuly deleted!", "Check", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Username does not exist in the database!", "Error", JOptionPane.ERROR_MESSAGE);

			}
			
			
							// pressed
		}

	}



}