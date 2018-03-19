
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

		
public class UpdateShowFrame extends JFrame implements ActionListener {

	 JLabel titleLbl = new JLabel("Title");
	 JLabel newDateLbl = new JLabel("New Date");
	 
	 JTextField titleTxt = new JTextField(20);
	 JTextField newDateTxt = new JTextField(20);

	 JButton updateNewDateBtn = new JButton("Update");

	
	public UpdateShowFrame()
	{
		JFrame frame = new JFrame("Update Show Date Window");
		frame.setSize(300, 150);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);

		frame.setVisible(true);
		panel.setLayout(null);

		
		titleLbl.setBounds(10, 10, 80, 25);
		panel.add(titleLbl);
		
		newDateLbl.setBounds(10, 40, 80, 25);
		panel.add(newDateLbl);
		
		
		
		titleTxt.setBounds(100, 10, 160, 25);
		panel.add(titleTxt);
		panel.add(newDateTxt);
		newDateTxt.setBounds(100, 40, 160, 25);
		

		
		
		updateNewDateBtn.setBounds(100, 70, 80, 25);
		panel.add(updateNewDateBtn);
		updateNewDateBtn.addActionListener(this);
		
	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateNewDateBtn)
		{
//			System.out.println("username   = " + userText.getText() + "\n");
//			System.out.println("lastname   = " + userText1.getText() + "\n");

			try {
				DbConnection.updateShowDate(titleTxt.getText(), newDateTxt.getText());
				JOptionPane.showMessageDialog(null, "Show`s date succesfully updated!", "Error", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
							// pressed
		}

	}



}