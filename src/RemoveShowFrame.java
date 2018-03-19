
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

		
public class RemoveShowFrame extends JFrame implements ActionListener {

	 JLabel titleLbl = new JLabel("Title");
	 JTextField titleTxt = new JTextField(20);
	 JButton deleteShowBtn = new JButton("Delete");

	
	public RemoveShowFrame()
	{
		JFrame frame = new JFrame("Remove Show Window");
		frame.setSize(300, 150);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);

		frame.setVisible(true);
		panel.setLayout(null);

		
		titleLbl.setBounds(10, 10, 80, 25);
		panel.add(titleLbl);
		
		
		
		titleTxt.setBounds(100, 10, 160, 25);
		panel.add(titleTxt);

		

		
		
		deleteShowBtn.setBounds(100, 70, 80, 25);
		panel.add(deleteShowBtn);
		deleteShowBtn.addActionListener(this);
		
	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == deleteShowBtn)
		{
			try {
				DbConnection.removeShowByTitle(titleTxt.getText());
				JOptionPane.showMessageDialog(null, "Show succesfuly deleted!", "Check", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Title does not exist in the database!", "Error", JOptionPane.ERROR_MESSAGE);

			}
			
			
							// pressed
		}

	}



}